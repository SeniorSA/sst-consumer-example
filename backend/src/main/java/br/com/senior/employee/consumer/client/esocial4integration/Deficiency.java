package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.List;

/**
 * Deficiência do colaborador.
 */
public class Deficiency {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String deficiencyId) {
            this.id = deficiencyId;
        }
        
        public String getDeficiencyId() {
            return id;
        }
        
        public String getId() {
            return id;
        }

    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<Deficiency> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<Deficiency> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<Deficiency> contents, Long totalPages, Long totalElements) {
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
     * Código da deficiência.
     */
    public Long code;
    /**
     * Nome da deficiência.
     */
    public String name;
    /**
     * É a deficiência principal?
     */
    public Boolean isMainDeficiency;
    /**
     * Tipo da deficiência no e-Social.
     */
    public DeficiencyType deficiencyType;
    /**
     * Data de início da deficiência.
     */
    public java.time.LocalDate dateWhen;
    /**
     * Reabilitado.
     */
    public Boolean isRehabilitated;
    /**
     * Id do colaborador.
     */
    public String employee;
    
    public Deficiency() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public Deficiency(String id, Long code, String name, Boolean isMainDeficiency, DeficiencyType deficiencyType, java.time.LocalDate dateWhen, Boolean isRehabilitated, String employee) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.isMainDeficiency = isMainDeficiency;
        this.deficiencyType = deficiencyType;
        this.dateWhen = dateWhen;
        this.isRehabilitated = isRehabilitated;
        this.employee = employee;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public Deficiency(Long code, String name, Boolean isMainDeficiency, DeficiencyType deficiencyType, java.time.LocalDate dateWhen, Boolean isRehabilitated, String employee) {
        this.code = code;
        this.name = name;
        this.isMainDeficiency = isMainDeficiency;
        this.deficiencyType = deficiencyType;
        this.dateWhen = dateWhen;
        this.isRehabilitated = isRehabilitated;
        this.employee = employee;
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
        if (!(obj instanceof Deficiency)) {
            return false;
        }
        Deficiency other = (Deficiency) obj;
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
    	sb.append("isMainDeficiency=").append(isMainDeficiency == null ? "null" : isMainDeficiency).append(", ");
    	sb.append("deficiencyType=").append(deficiencyType == null ? "null" : deficiencyType).append(", ");
    	sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen).append(", ");
    	sb.append("isRehabilitated=").append(isRehabilitated == null ? "null" : isRehabilitated).append(", ");
    	sb.append("employee=").append(employee == null ? "null" : employee);
    	sb.append(']');
    	return sb.toString();
    }
    
}
