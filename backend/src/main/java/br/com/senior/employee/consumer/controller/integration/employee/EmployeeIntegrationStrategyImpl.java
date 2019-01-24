package br.com.senior.employee.consumer.controller.integration.employee;

import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EmployeeIntegrationStrategyImpl extends EmployeeIntegrationStrategy {


    @Override
    public boolean employeeExists(IntegrationEntity integration) {
        /*
         * Programe aqui a consulta que verifica se o colaborador já existe no sistema do prestador SST.
         * Se não encontrar o colaborador, a rotina deve retornar false.
         */
        return true;
    }

    @Override
    void employeeInsert(IntegrationEntity integration) {
        /*
         * Programe aqui a rotina de inserção do colaborador no sistema do prestador SST.
         */
    }

    @Override
    void employeeUpdate(IntegrationEntity integration) {
        /*
         * Programe aqui a rotina de atualização das informações do colaborador no sistema do prestador SST.
         */
    }
}