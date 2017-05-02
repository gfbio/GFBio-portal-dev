


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Persistent Identifier     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_persistentidentifier','entity');

------------------------------------- Column Table Content -------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'website');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'has fee on id registration');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_persistentidentifier')),'change on id possible');

------------------------------------- Content Table Content -------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','name'), getMaxRowId(), 'Accession Number');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','label'), getMaxRowId(), 'ACCESSION');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','website'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','has fee on id registration'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','change on id possible'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','name'), getMaxRowId(), 'Digital Object Identifier');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','label'), getMaxRowId(), 'DOI');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','website'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','has fee on id registration'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_persistentidentifier')), getColumnIdByNames('gfbio_persistentidentifier','change on id possible'), getMaxRowId(), '');