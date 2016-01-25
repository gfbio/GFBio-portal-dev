------------------------------- Data Provider / Persistent Identifier -----------------------

DROP TABLE IF EXISTS
     gfbio_dataprovider_persistentidentifier;

CREATE TABLE gfbio_dataprovider_persistentidentifier
(
  gfbio_dataprovider bigint NOT NULL,
  gfbio_persistentidentifier bigint NOT NULL,
  CONSTRAINT gfbio_dataprovider_persistentidentifier_pkey PRIMARY KEY (gfbio_dataprovider, gfbio_persistentidentifier),
  CONSTRAINT gfbio_dataprovider FOREIGN KEY (gfbio_dataprovider)
      REFERENCES gfbio_dataprovider (dataproviderid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_persistentidentifier FOREIGN KEY (gfbio_persistentidentifier)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_dataprovider_persistentidentifier
  OWNER TO liferay_gfbio;