LOCK TABLE integration IN ACCESS EXCLUSIVE MODE;
ALTER TABLE integration ADD COLUMN operation_type VARCHAR(255) NOT NULL DEFAULT 'INSERT';
