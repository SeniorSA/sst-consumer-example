package br.com.senior.employee.consumer.pojos;

import java.util.ArrayList;
import java.util.List;

public class ResetPasswordInfo {

    /**
     * Token temporário gerado quando o usuário precisa alterar a senha
     */
    public String temporaryToken;
    /**
     * Nome do tenant
     */
    public String tenant;

    public ResetPasswordInfo() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public ResetPasswordInfo(String temporaryToken, String tenant) {
        this.temporaryToken = temporaryToken;
        this.tenant = tenant;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (temporaryToken != null) {
            ret = 31 * ret + temporaryToken.hashCode();
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
        if (!(obj instanceof ResetPasswordInfo)) {
            return false;
        }
        ResetPasswordInfo other = (ResetPasswordInfo) obj;
        if ((temporaryToken == null) != (other.temporaryToken == null)) {
            return false;
        }
        if ((temporaryToken != null) && !temporaryToken.equals(other.temporaryToken)) {
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
        sb.append("tenant=").append(tenant == null ? "null" : tenant);
        sb.append(']');
    }

}
