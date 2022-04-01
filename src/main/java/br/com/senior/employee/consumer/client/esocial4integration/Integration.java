package br.com.senior.employee.consumer.client.esocial4integration;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Controle de integrações.
 */
public class Integration {

    public static class Id {

        public String id;

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
    	public Long totalPages;
    	public Long totalElements;

        public List<Integration> contents;

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
     * Id da entidade.
     */
    public String id;
    /**
     * Id do colaborador no Payroll.
     */
    public String externalId;
    /**
     * Id de histórico do colaborador no Payroll.
     */
    public String externalHistoricId;
    /**
     * Tipo de operação
     */
    public OperationType operationType;
    /**
     * Colaborador da integração.
     */
    public Employee employee;
    /**
     * Tipo do status de integração.
     */
    public StatusType statusType;
    /**
     * Tipo da integração.
     */
    public IntegrationType integrationType;
    /**
     * Data e hora do recebimento do colaborador.
     */
    public java.time.Instant receiptDate;
    /**
     * Data e hora do envio para o provedor SST.
     */
    public java.time.Instant sendDate;
    /**
     * Data de agendamento para envio da pendencia.
     */
    public java.time.LocalDate scheduledDate;
    /**
     * Data do histórico gerado.
     */
    public java.time.LocalDate dateWhen;
    /**
     * Mensagem da integração.
     */
    public String integrationMessage;
    /**
     * StackTrace do erro.
     */
    public String stackTrace;
    /**
     * Código da empresa
     */
    public Long companyCode;
    /**
     * Nome da empresa.
     */
    public String companyName;
    /**
     * Código da filial,=.
     */
    public Long companyBranchCode;
    /**
     * Razão social.
     */
    public String companyBranchName;
    /**
     * Nome da filial.
     */
    public String branchName;
    /**
     * Código do colaborador.
     */
    public Long employeeCode;
    /**
     * Matrícula do e-Social.
     */
    public String eSocialRegistration;
    /**
     * Número do CPF.
     */
    public String cpfNumber;
    /**
     * Nome do colaborador.
     */
    public String employeeName;
    /**
     * Identificação da empresa no prestador SST.
     */
    public String providerCompanyIdentification;
    /**
     * Identificação da empresa no prestador SST.
     */
    public Long integrationSequence;
    /**
     * Motivo cancelamento.
     */
    public String cancelationReason;
    /**
     * Data prevista para envio
     */
    public java.time.Instant previewSendDate;
    /**
     * Lote do histórico de posto de trabalho
     */
    public String lotWorkstation;
    /**
     * Identificação da empresa anterior do colaborador no prestador SST.
     */
    public String providerPreviousCompanyIdentification;
    /**
     * Identificação única do colaborador no sistema do prestador SST
     */
    public String providerEmployeeIdentification;
    /**
     * Identificação anterior do colaborador no sistema do prestador SST
     */
    public String providerPreviousEmployeeIdentification;

    public Integration() {
    }

