

----------------------------------------------------------------------------------------------------------------------
-------------------------------------              datamanagementplan              -- 06.10.2017 ---------------------
----------------------------------------------------------------------------------------------------------------------

CREATE TABLE gfbio_datamanagementplan
(
  dmpid bigint NOT NULL,
  name character(150) NOT NULL,
  userid bigint NOT NULL,
  dmptinput text,
  lastmodifieddate timestamp with time zone NOT NULL DEFAULT now(),
  CONSTRAINT gfbio_datamanagementplan_pkey PRIMARY KEY (dmpid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_datamanagementplan
  OWNER TO liferay_gfbio;
 


------------------------------------------------------------------------------------------------
--------------------------------------       license        -- 20.10.2017 ----------------------
------------------------------------------------------------------------------------------------ 
  
SELECT changeCellContentByNames('gfbio_license', 'url', 'https://creativecommons.org/licenses/by-sa/3.0/de', '');

UPDATE gfbio_content 
SET 
	cellcontent = 'https://creativecommons.org/licenses/by-sa/3.0/de', lastmodifieddate = now()  
WHERE 
  headid =  (select getHeadIdByName('gfbio_license')) and
  columnid = (select getColumnIdByNames('gfbio_license','url')) and
  rowid in (
    SELECT 
      rowid 
    FROM 
      public.gfbio_content
    WHERE
      headid =  (select getHeadIdByName('gfbio_license')) and
      cellcontent = 'CC BY-SA'
  )

  
  ------------------------------------------------------------------------------------------------
-----------------------------------       researchobject        -- 02.11.2017 --------------------
-------------------------------------------------------------------------------------------------- 

ALTER TABLE gfbio_researchobject ADD publications text;
ALTER TABLE gfbio_researchobject ADD datacollectiontime text;
ALTER TABLE gfbio_researchobject ADD embargo timestamp with time zone;


  ------------------------------------------------------------------------------------------------
-----------------------------------       license        -- 02.01.2018 --------------------
-------------------------------------------------------------------------------------------------- 

UPDATE gfbio_content SET  cellcontent='Creative Commons Attribution-NonCommercial'				WHERE cellcontent = 'Creative Commons Attribution-NonComercial';
UPDATE gfbio_content SET  cellcontent='Creative Commons Attribution-NonCommercial-NoDerivs'		WHERE cellcontent = 'Creative Commons Attribution-NonComercial-NoDerivs';
UPDATE gfbio_content SET  cellcontent='Creative Commons Attribution-NonCommercial-ShareAlike'	WHERE cellcontent = 'Creative Commons Attribution-NonComercial-ShareAlike';

