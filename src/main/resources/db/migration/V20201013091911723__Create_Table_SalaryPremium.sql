lock table employee in access exclusive mode;

/* Entity SalaryPremiumEntitySuper */
create table salary_premium (
	id UUID NOT NULL,
	date_when DATE /* dateWhen */,
	end_date DATE /* endDate */,
	insalubrity NUMERIC(19,4),
	hazard NUMERIC(19,4),
	length_of_service NUMERIC(19,4) /* lengthOfService */,
	special_retirement_type VARCHAR(255) /* specialRetirementType */
);

/* Primary Key Constraints */
alter table salary_premium add constraint pk_salary_premium_id primary key(id);

alter table employee add column salary_premium UUID;

alter table employee add constraint fk_employee_salary_premium foreign key (salary_premium) references salary_premium (id);