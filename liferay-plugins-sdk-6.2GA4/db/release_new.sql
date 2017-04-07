---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
-------------------------------------   dynamic headids 10.02.2017 --------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxHeadId() RETURNS TABLE (mr bigint) AS
$$
	SELECT headid
	FROM
		(SELECT MAX(headid) as "headid" FROM gfbio_head) as maxid
	ORDER BY headid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewHeadId() RETURNS bigint AS
$$
	SELECT getMaxHeadId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getHeadIdByName(in hename text) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
		headid 
	FROM 
		public.gfbio_head
	WHERE
		table_name = hename;
$$	
language 'sql' STABLE;


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic columnids 10.02.2017 -------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxColumnId() RETURNS TABLE (mr bigint) AS
$$
	SELECT columnid
	FROM
		(SELECT MAX(columnid) as "columnid" FROM gfbio_column) as maxid
	ORDER BY columnid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewColumnId() RETURNS bigint AS
$$
	SELECT getMaxColumnId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getColumnIdByNames(in hename text, in colname text) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
	  columnid 
	FROM 
	  public.gfbio_column
	WHERE
	  column_name = colname AND
	  headid = (select getHeadIdByName(hename));
$$	
language 'sql' STABLE;


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic contentids 10.02.2017 ------------------------
---------------------------------------------------------------------------------------------


--
create or replace function getMaxContentId() RETURNS TABLE (mr bigint) AS
$$
	SELECT contentid
	FROM
		(SELECT MAX(rowid) as "contentid" FROM gfbio_content) as maxid
		union
		SELECT MAX(contentid) FROM gfbio_content
	ORDER BY contentid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewContentId() RETURNS bigint AS
$$
	SELECT getMaxContentId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getMaxRowId() RETURNS TABLE (contentid bigint) AS
$$
	SELECT contentid
	FROM
		(SELECT MAX(rowid) AS "contentid" FROM gfbio_content) AS maxid
	ORDER BY contentid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewRowId() RETURNS bigint AS
$$
	SELECT getMaxContentId()+2;
$$	
language 'sql' STABLE;


--
create or replace function getContentIdByNames(in hename text, in colname text, in ccont text) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
	  contentid 
	FROM 
	  public.gfbio_content
	WHERE
	  cellcontent = ccont AND
	  columnid = (SELECT getColumnIdByNames(hename, colname));
$$	
language 'sql' STABLE;


-- 
create or replace function getRowIdByContentId(in conid bigint) RETURNS TABLE (rowid bigint) AS
$$
	SELECT 
	  rowid 
	FROM 
	  public.gfbio_content
	WHERE
	  contentid = conid;
$$	
language 'sql' STABLE;


--
create or replace function getContentIdentifierIdByRowID(in roid bigint) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
	  min(contentid) 
	FROM 
	  public.gfbio_content
	WHERE
	  rowid = roid;
$$	
language 'sql' STABLE;


--
create or replace function insertHCCRelationshipWithOutsideOfHCC(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text, in ccont2 bigint)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))));
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),ccont2);
$$	
language 'sql' VOLATILE;


--
create or replace function insertHCCRelationship(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text,in colname2 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))));
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))));
$$	
language 'sql' VOLATILE;


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------      category / data provider       - 10.02.2017 -------------
-----------------------------------------------------------------------------------------------

SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  4 );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
----------------------------------       category / type        - 10.02.2017 ------------------
-----------------------------------------------------------------------------------------------

DELETE 
FROM 
	public.gfbio_content 
WHERE  
	rowid in (
		SELECT
			rowid
		FROM 
			public.gfbio_content 
		WHERE  
			headid = (SELECT getHeadIdByName('gfbio_category_type')) AND
			cellcontent = CAST((SELECT getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames('gfbio_type','name','material kind'))))AS text)
	);

SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Paleontological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Other objects' ,  'name', 'material kind' );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------------       dataprovider        - 10.02.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider ADD COLUMN physicalobjectpossible BOOLEAN;
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET physicalobjectpossible2 = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN nophysicalobject BOOLEAN;
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='ENA';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='PANGAEA';

--ALTER TABLE gfbio_dataprovider DROP COLUMN physicalobjects;

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------       category / dataprovider        - 10.02.2017 --------------
-----------------------------------------------------------------------------------------------


SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  8 );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-----------------------------------        dataprovider        - 14.02.2017 -------------------
-----------------------------------------------------------------------------------------------

