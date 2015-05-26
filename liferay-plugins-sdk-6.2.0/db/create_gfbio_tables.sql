DROP TABLE 
gfbio_basket, gfbio_head, gfbio_position,  gfbio_project, gfbio_researchobject,  
gfbio_project_researchobject, gfbio_project_user, gfbio_project_user_pi;

-- Table: gfbio_basket

CREATE TABLE gfbio_basket
(
  basketid bigint NOT NULL,
  userid bigint NOT NULL,
  name character varying(75),
  lastmodifieddate timestamp without time zone,
  basketJSON text,
  queryJSON text,
  CONSTRAINT gfbio_basket_pkey PRIMARY KEY (basketid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_basket
  OWNER TO liferay_gfbio;


  
-- Table: gfbio_project

CREATE TABLE gfbio_project
(
  projectID bigint NOT NULL,
  name varchar(75),
  label varchar(75),
  description text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  status varchar(75),
  CONSTRAINT gfbio_project_pkey PRIMARY KEY (projectID)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project
  OWNER TO liferay_gfbio;
  

-- Table: gfbio_researchobject

CREATE TABLE gfbio_researchobject
(
  researchobjectid bigint NOT NULL,
  name character varying(75),
  label character varying(75),
  metadata character varying(5000),
  formatmetadata character varying(5000),
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;
  
  
-----------------------------------------------------------------------------------------
------------------------------------- Head & Position -----------------------------------
-----------------------------------------------------------------------------------------

-- Table: gfbio_head


CREATE TABLE gfbio_head
(
  headid bigint NOT NULL,
  name character(50) NOT NULL,
  task character(50) NOT NULL,
  column01 character(50),
  column02 character(50),
  column03 character(50),
  column04 character(50),
  column05 character(50),
  column06 character(50),
  column07 character(50),
  column08 character(50),
  column09 character(50),
  column10 character(50),
  column11 character(50),
  column12 character(50),
  column13 character(50),
  column14 character(50),
  column15 character(50),
  column16 character(50),
  column17 character(50),
  column18 character(50),
  column19 character(50),
  column20 character(50),
  CONSTRAINT gfbio_head_pkey PRIMARY KEY (headid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_head
  OWNER TO liferay_gfbio;
  
-- Table: gfbio_position


CREATE TABLE gfbio_position
(
  positionid bigint NOT NULL,
  headid bigint NOT NULL,
  column01 text,
  column02 text,
  column03 text,
  column04 text,
  column05 text,
  column06 text,
  column07 text,
  column08 text,
  column09 text,
  column10 text,
  column11 text,
  column12 text,
  column13 text,
  column14 text,
  column15 text,
  column16 text,
  column17 text,
  column18 text,
  column19 text,
  column20 text,
  CONSTRAINT gfbio_position_pkey PRIMARY KEY (positionid),
  CONSTRAINT gfbio_head_fkey FOREIGN KEY (headid)
      REFERENCES gfbio_head (headid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_position
  OWNER TO liferay_gfbio;
  
    



-----------------------------------------------------------------------------------------
------------------------------------- m to n tables -------------------------------------
-----------------------------------------------------------------------------------------
 
  
-- Table: gfbio_project_researchobject
  
CREATE TABLE gfbio_project_researchobject
(
  projectid bigint NOT NULL,
  researchobjectid bigint NOT NULL,
  CONSTRAINT gfbio_project_researchobject_pkey PRIMARY KEY (projectid, researchobjectid),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid)
      REFERENCES gfbio_researchobject (researchobjectid) MATCH SIMPLE
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
  projectid bigint NOT NULL,
  userid bigint NOT NULL,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  CONSTRAINT gfbio_project_user_pkey PRIMARY KEY (projectid, userid),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
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
  projectid bigint NOT NULL,
  userid bigint NOT NULL,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  CONSTRAINT gfbio_project_user_pi_pkey PRIMARY KEY (projectid, userid),
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_user_pi
  OWNER TO liferay_gfbio;
  
  


  
  
  
  