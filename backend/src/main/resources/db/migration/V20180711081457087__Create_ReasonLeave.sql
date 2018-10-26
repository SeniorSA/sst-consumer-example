/* Entity ReasonLeave */
create table reason_leave (
	id UUID NOT NULL,
	code NUMERIC(19) NOT NULL,
	name VARCHAR(255) NOT NULL
);

alter table reason_leave add constraint pk_reason_leave_id primary key(id);