UPDATE gfbio_dataprovider SET name = 'Botanic Garden and Botanical Museum Berlin-Dahlem, Freie Universität Berlin' WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET name = 'Leibniz Institute DSMZ - German Collection of Microorganisms and Cell Cultures, Braunschweig' WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET name = 'Leibniz Institute for Research on Evolution and Biodiversity, Berlin' WHERE label ='MfN';
UPDATE gfbio_dataprovider SET name = 'Senckenberg Gesellschaft für Naturforschung - Leibniz Institute, Frankfurt' WHERE label ='SGN';
UPDATE gfbio_dataprovider SET name = 'State Museum of Natural History Stuttgart' WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET name = 'Staatliche naturwissenschaftliche Sammlungen Bayerns - SNSB IT Center, München' WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET name = 'Zoological Research Museum Alexander Koenig - Leibniz Institute for Animal Biodiversity, Bonn' WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET name = 'European Nucleotide Archive' WHERE label ='ENA';
UPDATE gfbio_dataprovider SET name = 'Data Publisher for Earth & Environmental Science' WHERE label ='PANGAEA';


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic contentids 14.02.2017 ------------------------
---------------------------------------------------------------------------------------------


create or replace function deleteHCCRelationshipWithOutsideOfHCC(in relationhename text, in relationcolname1 text, in colname1 text, in ccont1 text, in ccont2 text)  RETURNS void AS
$$
	DELETE 
	FROM 
		public.gfbio_content 
	WHERE  
		rowid in (
			SELECT
				rowid
			FROM 
				public.gfbio_content 
			WHERE  
				headid = (SELECT getHeadIdByName(relationhename)) AND
				cellcontent = CAST((SELECT getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))))AS text)
		) AND
		rowid in (
			SELECT
				rowid
			FROM 
				public.gfbio_content 
			WHERE  
				headid = (SELECT getHeadIdByName(relationhename)) AND
				cellcontent = ccont2
		);
$$	
language 'sql' VOLATILE;



create or replace function deleteHCCRelationship(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text,  in colname2 text, in ccont2 text)  RETURNS void AS
$$
	DELETE
	FROM 
		public.gfbio_content 
	WHERE  
		rowid in (
			SELECT
				rowid
			FROM 
				public.gfbio_content 
			WHERE  
				headid = (SELECT getHeadIdByName(relationhename)) AND
				cellcontent = CAST((SELECT getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))))AS text)
		) AND
		rowid in (
			SELECT
				rowid
			FROM 
				public.gfbio_content 
			WHERE  
				headid = (SELECT getHeadIdByName(relationhename)) AND
				cellcontent = CAST((SELECT getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))))AS text)
		);
$$	
language 'sql' VOLATILE;


create or replace function changeCellContentByIds(in colid bigint, in oldccont text, in ccont text)  RETURNS void AS
$$
	UPDATE gfbio_content SET cellcontent = ccont WHERE columnid = colid AND cellcontent = oldccont;
$$	
language 'sql' VOLATILE;


create or replace function changeCellContentByNames(in hename text, in colname text, in oldccont text, in ccont text)  RETURNS void AS
$$
	SELECT changeCellContentByIds(getcolumnidbynames(hename , colname), oldccont, ccont);
$$	
language 'sql' VOLATILE;




-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------       category / dataprovider        - 14.02.2017 --------------
-----------------------------------------------------------------------------------------------


SELECT deleteHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider', 'gfbio_category','name','Botanical tissue objects', '1');
SELECT deleteHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider', 'gfbio_category','name','Botanical tissue objects', '5');
SELECT deleteHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider', 'gfbio_category','name','Botanical tissue objects', '6');
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  6 );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-------------------------------------        category        - 14.02.2017 ---------------------
-----------------------------------------------------------------------------------------------

SELECT changeCellContentByNames('gfbio_category', 'name',  'Other discipline', 'Other');
SELECT changeCellContentByNames('gfbio_category', 'label', 'Other discipline', 'Other');
SELECT changeCellContentByNames('gfbio_category', 'name',  'Other objects', 'Other');
SELECT changeCellContentByNames('gfbio_category', 'label', 'Other objects', 'Other');


