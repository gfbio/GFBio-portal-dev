

----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
-----------------------------------   dynamic dataprovider 02.05.2017 ------------------------
----------------------------------------------------------------------------------------------



--
create or replace function getDataProviderIdByLabel(in dataproviderlabel text) RETURNS TABLE (dataproviderid bigint) AS
$$
	SELECT 
	  dataproviderid 
	FROM 
	  public.gfbio_dataprovider
	WHERE
	  label = dataproviderlabel;
$$	
language 'sql' STABLE;


--
create or replace function getMaxDataProivderId() RETURNS TABLE (maxid bigint) AS
$$
	SELECT 
		MAX(dataproviderid) 
	FROM 
		gfbio_dataprovider
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewDataProviderId() RETURNS bigint AS
$$
	SELECT getMaxDataProivderId()+1;
$$	
language 'sql' STABLE;


----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
--------------------------------------   dynamic content 02.05.2017 --------------------------
----------------------------------------------------------------------------------------------


--
create or replace function insertHCCRelationshipWithOutsideOfHCCFirstColumn(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname2 text, in ccont1 text, in ccont2 bigint)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),ccont1);
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))));

$$	
language 'sql' VOLATILE;

--
create or replace function insertHCCRelationshipWithOutsideOfHCCSecoundColumn(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text, in ccont2 bigint)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))));
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),ccont2);
$$	
language 'sql' VOLATILE;



