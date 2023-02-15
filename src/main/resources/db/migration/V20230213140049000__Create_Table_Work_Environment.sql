CREATE TABLE IF NOT EXISTS work_environment (
   id UUID NOT NULL,
   location VARCHAR(255) NOT NULL,
   code VARCHAR(255) NOT NULL,
   name VARCHAR(255) NOT NULL,
   subscription_type VARCHAR(255) NOT NULL,
   subscription_number VARCHAR(255) NOT NULL,
   date_when date NOT NULL,
   CONSTRAINT pk_work_environment PRIMARY KEY (id)
);
