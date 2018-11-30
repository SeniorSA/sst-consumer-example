package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.List;

/**
 * Categoria eSocial.
 */
public class ESocialCategory {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String eSocialCategoryId) {
            this.id = eSocialCategoryId;
        }
        
        public String getESocialCategoryId() {
            return id;
        }
        
        public String getId() {
            return id;
        }

    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<ESocialCategory> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<ESocialCategory> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<ESocialCategory> contents, Long totalPages, Long totalElements) {
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
     * Id interno da entidade.
     */
    public String id;
    /**
     * Chave da categoria eSocial.
     */
    public ESocialCategoryType code;
    /**
     * Data do histórico da categoria eSocial (A partir de).
     */
    public java.time.LocalDate dateWhen;
    
    public ESocialCategory() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public ESocialCategory(String id, ESocialCategoryType code, java.time.LocalDate dateWhen) {
        this.id = id;
        this.code = code;
        this.dateWhen = dateWhen;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public ESocialCategory(ESocialCategoryType code, java.time.LocalDate dateWhen) {
        this.code = code;
        this.dateWhen = dateWhen;
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
        if (!(obj instanceof ESocialCategory)) {
            return false;
        }
        ESocialCategory other = (ESocialCategory) obj;
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
    	sb.append("code=").append(code == null ? "null" : code).append(", ");
    	sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
    	sb.append(']');
    	return sb.toString();
    }
    
}
