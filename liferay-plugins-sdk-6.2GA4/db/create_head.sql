
------------------------------------- Head  -------------------------------------


CREATE TABLE gfbio_head
(
  headid bigint NOT NULL,
  table_name text NOT NULL,
  table_type text NOT NULL,
  CONSTRAINT gfbio_head_pkey PRIMARY KEY (headid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_head
  OWNER TO liferay_gfbio;
  
