DROP TABLE IF EXISTS   gfbio_project_user_pi					CASCADE;
DROP TABLE IF EXISTS   gfbio_submissionregistry					CASCADE;
DROP TABLE IF EXISTS   gfbio_dataprovider_persistentidentifier	CASCADE;
DROP TABLE IF EXISTS   gfbio_content							CASCADE;
DROP TABLE IF EXISTS   gfbio_column 							CASCADE;
DROP TABLE IF EXISTS   gfbio_head 								CASCADE;



------------------------------------- Head  -------------------------------------

DROP TABLE IF EXISTS
     gfbio_column,gfbio_content,gfbio_head CASCADE;

CREATE TABLE gfbio_head
(
  headid bigint NOT NULL,
  table_name text NOT NULL,
  table_type text NOT NULL,
  CONSTRAINT gfbio_head_pkey PRIMARY KEY (headid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_head
  OWNER TO liferay_gfbio;
  

------------------------------------- Column   ------------------------------------- 

DROP TABLE IF EXISTS
     gfbio_column;

CREATE TABLE gfbio_column
(
  columnid bigint NOT NULL,
  headid bigint NOT NULL,
  column_name text,
  CONSTRAINT gfbio_column_pkey PRIMARY KEY (columnid),
  CONSTRAINT gfbio_head_fkey FOREIGN KEY (headid)
      REFERENCES gfbio_head (headid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_column
  OWNER TO liferay_gfbio;
  
  
  ------------------------------------- Content  ------------------------------------- 

DROP TABLE IF EXISTS
     gfbio_content;

CREATE TABLE gfbio_content
(
  contentid bigint NOT NULL,
  headid bigint NOT NULL,
  columnid bigint NOT NULL,
  rowid bigint NOT NULL,
  cellcontent text,
  CONSTRAINT gfbio_content_pkey PRIMARY KEY (contentid),
  CONSTRAINT gfbio_column_fkey FOREIGN KEY (columnid)
      REFERENCES gfbio_column (columnid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_head_fkey FOREIGN KEY (headid)
      REFERENCES gfbio_head (headid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_content
  OWNER TO liferay_gfbio;
  


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-----------------------------------     Researchfield     ---------------------------------
-------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('2','gfbio_researchfield','entity');


------------------------------------- Column Table Content -------------------------------------

 
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('4','2','id');				--gfbio_researchfield
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('5','2','name');				--gfbio_researchfield
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('6','2','description');		--gfbio_researchfield


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	513	','	2	','	4	','	204	','513');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	514	','	2	','	5	','	204	','Botany');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	515	','	2	','	6	','	204	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	516	','	2	','	4	','	205	','516');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	517	','	2	','	5	','	205	','Climate Research');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	518	','	2	','	6	','	205	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	519	','	2	','	4	','	206	','519');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	520	','	2	','	5	','	206	','Geology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	521	','	2	','	6	','	206	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	522	','	2	','	4	','	207	','522');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	523	','	2	','	5	','	207	','Meteorology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	524	','	2	','	6	','	207	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	525	','	2	','	4	','	208	','525');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	526	','	2	','	5	','	208	','Microbiology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	527	','	2	','	6	','	208	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	528	','	2	','	4	','	209	','528');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	529	','	2	','	5	','	209	','Palaeontology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	530	','	2	','	6	','	209	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	531	','	2	','	4	','	210	','531');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	532	','	2	','	5	','	210	','Sedimentology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	533	','	2	','	6	','	210	','');






-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------       Type       -----------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('5','gfbio_type','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('12','5','id');				--gfbio_type
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('13','5','name');			--gfbio_type
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('14','5','description');		--gfbio_type


------------------------------------- Content Table Content -------------------------------------


--- gfbio_type
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('298','5','12','100','298');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('299','5','13','100','accesscontrol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('300','5','14','100','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('301','5','12','101','301');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('302','5','13','101','collection taxon');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('303','5','14','101','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('304','5','12','102','304');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('305','5','13','102','collection type');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('306','5','14','102','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('307','5','12','103','307');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('308','5','13','103','datadomain');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('309','5','14','103','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('310','5','12','104','310');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('311','5','13','104','ecological field');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('312','5','14','104','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('313','5','12','105','313');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('314','5','13','105','geographic region');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('315','5','14','105','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('316','5','12','106','316');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('317','5','13','106','taxonomic field');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('318','5','14','106','');


  



-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------------     Category     ------------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('1','gfbio_category','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('1','1','id');				--gfbio_category
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('2','1','name');				--gfbio_category
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('3','1','label');			--gfbio_category
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('22','1','description');		--gfbio_category


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1','1','1','1','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('2','1','2','1','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('3','1','3','1','Africa');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1277','1','22','1','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('4','1','1','2','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('5','1','2','2','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('6','1','3','2','Algae');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1278','1','22','2','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('7','1','1','3','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('8','1','2','3','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('9','1','3','3','Amber collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1279','1','22','3','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('10','1','1','4','10');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('11','1','2','4','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('12','1','3','4','Antarctica');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1280','1','22','4','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('13','1','1','5','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('14','1','2','5','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('15','1','3','5','Anthropological collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1281','1','22','5','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('16','1','1','6','16');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('17','1','2','6','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('18','1','3','6','Arabic peninsula and adjacent areas');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1282','1','22','6','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('19','1','1','7','19');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('20','1','2','7','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('21','1','3','7','Arachnida');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1283','1','22','7','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('22','1','1','8','22');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('23','1','2','8','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('24','1','3','8','Arctica');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1284','1','22','8','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('25','1','1','9','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('26','1','2','9','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('27','1','3','9','Asia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1285','1','22','9','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('28','1','1','10','28');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('29','1','2','10','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('30','1','3','10','Asterales');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1286','1','22','10','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('31','1','1','11','31');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('32','1','2','11','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('33','1','3','11','Aves');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1287','1','22','11','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('34','1','1','12','34');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('35','1','2','12','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('36','1','3','12','Bacteria and Archaea');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1288','1','22','12','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('37','1','1','13','37');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('38','1','2','13','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('39','1','3','13','Baden-Württemberg');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1289','1','22','13','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('40','1','1','14','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('41','1','2','14','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('42','1','3','14','Bavaria');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1290','1','22','14','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('43','1','1','15','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('44','1','2','15','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('45','1','3','15','Berlin');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1291','1','22','15','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('46','1','1','16','46');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('47','1','2','16','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('48','1','3','16','Biological environmental collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1292','1','22','16','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('49','1','1','17','49');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('50','1','2','17','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('51','1','3','17','Biological measurement data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1293','1','22','17','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('52','1','1','18','52');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('53','1','2','18','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('54','1','3','18','Botanical collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1294','1','22','18','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('55','1','1','19','55');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('56','1','2','19','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('57','1','3','19','Brandenburg');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1295','1','22','19','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('58','1','1','20','58');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('59','1','2','20','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('60','1','3','20','Bryophyta');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1296','1','22','20','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('61','1','1','21','61');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('62','1','2','21','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('63','1','3','21','Caryophylales');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1297','1','22','21','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('64','1','1','22','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('65','1','2','22','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('66','1','3','22','Caucasus Region');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1298','1','22','22','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('67','1','1','23','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('68','1','2','23','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('69','1','3','23','Central Asia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1299','1','22','23','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('70','1','1','24','70');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('71','1','2','24','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('72','1','3','24','Chelicerata');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1300','1','22','24','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('73','1','1','25','73');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('74','1','2','25','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('75','1','3','25','Collection data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1301','1','22','25','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('76','1','1','26','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('77','1','2','26','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('78','1','3','26','Content based');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1302','1','22','26','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('79','1','1','27','79');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('80','1','2','27','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('81','1','3','27','Crustacea');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1303','1','22','27','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('82','1','1','28','82');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('83','1','2','28','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('84','1','3','28','Cuba and the Carribbean');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1304','1','22','28','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('85','1','1','29','85');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('86','1','2','29','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('87','1','3','29','Data producer notification on data publication');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1305','1','22','29','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('88','1','1','30','88');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('89','1','2','30','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('90','1','3','30','Deep sea fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1306','1','22','30','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('91','1','1','31','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('92','1','2','31','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('93','1','3','31','Destruents');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1307','1','22','31','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('94','1','1','32','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('95','1','2','32','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('96','1','3','32','Diatoms');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1308','1','22','32','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('97','1','1','33','97');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('98','1','2','33','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('99','1','3','33','DNA-samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1309','1','22','33','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('103','1','1','35','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('104','1','2','35','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('105','1','3','35','Embargo period');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1310','1','22','35','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('106','1','1','36','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('107','1','2','36','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('108','1','3','36','Embargo until paper publication');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1311','1','22','36','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('109','1','1','37','109');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('110','1','2','37','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('111','1','3','37','Embryology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1312','1','22','37','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('112','1','1','38','112');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('113','1','2','38','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('114','1','3','38','Environmental data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1313','1','22','38','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('118','1','1','40','118');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('119','1','2','40','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('120','1','3','40','Europe');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1314','1','22','40','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('121','1','1','41','121');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('122','1','2','41','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('123','1','3','41','European Alps');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1315','1','22','41','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('124','1','1','42','124');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('125','1','2','42','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('126','1','3','42','Extreme regions worldwide (alpine, arid)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1316','1','22','42','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('127','1','1','43','127');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('128','1','2','43','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('129','1','3','43','File type based');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1317','1','22','43','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('130','1','1','44','130');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('131','1','2','44','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('132','1','3','44','For publication only');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1318','1','22','44','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('133','1','1','45','133');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('134','1','2','45','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('135','1','3','45','Hemimetabola');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1319','1','22','45','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('136','1','1','46','136');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('137','1','2','46','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('138','1','3','46','Hesse');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1320','1','22','46','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('139','1','1','47','139');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('140','1','2','47','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('141','1','3','47','Indo-pacific');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1321','1','22','47','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('142','1','1','48','142');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('143','1','2','48','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('144','1','3','48','Insecta');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1322','1','22','48','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('145','1','1','49','145');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('146','1','2','49','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('147','1','3','49','Invertebrate fossils');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1323','1','22','49','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('148','1','1','50','148');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('149','1','2','50','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('150','1','3','50','Invertebrates');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1324','1','22','50','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('151','1','1','51','151');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('152','1','2','51','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('153','1','3','51','Japan');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1325','1','22','51','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('154','1','1','52','154');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('155','1','2','52','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('156','1','3','52','Lichen');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1326','1','22','52','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('157','1','1','53','157');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('158','1','2','53','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('159','1','3','53','Light microscopical slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1327','1','22','53','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('160','1','1','54','160');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('161','1','2','54','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('162','1','3','54','Limnological fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1328','1','22','54','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('163','1','1','55','163');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('164','1','2','55','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('165','1','3','55','Littoral fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1329','1','22','55','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('166','1','1','56','166');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('167','1','2','56','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('168','1','3','56','Macrofungi');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1330','1','22','56','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('169','1','1','57','169');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('170','1','2','57','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('171','1','3','57','Mammalia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1331','1','22','57','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('172','1','1','58','172');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('173','1','2','58','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('174','1','3','58','Marine circumpolar fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1332','1','22','58','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('175','1','1','59','175');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('176','1','2','59','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('177','1','3','59','Marine micro fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1333','1','22','59','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('178','1','1','60','178');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('179','1','2','60','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('180','1','3','60','Mediterranean fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1334','1','22','60','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('181','1','1','61','181');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('182','1','2','61','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('183','1','3','61','Mediterranean flora');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1335','1','22','61','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('184','1','1','62','184');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('185','1','2','62','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('186','1','3','62','Metazoa');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1336','1','22','62','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('187','1','1','63','187');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('188','1','2','63','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('189','1','3','63','Microfossils');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1337','1','22','63','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('190','1','1','64','190');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('191','1','2','64','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('192','1','3','64','Microfungi');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1338','1','22','64','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('193','1','1','65','193');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('194','1','2','65','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('195','1','3','65','Molecular data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1339','1','22','65','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('196','1','1','66','196');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('197','1','2','66','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('198','1','3','66','Mollusca');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1340','1','22','66','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('199','1','1','67','199');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('200','1','2','67','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('201','1','3','67','Morphological and structural descriptions');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1341','1','22','67','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('202','1','1','68','202');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('203','1','2','68','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('204','1','3','68','Mycological collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1342','1','22','68','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('205','1','1','69','205');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('206','1','2','69','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('207','1','3','69','Myriapoda');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1343','1','22','69','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('208','1','1','70','208');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('209','1','2','70','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('210','1','3','70','North sea');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1344','1','22','70','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('211','1','1','71','211');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('212','1','2','71','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('213','1','3','71','Occurrence and observational data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1345','1','22','71','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('214','1','1','72','214');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('215','1','2','72','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('216','1','3','72','Organisms');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1346','1','22','72','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('217','1','1','73','217');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('218','1','2','73','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('219','1','3','73','Palaeoanthropology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1347','1','22','73','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('220','1','1','74','220');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('221','1','2','74','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('222','1','3','74','Paleontological collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1348','1','22','74','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('223','1','1','75','223');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('224','1','2','75','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('225','1','3','75','Parasitic fungi');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1349','1','22','75','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('226','1','1','76','226');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('227','1','2','76','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('228','1','3','76','Parasitic organisms');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1350','1','22','76','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('229','1','1','77','229');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('230','1','2','77','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('231','1','3','77','Plant fossils');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1351','1','22','77','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('232','1','1','78','232');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('233','1','2','78','Fishes');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('234','1','3','78','Pisces');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1352','1','22','78','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('235','1','1','79','235');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('236','1','2','79','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('237','1','3','79','Protozoa');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1353','1','22','79','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('238','1','1','80','238');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('239','1','2','80','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('240','1','3','80','Red sea');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1354','1','22','80','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('241','1','1','81','241');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('242','1','2','81','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('243','1','3','81','Registered GFBio users');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1355','1','22','81','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('244','1','1','82','244');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('245','1','2','82','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('246','1','3','82','Reptilia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1356','1','22','82','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('247','1','1','83','247');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('248','1','2','83','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('249','1','3','83','Rhineland/North Rhine-Westphalia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1357','1','22','83','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('250','1','1','84','250');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('251','1','2','84','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('252','1','3','84','Single users');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1358','1','22','84','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('253','1','1','85','253');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('254','1','2','85','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('255','1','3','85','Soil organisms');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1359','1','22','85','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('256','1','1','86','256');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('257','1','2','86','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('258','1','3','86','South and Central America');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1360','1','22','86','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('259','1','1','87','259');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('260','1','2','87','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('261','1','3','87','South Asia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1361','1','22','87','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('262','1','1','88','262');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('263','1','2','88','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('264','1','3','88','Southeast Asia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1362','1','22','88','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('265','1','1','89','265');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('266','1','2','89','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('267','1','3','89','Survey data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1363','1','22','89','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('268','1','1','90','268');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('269','1','2','90','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('270','1','3','90','Terrestrial fauna');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1364','1','22','90','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('271','1','1','91','271');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('272','1','2','91','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('273','1','3','91','Tissue collection');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1365','1','22','91','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('274','1','1','92','274');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('275','1','2','92','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('276','1','3','92','Trait data');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1366','1','22','92','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('277','1','1','93','277');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('278','1','2','93','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('279','1','3','93','Tropical rainforest');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1367','1','22','93','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('280','1','1','94','280');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('281','1','2','94','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('282','1','3','94','Vascular plants');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1368','1','22','94','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('283','1','1','95','283');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('284','1','2','95','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('285','1','3','95','Vermes');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1369','1','22','95','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('286','1','1','96','286');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('287','1','2','96','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('288','1','3','96','Vertebrate fossils');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1370','1','22','96','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('289','1','1','97','289');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('290','1','2','97','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('291','1','3','97','Viruses and Phages');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1371','1','22','97','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('292','1','1','98','292');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('293','1','2','98','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('294','1','3','98','Workgroup members');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1372','1','22','98','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('295','1','1','99','295');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('296','1','2','99','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('297','1','3','99','Zoological collections');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1373','1','22','99','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('624','1','1','256','624');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('625','1','2','256','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('626','1','3','256','Cell cultures');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1374','1','22','256','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('695','1','1','291','695');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('696','1','2','291','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('697','1','3','291','Tissue cultures');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1375','1','22','291','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('716','1','1','301','716');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('717','1','2','301','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('718','1','3','301','Amphibia');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1376','1','22','301','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1087','1','1','486','1087');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1088','1','2','486','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1089','1','3','486','America');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1377','1','22','486','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1242','1','1','563','1242');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1243','1','2','563','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1244','1','3','563','Vertebrata');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1378','1','22','563','');







-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Persistent Identifier     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('3','gfbio_persistentidentifier','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('7','3','id');								--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('8','3','name');								--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('9','3','label');							--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('19','3','website');							--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('20','3','has fee on id registration');		--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('21','3','change on id possible');			--gfbio_persistentidentifier

------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1265	','	3	','	7	','	574	','	1265');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1266	','	3	','	8	','	574	','	Accession Number');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1267	','	3	','	9	','	574	','	ACCESSION');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1268	','	3	','	7	','	575	','	1030');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1269	','	3	','	8	','	575	','	Digital Object Identifier');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1270	','	3	','	9	','	575	','	DOI');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1271	','	3	','	19	','	574	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1272	','	3	','	20	','	574	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1273	','	3	','	21	','	574	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1274	','	3	','	19	','	575	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1275	','	3	','	20	','	575	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1276	','	3	','	21	','	575	','');




-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Category Researchfield     ----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('4','gfbio_category_researchfield','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('10','4','gfbio_category');		--gfbio_category_researchfield
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('11','4','gfbio_researchfield');	--gfbio_category_researchfield


------------------------------------- Content Table Content -------------------------------------






-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-----------------------------------     Category Type     ---------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('6','gfbio_category_type','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('15','6','gfbio_category');		--gfbio_category_type
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('16','6','gfbio_type');			--gfbio_category_type


------------------------------------- Content Table Content -------------------------------------


--- gfbio_category_type
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	319	','	6	','	15	','	107	','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	320	','	6	','	16	','	107	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	321	','	6	','	15	','	108	','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	322	','	6	','	16	','	108	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	323	','	6	','	15	','	109	','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	324	','	6	','	16	','	109	','101');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	325	','	6	','	15	','	110	','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	326	','	6	','	16	','	110	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	327	','	6	','	15	','	111	','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	328	','	6	','	16	','	111	','101');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	329	','	6	','	15	','	112	','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	330	','	6	','	16	','	112	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	331	','	6	','	15	','	113	','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	332	','	6	','	16	','	113	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	333	','	6	','	15	','	114	','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	334	','	6	','	16	','	114	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	335	','	6	','	15	','	115	','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	336	','	6	','	16	','	115	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	337	','	6	','	15	','	116	','10');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	338	','	6	','	16	','	116	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	339	','	6	','	15	','	117	','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	340	','	6	','	16	','	117	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	341	','	6	','	15	','	118	','12');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	342	','	6	','	16	','	118	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	343	','	6	','	15	','	119	','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	344	','	6	','	16	','	119	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	345	','	6	','	15	','	120	','14');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	346	','	6	','	16	','	120	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	347	','	6	','	15	','	121	','15');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	348	','	6	','	16	','	121	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	349	','	6	','	15	','	122	','16');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	350	','	6	','	16	','	122	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	351	','	6	','	15	','	123	','17');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	352	','	6	','	16	','	123	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	353	','	6	','	15	','	124	','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	354	','	6	','	16	','	124	','101');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	355	','	6	','	15	','	125	','19');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	356	','	6	','	16	','	125	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	357	','	6	','	15	','	126	','20');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	358	','	6	','	16	','	126	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	359	','	6	','	15	','	127	','21');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	360	','	6	','	16	','	127	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	361	','	6	','	15	','	128	','22');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	362	','	6	','	16	','	128	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	363	','	6	','	15	','	129	','23');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	364	','	6	','	16	','	129	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	365	','	6	','	15	','	130	','24');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	366	','	6	','	16	','	130	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	367	','	6	','	15	','	131	','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	368	','	6	','	16	','	131	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	369	','	6	','	15	','	132	','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	370	','	6	','	16	','	132	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	371	','	6	','	15	','	133	','27');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	372	','	6	','	16	','	133	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	373	','	6	','	15	','	134	','28');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	374	','	6	','	16	','	134	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	375	','	6	','	15	','	135	','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	376	','	6	','	16	','	135	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	377	','	6	','	15	','	136	','30');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	378	','	6	','	16	','	136	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	379	','	6	','	15	','	137	','31');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	380	','	6	','	16	','	137	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	381	','	6	','	15	','	138	','32');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	382	','	6	','	16	','	138	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	383	','	6	','	15	','	139	','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	384	','	6	','	16	','	139	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	385	','	6	','	15	','	140	','34');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	386	','	6	','	16	','	140	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	387	','	6	','	15	','	141	','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	388	','	6	','	16	','	141	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	389	','	6	','	15	','	142	','36');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	390	','	6	','	16	','	142	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	391	','	6	','	15	','	143	','37');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	392	','	6	','	16	','	143	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	393	','	6	','	15	','	144	','38');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	394	','	6	','	16	','	144	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	395	','	6	','	15	','	145	','39');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	396	','	6	','	16	','	145	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	397	','	6	','	15	','	146	','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	398	','	6	','	16	','	146	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	399	','	6	','	15	','	147	','41');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	400	','	6	','	16	','	147	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	401	','	6	','	15	','	148	','42');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	402	','	6	','	16	','	148	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	403	','	6	','	15	','	149	','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	404	','	6	','	16	','	149	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	405	','	6	','	15	','	150	','44');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	406	','	6	','	16	','	150	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	407	','	6	','	15	','	151	','45');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	408	','	6	','	16	','	151	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	409	','	6	','	15	','	152	','46');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	410	','	6	','	16	','	152	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	411	','	6	','	15	','	153	','47');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	412	','	6	','	16	','	153	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	413	','	6	','	15	','	154	','48');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	414	','	6	','	16	','	154	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	415	','	6	','	15	','	155	','49');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	416	','	6	','	16	','	155	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	417	','	6	','	15	','	156	','50');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	418	','	6	','	16	','	156	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	419	','	6	','	15	','	157	','51');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	420	','	6	','	16	','	157	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	421	','	6	','	15	','	158	','52');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	422	','	6	','	16	','	158	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	423	','	6	','	15	','	159	','53');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	424	','	6	','	16	','	159	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	425	','	6	','	15	','	160	','54');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	426	','	6	','	16	','	160	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	427	','	6	','	15	','	161	','55');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	428	','	6	','	16	','	161	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	429	','	6	','	15	','	162	','56');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	430	','	6	','	16	','	162	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	431	','	6	','	15	','	163	','57');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	432	','	6	','	16	','	163	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	433	','	6	','	15	','	164	','58');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	434	','	6	','	16	','	164	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	435	','	6	','	15	','	165	','59');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	436	','	6	','	16	','	165	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	437	','	6	','	15	','	166	','60');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	438	','	6	','	16	','	166	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	439	','	6	','	15	','	167	','61');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	440	','	6	','	16	','	167	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	441	','	6	','	15	','	168	','62');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	442	','	6	','	16	','	168	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	443	','	6	','	15	','	169	','63');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	444	','	6	','	16	','	169	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	445	','	6	','	15	','	170	','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	446	','	6	','	16	','	170	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	447	','	6	','	15	','	171	','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	448	','	6	','	16	','	171	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	449	','	6	','	15	','	172	','66');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	450	','	6	','	16	','	172	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	451	','	6	','	15	','	173	','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	452	','	6	','	16	','	173	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	453	','	6	','	15	','	174	','68');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	454	','	6	','	16	','	174	','101');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	455	','	6	','	15	','	175	','69');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	456	','	6	','	16	','	175	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	457	','	6	','	15	','	176	','70');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	458	','	6	','	16	','	176	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	459	','	6	','	15	','	177	','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	460	','	6	','	16	','	177	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	461	','	6	','	15	','	178	','72');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	462	','	6	','	16	','	178	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	463	','	6	','	15	','	179	','73');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	464	','	6	','	16	','	179	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	465	','	6	','	15	','	180	','74');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	466	','	6	','	16	','	180	','101');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	467	','	6	','	15	','	181	','75');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	468	','	6	','	16	','	181	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	469	','	6	','	15	','	182	','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	470	','	6	','	16	','	182	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	471	','	6	','	15	','	183	','77');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	472	','	6	','	16	','	183	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	473	','	6	','	15	','	184	','78');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	474	','	6	','	16	','	184	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	475	','	6	','	15	','	185	','79');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	476	','	6	','	16	','	185	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	477	','	6	','	15	','	186	','80');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	478	','	6	','	16	','	186	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	479	','	6	','	15	','	187	','81');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	480	','	6	','	16	','	187	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	481	','	6	','	15	','	188	','82');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	482	','	6	','	16	','	188	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	483	','	6	','	15	','	189	','83');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	484	','	6	','	16	','	189	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	485	','	6	','	15	','	190	','84');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	486	','	6	','	16	','	190	','100');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	487	','	6	','	15	','	191	','85');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	488	','	6	','	16	','	191	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	489	','	6	','	15	','	192	','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	490	','	6	','	16	','	192	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	491	','	6	','	15	','	193	','87');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	492	','	6	','	16	','	193	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	493	','	6	','	15	','	194	','88');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	494	','	6	','	16	','	194	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	495	','	6	','	15	','	195	','89');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	496	','	6	','	16	','	195	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	497	','	6	','	15	','	196	','90');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	498	','	6	','	16	','	196	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	499	','	6	','	15	','	197	','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	500	','	6	','	16	','	197	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	501	','	6	','	15	','	198	','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	502	','	6	','	16	','	198	','103');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	503	','	6	','	15	','	199	','93');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	504	','	6	','	16	','	199	','104');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	505	','	6	','	15	','	200	','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	506	','	6	','	16	','	200	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	507	','	6	','	15	','	201	','95');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	508	','	6	','	16	','	201	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	509	','	6	','	15	','	202	','96');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	510	','	6	','	16	','	202	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	511	','	6	','	15	','	203	','97');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	512	','	6	','	16	','	203	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	627	','	6	','	15	','	257	','256');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	628	','	6	','	16	','	257	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	698	','	6	','	15	','	292	','291');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	699	','	6	','	16	','	292	','102');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	719	','	6	','	15	','	302	','301');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	720	','	6	','	16	','	302	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1090','	6	','	15	','	487	','486');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1091','	6	','	16	','	487	','105');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1245','	6	','	15	','	564	','563');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1246','	6	','	16	','	564	','106');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1379','	6	','	15	','	574	','99');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1380','	6	','	16	','	574	','101');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1381	','	6	','	15	','	575	','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1382	','	6	','	16	','	575	','100');




-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
----------------------------------     Categoryparent     ---------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('8','gfbio_categoryparent','parentrelationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('23','8','gfbio_category');	--gfbio_category
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('24','8','parent');			--parent category


------------------------------- Data Provider / Persistent Identifier -----------------------

DROP TABLE IF EXISTS
     gfbio_dataprovider_persistentidentifier;

CREATE TABLE gfbio_dataprovider_persistentidentifier
(
  gfbio_dataprovider bigint NOT NULL,
  gfbio_persistentidentifier bigint NOT NULL,
  CONSTRAINT gfbio_dataprovider_persistentidentifier_pkey PRIMARY KEY (gfbio_dataprovider, gfbio_persistentidentifier),
  CONSTRAINT gfbio_dataprovider FOREIGN KEY (gfbio_dataprovider)
      REFERENCES gfbio_dataprovider (dataproviderid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_persistentidentifier FOREIGN KEY (gfbio_persistentidentifier)
      REFERENCES gfbio_content (contentid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_dataprovider_persistentidentifier
  OWNER TO liferay_gfbio;
  
  
  
  ------------------------------------- Content Dataprovider Persistent Identifier -------------------------------------


INSERT INTO gfbio_dataprovider_persistentidentifier (gfbio_dataprovider, gfbio_persistentidentifier) VALUES ('4','1268');
INSERT INTO gfbio_dataprovider_persistentidentifier (gfbio_dataprovider, gfbio_persistentidentifier) VALUES ('9','1265');





-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Category Dataprovider     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('7','gfbio_category_dataprovider','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('17','6','gfbio_category');		--gfbio_category_dataprovider
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('18','6','gfbio_dataprovider');	--gfbio_category_dataprovider


------------------------------------- Content Table Content -------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('534','7','17','211','20');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('535','7','18','211','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('536','7','17','212','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('537','7','18','212','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('538','7','17','213','52');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('539','7','18','213','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('540','7','17','214','32');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('541','7','18','214','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('542','7','17','215','56');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('543','7','18','215','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('544','7','17','216','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('545','7','18','216','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('546','7','17','217','75');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('547','7','18','217','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('548','7','17','218','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('549','7','18','218','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('550','7','17','219','10');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('551','7','18','219','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('552','7','17','220','21');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('553','7','18','220','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('554','7','17','221','93');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('555','7','18','221','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('556','7','17','222','61');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('557','7','18','222','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('558','7','17','223','28');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('559','7','18','223','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('560','7','17','224','15');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('561','7','18','224','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('562','7','17','225','19');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('563','7','18','225','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('564','7','17','226','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('565','7','18','226','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('566','7','17','227','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('567','7','18','227','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('568','7','17','228','22');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('569','7','18','228','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('570','7','17','229','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('571','7','18','229','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('572','7','17','230','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('573','7','18','230','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('574','7','17','231','81');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('575','7','18','231','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('576','7','17','232','84');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('577','7','18','232','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('578','7','17','233','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('579','7','18','233','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('580','7','17','234','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('581','7','18','234','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('582','7','17','235','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('583','7','18','235','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('584','7','17','236','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('585','7','18','236','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('586','7','17','237','72');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('587','7','18','237','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('588','7','17','238','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('589','7','18','238','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('590','7','17','239','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('591','7','18','239','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('592','7','17','240','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('593','7','18','240','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('594','7','17','241','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('595','7','18','241','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('596','7','17','242','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('597','7','18','242','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('598','7','17','243','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('599','7','18','243','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('600','7','17','244','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('601','7','18','244','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('602','7','17','245','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('603','7','18','245','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('604','7','17','246','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('605','7','18','246','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('606','7','17','247','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('607','7','18','247','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('608','7','17','248','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('609','7','18','248','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('610','7','17','249','12');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('611','7','18','249','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('612','7','17','250','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('613','7','18','250','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('614','7','17','251','14');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('615','7','18','251','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('616','7','17','252','15');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('617','7','18','252','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('618','7','17','253','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('619','7','18','253','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('620','7','17','254','19');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('621','7','18','254','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('622','7','17','255','22');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('623','7','18','255','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('629','7','17','258','256');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('630','7','18','258','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('631','7','17','259','23');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('632','7','18','259','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('633','7','17','260','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('634','7','18','260','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('635','7','17','261','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('636','7','18','261','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('637','7','17','262','28');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('638','7','18','262','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('639','7','17','263','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('640','7','18','263','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('641','7','17','264','31');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('642','7','18','264','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('643','7','17','265','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('644','7','18','265','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('645','7','17','266','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('646','7','18','266','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('647','7','17','267','41');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('648','7','18','267','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('649','7','17','268','42');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('650','7','18','268','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('651','7','17','269','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('652','7','18','269','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('653','7','17','270','44');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('654','7','18','270','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('655','7','17','271','46');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('656','7','18','271','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('657','7','17','272','47');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('658','7','18','272','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('659','7','17','273','51');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('660','7','18','273','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('661','7','17','274','56');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('662','7','18','274','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('663','7','17','275','62');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('664','7','18','275','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('665','7','17','276','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('666','7','18','276','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('667','7','17','277','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('668','7','18','277','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('669','7','17','278','68');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('670','7','18','278','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('671','7','17','279','70');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('672','7','18','279','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('673','7','17','280','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('674','7','18','280','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('675','7','17','281','75');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('676','7','18','281','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('677','7','17','282','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('678','7','18','282','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('679','7','17','283','79');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('680','7','18','283','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('681','7','17','284','83');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('682','7','18','284','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('683','7','17','285','84');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('684','7','18','285','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('685','7','17','286','85');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('686','7','18','286','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('687','7','17','287','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('688','7','18','287','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('689','7','17','288','87');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('690','7','18','288','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('691','7','17','289','89');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('692','7','18','289','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('693','7','17','290','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('694','7','18','290','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('700','7','17','293','291');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('701','7','18','293','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('702','7','17','294','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('703','7','18','294','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('704','7','17','295','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('705','7','18','295','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('706','7','17','296','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('707','7','18','296','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('708','7','17','297','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('709','7','18','297','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('710','7','17','298','80');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('711','7','18','298','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('712','7','17','299','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('713','7','18','299','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('714','7','17','300','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('715','7','18','300','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('721','7','17','303','301');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('722','7','18','303','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('723','7','17','304','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('724','7','18','304','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('725','7','17','305','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('726','7','18','305','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('727','7','17','306','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('728','7','18','306','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('729','7','17','307','17');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('730','7','18','307','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('731','7','17','308','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('732','7','18','308','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('733','7','17','309','24');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('734','7','18','309','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('735','7','17','310','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('736','7','18','310','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('737','7','17','311','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('738','7','18','311','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('739','7','17','312','27');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('740','7','18','312','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('741','7','17','313','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('742','7','18','313','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('743','7','17','314','30');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('744','7','18','314','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('745','7','17','315','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('746','7','18','315','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('747','7','17','316','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('748','7','18','316','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('749','7','17','317','37');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('750','7','18','317','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('751','7','17','318','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('752','7','18','318','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('753','7','17','319','44');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('754','7','18','319','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('755','7','17','320','45');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('756','7','18','320','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('757','7','17','321','47');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('758','7','18','321','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('759','7','17','322','48');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('760','7','18','322','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('761','7','17','323','49');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('762','7','18','323','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('763','7','17','324','50');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('764','7','18','324','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('765','7','17','325','57');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('766','7','18','325','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('767','7','17','326','59');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('768','7','18','326','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('769','7','17','327','62');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('770','7','18','327','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('771','7','17','328','63');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('772','7','18','328','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('773','7','17','329','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('774','7','18','329','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('775','7','17','330','66');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('776','7','18','330','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('777','7','17','331','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('778','7','18','331','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('779','7','17','332','69');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('780','7','18','332','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('781','7','17','333','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('782','7','18','333','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('783','7','17','334','74');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('784','7','18','334','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('785','7','17','335','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('786','7','18','335','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('787','7','17','336','78');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('788','7','18','336','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('789','7','17','337','77');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('790','7','18','337','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('791','7','17','338','82');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('792','7','18','338','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('793','7','17','339','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('794','7','18','339','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('795','7','17','340','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('796','7','18','340','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('797','7','17','341','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('798','7','18','341','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('799','7','17','342','95');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('800','7','18','342','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('801','7','17','343','96');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('802','7','18','343','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('803','7','17','344','99');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('804','7','18','344','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('805','7','17','345','72');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('806','7','18','345','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('807','7','17','346','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('808','7','18','346','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('809','7','17','347','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('810','7','18','347','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('811','7','17','348','17');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('812','7','18','348','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('813','7','17','349','27');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('814','7','18','349','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('815','7','17','350','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('816','7','18','350','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('817','7','17','351','30');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('818','7','18','351','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('819','7','17','352','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('820','7','18','352','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('821','7','17','353','36');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('822','7','18','353','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('823','7','17','354','38');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('824','7','18','354','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('825','7','17','355','44');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('826','7','18','355','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('827','7','17','356','50');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('828','7','18','356','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('829','7','17','357','58');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('830','7','18','357','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('831','7','17','358','59');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('832','7','18','358','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('833','7','17','359','62');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('834','7','18','359','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('835','7','17','360','63');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('836','7','18','360','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('837','7','17','361','66');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('838','7','18','361','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('839','7','17','362','70');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('840','7','18','362','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('841','7','17','363','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('842','7','18','363','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('843','7','17','364','79');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('844','7','18','364','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('845','7','17','365','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('846','7','18','365','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('847','7','17','366','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('848','7','18','366','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('849','7','17','367','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('850','7','18','367','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('851','7','17','368','301');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('852','7','18','368','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('853','7','17','369','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('854','7','18','369','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('855','7','17','370','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('856','7','18','370','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('857','7','17','371','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('858','7','18','371','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('859','7','17','372','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('860','7','18','372','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('861','7','17','373','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('862','7','18','373','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('863','7','17','374','16');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('864','7','18','374','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('865','7','17','375','17');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('866','7','18','375','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('867','7','17','376','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('868','7','18','376','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('869','7','17','377','23');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('870','7','18','377','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('871','7','17','378','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('872','7','18','378','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('873','7','17','379','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('874','7','18','379','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('875','7','17','380','27');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('876','7','18','380','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('877','7','17','381','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('878','7','18','381','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('879','7','17','382','30');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('880','7','18','382','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('881','7','17','383','31');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('882','7','18','383','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('883','7','17','384','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('884','7','18','384','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('885','7','17','385','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('886','7','18','385','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('887','7','17','386','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('888','7','18','386','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('889','7','17','387','41');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('890','7','18','387','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('891','7','17','388','46');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('892','7','18','388','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('893','7','17','389','47');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('894','7','18','389','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('895','7','17','390','48');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('896','7','18','390','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('897','7','17','391','50');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('898','7','18','391','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('899','7','17','392','51');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('900','7','18','392','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('901','7','17','393','52');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('902','7','18','393','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('903','7','17','394','54');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('904','7','18','394','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('905','7','17','395','55');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('906','7','18','395','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('907','7','17','396','56');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('908','7','18','396','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('909','7','17','397','57');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('910','7','18','397','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('911','7','17','398','58');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('912','7','18','398','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('913','7','17','399','59');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('914','7','18','399','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('915','7','17','400','60');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('916','7','18','400','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('917','7','17','401','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('918','7','18','401','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('919','7','17','402','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('920','7','18','402','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('921','7','17','403','66');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('922','7','18','403','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('923','7','17','404','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('924','7','18','404','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('925','7','17','405','68');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('926','7','18','405','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('927','7','17','406','70');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('928','7','18','406','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('929','7','17','407','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('930','7','18','407','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('931','7','17','408','72');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('932','7','18','408','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('933','7','17','409','73');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('934','7','18','409','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('935','7','17','410','74');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('936','7','18','410','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('937','7','17','411','75');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('938','7','18','411','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('939','7','17','412','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('940','7','18','412','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('941','7','17','413','78');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('942','7','18','413','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('943','7','17','414','82');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('944','7','18','414','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('945','7','17','415','85');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('946','7','18','415','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('947','7','17','416','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('948','7','18','416','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('949','7','17','417','87');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('950','7','18','417','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('951','7','17','418','89');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('952','7','18','418','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('953','7','17','419','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('954','7','18','419','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('955','7','17','420','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('956','7','18','420','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('957','7','17','421','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('958','7','18','421','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('959','7','17','422','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('960','7','18','422','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('961','7','17','423','99');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('962','7','18','423','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('963','7','17','424','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('964','7','18','424','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('965','7','17','425','80');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('966','7','18','425','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('967','7','17','426','84');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('968','7','18','426','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('969','7','17','427','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('970','7','18','427','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('971','7','17','428','3');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('972','7','18','428','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('973','7','17','429','301');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('974','7','18','429','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('975','7','17','430','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('976','7','18','430','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('977','7','17','431','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('978','7','18','431','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('979','7','17','432','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('980','7','18','432','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('981','7','17','433','10');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('982','7','18','433','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('983','7','17','434','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('984','7','18','434','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('985','7','17','435','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('986','7','18','435','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('987','7','17','436','17');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('988','7','18','436','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('989','7','17','437','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('990','7','18','437','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('991','7','17','438','20');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('992','7','18','438','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('993','7','17','439','21');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('994','7','18','439','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('995','7','17','440','23');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('996','7','18','440','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('997','7','17','441','24');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('998','7','18','441','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('999','7','17','442','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1000','7','18','442','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1001','7','17','443','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1002','7','18','443','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1003','7','17','444','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1004','7','18','444','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1005','7','17','445','31');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1006','7','18','445','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1007','7','17','446','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1008','7','18','446','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1009','7','17','447','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1010','7','18','447','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1011','7','17','448','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1012','7','18','448','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1013','7','17','449','42');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1014','7','18','449','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1015','7','17','450','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1016','7','18','450','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1017','7','17','451','45');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1018','7','18','451','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1019','7','17','452','47');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1020','7','18','452','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1021','7','17','453','48');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1022','7','18','453','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1023','7','17','454','50');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1024','7','18','454','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1025','7','17','455','52');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1026','7','18','455','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1027','7','17','456','54');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1028','7','18','456','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1029','7','17','457','56');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1030','7','18','457','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1031','7','17','458','57');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1032','7','18','458','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1033','7','17','459','60');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1034','7','18','459','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1035','7','17','460','61');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1036','7','18','460','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1037','7','17','461','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1038','7','18','461','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1039','7','17','462','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1040','7','18','462','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1041','7','17','463','66');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1042','7','18','463','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1043','7','17','464','68');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1044','7','18','464','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1045','7','17','465','69');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1046','7','18','465','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1047','7','17','466','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1048','7','18','466','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1049','7','17','467','72');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1050','7','18','467','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1051','7','17','468','73');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1052','7','18','468','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1053','7','17','469','74');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1054','7','18','469','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1055','7','17','470','75');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1056','7','18','470','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1057','7','17','471','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1058','7','18','471','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1059','7','17','472','78');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1060','7','18','472','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1061','7','17','473','82');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1062','7','18','473','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1063','7','17','474','84');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1064','7','18','474','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1065','7','17','475','85');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1066','7','18','475','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1067','7','17','476','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1068','7','18','476','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1069','7','17','477','88');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1070','7','18','477','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1071','7','17','478','90');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1072','7','18','478','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1073','7','17','479','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1074','7','18','479','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1075','7','17','480','93');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1076','7','18','480','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1077','7','17','481','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1078','7','18','481','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1079','7','17','482','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1080','7','18','482','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1081','7','17','483','99');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1082','7','18','483','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1083','7','17','484','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1084','7','18','484','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1085','7','17','485','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1086','7','18','485','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1092','7','17','488','486');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1093','7','18','488','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1094','7','17','489','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1095','7','18','489','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1096','7','17','490','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1097','7','18','490','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1098','7','17','491','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1099','7','18','491','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1100','7','17','492','14');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1101','7','18','492','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1102','7','17','493','16');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1103','7','18','493','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1104','7','17','494','17');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1105','7','18','494','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1106','7','17','495','18');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1107','7','18','495','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1108','7','17','496','23');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1109','7','18','496','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1110','7','17','497','24');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1111','7','18','497','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1112','7','17','498','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1113','7','18','498','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1114','7','17','499','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1115','7','18','499','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1116','7','17','500','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1117','7','18','500','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1118','7','17','501','31');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1119','7','18','501','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1120','7','17','502','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1121','7','18','502','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1122','7','17','503','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1123','7','18','503','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1124','7','17','504','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1125','7','18','504','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1126','7','17','505','41');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1127','7','18','505','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1128','7','17','506','42');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1129','7','18','506','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1130','7','17','507','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1131','7','18','507','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1132','7','17','508','48');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1133','7','18','508','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1134','7','17','509','52');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1135','7','18','509','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1136','7','17','510','56');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1137','7','18','510','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1138','7','17','511','64');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1139','7','18','511','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1140','7','17','512','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1141','7','18','512','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1142','7','17','513','66');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1143','7','18','513','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1144','7','17','514','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1145','7','18','514','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1146','7','17','515','68');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1147','7','18','515','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1148','7','17','516','69');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1149','7','18','516','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1150','7','17','517','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1151','7','18','517','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1152','7','17','518','74');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1153','7','18','518','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1154','7','17','519','75');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1155','7','18','519','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1156','7','17','520','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1157','7','18','520','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1158','7','17','521','78');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1159','7','18','521','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1160','7','17','522','84');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1161','7','18','522','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1162','7','17','523','85');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1163','7','18','523','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1164','7','17','524','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1165','7','18','524','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1166','7','17','525','87');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1167','7','18','525','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1168','7','17','526','90');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1169','7','18','526','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1170','7','17','527','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1171','7','18','527','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1172','7','17','528','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1173','7','18','528','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1174','7','17','529','93');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1175','7','18','529','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1176','7','17','530','94');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1177','7','18','530','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1178','7','17','531','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1179','7','18','531','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1180','7','17','532','99');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1181','7','18','532','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1182','7','17','533','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1183','7','18','533','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1184','7','17','534','301');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1185','7','18','534','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1186','7','17','535','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1187','7','18','535','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1188','7','17','536','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1189','7','18','536','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1190','7','17','537','25');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1191','7','18','537','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1192','7','17','538','26');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1193','7','18','538','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1194','7','17','539','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1195','7','18','539','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1196','7','17','540','33');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1197','7','18','540','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1198','7','17','541','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1199','7','18','541','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1200','7','17','542','40');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1201','7','18','542','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1202','7','17','543','43');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1203','7','18','543','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1204','7','17','544','47');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1205','7','18','544','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1206','7','17','545','48');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1207','7','18','545','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1208','7','17','546','50');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1209','7','18','546','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1210','7','17','547','53');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1211','7','18','547','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1212','7','17','548','54');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1213','7','18','548','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1214','7','17','549','57');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1215','7','18','549','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1216','7','17','550','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1217','7','18','550','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1218','7','17','551','67');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1219','7','18','551','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1220','7','17','552','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1221','7','18','552','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1222','7','17','553','72');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1223','7','18','553','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1224','7','17','554','76');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1225','7','18','554','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1226','7','17','555','78');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1227','7','18','555','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1228','7','17','556','82');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1229','7','18','556','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1230','7','17','557','83');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1231','7','18','557','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1232','7','17','558','86');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1233','7','18','558','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1234','7','17','559','90');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1235','7','18','559','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1236','7','17','560','91');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1237','7','18','560','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1238','7','17','561','92');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1239','7','18','561','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1240','7','17','562','93');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1241','7','18','562','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1247','7','17','565','563');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1248','7','18','565','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1249','7','17','566','98');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1250','7','18','566','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1251','7','17','567','99');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1252','7','18','567','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1253','7','17','568','29');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1254','7','18','568','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1255','7','17','569','35');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1256','7','18','569','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1257','7','17','570','36');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1258','7','18','570','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1259','7','17','571','44');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1260','7','18','571','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1261','7','17','572','65');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1262','7','18','572','9');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1263','7','17','573','71');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1264','7','18','573','9');




------------------------------- Submission -----------------------

DROP TABLE IF EXISTS
     gfbio_submission CASCADE;

CREATE TABLE gfbio_submission
(
  researchobjectid bigint NOT NULL,
  researchobjectversion smallint NOT NULL,
  archive character(75) NOT NULL,
  archive_pid text DEFAULT NULL,
  archive_pid_type bigint,
  brokersubmissionid character(75) NOT NULL,
  last_changed timestamp with time zone NOT NULL DEFAULT now(),
  userid bigint NOT NULL,
  is_public boolean NOT NULL DEFAULT false,
  public_after timestamp with time zone DEFAULT NULL,
  status text NOT NULL,
  submissionid bigint NOT NULL,
  CONSTRAINT gfbio_submission_pkey PRIMARY KEY (submissionid),
  CONSTRAINT gfbio_dataprovider_fkey FOREIGN KEY (archive)
      REFERENCES gfbio_dataprovider (label) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT gfbio_submission_uniquecolumns UNIQUE (researchobjectid, researchobjectversion, archive)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_submission
  OWNER TO liferay_gfbio;  

ALTER TABLE gfbio_researchobject
DROP COLUMN formatmetadata;

ALTER TABLE gfbio_researchobject
RENAME COLUMN metadata TO extendeddata;

ALTER TABLE gfbio_project
ADD extendeddata text;

ALTER TABLE gfbio_project_user
ADD usertype character(40);

------------------------------- Basket -----------------------
ALTER TABLE gfbio_basket 
RENAME COLUMN basketJSON TO basketContent;



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



--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------     metadata     -----------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1703','11','31','1490','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1704','11','33','1490','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1705','11','34','1490','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1706','11','31','1491','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1707','11','33','1491','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1708','11','34','1491','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1709','11','31','1492','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1710','11','33','1492','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1711','11','34','1492','');



----------------------------------------------------------------------------------------------
-------------------------------------     dataprovider      -- 22.06.2016 --------------------
----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider ADD COLUMN physicalobjects boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN taxonbased boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN notaxonbased boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN livingobjects boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN deadobjects boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN sequencedata boolean;


UPDATE gfbio_dataprovider SET name = 'Botanic Garden and Botanical Museum Berlin-Dahlem' WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET name = 'Leibniz Institute DSMZ-German Collection of Microorganisms and Cell Cultures' WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET name = 'Museum fuer Naturkunde - Leibniz Institute for Evolution and Biodiversity Science' WHERE label ='MfN';
UPDATE gfbio_dataprovider SET name = 'Senckenberg Gesellschaft fuer Naturforschung' WHERE label ='SGN';
UPDATE gfbio_dataprovider SET name = 'State Museum of Natural History Stuttgart' WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET name = 'Bavarian Natural History Collections' WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET name = 'Zoological Research Museum Alexander Koenig' WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET name = 'European Nucleotide Archive' WHERE label ='ENA';
UPDATE gfbio_dataprovider SET name = 'PANGAEA - Data Publisher for Earth & Environmental Science' WHERE label ='PANGAEA';
UPDATE gfbio_dataprovider SET name = 'GFBio Collections' WHERE label ='GFBio collections';

--Question 1
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET physicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET physicalobjects = false WHERE label ='PANGAEA';

--Question 2.1
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET taxonbased = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET taxonbased = false WHERE label ='PANGAEA';

--Question 2.2
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET notaxonbased = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET notaxonbased = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET notaxonbased = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='PANGAEA';

--Question 3.1
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET livingobjects = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='SGN';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='PANGAEA';

--Question 3.2
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET deadobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET deadobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET deadobjects = false WHERE label ='PANGAEA';

--Question 5
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='SGN';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET sequencedata = true WHERE label ='ENA';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='PANGAEA';


-----------------------------------------------------------------------------------------------
-------------------------------------- Head, Cell & Content -----------------------------------
-------------------------------------     category          -- 23.06.2016 ---------------------
-----------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1696','1','1' ,'1697','1696');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1698','1','2' ,'1697','Algae & Protists');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1699','1','3' ,'1697','Algae & Protists');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1700','1','22','1697','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1701','1','1' ,'1702','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1703','1','2' ,'1702','Bacteriology, Virology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1704','1','3' ,'1702','Bacteriology, Virology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1705','1','22','1702','');

----------------------------------------------------------------------------------------------
-------------------------------------- Head, Cell & Content ----------------------------------
-----------------------------------     category Type      -- 23.06.2016 ---------------------
----------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1711','6','15','1712','1696');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1713','6','16','1712','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1714','6','15','1715','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1716','6','16','1715','1524');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------     category dataprovider     -- 23.06.2016 ---------------
--------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1720','7','17','1721','1696');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1722','7','18','1721','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1724','7','17','1725','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1726','7','18','1725','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1728','7','17','1729','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1730','7','18','1729','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1732','7','17','1733','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1734','7','18','1733','1');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1736','7','17','1737','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1738','7','18','1737','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1739','7','17','1740','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1741','7','18','1740','2');

Delete FROM gfbio_content WHERE  rowid = 1569;
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1742','7','17','1743','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1744','7','18','1743','3');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1745','7','17','1746','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1747','7','18','1746','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1748','7','17','1749','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1750','7','18','1749','4');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1754','7','17','1755','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1756','7','18','1755','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1757','7','17','1758','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1759','7','18','1758','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1760','7','17','1761','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1762','7','18','1761','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1763','7','17','1764','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1765','7','18','1764','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1766','7','17','1767','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1768','7','18','1767','5');

Delete FROM gfbio_content WHERE  rowid = 1614;
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1769','7','17','1770','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1771','7','18','1770','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1772','7','17','1773','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1774','7','18','1773','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1775','7','17','1776','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1777','7','18','1776','6');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1778','7','17','1779','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1780','7','18','1779','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1781','7','17','1782','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1783','7','18','1782','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1784','7','17','1785','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1786','7','18','1785','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1787','7','17','1788','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1789','7','18','1788','7');

Delete FROM gfbio_content WHERE  rowid = 1635;
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1790','7','17','1791','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1792','7','18','1791','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1793','7','17','1794','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1795','7','18','1794','8');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1796','7','17','1797','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1798','7','18','1797','9');



----------------------------------------------------------------------------------------------
-------------------------------------     dataprovider      -- 29.06.2016 --------------------
----------------------------------------------------------------------------------------------

--Question 4
ALTER TABLE gfbio_dataprovider ADD COLUMN botanicalobjects boolean;
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicalobjects boolean;
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicalobjects boolean;
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN paleontologicalobjects boolean;
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicaltissueobjects boolean;
UPDATE gfbio_dataprovider SET botanicaltissueobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicaltissueobjects boolean;
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicaltissueobjects boolean;
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicaldnasamples boolean;
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicaldnasamples boolean;
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicaldnasamples boolean;
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicalobjectsinethanol boolean;
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicalobjectsinethanol boolean;
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicalobjectsinethanol boolean;
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicalmicroscopicslides boolean;
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicalmicroscopicslides boolean;
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicalmicroscopicslides boolean;
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN otherobjects boolean;
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='PANGAEA';


----------------------------------------------------------------------------------------------
-------------------------------------     user sso      --  --------------------
----------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS
     gfbio_usersso;

CREATE TABLE gfbio_usersso
(
  userId bigint NOT NULL,
  token text,
  lastmodifieddate timestamp without time zone,
  CONSTRAINT gfbio_usersso_pkey PRIMARY KEY (userId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_usersso
  OWNER TO liferay_gfbio;
  
  
----------------------------------------------------------------------------------------------
---------------------------------     researchobject user      -- 02.08.2016 -----------------
----------------------------------------------------------------------------------------------


CREATE TABLE gfbio_researchobject_user
(
  researchobjectid bigint NOT NULL,
  userid bigint NOT NULL,
  startdate timestamp with time zone,
  enddate timestamp with time zone,
  usertype character(40),
  researchobjectversion integer,
  CONSTRAINT gfbio_researchobject_user_pkey PRIMARY KEY (researchobjectid, userid),
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject_user
  OWNER TO liferay_gfbio;

  
--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 30.08.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1800','11','30' ,'1801','1800');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1802','11','31' ,'1801','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1803','11','32' ,'1801','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1804','11','33' ,'1801','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1805','11','34' ,'1801','');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 31.08.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1806','11','30' ,'1807','1806');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1808','11','31' ,'1807','ABCD 2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1809','11','32' ,'1807','ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1810','11','33' ,'1807','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1811','11','34' ,'1807','2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1812','11','30' ,'1813','1812');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1814','11','31' ,'1813','Dublin Core (Metadata Elements Set V1.1)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1815','11','32' ,'1813','Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1816','11','33' ,'1813','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1817','11','34' ,'1813','Metadata Elements Set V1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1818','11','30' ,'1819','1818');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1820','11','31' ,'1819','Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1821','11','32' ,'1819','Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1822','11','33' ,'1819','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1823','11','34' ,'1819','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1824','11','30' ,'1825','1824');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1826','11','31' ,'1825','EDM (Europeana Data Model V5.2.5)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1827','11','32' ,'1825','EDM');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1828','11','33' ,'1825','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1829','11','34' ,'1825','V5.2.5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1830','11','30' ,'1831','1830');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1832','11','31' ,'1831','EML (Ecological Metadata Language V2.1.1)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1833','11','32' ,'1831','EML');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1834','11','33' ,'1831','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1835','11','34' ,'1831','V2.1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1836','11','30' ,'1837','1836');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1838','11','31' ,'1837','ESE (Europeana Semantic Elements V3.4.1)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1839','11','32' ,'1837','ESE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1840','11','33' ,'1837','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1841','11','34' ,'1837','V3.4.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1842','11','30' ,'1843','1842');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1844','11','31' ,'1843','MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1845','11','32' ,'1843','MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1846','11','33' ,'1843','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1847','11','34' ,'1843','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1848','11','30' ,'1849','1848');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1850','11','31' ,'1849','INSPIRE (VO (EG) Nr. 1205/2008)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1851','11','32' ,'1849','INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1852','11','33' ,'1849','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1853','11','34' ,'1849','VO (EG) Nr. 1205/2008');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1854','11','30' ,'1855','1854');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1856','11','31' ,'1855','ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1857','11','32' ,'1855','ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1858','11','33' ,'1855','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1859','11','34' ,'1855','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1860','11','30' ,'1861','1860');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1862','11','31' ,'1861','pansimple DC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1863','11','32' ,'1861','pansimple DC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1864','11','33' ,'1861','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1865','11','34' ,'1861','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1866','11','30' ,'1867','1866');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1868','11','31' ,'1867','Biological Collections Ontology (BCO)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1869','11','32' ,'1867','BCO');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1870','11','33' ,'1867','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1871','11','34' ,'1867','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1872','11','30' ,'1873','1872');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1874','11','31' ,'1873','Biological Collections Ontology (BCO)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1875','11','32' ,'1873','BCO');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1876','11','33' ,'1873','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1877','11','34' ,'1873','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1878','11','30' ,'1879','1878');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1880','11','31' ,'1879','Biodiversity Ecosystem Functioning Data (BEFDATA)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1881','11','32' ,'1879','BEFDATA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1882','11','33' ,'1879','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1883','11','34' ,'1879','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1884','11','30' ,'1885','1884');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1886','11','31' ,'1885','Chemical Entities of Biological Interest (ChEBI)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1887','11','32' ,'1885','ChEBI');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1888','11','33' ,'1885','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1889','11','34' ,'1885','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1890','11','30' ,'1891','1890');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1892','11','31' ,'1891','Geographic Region Ontology (GEOREGION)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1893','11','32' ,'1891','GEOREGION');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1894','11','33' ,'1891','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1895','11','34' ,'1891','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1896','11','30' ,'1897','1896');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1898','11','31' ,'1897','Phenotypic Quality Ontology (PATO)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1899','11','32' ,'1897','PATO');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1900','11','33' ,'1897','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1901','11','34' ,'1897','');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     license      -- 31.08.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1902','8','23','1903','1902');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1904','8','24','1903','Creative Commons Zero');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1905','8','25','1903','CC0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1906','8','26','1903','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1907','8','26','1903','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1908','8','27','1903','');

--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     license      -- 07.09.2016 ---------------------
--------------------------------------------------------------------------------------------

UPDATE 	gfbio_content 	SET cellcontent = 'Other License' 											WHERE 	contentid =1466;
UPDATE 	gfbio_content 	SET cellcontent = 'other' 													WHERE 	contentid =1467;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Zero' 									WHERE 	contentid =1470;
UPDATE 	gfbio_content 	SET cellcontent = 'CC0' 													WHERE 	contentid =1471;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution' 							WHERE 	contentid =1474;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY' 													WHERE 	contentid =1475;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-ShareAlike' 				WHERE 	contentid =1478;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-SA' 												WHERE 	contentid =1479;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NoDerivs' 					WHERE 	contentid =1482;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC-SA' 											WHERE 	contentid =1483;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NonCommercial' 				WHERE 	contentid =1486;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC' 												WHERE 	contentid =1487;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NonCommercial-ShareAlike' 	WHERE 	contentid =1490;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC-SA' 											WHERE 	contentid =1491;
UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NonCommercial-NoDerivs' 	WHERE 	contentid =1904;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC-ND' 											WHERE 	contentid =1905;


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 07.09.2016 ---------------------
--------------------------------------------------------------------------------------------

UPDATE 	gfbio_content 	SET cellcontent = 'ABCD' 													WHERE 	contentid =1808;
UPDATE 	gfbio_content 	SET cellcontent = 'ABCD 2.06' 												WHERE 	contentid =1809;
UPDATE 	gfbio_content 	SET cellcontent = 'Dublin Core' 											WHERE 	contentid =1814;
UPDATE 	gfbio_content 	SET cellcontent = 'Dublin Core (Metadata Elements Set V1.1)' 				WHERE 	contentid =1815;
UPDATE 	gfbio_content 	SET cellcontent = 'EDM' 													WHERE 	contentid =1826;
UPDATE 	gfbio_content 	SET cellcontent = 'EDM (Europeana Data Model V5.2.5)' 						WHERE 	contentid =1827;
UPDATE 	gfbio_content 	SET cellcontent = 'EML' 													WHERE 	contentid =1832;
UPDATE 	gfbio_content 	SET cellcontent = 'EML (Ecological Metadata Language V2.1.1)' 				WHERE 	contentid =1833;
UPDATE 	gfbio_content 	SET cellcontent = 'ESE' 													WHERE 	contentid =1838;
UPDATE 	gfbio_content 	SET cellcontent = 'ESE (Europeana Semantic Elements V3.4.1)' 				WHERE 	contentid =1839;
UPDATE 	gfbio_content 	SET cellcontent = 'INSPIRE' 												WHERE 	contentid =1850;
UPDATE 	gfbio_content 	SET cellcontent = 'INSPIRE (VO (EG) Nr. 1205/2008)' 						WHERE 	contentid =1851;
UPDATE 	gfbio_content 	SET cellcontent = 'BCO' 													WHERE 	contentid =1868;
UPDATE 	gfbio_content 	SET cellcontent = 'Biological Collections Ontology (BCO)' 					WHERE 	contentid =1869;
UPDATE 	gfbio_content 	SET cellcontent = 'BEFDATA' 												WHERE 	contentid =1880;
UPDATE 	gfbio_content 	SET cellcontent = 'Biodiversity Ecosystem Functioning Data (BEFDATA)' 		WHERE 	contentid =1881;
UPDATE 	gfbio_content 	SET cellcontent = 'ChEBI' 													WHERE 	contentid =1886;
UPDATE 	gfbio_content 	SET cellcontent = 'Chemical Entities of Biological Interest (ChEBI)' 		WHERE 	contentid =1887;
UPDATE 	gfbio_content 	SET cellcontent = 'GEOREGION' 												WHERE 	contentid =1892;
UPDATE 	gfbio_content 	SET cellcontent = 'Geographic Region Ontology (GEOREGION)' 					WHERE 	contentid =1893;
UPDATE 	gfbio_content 	SET cellcontent = 'PATO' 													WHERE 	contentid =1898;
UPDATE 	gfbio_content 	SET cellcontent = 'Phenotypic Quality Ontology (PATO)' 						WHERE 	contentid =1899;

Delete FROM gfbio_content WHERE  rowid = 1873;


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 08.09.2016 ---------------------
--------------------------------------------------------------------------------------------

-- delete others by Metadata, because this is not part of this release
Delete FROM gfbio_content WHERE  rowid = 1801; 

-- we integrate other in this release
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1800','11','30' ,'1801','1800');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1802','11','31' ,'1801','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1803','11','32' ,'1801','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1804','11','33' ,'1801','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1805','11','34' ,'1801','');



--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 08.09.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_dataprovider (dataproviderid, name, label)VALUES(10,'GFBio Collections','GFBio collections');



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


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
-------------------------------------   dynamic headids 10.02.2017 --------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxHeadId() RETURNS TABLE (mr bigint) AS
$$
	SELECT headid
	FROM
		(SELECT MAX(headid) as "headid" FROM gfbio_head) as maxid
	ORDER BY headid DESC
	limit (1);
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


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic columnids 10.02.2017 -------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxColumnId() RETURNS TABLE (mr bigint) AS
$$
	SELECT columnid
	FROM
		(SELECT MAX(columnid) as "columnid" FROM gfbio_column) as maxid
	ORDER BY columnid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewColumnId() RETURNS bigint AS
$$
	SELECT getMaxColumnId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getColumnIdByNames(in hename text, in colname text) RETURNS TABLE (contentid bigint) AS
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


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic contentids 10.02.2017 ------------------------
---------------------------------------------------------------------------------------------


--
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
create or replace function insertHCCRelationshipWithOutsideOfHCC(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text, in ccont2 bigint)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))));
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),ccont2);
$$	
language 'sql' VOLATILE;


--
create or replace function insertHCCRelationship(in relationhename text, in relationcolname1 text, in relationcolname2 text, in colname1 text, in ccont1 text,in colname2 text, in ccont2 text)  RETURNS void AS
$$
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname1), getNewRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname1, colname1, ccont1))));
	INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),getHeadIdByName(relationhename), getColumnIdByNames(relationhename, relationcolname2), getMaxRowId(),getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames(relationcolname2, colname2, ccont2))));
$$	
language 'sql' VOLATILE;


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------      category / data provider       - 10.02.2017 -------------
-----------------------------------------------------------------------------------------------

SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  4 );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
----------------------------------       category / type        - 10.02.2017 ------------------
-----------------------------------------------------------------------------------------------

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
			headid = (SELECT getHeadIdByName('gfbio_category_type')) AND
			cellcontent = CAST((SELECT getContentIdentifierIdByRowID(getrowIdByContentId(getContentIdByNames('gfbio_type','name','material kind'))))AS text)
	);

SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Paleontological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Other objects' ,  'name', 'material kind' );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------------       dataprovider        - 10.02.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider ADD COLUMN physicalobjectpossible BOOLEAN;
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET physicalobjectpossible = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET physicalobjectpossible = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN nophysicalobject BOOLEAN;
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='ENA';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='PANGAEA';

--ALTER TABLE gfbio_dataprovider DROP COLUMN physicalobjects;

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------       category / dataprovider        - 10.02.2017 --------------
-----------------------------------------------------------------------------------------------


SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  8 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  3 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  6 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  7 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  8 );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-----------------------------------        dataprovider        - 14.02.2017 -------------------
-----------------------------------------------------------------------------------------------

UPDATE gfbio_dataprovider SET name = 'Botanic Garden and Botanical Museum Berlin-Dahlem, Freie Universität Berlin' WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET name = 'Leibniz Institute DSMZ - German Collection of Microorganisms and Cell Cultures, Braunschweig' WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET name = 'Leibniz Institute for Research on Evolution and Biodiversity, Berlin' WHERE label ='MfN';
UPDATE gfbio_dataprovider SET name = 'Senckenberg Gesellschaft für Naturforschung - Leibniz Institute, Frankfurt' WHERE label ='SGN';
UPDATE gfbio_dataprovider SET name = 'State Museum of Natural History Stuttgart' WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET name = 'Staatliche naturwissenschaftliche Sammlungen Bayerns - SNSB IT Center, München' WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET name = 'Zoological Research Museum Alexander Koenig - Leibniz Institute for Animal Biodiversity, Bonn' WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET name = 'European Nucleotide Archive' WHERE label ='ENA';
UPDATE gfbio_dataprovider SET name = 'Data Publisher for Earth & Environmental Science' WHERE label ='PANGAEA';


---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic contentids 14.02.2017 ------------------------
---------------------------------------------------------------------------------------------


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


create or replace function changeCellContentByIds(in colid bigint, in oldccont text, in ccont text)  RETURNS void AS
$$
	UPDATE gfbio_content SET cellcontent = ccont WHERE columnid = colid AND cellcontent = oldccont;
$$	
language 'sql' VOLATILE;


create or replace function changeCellContentByNames(in hename text, in colname text, in oldccont text, in ccont text)  RETURNS void AS
$$
	SELECT changeCellContentByIds(getcolumnidbynames(hename , colname), oldccont, ccont);
$$	
language 'sql' VOLATILE;




-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------       category / dataprovider        - 14.02.2017 --------------
-----------------------------------------------------------------------------------------------


SELECT deleteHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider', 'gfbio_category','name','Botanical tissue objects', '1');
SELECT deleteHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider', 'gfbio_category','name','Botanical tissue objects', '5');
SELECT deleteHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider', 'gfbio_category','name','Botanical tissue objects', '6');
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  1 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  5 );
SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  6 );


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-------------------------------------        category        - 14.02.2017 ---------------------
-----------------------------------------------------------------------------------------------

SELECT changeCellContentByNames('gfbio_category', 'name',  'Other discipline', 'Other');
SELECT changeCellContentByNames('gfbio_category', 'label', 'Other discipline', 'Other');
SELECT changeCellContentByNames('gfbio_category', 'name',  'Other objects', 'Other');
SELECT changeCellContentByNames('gfbio_category', 'label', 'Other objects', 'Other');


-----------------------------------------------------------------------------------------------
-----------------------------------        dataprovider        - 15.02.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider DROP COLUMN physicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicaltissueobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicaldnasamples;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicalmicroscopicslides;
ALTER TABLE gfbio_dataprovider DROP COLUMN botanicalobjectsinethanol;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicaltissueobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicaldnasamples;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicalmicroscopicslides;
ALTER TABLE gfbio_dataprovider DROP COLUMN mycologicalobjectsinethanol;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicaltissueobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicaldnasamples;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicalobjectsinethanol;
ALTER TABLE gfbio_dataprovider DROP COLUMN zoologicalmicroscopicslides;
ALTER TABLE gfbio_dataprovider DROP COLUMN paleontologicalobjects;
ALTER TABLE gfbio_dataprovider DROP COLUMN otherobjects;

-----------------------------------------------------------------------------------------------
-----------------------------------        dataprovider        - 06.03.2017 -------------------
-----------------------------------------------------------------------------------------------

UPDATE gfbio_dataprovider SET name = 'Botanic Garden and Botanical Museum Berlin, Freie Universität Berlin' WHERE label ='BGBM';


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------------       category / dataprovider        - 06.03.2017 --------------
-----------------------------------------------------------------------------------------------


SELECT insertHCCRelationshipWithOutsideOfHCC('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Algae & Protists' ,  4 );

-----------------------------------------------------------------------------------------------
-----------------------------------        submission        - 07.03.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_submission ADD COLUMN jiraid character (75);

-----------------------------------------------------------------------------------------------
-----------------------------------        submission        - 08.03.2017 -------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_submission ADD COLUMN jirakey character (75);


-----------------------------------------------------------------------------------------------
-----------------------------------        basket         - 13.03.2017 -------------------
-----------------------------------------------------------------------------------------------
---- Basket has been updated on v6.5, no need to rerun again (see update_gfbio_basket.sql)
--ALTER TABLE gfbio_basket ADD COLUMN queryKeyword text;
--ALTER TABLE gfbio_basket ADD COLUMN queryFilter text;




---- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ----
----							scripts above this line are on pub2 				16.03.2017
---- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ----



-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------------       license        -- 16.03.2017 ---------------------
-----------------------------------------------------------------------------------------------

------------------------------------- Column Table Content -------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),getHeadIdByName('gfbio_license'),'version');


------------------------------------- Content Table Content -------------------------------------

DO
$do$
	DECLARE
		r bigint;
	BEGIN
		FOR r IN 
			SELECT 
			  distinct(rowid )
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_license'))
		LOOP
			INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'),r, '');
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;



---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic contentids 04.04.2017 ------------------------
---------------------------------------------------------------------------------------------


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



-- -----------------------------------------------------------------------------------------------
-- ------------------------------------ Head, Column & Content -----------------------------------
-- --------------------------------------       license        -- 04.04.2017 ---------------------
-- -----------------------------------------------------------------------------------------------


ALTER TABLE gfbio_researchobject ADD COLUMN licenselabel text;


DO
$do$
	DECLARE
		lid bigint;
	BEGIN
		FOR lid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_license')) AND
			  columnid = (select getColumnIdByNames('gfbio_license','id'))
		LOOP
			UPDATE gfbio_researchobject SET licenselabel = (Select (getContentByColumnName('gfbio_license', 'label', lid ))) WHERE licenseid =lid;
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


UPDATE gfbio_researchobject SET licenselabel = 'CC-BY' 			WHERE licenselabel ='CC BY';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-SA' 		WHERE licenselabel ='CC BY-SA';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-NC-SA' 	WHERE licenselabel ='CC BY-NC-SA';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-NC' 		WHERE licenselabel ='CC BY-NC';
UPDATE gfbio_researchobject SET licenselabel = 'CC-BY-NC-ND' 	WHERE licenselabel ='CC BY-NC-ND';

SELECT deleteHCCRow('gfbio_license', 'label', 'other');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC0');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-SA');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-NC-SA');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-NC');
SELECT deleteHCCRow('gfbio_license', 'label', 'CC BY-NC-ND');


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Other License');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Zero');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '{"url":"https://creativecommons.org/publicdomain/zero/1.0/deed.de"}');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '1.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '{"url":"https://creativecommons.org/licenses/by/3.0/de"}');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NonComercial');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-NC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NonComercial-NoDerivs');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-NC-ND');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NonComercial-ShareAlike');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-NC-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '{"url":"https://creativecommons.org/licenses/by-sa/3.0/de"}');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-NoDerivs');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-ND');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), getMaxRowId(), 'Creative Commons Attribution-ShareAlike');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), getMaxRowId(), 'CC-BY-SA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), getMaxRowId(), '3.0');





DO
$do$
	DECLARE
		lid bigint;
	BEGIN
		FOR lid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_license')) AND
			  columnid = (select getColumnIdByNames('gfbio_license','id'))
		LOOP
			UPDATE gfbio_researchobject SET licenseid = lid WHERE licenselabel = (Select (getContentByColumnName('gfbio_license', 'label', lid )));
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


UPDATE gfbio_researchobject SET licenseid = null 	WHERE licenseid =0;

ALTER TABLE	gfbio_researchobject DROP licenselabel;
	

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
-------------------------------------       metadata        -- 04.04.2017 ---------------------
-----------------------------------------------------------------------------------------------


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'schema');


------------------------------------- Content Table Content -------------------------------------



ALTER TABLE gfbio_researchobject ADD COLUMN metadatalabel text;


DO
$do$
	DECLARE
		mid bigint;
	BEGIN
		FOR mid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_metadata')) AND
			  columnid = (select getColumnIdByNames('gfbio_metadata','id'))
		LOOP
			UPDATE gfbio_researchobject SET metadatalabel = (Select (getContentByColumnName('gfbio_metadata', 'label', mid ))) WHERE metadataid =mid;
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;

UPDATE gfbio_researchobject SET metadatalabel = 'ABCD' WHERE metadatalabel ='ABCD 2.06';
UPDATE gfbio_researchobject SET metadatalabel = 'Dublin Core' WHERE metadatalabel ='Dublin Core (Metadata Elements Set V1.1)';
UPDATE gfbio_researchobject SET metadatalabel = 'EDM' WHERE metadatalabel ='EDM (Europeana Data Model V5.2.5)';
UPDATE gfbio_researchobject SET metadatalabel = 'EML' WHERE metadatalabel ='EML (Ecological Metadata Language V2.1.1)';
UPDATE gfbio_researchobject SET metadatalabel = 'ESE' WHERE metadatalabel ='ESE (Europeana Semantic Elements V3.4.1';
UPDATE gfbio_researchobject SET metadatalabel = 'INSPIRE' WHERE metadatalabel ='INSPIRE (VO (EG) Nr. 1205/2008)';

SELECT deleteHCCAllTableContent('gfbio_metadata');
UPDATE gfbio_researchobject SET metadataid = 0;




INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Other metadata schema or version');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Europeana Data Model');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'EDM');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '5.2.5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Ecological Metadata Language');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'EML');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '2.1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Europeana Semantic Elements');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ESE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '3.4.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), 'VO (EG) Nr. 1205/2008');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Minimum Information about any (x) Sequence');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), 'The MIxS standard (Minimum Information about any (x) Sequence) is an overarching framework providing a single entry point to all minimum information checklists from the Genomic Standards Consortium (GSC) and to the environmental packages. MIxS includes the technology-specific checklists from the previous MIGS (Minimum Information about a Genome Sequence) and MIMS (Minimum Information about a Metagenome Sequence) standards. It provides a way to introduce additional checklists such as MIMARKS (Minimum Information about a Marker Gene Sequence), and allows annotation of sample data using environmental packages. MIxS was published in Nature Biotechnology in 2011.');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '4.0.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');



DO
$do$
	DECLARE
		mid bigint;
	BEGIN
		FOR mid IN 
			SELECT 
			  cellcontent
			FROM 
			  public.gfbio_content
			WHERE
			  headid = (select getHeadIdByName('gfbio_metadata')) AND
			  columnid = (select getColumnIdByNames('gfbio_metadata','id'))
		LOOP
			UPDATE gfbio_researchobject SET metadataid = mid WHERE metadatalabel = (Select (getContentByColumnName('gfbio_metadata', 'label', mid )));
		END LOOP;
		RETURN;
	END
$do$
LANGUAGE plpgsql;


UPDATE gfbio_researchobject SET metadataid = null WHERE metadataid =0;
ALTER TABLE	gfbio_researchobject DROP metadatalabel;

-----------------------------------------------------------------------------------------------
----------------------------------        researchobject        - 04.04.2017 ------------------
-----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_researchobject ADD COLUMN lastmodifieddate timestamp with time zone NOT NULL DEFAULT now();

-- -----------------------------------------------------------------------------------------------
-- ------------------------------------ Head, Column & Content -----------------------------------
-- --------------------------------------       license        -- 10.04.2017 ---------------------
-- -----------------------------------------------------------------------------------------------




UPDATE gfbio_content SET cellcontent = 'CC BY' 			WHERE cellcontent ='CC-BY' and headid = (select getHeadIdByName('gfbio_license'));
UPDATE gfbio_content SET cellcontent = 'CC BY-SA' 		WHERE cellcontent ='CC-BY-SA' and headid = (select getHeadIdByName('gfbio_license'));
UPDATE gfbio_content SET cellcontent = 'CC BY-NC-SA' 	WHERE cellcontent ='CC-BY-NC-SA' and headid = (select getHeadIdByName('gfbio_license'));
UPDATE gfbio_content SET cellcontent = 'CC BY-NC' 		WHERE cellcontent ='CC-BY-NC' and headid = (select getHeadIdByName('gfbio_license'));
UPDATE gfbio_content SET cellcontent = 'CC BY-NC-ND' 	WHERE cellcontent ='CC-BY-NC-ND' and headid = (select getHeadIdByName('gfbio_license'));
UPDATE gfbio_content SET cellcontent = 'CC BY-ND' 		WHERE cellcontent ='CC-BY-ND' and headid = (select getHeadIdByName('gfbio_license'));




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
	cellcontent = 'Other';
			
			
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

ALTER TABLE gfbio_head ADD description text;


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


-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------       legal requirements        -- 28.06.2017 ----------------
-----------------------------------------------------------------------------------------------

DELETE FROM gfbio_content WHERE headid = (select getHeadIdByName('gfbio_legalrequirement'));
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
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Uncertain', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());


------------------------------------------------------------------------------------------------
----------------------------------       research object        -- 04.08.2017 ------------------
------------------------------------------------------------------------------------------------

ALTER TABLE gfbio_researchobject ALTER COLUMN extendeddata  TYPE text;

------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 04.08.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'url', now());


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'other')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY')), 'https://creativecommons.org/licenses/by/3.0/de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-SA')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-SA')), 'https://creativecommons.org/licenses/by-sa/3.0/de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-ND')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-ND')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0')), 'https://creativecommons.org/publicdomain/zero/1.0/deed.de', now());

SELECT changeCellContentByNames('gfbio_license', 'extendeddata', '{"url":"https://creativecommons.org/publicdomain/zero/1.0/deed.de"}', '');
SELECT changeCellContentByNames('gfbio_license', 'extendeddata', '{"url":"https://creativecommons.org/licenses/by/3.0/de"}', '');
SELECT changeCellContentByNames('gfbio_license', 'extendeddata', '{"url":"https://creativecommons.org/licenses/by-sa/3.0/de"}', '');


------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 06.10.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'preferredbygfbio', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'other')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-SA')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-SA')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-ND')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-ND')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0')), 'true', now());

------------------------------------------------------------------------------------------------
-------------------------------------       metadata        -- 06.10.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'preferredbygfbio', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'other')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'Darwin Core')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'Dublin Core')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'EDM')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'EML')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ESE')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'INSPIRE')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ISO 19115')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'MIxS')), 'true', now());



----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
-------------------------------------       iteration 10 changes start here        -- 16.10.2017 ---------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------
-------------------------------------              datamanagementplan              -- 06.10.2017 ---------------------
----------------------------------------------------------------------------------------------------------------------

CREATE TABLE gfbio_datamanagementplan
(
  dmpid bigint NOT NULL,
  name character(150) NOT NULL,
  userid bigint NOT NULL,
  dmptinput text,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_datamanagementplan_pkey PRIMARY KEY (dmpid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_datamanagementplan
  OWNER TO liferay_gfbio;

  
------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 20.10.2017 ----------------------
------------------------------------------------------------------------------------------------ 
  
SELECT changeCellContentByNames('gfbio_license', 'url', 'https://creativecommons.org/licenses/by-sa/3.0/de', '');

UPDATE gfbio_content 
SET 
	cellcontent = 'https://creativecommons.org/licenses/by-sa/3.0/de', lastmodifieddate = now()  
WHERE 
  headid =  (select getHeadIdByName('gfbio_license')) and
  columnid = (select getColumnIdByNames('gfbio_license','url')) and
  rowid in (
    SELECT 
      rowid 
    FROM 
      public.gfbio_content
    WHERE
      headid =  (select getHeadIdByName('gfbio_license')) and
      cellcontent = 'CC BY-SA'
  );

  
    
  ------------------------------------------------------------------------------------------------
-----------------------------------       researchobject        -- 02.11.2017 --------------------
-------------------------------------------------------------------------------------------------- 

ALTER TABLE gfbio_researchobject ADD publications text;
ALTER TABLE gfbio_researchobject ADD datacollectiontime text;
ALTER TABLE gfbio_researchobject ADD embargo timestamp with time zone;



  ------------------------------------------------------------------------------------------------
-----------------------------------       license        -- 02.01.2018 --------------------
-------------------------------------------------------------------------------------------------- 

UPDATE gfbio_content SET  cellcontent='Creative Commons Attribution-NonCommercial'				WHERE cellcontent = 'Creative Commons Attribution-NonComercial';
UPDATE gfbio_content SET  cellcontent='Creative Commons Attribution-NonCommercial-NoDerivs'		WHERE cellcontent = 'Creative Commons Attribution-NonComercial-NoDerivs';
UPDATE gfbio_content SET  cellcontent='Creative Commons Attribution-NonCommercial-ShareAlike'	WHERE cellcontent = 'Creative Commons Attribution-NonComercial-ShareAlike';

