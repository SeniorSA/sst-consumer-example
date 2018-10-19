package br.com.senior.employee.consumer.pojos;

import java.util.List;


/**
 * S-1060 - Tabela de Ambientes de Trabalho.
 */
public class LayoutS1060 {

    public static class Id {

        public String id;

        public Id() {
        }

        public Id(String layoutS1060Id) {
            this.id = layoutS1060Id;
        }

        public String getLayoutS1060Id() {
            return id;
        }

        public String getId() {
            return id;
        }
    }

    public static class PagedResults {
        public Long totalPages;
        public Long totalElements;

        public List<LayoutS1060> contents;

        public PagedResults() {
        }

        public PagedResults(List<LayoutS1060> contents) {
            this.contents = contents;
        }

        public PagedResults(List<LayoutS1060> contents, Long totalPages, Long totalElements) {
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
     * Origem do layout.
     */
    public LayoutSourceType layoutSourceType;
    /**
     * Identificador do evento no governo.
     */
    public String eventId;
    /**
     * Data e hora do evento.
     */
    public java.time.Instant eventDate;
    /**
     * CPF / CNPJ do empregador.
     */
    public String employerDocumentNumber;
    /**
     * Número do recibo.
     */
    public String receiptNumber;
    /**
     * Código do ambiente.
     */
    public String environmentCode;
    /**
     * Descrição do ambiente
     */
    public String environmentName;
    /**
     * Data de inicio da informação.
     */
    public java.time.LocalDate startDate;
    /**
     * Data de término da informação.
     */
    public java.time.LocalDate endDate;
    /**
     * Tipo da operação.
     */
    public OperationType operationType;
    /**
     * Dados completo do layout em JSON.
     */
    public ESocialS1060 jsonText;

    public LayoutS1060() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LayoutS1060(String id, LayoutSourceType layoutSourceType, String eventId, java.time.Instant eventDate, String employerDocumentNumber, String receiptNumber, String environmentCode, String environmentName, java.time.LocalDate startDate, java.time.LocalDate endDate, OperationType operationType, ESocialS1060 jsonText) {
        this.id = id;
        this.layoutSourceType = layoutSourceType;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.employerDocumentNumber = employerDocumentNumber;
        this.receiptNumber = receiptNumber;
        this.environmentCode = environmentCode;
        this.environmentName = environmentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.operationType = operationType;
        this.jsonText = jsonText;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public LayoutS1060(LayoutSourceType layoutSourceType, OperationType operationType, ESocialS1060 jsonText) {
        this.layoutSourceType = layoutSourceType;
        this.operationType = operationType;
        this.jsonText = jsonText;
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
        if (!(obj instanceof LayoutS1060)) {
            return false;
        }
        LayoutS1060 other = (LayoutS1060) obj;
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
        sb.append("layoutSourceType=").append(layoutSourceType == null ? "null" : layoutSourceType).append(", ");
        sb.append("eventId=").append(eventId == null ? "null" : eventId).append(", ");
        sb.append("eventDate=").append(eventDate == null ? "null" : eventDate).append(", ");
        sb.append("employerDocumentNumber=").append(employerDocumentNumber == null ? "null" : employerDocumentNumber).append(", ");
        sb.append("receiptNumber=").append(receiptNumber == null ? "null" : receiptNumber).append(", ");
        sb.append("environmentCode=").append(environmentCode == null ? "null" : environmentCode).append(", ");
        sb.append("environmentName=").append(environmentName == null ? "null" : environmentName).append(", ");
        sb.append("startDate=").append(startDate == null ? "null" : startDate).append(", ");
        sb.append("endDate=").append(endDate == null ? "null" : endDate).append(", ");
        sb.append("operationType=").append(operationType == null ? "null" : operationType).append(", ");
        sb.append("jsonText=<").append(jsonText == null ? "null" : jsonText).append('>');
        sb.append(']');
        return sb.toString();
    }

}
