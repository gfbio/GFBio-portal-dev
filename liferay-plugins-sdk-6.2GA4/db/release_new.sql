
--------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ----------------------------------
--------------------------------------     metadata      -- 17.09.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1909','11','30' ,'1910','1909');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1911','11','31' ,'1910','no metadata');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1912','11','32' ,'1910','no metadata');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1913','11','33' ,'1910','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1914','11','34' ,'1910','');


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
------------------------------------ Head, Column & Content ----------------------------------
--------------------------------------     category      -- 07.12.2016 ---------------------
--------------------------------------------------------------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1920','1','1' ,'1921','1920');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1922','1','2' ,'1921','Botanical Objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1923','1','3' ,'1921','Botanical Objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1924','1','22','1921','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1925','1','1' ,'1926','1925');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1927','1','2' ,'1926','Botanical tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1928','1','3' ,'1926','Botanical tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1929','1','22','1926','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1930','1','1' ,'1931','1930');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1932','1','2' ,'1931','Botanical DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1933','1','3' ,'1931','Botanical DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1934','1','22','1931','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1935','1','1' ,'1936','1935');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1937','1','2' ,'1936','Botanical objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1938','1','3' ,'1936','Botanical objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1939','1','22','1936','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1940','1','1' ,'1941','1940');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1942','1','2' ,'1941','Botanical microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1943','1','3' ,'1941','Botanical microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1944','1','22','1941','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1945','1','1' ,'1946','1945');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1947','1','2' ,'1946','Mycological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1948','1','3' ,'1946','Mycological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1949','1','22','1946','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1950','1','1' ,'1951','1950');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1952','1','2' ,'1951','Mycological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1953','1','3' ,'1951','Mycological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1954','1','22','1951','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1955','1','1' ,'1956','1955');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1957','1','2' ,'1956','Mycological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1958','1','3' ,'1956','Mycological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1959','1','22','1956','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1960','1','1' ,'1961','1960');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1962','1','2' ,'1961','Mycological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1963','1','3' ,'1961','Mycological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1964','1','22','1961','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1965','1','1' ,'1966','1965');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1967','1','2' ,'1966','Mycological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1968','1','3' ,'1966','Mycological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1969','1','22','1966','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1970','1','1' ,'1971','1970');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1972','1','2' ,'1971','Zoological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1973','1','3' ,'1971','Zoological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1974','1','22','1971','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1975','1','1' ,'1976','1975');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1977','1','2' ,'1976','Zoological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1978','1','3' ,'1976','Zoological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1979','1','22','1976','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1980','1','1' ,'1981','1980');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1982','1','2' ,'1981','Zoological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1983','1','3' ,'1981','Zoological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1984','1','22','1981','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1985','1','1' ,'1986','1985');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1987','1','2' ,'1986','Zoological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1988','1','3' ,'1986','Zoological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1989','1','22','1986','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1990','1','1' ,'1991','1990');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1992','1','2' ,'1991','Zoological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1993','1','3' ,'1991','Zoological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1994','1','22','1991','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1995','1','1' ,'1996','1995');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1997','1','2' ,'1996','Paleontological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1998','1','3' ,'1996','Paleontological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1999','1','22','1996','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2000','1','1' ,'2001','2000');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2002','1','2' ,'2001','Other objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2003','1','3' ,'2001','Other objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2004','1','22','2001','');

---------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ---------------------------------
--------------------------------------       type        -- 07.12.2016 ----------------------
---------------------------------------------------------------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2005','5','12' ,'2006','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2007','5','13' ,'2006','material kind');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2008','5','14' ,'2006','material kind');

---------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ---------------------------------
----------------------------------       category type        -- 07.12.2016 -----------------
---------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2009','6','15' ,'2010','1920');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2011','6','16' ,'2010','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2012','6','15' ,'2013','1925');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2014','6','16' ,'2013','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2059','6','15' ,'2015','1930');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2016','6','16' ,'2015','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2017','6','15' ,'2018','1935');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2019','6','16' ,'2018','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2020','6','15' ,'2021','1940');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2022','6','16' ,'2021','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2023','6','15' ,'2024','1945');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2025','6','16' ,'2024','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2026','6','15' ,'2027','1950');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2028','6','16' ,'2027','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2029','6','15' ,'2030','1955');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2031','6','16' ,'2030','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2032','6','15' ,'2033','1960');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2034','6','16' ,'2033','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2035','6','15' ,'2036','1965');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2037','6','16' ,'2036','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2038','6','15' ,'2039','1970');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2040','6','16' ,'2039','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2041','6','15' ,'2042','1975');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2043','6','16' ,'2042','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2044','6','15' ,'2045','1980');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2046','6','16' ,'2045','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2047','6','15' ,'2048','1985');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2049','6','16' ,'2048','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2050','6','15' ,'2051','1990');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2052','6','16' ,'2051','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2053','6','15' ,'2054','1995');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2055','6','16' ,'2054','2005');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2056','6','15' ,'2057','2000');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2058','6','16' ,'2057','2005');

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
------------------------------------      category      -- 19.12.2016 ------------------------
----------------------------------------------------------------------------------------------

UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects' 											WHERE 	contentid =1922;
UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects' 											WHERE 	contentid =1466;


----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content ----------------------------------
------------------------------------      category      -- 20.12.2016 ------------------------
----------------------------------------------------------------------------------------------

UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects' 											WHERE 	contentid =1923;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution' 								WHERE 	contentid =1466;

UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects in ethanol' 								WHERE 	contentid =1937;
UPDATE 	gfbio_content 	SET cellcontent = 'Botanical objects in ethanol'  								WHERE 	contentid =1938;
