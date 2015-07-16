SELECT 
  gfbio_head.name, 
  gfbio_head.type, 
  gfbio_column.value, 
  gfbio_position.rowid, 
  gfbio_position.value
FROM 
  public.gfbio_column, 
  public.gfbio_head, 
  public.gfbio_position
WHERE 
  gfbio_column.headid = gfbio_head.headid AND
  gfbio_column.columnid = gfbio_position.columnid AND
  gfbio_head.headid = 1;
  
