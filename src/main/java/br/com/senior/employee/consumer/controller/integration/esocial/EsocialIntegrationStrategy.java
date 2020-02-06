package br.com.senior.employee.consumer.controller.integration.esocial;


import br.com.senior.employee.consumer.client.esocial.XmlOutput;

public abstract class EsocialIntegrationStrategy {

    /**
     * Rotina responsável por devolver o status do XML enviado para a Senior.
     *
     * @param xmlOutput Status do XML.
     */
    abstract void eSocialStatusXml(XmlOutput xmlOutput) throws Exception;

    /**
     * Rotina responsável por enviar o XML para a plataforma da Senior.
     */
    abstract void eSocialSendXml() throws Exception;
}
