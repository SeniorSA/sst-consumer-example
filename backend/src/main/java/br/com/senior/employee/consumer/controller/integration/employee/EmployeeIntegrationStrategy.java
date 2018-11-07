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
    final void processPendency(IntegrationEntity integration) {
        if (integration.getIntegrationType() == IntegrationType.NEW_EMPLOYEE) {
            employeeAdmission(integration);
        } else if (integration.getIntegrationType() == IntegrationType.EMPLOYEE_CHANGE) {
            employeeChange(integration);
        } else if (integration.getIntegrationType() == IntegrationType.DISMISSAL) {
            employeeDismissal(integration);
        } else if (integration.getIntegrationType() == IntegrationType.HISTORICAL_COST_CENTER) {
            employeeHistoricalCostCenter(integration);
        } else if (integration.getIntegrationType() == IntegrationType.HISTORICAL_DEPARTMENT) {
            employeeHistoricalDepartment(integration);
        } else if (integration.getIntegrationType() == IntegrationType.HISTORICAL_JOB_POSITION) {
            employeeHistoricalJobPosition(integration);
        } else if (integration.getIntegrationType() == IntegrationType.HISTORICAL_WORKSTATION) {
            employeeHistoricalWorkStation(integration);
        } else if (integration.getIntegrationType() == IntegrationType.HISTORICAL_COMPANY_BRANCH) {
            employeeHistoricalCompanyBranch(integration);
        } else if (integration.getIntegrationType() == IntegrationType.HISTORICAL_WORKSHIFT) {
            employeeHistoricalWorkShift(integration);
        }
    }

    /**
     * Método responsável pelas implementações pertinentes a admissão do colaborador.
     *
     * @param integration Entidade referente a integração.
     */
    private final void employeeAdmission(IntegrationEntity integration) {
        LOGGER.info("employeeAdmission ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.UPDATE) {
                employeeAdmissionUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeAdmissionDelete(integration);
            } else {
                LOGGER.warn("A pendência de admissão de operação " + integration.getOperationType() + " foi enviada para um colaborador já admitido.");
            }
        } else {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeAdmissionInsert(integration);
            } else {
                LOGGER.warn("A pendência de admissão de operação " + integration.getOperationType() + " foi enviada para um colaborador que não foi admitido.");
            }
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
     * Realiza a inserção de uma admissão de um colaborador.
     *
     * @param integration Entidade referente a integração.
     */
    abstract void employeeAdmissionInsert(IntegrationEntity integration);

    /**
     * Realiza a atualização de uma admissão de um colaborador.
     *
     * @param integration Entidade referente a integração.
     */
    abstract void employeeAdmissionUpdate(IntegrationEntity integration);

    /**
     * Realiza a exclusão de uma admissão de um colaborador.
     *
     * @param integration Entidade referente a integração.
     */
    abstract void employeeAdmissionDelete(IntegrationEntity integration);

    /**
     * Método responsável pelas implementações pertinentes a alterações do colaborador.
     *
     * @param integration Entidade referente a integração.
     */
    private final void employeeChange(IntegrationEntity integration) {
        LOGGER.info("employeeChange ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        integration.setOperationType(OperationType.UPDATE);
        if (employeeExists) {
            if (integration.getOperationType() == OperationType.UPDATE) {
                employeeUpdate(integration);
            } else {
                LOGGER.warn("Somente é possível enviar pendências de alteração de dados do colaborador para a operação " + OperationType.UPDATE.name());
            }
        } else {
            LOGGER.warn("A pendência de alteração de dados foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeUpdate(IntegrationEntity integration);

    private final void employeeDismissal(IntegrationEntity integration) {
        LOGGER.info("employeeDismissal ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeUpdate(integration);
            } else {
                LOGGER.warn("Somente é possível enviar pendências de demissão para a operação " + OperationType.INSERT.name());
            }
        } else {
            LOGGER.warn("A pendência de demissão foi enviada para um colaborador que não foi admitido.");
        }
    }

    /**
     * Metodo responsável pelas implementações referentes a histórico de centro de custo do colaborador.
     *
     * @param integration
     */
    private final void employeeHistoricalCostCenter(IntegrationEntity integration) {
        LOGGER.info("employeeHistoricalCostCenter ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeHistoricalCostCenterInsert(integration);
            } else if (integration.getOperationType() == OperationType.UPDATE) {
                employeeHistoricalCostCenterUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeHistoricalCostCenterDelete(integration);
            }
        } else {
            LOGGER.warn("A pendência de histórico de centro de custo foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeHistoricalCostCenterInsert(IntegrationEntity integration);

    abstract void employeeHistoricalCostCenterUpdate(IntegrationEntity integration);

    abstract void employeeHistoricalCostCenterDelete(IntegrationEntity integration);


    /**
     * Metodo responsável pelas implementações referentes a histórico de departamento do colaborador.
     *
     * @param integration Entidade da integração.
     */
    final void employeeHistoricalDepartment(IntegrationEntity integration) {
        LOGGER.info("employeeHistoricalDepartment ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeHistoricalDepartmentInsert(integration);
            } else if (integration.getOperationType() == OperationType.UPDATE) {
                employeeHistoricalDepartmentUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeHistoricalDepartmentDelete(integration);
            }
        } else {
            LOGGER.warn("A pendência de histórico de departamento foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeHistoricalDepartmentInsert(IntegrationEntity integration);

    abstract void employeeHistoricalDepartmentUpdate(IntegrationEntity integration);

    abstract void employeeHistoricalDepartmentDelete(IntegrationEntity integration);


    /**
     * Metodo responsável pelas implementações referentes a histórico de cargo do colaborador.
     *
     * @param integration Entidade da integração.
     */
    final void employeeHistoricalJobPosition(IntegrationEntity integration) {
        LOGGER.info("employeeHistoricalJobPosition ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeHistoricalJobPositionInsert(integration);
            } else if (integration.getOperationType() == OperationType.UPDATE) {
                employeeHistoricalJobPositionUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeHistoricalJobPositionDelete(integration);
            }
        } else {
            LOGGER.warn("A pendência de histórico de cargo foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeHistoricalJobPositionInsert(IntegrationEntity integration);

    abstract void employeeHistoricalJobPositionUpdate(IntegrationEntity integration);

    abstract void employeeHistoricalJobPositionDelete(IntegrationEntity integration);


    /**
     * Metodo responsável pelas implementações referentes a histórico de posto de trabalho do colaborador.
     *
     * @param integration Entidade da integração.
     */
    final void employeeHistoricalWorkStation(IntegrationEntity integration) {
        LOGGER.info("employeeHistoricalWorkStation ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeHistoricalWorkStationInsert(integration);
            } else if (integration.getOperationType() == OperationType.UPDATE) {
                employeeHistoricalWorkStationUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeHistoricalWorkStationDelete(integration);
            }
        } else {
            LOGGER.warn("A pendência de histórico de posto de trabalho foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeHistoricalWorkStationInsert(IntegrationEntity integration);

    abstract void employeeHistoricalWorkStationUpdate(IntegrationEntity integration);

    abstract void employeeHistoricalWorkStationDelete(IntegrationEntity integration);


    /**
     * Metodo responsável pelas implementações referentes a histórico de empresa do colaborador.
     *
     * @param integration Entidade da integração.
     */
    final void employeeHistoricalCompanyBranch(IntegrationEntity integration) {
        LOGGER.info("employeeHistoricalCompanyBranch ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeHistoricalCompanyBranchInsert(integration);
            } else if (integration.getOperationType() == OperationType.UPDATE) {
                employeeHistoricalCompanyBranchUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeHistoricalCompanyBranchDelete(integration);
            }
        } else {
            LOGGER.warn("A pendência de histórico de empresa foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeHistoricalCompanyBranchInsert(IntegrationEntity integration);

    abstract void employeeHistoricalCompanyBranchUpdate(IntegrationEntity integration);

    abstract void employeeHistoricalCompanyBranchDelete(IntegrationEntity integration);


    /**
     * Metodo responsável pelas implementações referentes a histórico escala do colaborador.
     *
     * @param integration Entidade da integração.
     */
    final void employeeHistoricalWorkShift(IntegrationEntity integration) {
        LOGGER.info("employeeHistoricalCompanyBranch ID: " + integration.getId());

        boolean employeeExists = employeeExists(integration);

        if (employeeExists) {
            if (integration.getOperationType() == OperationType.INSERT) {
                employeeHistoricalWorkShiftInsert(integration);
            } else if (integration.getOperationType() == OperationType.UPDATE) {
                employeeHistoricalWorkShiftUpdate(integration);
            } else if (integration.getOperationType() == OperationType.DELETE) {
                employeeHistoricalWorkShiftDelete(integration);
            }
        } else {
            LOGGER.warn("A pendência de histórico de escala foi enviada para um colaborador que não foi admitido.");
        }
    }

    abstract void employeeHistoricalWorkShiftInsert(IntegrationEntity integration);

    abstract void employeeHistoricalWorkShiftUpdate(IntegrationEntity integration);

    abstract void employeeHistoricalWorkShiftDelete(IntegrationEntity integration);

}
