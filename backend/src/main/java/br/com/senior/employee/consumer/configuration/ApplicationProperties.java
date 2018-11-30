package br.com.senior.employee.consumer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Singleton
@Component
public class ApplicationProperties {

    @Value("${platform.url}")
    private String url;

    public String getG7Location() {
        return url;
    }
}
