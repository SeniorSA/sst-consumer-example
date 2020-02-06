package br.com.senior.employee.consumer.handler;

import java.io.Console;

import br.com.senior.employee.consumer.controller.integration.employee.EmployeeIntegrationController;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationPendencyEventPayload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/integration")
public class IntegrationEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationEventHandler.class);

    @Autowired
    private EmployeeIntegrationController employeeIntegrationController;

    /**
     * Endpoint que recebe um POST.
     * Uma REGRA deve ser cadastrada no EVENTO integrationPendency.
     * Este endpoint será invocado quando uma ação de admissão, alteração de admissão e movimentações (Centro de custo, Local, Cargo, Posto de trabalho e Afastamentos) do colaborador ocorrer.
     *
     * @param payload Dados do colaborador.
     */
    @PostMapping(path = "/pendency")
    public void integrationPendency(@RequestHeader(name = "x-senior-key") String accessKey, @RequestBody IntegrationPendencyEventPayload payload) {
        /*
            O payload virá com todos os dados do colaborador independente do tipo de integração (integrationType).
            Enviamos o integrationType para o provedor SST decidir alterar apenas o que foi alterado do colaborador, ou, por controle do provedor SST salvar sempre todos os dados do colaborador.
            Aqui é feito o 'parse' dos dados do payload para a base interna do provedor SST.
         */
        employeeIntegrationController.integrationPendency(accessKey, payload.integration);
    }

}
