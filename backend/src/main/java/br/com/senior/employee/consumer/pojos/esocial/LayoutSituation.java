package br.com.senior.employee.consumer.pojos.esocial;

import br.com.senior.employee.consumer.pojos.common.SubscriptionType;

import java.util.List;

/**
 * Situação de layout do eSocial.
 */
public class LayoutSituation {

    public static class Id {

        public String id; //NOSONAR

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
        public Long totalPages; //NOSONAR
        public Long totalElements; //NOSONAR

        public List<LayoutSituation> contents; //NOSONAR

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
        public Long offset; //NOSONAR
        public Long size; //NOSONAR
        public boolean translations; //NOSONAR
        public String orderBy; //NOSONAR
        public String filter; //NOSONAR
        public List<String> displayFields; //NOSONAR

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
    public String id; //NOSONAR
    /**
     * Identificador do layout.
     */
    public String layoutId; //NOSONAR
    /**
     * Identificador do evento.
     */
    public String eventId; //NOSONAR
    /**
     * Data e hora do evento.
     */
    public java.time.Instant eventDate; //NOSONAR
    /**
     * Tipo do layout.
     */
    public LayoutType layoutType; //NOSONAR
    /**
     * Tipo da operação.
     */
    public OperationType operationType; //NOSONAR
    /**
     * Status do layout.
     */
    public StatusType statusType; //NOSONAR
    /**
     * Mensagem do layout (Erro ou Retorno do governo).
     */
    public String layoutMessage; //NOSONAR
    /**
     * Número do recibo.
     */
    public String receiptNumber; //NOSONAR
    /**
     * Número de matricula
     */
    public String registrationNumber; //NOSONAR
    /**
     * CPF / CNPJ do empregador.
     */
    public String employerDocumentNumber; //NOSONAR
    /**
     * CPF do trabalhador.
     */
    public String employeeDocumentNumber; //NOSONAR
    /**
     * Código correspondente ao tipo de inscrição.
     * 1 - CNPJ
     * 2 - CPF
     * 3 - CAEPF (Cadastro de Atividade Econômica de Pessoa Física)
     * 4 - CNO (Cadastro Nacional de Obra)
     */
    public SubscriptionType subscriptionType; //NOSONAR

    public LayoutSituation() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public LayoutSituation(String id, String layoutId, String eventId, java.time.Instant eventDate, LayoutType layoutType, OperationType operationType, StatusType statusType, String layoutMessage, String receiptNumber, String registrationNumber, String employerDocumentNumber, String employeeDocumentNumber, SubscriptionType subscriptionType) { //NOSONAR
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
        this.subscriptionType = subscriptionType;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public LayoutSituation(String layoutId, String eventId, java.time.Instant eventDate, LayoutType layoutType, StatusType statusType, String employerDocumentNumber, SubscriptionType subscriptionType) {
        this.layoutId = layoutId;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.layoutType = layoutType;
        this.statusType = statusType;
        this.employerDocumentNumber = employerDocumentNumber;
        this.subscriptionType = subscriptionType;
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
        if ((id != null) && !id.equals(other.id)) { //NOSONAR
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
        sb.append("employeeDocumentNumber=").append(employeeDocumentNumber == null ? "null" : employeeDocumentNumber).append(", ");
        sb.append("subscriptionType=").append(subscriptionType == null ? "null" : subscriptionType);
        sb.append(']');
        return sb.toString();
    }

}
