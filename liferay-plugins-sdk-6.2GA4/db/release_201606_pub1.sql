-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
----------------------------------     category parent      -------------------------------
-------------------------------------------------------------------------------------------

------------------------- Delete old category_parent and relation -------------------------


DELETE FROM gfbio_column WHERE columnid = 23;
DELETE FROM gfbio_column WHERE columnid = 24;
DELETE FROM gfbio_head WHERE headid = 8;

--DELETE FROM gfbio_column WHERE columnid = 61;
--DELETE FROM gfbio_column WHERE columnid = 62;
--DELETE FROM gfbio_column WHERE columnid = 63;
--DELETE FROM gfbio_head WHERE headid = 20;


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('21','gfbio_category_parent','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('63','21','id');	
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('64','21','gfbio_category');	
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('65','21','parent');


------------------------------------- Content Table Content -------------------------------------


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


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1464','8','23','1465','1464');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1466','8','24','1465','Creative Commons Attribution');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1467','8','25','1465','CC BY');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1468','8','23','1469','1468');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1470','8','24','1469','Creative Commons Attribution-ShareAlike');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1471','8','25','1469','CC BY-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1472','8','23','1473','1472');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1474','8','24','1473','Creative Commons Attribution-NoDerivs');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1475','8','25','1473','CC BY-NC-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1476','8','23','1477','1476');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1478','8','24','1477','Creative Commons Attribution-NonCommercial');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1479','8','25','1477','CC BY-NC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1480','8','23','1481','1480');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1482','8','24','1481','Creative Commons Attribution-NonCommercial-ShareAlike');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1483','8','25','1481','CC BY-NC-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1484','8','23','1485','1484');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1486','8','24','1485','Creative Commons Attribution-NonCommercial-NoDerivs');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1487','8','25','1485','CC BY-NC-ND');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1488','8','23','1489','1488');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1490','8','24','1489','Other License');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1491','8','25','1489','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1682','8','26','1465','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1683','8','26','1469','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1684','8','26','1473','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1685','8','26','1477','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1686','8','26','1481','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1687','8','26','1485','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1688','8','26','1489','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1689','8','27','1465','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1690','8','27','1469','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1691','8','27','1473','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1692','8','27','1477','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1693','8','27','1481','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1694','8','27','1485','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1695','8','27','1489','');



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




-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-----------------------------     license / research object      --------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('20','gfbio_license_researchobject','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('61','20','gfbio_license');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('62','20','gfbio_researchobject');



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
-- ALTER TABLE gfbio_researchobject ADD COLUMN licenseid bigint;


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

  

---------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content -----------------------------------
-------------------------------------     institution      ----------------------------------
---------------------------------------------------------------------------------------------


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

  
  
-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------     category      -----------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1492','1','1','1493','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1494','1','2','1493','Botany');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1495','1','3','1493','Botany');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1496','1','1','1497','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1498','1','2','1497','Ecology ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1499','1','3','1497','Ecology ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1500','1','1','1501','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1502','1','2','1501','Geoscience');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1503','1','3','1501','Geoscience');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1504','1','1','1505','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1506','1','2','1505','Microbiology ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1507','1','3','1505','Microbiology ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1508','1','1','1509','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1510','1','2','1509','Mycology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1511','1','3','1509','Mycology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1512','1','1','1513','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1514','1','2','1513','Palaeontology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1515','1','3','1513','Palaeontology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1516','1','1','1517','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1518','1','2','1517','Zoology ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1519','1','3','1517','Zoology ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1520','1','1','1521','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1522','1','2','1521','Other discipline');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1523','1','3','1521','Other discipline ');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1552','1','22','1493','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1553','1','22','1497','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1554','1','22','1501','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1555','1','22','1505','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1556','1','22','1509','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1557','1','22','1513','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1558','1','22','1517','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1559','1','22','1521','');


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------     Type      -----------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1524','5','12','1525','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1526','5','13','1525','research field');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1527','5','14','1525','research field');

-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-----------------------------------     category Type      --------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1528','6','15','1529','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1530','6','16','1529','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1531','6','15','1532','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1533','6','16','1532','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1534','6','15','1535','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1536','6','16','1535','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1537','6','15','1538','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1539','6','16','1538','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1540','6','15','1541','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1542','6','16','1541','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1543','6','15','1544','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1545','6','16','1544','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1546','6','15','1547','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1548','6','16','1547','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1549','6','15','1550','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1551','6','16','1550','1524');



-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
----------------------     Delete old categories and researchfields     -------------------
-------------------------------------------------------------------------------------------


DELETE 
FROM 
	public.gfbio_content
