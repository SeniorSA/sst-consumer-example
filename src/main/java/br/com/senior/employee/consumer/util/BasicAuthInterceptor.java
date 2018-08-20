package br.com.senior.employee.consumer.util;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Collections;

public class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    private Auth auth = new Auth();

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        request.getHeaders().add("Authorization", "Bearer " + auth.getAuth());
        return execution.execute(request, body);
    }
}
