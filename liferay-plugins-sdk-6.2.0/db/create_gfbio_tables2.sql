 DROP TABLE 
 gfbio_basket, gfbio_project, gfbio_researchobject,  
 gfbio_project_researchobject, gfbio_project_user, gfbio_project_user_pi,
 gfbio_position, gfbio_column, gfbio_head;

-- Table: gfbio_basket

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


  
-- Table: gfbio_project

CREATE TABLE gfbio_project
(
  projectId bigint NOT NULL,
  name varchar(75),
  label varchar(75),
  description text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  status varchar(75),
  CONSTRAINT gfbio_project_pkey PRIMARY KEY (projectId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project
  OWNER TO liferay_gfbio;
  

-- Table: gfbio_researchobject

CREATE TABLE gfbio_researchobject
(
  researchobjectId bigint NOT NULL,
  name character varying(75),
  label character varying(75),
  metadata character varying(5000),
  formatmetadata character varying(5000),
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;
  
  
-----------------------------------------------------------------------------------------
---------------------------------- Head, Column & Position --------------------------------
-----------------------------------------------------------------------------------------


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
  OWNER TO liferay;
  
  
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
  OWNER TO liferay;



  
  
  
  
-----------------------------------------------------------------------------------------
------------------------------------- m to n tables -------------------------------------
-----------------------------------------------------------------------------------------
 
  
-- Table: gfbio_project_researchobject
  
CREATE TABLE gfbio_project_researchobject
(
  projectId bigint NOT NULL,
  researchobjectId bigint NOT NULL,
  CONSTRAINT gfbio_project_researchobject_pkey PRIMARY KEY (projectId, researchobjectId),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectId)
      REFERENCES gfbio_project (projectId) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectId)
      REFERENCES gfbio_researchobject (researchobjectId) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_researchobject
  OWNER TO liferay_gfbio;
  

-- Table: gfbio_project_user

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

  
-- Table: gfbio_project_user_pi

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
  
  


  
  
  
  