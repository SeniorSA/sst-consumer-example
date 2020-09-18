LOCK TABLE employee IN ACCESS EXCLUSIVE MODE;

ALTER TABLE employee ADD COLUMN previous_company_branch UUID;
ALTER TABLE employee ADD CONSTRAINT fk_employee_previous_company_branch FOREIGN KEY (previous_company_branch) REFERENCES company_branch (id);
