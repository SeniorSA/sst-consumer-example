/* Entity CompanyBranch */
create table company_branch (
	id UUID NOT NULL,
	code NUMERIC(19) NOT NULL,
	name VARCHAR(255) NOT NULL,
	subscription_type VARCHAR(255) NOT NULL /* subscriptionType */,
	subscription_number VARCHAR(14) NOT NULL /* subscriptionNumber */
);

alter table company_branch add constraint pk_company_branch_id primary key(id);