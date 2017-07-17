---------------------------------------------------------------------------------------------
------------------------------------------ Functions ----------------------------------------
-------------------------------------   dynamic dataprovider    -------------------------------------
---------------------------------------------------------------------------------------------


--
create or replace function getDataProviderIdByLabel(in dataproviderlabel text) RETURNS TABLE (dataproviderid bigint) AS
$$
	SELECT 
	  dataproviderid 
	FROM 
	  public.gfbio_dataprovider
	WHERE
	  label = dataproviderlabel;
$$	
language 'sql' STABLE;


--
create or replace function getMaxDataProivderId() RETURNS TABLE (maxid bigint) AS
$$
	SELECT 
		(CASE 
			WHEN 
				count(dataproviderid) =0 
			THEN 
				0 
			ELSE
				MAX(dataproviderid)
			END 
		) as dataproviderid
	FROM
		public.gfbio_dataprovider
$$	
language 'sql' STABLE;


--
CREATE or replace function getNewDataProviderId() RETURNS bigint AS
$$
	SELECT getMaxDataProivderId()+1;
$$	
language 'sql' STABLE;
