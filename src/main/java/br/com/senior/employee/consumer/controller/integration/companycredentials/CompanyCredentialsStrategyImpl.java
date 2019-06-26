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
        credentials.add(new KeyCredential("JBxZyvgq6t0L85Wl49syyEhtyK0a", "pjGpTrlqb4d5qzevIFqx79Mt82sa", "vinicius-luis"));
        return credentials;
    }
}