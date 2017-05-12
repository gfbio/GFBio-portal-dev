----------------------------     funding / institution project      -------------------------

--DROP TABLE IF EXISTS
--     gfbio_funding_personproject CASCADE;

CREATE TABLE gfbio_funding_personproject
(
  projectid bigint NOT NULL,
  fundingagencyid bigint NOT NULL,
  fundingprogramid bigint NOT NULL,
  personid bigint NOT NULL,
  persontype character(75) NOT NULL,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_funding_personproject_pkey PRIMARY KEY (projectid, fundingagencyid, fundingprogramid, personid, persontype),
  CONSTRAINT gfbio_fundingagency_fkey FOREIGN KEY (fundingagencyid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_fundingprogram_fkey FOREIGN KEY (fundingprogramid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_funding_personproject
  OWNER TO liferay_gfbio;