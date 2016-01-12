


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
