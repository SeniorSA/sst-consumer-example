package br.com.senior.employee.consumer.controller.integration.companycredentials;

import br.com.senior.employee.consumer.client.authentication.Credential;

import java.util.List;

public interface CompanyCredentialsStrategy {

    List<Credential> getCredentials();
}
