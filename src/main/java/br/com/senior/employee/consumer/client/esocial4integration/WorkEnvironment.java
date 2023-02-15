package br.com.senior.employee.consumer.client.esocial4integration;

import java.time.LocalDate;
import java.util.List;

/**
 * Ambiente de trabalho.
 */
public class WorkEnvironment {

    public static class Id {

        public String id;

        public Id() {
        }

        public Id(String workEnvironmentId) {
            this.id = workEnvironmentId;
        }

        public String getWorkEnvironmentId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages;
        public Long totalElements;

        public List<WorkEnvironment> contents;

        public PagedResults() {
        }

        public PagedResults(List<WorkEnvironment> contents) {
            this.contents = contents;
        }

        public PagedResults(List<WorkEnvironment> contents, Long totalPages, Long totalElements) {
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
     * Local de trabalho.
     */
    public WorkEnvironmentType location;
    /**
     * Código do ambiente de trabalho.
     */
    public String code;
    /**
     * Nome do ambiente de trabalho.
     */
    public String name;
    /**
     * Tipo de inscrição do ambiente de trabalho.
     */
    public SubscriptionType subscriptionType;
    /**
     * Número de inscrição do ambiente de trabalho.
     */
    public String subscriptionNumber;
    /**
     * Data do histórico de ambiente de trabalho (A partir de).
     */
    public java.time.LocalDate dateWhen;

    public WorkEnvironment() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public WorkEnvironment(String id, WorkEnvironmentType location, String code, String name, SubscriptionType subscriptionType, String subscriptionNumber, LocalDate dateWhen) {
        this.id = id;
        this.location = location;
        this.code = code;
        this.name = name;
        this.subscriptionType = subscriptionType;
        this.subscriptionNumber = subscriptionNumber;
        this.dateWhen = dateWhen;
    }
    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public WorkEnvironment(WorkEnvironmentType location, String code, String name, SubscriptionType subscriptionType, String subscriptionNumber, LocalDate dateWhen) {
        this.location = location;
        this.code = code;
        this.name = name;
        this.subscriptionType = subscriptionType;
        this.subscriptionNumber = subscriptionNumber;
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
        if (!(obj instanceof WorkEnvironment)) {
            return false;
        }
        WorkEnvironment other = (WorkEnvironment) obj;
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
        sb.append("location=<").append(location == null ? "null" : location).append('>').append(", ");
        sb.append("code=").append(code == null ? "null" : code).append(", ");
        sb.append("name=").append(name == null ? "null" : name).append(", ");
        sb.append("subscriptionType=<").append(subscriptionType == null ? "null" : subscriptionType).append('>').append(", ");
        sb.append("subscriptionNumber=").append(subscriptionNumber == null ? "null" : subscriptionNumber).append(", ");
        sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen);
        sb.append(']');
        return sb.toString();
    }

}

