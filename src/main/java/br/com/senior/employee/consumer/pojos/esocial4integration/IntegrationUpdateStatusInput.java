package br.com.senior.employee.consumer.pojos.esocial4integration;

public class IntegrationUpdateStatusInput {

    /**
     * Id da integração.
     */
    public String integrationId; //NOSONAR
    /**
     * Status da integração.
     */
    public ProviderStatusType statusType; //NOSONAR
    /**
     * Mensagem de erro.
     */
    public String errorMessage; //NOSONAR

    public IntegrationUpdateStatusInput() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public IntegrationUpdateStatusInput(String integrationId, ProviderStatusType statusType, String errorMessage) {
        this.integrationId = integrationId;
        this.statusType = statusType;
        this.errorMessage = errorMessage;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public IntegrationUpdateStatusInput(String integrationId, ProviderStatusType statusType) {
        this.integrationId = integrationId;
        this.statusType = statusType;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (integrationId != null) {
            ret = 31 * ret + integrationId.hashCode();
        }
        if (statusType != null) {
            ret = 31 * ret + statusType.hashCode();
        }
        if (errorMessage != null) {
            ret = 31 * ret + errorMessage.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntegrationUpdateStatusInput)) {
            return false;
        }
        IntegrationUpdateStatusInput other = (IntegrationUpdateStatusInput) obj;
        if ((integrationId == null) != (other.integrationId == null)) {
            return false;
        }
        if ((integrationId != null) && !integrationId.equals(other.integrationId)) {
            return false;
        }
        if ((statusType == null) != (other.statusType == null)) {
            return false;
        }
        if ((statusType != null) && !statusType.equals(other.statusType)) {
            return false;
        }
        if ((errorMessage == null) != (other.errorMessage == null)) {
            return false;
        }
        if ((errorMessage != null) && !errorMessage.equals(other.errorMessage)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("integrationId=").append(integrationId == null ? "null" : integrationId).append(", ");
        sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
        sb.append("errorMessage=").append(errorMessage == null ? "null" : errorMessage);
        sb.append(']');
        return sb.toString();
    }

}
