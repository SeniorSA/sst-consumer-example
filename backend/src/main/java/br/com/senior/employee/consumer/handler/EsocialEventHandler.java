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
    public void esocialStatusIntegration(@RequestBody XmlStatus payload) {
        esocialIntegrationController.statusXml(payload);
    }

    /**
     * Sempre que o governo retornar um numero de recibo ou critica de um evento do Esocial será feito um POST que será consumido por este metodo.
     *
     * @param payload Numero do recibo / criticas retornados pelo governo.
     */
    @PostMapping(path = "/returnGovernment")
    public void esocialReturnGovernment(@RequestBody LayoutSituation payload) {
        esocialIntegrationController.returnGovernment(payload);
    }

    @PostMapping(path = "/sendXml")
    public void esocialSendXml(@RequestBody EsocialEventXmlPayload payload) {
        esocialIntegrationController.sendXml(payload.credential, payload.esocialEventXmlInput);
    }
}
