package br.com.senior.employee.consumer.pojos;

import java.util.ArrayList;
import java.util.List;

public class LoginOutput {

    /**
     * String contendo um json com os tokens de acesso, de refresh, o tempo de validade restante para o token de acesso e o nome do usuário.
     * Se o usuário/tenant estiver configurado para usar autenticação multifator, esse token não será retornado. Ao invés disso, será retornado um token temporário, dentro do 'mfaInfo', que
     * deverá ser enviado na primitiva loginMFA.
     */
    public String jsonToken;
    /**
     * Informações para realizar o próximo passo da autenticação quando o usuário utiliza autenticação multifator.
     */
    public LoginMFAInfo mfaInfo;
    /**
     * Informações para realizar o próximo passo da autenticação quando o usuário está sinalizado para alterar a senha após se autenticar.
     */
    public ResetPasswordInfo resetPasswordInfo;

    public LoginOutput() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LoginOutput(String jsonToken, LoginMFAInfo mfaInfo, ResetPasswordInfo resetPasswordInfo) {
        this.jsonToken = jsonToken;
        this.mfaInfo = mfaInfo;
        this.resetPasswordInfo = resetPasswordInfo;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (jsonToken != null) {
            ret = 31 * ret + jsonToken.hashCode();
        }
        if (mfaInfo != null) {
            ret = 31 * ret + mfaInfo.hashCode();
        }
        if (resetPasswordInfo != null) {
            ret = 31 * ret + resetPasswordInfo.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginOutput)) {
            return false;
        }
        LoginOutput other = (LoginOutput) obj;
        if ((jsonToken == null) != (other.jsonToken == null)) {
            return false;
        }
        if ((jsonToken != null) && !jsonToken.equals(other.jsonToken)) {
            return false;
        }
        if ((mfaInfo == null) != (other.mfaInfo == null)) {
            return false;
        }
        if ((mfaInfo != null) && !mfaInfo.equals(other.mfaInfo)) {
            return false;
        }
        if ((resetPasswordInfo == null) != (other.resetPasswordInfo == null)) {
            return false;
        }
        if ((resetPasswordInfo != null) && !resetPasswordInfo.equals(other.resetPasswordInfo)) {
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
        sb.append("jsonToken=").append(jsonToken == null ? "null" : jsonToken).append(", ");
        sb.append("mfaInfo=<");
        if (mfaInfo == null) {
            sb.append("null");
        } else {
            mfaInfo.toString(sb, appended);
        }
        sb.append('>').append(", ");
        sb.append("resetPasswordInfo=<");
        if (resetPasswordInfo == null) {
            sb.append("null");
        } else {
            resetPasswordInfo.toString(sb, appended);
        }
        sb.append('>');
        sb.append(']');
    }

}
