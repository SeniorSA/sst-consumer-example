package br.com.senior.employee.consumer.controller.integration.employee;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.senior.employee.consumer.client.esocial4integration.IntegrationEntity;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class EmployeeIntegrationStrategyImpl extends EmployeeIntegrationStrategy {

    @Override
    public boolean employeeExists(IntegrationEntity integration) {
        /**
         * Programe aqui a consulta que verifica se o colaborador já existe no sistema do prestador SST.
         * Se não encontrar o colaborador, a rotina deve retornar false.
         */
        return true;
    }

    @Override
    Optional<String> employeeInsert(IntegrationEntity integration) {
        /**
         * Programe aqui a rotina de inserção do colaborador no sistema do prestador SST.
         */
        return Optional.empty();
    }

    @Override
    Optional<String> employeeUpdate(IntegrationEntity integration) {
        /**
         * Programe aqui a rotina de atualização das informações do colaborador no sistema do prestador SST.
         */
        return Optional.empty();
    }

    @Override
    Optional<String> employeeDelete(IntegrationEntity integration) throws Exception {
        /**
         *
         *      ******************************************************************************************************************
         *      **                                                                                                              **
         *      **      ATENÇÃO: RECOMENDAMOS NÃO EXCLUIR O COLABORADOR NEM QUALQUER INFORMAÇÃO DO MESMO, E SIM INATIVÁ-LO      **
         *      **                                                                                                              **
         *      ******************************************************************************************************************
         *
         *
         * Programe aqui a rotina que tratará a exclusão das informações do colaborador no sistema do prestador SST.
         *
         */
        return Optional.empty();
    }
}