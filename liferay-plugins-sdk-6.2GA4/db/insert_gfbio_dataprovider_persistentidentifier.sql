
-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-------------------------------     Category Dataprovider     -----------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------

INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_dataprovider_persistentidentifier','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_dataprovider_persistentidentifier')),'gfbio_dataprovider');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_dataprovider_persistentidentifier')),'gfbio_persistentidentifier');



------------------------------------- Content Table Content -------------------------------------

------------------------------------- Content Dataprovider Persistent Identifier -------------------------------------




SELECT insertHCCRelationshipWithOutsideOfHCCFirstColumn('gfbio_dataprovider_persistentidentifier' , 'gfbio_persistentidentifier' , 'gfbio_dataprovider' ,  'label' ,  'DOI' ,       (SELECT getDataProviderIdByLabel( 'PANGAEA' )) );
SELECT insertHCCRelationshipWithOutsideOfHCCFirstColumn('gfbio_dataprovider_persistentidentifier' , 'gfbio_persistentidentifier' , 'gfbio_dataprovider' ,  'label' ,  'ACCESSION' , (SELECT getDataProviderIdByLabel( 'ENA' )) );