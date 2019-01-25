package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.Credential;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Collections;

@AllArgsConstructor
public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    private Auth auth;
    private Credential credential;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        request.getHeaders().add("Authorization", "Bearer " + auth.getToken(credential));
        return execution.execute(request, body);
    }
}
