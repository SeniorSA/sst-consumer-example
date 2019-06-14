package br.com.senior.employee.consumer.controller.integration.companycredentials;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;

import java.util.List;

public interface CompanyCredentialsStrategy {

    /**
     * Obtém a lista de credenciais das empresas na plataforma Senior.
     *
     * @return {@Link List<KeyCredential>}
     */
    List<KeyCredential> getCredentials();
}
