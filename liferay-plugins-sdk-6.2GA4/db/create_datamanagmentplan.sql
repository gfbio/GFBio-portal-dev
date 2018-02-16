
----------------------------------------------------------------------------------------------------------------------
-------------------------------------              datamanagementplan              -----------------------------------
----------------------------------------------------------------------------------------------------------------------

CREATE TABLE gfbio_datamanagementplan
(
  dmpid bigint NOT NULL,
  name character(150) NOT NULL,
  userid bigint NOT NULL,
  dmptinput text,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_datamanagementplan_pkey PRIMARY KEY (dmpid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_datamanagementplan
  OWNER TO liferay_gfbio;