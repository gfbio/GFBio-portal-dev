------------------------------------- Project ------------------------------------- 

--DROP TABLE IF EXISTS 
--     gfbio_project CASCADE;

CREATE TABLE gfbio_project
(
  projectid bigint NOT NULL,
  name text NOT NULL,
  label text NOT NULL,
  extendeddata text,
  description text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  status text,
  parentprojectid bigint,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_project_pkey PRIMARY KEY (projectId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project
  OWNER TO liferay_gfbio;