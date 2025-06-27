<<<<<<< HEAD
=======
drop table application_user;

>>>>>>> origin/new_application_user_account_table
create table application_user_account
(
id SERIAL PRIMARY KEY,
login text UNIQUE not null,
<<<<<<< HEAD
password text not null,
user_id BIGINT UNIQUE

=======
password text not null
>>>>>>> origin/new_application_user_account_table
);

create table application_user
(
id bigint PRIMARY KEY REFERENCES application_user_account (id),
first_name text not null,
last_name text not null,
birthday date not null,
sex text not null
);

