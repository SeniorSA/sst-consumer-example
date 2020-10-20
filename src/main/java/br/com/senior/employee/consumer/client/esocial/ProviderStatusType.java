package br.com.senior.employee.consumer.client.esocial;

/**
 * Situação do consumo do status do XML pelo prestador SST.
 */
public enum ProviderStatusType {
    /**
     * Recebido pelo prestador SST.
     */
    ON_PROVIDER,
    /**
     * Enviado ao prestador SST.
     */
    SENT_TO_PROVIDER,
    /**
     * Erro no provedor.
     */
    PROVIDER_ERROR
}
