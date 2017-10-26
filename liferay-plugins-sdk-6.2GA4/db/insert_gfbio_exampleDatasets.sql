-- Function: getmetadataid(character)

-- DROP FUNCTION getmetadataid(character);
CREATE OR REPLACE FUNCTION getexampleuserid()
  RETURNS SETOF bigint AS
$BODY$
	Select cast (10199 as bigint); --135812
$BODY$
  LANGUAGE sql STABLE
  COST 100
  ROWS 1000;
ALTER FUNCTION getexampleuserid()
  OWNER TO postgres;

  

CREATE OR REPLACE FUNCTION getmetadataid(t character)
  RETURNS bigint AS
$BODY$
	SELECT
	contentid
	FROM
	public.gfbio_content
	WHERE gfbio_content.headid =(select getHeadIdByName('gfbio_metadata')) AND gfbio_content.columnid= (select getColumnIdByNames('gfbio_metadata','id')) AND gfbio_content.rowid in(
		SELECT 
		  rowid
		FROM 
		  public.gfbio_content
		WHERE 
		  gfbio_content.headid =(select getHeadIdByName('gfbio_metadata')) AND
		  gfbio_content.columnid= (select getColumnIdByNames('gfbio_metadata','label')) AND
		  gfbio_content.cellcontent = t
		);
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
ALTER FUNCTION getmetadataid(character)
  OWNER TO postgres;
  

CREATE OR REPLACE FUNCTION getlicenseid(t character)
  RETURNS bigint AS
$BODY$
	SELECT
	contentid
	FROM
	public.gfbio_content
	WHERE gfbio_content.headid =(select getHeadIdByName('gfbio_license')) AND gfbio_content.columnid= (select getColumnIdByNames('gfbio_license','id')) AND gfbio_content.rowid in(
		SELECT 
		  rowid
		FROM 
		  public.gfbio_content
		WHERE 
		  gfbio_content.headid =(select getHeadIdByName('gfbio_license')) AND
		  gfbio_content.columnid= (select getColumnIdByNames('gfbio_license','label')) AND
		  gfbio_content.cellcontent = t
		);
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
ALTER FUNCTION getmetadataid(character)
  OWNER TO postgres;  

 


  
  
 -- 1
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Die Zitterspinnen Südostasiens (DFG-Projekt HU-980/11-1)', 'Zitterspinnen, Pholcidae, Diversität, Taxonomie, Phylogenie, Mikrohabiate', '{"datacollectiontime":"2009-09-24 to 2014-06-15","legalrequirements":[],"embargo":"","publications":"8 Publications, much more than 500 characters"}', 1, 0, 'Bearbeitung der Diversität, Phylogenie und mehrfach konvergente Mikrohabitats-Wechsel bei Zitterspinnen Südostasiens.', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid, usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 1, now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\64801\2902\1\ZFMK-Araneae_DFG-HU-98011-1.xlsx', 'ZFMK-Araneae_DFG-HU-98011-1.xlsx', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_submission(researchobjectid, researchobjectversion, archive, archive_pid, archive_pid_type, brokersubmissionid, last_changed, userid, is_public,  status, submissionid, jiraid, jirakey)
    VALUES (getmaxresearchobjectid(), 1, 'GFBio collections', '', 0, '0000015c-0c95-c0ff-0000-015c0c95c0ff', now(), getexampleuserid(), FALSE, 'sent', getnewsubmissionid(), '12149', 'DSUB-44');

	
-- 2
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'First record of alien species in a region', 'alien species, global, time series, established alien species', '{"datacollectiontime":"-2014-12-31","legalrequirements":[],"embargo":"2018-05-31","publications":""}', 1, 0, 'The data set contains the year of first record of an alien species in a region, with a region being mostly a country. That is, the data are time series of alien species accumulation for each region. The data set is global including around 280 regions across all taxonomic groups.', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(), 'owner', 1, now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\78042\3002\1\DataFirstRecord_160517.csv', 'DataFirstRecord_160517.csv', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_submission(researchobjectid, researchobjectversion, archive, archive_pid, archive_pid_type, brokersubmissionid, last_changed, userid, is_public,  status, submissionid, jiraid, jirakey)
    VALUES (getmaxresearchobjectid(), 1, 'GFBio collections', '', 0, '0000015c-356d-0243-0000-015c356d0243', now(), getexampleuserid(), FALSE, 'sent', getnewsubmissionid(), '12239', 'DSUB-45');

	
