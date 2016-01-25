

-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
----------------------------------     Categoryparent     ---------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('8','gfbio_categoryparent','parentrelationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('23','8','gfbio_category');	--gfbio_category
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('24','8','parent');			--parent category