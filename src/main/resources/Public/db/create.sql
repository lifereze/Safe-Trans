CREATE DATABASE safetrans;
\c safetrans;
CREATE TABLE IF NOT EXISTS landlord (
    landlordId SERIAL PRIMARY KEY,
    landlordName VARCHAR,
    apartment VARCHAR,
    location VARCHAR
);

CREATE TABLE IF NOT EXISTS tenant (
    tenantId SERIAL PRIMARY KEY,
    tenantName  VARCHAR,
    houseNumber INT,
    exitDate VARCHAR
);