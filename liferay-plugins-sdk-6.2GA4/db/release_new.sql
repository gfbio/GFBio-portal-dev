------------------------------------------------------------------------------------------------
----------------------------------       research object        -- 04.08.2017 ------------------
------------------------------------------------------------------------------------------------

ALTER TABLE gfbio_researchobject ALTER COLUMN extendeddata  TYPE text;

------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 04.08.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'url', now());


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','url'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'other')), '', now());
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


------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 06.10.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_license')),'preferredbygfbio', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'other')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-SA')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-SA')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-NC-ND')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC BY-ND')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_license')), getColumnIdByNames('gfbio_license','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_license', 'label', 'CC0')), 'true', now());

------------------------------------------------------------------------------------------------
-------------------------------------       metadata        -- 06.10.2017 ----------------------
------------------------------------------------------------------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'preferredbygfbio', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'other')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'Darwin Core')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'Dublin Core')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'EDM')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'EML')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ESE')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'INSPIRE')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ISO 19115')), 'true', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','preferredbygfbio'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'MIxS')), 'true', now());


----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
-------------------------------------       iteration 10 changes start here        -- 16.10.2017 ---------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------------------------
-------------------------------------              datamanagementplan              -- 06.10.2017 ---------------------
----------------------------------------------------------------------------------------------------------------------

CREATE TABLE gfbio_datamanagementplan
(
  dmpid bigint NOT NULL,
  name character(150) NOT NULL,
  userid bigint NOT NULL,
  dmptinput text,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_datamanagementplan_pkey PRIMARY KEY (dmpid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_datamanagementplan
  OWNER TO liferay_gfbio;
