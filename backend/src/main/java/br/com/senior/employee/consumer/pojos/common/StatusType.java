/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.pojos.common;

/**
 * Tipo do status de integração.
 */
public enum StatusType {
    /**
     * Envio da pendência agendado.
     */
    SCHEDULED,
    /**
     * Processando a pendência.
     */
    INTEGRATING,
    /**
     * Pendência enviada ao prestador SST.
     */
    SENT_TO_PROVIDER,
    /**
     * Pendência recebida com sucesso pelo prestador SST.
     */
    ON_PROVIDER,
    /**
     * Erro no envio ou no recebimento da pendência pelo prestador SST.
     */
    INTEGRATION_ERROR,
    /**
     * Pendência cancelada.
     */
    CANCELED,
    /**
     * Em análise.
     */
    IN_ANALYSIS,
    /**
     * Erro na análise.
     */
    ANALYSIS_ERROR,
    /**
     * Irrelevante para o envio.
     */
    IRRELEVANT
}

