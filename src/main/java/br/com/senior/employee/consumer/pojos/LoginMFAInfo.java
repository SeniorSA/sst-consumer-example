package br.com.senior.employee.consumer.pojos;

import java.util.ArrayList;
import java.util.List;

public class LoginMFAInfo {

    /**
     * Token temporário gerado quando o usuário possui autenticação multifator habilitada.
     */
    public String temporaryToken;
    /**
     * Status da configuração da autenticação multifator por parte do usuário. Se for UNCONFIGURED ou RESETTED, deverá ser chamado a primitiva que envia um e-mail com as instruções para a configuração do MFA.
     */
    public UserOTPAuthStatusDTO mfaStatus;
    /**
     * Nome do tenant
     */
    public String tenant;

    public LoginMFAInfo() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LoginMFAInfo(String temporaryToken, UserOTPAuthStatusDTO mfaStatus, String tenant) {
        this.temporaryToken = temporaryToken;
        this.mfaStatus = mfaStatus;
        this.tenant = tenant;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (temporaryToken != null) {
            ret = 31 * ret + temporaryToken.hashCode();
        }
        if (mfaStatus != null) {
            ret = 31 * ret + mfaStatus.hashCode();
        }
        if (tenant != null) {
            ret = 31 * ret + tenant.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginMFAInfo)) {
            return false;
        }
        LoginMFAInfo other = (LoginMFAInfo) obj;
        if ((temporaryToken == null) != (other.temporaryToken == null)) {
            return false;
        }
        if ((temporaryToken != null) && !temporaryToken.equals(other.temporaryToken)) {
            return false;
        }
        if ((mfaStatus == null) != (other.mfaStatus == null)) {
            return false;
        }
        if ((mfaStatus != null) && !mfaStatus.equals(other.mfaStatus)) {
            return false;
        }
        if ((tenant == null) != (other.tenant == null)) {
            return false;
        }
        if ((tenant != null) && !tenant.equals(other.tenant)) {
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
        sb.append("temporaryToken=").append(temporaryToken == null ? "null" : temporaryToken).append(", ");
        sb.append("mfaStatus=").append(mfaStatus == null ? "null" : mfaStatus).append(", ");
        sb.append("tenant=").append(tenant == null ? "null" : tenant);
        sb.append(']');
    }

}
