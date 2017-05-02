


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Category Dataprovider     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------

INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_category_dataprovider','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_dataprovider')),'gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_dataprovider')),'gfbio_dataprovider');


------------------------------------- Content Table Content -------------------------------------

-- categories with type material kind
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botanical tissue objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycological tissue objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Paleontological objects' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological DNA samples' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological microscopic slides' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological objects in ethanol' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoological tissue objects' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other objects' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );


-- categories with type research field
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Algae & Protists' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Algae & Protists' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Bacteriology, Virology' ,  (SELECT getDataProviderIdByLabel( 'DSMZ' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Bacteriology, Virology' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Bacteriology, Virology' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'DSMZ' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Botany' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Ecology' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Geoscience' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT getDataProviderIdByLabel( 'DSMZ' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Microbiology' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT getDataProviderIdByLabel( 'DSMZ' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Mycology' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Palaeontology' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'DSMZ' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Zoology' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );

SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'BGBM' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'DSMZ' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'MfN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'SGN' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'SMNS' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'SNSB' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'ZFMK' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCSecoundColumn('gfbio_category_dataprovider' , 'gfbio_category' , 'gfbio_dataprovider' ,  'label' ,  'Other' ,  (SELECT getDataProviderIdByLabel( 'ENA' )) );









