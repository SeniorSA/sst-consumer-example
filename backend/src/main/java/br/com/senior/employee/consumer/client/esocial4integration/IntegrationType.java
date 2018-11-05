package br.com.senior.employee.consumer.client.esocial4integration;

/**
 * Tipo da integração.
 */
public enum IntegrationType {
    /**
     * Novo colaborador.
     */
    NEW_EMPLOYEE,
    /**
     * Alteração do colaborador.
     */
    EMPLOYEE_CHANGE,
    /**
     * Histórico de centro de custo.
     */
    HISTORICAL_COST_CENTER,
    /**
     * Histórico de departamento.
     */
    HISTORICAL_DEPARTMENT,
    /**
     * Histórico de cargo.
     */
    HISTORICAL_JOB_POSITION,
    /**
     * Histórico de posto de trabalho.
     */
    HISTORICAL_WORKSTATION,
    /**
     * Histórico de filial.
     */
    HISTORICAL_COMPANY_BRANCH,
    /**
     * Histórico de escala.
     */
    HISTORICAL_WORKSHIFT,
    /**
     * Demissão do colaborador.
     */
    DISMISSAL
}