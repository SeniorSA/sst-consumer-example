create table employee (
    id uuid not null primary key,
    code integer,
    name varchar(255),
    integration_type varchar(255),
    integration_id varchar(36),
    date_when timestamp
)