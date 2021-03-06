------------------------------------- Research Object -------------------------------------   

-- Table: gfbio_researchobject
-- DROP TABLE gfbio_researchobject;

CREATE TABLE gfbio_researchobject
(
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL DEFAULT 1,
  parentresearchobjectid bigint,
  name text NOT NULL,
  label text NOT NULL,
  extendeddata text,
  description text,
  metadataid bigint,
  licenseid bigint,
  researchobjecttype text,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  publications text,
  datacollectiontime text,
  embargo timestamp with time zone,
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid, researchobjectversion)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;
