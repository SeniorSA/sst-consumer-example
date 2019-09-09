LOCK TABLE workstation IN ACCESS EXCLUSIVE MODE;

alter table workstation alter column structure_code drop not null;