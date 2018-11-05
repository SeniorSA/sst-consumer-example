package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.List;

/**
 * Posto de trabalho.
 */
public class Workstation {

    public static class Id {

        public String id; //NOSONAR

        public Id() {
        }

        public Id(String workstationId) {
            this.id = workstationId;
        }

        public String getWorkstationId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages; //NOSONAR
        public Long totalElements; //NOSONAR

        public List<Workstation> contents; //NOSONAR

        public PagedResults() {
        }

        public PagedResults(List<Workstation> contents) {
            this.contents = contents;
        }

        public PagedResults(List<Workstation> contents, Long totalPages, Long totalElements) {
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
     * Id interno da entidade.
     */
    public String id; //NOSONAR
    /**
     * Código do posto de trabalho.
     */
    public String code; //NOSONAR
    /**
     * Estrutura do posto de trabalho.
     */
    public Long structureCode; //NOSONAR
    /**
     * Nome do posto de trabalho.
     */
    public String name; //NOSONAR

    public Workstation() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Workstation(String id, String code, Long structureCode, String name) {
        this.id = id;
        this.code = code;
        this.structureCode = structureCode;
        this.name = name;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Workstation(String code, Long structureCode, String name) {
        this.code = code;
        this.structureCode = structureCode;
        this.name = name;
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
        if (!(obj instanceof Workstation)) {
            return false;
        }
        Workstation other = (Workstation) obj;
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
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("structureCode=").append(structureCode == null ? "null" : structureCode).append(", ");
        sb.append("name=").append(name == null ? "null" : name);
        sb.append(']');
        return sb.toString();
    }

}
