


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
-----------------------------------     Category Type     ---------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


INSERT INTO gfbio_head (headid, table_name, table_type)VALUES(getNewHeadId(),'gfbio_category_type','relationship');


------------------------------------- Column Table Content -------------------------------------


INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_type')),'gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES(getNewColumnId(),(select getHeadIdByName('gfbio_category_type')),'gfbio_type');


------------------------------------- Content Table Content -------------------------------------


--categories with type material kind
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botanical microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycological microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological tissue objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological DNA samples' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological objects in ethanol' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoological microscopic slides' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Paleontological objects' ,  'name', 'material kind' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Other objects' ,  'name', 'material kind' );

--categories with type research field
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Algae & Protists' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Bacteriology, Virology' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Botany' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Ecology' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Geoscience' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Microbiology' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Mycology' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Palaeontology' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Zoology' ,  'name', 'research field' );
SELECT insertHCCRelationship('gfbio_category_type' , 'gfbio_category' , 'gfbio_type' ,  'label' ,  'Other' ,  'name', 'research field' );