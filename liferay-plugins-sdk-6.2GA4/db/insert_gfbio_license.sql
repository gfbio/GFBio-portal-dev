
-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------     license      -----------------------------------
-------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type, description, lastmodifieddate)VALUES(getNewHeadId(),'gfbio_license','entity','In this table we store information about the licenses, that we use in GFBio.', 	now());


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'id', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'name', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'label', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'description', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'extendeddata', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'version', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'url', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'preferredbygfbio', 	now());
INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'lastmodifieddate', 	now());



------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), 	now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Other License', 	now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'other', 			now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', 					now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', 					now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), 	now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Zero', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '1.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), 'https://creativecommons.org/publicdomain/zero/1.0/deed.de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Attribution', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC BY', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '3.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), 'https://creativecommons.org/licenses/by/3.0/de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Attribution-NonCommercial', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC BY-NC', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '3.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Attribution-NonCommercial-NoDerivs', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC BY-NC-ND', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '3.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Attribution-NonCommercial-ShareAlike', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC BY-NC-SA', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '3.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Attribution-NoDerivs', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC BY-ND', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '3.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','id'),				getNewRowId(), getNewContentId(), now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','name'), 			getMaxRowId(), 'Creative Commons Attribution-ShareAlike', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','label'), 			getMaxRowId(), 'CC BY-SA', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','description'), 	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','extendeddata'),	getMaxRowId(), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','version'), 		getMaxRowId(), '3.0', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), 			getMaxRowId(), 'https://creativecommons.org/licenses/by-sa/3.0/de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'),getMaxRowId(), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','lastmodifieddate'),getMaxRowId(), now(), now());
