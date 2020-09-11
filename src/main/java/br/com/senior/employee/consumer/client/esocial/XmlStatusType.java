/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial;

/**
 * Status do xml.
 */
public enum XmlStatusType {
    /**
     * XML Recebido.
     */
    IN_ANALYSIS,
    /**
     * Erro de validação.
     */
    VALIDATION_ERROR,
    /**
     * Validação com sucesso.
     */
    VALIDATION_SUCCESS,
    /**
     * Enviando para o governo
     */
    SENDING_TO_GOVERNMENT,
    /**
     * Aguardando o retorno do governo
     */
    WAITING_GOVERNMENT_RETURN,
    /**
     * Retorno do governo.
     */
    GOVERNMENT_RETURN,
    /**
     * Erro ao enviar o XML.
     */
    SEND_XML_ERROR,
    /**
     * Cancelado pelo usuário
     */
    CANCELED_BY_USER
}
