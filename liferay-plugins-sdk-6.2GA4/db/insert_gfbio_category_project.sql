

--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
---------------------------------     category / project      ------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_category_project','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_project')),'gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_project')),'gfbio_project');



------------------------------------- Content Table Content -------------------------------------

