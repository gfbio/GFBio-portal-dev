------------------------------------- Search History ------------------------------------- 

--DROP TABLE IF EXISTS
--     gfbio_searchhistory;

CREATE TABLE gfbio_searchhistory
(
  searchHistoryID bigint NOT NULL,
  userId bigint NOT NULL,
  queryString text,
  queryFilter text,
  lastmodifieddate timestamp without time zone,
  CONSTRAINT gfbio_searchhistory_pkey PRIMARY KEY (searchHistoryID)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_searchhistory
  OWNER TO liferay_gfbio;
  
------------------------------------- Search Feedback ------------------------------------- 

DROP TABLE IF EXISTS
     gfbio_searchfeedback;

CREATE TABLE gfbio_searchfeedback
(
  searchFeedbackID bigint NOT NULL,
  userId bigint NOT NULL,
  queryString text,
  queryFilter text,
  datasetDetail text,
  datasetRank int,
  rating smallint,
  lastmodifieddate timestamp without time zone,
  CONSTRAINT gfbio_searchfeedback_pkey PRIMARY KEY (searchFeedbackID)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_searchfeedback
  OWNER TO liferay_gfbio;