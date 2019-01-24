package br.com.senior.employee.consumer.controller.integration.esocial;


import br.com.senior.employee.consumer.client.esocial.ProviderXml;
import br.com.senior.employee.consumer.client.esocial.XmlOutput;

public abstract class EsocialIntegrationStrategy {

    /**
     * Rotina responsável por devolver o status do XML enviado para a Senior.
     *
     * @param xmlOutput Status do XML.
     */
    abstract void eSocialStatusXml(XmlOutput xmlOutput) throws Exception;
}
