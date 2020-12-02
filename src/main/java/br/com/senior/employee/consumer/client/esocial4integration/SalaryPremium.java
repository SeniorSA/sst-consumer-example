package br.com.senior.employee.consumer.client.esocial4integration;

import java.util.List;

/**
 * Adicionais no salário do colaborador
 */
public class SalaryPremium {
    public static class Id {

        public String id;

        public Id() {
        }

        public Id(String salaryPremiumId) {
            this.id = salaryPremiumId;
        }

        public String getSalaryPremiumId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages;
        public Long totalElements;

        public List<SalaryPremium> contents;

        public PagedResults() {
        }

        public PagedResults(List<SalaryPremium> contents) {
            this.contents = contents;
        }

        public PagedResults(List<SalaryPremium> contents, Long totalPages, Long totalElements) {
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
     * Data de inicio
     */
    public java.time.LocalDate dateWhen;
    /**
     * Data fim
     */
    public java.time.LocalDate endDate;
    /**
     * Insalubridade
     */
    public Double insalubrity;
    /**
     * Periculosidade
     */
    public Double hazard;
    /**
     * Fator tempo de serviço
     */
    public Double lengthOfService;
    /**
     * Aposentadoria especial
     */
    public SpecialRetirementType specialRetirementType;

    public SalaryPremium() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public SalaryPremium(String id, java.time.LocalDate dateWhen, java.time.LocalDate endDate, Double insalubrity, Double hazard, Double lengthOfService, SpecialRetirementType specialRetirementType) {
        this.id = id;
        this.dateWhen = dateWhen;
        this.endDate = endDate;
        this.insalubrity = insalubrity;
        this.hazard = hazard;
        this.lengthOfService = lengthOfService;
        this.specialRetirementType = specialRetirementType;
    }
    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public SalaryPremium(java.time.LocalDate dateWhen, SpecialRetirementType specialRetirementType) {
        this.dateWhen = dateWhen;
        this.specialRetirementType = specialRetirementType;
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
        if (!(obj instanceof SalaryPremium)) {
            return false;
        }
        SalaryPremium other = (SalaryPremium) obj;
        if (id == null || !id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen).append(", ");
        sb.append("endDate=").append(endDate == null ? "null" : endDate).append(", ");
        sb.append("insalubrity=").append(insalubrity == null ? "null" : insalubrity).append(", ");
        sb.append("hazard=").append(hazard == null ? "null" : hazard).append(", ");
        sb.append("lengthOfService=").append(lengthOfService == null ? "null" : lengthOfService).append(", ");
        sb.append("specialRetirementType=").append(specialRetirementType == null ? "null" : specialRetirementType);
        sb.append(']');
        return sb.toString();
    }

}
