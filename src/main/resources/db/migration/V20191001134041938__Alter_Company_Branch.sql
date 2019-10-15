LOCK TABLE company_branch IN ACCESS EXCLUSIVE MODE;

alter table company_branch add column company_branch_name VARCHAR(255);