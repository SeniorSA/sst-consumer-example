package br.com.senior.employee.consumer.controller.integration.esocial;


import br.com.senior.employee.consumer.client.esocial.LayoutSituation;
import br.com.senior.employee.consumer.client.esocial.LayoutSituationEventPayload;
import br.com.senior.employee.consumer.client.esocial.XmlSituation;
import br.com.senior.employee.consumer.client.esocial.XmlStatus;

import java.util.List;

public abstract class EsocialIntegrationStrategy {

    /**
     * Rotina responsável por devolver o status do XML enviado para a Senior.
     *
     * @param statusXml Status do XML.
     */
    abstract void eSocialStatusXml(XmlStatus statusXml);

    /**
     * Rotina responsável por devolver o recibo/críticas do governo.
     *
     * @param government Dados de retorno.
     */
    abstract void returnGovernment(LayoutSituation government);
}
