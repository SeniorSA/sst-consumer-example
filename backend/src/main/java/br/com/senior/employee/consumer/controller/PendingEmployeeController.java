package br.com.senior.employee.consumer.controller;

import br.com.senior.employee.consumer.configuration.SystemProperties;
import br.com.senior.employee.consumer.handler.EmployeeEventController;
import br.com.senior.employee.consumer.pojos.esocial4integration.EmployeeEventPayload;
import br.com.senior.employee.consumer.pojos.esocial4integration.Integration;
import br.com.senior.employee.consumer.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PendingEmployeeController {

    @Autowired
    private Rest rest;
    @Autowired
    private EmployeeEventController employeeEventController;

    /*
        Este método é executado ao iniciar este sistema para verificar se existe algum registro de colaborador pendente de processamento.
     */
    public void execute() {
        /*
            Busca os colaboradores com o status "Pronto para integração" no sistema SENIOR.
         */
        Integration.PagedResults list;
        do {
            ResponseEntity<Integration.PagedResults> response = getData();
            list = response.getBody();
            list.contents.forEach(f -> employeeEventController.employeeEvent(new EmployeeEventPayload(f.employee, f.integrationType, f.id)));
        } while (containsPendencies(list));
    }

    private ResponseEntity<Integration.PagedResults> getData() {
        String filter = "statusType eq SENT_TO_PROVIDER";
        return rest.get().exchange(SystemProperties.getG7Location() + "/hcm/esocial4integration/entities/integration?filter=" + filter,
                HttpMethod.GET,
                null,
                Integration.PagedResults.class);
    }

    private boolean containsPendencies(Integration.PagedResults response) {
        return response.totalElements > 0;
    }
}
