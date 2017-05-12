------------------------------- Primary data -----------------------

--DROP TABLE IF EXISTS
--     gfbio_primarydata CASCADE;



CREATE TABLE gfbio_primarydata
(
  primarydataid bigint NOT NULL,
  path character(150),
  name character(200),
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_primarydata_pkey PRIMARY KEY (primarydataid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_primarydata
  OWNER TO liferay_gfbio;
