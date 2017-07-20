---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
-------------------------------------   dynamic head    -------------------------------------
---------------------------------------------------------------------------------------------


--
create or replace function getMaxHeadId() RETURNS TABLE (mr bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(headid) =0 
			THEN 
				0 
			ELSE
				MAX(headid)
			END 
		) as headid
	FROM
		public.gfbio_head
	
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
