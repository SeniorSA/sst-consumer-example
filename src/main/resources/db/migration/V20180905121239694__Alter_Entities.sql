/* Entity CompanyBranch */
lock table company_branch in access exclusive mode;
alter table company_branch add column date_when date not null default '2018-01-01';

/* Entity CostCenter */
lock table cost_center in access exclusive mode;
alter table cost_center add column date_when date not null default '2018-01-02';

/* Entity Deficiency */
lock table deficiency in access exclusive mode;
alter table deficiency add column date_when date not null default '2018-01-03';
alter table deficiency add column is_rehabilitated boolean not null default false;

/* Entity Department */
lock table department in access exclusive mode;
alter table department add column date_when date not null default '2018-01-04';

/* Entity JobPosition */
lock table job_position in access exclusive mode;
alter table job_position add column date_when date not null default '2018-01-05';

/* Entity ReasonLeave */
lock table reason_leave in access exclusive mode;
alter table reason_leave add column start_date timestamp;
alter table reason_leave add column end_date timestamp;
alter table reason_leave add column estimated_end_date date;

/* Entity Shift */
lock table shift in access exclusive mode;
alter table shift add column date_when date not null default '2018-02-02';

/* Entity Workstation */
lock table workstation in access exclusive mode;
alter table workstation add column date_when date not null default '2018-03-03';

/* Entity Employee */
lock table employee in access exclusive mode;
alter table employee add column dismissal_date date;
