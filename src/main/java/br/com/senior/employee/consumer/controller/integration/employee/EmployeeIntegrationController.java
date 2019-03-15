package br.com.senior.employee.consumer.controller.integration.employee;

import br.com.senior.employee.consumer.client.authentication.Credential;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.client.esocial4integration.Integration;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.employee.consumer.client.esocial4integration.ProviderStatusType;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategy;
import br.com.senior.employee.consumer.repository.IntegrationRepository;
import br.com.senior.employee.consumer.rest.Rest;
import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

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

    /**
     * Este método é executado ao iniciar este sistema para verificar se existem pendências não consumidas.
     */
    public void consumePendencies() {
        LOGGER.info("Consumindo pendências antigas.");
        companyCredentialsStrategy.getCredentials().forEach(c -> {
            Integration.PagedResults list = null;
            do {
                Optional<ResponseEntity<Integration.PagedResults>> results = getData(c);
                if (results.isPresent()) {
                    list = getData(c).get().getBody();
                    list.contents.forEach(integration -> integrationPendency(c.username, integration));
                }
            } while (containsPendencies(list));
        });
    }

    /**
     * Esse método é responsável por consumir as pendências de integração de um determinado usuário.
     * @param user
     */
    public void consumePendenciesByTenant(String user) {
        LOGGER.info("Consumindo pendências do usuário: " + user);
        Credential credential = Credential.fromUser(user);
        Integration.PagedResults list = null;
        do {
            Optional<ResponseEntity<Integration.PagedResults>> results = getData(credential);
            if (results.isPresent()) {
                list = getData(credential).get().getBody();
                list.contents.forEach(integration -> integrationPendency(credential.username, integration));
            }
        } while (containsPendencies(list));
    }

    /**
     * Busca as pendências não consumidas no sistema SENIOR.
     *
     * @return {@Link ResponseEntity<Integration.PagedResults>}
     */
    private Optional<ResponseEntity<Integration.PagedResults>> getData(Credential credential) {
        String filter = "statusType eq SENT_TO_PROVIDER";
        try {
            return Optional.of(rest.get(credential).exchange(applicationProperties.getG7Location() + "/hcm/esocial4integration/entities/integration?filter=" + filter,
                    HttpMethod.GET,
                    null,
                    Integration.PagedResults.class));
        } catch (HttpServerErrorException e) {
            LOGGER.error("Não foi possível obter os dados de " + credential.username, e);
        } catch (HttpClientErrorException e) {
            LOGGER.info("Credencial inválida para o usuário: " + credential.username);
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
     * @param user\
     * @param integration Entidade da integração.
     */
    public void integrationPendency(String user, Integration integration) {
        LOGGER.info("Processando a pendência de integração ID: " + integration.id);
        Credential credential = Credential.fromUser(user);
        try {
            IntegrationEntity entity = DtoJsonConverter.toDTO(DtoJsonConverter.toJSON(integration), IntegrationEntity.class);

            // Salva os dados do colaborador
            integrationRepository.save(entity);

            //Processa a pendencia de integração
            integrationStrategy.processPendency(entity);
            /**
             * Neste ponto o código comunica para a SENIOR que recebeu o evento e que os dados estão salvos na base do prestador SST.
             * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
             */
            IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.ON_PROVIDER);
            rest.get(credential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
            LOGGER.info("A pendência ID: " + integration.id + " foi consumida.");
        } catch (Exception e) {
            LOGGER.error("Erro na integração da pendência ID: " + integration.id, e);
            IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.INTEGRATION_ERROR, e.getMessage());
            rest.get(credential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
        }
    }
}
