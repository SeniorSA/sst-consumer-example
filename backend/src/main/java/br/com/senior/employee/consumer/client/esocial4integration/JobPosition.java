package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.List;

/**
 * Cargo do colaborador.
 */
public class JobPosition {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String jobPositionId) {
            this.id = jobPositionId;
        }
        
        public String getJobPositionId() {
            return id;
        }
        
        public String getId() {
            return id;
        }
        
    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<JobPosition> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<JobPosition> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<JobPosition> contents, Long totalPages, Long totalElements) {
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
     * Código do cargo.
     */
    public String code;
    /**
     * Código da estrutura do cargo
     */
    public String structureCode;
    /**
     * Código do CBO do cargo.
     */
    public String cboCode;
    /**
     * Nome do cargo.
     */
    public String name;
    /**
     * Data do histórico de Cargo (A partir de).
     */
    public java.time.LocalDate dateWhen;
    
    public JobPosition() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public JobPosition(String id, String code, String structureCode, String cboCode, String name, java.time.LocalDate dateWhen) {
        this.id = id;
        this.code = code;
        this.structureCode = structureCode;
        this.cboCode = cboCode;
        this.name = name;
        this.dateWhen = dateWhen;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public JobPosition(String code, String structureCode, String name, java.time.LocalDate dateWhen) {
        this.code = code;
        this.structureCode = structureCode;
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
        if (!(obj instanceof JobPosition)) {
            return false;
        }
        JobPosition other = (JobPosition) obj;
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
    	sb.append("structureCode=").append(structureCode == null ? "null" : structureCode).append(", ");
    	sb.append("cboCode=").append(cboCode == null ? "null" : cboCode).append(", ");
    	sb.append("name=").append(name == null ? "null" : name).append(", ");
    	sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
    	sb.append(']');
    	return sb.toString();
    }
    
}
