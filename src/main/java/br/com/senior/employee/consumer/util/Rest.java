package br.com.senior.employee.consumer.util;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class Rest {

    private RestTemplate restTemplate;

    public RestTemplate get() {
        if (restTemplate != null) return restTemplate;

        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new BasicAuthInterceptor());
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }
}
