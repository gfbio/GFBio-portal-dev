


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------       Type       -----------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_type','entity');

------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_type')),'id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_type')),'name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_type')),'description');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_type')),'lastmodifieddate');


------------------------------------- Content Table Content -------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','id'),getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','name'), getMaxRowId(), 'accesscontrol', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','description'), getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','lastmodifieddate'), getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','id'),getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','name'), getMaxRowId(), 'research field', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','description'), getMaxRowId(), 'research field', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','lastmodifieddate'), getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','id'),getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','name'), getMaxRowId(), 'material kind', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','description'), getMaxRowId(), 'material kind', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_type')), getColumnIdByNames('gfbio_type','lastmodifieddate'), getMaxRowId(), now(), now());


