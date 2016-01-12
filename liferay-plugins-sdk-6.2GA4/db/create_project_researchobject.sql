 
------------------------------- Project / Research Object -----------------------
  

CREATE TABLE gfbio_project_researchobject
(
  projectid bigint NOT NULL,
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL,
  CONSTRAINT gfbio_project_researchobject_pkey PRIMARY KEY (projectid, researchobjectid, researchobjectversion),
  CONSTRAINT gfbio_project FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_researchobject
  OWNER TO liferay_gfbio;