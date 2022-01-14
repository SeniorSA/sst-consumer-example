package br.com.senior.employee.consumer.rest;

import br.com.senior.employee.consumer.client.authentication.*;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
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

    public String getKeyToken(KeyCredential credential) {
        LoginDTO cachedLogin = cachedLogins.get(credential.accessKey);
        if (cachedLogin != null) {
            LocalDate lastLogin = cachedLogin.loggedIn.atZone(ZoneOffset.UTC).toLocalDate();
            LocalDate today = Instant.now().atZone(ZoneOffset.UTC).toLocalDate();
            // Forçamos o reset do token a cada 7 dias.
            if (lastLogin != null && lastLogin.plusDays(7).isAfter(today))
                return cachedLogin.access_token;
        }
        try {
            KeyLoginInput accessTokenRequest = new KeyLoginInput();
            accessTokenRequest.accessKey = credential.accessKey;
            accessTokenRequest.secret = credential.secret;
            accessTokenRequest.tenantName = credential.tenantName;

            KeyLoginOutput accessTokenResponse = requestKeyAuth(accessTokenRequest);

            LoginDTO tokenResponse = gson.fromJson(accessTokenResponse.jsonToken, LoginDTO.class);
            tokenResponse.loggedIn = Instant.now();
            cachedLogins.put(credential.accessKey, tokenResponse);
            return tokenResponse.access_token;
        } catch (Exception e) {
            LOGGER.error("Não foi possível obter o token de " + credential.tenantName, e);
        }
        return "";
    }

    private KeyLoginOutput requestKeyAuth(KeyLoginInput keyLoginInput) {
        return RestTemplateBuilder.build().postForObject(applicationProperties.getG7AnonymousLocation() + "/platform/authentication/actions/loginWithKey", keyLoginInput, KeyLoginOutput.class);
    }

    public void removeLoginFromCache(KeyCredential credential){
        cachedLogins.remove(credential.accessKey);
    }
}
