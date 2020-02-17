-- Table: gfbio_usergoesternid

DROP TABLE IF EXISTS gfbio_usergoesternid;

CREATE TABLE gfbio_usergoesternid
(
  userid bigint NOT NULL,
  goesternid VARCHAR(255) NOT NULL,
  lastmodifieddate timestamp without time zone,
  CONSTRAINT gfbio_usergoesternid_pkey PRIMARY KEY (userid, goesternid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_usergoesternid
  OWNER TO liferay_gfbio;
