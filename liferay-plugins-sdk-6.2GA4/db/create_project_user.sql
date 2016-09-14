------------------------------- Project / User -----------------------

DROP TABLE IF EXISTS
     gfbio_project_user CASCADE;

CREATE TABLE gfbio_project_user
(
  projectId bigint NOT NULL,
  userId bigint NOT NULL,
  startdate timestamp with time zone,
  enddate timestamp with time zone,
  usertype character(40) NOT NULL,
  CONSTRAINT gfbio_project_user_pkey PRIMARY KEY (projectId, userId),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectId)
      REFERENCES gfbio_project (projectId) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_user
  OWNER TO liferay_gfbio;
 
