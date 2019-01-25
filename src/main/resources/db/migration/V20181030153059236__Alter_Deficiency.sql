/*Entidade deficiência*/
lock table deficiency in access exclusive mode;
DELETE FROM deficiency;
ALTER TABLE deficiency ADD COLUMN employee varchar(36) NOT NULL;