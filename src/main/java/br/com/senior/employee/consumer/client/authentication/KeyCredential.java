package br.com.senior.employee.consumer.client.authentication;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class KeyCredential {

    public String accessKey;
    public String secret;
    public String tenantName;
    public String scope;

    public KeyCredential(String accessKey, String secret, String tenantName) {
        this.accessKey = accessKey;
        this.secret = secret;
        this.tenantName = tenantName;
    }

    public static KeyCredential getKeyCredentialFromAccessKey(String accessKey) {
        return new KeyCredential(accessKey, null, null);
    }
}
