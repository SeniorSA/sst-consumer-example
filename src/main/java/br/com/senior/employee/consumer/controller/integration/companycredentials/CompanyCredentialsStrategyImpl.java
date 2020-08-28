package br.com.senior.employee.consumer.controller.integration.companycredentials;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyCredentialsStrategyImpl implements CompanyCredentialsStrategy {

    /**
     * Retorna a lista de credenciais (chave de acesso/chave secreta de acesso/nome do tenant) referente ao
     * usuário da integração com a plataforma SeniorX de cada empresa.
     * @return a lista de credenciais de usuário.
     */
    @Override
    public List<KeyCredential> getCredentials() {
        List<KeyCredential> credentials = new ArrayList<>();
        credentials.add(new KeyCredential("anaBvCB0QadJ07obh20yimYjo4ka", "mfmbLd3fTI_vvYax9ajRux9L_Soa", "neuryellen-schmitz"));
        return credentials;
    }
}