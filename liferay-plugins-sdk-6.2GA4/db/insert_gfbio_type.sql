


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


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('298','5','12','100','298');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('299','5','13','100','accesscontrol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('300','5','14','100','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1524','5','12','1525','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1526','5','13','1525','research field');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1527','5','14','1525','research field');
