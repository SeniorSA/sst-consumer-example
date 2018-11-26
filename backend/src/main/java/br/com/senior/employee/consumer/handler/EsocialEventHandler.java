package br.com.senior.employee.consumer.handler;

import br.com.senior.employee.consumer.client.esocial.*;
import br.com.senior.employee.consumer.controller.integration.esocial.EsocialIntegrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/esocial")
public class EsocialEventHandler {

    @Autowired
    private EsocialIntegrationController esocialIntegrationController;

    /**
     * Sempre que o status do envio do XML for alterado será feito um POST que é consumido por este metodo.
     *
     * @param payload Status do envio do XML.
     */
    @PostMapping(path = "/statusIntegration")
    public void esocialStatusIntegration(@RequestBody StatusIntegrationEventPayload payload) {
        esocialIntegrationController.statusXml(payload.result);
    }

    @PostMapping(path = "/sendXml")
    public void esocialSendXml(@RequestBody EsocialEventXmlPayload payload) {
        esocialIntegrationController.sendXml(payload.credential, payload.esocialEventXmlInput);
    }
}
