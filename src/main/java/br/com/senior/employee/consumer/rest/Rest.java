package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.Credential;
import br.com.senior.employee.consumer.controller.integration.companycredentials.CompanyCredentialsStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Singleton
public class Rest {

    @Autowired
    private Auth auth;
    @Autowired
    private CompanyCredentialsStrategyImpl companyCredentialsStrategy;

    public RestTemplate get(Credential credential) {
        RestTemplate restTemplate = RestTemplateBuilder.build();
        try {
                Credential credentialFromUser = getCredentialFromUser(credential.username);

                final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
                BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor(auth, credentialFromUser);
                interceptors.add(basicAuthInterceptor);
                restTemplate.setInterceptors(interceptors);

            } catch (Exception e) {
                throw new RestClientConfigurationException(e);
            }
        return restTemplate;
    }

    /**
     * Busca por uma credencial registrada com base em um determinado usuário.
     * @param username nome do usuário a ser buscado.
     * @return a credencial do usuário.
     */
    private Credential getCredentialFromUser(String username) {
        Stream<Credential> credentialStream = companyCredentialsStrategy.getCredentials().stream().filter(cr -> cr.username.equals(username));
        return credentialStream.findFirst().get();
    }
}
