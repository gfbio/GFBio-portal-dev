


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Persistent Identifier     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('3','gfbio_persistentidentifier','entity');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('7','3','id');								--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('8','3','name');								--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('9','3','label');							--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('19','3','website');							--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('20','3','has fee on id registration');		--gfbio_persistentidentifier
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('21','3','change on id possible');			--gfbio_persistentidentifier

------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1265	','	3	','	7	','	574	','	1265');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1266	','	3	','	8	','	574	','	Accession Number');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1267	','	3	','	9	','	574	','	ACCESSION');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1268	','	3	','	7	','	575	','	1030');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1269	','	3	','	8	','	575	','	Digital Object Identifier');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1270	','	3	','	9	','	575	','	DOI');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1271	','	3	','	19	','	574	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1272	','	3	','	20	','	574	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1273	','	3	','	21	','	574	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1274	','	3	','	19	','	575	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1275	','	3	','	20	','	575	','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('	1276	','	3	','	21	','	575	','');
