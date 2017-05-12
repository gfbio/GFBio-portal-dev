---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic content   ------------------------------------
---------------------------------------------------------------------------------------------


--
create or replace function getMaxContentAndRowId() RETURNS TABLE (mr bigint) AS
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
create or replace function getMaxContentId() RETURNS TABLE (mr bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(contentid) =0 
			THEN 
				0 
			ELSE
				getMaxContentAndRowId()
			END 
		) as contentid
	FROM
		public.gfbio_content
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
create or replace function insertHCCRelationshipWithOutsideOfHCCFirstColumn(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname2 text, in ccont1 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),ccont1, now());
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))), now());
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, 'lastmodifieddate'), getMaxRowId(),now(), now());
$$	
language 'sql' VOLATILE;

--
create or replace function insertHCCRelationshipWithOutsideOfHCCSecoundColumn(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))), now());
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),ccont2, now());
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, 'lastmodifieddate'), getMaxRowId(),now(), now());
$$	
language 'sql' VOLATILE;


--
create or replace function insertHCCRelationship(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text,in colname2 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))), now());
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))), now());
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, 'lastmodifieddate'), getMaxRowId(),now(), now());
$$	
language 'sql' VOLATILE;




--
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


--
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


--
create or replace function changeCellContentByIds(in colid bigint, in oldccont text, in ccont text)  RETURNS void AS
$$
	UPDATE gfbio_content SET cellcontent = ccont, lastmodifieddate = now()  WHERE columnid = colid AND cellcontent = oldccont;
$$	
language 'sql' VOLATILE;


create or replace function changeCellContentByNames(in hename text, in colname text, in oldccont text, in ccont text)  RETURNS void AS
$$
	SELECT changeCellContentByIds(getcolumnidbynames(hename , colname), oldccont, ccont);
$$	
language 'sql' VOLATILE;



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

