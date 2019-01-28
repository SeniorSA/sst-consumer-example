package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Singleton
public class Rest {

    @Autowired
    private Auth auth;
    private Map<String, RestTemplate> restTemplates = new HashMap();

    public RestTemplate get(Credential credential) {
        if (restTemplates.get(credential.username) == null) {
            try {
                RestTemplate restTemplate = RestTemplateBuilder.build();

                final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

                BasicAuthInterceptor basicAuthInterceptor = new BasicAuthInterceptor(auth, credential);
                interceptors.add(basicAuthInterceptor);
                restTemplate.setInterceptors(interceptors);

                restTemplates.put(credential.username, restTemplate);
            } catch (Exception e) {
                throw new RestClientConfigurationException(e);
            }
        }
        return restTemplates.get(credential.username);
    }
}
