-- Table: gfbio_project

-- DROP TABLE gfbio_project;

CREATE TABLE gfbio_project
(
  projectID bigint NOT NULL,
  name varchar(50),
  description text,
  CONSTRAINT project_pkey PRIMARY KEY (projectID)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project
  OWNER TO liferay_gfbio;