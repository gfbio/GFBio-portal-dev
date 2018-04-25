
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
-------------------------------------       iteration 11 changes start here        -- 06.03.2018 ---------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------
-------------------------------------       metadata        -- 06.03.2018 ----------------------
------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION updatecellcontentbyrowidentifier(hename text, rowidentifiercolumnname text, targetcolumnname text, rowidentifierrowidentifier text, newccont text)
  RETURNS void AS
$BODY$
	UPDATE gfbio_content SET  cellcontent=newccont, lastmodifieddate = now()		WHERE	headid =(select getHeadIdByName(hename)) AND	  columnid = (select getcolumnidbynames(hename, targetcolumnname))   and	rowid in (select rowid from gfbio_content	where	  headid = (select getHeadIdByName(hename)) and		  columnid = (select getcolumnidbynames(hename, rowidentifiercolumnname)) and 		  cellcontent  = rowidentifierrowidentifier	  ); 
	UPDATE gfbio_content SET  cellcontent=now()	  , lastmodifieddate = now()		WHERE	headid =(select getHeadIdByName(hename)) AND	  columnid = (select getcolumnidbynames(hename, 'lastmodifieddate')) and	rowid in (select rowid from gfbio_content	where	  headid = (select getHeadIdByName(hename)) and		  columnid = (select getcolumnidbynames(hename, rowidentifiercolumnname)) and 		  cellcontent  = rowidentifierrowidentifier	  );

$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
ALTER FUNCTION updatecellcontentbyrowidentifier(text, text, text, text, text)
  OWNER TO postgres;
  
select updatecellcontentbyrowidentifier('gfbio_metadata', 'name', 'label', 'Darwin Core',		'DwC');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'name', 'label', 'Dublin Core',		'DC');


select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'name', 'ABCD',		'Access to Biological Collections Data');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'name', 'INSPIRE',	'Infrastructure for Spatial Information in the European Community');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'name', 'ISO 19115',	'ISO 19115 Geographic information (Metadata)');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'ABCD',		'The Access to Biological Collections Data schema (ABCD) is the core standard of any BioCASe related network. Its primary use case is the publication of rich natural history collections specimen data, but it can also be used for general species occurrence datasets. It is XML-based (eXtensible Mark-up Language), meaning it stores the information in a structure that can be easily processed by software. The current major version 2.06 has  been widely adopted by networks and  is an accepted standard of Biodiversity Information Standards (also known as Taxonomic Databases Working Group ).');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'DwC',		'The Darwin Core (DwC) is body of standards. It includes a glossary of terms intended to facilitate the sharing of information about biological diversity by providing reference definitions, examples, and commentaries. The Darwin Core is primarily based on taxa, their occurrence in nature as documented by observations, specimens, and samples, and related information. DwC is an accepted standard of Biodiversity Information Standards (also known as Taxonomic Databases Working Group ).');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'DC',			'Dublin Core (DC) is a metadata standard that was originally developed for libraries but its elements have been reused in many other formats as well, e.g. DWC. Dublin Core Metadata Element Set contains 15 elements and is an accepted ISO standard (ISO 15836:2009).');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'EDM',		'The Europeana Data Model (EDM) aims at being an integration medium for collecting, connecting and enriching the descriptions provided by Europeana content providers. ');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'EML',		'The Ecological Metadata Language (EML) is as a set of XML Schema documents that allow for the structural expression of metadata necessary to document a typical data set in ecological sciences. ');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'ESE',		'Europeana Semantic Elements (ESE) is a format, which provides a basic set of elements for describing objects in the cultural heritage domain in a way that is usable for Europeana.');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'INSPIRE',	'Aim of the INSPIRE Directive is to create a European Union spatial data infrastructure that will help to make spatial or geographical information more accessible and interoperable for a wide range of purposes of EU environmental policies and policies or activities which may have an impact on the environment. On 15 May 2007 the INPIRE Directive came into force and will be implemented in various stages, with full implementation required by 2021.');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'description', 'ISO 19115',	'ISO 19115-1:2014 Geographic information (Metadata) is a standard of the ISO (the International Organization for Standardization) and defines the schema required for describing geographic information and services by means of metadata. It provides information about the identification, the extent, the quality, the spatial and temporal aspects, the content, the spatial reference, the portrayal, distribution, and other properties of digital geographic data and services.');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'DwC',		'2013-10-25');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'EDM',		'5.2.3');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'EML',		'2.1.1');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'ESE',		'3.4.1');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'INSPIRE',	'Directive 2007/2/EC');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'ISO 19115',	'2014');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'url', 'ABCD', 		'http://www.biocase.org/products/schema_repository/index.shtml');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'url', 'EDM', 		'https://pro.europeana.eu/page/edm-documentation');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'url', 'ESE', 		'https://pro.europeana.eu/page/ese-documentation');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'url', 'INSPIRE', 	'http://inspire.ec.europa.eu/about-inspire/563 ');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'url', 'ISO 19115', 	'https://www.iso.org/standard/53798.html');



