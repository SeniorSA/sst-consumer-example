/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.employee.consumer.client.esocial4integration;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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

	/**
	 * Identificação da empresa anterior do colaborador no prestador SST.
	 */
	@Column(name = "provider_previous_company_identification")
	private String providerPreviousCompanyIdentification;

	/**
	 * Identificação única “anterior” do colaborador no sistema do prestador SST (usado para movimentações de empresa e filial)
	 */
	@Column(name = "provider_previous_employee_identification")
	private String providerPreviousEmployeeIdentification;

	/**
	 * Identificação única do colaborador no sistema do prestador SST
	 */
	@Column(name = "provider_employee_identification")
	private String providerEmployeeIdentification;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getExternalHistoricId() {
		return externalHistoricId;
	}

	public void setExternalHistoricId(String externalHistoricId) {
		this.externalHistoricId = externalHistoricId;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public IntegrationType getIntegrationType() {
		return integrationType;
	}

	public void setIntegrationType(IntegrationType integrationType) {
		this.integrationType = integrationType;
	}

	public Instant getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Instant receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Instant getSendDate() {
		return sendDate;
	}

	public void setSendDate(Instant sendDate) {
		this.sendDate = sendDate;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public LocalDate getDateWhen() {
		return dateWhen;
	}

	public void setDateWhen(LocalDate dateWhen) {
		this.dateWhen = dateWhen;
	}

	public String getIntegrationMessage() {
		return integrationMessage;
	}

	public void setIntegrationMessage(String integrationMessage) {
		this.integrationMessage = integrationMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCompanyBranchCode() {
		return companyBranchCode;
	}

	public void setCompanyBranchCode(Long companyBranchCode) {
		this.companyBranchCode = companyBranchCode;
	}

	public String getCompanyBranchName() {
		return companyBranchName;
	}

	public void setCompanyBranchName(String companyBranchName) {
		this.companyBranchName = companyBranchName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String geteSocialRegistration() {
		return eSocialRegistration;
	}

	public void seteSocialRegistration(String eSocialRegistration) {
		this.eSocialRegistration = eSocialRegistration;
	}

	public String getCpfNumber() {
		return cpfNumber;
	}

	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getProviderCompanyIdentification() {
		return providerCompanyIdentification;
	}

	public void setProviderCompanyIdentification(String providerCompanyIdentification) {
		this.providerCompanyIdentification = providerCompanyIdentification;
	}

	public Long getIntegrationSequence() {
		return integrationSequence;
	}

	public void setIntegrationSequence(Long integrationSequence) {
		this.integrationSequence = integrationSequence;
	}

	public String getCancelationReason() {
		return cancelationReason;
	}

	public void setCancelationReason(String cancelationReason) {
		this.cancelationReason = cancelationReason;
	}

	public Instant getPreviewSendDate() {
		return previewSendDate;
	}

	public void setPreviewSendDate(Instant previewSendDate) {
		this.previewSendDate = previewSendDate;
	}

	public String getLotWorkstation() {
		return lotWorkstation;
	}

	public void setLotWorkstation(String lotWorkstation) {
		this.lotWorkstation = lotWorkstation;
	}

	public String getProviderPreviousCompanyIdentification() {
		return providerPreviousCompanyIdentification;
	}

	public void setProviderPreviousCompanyIdentification(String providerPreviousCompanyIdentification) {
		this.providerPreviousCompanyIdentification = providerPreviousCompanyIdentification;
	}

	public String getProviderPreviousEmployeeIdentification() {
		return providerPreviousEmployeeIdentification;
	}

	public void setProviderPreviousEmployeeIdentification(String providerPreviousEmployeeIdentification) {
		this.providerPreviousEmployeeIdentification = providerPreviousEmployeeIdentification;
	}

	public String getProviderEmployeeIdentification() {
		return providerEmployeeIdentification;
	}

	public void setProviderEmployeeIdentification(String providerEmployeeIdentification) {
		this.providerEmployeeIdentification = providerEmployeeIdentification;
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
		sb.append("lotWorkstation=").append(lotWorkstation == null ? "null" : lotWorkstation).append(", ");
		sb.append("providerPreviousCompanyIdentification=").append(providerPreviousCompanyIdentification == null ? "null" : providerPreviousCompanyIdentification);
		sb.append("providerPreviousEmployeeIdentification=").append(providerPreviousEmployeeIdentification == null ? "null" : providerPreviousEmployeeIdentification);
		sb.append("providerEmployeeIdentification=").append(providerEmployeeIdentification == null ? "null" : providerEmployeeIdentification);
		sb.append(']');
		return sb.toString();
	}
	
}
