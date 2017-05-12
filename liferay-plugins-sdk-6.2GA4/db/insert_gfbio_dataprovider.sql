------------------------------------- Content Data Provider -------------------------------------


INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Botanic Garden and Botanical Museum Berlin, Freie Universität Berlin', 'BGBM',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Leibniz Institute DSMZ - German Collection of Microorganisms and Cell Cultures, Braunschweig', 'DSMZ',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Leibniz Institute for Research on Evolution and Biodiversity, Berlin', 'MfN',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Data Publisher for Earth & Environmental Science', 'PANGAEA',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Senckenberg Gesellschaft für Naturforschung - Leibniz Institute, Frankfurt', 'SGN',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'State Museum of Natural History Stuttgart', 'SMNS',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Staatliche naturwissenschaftliche Sammlungen Bayerns - SNSB IT Center, München', 'SNSB',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'Zoological Research Museum Alexander Koenig - Leibniz Institute for Animal Biodiversity, Bonn', 'ZFMK',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'European Nucleotide Archive', 'ENA',now());
INSERT INTO gfbio_dataprovider (dataproviderid, name, label, lastmodifieddate)  VALUES ((select getNewDataProviderId()), 'GFBio Collections', 'GFBio collections',now());

--Provider type
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='MfN';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='SGN';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='ENA';
UPDATE gfbio_dataprovider SET providertype = 'GFBio Archive' WHERE label ='PANGAEA';

--Question 1
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET physicalobjectpossible = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET physicalobjectpossible = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='ENA';
UPDATE gfbio_dataprovider SET nophysicalobject = true WHERE label ='PANGAEA';

--Question 2.1
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET taxonbased = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET taxonbased = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET taxonbased = false WHERE label ='PANGAEA';

--Question 2.2
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET notaxonbased = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET notaxonbased = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET notaxonbased = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET notaxonbased = false WHERE label ='PANGAEA';

--Question 3.1
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET livingobjects = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='SGN';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET livingobjects = false WHERE label ='PANGAEA';

--Question 3.2
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET deadobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET deadobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET deadobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET deadobjects = false WHERE label ='PANGAEA';

--Question 4
-- in category dataprovider

--Question 5
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='SGN';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET sequencedata = true WHERE label ='ENA';
UPDATE gfbio_dataprovider SET sequencedata = false WHERE label ='PANGAEA';


--Timestamp
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='MfN';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='SGN';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='ENA';
UPDATE gfbio_dataprovider SET lastmodifieddate = now() WHERE label ='PANGAEA';

