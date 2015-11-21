CREATE TABLE gfbio_submissionregistry
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
  public_after time with time zone DEFAULT NULL,
  status text NOT NULL,
  CONSTRAINT gfbio_submissionregistry_pkey PRIMARY KEY (researchobjectid, researchobjectversion, archive),
  CONSTRAINT gfbio_dataprovider_fkey FOREIGN KEY (archive)
      REFERENCES gfbio_dataprovider (label) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_submissionregistry
  OWNER TO liferay_gfbio;  
