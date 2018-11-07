package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.Credential;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.client.authentication.LoginInput;
import br.com.senior.employee.consumer.client.authentication.LoginOutput;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Component
@Singleton
public class Auth {

    @Autowired
    private Gson gson;
    @Autowired
    private ApplicationProperties applicationProperties;
    private Map<String, LoginDTO> cachedLogins = new HashMap<>();

    public String getToken(Credential credential) {
        LoginDTO cachedLogin = cachedLogins.get(credential.username);

        if (cachedLogin != null) {
            Long secondsToExpirate = Long.valueOf(cachedLogin.expires_in);

            if (secondsToExpirate != null && secondsToExpirate > LocalTime.now().toSecondOfDay())
                return cachedLogin.access_token;
        }
        try {
            LoginInput loginInput = new LoginInput();
            loginInput.username = credential.username;
            loginInput.password = credential.password;

            LoginOutput output = requestAuth(loginInput);

            LoginDTO loginDTO = gson.fromJson(output.jsonToken, LoginDTO.class);
            cachedLogins.put(credential.username, loginDTO);

            return loginDTO.access_token;
        } catch (Exception e) {
            LOGGER.error("Não foi possível obter token de " + credential.username, e);
        }
        return "";
    }

    private LoginOutput requestAuth(LoginInput loginInput) {
        return RestTemplateBuilder.build().postForObject(applicationProperties.getG7Location() + "/platform/authentication/actions/login", loginInput, LoginOutput.class);
    }
}
