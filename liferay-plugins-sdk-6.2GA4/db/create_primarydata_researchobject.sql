------------------------------- Primary data / Research Object-----------------------


--DROP TABLE IF EXISTS
--     gfbio_primarydata_researchobject CASCADE;


CREATE TABLE gfbio_primarydata_researchobject
(
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL,
  primarydataid bigint NOT NULL,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_primarydata_researchobject_pkey PRIMARY KEY (researchobjectid, researchobjectversion, primarydataid),
  CONSTRAINT gfbio_primarydata_fkey FOREIGN KEY (primarydataid)
      REFERENCES gfbio_primarydata (primarydataid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_primarydata_researchobject
  OWNER TO liferay_gfbio;
