package br.com.senior.employee.consumer.client.esocial;

public class SendEsocialXmlInput {

    /**
     * Identificador do XML no prestador SST
     */
    public String providerXmlId;
    /**
     * Identificador da empresa no prestador SST.
     */
    public String providerCompanyId;
    /**
     * Tipo de inscrição da empresa.
     */
    public SubscriptionType subscriptionType;
    /**
     * Numero de inscrição da empresa.
     */
    public String subscriptionNumber;
    /**
     * XML do evento do eSocial.
     */
    public String xml;

    public SendEsocialXmlInput() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public SendEsocialXmlInput(String providerXmlId, String providerCompanyId, SubscriptionType subscriptionType, String subscriptionNumber, String xml) {
        this.providerXmlId = providerXmlId;
        this.providerCompanyId = providerCompanyId;
        this.subscriptionType = subscriptionType;
        this.subscriptionNumber = subscriptionNumber;
        this.xml = xml;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (providerXmlId != null) {
            ret = 31 * ret + providerXmlId.hashCode();
        }
        if (providerCompanyId != null) {
            ret = 31 * ret + providerCompanyId.hashCode();
        }
        if (subscriptionType != null) {
            ret = 31 * ret + subscriptionType.hashCode();
        }
        if (subscriptionNumber != null) {
            ret = 31 * ret + subscriptionNumber.hashCode();
        }
        if (xml != null) {
            ret = 31 * ret + xml.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendEsocialXmlInput)) {
            return false;
        }
        SendEsocialXmlInput other = (SendEsocialXmlInput) obj;
        if ((providerXmlId == null) != (other.providerXmlId == null)) {
            return false;
        }
        if ((providerXmlId != null) && !providerXmlId.equals(other.providerXmlId)) {
            return false;
        }
        if ((providerCompanyId == null) != (other.providerCompanyId == null)) {
            return false;
        }
        if ((providerCompanyId != null) && !providerCompanyId.equals(other.providerCompanyId)) {
            return false;
        }
        if ((subscriptionType == null) != (other.subscriptionType == null)) {
            return false;
        }
        if ((subscriptionType != null) && !subscriptionType.equals(other.subscriptionType)) {
            return false;
        }
        if ((subscriptionNumber == null) != (other.subscriptionNumber == null)) {
            return false;
        }
        if ((subscriptionNumber != null) && !subscriptionNumber.equals(other.subscriptionNumber)) {
            return false;
        }
        if ((xml == null) != (other.xml == null)) {
            return false;
        }
        if ((xml != null) && !xml.equals(other.xml)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("providerXmlId=").append(providerXmlId == null ? "null" : providerXmlId).append(", ");
        sb.append("providerCompanyId=").append(providerCompanyId == null ? "null" : providerCompanyId).append(", ");
        sb.append("subscriptionType=").append(subscriptionType == null ? "null" : subscriptionType).append(", ");
        sb.append("subscriptionNumber=").append(subscriptionNumber == null ? "null" : subscriptionNumber).append(", ");
        sb.append("xml=").append(xml == null ? "null" : xml);
        return sb.toString();
    }

}
