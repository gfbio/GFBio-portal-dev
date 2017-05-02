
--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -----------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_metadata','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'description');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'version');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'schema');

------------------------------------- Content Table Content -------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Other metadata schema or version');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Europeana Data Model');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'EDM');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '5.2.5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Ecological Metadata Language');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'EML');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '2.1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Europeana Semantic Elements');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ESE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '3.4.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), 'VO (EG) Nr. 1205/2008');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','id'),getNewRowId(), getNewContentId());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','name'), getMaxRowId(), 'Minimum Information about any (x) Sequence');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','label'), getMaxRowId(), 'MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','description'), getMaxRowId(), 'The MIxS standard (Minimum Information about any (x) Sequence) is an overarching framework providing a single entry point to all minimum information checklists from the Genomic Standards Consortium (GSC) and to the environmental packages. MIxS includes the technology-specific checklists from the previous MIGS (Minimum Information about a Genome Sequence) and MIMS (Minimum Information about a Metagenome Sequence) standards. It provides a way to introduce additional checklists such as MIMARKS (Minimum Information about a Marker Gene Sequence), and allows annotation of sample data using environmental packages. MIxS was published in Nature Biotechnology in 2011.');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','version'), getMaxRowId(), '4.0.0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','schema'), getMaxRowId(), '');


