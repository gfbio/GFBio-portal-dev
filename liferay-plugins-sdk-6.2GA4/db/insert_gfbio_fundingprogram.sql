
---------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content -----------------------------------
-----------------------------------     funding program      --------------------------------
---------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_fundingprogram','entity');

------------------------------------- Column Table Content -------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingprogram')),'id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingprogram')),'name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingprogram')),'label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingprogram')),'fundingid');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingprogram')),'lastmodifieddate');



------------------------------------- Content Table Content -------------------------------------