/* Entity Deficiency */
create table deficiency (
	id UUID NOT NULL,
	code NUMERIC(19) NOT NULL,
	name VARCHAR(255) NOT NULL,
	is_main_deficiency BOOLEAN NOT NULL /* isMainDeficiency */,
	deficiency_type VARCHAR(255) NOT NULL /* deficiencyType */
);

alter table deficiency add constraint pk_deficiency_id primary key(id);