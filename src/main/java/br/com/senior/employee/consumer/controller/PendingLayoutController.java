package br.com.senior.employee.consumer.controller;

import br.com.senior.employee.consumer.configuration.SystemProperties;
import br.com.senior.employee.consumer.handler.LayoutEventController;
import br.com.senior.employee.consumer.pojos.esocial.LayoutSituation;
import br.com.senior.employee.consumer.pojos.esocial.LayoutSituationEventPayload;
import br.com.senior.employee.consumer.pojos.esocial.LayoutSituationEventType;
import br.com.senior.employee.consumer.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PendingLayoutController {

    @Autowired
    private Rest rest;
    @Autowired
    private LayoutEventController layoutEventController;

    /*
      Este método é executado ao iniciar este sistema para verificar se existe algum registro de layout pendente de processamento.
   */
    public void execute() {
        /*
            Busca os layouts com o status "Número do recibo recebido, Número do recibo informado manualmente e Erro retornado" no sistema SENIOR.
         */
        LayoutSituation.PagedResults list;
        do {
            ResponseEntity<LayoutSituation.PagedResults> response = getData();
            list = response.getBody();
            list.contents.forEach(f -> layoutEventController.layoutEvent(new LayoutSituationEventPayload(f.layoutId, f.receiptNumber, f.layoutMessage, LayoutSituationEventType.RECEIVED)));
        } while (containsPendencies(list));
    }

    private ResponseEntity<LayoutSituation.PagedResults> getData() {
        String filter = "statusType in ('RECEIPT_RETURNED', 'RECEIPT_MANUAL', 'ERROR_RETURNED')";
        return rest.get().exchange(SystemProperties.getG7Location() + "/hcm/esocial/entities/layoutSituation?filter=" + filter,
                HttpMethod.GET,
                null,
                LayoutSituation.PagedResults.class);
    }

    private boolean containsPendencies(LayoutSituation.PagedResults response) {
        return response.totalElements > 0;
    }
}
