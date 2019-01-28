package br.com.senior.employee.consumer.client.authentication;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Credential {

    public String username;
    public String password;

    public static Credential fromUser(String user) {
        return new Credential(user, null);
    }
}
