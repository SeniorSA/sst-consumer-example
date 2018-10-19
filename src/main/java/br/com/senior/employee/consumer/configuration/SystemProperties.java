package br.com.senior.employee.consumer.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SystemProperties {

    private static final String URL = "https://pcbnu002050.interno.senior.com.br:8243/t/senior.com.br/bridge/1.0/rest";
    private static final String USER = "admin@boeing.com.br";
    private static final String PASS = "Senha1!";

    public static String getG7Location() {
        return URL;
    }

    public static String getG7UserName() {
        return USER;
    }

    public static String getG7Password() {
        return PASS;
    }
}
