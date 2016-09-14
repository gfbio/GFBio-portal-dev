------------------------------------- Content Data Provider -------------------------------------


INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('1', 'Botanic Garden and Botanical Museum Berlin-Dahlem', 'BGBM');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('2', 'Leibniz Institute DSMZ-German Collection of Microorganisms and Cell Cultures', 'DSMZ');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('3', 'Museum fuer Naturkunde - Leibniz Institute for Evolution and Biodiversity Science', 'MfN');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('4', 'PANGAEA - Data Publisher for Earth & Environmental Science', 'PANGAEA');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('5', 'Senckenberg Gesellschaft fuer Naturforschung', 'SGN');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('6', 'Bavarian Natural History Collections', 'SMNS');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('7', 'Staatliche Naturwissenschaftliche Sammlungen Bayerns IT Center', 'SNSB');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('8', 'Zoological Research Museum Alexander Koenig', 'ZFMK');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('9', 'European Nucleotide Archive', 'ENA');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('10', 'GFBio Collections', 'GFBio collections');

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

--Question 4
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET botanicaltissueobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET mycologicaltissueobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='PANGAEA';

UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='PANGAEA'

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




