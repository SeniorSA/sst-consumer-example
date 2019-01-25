package br.com.senior.employee.consumer.controller.integration.employee;

import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationType;
import br.com.senior.employee.consumer.client.esocial4integration.OperationType;
import lombok.extern.log4j.Log4j;

/**
 * Estratégia para integração do colaborador.
 */
@Log4j
public abstract class EmployeeIntegrationStrategy {

    /**
     * Identifica qual implementação deve ser utilizada para a pendência de integração em questão.
     *
     * @param integration Entidade da integração.
     */
    final void processPendency(IntegrationEntity integration) throws Exception {
        if (employeeExists(integration)) {
            employeeUpdate(integration);
        } else {
            employeeInsert(integration);
        }
    }

    /**
     * Valida se o colaborador já existe no sistema prestador SST.
     *
     * @param integration Entidade referente a integração.
     * @return {@Link Boolean}
     */
    abstract boolean employeeExists(IntegrationEntity integration);

    /**
     * Rotina responsável inserir um colaborador.
     *
     * @param integration Entidade da integração.
     */
    abstract void employeeInsert(IntegrationEntity integration) throws Exception;

    /**
     * Rotina responsável inserir um colaborador.
     *
     * @param integration Entidade da integração.
     */
    abstract void employeeUpdate(IntegrationEntity integration) throws Exception;
}
