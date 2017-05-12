


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Category Dataprovider     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------

INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_category_dataprovider','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_dataprovider')),'gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_dataprovider')),'gfbio_dataprovider');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_dataprovider')),'lastmodifieddate');


------------------------------------- Content Table Content -------------------------------------

-- categories with type material kind
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );


-- categories with type research field
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Algae & Protists' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Algae & Protists' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Bacteriology, Virology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'DSMZ' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Bacteriology, Virology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Bacteriology, Virology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'DSMZ' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'DSMZ' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'DSMZ' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'DSMZ' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'BGBM' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'DSMZ' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'MfN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SGN' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SMNS' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'SNSB' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ZFMK' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );









