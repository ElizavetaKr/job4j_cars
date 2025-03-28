ALTER TABLE auto_post DROP COLUMN auto_user_id;
ALTER TABLE auto_post ADD COLUMN car_id  int references car(id);