package br.com.senior.employee.consumer.handler;

import br.com.senior.employee.consumer.client.esocial.*;
import br.com.senior.employee.consumer.controller.integration.esocial.EsocialIntegrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/esocial")
public class EsocialEventHandler {

    @Autowired
    private EsocialIntegrationController esocialIntegrationController;

    /**
     * Sempre que o status do envio do XML for alterado será feito um POST que é consumido por este metodo.
     *
     *  @param accessKey Chave de acesso da aplicação.
     * @param payload Status do envio do XML.
     */
    @PostMapping(path = "/statusIntegration")
    public void esocialStatusIntegration(@RequestHeader(name = "x-senior-key") String accessKey, @RequestBody StatusIntegrationEventPayload payload) {
        esocialIntegrationController.statusXml(accessKey, payload.result);

    }

    @PostMapping(path = "/sendXml")
    public XmlOutput esocialSendXml(@RequestBody EsocialEventXmlPayload payload) {
       return esocialIntegrationController.sendXml(payload.credential, payload.esocialEventXmlInput);
    }
}
