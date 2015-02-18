

-- Table: gfbio_project

CREATE TABLE gfbio_project
(
  projectID bigint NOT NULL,
  name varchar(50),
  description text,
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
  metadata character varying(75),
  CONSTRAINT gfbio_researchobject_pkey PRIMARY KEY (researchobjectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject
  OWNER TO liferay_gfbio;
  
  

-----------------------------------------------------------------------------------------
------------------------------------- m to n tables -------------------------------------
-----------------------------------------------------------------------------------------


-- Table: gfbio_project_researchobject
  
CREATE TABLE gfbio_project_researchobject
(
  projectid bigint NOT NULL,
  researchobjectid bigint NOT NULL,
  CONSTRAINT gfbio_project_researchobject_pkey PRIMARY KEY (projectid, researchobjectid)
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
  begin_ timestamp without time zone,
  end_ timestamp without time zone,
  CONSTRAINT gfbio_project_user_pkey PRIMARY KEY (projectid, userid)
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
  begin_ timestamp without time zone,
  end_ timestamp without time zone,
  CONSTRAINT gfbio_project_user_pi_pkey PRIMARY KEY (projectid, userid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_project_user_pi
  OWNER TO liferay_gfbio;



  
  
  