    /**
     * This constructor allows initialization of all fields, required and optional.
     */
    public Integration(String id, String externalId, String externalHistoricId, OperationType operationType, Employee employee, StatusType statusType, IntegrationType integrationType, Instant receiptDate, Instant sendDate, LocalDate scheduledDate, LocalDate dateWhen, String integrationMessage, String stackTrace, Long companyCode, String companyName, Long companyBranchCode, String companyBranchName, String branchName, Long employeeCode, String eSocialRegistration, String cpfNumber, String employeeName, String providerCompanyIdentification, Long integrationSequence, String cancelationReason, Instant previewSendDate, String lotWorkstation, String providerPreviousCompanyIdentification) {
        this.id = id;
        this.externalId = externalId;
        this.externalHistoricId = externalHistoricId;
        this.operationType = operationType;
        this.employee = employee;
        this.statusType = statusType;
        this.integrationType = integrationType;
        this.receiptDate = receiptDate;
        this.sendDate = sendDate;
        this.scheduledDate = scheduledDate;
        this.dateWhen = dateWhen;
        this.integrationMessage = integrationMessage;
        this.stackTrace = stackTrace;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.companyBranchCode = companyBranchCode;
        this.companyBranchName = companyBranchName;
        this.branchName = branchName;
        this.employeeCode = employeeCode;
        this.eSocialRegistration = eSocialRegistration;
        this.cpfNumber = cpfNumber;
        this.employeeName = employeeName;
        this.providerCompanyIdentification = providerCompanyIdentification;
        this.integrationSequence = integrationSequence;
        this.cancelationReason = cancelationReason;
        this.previewSendDate = previewSendDate;
        this.lotWorkstation = lotWorkstation;
        this.providerPreviousCompanyIdentification = providerPreviousCompanyIdentification;
        this.providerEmployeeIdentification = providerEmployeeIdentification;
        this.providerPreviousEmployeeIdentification = providerPreviousEmployeeIdentification;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Integration(String externalId, OperationType operationType, StatusType statusType, IntegrationType integrationType, java.time.Instant receiptDate, String lotWorkstation) {
        this.externalId = externalId;
        this.operationType = operationType;
        this.statusType = statusType;
        this.integrationType = integrationType;
        this.receiptDate = receiptDate;
        this.lotWorkstation = lotWorkstation;
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
    	sb.append("externalId=").append(externalId == null ? "null" : externalId).append(", ");
    	sb.append("externalHistoricId=").append(externalHistoricId == null ? "null" : externalHistoricId).append(", ");
    	sb.append("operationType=").append(operationType == null ? "null" : operationType).append(", ");
    	sb.append("employee=<").append(employee == null ? "null" : employee).append('>').append(", ");
    	sb.append("statusType=").append(statusType == null ? "null" : statusType).append(", ");
    	sb.append("integrationType=").append(integrationType == null ? "null" : integrationType).append(", ");
    	sb.append("receiptDate=").append(receiptDate == null ? "null" : receiptDate).append(", ");
    	sb.append("sendDate=").append(sendDate == null ? "null" : sendDate).append(", ");
    	sb.append("scheduledDate=").append(scheduledDate == null ? "null" : scheduledDate).append(", ");
    	sb.append("dateWhen=").append(dateWhen == null ? "null" : dateWhen).append(", ");
    	sb.append("integrationMessage=").append(integrationMessage == null ? "null" : integrationMessage).append(", ");
    	sb.append("stackTrace=").append(stackTrace == null ? "null" : stackTrace).append(", ");
    	sb.append("companyCode=").append(companyCode == null ? "null" : companyCode).append(", ");
    	sb.append("companyName=").append(companyName == null ? "null" : companyName).append(", ");
    	sb.append("companyBranchCode=").append(companyBranchCode == null ? "null" : companyBranchCode).append(", ");
    	sb.append("companyBranchName=").append(companyBranchName == null ? "null" : companyBranchName).append(", ");
        sb.append("branchName=").append(branchName == null ? "null" : branchName).append(", ");
    	sb.append("employeeCode=").append(employeeCode == null ? "null" : employeeCode).append(", ");
    	sb.append("eSocialRegistration=").append(eSocialRegistration == null ? "null" : eSocialRegistration).append(", ");
    	sb.append("cpfNumber=").append(cpfNumber == null ? "null" : cpfNumber).append(", ");
    	sb.append("employeeName=").append(employeeName == null ? "null" : employeeName).append(", ");
    	sb.append("providerCompanyIdentification=").append(providerCompanyIdentification == null ? "null" : providerCompanyIdentification).append(", ");
    	sb.append("integrationSequence=").append(integrationSequence == null ? "null" : integrationSequence).append(", ");
    	sb.append("cancelationReason=").append(cancelationReason == null ? "null" : cancelationReason).append(", ");
    	sb.append("previewSendDate=").append(previewSendDate == null ? "null" : previewSendDate).append(", ");
        sb.append("lotWorkstation=").append(lotWorkstation == null ? "null" : lotWorkstation).append(", ");
        sb.append("providerPreviousCompanyIdentification=").append(providerPreviousCompanyIdentification == null ? "null" : providerPreviousCompanyIdentification);
        sb.append("providerEmployeeIdentification=").append(providerEmployeeIdentification == null ? "null" : providerEmployeeIdentification);
        sb.append("providerPreviousEmployeeIdentification=").append(providerPreviousEmployeeIdentification == null ? "null" : providerPreviousEmployeeIdentification);
    	sb.append(']');
    	return sb.toString();
    }

}
