------------------------------------- Content  ------------------------------------- 

--DROP TABLE IF EXISTS
--     gfbio_content;

CREATE TABLE gfbio_content
(
  contentid bigint NOT NULL,
  headid bigint NOT NULL,
  columnid bigint NOT NULL,
  rowid bigint NOT NULL,
  cellcontent text,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_content_pkey PRIMARY KEY (contentid),
  CONSTRAINT gfbio_column_fkey FOREIGN KEY (columnid)
      REFERENCES gfbio_column (columnid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_head_fkey FOREIGN KEY (headid)
      REFERENCES gfbio_head (headid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_content
  OWNER TO liferay_gfbio;