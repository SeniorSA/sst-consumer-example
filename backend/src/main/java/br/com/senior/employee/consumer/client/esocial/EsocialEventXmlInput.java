package br.com.senior.employee.consumer.client.esocial;

import java.util.Map;

public class EsocialEventXmlInput {
    
    /**
     * Identificador unico do xml.
     */
    public String xmlId;
    /**
     * Xml.
     */
    public String xml;
    
    public EsocialEventXmlInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public EsocialEventXmlInput(String xmlId, String xml) {
        this.xmlId = xmlId;
        this.xml = xml;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (xmlId != null) {
            ret = 31 * ret + xmlId.hashCode();
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
        if (!(obj instanceof EsocialEventXmlInput)) {
            return false;
        }
        EsocialEventXmlInput other = (EsocialEventXmlInput) obj;
        if ((xmlId == null) != (other.xmlId == null)) {
            return false;
        }
        if ((xmlId != null) && !xmlId.equals(other.xmlId)) {
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
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("xmlId=").append(xmlId == null ? "null" : xmlId).append(", ");
    	sb.append("xml=").append(xml == null ? "null" : xml);
    	sb.append(']');
    	return sb.toString();
    }
}
