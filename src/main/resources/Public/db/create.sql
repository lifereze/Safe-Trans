CREATE DATABASE safe_trans;
\c safe_trans;
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    user_id VARCHAR,
    location VARCHAR,
    type VARCHAR
);

CREATE DATABASE safe_trans_test WITH TEMPLATE safe_trans;