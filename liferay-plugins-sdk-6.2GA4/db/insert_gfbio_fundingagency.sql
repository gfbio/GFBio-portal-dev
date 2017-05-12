
--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
-----------------------------------     funding agency      --------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_fundingagency','entity');


------------------------------------- Column Table Content -------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'mail');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'adress');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'website');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_fundingagency')),'lastmodifieddate');

------------------------------------- Content Table Content -------------------------------------