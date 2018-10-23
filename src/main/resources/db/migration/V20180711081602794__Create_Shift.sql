/* Entity Shift */
create table shift (
	id UUID NOT NULL,
	code NUMERIC(19) NOT NULL,
	name VARCHAR(255) NOT NULL
);

alter table shift add constraint pk_shift_id primary key(id);