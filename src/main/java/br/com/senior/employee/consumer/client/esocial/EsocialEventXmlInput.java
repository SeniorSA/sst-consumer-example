package br.com.senior.employee.consumer.client.esocial;

public class EsocialEventXmlInput {
    
    /**
     * Id do xml no prestador
     */
    public String providerXmlId;
    /**
     * Xml.
     */
    public String xml;
    /**
     * Id da empresa no prestador SST.
     */
    public String providerCompanyId;
    /**
     * Tipo de inscrição.
     */
    public SubscriptionType subscriptionType;
    /**
     * Numero de incrição.
     */
    public String subscriptionNumber;
    
    public EsocialEventXmlInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public EsocialEventXmlInput(String providerXmlId, String xml, String providerCompanyId, SubscriptionType subscriptionType, String subscriptionNumber) {
        this.providerXmlId = providerXmlId;
        this.xml = xml;
        this.providerCompanyId = providerCompanyId;
        this.subscriptionType = subscriptionType;
        this.subscriptionNumber = subscriptionNumber;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public EsocialEventXmlInput(String xml) {
        this.xml = xml;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (providerXmlId != null) {
            ret = 31 * ret + providerXmlId.hashCode();
        }
        if (xml != null) {
            ret = 31 * ret + xml.hashCode();
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
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EsocialEventXmlInput)) {
            return false;
        }
        EsocialEventXmlInput other = (EsocialEventXmlInput) obj;
        if ((providerXmlId == null) != (other.providerXmlId == null)) {
            return false;
        }
        if ((providerXmlId != null) && !providerXmlId.equals(other.providerXmlId)) {
            return false;
        }
        if ((xml == null) != (other.xml == null)) {
            return false;
        }
        if ((xml != null) && !xml.equals(other.xml)) {
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
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("providerXmlId=").append(providerXmlId == null ? "null" : providerXmlId).append(", ");
    	sb.append("xml=").append(xml == null ? "null" : xml).append(", ");
    	sb.append("providerCompanyId=").append(providerCompanyId == null ? "null" : providerCompanyId).append(", ");
    	sb.append("subscriptionType=").append(subscriptionType == null ? "null" : subscriptionType).append(", ");
    	sb.append("subscriptionNumber=").append(subscriptionNumber == null ? "null" : subscriptionNumber);
    	sb.append(']');
    	return sb.toString();
    }
    
}
