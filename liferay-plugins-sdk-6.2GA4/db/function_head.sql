---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
-------------------------------------   dynamic head    -------------------------------------
---------------------------------------------------------------------------------------------

--
create or replace function getMaxHeadId() RETURNS TABLE (mr bigint) AS
$$
	SELECT headid
	FROM
		(SELECT MAX(headid) as "headid" FROM gfbio_head) as maxid
	ORDER BY headid DESC
	limit (1);
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewHeadId() RETURNS bigint AS
$$
	SELECT getMaxHeadId()+1;
$$	
language 'sql' STABLE;


--
create or replace function getHeadIdByName(in hename text) RETURNS TABLE (contentid bigint) AS
$$
	SELECT 
		headid 
	FROM 
		public.gfbio_head
	WHERE
		table_name = hename;
$$	
language 'sql' STABLE;
