package br.com.senior.employee.consumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    private Auth auth;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        request.getHeaders().add("Authorization", "Bearer " + auth.getAuth());
        return execution.execute(request, body);
    }
}
