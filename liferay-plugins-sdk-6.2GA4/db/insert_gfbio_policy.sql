
-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------------       policy        ------------------------------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type, description, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_policy','entity', 'In this table we store information about the pilicies, that we use in GFBio.', now());

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'id', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'name', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'label', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'description', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'url', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy')),'lastmodifieddate', now());
