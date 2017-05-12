------------------------------ UserSSO ------------------------------- 

--DROP TABLE IF EXISTS
--	gfbio_usersso;

CREATE TABLE gfbio_usersso
(
  userId bigint NOT NULL,
  token text,
  lastmodifieddate timestamp without time zone,
  CONSTRAINT gfbio_usersso_pkey PRIMARY KEY (userId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_usersso
  OWNER TO liferay_gfbio;