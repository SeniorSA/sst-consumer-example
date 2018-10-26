-- A confirmação destes drop column depende da liberação desta issue http://jira.senior.com.br/browse/ARQPDT-717
--ALTER TABLE integration DROP COLUMN company_code;
--ALTER TABLE integration DROP COLUMN company_name;
--ALTER TABLE integration DROP COLUMN company_branch_code;
--ALTER TABLE integration DROP COLUMN company_branch_name;
--ALTER TABLE integration DROP COLUMN employee_code;
--ALTER TABLE integration DROP COLUMN e_social_registration;
--ALTER TABLE integration DROP COLUMN cpf_number;
--ALTER TABLE integration DROP COLUMN employee_name;

ALTER TABLE integration ADD COLUMN stack_trace VARCHAR(4000);