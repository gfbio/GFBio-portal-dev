
------------------------------------- Research Object ------------------------------------- 
  
  
CREATE TABLE gfbio_researchobject
(
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL DEFAULT 1,
  parentresearchobjectid bigint,
  --sourceresearchobjectid bigint,
  --sourceresearchobjectversion smallint,
  name character varying(75),
  label character varying(75) NOT NULL,
  extendeddata text,
  researchobjecttype character varying(75) NOT NULL,
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid, researchobjectversion)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;