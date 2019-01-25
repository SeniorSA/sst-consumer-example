package br.com.senior.employee.consumer.handler;

import br.com.senior.employee.consumer.client.esocial.*;
import br.com.senior.employee.consumer.controller.integration.esocial.EsocialIntegrationController;
import ch.qos.logback.core.net.SyslogOutputStream;
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
     *  @param user\
     * @param payload Status do envio do XML.
     */
    @PostMapping(path = "/statusIntegration")
    public void esocialStatusIntegration(@RequestHeader(name = "x-senior-user") String user, @RequestBody StatusIntegrationEventPayload payload) {
        esocialIntegrationController.statusXml(user, payload.result);

    }

    @PostMapping(path = "/sendXml")
    public XmlOutput esocialSendXml(@RequestBody EsocialEventXmlPayload payload) {
       return esocialIntegrationController.sendXml(payload.credential, payload.esocialEventXmlInput);
    }
}
