------------------------------------- Head  -------------------------------------

--DROP TABLE IF EXISTS
--     gfbio_head CASCADE;

CREATE TABLE gfbio_head
(
  headid bigint NOT NULL,
  table_name text NOT NULL,
  table_type text NOT NULL,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_head_pkey PRIMARY KEY (headid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_head
  OWNER TO liferay_gfbio;
  
