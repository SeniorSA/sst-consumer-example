LOCK TABLE employee IN ACCESS EXCLUSIVE MODE;
ALTER TABLE employee DROP COLUMN e_social_category_type;
ALTER TABLE employee ADD COLUMN e_social_category UUID;