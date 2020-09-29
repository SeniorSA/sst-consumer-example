package br.com.senior.employee.consumer.client.esocial;

public class StatusEsocialXmlReceivedInput {
    /**
     * Id do ProviderXml.
     */
    public String xmlId;
    /**
     * Id do xml do prestador
     */
    public String providerXmlId;
    /**
     * Status do provedor.
     */
    public ProviderStatusType providerStatusType;
    /**
     * Mensagem de erro retornada pelo provedor SST.
     */
    public String providerErrorMessage;

    public StatusEsocialXmlReceivedInput() {
    }

    public StatusEsocialXmlReceivedInput(String xmlId, ProviderStatusType providerStatusType) {
        this.xmlId = xmlId;
        this.providerStatusType = providerStatusType;
    }

    public StatusEsocialXmlReceivedInput(String xmlId, ProviderStatusType providerStatusType, String providerErrorMessage) {
        this.xmlId = xmlId;
        this.providerStatusType = providerStatusType;
        this.providerErrorMessage = providerErrorMessage;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (xmlId != null) {
            ret = 31 * ret + xmlId.hashCode();
        }
        if (providerXmlId != null) {
            ret = 31 * ret + providerXmlId.hashCode();
        }
        if (providerStatusType != null) {
            ret = 31 * ret + providerStatusType.hashCode();
        }
        if (providerErrorMessage != null) {
            ret = 31 * ret + providerErrorMessage.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusEsocialXmlReceivedInput)) {
            return false;
        }
        StatusEsocialXmlReceivedInput other = (StatusEsocialXmlReceivedInput) obj;
        if ((xmlId == null) != (other.xmlId == null)) {
            return false;
        }
        if ((xmlId != null) && !xmlId.equals(other.xmlId)) {
            return false;
        }
        if ((providerXmlId == null) != (other.providerXmlId == null)) {
            return false;
        }
        if ((providerXmlId != null) && !providerXmlId.equals(other.providerXmlId)) {
            return false;
        }
        if ((providerStatusType == null) != (other.providerStatusType == null)) {
            return false;
        }
        if ((providerStatusType != null) && !providerStatusType.equals(other.providerStatusType)) {
            return false;
        }
        if ((providerErrorMessage == null) != (other.providerErrorMessage == null)) {
            return false;
        }
        if ((providerErrorMessage != null) && !providerErrorMessage.equals(other.providerErrorMessage)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("xmlId=").append(xmlId == null ? "null" : xmlId).append(", ");
        sb.append("providerXmlId=").append(providerXmlId == null ? "null" : providerXmlId).append(", ");
        sb.append("providerStatusType=").append(providerStatusType == null ? "null" : providerStatusType).append(", ");
        sb.append("providerErrorMessage=").append(providerErrorMessage == null ? "null" : providerErrorMessage);
        sb.append(']');
        return sb.toString();
    }

}
