
--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------     funding agency / funding program      -----------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------

INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_fundingagency_fundingprogram','relationship');

------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency_fundingprogram')),'gfbio_fundingagency');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency_fundingprogram')),'gfbio_fundingprogram');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency_fundingprogram')),'lastmodifieddate');


------------------------------------- Content Table Content -------------------------------------