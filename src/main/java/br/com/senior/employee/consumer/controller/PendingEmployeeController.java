package br.com.senior.employee.consumer.controller;

import br.com.senior.employee.consumer.configuration.SystemProperties;
import br.com.senior.employee.consumer.handler.EmployeeEventController;
import br.com.senior.employee.consumer.pojos.EmployeeEventPayload;
import br.com.senior.employee.consumer.pojos.Integration;
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
        String filter = "statusType eq SENT_TO_PROVIDER";
        ResponseEntity<Integration.PagedResults> response = rest.get().exchange(SystemProperties.getG7Location() + "/hcm/esocial4integration/entities/integration?filter=" + filter,
                HttpMethod.GET,
                null,
                Integration.PagedResults.class);

        Integration.PagedResults list = response.getBody();
        list.contents.forEach(f -> employeeEventController.employeeEvent(new EmployeeEventPayload(f.employee, f.integrationType, f.id)));
    }
}
