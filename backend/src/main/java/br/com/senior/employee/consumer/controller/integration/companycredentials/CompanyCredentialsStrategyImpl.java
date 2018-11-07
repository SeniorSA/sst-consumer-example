package br.com.senior.employee.consumer.controller.integration.companycredentials;

import br.com.senior.employee.consumer.client.authentication.Credential;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyCredentialsStrategyImpl implements CompanyCredentialsStrategy {

    @Override
    public List<Credential> getCredentials() {
        List<Credential> list = new ArrayList<>();
        list.add(new Credential("admin@hcmsst.com.br", "Senha1!"));
        return list;
    }
}
