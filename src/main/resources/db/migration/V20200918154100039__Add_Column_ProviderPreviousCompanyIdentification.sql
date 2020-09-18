LOCK TABLE integration IN ACCESS EXCLUSIVE MODE;

ALTER TABLE integration ADD COLUMN provider_previous_company_identification VARCHAR(255);
