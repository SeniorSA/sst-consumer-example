LOCK TABLE employee IN ACCESS EXCLUSIVE MODE;

alter table employee add column previous_employee_type VARCHAR(255);
alter table employee add column previous_code NUMERIC(19);