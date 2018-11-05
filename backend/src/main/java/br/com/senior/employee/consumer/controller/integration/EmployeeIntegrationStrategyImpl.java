package br.com.senior.employee.consumer.controller.integration;

import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EmployeeIntegrationStrategyImpl extends EmployeeIntegrationStrategy {

    @Override
    public boolean employeeExists(IntegrationEntity integration) {
        LOGGER.info("employeeExists ID: " + integration.getId());
        // Programe aqui sua consulta para verificar se o colaborador existe na base e setar o retorno.
        return true;
    }

    @Override
    public void employeeAdmissionInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de uma admissão.
        LOGGER.info("employeeAdmissionInsert ID: " + integration.getId());
    }

    @Override
    public void employeeAdmissionUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de uma admissão.
        LOGGER.info("employeeAdmissionUpdate ID: " + integration.getId());
    }

    @Override
    public void employeeAdmissionDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de uma admissão.
        LOGGER.info("employeeAdmissionDelete ID: " + integration.getId());
    }

    @Override
    public void employeeUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração do colaborador.
        LOGGER.info("employeeUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalCostCenterInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de um centro de custo.
        LOGGER.info("employeeHistoricalCostCenterInsert ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalCostCenterUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes alteração de um centro de custo.
        LOGGER.info("employeeHistoricalCostCenterUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalCostCenterDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes exclusão de um centro de custo.
        LOGGER.info("employeeHistoricalCostCenterDelete ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalDepartmentInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de um departamento.
        LOGGER.info("employeeHistoricalDepartmentInsert ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalDepartmentUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de um departamento.
        LOGGER.info("employeeHistoricalDepartmentUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalDepartmentDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de um departamento.
        LOGGER.info("employeeHistoricalDepartmentDelete ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalJobPositionInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de cargo.
        LOGGER.info("employeeHistoricalJobPositionInsert ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalJobPositionUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de cargo.
        LOGGER.info("employeeHistoricalJobPositionUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalJobPositionDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de cargo.
        LOGGER.info("employeeHistoricalJobPositionDelete ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalWorkStationInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de posto de trabalho.
        LOGGER.info("employeeHistoricalWorkStationInsert ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalWorkStationUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de posto de trabalho.
        LOGGER.info("employeeHistoricalWorkStationUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalWorkStationDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de posto de trabalho.
        LOGGER.info("employeeHistoricalWorkStationDelete ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalCompanyBranchInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de empresa.
        LOGGER.info("employeeHistoricalCompanyBranchInsert ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalCompanyBranchUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de empresa.
        LOGGER.info("employeeHistoricalCompanyBranchUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalCompanyBranchDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de empresa.
        LOGGER.info("employeeHistoricalCompanyBranchDelete ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalWorkShiftInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de horario de trabalho.
        LOGGER.info("employeeHistoricalWorkShiftInsert ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalWorkShiftUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de horario de trabalho.
        LOGGER.info("employeeHistoricalWorkShiftUpdate ID: " + integration.getId());
    }

    @Override
    void employeeHistoricalWorkShiftDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de horario de trabalho.
        LOGGER.info("employeeHistoricalWorkShiftDelete ID: " + integration.getId());
    }
}
