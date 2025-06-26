CREATE TABLE application_user (
    id SERIAL PRIMARY KEY,
    first_name text,
    last_name text,
    birthday date,
    sex text
);

-- Таблица accounts (с user_id как FK)
CREATE TABLE application_user_account (
    id SERIAL PRIMARY KEY,
    login VARCHAR(255),
    password text not null,
    user_id BIGINT UNIQUE,  -- UNIQUE для связи 1:1
    FOREIGN KEY (user_id) REFERENCES application_user(id)
);