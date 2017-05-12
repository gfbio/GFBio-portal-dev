---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
------------------------------------   dynamic column    ------------------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxColumnId() RETURNS TABLE (mr bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(columnid) =0 
			THEN 
				0 
			ELSE
				MAX(columnid)
			END 
		) as columnid
	FROM
		public.gfbio_column
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