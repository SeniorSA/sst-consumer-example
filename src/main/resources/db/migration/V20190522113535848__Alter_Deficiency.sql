LOCK TABLE deficiency IN ACCESS EXCLUSIVE MODE;

ALTER TABLE deficiency
ALTER COLUMN employee TYPE uuid USING employee::uuid;

ALTER TABLE deficiency
ADD CONSTRAINT fk_deficiency_employee FOREIGN KEY (employee) REFERENCES employee (id);