where
	headid=2 or 
	headid= 4 or
	(
		headid = 7 AND
		cellcontent in 
		(  
			SELECT 
				cast (rowid as text) 
			FROM 
				public.gfbio_content
			WHERE
				headid = 1 AND
				rowid in
				(
					SELECT 
						cast (cellcontent as bigint)
					FROM 
						public.gfbio_content
					WHERE
						columnid =15 AND
						headid = 6 AND
						rowid in
						(
							SELECT 
								rowid
							FROM 
								public.gfbio_content
							WHERE
								headid = 6 AND
								cellcontent in 
								(
									SELECT 
									  cast (rowid AS text) 
									FROM 
									  public.gfbio_content
									WHERE
										headid = 5 AND
										(
											cellcontent ='accesscontrol' OR
											cellcontent ='collection taxon' OR
											cellcontent ='collection type' OR
											cellcontent ='datadomain' OR
											cellcontent ='ecological field' OR
											cellcontent ='geographic region' OR
											cellcontent ='geographic region' OR
											cellcontent ='taxonomic field' 
										)
								)
						)
				)
		)
	)
	or
	(
		headid = 1 AND
		rowid in
		(
			SELECT 
				cast (cellcontent as bigint)
			FROM 
				public.gfbio_content
			WHERE
				columnid =15 AND
				headid = 6 AND
				rowid in
				(
					SELECT 
						rowid
					FROM 
						public.gfbio_content
					WHERE
						headid = 6 AND
						cellcontent in 
						(
							SELECT 
								cast (rowid AS text) 
							FROM 
								public.gfbio_content
							WHERE
								headid = 5 AND
								(
									cellcontent ='accesscontrol' OR
									cellcontent ='collection taxon' OR
									cellcontent ='collection type' OR
									cellcontent ='datadomain' OR
									cellcontent ='ecological field' OR
									cellcontent ='geographic region' OR
									cellcontent ='geographic region' OR
									cellcontent ='taxonomic field' 
								)
						)
				)
		)
	)
	or
	(
		headid = 6 AND
		rowid in(
  SELECT 
  rowid
FROM 
  public.gfbio_content
WHERE
  headid = 6 AND
  cellcontent in (
	SELECT 
	  cast (rowid AS text) 
	FROM 
	  public.gfbio_content
	WHERE
	  headid = 5 AND
	  (
		cellcontent ='accesscontrol' OR
		cellcontent ='collection taxon' OR
		cellcontent ='collection type' OR
		cellcontent ='datadomain' OR
		cellcontent ='ecological field' OR
		cellcontent ='geographic region' OR
		cellcontent ='geographic region' OR
		cellcontent ='taxonomic field' 
	  )
  )
  )or
  (
  headid = 5 AND
  rowid in (
	SELECT 
	  rowid
	FROM 
	  public.gfbio_content
	WHERE
	  headid = 5 AND
	  (
		cellcontent ='accesscontrol' OR
		cellcontent ='collection taxon' OR
		cellcontent ='collection type' OR
		cellcontent ='datadomain' OR
		cellcontent ='ecological field' OR
		cellcontent ='geographic region' OR
		cellcontent ='geographic region' OR
		cellcontent ='taxonomic field' 
	  )
	  )
  )
  )
;

Delete
FROM 
  public.gfbio_column
WHERE
  headid = 4 or
  headid = 2;


Delete
FROM
  public.gfbio_head
WHERE
  headid = 2 or 
  headid = 4;
  
--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------     category dataprovider     -----------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Column Table Content -------------------------------------


update gfbio_column set headid = 7 WHERE columnid = 17;
update gfbio_column set headid = 7 WHERE columnid = 18;


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1568','7','17','1569','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1570','7','18','1569','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1571','7','17','1572','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1573','7','18','1572','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1574','7','17','1575','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1576','7','18','1575','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1577','7','17','1578','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1579','7','18','1578','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1580','7','17','1581','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1582','7','18','1581','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1583','7','17','1584','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1585','7','18','1584','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1586','7','17','1587','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1588','7','18','1587','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1589','7','17','1590','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1591','7','18','1590','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1592','7','17','1593','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1594','7','18','1593','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1595','7','17','1596','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1597','7','18','1596','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1598','7','17','1599','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1600','7','18','1599','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1601','7','17','1602','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1603','7','18','1602','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1604','7','17','1605','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1606','7','18','1605','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1607','7','17','1608','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1609','7','18','1608','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1610','7','17','1611','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1612','7','18','1611','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1613','7','17','1614','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1615','7','18','1614','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1616','7','17','1617','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1618','7','18','1617','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1619','7','17','1620','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1621','7','18','1620','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1622','7','17','1623','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1624','7','18','1623','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1625','7','17','1626','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1627','7','18','1626','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1628','7','17','1629','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1630','7','18','1629','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1631','7','17','1632','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1633','7','18','1632','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1634','7','17','1635','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1636','7','18','1635','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1637','7','17','1638','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1639','7','18','1638','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1640','7','17','1641','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1642','7','18','1641','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1643','7','17','1644','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1645','7','18','1644','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1646','7','17','1647','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1648','7','18','1647','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1649','7','17','1650','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1651','7','18','1650','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1652','7','17','1653','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1654','7','18','1653','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1655','7','17','1656','1512');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1657','7','18','1656','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1658','7','17','1659','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1660','7','18','1659','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1661','7','17','1662','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1663','7','18','1662','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1664','7','17','1665','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1666','7','18','1665','1');  
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1667','7','17','1668','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1669','7','18','1668','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1670','7','17','1671','1492');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1672','7','18','1671','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1673','7','17','1674','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1675','7','18','1674','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1676','7','17','1677','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1678','7','18','1677','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1679','7','17','1680','1516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1681','7','18','1680','2');
