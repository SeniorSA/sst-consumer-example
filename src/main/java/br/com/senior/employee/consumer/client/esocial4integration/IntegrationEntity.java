/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "integration")
public class IntegrationEntity {
	
	/**
	 * Id da entidade.
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;

	/**
	 * Id do colaborador no Payroll.
	 */
	@Column(name = "external_id", length = 36)
	private String externalId;
	
	/**
	 * Id de histórico do colaborador no Payroll.
	 */
	@Column(name = "external_historic_id", length = 36)
	private String externalHistoricId;
	
	/**
	 * Tipo de operação
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "operation_type")
	private OperationType operationType;
	
	/**
	 * Colaborador da integração.
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee")
	private EmployeeEntity employee;
	
	/**
	 * Tipo do status de integração.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "status_type")
	private StatusType statusType;
	
	/**
	 * Tipo da integração.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "integration_type")
	private IntegrationType integrationType;
	
	/**
	 * Data e hora do recebimento do colaborador.
	 */
	@Column(name = "receipt_date")
	private java.time.Instant receiptDate;
	
	/**
	 * Data e hora do envio para o provedor SST.
	 */
	@Column(name = "send_date")
	private java.time.Instant sendDate;
	
	/**
	 * Data de agendamento para envio da pendencia.
	 */
	@Column(name = "scheduled_date")
	private java.time.LocalDate scheduledDate;
	
	/**
	 * Data do histórico gerado.
	 */
	@Column(name = "date_when")
	private java.time.LocalDate dateWhen;
	
	/**
	 * Mensagem da integração.
	 */
	@Column(name = "integration_message")
	private String integrationMessage;
	
	/**
	 * StackTrace do erro.
	 */
	@Column(name = "stack_trace")
	private String stackTrace;
	
	/**
	 * Código da empresa
	 */
	@Column(name = "company_code")
	private Long companyCode;
	
	/**
	 * Nome da empresa.
	 */
	@Column(name = "company_name")
	private String companyName;
	
	/**
	 * Código da filial,=.
	 */
	@Column(name = "company_branch_code")
	private Long companyBranchCode;
	
	/**
	 * Razão social.
	 */
	@Column(name = "company_branch_name")
	private String companyBranchName;

	/**
	 * Nome da filial.
	 */
	@Column(name = "branch_name")
	private String branchName;
	
	/**
	 * Código do colaborador.
	 */
	@Column(name = "employee_code")
	private Long employeeCode;
	
	/**
	 * Matrícula do e-Social.
	 */
	@Column(name = "e_social_registration", length = 30)
	private String eSocialRegistration;
	
	/**
	 * Número do CPF.
	 */
	@Column(name = "cpf_number")
	private String cpfNumber;
	
	/**
	 * Nome do colaborador.
	 */
	@Column(name = "employee_name")
	private String employeeName;
	
	/**
	 * Identificação da empresa no prestador SST.
	 */
	@Column(name = "provider_company_identification")
	private String providerCompanyIdentification;
	
	/**
	 * Identificação da empresa no prestador SST.
	 */
	@Column(name = "integration_sequence")
	private Long integrationSequence;
	
	/**
	 * Motivo cancelamento.
	 */
	@Column(name = "cancelation_reason")
	private String cancelationReason;
	
	/**
	 * Data prevista para envio
	 */
	@Column(name = "preview_send_date")
	private java.time.Instant previewSendDate;
	
	/**
	 * Lote do histórico de posto de trabalho
	 */
	@Column(name = "lot_workstation")
	private String lotWorkstation;
	
	public java.util.UUID getId() {
		return this.id;
	}

	public String getExternalId() {
		return this.externalId;
	}
	
	public String getExternalHistoricId() {
		return this.externalHistoricId;
	}
	
	public OperationType getOperationType() {
		return this.operationType;
	}
	
	public EmployeeEntity getEmployee() {
		return this.employee;
	}
	
	public StatusType getStatusType() {
		return this.statusType;
	}
	
	public IntegrationType getIntegrationType() {
		return this.integrationType;
	}
	
	public java.time.Instant getReceiptDate() {
		return this.receiptDate;
	}
	
	public java.time.Instant getSendDate() {
		return this.sendDate;
	}
	
	public java.time.LocalDate getScheduledDate() {
		return this.scheduledDate;
	}
	
	public java.time.LocalDate getDateWhen() {
		return this.dateWhen;
	}
	
	public String getIntegrationMessage() {
		return this.integrationMessage;
	}
	
	public String getStackTrace() {
		return this.stackTrace;
	}
	
	public Long getCompanyCode() {
		return this.companyCode;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public Long getCompanyBranchCode() {
		return this.companyBranchCode;
	}
	
	public String getCompanyBranchName() {
		return this.companyBranchName;
	}

	public String getBranchName() {
		return branchName;
	}
	
	public Long getEmployeeCode() {
		return this.employeeCode;
	}
	
	public String getESocialRegistration() {
		return this.eSocialRegistration;
	}
	
	public String getCpfNumber() {
		return this.cpfNumber;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	public String getProviderCompanyIdentification() {
		return this.providerCompanyIdentification;
	}
	
	public Long getIntegrationSequence() {
		return this.integrationSequence;
	}
	
	public String getCancelationReason() {
		return this.cancelationReason;
	}
	
	public java.time.Instant getPreviewSendDate() {
		return this.previewSendDate;
	}
	
	public String getLotWorkstation() {
		return this.lotWorkstation;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	public void setExternalHistoricId(String externalHistoricId) {
		this.externalHistoricId = externalHistoricId;
	}
	
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
	
	public void setIntegrationType(IntegrationType integrationType) {
		this.integrationType = integrationType;
	}
	
	public void setReceiptDate(java.time.Instant receiptDate) {
		this.receiptDate = receiptDate;
	}
	
	public void setSendDate(java.time.Instant sendDate) {
		this.sendDate = sendDate;
	}
	
	public void setScheduledDate(java.time.LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public void setDateWhen(java.time.LocalDate dateWhen) {
		this.dateWhen = dateWhen;
	}
	
	public void setIntegrationMessage(String integrationMessage) {
		this.integrationMessage = integrationMessage;
	}
	
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setCompanyBranchCode(Long companyBranchCode) {
		this.companyBranchCode = companyBranchCode;
	}
	
	public void setCompanyBranchName(String companyBranchName) {
		this.companyBranchName = companyBranchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public void setESocialRegistration(String eSocialRegistration) {
		this.eSocialRegistration = eSocialRegistration;
	}
	
	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setProviderCompanyIdentification(String providerCompanyIdentification) {
		this.providerCompanyIdentification = providerCompanyIdentification;
	}
	
	public void setIntegrationSequence(Long integrationSequence) {
		this.integrationSequence = integrationSequence;
	}
	
	public void setCancelationReason(String cancelationReason) {
		this.cancelationReason = cancelationReason;
	}
	
	public void setPreviewSendDate(java.time.Instant previewSendDate) {
		this.previewSendDate = previewSendDate;
	}
	
	public void setLotWorkstation(String lotWorkstation) {
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
	    if (!(obj instanceof IntegrationEntity)) {
	        return false;
	    }
	    IntegrationEntity other = (IntegrationEntity) obj;
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
		sb.append("lotWorkstation=").append(lotWorkstation == null ? "null" : lotWorkstation);
		sb.append(']');
		return sb.toString();
	}
	
}