-- 3
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Species and genera detected in the Cameroon Highlands', 'Species and genera detected in the Cameroon Highlands', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":"Hirschfeld et al. 2016, PLoS ONE 11(5): e0155129; https:\/\/doi.org\/10.1371\/journal.pone.0155129"}', 1, 0, 'Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot", Phylogenie und mehrfach konvergente Mikrohabitats-Wechsel bei Zitterspinnen Südostasiens.', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(), 'owner', 1, now());
	
-- 4
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Species occurences over time on two mountains in the Cameroonian Highlands', 'Species occurences over time on two mountains in the Cameroonian Highlands', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":"Hirschfeld et al. 2016, PLoS ONE 11(5): e0155129; https:\/\/doi.org\/10.1371\/journal.pone.0155129"}', 1, 0, 'Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot"', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 1, now());
	
-- 5
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Species occurrence over time on two Cameroonian mountains', 'Species occurrence over time on two Cameroonian mountains', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":"Hirschfeld et al. 2016, PLoS ONE 11(5): e0155129. https:\/\/doi.org\/10.1371\/journal.pone.0155129"}', 1, 0, 'Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot"', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 1, now());
	
-- 6
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Species occurrence over time on two Cameroonian mountains', 'Species occurrence over time on two Cameroonian mountains', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":"Hirschfeld et al. 2016, PLoS ONE 11(5): e0155129. https:\/\/doi.org\/10.1371\/journal.pone.0155129"}', 1, 0, 'Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot" Einzelner Test von mir wegen HELP-157', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(), 'owner', 1, now());
	
-- 7
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Species occurrence over time on two Cameroonian mountains', 'Species occurrence over time on two Cameroonian mountains', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":""}', 2, 0, 'Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot" Einzelner Test von mir wegen HELP-157', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 2, now());
	
-- 8
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Species occurrence over time on two Cameroonian mountains', 'Species occurrence over time on two Cameroonian mountains', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":""}', 1, 0, 'Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot" but test HELP-157', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(), 'owner', 1, now());
	
-- 9
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
  VALUES (getnewresearchobjectid(), 'Species occurrence over time on two Cameroonian mountains', 'Species occurrence over time on two Cameroonian mountains', '{"datacollectiontime":"","legalrequirements":[],"embargo":"","publications":"Hirschfeld et al. 2016, PLoS ONE 11(5): e0155129. https:\/\/doi.org\/10.1371\/journal.pone.0155129"}', 1, 0, 'test for HELP-157Rowdata related to the publication in PLOS ONE: Mareike Hirschfeld, David C. Blackburn, Thomas M. Doherty-Bone, LeGrand Nono Gonwouo, Sonia Ghose, Mark-Oliver Rödel: "Dramatic declines of montane frogs in a Central African biodiversity hotspot"', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid, usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 1, now());
  
-- 10
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Säugetiere im Naturpark Schönbuch (Teilprojekt Soricidae)', 'Naturpark Schönbuch, Soricidae, Spitzmäuse', '{"datacollectiontime":"1989-01-01 to 1991-12-31","legalrequirements":["Uncertain"],"embargo":"2017-12-31","publications":"Erwin Kulzer, Andreas von Lindeiner-Wildau, Isa-Maria Wolters, 1993. Säugetiere im Naturpark Schönbuch, Beiheft 71,  Beihefte zu den Veröffentlichungen für Naturschutz und Landschaftspflege in Baden-Württemberg. ISBN 3-88251-185-0, 212 Seiten"}', 1, 0, 'Übersicht über die Biologie der Arten und Ergebnisse einer faunistisch-ökologischen Untersuchung in den Jahren 1989-1991.', getmetadataid('ABCD'), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid, usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 1, now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\78906\3402\1\Säugetiere_im_Naturpark_Schönbuch_20170705.xlsx', 'Säugetiere_im_Naturpark_Schönbuch_20170705.xlsx', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_submission(researchobjectid, researchobjectversion, archive, archive_pid, archive_pid_type, brokersubmissionid, last_changed, userid, is_public,  status, submissionid, jiraid, jirakey)
    VALUES (getmaxresearchobjectid(), 1, 'GFBio collections', '', 0, '0000015d-133d-94da-0000-015d133d94da', now(), getexampleuserid(), FALSE, 'sent', getnewsubmissionid(), '12475', 'DSUB-52');
	
