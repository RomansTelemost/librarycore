create table author
(
id SERIAL PRIMARY KEY,
first_name text not null,
last_name text not null,
middle_name text,
birthday date not null,
death_date date
);

create table book
(
id SERIAL PRIMARY KEY,
title text not null,
author_id int not null REFERENCES author(id)
);


