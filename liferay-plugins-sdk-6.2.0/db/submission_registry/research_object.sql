CREATE TYPE ro_type AS ENUM ('sample', 'experiment');

-- DROP TABLE IF EXISTS gfbio_researchobject;
CREATE TABLE gfbio_researchobject (
researchobjectId bigserial NOT NULL,
name character varying(75),
label character varying(75) NOT NULL UNIQUE,
metadata character varying(5000),
formatmetadata character varying(5000),
research_object_version smallint NOT NULL DEFAULT 1 CHECK (research_object_version>0),
type ro_type NOT NULL,
CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;

--Trigger function to increment version number of research objects
CREATE FUNCTION increment_version() RETURNS trigger AS $inc_ver$
       BEGIN
       --Only increment the version number if the update actually changes the object
       --This can be narrowed down to specific columns, or zero-change updates could be ignored altogether.
	IF ( NEW != OLD ) THEN
	        NEW.research_object_version := OLD.research_object_version+1;
	END IF;
	RETURN NEW;
       END;
$inc_ver$ LANGUAGE plpgsql;

--Triger definition for version increment
CREATE TRIGGER ro_version_trgr
       BEFORE UPDATE ON gfbio_researchobject
       FOR EACH ROW
       EXECUTE PROCEDURE increment_version();

--A function to create a research objects and get its id back.
CREATE OR REPLACE FUNCTION add_research_object(in_label text,in_type ro_type) RETURNS bigint AS $$
    DECLARE
        roid bigint;
    BEGIN
	INSERT INTO gfbio_researchobject (label,type) VALUES (in_label,in_type) RETURNING researchobjectId INTO STRICT roid;
	RETURN roid;
    END;
$$ LANGUAGE plpgsql;
