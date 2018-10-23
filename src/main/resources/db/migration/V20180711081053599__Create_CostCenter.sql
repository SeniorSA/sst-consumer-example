/* Entity CostCenter */
create table cost_center (
	id UUID NOT NULL,
	code VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL
);

alter table cost_center add constraint pk_cost_center_id primary key(id);