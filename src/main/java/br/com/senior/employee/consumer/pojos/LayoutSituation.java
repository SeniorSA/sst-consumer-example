package br.com.senior.employee.consumer.pojos;

import java.util.List;

/**
 * Situação de layout do eSocial.
 */
public class LayoutSituation {

    public static class Id {

        public String id;

        public Id() {
        }

        public Id(String layoutSituationId) {
            this.id = layoutSituationId;
        }

        public String getLayoutSituationId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages;
        public Long totalElements;

        public List<LayoutSituation> contents;

        public PagedResults() {
        }

        public PagedResults(List<LayoutSituation> contents) {
            this.contents = contents;
        }

        public PagedResults(List<LayoutSituation> contents, Long totalPages, Long totalElements) {
            this.contents = contents;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }
    }

    public static class PageRequest {
        public Long offset;
        public Long size;
        public boolean translations;
        public String orderBy;
        public String filter;
        public List<String> displayFields;

        public PageRequest() {
        }

        public PageRequest(Long offset, Long size) {
            this(offset, size, null, null);
        }

        public PageRequest(Long offset, Long size, String orderBy) {
            this(offset, size, orderBy, null);
        }

        public PageRequest(Long offset, Long size, String orderBy, String filter) {
            this(offset, size, orderBy, filter, null);
        }

        public PageRequest(Long offset, Long size, String orderBy, String filter, List<String> displayFields) {
            this.offset = offset;
            this.size = size;
            this.orderBy = orderBy;
            this.filter = filter;
            this.displayFields = displayFields;
        }
    }

    /**
     * Id da entidade.
     */
    public String id;
    /**
     * Identificador do layout.
     */
    public String layoutId;
    /**
     * Identificador do evento.
     */
    public String eventId;
    /**
     * Data e hora do evento.
     */
    public java.time.Instant eventDate;
    /**
     * Tipo do layout.
     */
    public LayoutType layoutType;
    /**
     * Tipo da operação.
     */
    public OperationType operationType;
    /**
     * Status do layout.
     */
    public StatusType statusType;
    /**
     * Mensagem do layout (Erro ou Retorno do governo).
     */
    public String layoutMessage;
    /**
     * Número do recibo.
     */
    public String receiptNumber;
    /**
     * Número de matricula
     */
    public String registrationNumber;
    /**
     * CPF / CNPJ do empregador.
     */
    public String employerDocumentNumber;
    /**
     * CPF do trabalhador.
     */
    public String employeeDocumentNumber;

    public LayoutSituation() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LayoutSituation(String id, String layoutId, String eventId, java.time.Instant eventDate, LayoutType layoutType, OperationType operationType, StatusType statusType, String layoutMessage, String receiptNumber, String registrationNumber, String employerDocumentNumber, String employeeDocumentNumber) {
        this.id = id;
        this.layoutId = layoutId;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.layoutType = layoutType;
        this.operationType = operationType;
        this.statusType = statusType;
        this.layoutMessage = layoutMessage;
        this.receiptNumber = receiptNumber;
        this.registrationNumber = registrationNumber;
        this.employerDocumentNumber = employerDocumentNumber;
        this.employeeDocumentNumber = employeeDocumentNumber;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public LayoutSituation(String layoutId, String eventId, java.time.Instant eventDate, LayoutType layoutType, StatusType statusType, String employerDocumentNumber) {
        this.layoutId = layoutId;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.layoutType = layoutType;
        this.statusType = statusType;
        this.employerDocumentNumber = employerDocumentNumber;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LayoutSituation)) {
            return false;
        }
        LayoutSituation other = (LayoutSituation) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("layoutId=").append(layoutId == null ? "null" : layoutId).append(", ");
        sb.append("eventId=").append(eventId == null ? "null" : eventId).append(", ");
        sb.append("eventDate=").append(eventDate == null ? "null" : eventDate).append(", ");
        sb.append("layoutType=").append(layoutType == null ? "null" : layoutType).append(", ");
        sb.append("operationType=").append(operationType == null ? "null" : operationType).append(", ");
        sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
        sb.append("layoutMessage=").append(layoutMessage == null ? "null" : layoutMessage).append(", ");
        sb.append("receiptNumber=").append(receiptNumber == null ? "null" : receiptNumber).append(", ");
        sb.append("registrationNumber=").append(registrationNumber == null ? "null" : registrationNumber).append(", ");
        sb.append("employerDocumentNumber=").append(employerDocumentNumber == null ? "null" : employerDocumentNumber).append(", ");
        sb.append("employeeDocumentNumber=").append(employeeDocumentNumber == null ? "null" : employeeDocumentNumber);
        sb.append(']');
        return sb.toString();
    }

}
