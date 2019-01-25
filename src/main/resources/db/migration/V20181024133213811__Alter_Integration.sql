lock table integration in access exclusive mode;
alter table integration add column integration_sequence NUMERIC(19) not null default 1;
ALTER TABLE integration ALTER COLUMN integration_sequence DROP NOT NULL;