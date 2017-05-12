----------------------------     funding / institution project      -------------------------

--DROP TABLE IF EXISTS
--     gfbio_funding_institutionproject CASCADE;

CREATE TABLE gfbio_funding_institutionproject
(
  projectid bigint NOT NULL,
  fundingagencyid bigint NOT NULL,
  fundingprogramid bigint NOT NULL,
  institutionid bigint NOT NULL,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_funding_institutionproject_pkey PRIMARY KEY (projectid, fundingagencyid, fundingprogramid, institutionid),
  CONSTRAINT gfbio_fundingagency_fkey FOREIGN KEY (fundingagencyid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_fundingprogram_fkey FOREIGN KEY (fundingprogramid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_institution_fkey FOREIGN KEY (institutionid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_funding_institutionproject
  OWNER TO liferay_gfbio; 