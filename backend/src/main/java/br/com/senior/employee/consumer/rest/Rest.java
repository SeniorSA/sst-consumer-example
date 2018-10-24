package br.com.senior.employee.consumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Component
@Singleton
public class Rest {

    @Autowired
    private BasicAuthInterceptor basicAuthInterceptor;
    private RestTemplate restTemplate;

    public RestTemplate get() {
        if (restTemplate == null) {
            try {
                restTemplate = RestTemplateBuilder.build();

                final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
                interceptors.add(basicAuthInterceptor);
                restTemplate.setInterceptors(interceptors);
            } catch (Exception e) {
                throw new RestClientConfigurationException(e);
            }
        }
        return restTemplate;
    }
}
