package br.com.senior.employee.consumer.pojos.esocial4integration;

import br.com.senior.employee.consumer.pojos.common.SituationType;

import java.util.List;

/**
 * Deficiência do colaborador.
 */
public class Deficiency {

    public static class Id {

        public String id; //NOSONAR

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
        public Long totalPages; //NOSONAR
        public Long totalElements; //NOSONAR

        public List<Deficiency> contents; //NOSONAR

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
     * Código da deficiência.
     */
    public Long code; //NOSONAR
    /**
     * Nome da deficiência.
     */
    public String name; //NOSONAR
    /**
     * É a deficiência principal?
     */
    public Boolean isMainDeficiency; //NOSONAR
    /**
     * Tipo da deficiência no e-Social.
     */
    public SituationType.DeficiencyType deficiencyType; //NOSONAR

    public Deficiency() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Deficiency(String id, Long code, String name, Boolean isMainDeficiency, SituationType.DeficiencyType deficiencyType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.isMainDeficiency = isMainDeficiency;
        this.deficiencyType = deficiencyType;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Deficiency(Long code, String name, Boolean isMainDeficiency, SituationType.DeficiencyType deficiencyType) {
        this.code = code;
        this.name = name;
        this.isMainDeficiency = isMainDeficiency;
        this.deficiencyType = deficiencyType;
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
        sb.append("name=").append(name == null ? "null" : name).append(", ");
        sb.append("isMainDeficiency=").append(isMainDeficiency == null ? "null" : isMainDeficiency).append(", ");
        sb.append("deficiencyType=").append(deficiencyType == null ? "null" : deficiencyType);
        sb.append(']');
        return sb.toString();
    }

}
