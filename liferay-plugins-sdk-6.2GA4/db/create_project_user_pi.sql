------------------------------- Project / User Pi -----------------------

DROP TABLE IF EXISTS
     gfbio_project_user_pi;

CREATE TABLE gfbio_project_user_pi
(
  projectId bigint NOT NULL,
  userId bigint NOT NULL,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  CONSTRAINT gfbio_project_user_pi_pkey PRIMARY KEY (projectId, userId),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectId)
      REFERENCES gfbio_project (projectId) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_user_pi
  OWNER TO liferay_gfbio;