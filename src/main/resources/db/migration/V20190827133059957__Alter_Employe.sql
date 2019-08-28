LOCK TABLE employee IN ACCESS EXCLUSIVE MODE;

alter table employee add column number_contract_same_hire_date NUMERIC(19);