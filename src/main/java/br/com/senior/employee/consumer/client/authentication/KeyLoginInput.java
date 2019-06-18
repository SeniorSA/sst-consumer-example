package br.com.senior.employee.consumer.client.authentication;

import java.util.Objects;

public class KeyLoginInput {

    /**
     * Chave da aplicação.
     */
    public String accessKey; //NOSONAR

    /**
     * Segredo da chave informada.
     */
    public String secret; //NOSONAR

    /**
     * Nome do tenant em que se deseja efetuar o login.
     */
    public String tenantName; //NOSONAR

    /**
     * Escopo do token da autenticação. Opcional, se não for informado será usado o valor padrão 'desktop'.
     */
    public String scope; //NOSONAR

    public KeyLoginInput() {}

    public KeyLoginInput(String accessKey, String secret, String tenantName, String scope) {
        this.accessKey = accessKey;
        this.secret = secret;
        this.tenantName = tenantName;
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyLoginInput that = (KeyLoginInput) o;
        return Objects.equals(accessKey, that.accessKey) &&
                Objects.equals(secret, that.secret) &&
                Objects.equals(tenantName, that.tenantName) &&
                Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessKey, secret, tenantName, scope);
    }

    @Override
    public String toString() {
        return "KeyLoginInput{" +
                "accessKey='" + accessKey + '\'' +
                ", secret='" + secret + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
