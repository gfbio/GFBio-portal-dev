
-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
----------------------------------       policy / project       -------------------------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type, description, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_policy_project','relationship', '', now());

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy_project')),'gfbio_policy');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy_project')),'gfbio_project');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_policy_project')),'lastmodifieddate');
