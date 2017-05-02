------------------------------------- Content Data Provider -------------------------------------


INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Botanic Garden and Botanical Museum Berlin, Freie Universität Berlin', 'BGBM');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Leibniz Institute DSMZ - German Collection of Microorganisms and Cell Cultures, Braunschweig', 'DSMZ');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Leibniz Institute for Research on Evolution and Biodiversity, Berlin', 'MfN');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Data Publisher for Earth & Environmental Science', 'PANGAEA');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Senckenberg Gesellschaft für Naturforschung - Leibniz Institute, Frankfurt', 'SGN');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'State Museum of Natural History Stuttgart', 'SMNS');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Staatliche naturwissenschaftliche Sammlungen Bayerns - SNSB IT Center, München', 'SNSB');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'Zoological Research Museum Alexander Koenig - Leibniz Institute for Animal Biodiversity, Bonn', 'ZFMK');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'European Nucleotide Archive', 'ENA');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES (getNewDataProviderId(), 'GFBio Collections', 'GFBio collections');

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
ALTER TABLE gfbio_dataprovider ADD COLUMN physicalobjectpossible BOOLEAN;
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET physicalobjectpossible = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET physicalobjectpossible = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET physicalobjectpossible = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN nophysicalobject BOOLEAN;
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






