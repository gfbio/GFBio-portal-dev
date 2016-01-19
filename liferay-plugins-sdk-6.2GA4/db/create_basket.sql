------------------------------------- Basket ------------------------------------- 

DROP TABLE IF EXISTS
     gfbio_basket;

CREATE TABLE gfbio_basket
(
  basketId bigint NOT NULL,
  userId bigint NOT NULL,
  name character varying(75),
  lastmodifieddate timestamp without time zone,
  basketJSON text,
  queryJSON text,
  CONSTRAINT gfbio_basket_pkey PRIMARY KEY (basketId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_basket
  OWNER TO liferay_gfbio;