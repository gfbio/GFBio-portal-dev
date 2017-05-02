------------------------------------- Data Provider ------------------------------------- 

DROP TABLE IF EXISTS 
     gfbio_dataprovider CASCADE;


CREATE TABLE gfbio_dataprovider
(
  dataproviderid bigint NOT NULL,
  name character(150) NOT NULL,
  label character(75) NOT NULL,
  description text,
  address text,
  website character(150),
  training text,
  providertype character(75),
  taxonbased boolean,
  notaxonbased boolean,
  livingobjects boolean,
  deadobjects boolean,
  sequencedata boolean,
  CONSTRAINT gfbio_dataprovider_pkey PRIMARY KEY (dataproviderid),
  CONSTRAINT gfbio_dataprovider_label_key UNIQUE (label)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_dataprovider
  OWNER TO liferay_gfbio;
