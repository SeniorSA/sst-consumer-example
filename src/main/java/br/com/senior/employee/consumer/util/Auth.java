package br.com.senior.employee.consumer.util;

import br.com.senior.platform.authentication.LoginInput;
import br.com.senior.platform.authentication.LoginOutput;
import com.google.gson.Gson;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

public class Auth {

    private Long expires;
    private String loginPass;

    public String getAuth() {
        if (expires != null && expires > LocalTime.now().toSecondOfDay()) return loginPass;

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        LoginInput loginInput = new LoginInput();
        loginInput.username = "admin@boeing.com.br";
        loginInput.password = "Senha1!";

        LoginOutput output = restTemplate.postForObject("https://pcbnu002050.interno.senior.com.br:8243/t/senior.com.br/bridge/1.0/rest/platform/authentication/actions/login", loginInput, LoginOutput.class);

        LoginDTO loginDTO = new Gson().fromJson(output.jsonToken, LoginDTO.class);
        expires = Long.valueOf(loginDTO.expires_in); // tempo em segundos
        loginPass = loginDTO.access_token;

        return loginPass;
    }
}