-- 11
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'Aboveground biomass stocks and net primary production of three primeval European beech forests in eastern Slovakia', 'Biomass stocks, Net primary production NPP, Litter, Deadwood, Stand structure', '{"datacollectiontime":"2013-08-01 to 2015-12-01","legalrequirements":[],"embargo":"","publications":"Glatthorn J, Feldmann E, Pichler V, Hauck M, Leuschner C. Biomass stock and productivity of primeval and production beech forests: Greater canopy structural diversity promotes productivity. Ecosystems. in press."}', 1, 0, 'The study took place in three primeval European beech forest reserves in eastern Slovakia and in three close by production forests with similar site conditions. Three compartments of aboveground biomass stocks (live woody tree biomass, litter biomass, regeneration biomass, coarse and fine woody debris) and two compartments of aboveground net primary production (anual woody biomass increment and litter production) were inventoried. Stand structural data (tree diameter, coordinates, height and more) was inventoried on 40 500 m^2 plots per primeval forest and on 10 plots of the same size per production forest (low intensity plots - 150 LIPs in total). This data was used to estimate live woody biomass on basis of allometric equations. The structural data of the plots were used to classify the primeval forest plots into three stages of the natural development cycle (growth, optimal, terminal). The classification was used as a basis to select four plots per development stage and four plots per production forest  for the recording of the remaining biomass and productivity compartments (high intensity plots - 48 HIPs in total). Litter biomass and production was estimated using litter traps. Regeneration biomass was recorded by counting regeneration trees on sub-plots of the 48 HIPs. Coarse woody debris was estimated by measuring dimensions of all downed logs with base diameters >= 20 cm. Fine woody debris was estimated with line intersect sampling on 4 6.5 m long transects per plot. Annual woody biomass was estimated by taking repeated readings of permanent increment tapes. Upscaling to tree level was done with allometric equations.', getmetadataid(''), 'Dataset', getlicenseid('CC BY'), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(),  'owner', 1, now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\standing_trees.csv', 'standing_trees.csv', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\lying_trees.csv', 'lying_trees.csv', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\plot_data.csv', 'plot_data.csv', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\regeneration.csv', 'regeneration.csv', now());
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\canopy_structure.csv', 'canopy_structure.csv', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\data_description.txt', 'data_description.txt', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\fine_woody_debris.csv', 'fine_woody_debris.csv', now()); 
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_primarydata(primarydataid, path, name, lastmodifieddate)
    VALUES (getnewprimarydataid(), 'C:\liferay-primary-data-folder\79622\4002\1\lying_trees.csv', 'litter.csv', now()); 	
INSERT INTO gfbio_primarydata_researchobject(researchobjectid, researchobjectversion, primarydataid, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), 1, getmaxprimarydataid(), now());
INSERT INTO gfbio_submission(researchobjectid, researchobjectversion, archive, archive_pid, archive_pid_type, brokersubmissionid, last_changed, userid, is_public,  status, submissionid, jiraid, jirakey)
    VALUES (getmaxresearchobjectid(), 1, 'GFBio collections', '', 0, '0000015e-0a13-d01f-0000-015e0a13d01f', now(), getexampleuserid(), FALSE, 'sent', getnewsubmissionid(), '12852', 'DSUB-77');

-- 12
INSERT INTO gfbio_researchobject(researchobjectid, name, label, extendeddata, researchobjectversion, parentresearchobjectid, description, metadataid, researchobjecttype,  licenseid, lastmodifieddate)
    VALUES (getnewresearchobjectid(), 'study_alias_0', 'study_alias_0', '{"study_type": "Metagenomics", "study_abstract": "123456", "study_title": "123456", "study_alias": "study_alias_0"}', 1, 0, '', getmetadataid(''), '', getlicenseid(''), now());
INSERT INTO gfbio_researchobject_user(researchobjectid, userid,  usertype, researchobjectversion, lastmodifieddate)
    VALUES (getmaxresearchobjectid(), getexampleuserid(), 'owner', 1, now());
