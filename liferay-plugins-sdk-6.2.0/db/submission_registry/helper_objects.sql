SHOW search_path;

--This is a mockup of the 'user' table
-- DROP TABLE IF EXISTS person;
CREATE TABLE person (
user_id smallserial NOT NULL PRIMARY KEY,
screenname text UNIQUE NOT NULL
);


-- DROP TABLE IF EXISTS data_provider;
CREATE TABLE data_provider (
data_provider_id smallserial NOT NULL PRIMARY KEY,
label text UNIQUE NOT NULL
);
