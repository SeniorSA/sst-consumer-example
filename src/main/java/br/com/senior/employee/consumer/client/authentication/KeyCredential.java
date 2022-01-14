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
    public String codigoEmpresa;

    public KeyCredential(String accessKey, String secret, String tenantName, String codigoEmpresa) {
        this.accessKey = accessKey == null ? accessKey : accessKey.trim();
        this.secret = secret == null ? secret : secret.trim();
        this.tenantName = tenantName == null ? tenantName : tenantName.trim();
        this.codigoEmpresa = codigoEmpresa == null ? codigoEmpresa : codigoEmpresa.trim();
    }

    public static KeyCredential getKeyCredentialFromAccessKey(String accessKey) {
        return new KeyCredential(accessKey, null, null, null);
    }

    public static KeyCredential getKeyCredentialFromAccessKey(String accessKey, String providerCompanyIdentification) {
        return new KeyCredential(accessKey, null, null, providerCompanyIdentification);
    }
}
