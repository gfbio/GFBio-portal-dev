----------------------------------------------------------------------------------------------
-------------------------------------     dataprovider      ----------------------------------
----------------------------------------------------------------------------------------------
UPDATE gfbio_dataprovider SET name = 'Botanic Garden and Botanical Museum Berlin-Dahlem' WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET name = 'Leibniz Institute DSMZ-German Collection of Microorganisms and Cell Cultures' WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET name = 'Museum fuer Naturkunde - Leibniz Institute for Evolution and Biodiversity Science' WHERE label ='MfN';
UPDATE gfbio_dataprovider SET name = 'Senckenberg Gesellschaft fuer Naturforschung' WHERE label ='SGN';
UPDATE gfbio_dataprovider SET name = 'State Museum of Natural History Stuttgart' WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET name = 'Bavarian Natural History Collections' WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET name = 'Zoological Research Museum Alexander Koenig' WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET name = 'European Nucleotide Archive' WHERE label ='ENA';
UPDATE gfbio_dataprovider SET name = 'PANGAEA - Data Publisher for Earth & Environmental Science' WHERE label ='PANGAEA';
UPDATE gfbio_dataprovider SET name = 'GFBio Collections' WHERE label ='GFBio collections';

--Question 1
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET physicalobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET physicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET physicalobjects = false WHERE label ='PANGAEA';

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