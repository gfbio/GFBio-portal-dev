
----------------------------------------------------------------------------------------------
---------------------------------     researchobject user      -------------------------------
----------------------------------------------------------------------------------------------

--DROP TABLE IF EXISTS
--     gfbio_researchobject_user CASCADE;

CREATE TABLE gfbio_researchobject_user
(
  researchobjectid bigint NOT NULL,
  userid bigint NOT NULL,
  startdate timestamp with time zone,
  enddate timestamp with time zone,
  usertype character(40),
  researchobjectversion integer,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_researchobject_user_pkey PRIMARY KEY (researchobjectid, userid),
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject_user
  OWNER TO liferay_gfbio;
