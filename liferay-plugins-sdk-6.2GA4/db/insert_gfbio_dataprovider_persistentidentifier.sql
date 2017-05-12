
-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Category Dataprovider     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------

INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_dataprovider_persistentidentifier','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_dataprovider_persistentidentifier')),'gfbio_dataprovider');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_dataprovider_persistentidentifier')),'gfbio_persistentidentifier');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_externalperson')),'lastmodifieddate');



------------------------------------- Content Table Content -------------------------------------


SELECT insertHCCRelationshipWithOutsideOfHCCFirstColumn('gfbio_dataprovider_persistentidentifier' , 'gfbio_persistentidentifier' , 'gfbio_dataprovider' ,  'label' ,  'DOI' ,       (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'PANGAEA' )) AS text)) );
SELECT insertHCCRelationshipWithOutsideOfHCCFirstColumn('gfbio_dataprovider_persistentidentifier' , 'gfbio_persistentidentifier' , 'gfbio_dataprovider' ,  'label' ,  'ACCESSION' , (SELECT  CAST( (SELECT getDataProviderIdByLabel( 'ENA' )) AS text)) );