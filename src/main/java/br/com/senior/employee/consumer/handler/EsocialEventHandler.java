package br.com.senior.employee.consumer.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.employee.consumer.client.esocial.SendEsocialXmlPayload;
import br.com.senior.employee.consumer.client.esocial.StatusIntegrationEventPayload;
import br.com.senior.employee.consumer.client.esocial.XmlOutput;
import br.com.senior.employee.consumer.controller.integration.esocial.EsocialIntegrationController;

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
    public XmlOutput esocialSendXml(@RequestBody SendEsocialXmlPayload payload) {
       return esocialIntegrationController.sendXml(payload.credential, payload.sendEsocialXmlInput);
    }
}
