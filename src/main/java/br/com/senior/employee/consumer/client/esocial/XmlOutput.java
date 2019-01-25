package br.com.senior.employee.consumer.client.esocial;

import java.util.Objects;

/**
 * Retorno do xml para o terceiro.
 */
public class XmlOutput {
    
    /**
     * Id unico do XML.
     */
    public String xmlId;
    /**
     * Status do XML.
     */
    public XmlStatusType xmlStatus;
    /**
     * Id do evento do esocial.
     */
    public String esocialEventId;
    /**
     * Tipo de layout.
     */
    public LayoutType esocialLayoutType;
    /**
     * Status do retorno do governo.
     */
    public StatusType esocialReturnType;
    /**
     * Número do recibo retornado pelo governo.
     */
    public String esocialReceiptNumber;
    /**
     * Mensagem de retorno.
     */
    public String message;

    /**
     * Id do xml no prestador.
     */
    public String xmlProviderId;

    /**
     * Tipo de inscrição da empresa.
     */
    public SubscriptionType subscriptionType;

    /**
     * Numero de inscrição da empresa.
     */
    public String subscriptionNumber;

    /**
     * Id da empresa no prestador SST.
     */
    public String companyProviderId;
    
    public XmlOutput() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public XmlOutput(String xmlId, XmlStatusType xmlStatus, String esocialEventId, LayoutType esocialLayoutType, StatusType esocialReturnType, String esocialReceiptNumber, String message, String xmlProviderId, SubscriptionType subscriptionType, String subscriptionNumber, String companyProviderId) {
        this.xmlId = xmlId;
        this.xmlStatus = xmlStatus;
        this.esocialEventId = esocialEventId;
        this.esocialLayoutType = esocialLayoutType;
        this.esocialReturnType = esocialReturnType;
        this.esocialReceiptNumber = esocialReceiptNumber;
        this.message = message;
        this.xmlProviderId = xmlProviderId;
        this.subscriptionType = subscriptionType;
        this.subscriptionNumber = subscriptionNumber;
        this.companyProviderId = companyProviderId;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public XmlOutput(String xmlId, XmlStatusType xmlStatus, String message) {
        this.xmlId = xmlId;
        this.xmlStatus = xmlStatus;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlOutput xmlOutput = (XmlOutput) o;
        return Objects.equals(xmlId, xmlOutput.xmlId) &&
                xmlStatus == xmlOutput.xmlStatus &&
                Objects.equals(esocialEventId, xmlOutput.esocialEventId) &&
                esocialLayoutType == xmlOutput.esocialLayoutType &&
                esocialReturnType == xmlOutput.esocialReturnType &&
                Objects.equals(esocialReceiptNumber, xmlOutput.esocialReceiptNumber) &&
                Objects.equals(message, xmlOutput.message) &&
                Objects.equals(xmlProviderId, xmlOutput.xmlProviderId) &&
                subscriptionType == xmlOutput.subscriptionType &&
                Objects.equals(subscriptionNumber, xmlOutput.subscriptionNumber) &&
                Objects.equals(companyProviderId, xmlOutput.companyProviderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xmlId, xmlStatus, esocialEventId, esocialLayoutType, esocialReturnType, esocialReceiptNumber, message, xmlProviderId, subscriptionType, subscriptionNumber, companyProviderId);
    }

    @Override
    public String toString() {
        return "XmlOutput{" +
                "xmlId='" + xmlId + '\'' +
                ", xmlStatus=" + xmlStatus +
                ", esocialEventId='" + esocialEventId + '\'' +
                ", esocialLayoutType=" + esocialLayoutType +
                ", esocialReturnType=" + esocialReturnType +
                ", esocialReceiptNumber='" + esocialReceiptNumber + '\'' +
                ", message='" + message + '\'' +
                ", xmlProviderId='" + xmlProviderId + '\'' +
                ", subscriptionType=" + subscriptionType +
                ", subscriptionNumber='" + subscriptionNumber + '\'' +
                ", companyProviderId='" + companyProviderId + '\'' +
                '}';
    }
}
