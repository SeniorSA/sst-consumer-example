package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
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

    public RestTemplate getWithKey(KeyCredential keyCredential) {
        RestTemplate restTemplate = RestTemplateBuilder.build();
        try {
            KeyCredential credentialFromAccessKey = getCredentialFromAccessKey(keyCredential.accessKey);

            final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
            BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor(auth, credentialFromAccessKey);
            interceptors.add(basicAuthInterceptor);
            restTemplate.setInterceptors(interceptors);

        } catch (Exception e) {
            throw new RestClientConfigurationException(e);
        }
        return restTemplate;
    }

    private KeyCredential getCredentialFromAccessKey(String accessKey) {
        Stream<KeyCredential> credentialStream = companyCredentialsStrategy.getCredentials().stream().filter(kc -> kc.accessKey.equals(accessKey));
        return credentialStream.findFirst().get();
    }
}
