package br.com.senior.employee.consumer.pojos;

import java.util.List;

/**
 * Local do colaborador.
 */
public class Department {

    public static class Id {

        public String id;

        public Id() {
        }

        public Id(String departmentId) {
            this.id = departmentId;
        }

        public String getDepartmentId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages;
        public Long totalElements;

        public List<Department> contents;

        public PagedResults() {
        }

        public PagedResults(List<Department> contents) {
            this.contents = contents;
        }

        public PagedResults(List<Department> contents, Long totalPages, Long totalElements) {
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
     * Código do local.
     */
    public String code;
    /**
     * Código de organograma do local.
     */
    public Long structureCode;
    /**
     * Nome do local.
     */
    public String name;

    public Department() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Department(String id, String code, Long structureCode, String name) {
        this.id = id;
        this.code = code;
        this.structureCode = structureCode;
        this.name = name;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Department(String code, Long structureCode, String name) {
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
        if (!(obj instanceof Department)) {
            return false;
        }
        Department other = (Department) obj;
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
        sb.append("name=").append(name == null ? "null" : name);
        sb.append(']');
        return sb.toString();
    }

}
