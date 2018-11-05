package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.client.authentication.LoginInput;
import br.com.senior.employee.consumer.client.authentication.LoginOutput;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.time.LocalTime;

@Component
@Singleton
public class Auth {

    @Autowired
    private Gson gson;
    @Autowired
    private ApplicationProperties applicationProperties;
    private Long secondsToExpirate;
    private String loginPass;

    public String getAuth() {
        if (secondsToExpirate != null && secondsToExpirate > LocalTime.now().toSecondOfDay()) return loginPass;

        LoginInput loginInput = new LoginInput();
        loginInput.username = applicationProperties.getG7UserName();
        loginInput.password = applicationProperties.getG7Password();

        LoginOutput output = RestTemplateBuilder.build().postForObject(applicationProperties.getG7Location() + "/platform/authentication/actions/login", loginInput, LoginOutput.class);

        LoginDTO loginDTO = gson.fromJson(output.jsonToken, LoginDTO.class);
        secondsToExpirate = Long.valueOf(loginDTO.expires_in); // tempo em segundos
        loginPass = loginDTO.access_token;

        return loginPass;
    }
}