-----------------------------------------------------------------------------------------------
-----------------------------------        dataprovider        - 15.02.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider DROP COLUMN physicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicaltissueobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicaldnasamples;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicalmicroscopicslides;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicalobjectsinethanol;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicaltissueobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicaldnasamples;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicalmicroscopicslides;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicalobjectsinethanol;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicaltissueobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicaldnasamples;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicalobjectsinethanol;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicalmicroscopicslides;
ALTER TABLE gfbio_dataprovider DROP COLUMN paleontologicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN otherobjects;

-----------------------------------------------------------------------------------------------
-----------------------------------        dataprovider        - 06.03.2017 -------------------
-----------------------------------------------------------------------------------------------

UPDATE gfbio_dataprovider SET name = 'Botanic Garden and Botanical Museum Berlin, Freie Universität Berlin' WHERE label ='BGBM';


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------       category / dataprovider        - 06.03.2017 --------------
-----------------------------------------------------------------------------------------------


SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Algae & Protists' ,  4 );

-----------------------------------------------------------------------------------------------
-----------------------------------        submission        - 07.03.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_submission ADD COLUMN jiraid character (75);

-----------------------------------------------------------------------------------------------
-----------------------------------        submission        - 08.03.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_submission ADD COLUMN jirakey character (75);


-----------------------------------------------------------------------------------------------
-----------------------------------        basket         - 13.03.2017 -------------------
-----------------------------------------------------------------------------------------------
---- Basket has been updated on v6.5, no need to rerun again (see update_gfbio_basket.sql)
--ALTER TABLE gfbio_basket ADD COLUMN queryKeyword text;
--ALTER TABLE gfbio_basket ADD COLUMN queryFilter text;




---- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ----
----							scripts above this line are on pub2 				16.03.2017
---- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ----



-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------------       license        -- 16.03.2017 ---------------------
-----------------------------------------------------------------------------------------------

------------------------------------- Column Table Content -------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),getHeadIdByName('gfbio_license'),'version');


------------------------------------- Content Table Content -------------------------------------

DO
$do$
	DECLARE
		r bigint;
	BEGIN
		FOR r IN 
			SELECT 
			  distinct(rowid )
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_license'))
		LOOP
			INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'),r, '');
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;



---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic contentids 04.04.2017 ------------------------
---------------------------------------------------------------------------------------------


--
create or replace function deleteHCCAllTableContent(in hename text)  RETURNS void AS
$$
	DELETE
	FROM 
		public.gfbio_content 
	WHERE  
		headid = (select getHeadIdByName(hename))
$$	
language 'sql' VOLATILE;


--
create or replace function deleteHCCRow(in hename text, in colname text, in ccont text)  RETURNS void AS
$$
	DELETE
	FROM 
		public.gfbio_content 
	WHERE  
		rowid in (
			SELECT 
				rowid 
			FROM 
				public.gfbio_content
			WHERE
				headid = (select getHeadIdByName(hename)) AND
				columnid = (SELECT getColumnIdByNames(hename, colname)) AND
				cellcontent = ccont
		);	
$$	
language 'sql' VOLATILE;


-- 
create or replace function getContentByColumnName(in hename text, in colname text, in conid bigint ) RETURNS TABLE (cellcontent text) AS
$$
	SELECT 
		cellcontent
	FROM 
		public.gfbio_content
	WHERE
		rowid =  (Select getRowIdByContentId(conid)) AND
		columnid = (SELECT getColumnIdByNames(hename, colname));
$$	
language 'sql' STABLE;



-- -----------------------------------------------------------------------------------------------
-- ------------------------------------ Head, Column & Content -----------------------------------
-- --------------------------------------       license        -- 04.04.2017 ---------------------
-- -----------------------------------------------------------------------------------------------


ALTER TABLE gfbio_researchobject ADD COLUMN licenselabel text;


DO
$do$
	DECLARE
		lid bigint;
	BEGIN
		FOR lid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_license')) AND
			  columnid = (select getColumnIdByNames('gfbio_license','id'))
		LOOP
			UPDATE gfbio_researchobject SET licenselabel = (Select (getContentByColumnName('gfbio_license', 'label', lid ))) WHERE licenseid =lid;
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


UPDATE gfbio_researchobject SET licenselabel = 'CC-BY' 			WHERE licenselabel ='CC BY';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-SA' 		WHERE licenselabel ='CC BY-SA';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-NC-SA' 	WHERE licenselabel ='CC BY-NC-SA';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-NC' 		WHERE licenselabel ='CC BY-NC';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-NC-ND' 	WHERE licenselabel ='CC BY-NC-ND';

