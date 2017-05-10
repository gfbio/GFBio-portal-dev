

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
create or replace function insertHCCRelationshipWithOutsideOfHCCFirstColumn(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname2 text, in ccont1 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),ccont1);
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))));

$$	
language 'sql' VOLATILE;

--
create or replace function insertHCCRelationshipWithOutsideOfHCCSecoundColumn(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))));
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),ccont2);
$$	
language 'sql' VOLATILE;


-----------------------------------------------------------------------------------------------
-----------------------------------------   timestamps 02.05.2017 -----------------------------
-----------------------------------------------------------------------------------------------


ALTER TABLE gfbio_column ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_content ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_dataprovider ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_dataprovider_persistentidentifier ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_funding_institutionproject ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_funding_personproject ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_head ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_primarydata ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_primarydata_researchobject ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_project ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_project_researchobject ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_project_user ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();
ALTER TABLE gfbio_researchobject_user ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();


-----------------------------------------------------------------------------------------------
---------------------------------------   hcc timestamps 03.05.2017 ---------------------------
-----------------------------------------------------------------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_externalperson')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingprogram')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_institution')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_type')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_dataprovider')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_project')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_researchobject')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_type')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_externalperson_researchobject')),'lastmodifieddate');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency_fundingprogram')),'lastmodifieddate');



DO
$do$
	DECLARE
		rid bigint;
		hname text;
	BEGIN
		FOR hname IN
			SELECT 
				gfbio_head.table_name
			FROM 
				public.gfbio_head
			LOOP
				FOR rid IN 
					SELECT 
						DISTINCT rowid 
					FROM 
						public.gfbio_content,
						public.gfbio_head
					WHERE
						gfbio_content.headid = gfbio_head.headid AND
						gfbio_head.table_name = hname
					ORDER BY rowid
				LOOP
					INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName(hname)), getColumnIdByNames(hname,'lastmodifieddate'), rid, now(), now());
				END LOOP;
			END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;

