


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------------     Category     ------------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_category','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category')),'id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category')),'name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category')),'label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category')),'description');


------------------------------------- Content Table Content -------------------------------------


------------------------------------- Content Table Content -------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Botany');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Botany');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Ecology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Ecology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Geoscience');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Geoscience');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Microbiology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Microbiology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Mycology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Mycology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Palaeontology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Palaeontology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Zoology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Zoology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Algae & Protists');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Algae & Protists');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Bacteriology, Virology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Bacteriology, Virology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Botanical objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Botanical objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Botanical tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Botanical tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Botanical DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Botanical DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Botanical objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Botanical objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Botanical microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Botanical microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Mycological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Mycological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Mycological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Mycological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Mycological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Mycological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Mycological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Mycological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Mycological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Mycological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Zoological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Zoological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Zoological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Zoological tissue objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Zoological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Zoological DNA samples');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Zoological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Zoological objects in ethanol');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Zoological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Zoological microscopic slides');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Paleontological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Paleontological objects');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_category')), getColumnIdByNames('gfbio_category','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
