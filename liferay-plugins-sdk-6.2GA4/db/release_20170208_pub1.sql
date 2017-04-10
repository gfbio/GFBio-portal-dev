---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
-------------------------------------------     dynamic contentids --------------------------
---------------------------------------------------------------------------------------------


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


CREATE or replace function getNewContentId() RETURNS bigint AS
$$
	SELECT getMaxContentId()+1;
$$	
language 'sql' STABLE;


create or replace function getMaxRowId() RETURNS TABLE (contentid bigint) AS
$$
	SELECT contentid
	FROM
		(SELECT MAX(rowid) AS "contentid" FROM gfbio_content) AS maxid
	ORDER BY contentid DESC
	limit (1);
$$	
language 'sql' STABLE;


CREATE or replace function getNewRowId() RETURNS bigint AS
$$
	SELECT getMaxRowId()+2;
$$	
language 'sql' STABLE;


create or replace function getContentIdByContent(in ccont text, in colid bigint) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
	  contentid 
	FROM 
	  public.gfbio_content
	WHERE
	  cellcontent = ccont AND
	  columnid = colid;
$$	
language 'sql' STABLE;



create or replace function getMaxRowId() RETURNS TABLE (contentid bigint) AS
$$
	SELECT contentid
	FROM
		(SELECT MAX(rowid) AS "contentid" FROM gfbio_content) AS maxid
	ORDER BY contentid DESC
	limit (1);
$$	
language 'sql' STABLE;


create or replace function getContentIdByContent(in ccont text, in colid bigint) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
	  contentid 
	FROM 
	  public.gfbio_content
	WHERE
	  cellcontent = ccont AND
	  columnid = colid;
$$	
language 'sql' STABLE;


create or replace function getrowIdByContentId(in conid bigint) RETURNS TABLE (rowid bigint) AS
$$
	SELECT 
	  rowid 
	FROM 
	  public.gfbio_content
	WHERE
	  contentid = conid;
$$	
language 'sql' STABLE;


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


--------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ----------------------------------
--------------------------------------     metadata      -- 17.09.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'11','30' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'11','31' ,getMaxRowId(),'no metadata');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'11','32' ,getMaxRowId(),'no metadata');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'11','33' ,getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'11','34' ,getMaxRowId(),'');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ----------------------------------
------------------------------      category / dataprovider      -- 20.09.2016 -------------
--------------------------------------------------------------------------------------------

update gfbio_content set cellcontent = '1496' WHERE contentid = 1574;

--------------------------------------------------------------------------------------------
---------------------------------      primary data      -- 04.11.2016 ---------------------
--------------------------------------------------------------------------------------------

CREATE TABLE gfbio_primarydata
(
  primarydataid bigint NOT NULL,
  path character(150),
  name character(200),
  CONSTRAINT gfbio_primarydata_pkey PRIMARY KEY (primarydataid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_primarydata
  OWNER TO liferay_gfbio;


--------------------------------------------------------------------------------------------
------------------------      primary data / research object      -- 04.11.2016 ------------
--------------------------------------------------------------------------------------------


CREATE TABLE gfbio_primarydata_researchobject
(
  researchobjectid bigint NOT NULL,
  researchobjectversion bigint NOT NULL,
  primarydataid bigint NOT NULL,
  CONSTRAINT gfbio_primarydata_researchobject_pkey PRIMARY KEY (researchobjectid, researchobjectversion, primarydataid),
  CONSTRAINT gfbio_primarydata_fkey FOREIGN KEY (primarydataid)
      REFERENCES gfbio_primarydata (primarydataid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_primarydata_researchobject
  OWNER TO liferay_gfbio;

  
--------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content --------------------------------
--------------------------------------     category      -- 07.12.2016 edit: 07.02.2017 ----
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Botanical objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Botanical objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Botanical tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Botanical tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Botanical DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Botanical DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Botanical objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Botanical objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Botanical microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Botanical microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Mycological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Mycological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Mycological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Mycological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Mycological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Mycological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Mycological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Mycological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Mycological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Mycological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Zoological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Zoological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Zoological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Zoological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Zoological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Zoological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Zoological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Zoological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Zoological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Zoological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Paleontological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Paleontological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','1' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','2' ,getMaxRowId(),'Other objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','3' ,getMaxRowId(),'Other objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'1','22',getMaxRowId(),'');

---------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ---------------------------------
--------------------------------------       type        -- 07.12.2016 edit: 07.02.2017------
---------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'5','12' ,getNewRowId(),getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'5','13' ,getMaxRowId(),'material kind');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'5','14' ,getMaxRowId(),'material kind');

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
----------------------------------       category  / type        -- 07.12.2016 edit: 07.02.2017 --
-----------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical tissue objects', 2));--1925
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1930
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1935
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1940
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1945
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1950
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1955
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1960
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1965
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1970
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1975
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1980
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1985
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1990
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--1995
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','15' ,getNewRowId(),getContentIdByContent('Botanical objects', 2));--2000
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),'6','16' ,getMaxRowId(),getContentIdByContent('material kind', 13));

