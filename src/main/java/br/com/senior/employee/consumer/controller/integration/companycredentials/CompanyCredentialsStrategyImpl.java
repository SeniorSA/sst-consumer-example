package br.com.senior.employee.consumer.controller.integration.companycredentials;

import br.com.senior.employee.consumer.client.authentication.Credential;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyCredentialsStrategyImpl implements CompanyCredentialsStrategy {

    /*
     *  Retorna a lista de credenciais (usuário/senha) referente ao usuário da
     *  integração com a plataforma SeniorX de cada empresa.
     */
    @Override
    public List<Credential> getCredentials() {
        List<Credential> list = new ArrayList<>();
        list.add(new Credential("User", "Password"));
        return list;
    }
}