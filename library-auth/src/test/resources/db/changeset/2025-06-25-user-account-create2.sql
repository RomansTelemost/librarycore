CREATE TABLE application_user (
    id SERIAL PRIMARY KEY,
    first_name text not null,
    last_name text,
    birthday date,
    sex text
);

CREATE TABLE application_user_account (
    id bigint PRIMARY KEY REFERENCES application_user(id),
    login text UNIQUE not null,
    password text not null
);