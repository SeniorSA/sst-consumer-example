package br.com.senior.employee.consumer.controller.integration.employee;

import java.util.Optional;

import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationType;
import br.com.senior.employee.consumer.client.esocial4integration.OperationType;
import lombok.extern.log4j.Log4j2;

/**
 * Estratégia para integração do colaborador.
 */
@Log4j2
public abstract class EmployeeIntegrationStrategy {

    /**
     * Identifica qual implementação deve ser utilizada para a pendência de integração em questão.
     *
     * @param integration Entidade da integração.
     */
    final String processPendency(IntegrationEntity integration) throws Exception {
        if (isAdmissionExclusion(integration)) {
            var providerEmployeeIdentification = employeeDelete(integration);
            return this.getProviderEmployeeIdentificationIfPresentElseNull(providerEmployeeIdentification);
        } else if (employeeExists(integration)) {
            var providerEmployeeIdentification = employeeUpdate(integration);
            return this.getProviderEmployeeIdentificationIfPresentElseNull(providerEmployeeIdentification);
        } else {
            var providerEmployeeIdentification = employeeInsert(integration);
            return this.getProviderEmployeeIdentificationIfPresentElseNull(providerEmployeeIdentification);
        }
    }

    private String getProviderEmployeeIdentificationIfPresentElseNull(Optional<String> providerEmployeeIdentification) {
        return providerEmployeeIdentification.orElse(null);
    }

    /**
     * Retorna se é uma exclusão de uma admissão
     *
     * @param integration integração a ser analisada
     * @return verdadeiro é uma exclusão de uma admissão
     */
    public boolean isAdmissionExclusion(IntegrationEntity integration) {
        return integration.getIntegrationType() == IntegrationType.NEW_EMPLOYEE
                && integration.getOperationType() == OperationType.DELETE;
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
    abstract Optional<String> employeeInsert(IntegrationEntity integration) throws Exception;

    /**
     * Rotina responsável inserir um colaborador.
     *
     * @param integration Entidade da integração.
     */
    abstract Optional<String> employeeUpdate(IntegrationEntity integration) throws Exception;

    /**
     * Rotina responsável deletar um colaborador.
     *
     * @param integration Entidade da integração.
     */
    abstract Optional<String> employeeDelete(IntegrationEntity integration) throws Exception;
}
