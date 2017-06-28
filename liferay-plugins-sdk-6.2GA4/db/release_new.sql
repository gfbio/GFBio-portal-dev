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

-----------------------------------------------------------------------------------------------
-------------------------------------       primary data        -- 18.05.2017 ---------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_primarydata ALTER COLUMN path TYPE character(250);


-----------------------------------------------------------------------------------------------
-------------------------------------       head        -- 08.06.2017 -------------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_head ALTER COLUMN description TYPE text;


UPDATE gfbio_head SET  description='In this table we store keywords for some tools. This table is related with the "gfbio_type" table.'			WHERE table_name = 'gfbio_category';
UPDATE gfbio_head SET  description='In this table we store non user persons , that are related with GFBio. For example authors of a dataset or contact persons of an archive. An user can be an user and an external person to the same time.'			WHERE table_name = 'gfbio_externalperson';
UPDATE gfbio_head SET  description='In this table we store information of funding agencies, that are related with the GFBio Conext. For example via DMP Tool.'			WHERE table_name = 'gfbio_fundingagency';
UPDATE gfbio_head SET  description='In this table we store information of funding programms, that are related with the GFBio Conext. For example via DMP Tool.'			WHERE table_name = 'gfbio_fundingprogram';
UPDATE gfbio_head SET  description='In this table we store information of institutions, taht are related with GFBio as partner or from the user.'			WHERE table_name = 'gfbio_institution';
UPDATE gfbio_head SET  description='In this table we store information about the licenses, that we use in GFBio.'			WHERE table_name = 'gfbio_license';
UPDATE gfbio_head SET  description='In this table we store information about the metadata, that we use in GFBio. '			WHERE table_name = 'gfbio_metadata';
UPDATE gfbio_head SET  description='In this table we store the information about persistent identifier, that the archives/datacenter use.'			WHERE table_name = 'gfbio_persistentidentifier';
UPDATE gfbio_head SET  description='The type table specify the category.'			WHERE table_name = 'gfbio_type';




-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------       legal requirements        -- 22.06.2017 ----------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_legalrequirement','entity', now());

------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'id', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'name', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'label', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'description', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'extendeddata', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'lastmodifieddate', now());

------------------------------------- Content Table Content -------------------------------------
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Nagoya Protocol', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Red List', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Personally Identifiable Information', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Uncertain', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());



-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------       legal requirements / research object       -- 22.06.2017 -------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_legalrequirement_researchobject','relationship');

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_researchobject')),'gfbio_legalrequirement');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_researchobject')),'gfbio_researchobject');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_researchobject')),'lastmodifieddate');

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------       legal requirements / project       -- 22.06.2017 ---------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_legalrequirement_project','relationship');

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_project')),'gfbio_legalrequirement');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_project')),'gfbio_project');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_project')),'lastmodifieddate');



-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------------       policy        -- 22.06.2017 ----------------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_policy','entity', now());

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'id', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'name', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'label', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'description', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'url', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'lastmodifieddate', now());


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
----------------------------------       policy / project       -- 22.06.2017 -----------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_policy_project','relationship');

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy_project')),'gfbio_policy');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy_project')),'gfbio_project');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy_project')),'lastmodifieddate');



------------------------------------------------------------------------------------------------
----------------------------------       research object        -- 28.06.2017 ------------------
------------------------------------------------------------------------------------------------

ALTER TABLE gfbio_researchobject ALTER COLUMN name  TYPE text;
ALTER TABLE gfbio_researchobject ALTER COLUMN name  SET NOT NULL;
ALTER TABLE gfbio_researchobject ALTER COLUMN label  TYPE text;
ALTER TABLE gfbio_researchobject ALTER COLUMN label  SET NOT NULL;
ALTER TABLE gfbio_researchobject ALTER COLUMN researchobjecttype  TYPE text;

------------------------------------------------------------------------------------------------
--------------------------------------       project        -- 28.06.2017 ----------------------
------------------------------------------------------------------------------------------------

ALTER TABLE gfbio_project ALTER COLUMN name  TYPE text;
ALTER TABLE gfbio_project ALTER COLUMN name  SET NOT NULL;
ALTER TABLE gfbio_project ALTER COLUMN label  TYPE text;
ALTER TABLE gfbio_project ALTER COLUMN label  SET NOT NULL;
ALTER TABLE gfbio_project ALTER COLUMN status  TYPE text;


-------------------------------------------------------------------------------------------------
-------------------------------------       submission        -- 28.06.2017 ---------------------
-------------------------------------------------------------------------------------------------

ALTER TABLE gfbio_primarydata ALTER COLUMN name  TYPE text;
ALTER TABLE gfbio_primarydata ALTER COLUMN path  TYPE text;

