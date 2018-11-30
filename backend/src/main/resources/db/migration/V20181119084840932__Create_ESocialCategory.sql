/* Entity eSocialCategory */
create table e_social_category (
	id UUID NOT NULL,
	code VARCHAR(255) NOT NULL,
	date_when DATE NOT NULL
);

alter table e_social_category add constraint pk_e_social_category_id primary key(id);