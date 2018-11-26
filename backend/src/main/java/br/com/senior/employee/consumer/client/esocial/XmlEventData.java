package br.com.senior.employee.consumer.client.esocial;

import java.util.Map;

public class XmlEventData {
    
    /**
     * Id do layout e-Social.
     */
    public String idXml;
    /**
     * Status do xml.
     */
    public XmlStatusType xmlStatusType;
    /**
     * Id do evento.
     */
    public String idEsocialEvent;
    /**
     * Layout do evento.
     */
    public LayoutType layoutType;
    /**
     * Tipo do status para o layout.
     */
    public StatusType statusType;
    /**
     * Número do recibo.
     */
    public String receiptNumber;
    /**
     * Mensagem.
     */
    public String message;
    
    public XmlEventData() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public XmlEventData(String idXml, XmlStatusType xmlStatusType, String idEsocialEvent, LayoutType layoutType, StatusType statusType, String receiptNumber, String message) {
        this.idXml = idXml;
        this.xmlStatusType = xmlStatusType;
        this.idEsocialEvent = idEsocialEvent;
        this.layoutType = layoutType;
        this.statusType = statusType;
        this.receiptNumber = receiptNumber;
        this.message = message;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (idXml != null) {
            ret = 31 * ret + idXml.hashCode();
        }
        if (xmlStatusType != null) {
            ret = 31 * ret + xmlStatusType.hashCode();
        }
        if (idEsocialEvent != null) {
            ret = 31 * ret + idEsocialEvent.hashCode();
        }
        if (layoutType != null) {
            ret = 31 * ret + layoutType.hashCode();
        }
        if (statusType != null) {
            ret = 31 * ret + statusType.hashCode();
        }
        if (receiptNumber != null) {
            ret = 31 * ret + receiptNumber.hashCode();
        }
        if (message != null) {
            ret = 31 * ret + message.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XmlEventData)) {
            return false;
        }
        XmlEventData other = (XmlEventData) obj;
        if ((idXml == null) != (other.idXml == null)) {
            return false;
        }
        if ((idXml != null) && !idXml.equals(other.idXml)) {
            return false;
        }
        if ((xmlStatusType == null) != (other.xmlStatusType == null)) {
            return false;
        }
        if ((xmlStatusType != null) && !xmlStatusType.equals(other.xmlStatusType)) {
            return false;
        }
        if ((idEsocialEvent == null) != (other.idEsocialEvent == null)) {
            return false;
        }
        if ((idEsocialEvent != null) && !idEsocialEvent.equals(other.idEsocialEvent)) {
            return false;
        }
        if ((layoutType == null) != (other.layoutType == null)) {
            return false;
        }
        if ((layoutType != null) && !layoutType.equals(other.layoutType)) {
            return false;
        }
        if ((statusType == null) != (other.statusType == null)) {
            return false;
        }
        if ((statusType != null) && !statusType.equals(other.statusType)) {
            return false;
        }
        if ((receiptNumber == null) != (other.receiptNumber == null)) {
            return false;
        }
        if ((receiptNumber != null) && !receiptNumber.equals(other.receiptNumber)) {
            return false;
        }
        if ((message == null) != (other.message == null)) {
            return false;
        }
        if ((message != null) && !message.equals(other.message)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getClass().getSimpleName()).append(" [");
    	sb.append("idXml=").append(idXml == null ? "null" : idXml).append(", ");
    	sb.append("xmlStatusType=").append(xmlStatusType == null ? "null" : xmlStatusType).append(", ");
    	sb.append("idEsocialEvent=").append(idEsocialEvent == null ? "null" : idEsocialEvent).append(", ");
    	sb.append("layoutType=").append(layoutType == null ? "null" : layoutType).append(", ");
    	sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
    	sb.append("receiptNumber=").append(receiptNumber == null ? "null" : receiptNumber).append(", ");
    	sb.append("message=").append(message == null ? "null" : message);
    	sb.append(']');
    	return sb.toString();
    }
    
}
