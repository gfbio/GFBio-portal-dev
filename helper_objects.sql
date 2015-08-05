SHOW search_path;
-- DROP TABLE IF EXISTS person;

CREATE TABLE person (
user_id smallserial NOT NULL PRIMARY KEY,
screenname text UNIQUE NOT NULL
);


CREATE TYPE ro_type AS ENUM ('sample', 'experiment');

-- DROP TABLE IF EXISTS research_object;
CREATE TABLE research_object (
research_object_id bigserial NOT NULL PRIMARY KEY,
research_object_version bigint NOT NULL DEFAULT 1 CHECK (research_object_version>0),
label text NOT NULL UNIQUE,
type ro_type NOT NULL,
UNIQUE (research_object_id,research_object_version)
);

CREATE FUNCTION increment_version() RETURNS trigger AS $inc_ver$
       BEGIN
        NEW.research_object_version := OLD.research_object_version+1;
	RETURN NEW;
       END;
$inc_ver$ LANGUAGE plpgsql;

CREATE TRIGGER ro_version_trgr
       BEFORE UPDATE ON research_object
       FOR EACH ROW
       EXECUTE PROCEDURE increment_version();


-- DROP TABLE IF EXISTS data_provider;
CREATE TABLE data_provider (
data_provider_id smallserial NOT NULL PRIMARY KEY,
label text UNIQUE NOT NULL
);


-- DROP TABLE IF EXISTS persistent_identifier;
CREATE TABLE persistent_identifier (
pid smallserial NOT NULL PRIMARY KEY,
name text UNIQUE NOT NULL,
label text UNIQUE NOT NULL
);
