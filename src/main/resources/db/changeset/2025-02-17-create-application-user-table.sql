create table application_user
(
login text PRIMARY KEY,
first_name text not null,
last_name text not null,
birthday date not null,
sex text not null,
password text not null
);
