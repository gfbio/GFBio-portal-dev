
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