---------------------------------------------------------------------------------------------
---------------------------------      data provider      -- 07.12.2016 ---------------------
---------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider ADD COLUMN providertype character(75);
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='MfN';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='SGN';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='ENA';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='PANGAEA';




---------------------------------------------------------------------------------------------
--------------------------------      research object      -- 16.12.2016 --------------------
---------------------------------------------------------------------------------------------


ALTER TABLE gfbio_researchobject ADD COLUMN researchobjecttype character varying(75);
ALTER TABLE gfbio_researchobject ADD COLUMN licenseid bigint;

SELECT
	*
INTO 
	temp_rowithlicense
FROM
	(
		SELECT 
			researchobjectid, researchobjectversion, CAST (licenseInformation.cellcontent as bigint) as templicenseid
		FROM 
			public.gfbio_researchobject, 
			public.gfbio_content,
			(
				SELECT 
					* 
				FROM 
					public.gfbio_content
				WHERE
					public.gfbio_content.headid = 20  
			) AS licenseInformation
		WHERE
			public.gfbio_content.headid = 20 AND
			CAST(public.gfbio_researchobject.researchobjectid as text) = public.gfbio_content.cellcontent AND
			licenseInformation.rowid = public.gfbio_content.rowid AND
			licenseInformation.cellcontent != public.gfbio_content.cellcontent
	) AS temp_roWithLicense;

	
DO
$do$
	DECLARE
		r temp_roWithLicense%rowtype;
	BEGIN
		FOR r IN SELECT * FROM temp_roWithLicense 
		LOOP
			UPDATE
				gfbio_researchobject 
			SET 
				licenseid = r.templicenseid 
			WHERE 
				researchobjectid= r.researchobjectid AND
				researchobjectversion = r.researchobjectversion;
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;

DROP TABLE temp_roWithLicense;
DELETE FROM public.gfbio_content WHERE	headid=20;
DELETE FROM public.gfbio_column  WHERE	headid=20;
DELETE FROM public.gfbio_head  	 WHERE	headid=20;

----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ----------------------------------
------------------------------------      category      -- 19.12.2016 edit: 07.02.2017 -------
----------------------------------------------------------------------------------------------

--UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects' 											WHERE 	contentid =1922;
--UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects' 											WHERE 	contentid =1466;


----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ----------------------------------
------------------------------------      category      -- 20.12.2016 ------------------------
----------------------------------------------------------------------------------------------

--UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects' 											WHERE 	contentid =1923;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution' 								WHERE 	contentid =1466;

--UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects in ethanol' 								WHERE 	contentid =1937;
--UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects in ethanol'  								WHERE 	contentid =1938;

--------------------------------------------------------------------------------------------
------------------------      primary data / research object      -- 13.01.2017 ------------
--------------------------------------------------------------------------------------------

ALTER TABLE gfbio_primarydata_researchobject ALTER COLUMN researchobjectversion TYPE smallint


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
-----------------------------     category / research object      -- 16.01.2017 ------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(20,'gfbio_category_researchobject','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(61,20,'gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(62,20,'gfbio_researchobject');
