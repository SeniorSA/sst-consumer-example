package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.List;
import java.util.Map;

/**
 * Centro de custo do colaborador.
 */
public class CostCenter {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String costCenterId) {
            this.id = costCenterId;
        }
        
        public String getCostCenterId() {
            return id;
        }
        
        public String getId() {
            return id;
        }
        
    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<CostCenter> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<CostCenter> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<CostCenter> contents, Long totalPages, Long totalElements) {
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
     * Código do centro de custo.
     */
    public String code;
    /**
     * Nome do centro de custo.
     */
    public String name;
    /**
     * Data do histórico do centro de custo (A partir de).
     */
    public java.time.LocalDate dateWhen;
    
    public CostCenter() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public CostCenter(String id, String code, String name, java.time.LocalDate dateWhen) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateWhen = dateWhen;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public CostCenter(String code, String name, java.time.LocalDate dateWhen) {
        this.code = code;
        this.name = name;
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
        if (!(obj instanceof CostCenter)) {
            return false;
        }
        CostCenter other = (CostCenter) obj;
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
    	sb.append("name=").append(name == null ? "null" : name).append(", ");
    	sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
    	sb.append(']');
    	return sb.toString();
    }
    
}
