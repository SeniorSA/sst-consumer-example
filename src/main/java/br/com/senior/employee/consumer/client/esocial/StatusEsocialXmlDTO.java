package br.com.senior.employee.consumer.client.esocial;

public class StatusEsocialXmlDTO {

    /**
     * Identificador do registro na plataforma senior X.
     */
    public String id;
    /**
     * Identificador do XML no prestador SST
     */
    public String providerXmlId;
    /**
     * Status do evento do eSocial
     */
    public XmlStatusType xmlStatus;
    /**
     * Mensagem referente a validação do evento.
     */
    public String validationMessage;
    /**
     * ID do evento do eSocial
     */
    public String eventId;
    /**
     * Tipo de retorno do governo
     */
    public GovernmentReturnType governmentReturnType;
    /**
     * Número do recibo retornado do governo.
     */
    public String governmentReceiptNumber;
    /**
     * Mensagens ou críticas retornadas do governo
     */
    public String governmentMessage;
    /**
     * Retorno do governo
     */
    public String rawGovernmentReturn;
    /**
     * Código de identificação da empresa no prestador SST
     */
    public String providerCompanyId;

    public StatusEsocialXmlDTO() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public StatusEsocialXmlDTO(String id, String providerXmlId, XmlStatusType xmlStatus, String validationMessage, String eventId, GovernmentReturnType governmentReturnType, String governmentReceiptNumber, String governmentMessage, String rawGovernmentReturn) {
        this.id = id;
        this.providerXmlId = providerXmlId;
        this.xmlStatus = xmlStatus;
        this.validationMessage = validationMessage;
        this.eventId = eventId;
        this.governmentReturnType = governmentReturnType;
        this.governmentReceiptNumber = governmentReceiptNumber;
        this.governmentMessage = governmentMessage;
        this.rawGovernmentReturn = rawGovernmentReturn;
    }
    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public StatusEsocialXmlDTO(String id, String providerXmlId, XmlStatusType xmlStatus) {
        this.id = id;
        this.providerXmlId = providerXmlId;
        this.xmlStatus = xmlStatus;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        if (providerXmlId != null) {
            ret = 31 * ret + providerXmlId.hashCode();
        }
        if (xmlStatus != null) {
            ret = 31 * ret + xmlStatus.hashCode();
        }
        if (validationMessage != null) {
            ret = 31 * ret + validationMessage.hashCode();
        }
        if (eventId != null) {
            ret = 31 * ret + eventId.hashCode();
        }
        if (governmentReturnType != null) {
            ret = 31 * ret + governmentReturnType.hashCode();
        }
        if (governmentReceiptNumber != null) {
            ret = 31 * ret + governmentReceiptNumber.hashCode();
        }
        if (governmentMessage != null) {
            ret = 31 * ret + governmentMessage.hashCode();
        }
        if (rawGovernmentReturn != null) {
            ret = 31 * ret + rawGovernmentReturn.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusEsocialXmlDTO)) {
            return false;
        }
        StatusEsocialXmlDTO other = (StatusEsocialXmlDTO) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((providerXmlId == null) != (other.providerXmlId == null)) {
            return false;
        }
        if ((providerXmlId != null) && !providerXmlId.equals(other.providerXmlId)) {
            return false;
        }
        if ((xmlStatus == null) != (other.xmlStatus == null)) {
            return false;
        }
        if ((xmlStatus != null) && !xmlStatus.equals(other.xmlStatus)) {
            return false;
        }
        if ((validationMessage == null) != (other.validationMessage == null)) {
            return false;
        }
        if ((validationMessage != null) && !validationMessage.equals(other.validationMessage)) {
            return false;
        }
        if ((eventId == null) != (other.eventId == null)) {
            return false;
        }
        if ((eventId != null) && !eventId.equals(other.eventId)) {
            return false;
        }
        if ((governmentReturnType == null) != (other.governmentReturnType == null)) {
            return false;
        }
        if ((governmentReturnType != null) && !governmentReturnType.equals(other.governmentReturnType)) {
            return false;
        }
        if ((governmentReceiptNumber == null) != (other.governmentReceiptNumber == null)) {
            return false;
        }
        if ((governmentReceiptNumber != null) && !governmentReceiptNumber.equals(other.governmentReceiptNumber)) {
            return false;
        }
        if ((governmentMessage == null) != (other.governmentMessage == null)) {
            return false;
        }
        if ((governmentMessage != null) && !governmentMessage.equals(other.governmentMessage)) {
            return false;
        }
        if ((rawGovernmentReturn == null) != (other.rawGovernmentReturn == null)) {
            return false;
        }
        if ((rawGovernmentReturn != null) && !rawGovernmentReturn.equals(other.rawGovernmentReturn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("providerXmlId=").append(providerXmlId == null ? "null" : providerXmlId).append(", ");
        sb.append("xmlStatus=").append(xmlStatus == null ? "null" : xmlStatus).append(", ");
        sb.append("message=").append(validationMessage == null ? "null" : validationMessage).append(", ");
        sb.append("eventId=").append(eventId == null ? "null" : eventId).append(", ");
        sb.append("governmentReturnType=").append(governmentReturnType == null ? "null" : governmentReturnType).append(", ");
        sb.append("governmentReceiptNumber=").append(governmentReceiptNumber == null ? "null" : governmentReceiptNumber).append(", ");
        sb.append("governmentMessage=").append(governmentMessage == null ? "null" : governmentMessage).append(", ");
        sb.append("rawGovernmentReturn=").append(rawGovernmentReturn == null ? "null" : rawGovernmentReturn);
        sb.append(']');
        return sb.toString();
    }

}
