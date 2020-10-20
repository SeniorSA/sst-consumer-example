package br.com.senior.employee.consumer.controller.integration.esocial;

import br.com.senior.employee.consumer.client.esocial.StatusEsocialXmlDTO;

public abstract class EsocialIntegrationStrategy {

    /**
     * Rotina responsável por devolver o status do XML enviado para a Senior.
     *
     * @param statusEsocialXmlDTO dto do Status do XML.
     */
    abstract void eSocialStatusXml(StatusEsocialXmlDTO statusEsocialXmlDTO) throws Exception;
}
