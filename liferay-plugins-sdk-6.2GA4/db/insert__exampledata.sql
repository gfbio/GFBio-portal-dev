---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   helper for this script   -----------------------------
---------------------------------------------------------------------------------------------

create or replace function getExampleUserId() RETURNS TABLE (mr bigint) AS
$$
	Select cast (10199 as bigint);
$$
language 'sql' STABLE;


----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
------------------------------------      project      -- 18.05.2016 -------------------------
----------------------------------------------------------------------------------------------

--
create or replace function getMaxProjectId() RETURNS TABLE (maxid bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(projectid) =0 
			THEN 
				0 
			ELSE
				MAX(projectid)
			END 
		) as projectid
	FROM
		public.gfbio_project
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewProjectId() RETURNS bigint AS
$$
	SELECT getMaxProjectId()+1;
$$	
language 'sql' STABLE;


----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
----------------------------------   dynamic research object 18.05.2017 ----------------------
----------------------------------------------------------------------------------------------


--
create or replace function getMaxResearchObjectId() RETURNS TABLE (maxid bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(researchobjectid) =0 
			THEN 
				0 
			ELSE
				MAX(researchobjectid)
			END 
		) as researchobjectid
	FROM
		public.gfbio_researchobject
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewResearchObjectId() RETURNS bigint AS
$$
	SELECT getMaxResearchObjectId()+1;
$$	
language 'sql' STABLE;


--------------------------------------------------------------------------------------------
---------------------------------------- Functions -----------------------------------------
---------------------------------      submission      -- 18.05.2016 -----------------------
--------------------------------------------------------------------------------------------


--
create or replace function getMaxSubmissionId() RETURNS TABLE (maxid bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(submissionid) =0 
			THEN 
				0 
			ELSE
				MAX(submissionid)
			END 
		) as submissionid
	FROM
		public.gfbio_submission
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewSubmissionId() RETURNS bigint AS
$$
	SELECT getMaxSubmissionId()+1;
$$	
language 'sql' STABLE;



----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
-----------------------------------   dynamic primary data 18.05.2017 ------------------------
----------------------------------------------------------------------------------------------



--
create or replace function getMaxPrimaryDataId() RETURNS TABLE (maxid bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(primarydataid) =0 
			THEN 
				0 
			ELSE
				MAX(primarydataid)
			END 
		) as primarydataid
	FROM
		public.gfbio_primarydata
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewPrimaryDataId() RETURNS bigint AS
$$
	SELECT getMaxPrimaryDataId()+1;
$$	
language 'sql' STABLE;


--------------------------------------------------------------------------------------------
-----------------------------------      project      -- 18.05.2016 ------------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_project (projectid, name, label, extendeddata, description, startdate, enddate, status, parentprojectid, lastmodifieddate)
VALUES(
	getNewProjectId(),
	'Project A: Great Parent Project example with many/75 character in the title',
	'Project A' ,
	'{"pi":"Alice, Bob"}',
 	'It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. ',
	'1963-11-24 03:15:00',
 	'1963-11-24 03:15:00',
 	'planning',
	0,
	'2017-05-02 14:08:06.928+02'
);

INSERT INTO gfbio_project_user (projectid, userid, usertype, lastmodifieddate)
VALUES(
	getMaxProjectId(),
	getExampleUserId(),
	'owner',
	'2017-05-02 14:08:06.928+02'
);

INSERT INTO gfbio_project (projectid, name, label, extendeddata, description, startdate, enddate, status, parentprojectid, lastmodifieddate)
VALUES(
	getNewProjectId(),
	'Project B: Subproject',
	'Project A.B' ,
	'{"pi":"Alice"}',
 	'It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. ',
	'1963-11-24 03:15:00',
 	'1963-11-24 03:15:00',
 	'planning',
	getMaxProjectId(),
	'2017-05-02 14:08:06.928+02'
);


INSERT INTO gfbio_project_user (projectid, userid, usertype, lastmodifieddate)
VALUES(
	getMaxProjectId(),
	getExampleUserId(),
	'owner',
	'2017-05-02 14:08:06.928+02'
);


