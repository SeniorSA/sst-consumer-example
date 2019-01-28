/* Entity JobPosition */
create table job_position (
	id UUID NOT NULL,
	code VARCHAR(255) NOT NULL,
	structure_code VARCHAR(255) NOT NULL /* structureCode */,
	cbo_code VARCHAR(255) /* cboCode */,
	name VARCHAR(255) NOT NULL
);

alter table job_position add constraint pk_job_position_id primary key(id);