/* Entity Employee */
create table employee (
	id UUID NOT NULL,
	external_id VARCHAR(36) NOT NULL /* externalId */,
	receipt_date TIMESTAMP NOT NULL /* receiptDate */,
	employee_type VARCHAR(255) /* employeeType */,
	code NUMERIC(19),
	e_social_registration VARCHAR(255) /* eSocialRegistration */,
	name VARCHAR(255) NOT NULL,
	cpf_number VARCHAR(255) NOT NULL /* cpfNumber */,
	nis_number VARCHAR(255) /* nisNumber */,
	birthday DATE,
	hire_date DATE /* hireDate */,
	marital_status_type VARCHAR(255) /* maritalStatusType */,
	gender_type VARCHAR(255) /* genderType */,
	situation_type VARCHAR(255) NOT NULL /* situationType */,
	contract_type VARCHAR(255) /* contractType */,
	e_social_category_type VARCHAR(255) /* eSocialCategoryType */,
	is_deficient BOOLEAN /* isDeficient */,
	company UUID NOT NULL,
	company_branch UUID NOT NULL /* companyBranch */,
	cost_center UUID /* costCenter */,
	department UUID,
	job_position UUID /* jobPosition */,
	shift UUID,
	reason_leave UUID /* reasonLeave */,
	workstation UUID
);

alter table employee add constraint pk_employee_id primary key(id);

alter table employee add constraint fku1vlnbsyowli56smef054miguuev foreign key (company) references company (id);
alter table employee add constraint fk1fsq1znesobjyqagxtyqr52wa3gl foreign key (company_branch) references company_branch (id);
alter table employee add constraint fkbix2pcbmdao6smkob1dcmkb9coxy foreign key (cost_center) references cost_center (id);
alter table employee add constraint fk1dytructdttulmazqxbdnbfhkdbg foreign key (department) references department (id);
alter table employee add constraint fkovxaxc6fqghenjoavgl1xatnywpt foreign key (job_position) references job_position (id);
alter table employee add constraint fky50xiq9hpxa6pnnvydojvk6ptjti foreign key (shift) references shift (id);
alter table employee add constraint fktaubclzxyzosx5k7dj58itncpby3 foreign key (reason_leave) references reason_leave (id);
alter table employee add constraint fkwww8trzbtody88p6fwss2yy90ojf foreign key (workstation) references workstation (id);

/* master: Employee as employee, detail: Deficiency as deficiency */
create table employee_deficiency (
	employee_id UUID NOT NULL,
	deficiency_id UUID NOT NULL
);

alter table employee_deficiency add constraint pk_employee_deficiency primary key(employee_id, deficiency_id);

alter table employee_deficiency add constraint fknivvxvqnrlc4xb4ykh1zbtfbjbtu foreign key (employee_id) references employee (id);
alter table employee_deficiency add constraint fksqdelayzncnawxfigdw7ssrd14qk foreign key (deficiency_id) references deficiency (id);
