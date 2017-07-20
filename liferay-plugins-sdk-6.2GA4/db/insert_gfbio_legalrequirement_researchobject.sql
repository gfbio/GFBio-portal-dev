

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
------------------------       legal requirements / research object       ----------------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------
INSERT INTO gfbio_head (headid, table_name, table_type, description, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_legalrequirement_researchobject','relationship','',now());

------------------------------------- Column Table Content -------------------------------------
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_researchobject')),'gfbio_legalrequirement');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_researchobject')),'gfbio_researchobject');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement_researchobject')),'lastmodifieddate');


