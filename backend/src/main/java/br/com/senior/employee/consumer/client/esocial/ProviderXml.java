package br.com.senior.employee.consumer.client.esocial;

import java.util.List;
import java.util.Map;

/**
 * Xml recebido do prestador.
 */
public class ProviderXml {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String providerXmlId) {
            this.id = providerXmlId;
        }
        
        public String getProviderXmlId() {
            return id;
        }
        
        public String getId() {
            return id;
        }

    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<ProviderXml> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<ProviderXml> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<ProviderXml> contents, Long totalPages, Long totalElements) {
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
     * Xml string
     */
    public String xml;
    /**
     * Status do xml
     */
    public XmlStatusType xmlStatus;
    /**
     * Situação do consumo do status do XML pelo prestador SST.
     */
    public ProviderStatusType providerStatusType;
    /**
     * Situação de layout do eSocial.
     */
    public LayoutSituation layoutSituation;
    /**
     * Stacktrace.
     */
    public String stackTrace;
    /**
     * Mensagem.
     */
    public String message;
    /**
     * Id do evento.
     */
    public String idEvento;
    /**
     * Tipo de layout.
     */
    public LayoutType layoutType;
    /**
     * Data de recebimento.
     */
    public java.time.Instant receiptDate;
    /**
     * Status type.
     */
    public StatusType statusType;
    /**
     * Id da empresa no prestador SST.
     */
    public String providerCompanyId;
    /**
     * Tipo de inscrição.
     */
    public SubscriptionType subscriptionType;
    /**
     * Numero de incrição.
     */
    public String subscriptionNumber;
    /**
     * Id do xml dno prestador
     */
    public String providerXmlId;
    
    public ProviderXml() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ProviderXml(String id, String xml, XmlStatusType xmlStatus, ProviderStatusType providerStatusType, LayoutSituation layoutSituation, String stackTrace, String message, String idEvento, LayoutType layoutType, java.time.Instant receiptDate, StatusType statusType, String providerCompanyId, SubscriptionType subscriptionType, String subscriptionNumber, String providerXmlId) {
        this.id = id;
        this.xml = xml;
        this.xmlStatus = xmlStatus;
        this.providerStatusType = providerStatusType;
        this.layoutSituation = layoutSituation;
        this.stackTrace = stackTrace;
        this.message = message;
        this.idEvento = idEvento;
        this.layoutType = layoutType;
        this.receiptDate = receiptDate;
        this.statusType = statusType;
        this.providerCompanyId = providerCompanyId;
        this.subscriptionType = subscriptionType;
        this.subscriptionNumber = subscriptionNumber;
        this.providerXmlId = providerXmlId;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public ProviderXml(String xml, XmlStatusType xmlStatus, ProviderStatusType providerStatusType, java.time.Instant receiptDate) {
        this.xml = xml;
        this.xmlStatus = xmlStatus;
        this.providerStatusType = providerStatusType;
        this.receiptDate = receiptDate;
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
        if (!(obj instanceof ProviderXml)) {
            return false;
        }
        ProviderXml other = (ProviderXml) obj;
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
    	sb.append("xml=").append(xml == null ? "null" : xml).append(", ");
    	sb.append("xmlStatus=").append(xmlStatus == null ? "null" : xmlStatus).append(", ");
    	sb.append("providerStatusType=").append(providerStatusType == null ? "null" : providerStatusType).append(", ");
    	sb.append("layoutSituation=<").append(layoutSituation == null ? "null" : layoutSituation).append('>').append(", ");
    	sb.append("stackTrace=").append(stackTrace == null ? "null" : stackTrace).append(", ");
    	sb.append("message=").append(message == null ? "null" : message).append(", ");
    	sb.append("idEvento=").append(idEvento == null ? "null" : idEvento).append(", ");
    	sb.append("layoutType=").append(layoutType == null ? "null" : layoutType).append(", ");
    	sb.append("receiptDate=").append(receiptDate == null ? "null" : receiptDate).append(", ");
    	sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
    	sb.append("providerCompanyId=").append(providerCompanyId == null ? "null" : providerCompanyId).append(", ");
    	sb.append("subscriptionType=").append(subscriptionType == null ? "null" : subscriptionType).append(", ");
    	sb.append("subscriptionNumber=").append(subscriptionNumber == null ? "null" : subscriptionNumber).append(", ");
    	sb.append("providerXmlId=").append(providerXmlId == null ? "null" : providerXmlId);
    	sb.append(']');
    	return sb.toString();
    }
    
}
