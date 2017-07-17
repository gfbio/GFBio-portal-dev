

-----------------------------------------------------------------------------------------------
------------------------------------ Head, Column & Content -----------------------------------
--------------------------------       legal requirements        -- 22.06.2017 ----------------
-----------------------------------------------------------------------------------------------

------------------------------------- Head Table Content -------------------------------------

INSERT INTO gfbio_head (headid, table_name, table_type, description, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_legalrequirement','entity', 'In this table we store information about the legal requirements, that we use in GFBio.', now());


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'id', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'name', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'label', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'description', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'extendeddata', now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'lastmodifieddate', now());

------------------------------------- Content Table Content -------------------------------------
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Nagoya Protocol', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Red List', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Personally Identifiable Information', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','name'), 				getMaxRowId(), 'Uncertain', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','label'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','description'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','extendeddata'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','lastmodifieddate'), 	getMaxRowId(), now(), now());