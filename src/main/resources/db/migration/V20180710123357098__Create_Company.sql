/* Entity Company */
create table company (
	id UUID NOT NULL,
	code NUMERIC(19),
	name VARCHAR(255) NOT NULL
);

alter table company add constraint pk_company_id primary key(id);