
------------------------------------- Column   ------------------------------------- 


CREATE TABLE gfbio_column
(
  columnid bigint NOT NULL,
  headid bigint NOT NULL,
  column_name text,
  CONSTRAINT gfbio_column_pkey PRIMARY KEY (columnid),
  CONSTRAINT gfbio_head_fkey FOREIGN KEY (headid)
      REFERENCES gfbio_head (headid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_column
  OWNER TO liferay_gfbio;
  
  
  