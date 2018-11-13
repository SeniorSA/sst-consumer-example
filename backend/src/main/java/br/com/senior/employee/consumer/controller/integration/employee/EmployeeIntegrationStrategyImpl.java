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
    void employeeInsert(IntegrationEntity integration) {
        // Programe aqui a inserção do colaborador.
    }

    @Override
    void employeeUpdate(IntegrationEntity integration) {
        // Programe aqui a atualização do colaborador.
    }
}
