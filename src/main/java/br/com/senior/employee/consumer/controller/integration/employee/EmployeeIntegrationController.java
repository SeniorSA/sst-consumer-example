package br.com.senior.employee.consumer.controller.integration.employee;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
import br.com.senior.employee.consumer.client.esocial4integration.DeficiencyEntity;
import br.com.senior.employee.consumer.client.esocial4integration.EmployeeEntity;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.client.esocial4integration.Integration;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.employee.consumer.client.esocial4integration.ProviderStatusType;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategy;
import br.com.senior.employee.consumer.repository.DeficiencyRepository;
import br.com.senior.employee.consumer.repository.EmployeeRepository;
import br.com.senior.employee.consumer.repository.IntegrationRepository;
import br.com.senior.employee.consumer.rest.Rest;
import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Log4j
@Component
public class EmployeeIntegrationController {

    @Autowired
    private Rest rest;
    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private IntegrationRepository integrationRepository;
    @Autowired
    private EmployeeIntegrationStrategy integrationStrategy;
    @Autowired
    private CompanyCredentialsStrategy companyCredentialsStrategy;
    @Autowired
    private DeficiencyRepository deficiencyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Este método é executado ao iniciar este sistema para verificar se existem pendências não consumidas.
     */
    public void consumePendencies() {
        LOGGER.info("Consumindo pendências antigas.");
        companyCredentialsStrategy.getCredentials().forEach(c -> {
            Integration.PagedResults list = null;
            do {
                Optional<ResponseEntity<Integration.PagedResults>> results = getKeyData(c);
                if (results.isPresent()) {
                    list = getKeyData(c).get().getBody();
                    list.contents.forEach(integration -> integrationPendency(c.accessKey, integration));
                }
            } while (containsPendencies(list));
        });
    }

    /**
     * Esse método é responsável por consumir as pendências de integração de um determinado usuário.
     * @param accessKey Chave de acesso da aplicação.
     */
    public void consumePendenciesByTenant(String accessKey) {
        LOGGER.info("Consumindo pendências do tenant: " + accessKey);
        KeyCredential keyCredential = KeyCredential.getKeyCredentialFromAccessKey(accessKey);
        Integration.PagedResults list = null;
        do {
            Optional<ResponseEntity<Integration.PagedResults>> results = getKeyData(keyCredential);
            if (results.isPresent()) {
                list = getKeyData(keyCredential).get().getBody();
                list.contents.forEach(integration -> integrationPendency(keyCredential.accessKey, integration));
            }
        } while (containsPendencies(list));
    }

    /**
     * Busca as pendências não consumidas no sistema SENIOR.
     *
     * @return {@Link ResponseEntity<Integration.PagedResults>}
     */
    private Optional<ResponseEntity<Integration.PagedResults>> getKeyData(KeyCredential credential) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"pagination\": null}", headers);
        String url = applicationProperties.getG7Location() + "/hcm/esocial4integration/queries/retrieveSentIntegrationsQuery";
        try {
            return Optional.of(rest.getWithKey(credential).exchange(url,
                    HttpMethod.POST,
                    request,
                    Integration.PagedResults.class));
        } catch (HttpServerErrorException e) {
            LOGGER.error("Não foi possível obter os dados de " + credential.tenantName, e);
        } catch (HttpClientErrorException e) {
            LOGGER.info("Credencial inválida para o usuário: " + credential.tenantName);
        } catch (ResourceAccessException e) {
            LOGGER.info("URL da plataforma SeniorX inválida. Verifique o arquivo configurações da plataforma Senior.");
        }
        return Optional.empty();
    }

    /**
     * Método responsável por verificar se existem pendências de integração.
     *
     * @param response
     * @return @{@link boolean}
     */
    private boolean containsPendencies(Integration.PagedResults response) {
        return response != null && response.totalElements > 0;
    }

    /**
     * Método responsável por processar a pendência de integração.
     *
     * @param accessKey Chave de acesso da aplicação.
     * @param integration Entidade da integração.
     */
    public void integrationPendency(String accessKey, Integration integration) {
        LOGGER.info("Processando a pendência de integração ID: " + integration.id);

        if (rest.getCredentialFromAccessKey(accessKey) == null) {
            LOGGER.error("Não foi encontrada uma credencial para a chave de acesso: " + accessKey + ". A pendência ID: " + integration.id + " não será consumida.");
            return;
        }

        KeyCredential keyCredential = KeyCredential.getKeyCredentialFromAccessKey(accessKey);
        try {
            IntegrationEntity entity = DtoJsonConverter.toDTO(DtoJsonConverter.toJSON(integration), IntegrationEntity.class);

            // Salva os dados do colaborador
            entity = savePendency(entity);

            //Processa a pendencia de integração
            integrationStrategy.processPendency(entity);
            /**
             * Neste ponto o código comunica para a SENIOR que recebeu o evento e que os dados estão salvos na base do prestador SST.
             * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
             */
            IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.ON_PROVIDER);
            rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
            LOGGER.info("A pendência ID: " + integration.id + " foi consumida.");
        } catch (Exception e) {
            LOGGER.error("Erro na integração da pendência ID: " + integration.id, e);
            IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.INTEGRATION_ERROR, e.getMessage());
            rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
        }
    }

    /**
     * Método responsável por consistir os dados vindos com a pendencia de integração pela primeira vez
     *
     * @param entity entidade de pendencia de integração
     * @return entidade de pendencia de integração persistida
     */
    private IntegrationEntity savePendency(IntegrationEntity entity) {
        List<DeficiencyEntity> deficiencies = entity.getEmployee().getDeficiencies();
        entity.getEmployee().setDeficiencies(null);

        EmployeeEntity employee = employeeRepository.save(entity.getEmployee());
        entity.setEmployee(employee);

        if (deficiencies != null) {
            deficiencies.forEach(deficiencyEntity -> deficiencyEntity.setEmployee(employee));
            deficiencyRepository.saveAll(deficiencies);
        }

        return integrationRepository.save(entity);
    }
}
