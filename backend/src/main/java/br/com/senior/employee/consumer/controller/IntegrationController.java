package br.com.senior.employee.consumer.controller;

import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.entity.IntegrationEntity;
import br.com.senior.employee.consumer.handler.IntegrationEventHandler;
import br.com.senior.employee.consumer.pojos.esocial4integration.Integration;
import br.com.senior.employee.consumer.pojos.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.employee.consumer.pojos.esocial4integration.ProviderStatusType;
import br.com.senior.employee.consumer.repository.IntegrationRepository;
import br.com.senior.employee.consumer.rest.Rest;
import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class IntegrationController {

    @Autowired
    private Rest rest;
    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    private IntegrationRepository integrationRepository;

    /**
     * Este método é executado ao iniciar este sistema para verificar se existem pendências não consumidas.
     */
    public void consumeOldPendencies() {
        LOGGER.info("Consuming old pendencies.");
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

    private boolean containsPendencies(Integration.PagedResults response) {
        return response.totalElements > 0;
    }

    public void integrationPendency(Integration integration) {
        LOGGER.info("Processing integration with ID " + integration.id);
        IntegrationEntity entity = DtoJsonConverter.toDTO(DtoJsonConverter.toJSON(integration), IntegrationEntity.class);
        // Salva os dados do colaborador
        integrationRepository.save(entity);
        /*
            Neste ponto o código comunica para a SENIOR que recebeu o evento e que os dados estão salvos na base do prestador SST.
            Desta forma o sistema da Senior saberá que o dado está no provedor SST.
         */
        IntegrationUpdateStatusInput input = new IntegrationUpdateStatusInput(integration.id, ProviderStatusType.ON_PROVIDER);
        rest.get().postForLocation(applicationProperties.getG7Location() + "/hcm/esocial4integration/signals/integrationUpdateStatus", input);
        LOGGER.info("Integration with ID " + integration.id + " was consumed.");
    }
}
