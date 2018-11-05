package br.com.senior.employee.consumer.controller.integration;

import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.client.esocial4integration.Integration;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.employee.consumer.client.esocial4integration.ProviderStatusType;
import br.com.senior.employee.consumer.repository.IntegrationRepository;
import br.com.senior.employee.consumer.rest.Rest;
import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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

    /**
     * Este método é executado ao iniciar este sistema para verificar se existem pendências não consumidas.
     */
    public void consumeOldPendencies() {
        LOGGER.info("Consumindo pendências antigas.");
        Integration.PagedResults list;
        do {
            list = getData().getBody();
            list.contents.forEach(this::integrationPendency);
        } while (containsPendencies(list));
    }

    /**
     * Busca as pendências não consumidas no sistema SENIOR.
     *
     * @return {@Link ResponseEntity<Integration.PagedResults>}
     */
    private ResponseEntity<Integration.PagedResults> getData() {
        String filter = "statusType eq SENT_TO_PROVIDER";
        return rest.get().exchange(applicationProperties.getG7Location() + "/hcm/esocial4integration/entities/integration?filter=" + filter,
                HttpMethod.GET,
                null,
                Integration.PagedResults.class);
    }

    /**
     * Método responsável por verificar se existem pendências de integração.
     *
     * @param response
     * @return @{@link boolean}
     */
    private boolean containsPendencies(Integration.PagedResults response) {
        return response.totalElements > 0;
    }

    /**
     * Método responsável por processar a pendência de integração.
     *
     * @param integration Entidade da integração.
     */
    public void integrationPendency(Integration integration) {
        LOGGER.info("Processando a pendência de integração ID: " + integration.id);
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
            rest.get().postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
            LOGGER.info("A pendência ID: " + integration.id + " foi consumida.");
        } catch (Exception e) {
            IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.PROVIDER_ERROR);
            rest.get().postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
            LOGGER.error("Erro na integração da pendência ID: " + integration.id, e);
        }
    }
}
