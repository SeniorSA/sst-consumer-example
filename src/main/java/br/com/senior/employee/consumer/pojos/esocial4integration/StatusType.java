/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.pojos.esocial4integration;

/**
 * Tipo do status de integração.
 */
public enum StatusType {
    /**
     * Aguardando processamento.
     */
    TO_INTEGRATE,
    /**
     * Erro na integração.
     */
    INTEGRATION_ERROR,
    /**
     * Enviado ao prestador SST.
     */
    SENT_TO_PROVIDER,
    /**
     * Recebido pelo prestador SST.
     */
    ON_PROVIDER,
    /**
     * Erro no prestador de SST.
     */
    PROVIDER_ERROR
}
