LOCK TABLE integration IN ACCESS EXCLUSIVE MODE;

alter table integration add column provider_employee_identification VARCHAR(255);
alter table integration add column provider_previous_employee_identification VARCHAR(255);