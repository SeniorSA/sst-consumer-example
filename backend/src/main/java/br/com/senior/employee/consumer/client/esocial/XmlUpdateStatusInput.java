package br.com.senior.employee.consumer.client.esocial;

import java.util.Map;

public class XmlUpdateStatusInput {
    
    /**
     * Id do ProviderXml.
     */
    public String xmlId;
    /**
     * Status do provedor.
     */
    public ProviderStatusType providerStatusType;
    
    public XmlUpdateStatusInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public XmlUpdateStatusInput(String xmlId, ProviderStatusType providerStatusType) {
        this.xmlId = xmlId;
        this.providerStatusType = providerStatusType;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (xmlId != null) {
            ret = 31 * ret + xmlId.hashCode();
        }
        if (providerStatusType != null) {
            ret = 31 * ret + providerStatusType.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XmlUpdateStatusInput)) {
            return false;
        }
        XmlUpdateStatusInput other = (XmlUpdateStatusInput) obj;
        if ((xmlId == null) != (other.xmlId == null)) {
            return false;
        }
        if ((xmlId != null) && !xmlId.equals(other.xmlId)) {
            return false;
        }
        if ((providerStatusType == null) != (other.providerStatusType == null)) {
            return false;
        }
        if ((providerStatusType != null) && !providerStatusType.equals(other.providerStatusType)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("xmlId=").append(xmlId == null ? "null" : xmlId).append(", ");
    	sb.append("providerStatusType=").append(providerStatusType == null ? "null" : providerStatusType);
    	sb.append(']');
    	return sb.toString();
    }
    
}
