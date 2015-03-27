DROP TABLE gfbio_project, gfbio_researchobject, gfbio_basket, gfbio_project_researchobject, gfbio_project_user, gfbio_project_user_pi;

-- Table: gfbio_project

CREATE TABLE gfbio_project
(
  projectID bigint NOT NULL,
  name varchar(50),
  label varchar(50),
  description text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  status varchar(50),
  CONSTRAINT project_pkey PRIMARY KEY (projectID)
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
  label character varying(50),
  metadata character varying(5000),
  formatmetadata character varying(5000),
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;
  
    
-- Table: gfbio_basket

CREATE TABLE gfbio_basket
(
  basketid bigint NOT NULL,
  userid bigint NOT NULL,
  name character varying(75),
  basketJSON text,
  queryJSON text,
  CONSTRAINT gfbio_basket_pkey PRIMARY KEY (basketid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_basket
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


  
  
  