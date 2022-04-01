package br.com.senior.employee.consumer.controller.integration.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
import br.com.senior.employee.consumer.client.esocial4integration.DeficiencyEntity;
import br.com.senior.employee.consumer.client.esocial4integration.EmployeeEntity;
import br.com.senior.employee.consumer.client.esocial4integration.Integration;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.employee.consumer.client.esocial4integration.ProviderStatusType;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategy;
import br.com.senior.employee.consumer.repository.DeficiencyRepository;
import br.com.senior.employee.consumer.repository.EmployeeRepository;
import br.com.senior.employee.consumer.repository.IntegrationRepository;
import br.com.senior.employee.consumer.rest.Rest;
import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
     * Método responsável por processar a pendência de integração.
     *
     * @param accessKey Chave de acesso da aplicação.
     * @param integration Entidade da integração.
     */
    public void integrationPendency(String accessKey, Integration integration) {
        LOGGER.info("Processando a pendência de integração ID: " + integration.id);

        String providerEmployeeIdentification = null;

        KeyCredential keyCredential = rest.getCredentialFromAccessKey(accessKey, integration.providerCompanyIdentification);
        if (keyCredential == null) {
            LOGGER.error("Não foi encontrada uma credencial para a chave de acesso: " + accessKey + ". A pendência ID: " + integration.id + " não será consumida.");
            return;
        }

        keyCredential = KeyCredential.getKeyCredentialFromAccessKey(accessKey, integration.providerCompanyIdentification);
        try {
            IntegrationEntity entity = DtoJsonConverter.toDTO(DtoJsonConverter.toJSON(integration), IntegrationEntity.class);

            // Salva os dados do colaborador
            entity = savePendency(entity);

            //Processa a pendencia de integração
            providerEmployeeIdentification = integrationStrategy.processPendency(entity);

            enviarRespostaSucesso(integration, keyCredential, providerEmployeeIdentification);
        } catch (HttpClientErrorException e) {
            if(e.getRawStatusCode() == HttpStatus.UNAUTHORIZED.value()){
                LOGGER.info("Pendência ID: " + integration.id + " renovando autorizaçao.");
                rest.removeFromCache(keyCredential);
                try{
                    enviarRespostaSucesso(integration, keyCredential, providerEmployeeIdentification);
                } catch (Exception e1) {
                    logarErroNaIntegraçao(accessKey, integration, e, providerEmployeeIdentification);
                }

            }else{
                logarErroNaIntegraçao(accessKey, integration, e, providerEmployeeIdentification);
            }
        } catch (Exception e) {
            logarErroNaIntegraçao(accessKey, integration, e, providerEmployeeIdentification);
            processarException(integration, keyCredential, e, providerEmployeeIdentification);
        }
    }

    private void enviarRespostaSucesso(Integration integration, KeyCredential keyCredential, String providerEmployeeIdentification) {
        /**
         * Neste ponto o código comunica para a SENIOR que recebeu o evento e que os dados estão salvos na base do prestador SST.
         * Desta forma o sistema da Senior saberá que o dado está no provedor SST.
         */
        IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.ON_PROVIDER, providerEmployeeIdentification);
        rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
        LOGGER.info("A pendência ID: " + integration.id + " foi consumida.");
    }

    private void logarErroNaIntegraçao(String accessKey, Integration integration, Exception e, String providerEmployeeIdentification) {
        KeyCredential credentialFromAccessKey = rest.getCredentialFromAccessKey(accessKey, integration.providerCompanyIdentification);
        LOGGER.error("Erro na integração da pendência ID: " + integration.id + "\n" + //
                "Tenant: " + credentialFromAccessKey.tenantName + //
                " Chave de Acesso: " + credentialFromAccessKey.accessKey + //
                " Segredo da Chave: " + credentialFromAccessKey.secret + //
                " Identificação Única do colaborador no prestador: " + providerEmployeeIdentification, e);
    }

    private void processarException(Integration integration, KeyCredential keyCredential, Exception e, String providerEmployeeIdentification) {
        try{
            enviarErroParaSenior(integration, keyCredential, e, providerEmployeeIdentification);

        } catch (HttpClientErrorException e1) {
            if(e1.getRawStatusCode() == HttpStatus.UNAUTHORIZED.value()){
                LOGGER.info("Pendência ID: " + integration.id + " renovando autorizaçao.");
                rest.removeFromCache(keyCredential);
            }
            enviarErroParaSenior(integration, keyCredential, e, providerEmployeeIdentification);
        }
    }

    private void enviarErroParaSenior(Integration integration, KeyCredential keyCredential, Exception e, String providerEmployeeIdentification) {
        IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.INTEGRATION_ERROR, e.getMessage(), providerEmployeeIdentification);
        rest.getWithKey(keyCredential).postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
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
