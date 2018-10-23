package br.com.senior.employee.consumer.pojos.esocial4integration;

import br.com.senior.employee.consumer.pojos.common.SubscriptionType;

import java.util.List;

/**
 * Controle de integrações.
 */
public class Integration {

    public static class Id {

        public String id; //NOSONAR

        public Id() {
        }

        public Id(String integrationId) {
            this.id = integrationId;
        }

        public String getIntegrationId() {
            return id;
        }

        public String getId() {
            return id;
        }

    }

    public static class PagedResults {
        public Long totalPages; //NOSONAR
        public Long totalElements; //NOSONAR

        public List<Integration> contents; //NOSONAR

        public PagedResults() {
        }

        public PagedResults(List<Integration> contents) {
            this.contents = contents;
        }

        public PagedResults(List<Integration> contents, Long totalPages, Long totalElements) {
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
     * Id da entidade.
     */
    public String id; //NOSONAR
    /**
     * Id do colaborador no Payroll.
     */
    public String externalId; //NOSONAR
    /**
     * Id de histórico do colaborador no Payroll.
     */
    public String externalHistoricId; //NOSONAR
    /**
     * Colaborador da integração.
     */
    public Employee employee; //NOSONAR
    /**
     * Código da empresa
     */
    public Long companyCode; //NOSONAR
    /**
     * Nome da empresa.
     */
    public String companyName; //NOSONAR
    /**
     * Código da filial,=.
     */
    public Long companyBranchCode; //NOSONAR
    /**
     * Nome da filial.
     */
    public String companyBranchName; //NOSONAR
    /**
     * Código do colaborador.
     */
    public Long employeeCode; //NOSONAR
    /**
     * Matrícula do e-Social.
     */
    public String eSocialRegistration; //NOSONAR
    /**
     * Número do CPF.
     */
    public String cpfNumber; //NOSONAR
    /**
     * Nome do colaborador.
     */
    public String employeeName; //NOSONAR
    /**
     * Tipo do status de integração.
     */
    public StatusType statusType; //NOSONAR
    /**
     * Tipo da integração.
     */
    public SubscriptionType.IntegrationType integrationType; //NOSONAR
    /**
     * Data e hora do recebimento do colaborador.
     */
    public java.time.Instant receiptDate; //NOSONAR
    /**
     * Data e hora do envio para o provedor SST.
     */
    public java.time.Instant sendDate; //NOSONAR
    /**
     * Mensagem da integração.
     */
    public String integrationMessage; //NOSONAR

    public Integration() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Integration(String id, String externalId, String externalHistoricId, Employee employee, Long companyCode, String companyName, Long companyBranchCode, String companyBranchName, Long employeeCode, String eSocialRegistration, String cpfNumber, String employeeName, StatusType statusType, SubscriptionType.IntegrationType integrationType, java.time.Instant receiptDate, java.time.Instant sendDate, String integrationMessage) { //NOSONAR
        this.id = id;
        this.externalId = externalId;
        this.externalHistoricId = externalHistoricId;
        this.employee = employee;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyBranchCode = companyBranchCode;
        this.companyBranchName = companyBranchName;
        this.employeeCode = employeeCode;
        this.eSocialRegistration = eSocialRegistration;
        this.cpfNumber = cpfNumber;
        this.employeeName = employeeName;
        this.statusType = statusType;
        this.integrationType = integrationType;
        this.receiptDate = receiptDate;
        this.sendDate = sendDate;
        this.integrationMessage = integrationMessage;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Integration(String externalId, StatusType statusType, SubscriptionType.IntegrationType integrationType, java.time.Instant receiptDate) {
        this.externalId = externalId;
        this.statusType = statusType;
        this.integrationType = integrationType;
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
        if (!(obj instanceof Integration)) {
            return false;
        }
        Integration other = (Integration) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) { //NOSONAR
            return false;
        }
        return true;
    }

    @Override
    public String toString() { //NOSONAR
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" [");
        sb.append("id=").append(id == null ? "null" : id).append(", ");
        sb.append("externalId=").append(externalId == null ? "null" : externalId).append(", ");
        sb.append("externalHistoricId=").append(externalHistoricId == null ? "null" : externalHistoricId).append(", ");
        sb.append("employee=<").append(employee == null ? "null" : employee).append('>').append(", ");
        sb.append("companyCode=").append(companyCode == null ? "null" : companyCode).append(", ");
        sb.append("companyName=").append(companyName == null ? "null" : companyName).append(", ");
        sb.append("companyBranchCode=").append(companyBranchCode == null ? "null" : companyBranchCode).append(", ");
        sb.append("companyBranchName=").append(companyBranchName == null ? "null" : companyBranchName).append(", ");
        sb.append("employeeCode=").append(employeeCode == null ? "null" : employeeCode).append(", ");
        sb.append("eSocialRegistration=").append(eSocialRegistration == null ? "null" : eSocialRegistration).append(", ");
        sb.append("cpfNumber=").append(cpfNumber == null ? "null" : cpfNumber).append(", ");
        sb.append("employeeName=").append(employeeName == null ? "null" : employeeName).append(", ");
        sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
        sb.append("integrationType=").append(integrationType == null ? "null" : integrationType).append(", ");
        sb.append("receiptDate=").append(receiptDate == null ? "null" : receiptDate).append(", ");
        sb.append("sendDate=").append(sendDate == null ? "null" : sendDate).append(", ");
        sb.append("integrationMessage=").append(integrationMessage == null ? "null" : integrationMessage);
        sb.append(']');
        return sb.toString();
    }

}
