DROP TABLE IF EXISTS
 gfbio_project_researchobject, gfbio_project_user, gfbio_project_user_pi, gfbio_dataprovider_persistentidentifier,
 gfbio_content, gfbio_column, gfbio_head,
 gfbio_basket, gfbio_project, gfbio_submissionregistry, gfbio_dataprovider, gfbio_researchobject;
 
 
 -- CREATE TYPE ro_type AS ENUM ('sample', 'experiment');
 -- CREATE TYPE submission_status AS ENUM ('sent', 'archived');
 
 
 
 
 
-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------      Tables      -----------------------------------
-------------------------------------------------------------------------------------------


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
  
  
------------------------------------- Content  ------------------------------------- 
  
  
CREATE TABLE gfbio_content
(
  contentid bigint NOT NULL,
  headid bigint NOT NULL,
  columnid bigint NOT NULL,
  rowid bigint NOT NULL,
  cellcontent text,
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
 
  
---------------------------------------------------------------------------------------------
--------------------------------------- Other entities --------------------------------------
--------------------------------------      Tables     --------------------------------------
---------------------------------------------------------------------------------------------


------------------------------------- Basket ------------------------------------- 


CREATE TABLE gfbio_basket
(
  basketId bigint NOT NULL,
  userId bigint NOT NULL,
  name character varying(75),
  lastmodifieddate timestamp without time zone,
  basketJSON text,
  queryJSON text,
  CONSTRAINT gfbio_basket_pkey PRIMARY KEY (basketId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_basket
  OWNER TO liferay_gfbio;

  
------------------------------------- Data Provider ------------------------------------- 


CREATE TABLE gfbio_dataprovider
(
  dataproviderid bigint NOT NULL,
  name character(150) NOT NULL,
  label character(75) NOT NULL,
  description text,
  address text,
  website character(150),
  training text,
  CONSTRAINT gfbio_dataprovider_pkey PRIMARY KEY (dataproviderid),
  CONSTRAINT gfbio_dataprovider_label_key UNIQUE (label),
  CONSTRAINT gfbio_dataprovider_unique_label UNIQUE (label)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_dataprovider
  OWNER TO liferay_gfbio;


------------------------------------- Project ------------------------------------- 
  

CREATE TABLE gfbio_project
(
  projectid bigint NOT NULL,
  name varchar(75),
  label varchar(75),
  description text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  status varchar(75),
  parentprojectid bigint,
  CONSTRAINT gfbio_project_pkey PRIMARY KEY (projectId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project
  OWNER TO liferay_gfbio;
  

------------------------------------- Research Object ------------------------------------- 
  
  
CREATE TABLE gfbio_researchobject
(
  researchobjectid bigint NOT NULL,
  name character varying(75),
  label character varying(75) NOT NULL,
  metadata character varying(5000),
  formatmetadata character varying(5000),
  researchobjectversion smallint NOT NULL DEFAULT 1,
  researchobjecttype character varying(75) NOT NULL,
  parentresearchobjectid bigint,
  --sourceresearchobjectid bigint,
  --sourceresearchobjectversion smallint,
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid, researchobjectversion)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;

  
  
------------------------------------- Submission Registry ------------------------------------- 
  

CREATE TABLE gfbio_submissionregistry
(
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL,
  archive character(75) NOT NULL,
  archive_pid text,
  archive_pid_type bigint,
  brokersubmissionid character(75)  NOT NULL,
  last_changed timestamp with time zone NOT NULL DEFAULT now(),
  userid bigint NOT NULL,
  is_public boolean NOT NULL DEFAULT false,
  public_after time with time zone DEFAULT (now() + '6 mons'::interval),
  status text NOT NULL,
  CONSTRAINT gfbio_submissionregistry_pkey PRIMARY KEY (researchobjectid, researchobjectversion, archive),
  CONSTRAINT gfbio_dataprovider_fkey FOREIGN KEY (archive)
      REFERENCES gfbio_dataprovider (label) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_submissionregistry
  OWNER TO liferay_gfbio;  
  
  
---------------------------------------------------------------------------------------------
------------------------------------ Other relationships ------------------------------------
--------------------------------------      Tables     --------------------------------------
---------------------------------------------------------------------------------------------
 
 
------------------------------- Data Provider / Persistent Identifier -----------------------
 

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

 
------------------------------- Project / Research Object -----------------------
  
  

CREATE TABLE gfbio_project_researchobject
(
  projectid bigint NOT NULL,
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL,
  CONSTRAINT gfbio_project_researchobject_pkey PRIMARY KEY (projectid, researchobjectid, researchobjectversion),
  CONSTRAINT gfbio_project FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_researchobject
  OWNER TO liferay_gfbio;
  

------------------------------- Project / User -----------------------


CREATE TABLE gfbio_project_user
(
  projectId bigint NOT NULL,
  userId bigint NOT NULL,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  CONSTRAINT gfbio_project_user_pkey PRIMARY KEY (projectId, userId),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectId)
      REFERENCES gfbio_project (projectId) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_user
  OWNER TO liferay_gfbio;

  
------------------------------- Project / User Pi -----------------------


CREATE TABLE gfbio_project_user_pi
(
  projectId bigint NOT NULL,
  userId bigint NOT NULL,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  CONSTRAINT gfbio_project_user_pi_pkey PRIMARY KEY (projectId, userId),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectId)
      REFERENCES gfbio_project (projectId) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_user_pi
  OWNER TO liferay_gfbio;
  
  


  
  
  
  