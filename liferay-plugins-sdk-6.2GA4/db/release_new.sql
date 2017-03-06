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
