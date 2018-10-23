/* Entity Workstation */
create table workstation (
	id UUID NOT NULL,
	code VARCHAR(255) NOT NULL,
	structure_code NUMERIC(19) NOT NULL /* structureCode */,
	name VARCHAR(255) NOT NULL
);

alter table workstation add constraint pk_workstation_id primary key(id);