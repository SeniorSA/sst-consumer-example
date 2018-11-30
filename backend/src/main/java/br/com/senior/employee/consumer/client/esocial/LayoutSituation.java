package br.com.senior.employee.consumer.client.esocial;

import java.util.List;
import java.util.Map;

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
     * Origem do layout.
     */
    public LayoutSourceType layoutSourceType;
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
    /**
     * Código correspondente ao tipo de inscrição.
     * 1 - CNPJ
     * 2 - CPF
     * 3 - CAEPF (Cadastro de Atividade Econômica de Pessoa Física)
     * 4 - CNO (Cadastro Nacional de Obra)
     */
    public SubscriptionType subscriptionType;
    /**
     * Tipo de ambiente.
     */
    public EnvironmentIdType environmentIdType;
    
    public LayoutSituation() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public LayoutSituation(String id, String layoutId, String eventId, java.time.Instant eventDate, LayoutType layoutType, LayoutSourceType layoutSourceType, OperationType operationType, StatusType statusType, String layoutMessage, String receiptNumber, String registrationNumber, String employerDocumentNumber, String employeeDocumentNumber, SubscriptionType subscriptionType, EnvironmentIdType environmentIdType) {
        this.id = id;
        this.layoutId = layoutId;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.layoutType = layoutType;
        this.layoutSourceType = layoutSourceType;
        this.operationType = operationType;
        this.statusType = statusType;
        this.layoutMessage = layoutMessage;
        this.receiptNumber = receiptNumber;
        this.registrationNumber = registrationNumber;
        this.employerDocumentNumber = employerDocumentNumber;
        this.employeeDocumentNumber = employeeDocumentNumber;
        this.subscriptionType = subscriptionType;
        this.environmentIdType = environmentIdType;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public LayoutSituation(String layoutId, String eventId, java.time.Instant eventDate, LayoutType layoutType, LayoutSourceType layoutSourceType, StatusType statusType, String employerDocumentNumber, SubscriptionType subscriptionType, EnvironmentIdType environmentIdType) {
        this.layoutId = layoutId;
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.layoutType = layoutType;
        this.layoutSourceType = layoutSourceType;
        this.statusType = statusType;
        this.employerDocumentNumber = employerDocumentNumber;
        this.subscriptionType = subscriptionType;
        this.environmentIdType = environmentIdType;
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
    	sb.append("layoutSourceType=").append(layoutSourceType == null ? "null" : layoutSourceType).append(", ");
    	sb.append("operationType=").append(operationType == null ? "null" : operationType).append(", ");
    	sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
    	sb.append("layoutMessage=").append(layoutMessage == null ? "null" : layoutMessage).append(", ");
    	sb.append("receiptNumber=").append(receiptNumber == null ? "null" : receiptNumber).append(", ");
    	sb.append("registrationNumber=").append(registrationNumber == null ? "null" : registrationNumber).append(", ");
    	sb.append("employerDocumentNumber=").append(employerDocumentNumber == null ? "null" : employerDocumentNumber).append(", ");
    	sb.append("employeeDocumentNumber=").append(employeeDocumentNumber == null ? "null" : employeeDocumentNumber).append(", ");
    	sb.append("subscriptionType=").append(subscriptionType == null ? "null" : subscriptionType).append(", ");
    	sb.append("environmentIdType=").append(environmentIdType == null ? "null" : environmentIdType);
    	sb.append(']');
    	return sb.toString();
    }
    
}