SELECT deleteHCCRow('gfbio_license', 'label', 'other');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC0');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-SA');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-NC-SA');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-NC');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-NC-ND');


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Other License');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Zero');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '{"url":"https://creativecommons.org/publicdomain/zero/1.0/deed.de"}');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '1.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '{"url":"https://creativecommons.org/licenses/by/3.0/de"}');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NonComercial');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-NC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NonComercial-NoDerivs');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-NC-ND');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NonComercial-ShareAlike');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-NC-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '{"url":"https://creativecommons.org/licenses/by-sa/3.0/de"}');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NoDerivs');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-ND');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-ShareAlike');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');





DO
$do$
	DECLARE
		lid bigint;
	BEGIN
		FOR lid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_license')) AND
			  columnid = (select getColumnIdByNames('gfbio_license','id'))
		LOOP
			UPDATE gfbio_researchobject SET licenseid = lid WHERE licenselabel = (Select (getContentByColumnName('gfbio_license', 'label', lid )));
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


UPDATE gfbio_researchobject SET licenseid = null 	WHERE licenseid =0;

ALTER TABLE	gfbio_researchobject DROP licenselabel;
	

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-------------------------------------       metadata        -- 04.04.2017 ---------------------
-----------------------------------------------------------------------------------------------


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'schema');


------------------------------------- Content Table Content -------------------------------------



ALTER TABLE gfbio_researchobject ADD COLUMN metadatalabel text;


DO
$do$
	DECLARE
		mid bigint;
	BEGIN
		FOR mid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_metadata')) AND
			  columnid = (select getColumnIdByNames('gfbio_metadata','id'))
		LOOP
			UPDATE gfbio_researchobject SET metadatalabel = (Select (getContentByColumnName('gfbio_metadata', 'label', mid ))) WHERE metadataid =mid;
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;

UPDATE gfbio_researchobject SET metadatalabel = 'ABCD' WHERE metadatalabel ='ABCD 2.06';
UPDATE gfbio_researchobject SET metadatalabel = 'Dublin Core' WHERE metadatalabel ='Dublin Core (Metadata Elements Set V1.1)';
UPDATE gfbio_researchobject SET metadatalabel = 'EDM' WHERE metadatalabel ='EDM (Europeana Data Model V5.2.5)';
UPDATE gfbio_researchobject SET metadatalabel = 'EML' WHERE metadatalabel ='EML (Ecological Metadata Language V2.1.1)';
UPDATE gfbio_researchobject SET metadatalabel = 'ESE' WHERE metadatalabel ='ESE (Europeana Semantic Elements V3.4.1';
UPDATE gfbio_researchobject SET metadatalabel = 'INSPIRE' WHERE metadatalabel ='INSPIRE (VO (EG) Nr. 1205/2008)';

SELECT deleteHCCAllTableContent('gfbio_metadata');
UPDATE gfbio_researchobject SET metadataid = 0;




INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Other metadata schema or version');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Europeana Data Model');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'EDM');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '5.2.5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Ecological Metadata Language');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'EML');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '2.1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Europeana Semantic Elements');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ESE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '3.4.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), 'VO (EG) Nr. 1205/2008');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Minimum Information about any (x) Sequence');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), 'The MIxS standard (Minimum Information about any (x) Sequence) is an overarching framework providing a single entry point to all minimum information checklists from the Genomic Standards Consortium (GSC) and to the environmental packages. MIxS includes the technology-specific checklists from the previous MIGS (Minimum Information about a Genome Sequence) and MIMS (Minimum Information about a Metagenome Sequence) standards. It provides a way to introduce additional checklists such as MIMARKS (Minimum Information about a Marker Gene Sequence), and allows annotation of sample data using environmental packages. MIxS was published in Nature Biotechnology in 2011.');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '4.0.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');



DO
$do$
	DECLARE
		mid bigint;
	BEGIN
		FOR mid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_metadata')) AND
			  columnid = (select getColumnIdByNames('gfbio_metadata','id'))
		LOOP
			UPDATE gfbio_researchobject SET metadataid = mid WHERE metadatalabel = (Select (getContentByColumnName('gfbio_metadata', 'label', mid )));
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


UPDATE gfbio_researchobject SET metadataid = null WHERE metadataid =0;
ALTER TABLE	gfbio_researchobject DROP metadatalabel;

-----------------------------------------------------------------------------------------------
----------------------------------        researchobject        - 04.04.2017 ------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_researchobject ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
