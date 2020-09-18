LOCK TABLE employee IN ACCESS EXCLUSIVE MODE;

ALTER TABLE employee ADD COLUMN previous_company UUID;
ALTER TABLE employee ADD CONSTRAINT fk_employee_previous_company FOREIGN KEY (previous_company) REFERENCES company (id);
