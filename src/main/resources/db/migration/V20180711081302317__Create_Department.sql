/* Entity Department */
create table department (
	id UUID NOT NULL,
	code VARCHAR(255) NOT NULL,
	structure_code NUMERIC(19) NOT NULL /* structureCode */,
	name VARCHAR(255) NOT NULL
);

alter table department add constraint pk_department_id primary key(id);