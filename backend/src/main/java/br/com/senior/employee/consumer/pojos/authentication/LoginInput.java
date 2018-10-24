package br.com.senior.employee.consumer.pojos.authentication;

import java.util.ArrayList;
import java.util.List;

public class LoginInput {

    /**
     * Nome do usuário incluindo o domínio. Exemplo: ana.silva@senior.com.br.
     * Este campo deve ser informado se o login for baseado em um usuário e senha.
     */
    public String username; //NOSONAR
    /**
     * Senha do usuário. Este campo deve ser informado se o login for baseado em um usuário e senha.
     */
    public String password; //NOSONAR
    /**
     * Código de autorização do provedor externo de autenticação. Provedores suportados: SAML.
     * Este campo deve ser informado se o login for baseado em um código de autorização.
     */
    public String code; //NOSONAR
    /**
     * Escopo do token da autenticação. Opcional, se não for informado será usado o valor padrão 'desktop'
     */
    public String scope; //NOSONAR

    public LoginInput() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LoginInput(String username, String password, String code, String scope) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.scope = scope;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (username != null) {
            ret = 31 * ret + username.hashCode();
        }
        if (password != null) {
            ret = 31 * ret + password.hashCode();
        }
        if (code != null) {
            ret = 31 * ret + code.hashCode();
        }
        if (scope != null) {
            ret = 31 * ret + scope.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginInput)) {
            return false;
        }
        LoginInput other = (LoginInput) obj;
        if ((username == null) != (other.username == null)) {
            return false;
        }
        if ((username != null) && !username.equals(other.username)) {
            return false;
        }
        if ((password == null) != (other.password == null)) {
            return false;
        }
        if ((password != null) && !password.equals(other.password)) {
            return false;
        }
        if ((code == null) != (other.code == null)) {
            return false;
        }
        if ((code != null) && !code.equals(other.code)) {
            return false;
        }
        if ((scope == null) != (other.scope == null)) {
            return false;
        }
        if ((scope != null) && !scope.equals(other.scope)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, new ArrayList<>());
        return sb.toString();
    }

    void toString(StringBuilder sb, List<Object> appended) {
        sb.append(getClass().getSimpleName()).append(" [");
        if (appended.contains(this)) {
            sb.append("<Previously appended object>").append(']');
            return;
        }
        appended.add(this);
        sb.append("username=").append(username == null ? "null" : username).append(", ");
        sb.append("password=").append(password == null ? "null" : password).append(", ");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("scope=").append(scope == null ? "null" : scope);
        sb.append(']');
    }

}
