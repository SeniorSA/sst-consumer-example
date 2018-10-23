package br.com.senior.employee.consumer.pojos.esocial;

public class LayoutSituationEventPayload {

    /**
     * Id do layout e-Social.
     */
    public String layoutId; //NOSONAR
    /**
     * Número do recibo.
     */
    public String receiptNumber; //NOSONAR
    /**
     * Mensagens de críticas / erros.
     */
    public String message; //NOSONAR
    /**
     * Tipo da publicação do evento.
     */
    public LayoutSituationEventType eventType; //NOSONAR

    public LayoutSituationEventPayload() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LayoutSituationEventPayload(String layoutId, String receiptNumber, String message, LayoutSituationEventType eventType) {
        this.layoutId = layoutId;
        this.receiptNumber = receiptNumber;
        this.message = message;
        this.eventType = eventType;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public LayoutSituationEventPayload(String layoutId, String receiptNumber, LayoutSituationEventType eventType) {
        this.layoutId = layoutId;
        this.receiptNumber = receiptNumber;
        this.eventType = eventType;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (layoutId != null) {
            ret = 31 * ret + layoutId.hashCode();
        }
        if (receiptNumber != null) {
            ret = 31 * ret + receiptNumber.hashCode();
        }
        if (message != null) {
            ret = 31 * ret + message.hashCode();
        }
        if (eventType != null) {
            ret = 31 * ret + eventType.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LayoutSituationEventPayload)) {
            return false;
        }
        LayoutSituationEventPayload other = (LayoutSituationEventPayload) obj;
        if ((layoutId == null) != (other.layoutId == null)) {
            return false;
        }
        if ((layoutId != null) && !layoutId.equals(other.layoutId)) {
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
        if ((eventType == null) != (other.eventType == null)) {
            return false;
        }
        if ((eventType != null) && !eventType.equals(other.eventType)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("layoutId=").append(layoutId == null ? "null" : layoutId).append(", ");
        sb.append("receiptNumber=").append(receiptNumber == null ? "null" : receiptNumber).append(", ");
        sb.append("message=").append(message == null ? "null" : message).append(", ");
        sb.append("eventType=").append(eventType == null ? "null" : eventType);
        sb.append(']');
        return sb.toString();
    }

}
