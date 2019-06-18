package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.KeyCredential;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Collections;

public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    private Auth auth;
    private KeyCredential keyCredential;

    public BasicAuthInterceptor(Auth auth, KeyCredential keyCredential) {
        this.auth = auth;
        this.keyCredential = keyCredential;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        request.getHeaders().add("Authorization", "Bearer " + auth.getKeyToken(keyCredential));
        return execution.execute(request, body);
    }
}
