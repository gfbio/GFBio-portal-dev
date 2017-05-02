---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic column    ------------------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxColumnId() RETURNS TABLE (mr bigint) AS
$$
	SELECT columnid
	FROM
		(SELECT MAX(columnid) as "columnid" FROM gfbio_column) as maxid
	ORDER BY columnid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewColumnId() RETURNS bigint AS
$$
	SELECT getMaxColumnId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getColumnIdByNames(in hename text, in colname text) RETURNS TABLE (columnid bigint) AS
$$
	SELECT 
	  columnid 
	FROM 
	  public.gfbio_column
	WHERE
	  column_name = colname AND
	  headid = (select getHeadIdByName(hename));
$$	
language 'sql' STABLE;