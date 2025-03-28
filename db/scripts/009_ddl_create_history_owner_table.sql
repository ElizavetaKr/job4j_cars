CREATE TABLE history_owner (
   id serial PRIMARY KEY,
   car_id int not null REFERENCES car(id),
   owner_id int not null REFERENCES owner(id),
   UNIQUE (car_id, owner_id)
);