package br.com.senior.employee.consumer.handler;

import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.controller.IntegrationController;
import br.com.senior.employee.consumer.entity.EmployeeEntity;
import br.com.senior.employee.consumer.entity.IntegrationEntity;
import br.com.senior.employee.consumer.pojos.common.SubscriptionType;
import br.com.senior.employee.consumer.pojos.esocial.*;
import br.com.senior.employee.consumer.pojos.esocial4integration.Integration;
import br.com.senior.employee.consumer.pojos.esocial4integration.IntegrationPendencyEventPayload;
import br.com.senior.employee.consumer.pojos.esocial4integration.IntegrationUpdateStatusInput;
import br.com.senior.employee.consumer.pojos.esocial4integration.ProviderStatusType;
import br.com.senior.employee.consumer.repository.IntegrationRepository;
import br.com.senior.employee.consumer.rest.Rest;
import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping(path = "/integration")
public class IntegrationEventHandler {

    @Autowired
    private IntegrationController integrationController;

    /**
     * Integrar todas as pendências ainda não consumidas.
     */
    @PostMapping(path = "/consumeOldPendencies")
    public void integrationPendency() {
        integrationController.consumeOldPendencies();
    }

    /**
     * Endpoint que recebe um POST.
     * Uma REGRA deve ser cadastrada no EVENTO integrationPendency.
     * Este endpoint será invocado quando uma ação de admissão, alteração de admissão e movimentações (Centro de custo, Local, Cargo, Posto de trabalho e Afastamentos) do colaborador ocorrer.
     *
     * @param payload Dados do colaborador.
     */
    @PostMapping(path = "/pendency")
    public void integrationPendency(@RequestBody IntegrationPendencyEventPayload payload) {
        /*
            O payload virá com todos os dados do colaborador independente do tipo de integração (integrationType).
            Enviamos o integrationType para o provedor SST decidir alterar apenas o que foi alterado do colaborador, ou, por controle do provedor SST salvar sempre todos os dados do colaborador.
            Aqui é feito o 'parse' dos dados do payload para a base interna do provedor SST.
         */
        integrationController.integrationPendency(payload.integration);
    }

}
