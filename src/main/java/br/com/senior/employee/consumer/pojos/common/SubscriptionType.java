/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.pojos.common;

/**
 * Tipo de inscrição.
 */
public enum SubscriptionType {
    /**
     * 1 - CNPJ.
     */
    CNPJ,
    /**
     * 2 - CPF.
     */
    CPF,
    /**
     * 3 - CAEPF (Cadastro de Atividade Econômica de Pessoa Física).
     */
    CAEPF,
    /**
     * 4 - CNO (Cadastro Nacional de Obra).
     */
    CNO,
    /**
     * 5 - CEI.
     */
    CEI;

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
         * Histórico de afastamentos.
         */
        HISTORICAL_LEAVE,
        /**
         * Histórico de posto de trabalho.
         */
        HISTORICAL_WORKSTATION
    }
}
