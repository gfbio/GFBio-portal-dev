------------------------------------------------------------------------------------------------
----------------------------------       research object        -- 04.08.2017 ------------------
------------------------------------------------------------------------------------------------

ALTER TABLE gfbio_researchobject ALTER COLUMN extendeddata  TYPE text;

------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 04.08.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'url', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY')), 'https://creativecommons.org/licenses/by/3.0/de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-SA')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-SA')), 'https://creativecommons.org/licenses/by-sa/3.0/de', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-ND')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-ND')), '', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0')), 'https://creativecommons.org/publicdomain/zero/1.0/deed.de', now());

SELECT changeCellContentByNames('gfbio_license', 'extendeddata', '{"url":"https://creativecommons.org/publicdomain/zero/1.0/deed.de"}', '');
SELECT changeCellContentByNames('gfbio_license', 'extendeddata', '{"url":"https://creativecommons.org/licenses/by/3.0/de"}', '');
SELECT changeCellContentByNames('gfbio_license', 'extendeddata', '{"url":"https://creativecommons.org/licenses/by-sa/3.0/de"}', '');