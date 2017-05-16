----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
---------------------------------------   dynamic head 12.05.2017 ----------------------------
----------------------------------------------------------------------------------------------



--
create or replace function getMaxHeadId() RETURNS TABLE (mr bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(headid) =0 
			THEN 
				0 
			ELSE
				MAX(headid)
			END 
		) as headid
	FROM
		public.gfbio_head
	
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



----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
--------------------------------------   dynamic column 12.05.2017 ---------------------------
----------------------------------------------------------------------------------------------




--
create or replace function getMaxColumnId() RETURNS TABLE (mr bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(columnid) =0 
			THEN 
				0 
			ELSE
				MAX(columnid)
			END 
		) as columnid
	FROM
		public.gfbio_column
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewColumnId() RETURNS bigint AS
$$
	SELECT getMaxColumnId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getColumnIdByNames(in hename text, in colname text) RETURNS TABLE (columnid bigint) AS
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



----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
--------------------------------------   dynamic content 12.05.2017 --------------------------
----------------------------------------------------------------------------------------------


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




----------------------------------------------------------------------------------------------
------------------------------------------ Functions -----------------------------------------
------------------------------------   dynamic dataprovider 12.05.2017 -----------------------
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
		(CASE 
			WHEN 
				count(dataproviderid) =0 
			THEN 
				0 
			ELSE
				MAX(dataproviderid)
			END 
		) as dataproviderid
	FROM
		public.gfbio_dataprovider
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewDataProviderId() RETURNS bigint AS
$$
	SELECT getMaxDataProivderId()+1;
$$	
language 'sql' STABLE;




-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-------------------------------------       category        -- 12.05.2017 ---------------------
-----------------------------------------------------------------------------------------------

UPDATE 
	gfbio_content 
SET 
	cellcontent = 'Other objects' 		
WHERE
	rowid in (
		select
			rowid 
		from
			gfbio_content
		where
			cast (contentid as text) in (
				Select
					cellcontent
				From
					gfbio_content
				where
					rowid in (
						Select
							rowid
						From
							gfbio_content
						where 
							headid = (select getheadidbyname('gfbio_category_type')) And
							columnid = (select getcolumnidbynames('gfbio_category_type', 'gfbio_type')) AND
							cast (cellcontent as bigint) in (
								select (getcontentidentifieridbyrowid((
									Select
										*
									from(
										SELECT 
											distinct(rowid)
										FROM 
											public.gfbio_content
										WHERE
											headid= (select getheadidbyname('gfbio_type')) AND
											cellcontent= 'material kind'
									) AS rowid
								)))
							)
					) and
					columnid != (select getcolumnidbynames('gfbio_category_type', 'gfbio_type')) and
					columnid != (select getcolumnidbynames('gfbio_category_type', 'lastmodifieddate')) 
			)
	)and
	columnid != (select getcolumnidbynames('gfbio_category', 'id')) and
	columnid != (select getcolumnidbynames('gfbio_category', 'name')) and
	columnid != (select getcolumnidbynames('gfbio_category', 'description')) and
	columnid != (select getcolumnidbynames('gfbio_category', 'lastmodifieddate')) and
	cellcontent = 'Other'
			
			
-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-------------------------------------       category        -- 16.05.2017 ---------------------
-----------------------------------------------------------------------------------------------
			

--SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
--SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );