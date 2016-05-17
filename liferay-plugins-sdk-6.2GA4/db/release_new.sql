-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
----------------------------------     category parent      -------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('20','gfbio_license','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('61','20','id');	
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('62','20','gfbio_category');	
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('63','20','parent');


------------------------------------- Content Table Content -------------------------------------


------------------------------------- Delete old category_parent -------------------------------------


DELETE FROM gfbio_colum WHERE columnid = 23;
DELETE FROM gfbio_colum WHERE columnid = 24;
DELETE FROM gfbio_head WHERE headid = 8;



-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
------------------------------     category / dataprovider      ---------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Column Table Content -------------------------------------


update gfbio_column set headid = 7 WHERE columnid = 17;
update gfbio_column set headid = 7 WHERE columnid = 18;


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------     license      -----------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('8','gfbio_license','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('23','8','id');	
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('24','8','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('25','8','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('26','8','description');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('27','8','extendeddata');


------------------------------------- Content Table Content -------------------------------------



----------------------------------------------------------------------------------------------
-------------------------------------     dataprovider      ----------------------------------
----------------------------------------------------------------------------------------------


INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('10', 'GFBio collections', 'GFBio collections');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -----------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('11','gfbio_metadata','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('30','11','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('31','11','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('32','11','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('33','11','description');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('34','11','version');


------------------------------------- Content Table Content -------------------------------------


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-----------------------------     metadata / research object      --------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


--INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('12','gfbio_metadata_researchobject','relationship');


------------------------------------- Column Table Content -------------------------------------


--INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('35','12','gfbio_metadata');
--INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('36','12','gfbio_researchobject');



------------------------------------- Content Table Content -------------------------------------


---------------------------------------------------------------------------------------------
-----------------------------------     research object      --------------------------------
---------------------------------------------------------------------------------------------


CREATE FUNCTION getNewContentId(count integer) RETURNS bigint AS $$
    SELECT MAX(contentid)+count AS newid FROM gfbio_content;
$$ LANGUAGE SQL;



CREATE FUNCTION getNewRowId(count integer) RETURNS bigint AS $$
    SELECT MAX(rowid)+count AS newid FROM gfbio_content;
$$ LANGUAGE SQL;


CREATE FUNCTION getMetadataId (t character(75)) RETURNS bigint AS $$
	SELECT
	contentid
	FROM
	public.gfbio_content
	WHERE gfbio_content.headid =11 AND gfbio_content.columnid= 30 AND gfbio_content.rowid in(
		SELECT 
		  rowid
		FROM 
		  public.gfbio_content
		WHERE 
		  gfbio_content.headid =11 AND
		  gfbio_content.columnid= 32 AND
		  gfbio_content.cellcontent = t
		);
$$ LANGUAGE SQL;


CREATE TABLE gfbio_temp
(
  id bigint NOT NULL,
  label character(75) NOT NULL,
  version integer NOT NULL,
  headid bigint,
  rowid bigint,
  columnid bigint,
  CONSTRAINT temp_pkey PRIMARY KEY (id, label, version)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_temp
  OWNER TO liferay_gfbio;

DO
$do$
	BEGIN 
		INSERT INTO gfbio_temp (id, label, version)
		SELECT DISTINCT ON (researchobjecttype) researchobjectid, researchobjecttype, researchobjectversion	FROM gfbio_researchobject;
	END
$do$;


DO
$do$
	DECLARE
		rec RECORD;
		r gfbio_temp%rowtype;
		count integer :=0;
	BEGIN
		FOR r IN SELECT * FROM gfbio_temp 
		LOOP
			count = count+1;
			UPDATE gfbio_temp SET rowid = getNewRowId(count) 	  			WHERE id= r.id AND label=r.label AND version = r.version;
			UPDATE gfbio_temp SET headid = 11 			  				WHERE id= r.id AND label=r.label AND version = r.version;
			UPDATE gfbio_temp SET columnid = 32 			  				WHERE id= r.id AND label=r.label AND version = r.version;
			UPDATE gfbio_temp SET id = getNewContentId(count) WHERE id= r.id AND label=r.label AND version = r.version;
			INSERT INTO gfbio_temp (id, label, version, headid, rowid, columnid) 
				VALUES ((getNewContentId(count)*10), 'notFix', 1, 11, getNewRowId(count), 30);
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


DO
$do$
DECLARE
    rec RECORD;
    r gfbio_temp%rowtype;
    count integer :=0;
BEGIN
    FOR r IN SELECT * FROM gfbio_temp 
    LOOP
      count = count+1;
	  UPDATE gfbio_temp SET id = getNewContentId(count) WHERE id= r.id AND label=r.label AND version = r.version;
	  IF r.label = 'notFix' THEN
		UPDATE gfbio_temp SET label = getNewContentId(count) WHERE id= getNewContentId(count) AND label=r.label AND version = r.version;
	  END IF;
    END LOOP;
    RETURN;
END
$do$
LANGUAGE plpgsql;


DO
$do$
	BEGIN 
		INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)
		SELECT id, headid,columnid, rowid, label	FROM gfbio_temp;
	END
$do$;


ALTER TABLE gfbio_researchobject ADD COLUMN description text;
ALTER TABLE gfbio_researchobject ADD COLUMN metadataid bigint;
ALTER TABLE gfbio_researchobject ADD COLUMN licenseid bigint;


DO
$do$
DECLARE
    r gfbio_researchobject%rowtype;
BEGIN
    FOR r IN SELECT * FROM gfbio_researchobject 
    LOOP
	  UPDATE gfbio_researchobject SET metadataid = getMetadataId (r.researchobjecttype) WHERE researchobjectid= r.researchobjectid AND researchobjectversion = r.researchobjectversion;
    END LOOP;
    RETURN;
END
$do$
LANGUAGE plpgsql;


ALTER TABLE gfbio_researchobject DROP COLUMN researchobjecttype;
DROP TABLE gfbio_temp;


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
----------------------------------     external person      -------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('13','gfbio_externalperson','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('37','13','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('38','13','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('39','13','mail');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('40','13','orcid');



------------------------------------- Content Table Content -------------------------------------


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------     external person / research object      ----------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('14','gfbio_externalperson_researchobject','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('41','14','gfbio_externalperson');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('42','14','gfbio_researchobject');



------------------------------------- Content Table Content -------------------------------------


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
---------------------------------     category / project      ------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('15','gfbio_category_project','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('43','15','gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('44','15','gfbio_project');


------------------------------------- Content Table Content -------------------------------------


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
-----------------------------------     funding agency      --------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('16','gfbio_fundingagency','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('45','16','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('46','16','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('47','16','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('48','16','mail');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('49','16','adress');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('50','16','website');


------------------------------------- Content Table Content -------------------------------------



---------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content -----------------------------------
-----------------------------------     funding program      --------------------------------
---------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('17','gfbio_fundingprogram','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('51','17','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('52','17','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('53','17','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('54','17','fundingid');



------------------------------------- Content Table Content -------------------------------------


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------     funding agency / funding program      -----------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('18','gfbio_fundingagency_fundingprogram','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('55','18','gfbio_fundingagency');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('56','18','gfbio_fundingprogram');


------------------------------------- Content Table Content -------------------------------------


----------------------------------------------------------------------------------------------
-------------------------------     funding / person project      ----------------------------
----------------------------------------------------------------------------------------------


CREATE TABLE gfbio_funding_personproject
(
  projectid bigint NOT NULL,
  fundingagencyid bigint NOT NULL,
  fundingprogramid bigint NOT NULL,
  personid bigint NOT NULL,
  persontype character(75) NOT NULL,
  CONSTRAINT gfbio_funding_personproject_pkey PRIMARY KEY (projectid, fundingagencyid, fundingprogramid, personid, persontype),
  CONSTRAINT gfbio_fundingagency_fkey FOREIGN KEY (fundingagencyid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_fundingprogram_fkey FOREIGN KEY (fundingprogramid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_funding_personproject
  OWNER TO liferay_gfbio;

  

--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------     funding agency / funding program      -----------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('19','gfbio_institution','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('57','19','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('58','19','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('59','19','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('60','19','website');


------------------------------------- Content Table Content -------------------------------------

 
---------------------------------------------------------------------------------------------
----------------------------     funding / institution project      -------------------------
---------------------------------------------------------------------------------------------


CREATE TABLE gfbio_funding_institutionproject
(
  projectid bigint NOT NULL,
  fundingagencyid bigint NOT NULL,
  fundingprogramid bigint NOT NULL,
  institutionid bigint NOT NULL,
  CONSTRAINT gfbio_funding_institutionproject_pkey PRIMARY KEY (projectid, fundingagencyid, fundingprogramid, institutionid),
  CONSTRAINT gfbio_fundingagency_fkey FOREIGN KEY (fundingagencyid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_fundingprogram_fkey FOREIGN KEY (fundingprogramid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_institution_fkey FOREIGN KEY (institutionid)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_project_fkey FOREIGN KEY (projectid)
      REFERENCES gfbio_project (projectid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_funding_institutionproject
  OWNER TO liferay_gfbio;
