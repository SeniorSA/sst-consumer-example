/* Entity Integration */
create table integration (
	id UUID NOT NULL,
	external_id VARCHAR(36) NOT NULL /* externalId */,
	external_historic_id VARCHAR(36) /* externalHistoricId */,
	employee UUID,
	company_code NUMERIC(19) /* companyCode */,
	company_name VARCHAR(255) /* companyName */,
	company_branch_code NUMERIC(19) /* companyBranchCode */,
	company_branch_name VARCHAR(255) /* companyBranchName */,
	employee_code NUMERIC(19) /* employeeCode */,
	e_social_registration VARCHAR(255) /* eSocialRegistration */,
	cpf_number VARCHAR(255) /* cpfNumber */,
	employee_name VARCHAR(255) /* employeeName */,
	status_type VARCHAR(255) NOT NULL /* statusType */,
	integration_type VARCHAR(255) NOT NULL /* integrationType */,
	receipt_date TIMESTAMP NOT NULL /* receiptDate */,
	send_date TIMESTAMP /* sendDate */,
	scheduled_date DATE, /* scheduledDate */
	integration_message TEXT /* integrationMessage */
);

alter table integration add constraint pk_integration_id primary key(id);
alter table integration add constraint fkvtzztmyti7rwdudc1t5yvjoiymdr foreign key (employee) references employee (id);
alter table integration add constraint uq_integration_external_id unique (external_id, receipt_date);