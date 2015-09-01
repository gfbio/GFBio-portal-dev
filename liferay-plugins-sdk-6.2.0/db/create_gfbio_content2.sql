


-------------------------------------------------------------------------------------------
---------------------------------- Head, Cell & Position ----------------------------------
--------------------------------------     Content     ------------------------------------
-------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------

---- tables  ----
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('1','gfbio_category','entity');
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('2','gfbio_researchfield','entity');


--- relations ----
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('3','gfbio_category_researchfield','relationship');



------------------------------------- Column Table Content -------------------------------------


 
---- tables  ----
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('100','1','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('101','1','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('102','2','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('103','2','description');


--- relations ----
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('104','3','gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('105','3','gfbio_researchfield');



------------------------------------- Position Table Content -------------------------------------


--- entities


--- gfbio_category
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1000','1','100','10','Fishes');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1001','1','101','10','Pisces');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1002','1','100','11','Sea urchin');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1003','1','101','11','Echinoidea');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1004','1','100','12','E.coli');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1005','1','101','12','Escherichia coli');


--- gfbio_researchfield
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1006','2','102','13','Oceanography');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1007','2','103','13','Branch of Earth science that studies the ocean.');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1008','2','102','14','Microbiology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1009','2','103','14','It is the study of microscopic organisms.');


--- relations


--- gfbio_category_researchfield
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1010','3','104','15','10');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1011','3','105','15','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1012','3','104','16','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1013','3','105','16','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1014','3','104','17','12');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1015','3','105','17','14');

