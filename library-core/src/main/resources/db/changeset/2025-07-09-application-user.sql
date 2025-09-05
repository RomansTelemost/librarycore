CREATE TABLE application_user (
    id SERIAL PRIMARY KEY,
    login text UNIQUE NOT NULL,
    first_name text NOT NULL,
    last_name text,
    birthday date,
    sex text
);