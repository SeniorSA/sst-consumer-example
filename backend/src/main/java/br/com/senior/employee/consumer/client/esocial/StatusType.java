/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial;

/**
 * Status do layout.
 */
public enum StatusType {
    /**
     * Erro retornado.
     */
    ERROR_RETURNED,
    /**
     * Erro comunicação eDocs.
     */
    E_DOC_COMMUNICATION_ERROR,
    /**
     * Erro na geração do XML.
     */
    XML_GENERATION_ERROR,
    /**
     * Aguardando envio manual.
     */
    WAITING_MANUAL_SUBMISSION,
    /**
     * Aguardando envio automático.
     */
    WAITING_AUTOMATIC_SUBMISSION,
    /**
     * Aguardando retorno.
     */
    WAITING_RETURN,
    /**
     * Recibo retornado com sucesso.
     */
    RECEIPT_RETURNED,
    /**
     * Recibo informado manualmente.
     */
    RECEIPT_MANUAL,
    /**
     * Erro tratado.
     */
    FIXED_ERROR,
    /**
     * Erro tratado (evento excluído).
     */
    EVENT_DELETED,
    /**
     * Evento cancelado.
     */
    EVENT_CANCELED
}
