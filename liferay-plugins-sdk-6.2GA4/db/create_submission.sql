------------------------------- Submission -----------------------

DROP TABLE IF EXISTS
     gfbio_submission CASCADE;

CREATE TABLE gfbio_submission
(
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL,
  archive character(75) NOT NULL,
  archive_pid text DEFAULT NULL,
  archive_pid_type bigint,
  brokersubmissionid character(75) NOT NULL,
  last_changed timestamp with time zone NOT NULL DEFAULT now(),
  userid bigint NOT NULL,
  is_public boolean NOT NULL DEFAULT false,
  public_after timestamp with time zone DEFAULT NULL,
  status text NOT NULL,
  submissionid bigint NOT NULL,
  CONSTRAINT gfbio_submission_pkey PRIMARY KEY (submissionid),
  CONSTRAINT gfbio_dataprovider_fkey FOREIGN KEY (archive)
      REFERENCES gfbio_dataprovider (label) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_submission_uniquecolumns UNIQUE (researchobjectid, researchobjectversion, archive)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_submission
  OWNER TO liferay_gfbio;  