--------------------------------------------------------------------------------------------
-------------------------------      external person      -- 18.05.2016 --------------------
--------------------------------------------------------------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'id'), 	getNewRowId(),	getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'name'), 	getMaxRowId(),	'Example Alice');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'mail'), 	getMaxRowId(),	'alice@examlpe.example');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'orcid'), 	getMaxRowId(),	'ORCI-DEXA-MPLE-001X');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'lastmodifieddate'), 	getMaxRowId(),	now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'id'), 	getNewRowId(),	getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'name'), 	getMaxRowId(),	'Example Bob');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'mail'), 	getMaxRowId(),	'bob@examlpe.example');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'orcid'), 	getMaxRowId(),	'ORCI-DEXA-MPLE-002X');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_externalperson')), getColumnIdByNames('gfbio_externalperson', 'lastmodifieddate'), 	getMaxRowId(),	now());


--------------------------------------------------------------------------------------------
--------------------------------      primary data      -- 18.05.2016 ----------------------
--------------------------------------------------------------------------------------------


-- it's in the research object area


--------------------------------------------------------------------------------------------
---------------------------------      submission      -- 18.05.2016 -----------------------
--------------------------------------------------------------------------------------------


-- it's in the research object area


--------------------------------------------------------------------------------------------
-------------------------------      research object      -- 18.05.2016 --------------------
--------------------------------------------------------------------------------------------

--basic ro 01: all relations
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, parentresearchobjectid, name, label, extendeddata, description, metadataid, licenseid, researchobjecttype)
VALUES(
	getNewResearchObjectId(),
	1,
	0,
	'Dataset a: Large ResearchObject Title example with many/74 character',
	'Dataset a' ,
	'{"datacollectiontime":"summer 2016","publications":"no publications","legalrequirements":["Nagoya","Personal"],"embargo":"2017-12-31"}',
 	'It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. ',
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD'))),
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0'))),
	'Dataset'
);


-- ro 01 - user
INSERT INTO gfbio_researchobject_user (researchobjectid, researchobjectversion, userid, usertype)
VALUES(
	getMaxResearchObjectId(),
	1,
	getExampleUserId(),
	'owner'
);


-- ro 01 - external person (author)
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Alice' ,  cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Bob' ,  cast (getMaxResearchObjectId() AS text) );


-- primarydata - ro 01
INSERT INTO gfbio_primarydata(primarydataid, path, name)
VALUES(
	getNewPrimaryDataId(),
	'example\userid\researchobjectid\researchobjectversion\examplesample of examplefield 01.csv',
	'examplesample of examplefield 01.csv'
);

INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid)
VALUES(
	getMaxResearchObjectId(),
	1,
	getMaxPrimaryDataId()
);

INSERT INTO gfbio_primarydata(primarydataid, path, name)
VALUES(
	getNewPrimaryDataId(),
	'example\userid\researchobjectid\researchobjectversion\examplesample of examplefield 02.csv',
	'examplesample of examplefield 02.csv'
);

INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid)
VALUES(
	getMaxResearchObjectId(),
	1,
	getMaxPrimaryDataId()
);

-- project - ro 01
INSERT INTO gfbio_project_researchobject (projectid, researchobjectid, researchobjectversion)
VALUES(
	getMaxProjectId(),
	getMaxResearchObjectId(),
	1
);

--submission - ro 01
INSERT INTO gfbio_submission (researchobjectid, researchobjectversion, archive, archive_pid,  brokersubmissionid, userid, is_public, public_after, status, submissionid, jiraid,jirakey)
VALUES(
	getMaxResearchObjectId(),
	1,
	'GFBio collections',
	'' ,
	'0000015b-a51e-fed3-0000-015ba51efed3', --id from  a random submission in our JIRA
	getExampleUserId(),
	false,
	'2017-12-31',
	'sent',
	getNewSubmissionId(),
	'11952', 								--id from  a random submission in our JIRA
	'SAND-752'								--key from  a random submission in our JIRA
);

--submission - ro 01
INSERT INTO gfbio_submission (researchobjectid, researchobjectversion, archive, archive_pid, archive_pid_type, brokersubmissionid, userid, is_public, public_after, status, submissionid, jiraid,jirakey)
VALUES(
	getMaxResearchObjectId(),
	1,
	'PANGAEA',
	'https://doi.org/10.1000/182',
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_persistentidentifier', 'label', 'DOI'))),
	'0000015a-f121-293b-0000-015af121293b', --id of a random submission in our JIRA
	getExampleUserId(),
	false,
	'2017-12-31',
	'archived',
	getNewSubmissionId(),
	'11819',								--id from  a random submission in our JIRA
	'SAND-647'								--key from  a random submission in our JIRA
);




