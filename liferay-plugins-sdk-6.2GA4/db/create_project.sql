------------------------------------- Project ------------------------------------- 

DROP TABLE IF EXISTS
     gfbio_project;

CREATE TABLE gfbio_project
(
  projectid bigint NOT NULL,
  name varchar(75),
  label varchar(75),
  description text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  status varchar(75),
  parentprojectid bigint,
  CONSTRAINT gfbio_project_pkey PRIMARY KEY (projectId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project
  OWNER TO liferay_gfbio;