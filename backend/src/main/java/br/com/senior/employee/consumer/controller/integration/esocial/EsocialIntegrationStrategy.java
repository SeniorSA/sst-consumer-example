package br.com.senior.employee.consumer.controller.integration.esocial;


import br.com.senior.employee.consumer.client.esocial.XmlEventData;

public abstract class EsocialIntegrationStrategy {

    /**
     * Rotina responsável por devolver o status do XML enviado para a Senior.
     *
     * @param statusXml Status do XML.
     */
    abstract void eSocialStatusXml(XmlEventData statusXml);
}