------------------------------------------------------------------------------------------------
-------------------------------------       metadata        -- 28.03.2018 ----------------------
------------------------------------------------------------------------------------------------


select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'label', 'ISO 19115', 	'ISO 19115-1');
select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'version', 'MIxS',		'4.0');



------------------------------------------------------------------------------------------------
-------------------------------------       metadata        -- 19.04.2018 ----------------------
------------------------------------------------------------------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_metadata')),'url', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','url'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ABCD')), 'http://www.biocase.org/products/schema_repository/index.shtml', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','url'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'EDM')), 'https://pro.europeana.eu/page/edm-documentation', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','url'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ESE')), 'https://pro.europeana.eu/page/ese-documentation', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','url'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'INSPIRE')), 'http://inspire.ec.europa.eu/about-inspire/563', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_metadata')), getColumnIdByNames('gfbio_metadata','url'), getrowIdByContentId(getContentIdByNames('gfbio_metadata', 'label', 'ISO 19115-1')), 'https://www.iso.org/standard/53798.html', now());

select updatecellcontentbyrowidentifier('gfbio_metadata', 'label', 'name', 'other',		'Other metadata or documentation');


------------------------------------------------------------------------------------------------
---------------------------------       legal requirements        -- 24.04.2018 ----------------
------------------------------------------------------------------------------------------------

INSERT INTO gfbio_column (columnid, headid, column_name, lastmodifieddate)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_legalrequirement')),'url', now());

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','url'), getrowIdByContentId(getContentIdByNames('gfbio_legalrequirement', 'name', 'Nagoya Protocol')), 'https://gfbio.biowikifarm.net/wiki/Legal_aspects_of_gathering_and_using_biological_material_for_genetic_research', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','url'), getrowIdByContentId(getContentIdByNames('gfbio_legalrequirement', 'name', 'Red List')), 'http://www.iucnredlist.org/', now());
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent, lastmodifieddate)VALUES(getNewContentId(),(select getHeadIdByName('gfbio_legalrequirement')), getColumnIdByNames('gfbio_legalrequirement','url'), getrowIdByContentId(getContentIdByNames('gfbio_legalrequirement', 'name', 'Personally Identifiable Information')), 'https://en.wikipedia.org/wiki/Personally_identifiable_information', now());


select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'description', 'Nagoya Protocol', 	'The Nagoya Protocol (NP) is an international agreement that aims at sharing the benefits resulting from the utilization of genetic resources in a fair and equitable way.');
select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'description', 'Red List',		'The Red List is widely recognized as the most comprehensive, objective global approach for evaluating the conservation status of plant and animal species and now plays an increasingly prominent role in guiding conservation activities of governments, NGOs and scientific institutions (http://www.iucnredlist.org).');
select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'description', 'Personally Identifiable Information',		'Sensitive personal information can be used to identify a single person (e.g. name, passport information, credit card number).');

select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'name', 'Nagoya Protocol',		'Nagoya Protocol');
select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'name', 'Red List',		'IUCN Red List of Threatened Species');
select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'name', 'Personally Identifiable Information',		'Sensitive Personal Information');

select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'label', 'Sensitive Personal Information',		'Sensitive Personal Information');
select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'label', 'IUCN Red List of Threatened Species',		'Red List');
select updatecellcontentbyrowidentifier('gfbio_legalrequirement', 'name', 'label', 'Nagoya Protocol',		'Nagoya Protocol');