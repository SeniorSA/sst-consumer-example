create table layout (
    id uuid not null primary key,
    layout_situation_id varchar(36),
    receipt_number varchar(255),
    message TEXT,
    employee_code numeric(19),
    date_when timestamp
)