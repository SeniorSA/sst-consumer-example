LOCK TABLE EMPLOYEE IN ACCESS EXCLUSIVE MODE;

alter table employee add column ctps_number VARCHAR(255); /* ctpsNumber */
alter table employee add column ctps_serie VARCHAR(5); /* ctpsSerie */
alter table employee add column ctps_serie_digit VARCHAR(5); /* ctpsSerieDigit */
alter table employee add column ctps_issuance_date DATE; /* ctpsIssuanceDate */
alter table employee add column ctps_state VARCHAR(255); /* ctpsState */
alter table employee add column rg_number VARCHAR(255); /* rgNumber */
alter table employee add column rg_issuer VARCHAR(255); /* rgIssuer */
alter table employee add column rg_state VARCHAR(255); /* rgState */
alter table employee add column rg_issuance_date DATE; /* rgIssuanceDate */