-- ro 01 - category
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_researchobject' , 		'gfbio_category' , 			'gfbio_researchobject' ,  'name' ,  'Algae & Protists' ,  		cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_researchobject' , 		'gfbio_category' , 			'gfbio_researchobject' ,  'name' ,  'Botany' ,  				cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_researchobject' , 		'gfbio_category' , 			'gfbio_researchobject' ,  'name' ,  'Ecology' ,  				cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_researchobject' , 		'gfbio_category' , 			'gfbio_researchobject' ,  'name' ,  'Zoology' ,  				cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_researchobject' , 		'gfbio_category' , 			'gfbio_researchobject' ,  'label' , 'Other' ,  					cast (getMaxResearchObjectId() AS text) );



--basic ro 02: child of ro 01 and no sent data, ut with more extended data
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, parentresearchobjectid, name, label, extendeddata, description, metadataid, licenseid, researchobjecttype)
VALUES(
	getNewResearchObjectId(),
	1,
	getMaxResearchObjectId(),
	'Dataset b: Large ResearchObject Title example with many/74 character',
	'Dataset a.b' ,
	'{"datacollectiontime":"summer 2016","publications":"no publications","legalrequirements":["Nagoya","Personal"],"embargo":"2017-12-31","more data 01":"extendat data","more data 02":"extendat data","more data 03":"extendat data"}',
 	'It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. ',
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD'))),
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0'))),
	'Dataset'
);

-- ro 02 - external person (author)
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Alice' ,  cast (getMaxResearchObjectId() AS text) );


-- ro 02 - user
INSERT INTO gfbio_researchobject_user (researchobjectid, researchobjectversion, userid, usertype)
VALUES(
	getMaxResearchObjectId(),
	1,
	getExampleUserId(),
	'owner'
);

--basic ro 03: researchobject with more versions and only related over project
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion,  name, label, extendeddata, description, metadataid, licenseid, researchobjecttype)
VALUES(
	getNewResearchObjectId(),
	1,
	'Dataset c: Large ResearchObject Title example with many/74 character',
	'Dataset c 01' ,
	'{"datacollectiontime":"summer 2016","publications":"no publications","legalrequirements":["Nagoya","Personal"],"embargo":"2017-12-31"}',
 	'It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. ',
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD'))),
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0'))),
	'Dataset'
);

-- ro 03 - external person (author)
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Alice' ,  cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Bob' ,  cast (getMaxResearchObjectId() AS text) );


-- project - ro 03
INSERT INTO gfbio_project_researchobject (projectid, researchobjectid, researchobjectversion)
VALUES(
	getMaxProjectId(),
	getMaxResearchObjectId(),
	1
);

--basic ro 04: researchobject with more versions and only related over project
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, name, label, extendeddata, description, metadataid, licenseid, researchobjecttype)
VALUES(
	getMaxResearchObjectId(),
	2,
	'Dataset c: Large ResearchObject Title example with many/74 character',
	'Dataset c 02' ,
	'{"datacollectiontime":"summer 2016","publications":"no publications","legalrequirements":["Nagoya","Personal"],"embargo":"2017-12-31"}',
 	'It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. It can be, that this is a very long text, with many explanations. ',
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD'))),
	getContentIdentifierIdByRowID(getRowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0'))),
	'Dataset'
);

-- ro 04 - external person (author)
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Alice' ,  cast (getMaxResearchObjectId() AS text) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_externalperson_researchobject' , 'gfbio_externalperson' , 'gfbio_researchobject' ,  'name' ,  'Example Bob' ,  cast (getMaxResearchObjectId() AS text) );


-- project - ro 04
INSERT INTO gfbio_project_researchobject (projectid, researchobjectid, researchobjectversion)
VALUES(
	getMaxProjectId(),
	getMaxResearchObjectId(),
	2
);

--submission - ro 01
INSERT INTO gfbio_submission (researchobjectid, researchobjectversion, archive, archive_pid,  brokersubmissionid, userid, is_public, public_after, status, submissionid, jiraid,jirakey)
VALUES(
	getMaxResearchObjectId(),
	2,
	'GFBio collections',
	'' ,
	'0000015b-d376-6c3c-0000-015bd3766c3c ', --id from  a random submission in our JIRA
	getExampleUserId(),
	false,
	'2017-12-31',
	'sent',
	getNewSubmissionId(),
	'12046', 								--id from  a random submission in our JIRA
	'SAND-820'								--key from  a random submission in our JIRA
);