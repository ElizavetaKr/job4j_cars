create table owner (
id serial primary key,
name varchar unique not null,
user_id int not null references auto_user(id)

);