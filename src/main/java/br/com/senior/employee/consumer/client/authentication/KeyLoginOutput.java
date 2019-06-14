package br.com.senior.employee.consumer.client.authentication;

import java.util.Objects;

public class KeyLoginOutput {

    /**
     * <code>String</code> contendo um <code>JSON</code> com o token de acesso e tempo de validade do token de acesso.
     */
    public String jsonToken; //NOSONAR

    public KeyLoginOutput() {}

    public KeyLoginOutput(String jsonToken) {
        this.jsonToken = jsonToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyLoginOutput that = (KeyLoginOutput) o;
        return Objects.equals(jsonToken, that.jsonToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonToken);
    }

    @Override
    public String toString() {
        return "KeyLoginOutput{" +
                "jsonToken='" + jsonToken + '\'' +
                '}';
    }
}
