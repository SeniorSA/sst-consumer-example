package br.com.senior.employee.consumer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

@Singleton
@Component
public class ApplicationProperties {

    @Value("${platform.url}")
    private String url;
    @Value("${platform.user}")
    private String user;
    @Value("${platform.password}")
    private String password;

    public String getG7Location() {
        return url;
    }

    public String getG7UserName() {
        return user;
    }

    public String getG7Password() {
        return password;
    }
}
