package br.com.senior.employee.consumer.controller.integration.employee;

import br.com.senior.employee.consumer.client.esocial.EsocialEventXmlInput;
import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import br.com.senior.employee.consumer.controller.integration.esocial.EsocialIntegrationController;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EmployeeIntegrationStrategyImpl extends EmployeeIntegrationStrategy {

    @Override
    public boolean employeeExists(IntegrationEntity integration) {
        // Programe aqui sua consulta para verificar se o colaborador existe na base e setar o retorno.
        return true;
    }

    @Override
    public void employeeAdmissionInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de uma admissão.
    }

    @Override
    public void employeeAdmissionUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de uma admissão.
    }

    @Override
    public void employeeAdmissionDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de uma admissão.
    }

    @Override
    public void employeeUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração do colaborador.
    }

    @Override
    void employeeHistoricalCostCenterInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de um histórico de centro de custo do colaborador.
    }

    @Override
    void employeeHistoricalCostCenterUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes alteração de histórico de centro de custo do colaborador.
    }

    @Override
    void employeeHistoricalCostCenterDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes exclusão de histórico de centro de custo do colaborador.
    }

    @Override
    void employeeHistoricalDepartmentInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de um histórico de departamento(setor) do colaborador.
    }

    @Override
    void employeeHistoricalDepartmentUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de histórico de departamento(setor) do colaborador.
    }

    @Override
    void employeeHistoricalDepartmentDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de histórico de departamento(setor) do colaborador.
    }

    @Override
    void employeeHistoricalJobPositionInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de histórico de cargo do colaborador.
    }

    @Override
    void employeeHistoricalJobPositionUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de histórico de cargo do colaborador.
    }

    @Override
    void employeeHistoricalJobPositionDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de histórico de cargo do colaborador.
    }

    @Override
    void employeeHistoricalWorkStationInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de histórico de posto de trabalho do colaborador.
    }

    @Override
    void employeeHistoricalWorkStationUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de histórico de posto de trabalho do colaborador.
    }

    @Override
    void employeeHistoricalWorkStationDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de histórico de posto de trabalho do colaborador.
    }

    @Override
    void employeeHistoricalCompanyBranchInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de histórico de empresa do colaborador.
    }

    @Override
    void employeeHistoricalCompanyBranchUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de histórico de empresa do colaborador.
    }

    @Override
    void employeeHistoricalCompanyBranchDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de histórico de empresa do colaborador.
    }

    @Override
    void employeeHistoricalWorkShiftInsert(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a inserção de histórico de turno do colaborador.
    }

    @Override
    void employeeHistoricalWorkShiftUpdate(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a alteração de histórico turno do colaborador.
    }

    @Override
    void employeeHistoricalWorkShiftDelete(IntegrationEntity integration) {
        // Programe aqui os tratamentos referentes a exclusão de histórico turno de trabalho do colaborador.
    }
}
