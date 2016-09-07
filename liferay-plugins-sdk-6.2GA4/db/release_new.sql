----------------------------------------------------------------------------------------------
-------------------------------------     dataprovider      -- 22.06.2016 --------------------
----------------------------------------------------------------------------------------------

ALTER TABLE gfbio_dataprovider ADD COLUMN physicalobjects boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN taxonbased boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN notaxonbased boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN livingobjects boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN deadobjects boolean;
ALTER TABLE gfbio_dataprovider ADD COLUMN sequencedata boolean;


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


-----------------------------------------------------------------------------------------------
-------------------------------------- Head, Cell & Content -----------------------------------
-------------------------------------     category          -- 23.06.2016 ---------------------
-----------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1696','1','1' ,'1697','1696');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1698','1','2' ,'1697','Algae & Protists');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1699','1','3' ,'1697','Algae & Protists');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1700','1','22','1697','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1701','1','1' ,'1702','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1703','1','2' ,'1702','Bacteriology, Virology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1704','1','3' ,'1702','Bacteriology, Virology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1705','1','22','1702','');

----------------------------------------------------------------------------------------------
-------------------------------------- Head, Cell & Content ----------------------------------
-----------------------------------     category Type      -- 23.06.2016 ---------------------
----------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1711','6','15','1712','1696');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1713','6','16','1712','1524');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1714','6','15','1715','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1716','6','16','1715','1524');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------     category dataprovider     -- 23.06.2016 ---------------
--------------------------------------------------------------------------------------------


------------------------------------- Content Table Content -------------------------------------


INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1720','7','17','1721','1696');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1722','7','18','1721','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1724','7','17','1725','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1726','7','18','1725','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1728','7','17','1729','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1730','7','18','1729','1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1732','7','17','1733','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1734','7','18','1733','1');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1736','7','17','1737','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1738','7','18','1737','2');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1739','7','17','1740','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1741','7','18','1740','2');

Delete FROM gfbio_content WHERE  rowid = 1569;
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1742','7','17','1743','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1744','7','18','1743','3');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1745','7','17','1746','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1747','7','18','1746','4');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1748','7','17','1749','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1750','7','18','1749','4');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1754','7','17','1755','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1756','7','18','1755','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1757','7','17','1758','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1759','7','18','1758','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1760','7','17','1761','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1762','7','18','1761','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1763','7','17','1764','1508');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1765','7','18','1764','5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1766','7','17','1767','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1768','7','18','1767','5');

Delete FROM gfbio_content WHERE  rowid = 1614;
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1769','7','17','1770','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1771','7','18','1770','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1772','7','17','1773','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1774','7','18','1773','6');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1775','7','17','1776','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1777','7','18','1776','6');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1778','7','17','1779','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1780','7','18','1779','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1781','7','17','1782','1500');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1783','7','18','1782','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1784','7','17','1785','1504');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1786','7','18','1785','7');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1787','7','17','1788','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1789','7','18','1788','7');

Delete FROM gfbio_content WHERE  rowid = 1635;
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1790','7','17','1791','1496');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1792','7','18','1791','8');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1793','7','17','1794','1520');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1795','7','18','1794','8');

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1796','7','17','1797','1701');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1798','7','18','1797','9');



----------------------------------------------------------------------------------------------
-------------------------------------     dataprovider      -- 29.06.2016 --------------------
----------------------------------------------------------------------------------------------

--Question 4
ALTER TABLE gfbio_dataprovider ADD COLUMN botanicalobjects boolean;
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicalobjects boolean;
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicalobjects boolean;
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN paleontologicalobjects boolean;
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET paleontologicalobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET paleontologicalobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicaltissueobjects boolean;
UPDATE gfbio_dataprovider SET botanicaltissueobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicaltissueobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicaltissueobjects boolean;
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicaltissueobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicaltissueobjects boolean;
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicaltissueobjects = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicaldnasamples boolean;
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicaldnasamples = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicaldnasamples boolean;
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicaldnasamples = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicaldnasamples boolean;
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicaldnasamples = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicalobjectsinethanol boolean;
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalobjectsinethanol = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicalobjectsinethanol boolean;
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalobjectsinethanol = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicalobjectsinethanol boolean;
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalobjectsinethanol = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN botanicalmicroscopicslides boolean;
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET botanicalmicroscopicslides = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN mycologicalmicroscopicslides boolean;
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='MfN';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET mycologicalmicroscopicslides = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN zoologicalmicroscopicslides boolean;
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET zoologicalmicroscopicslides = false WHERE label ='PANGAEA';

ALTER TABLE gfbio_dataprovider ADD COLUMN otherobjects boolean;
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='BGBM';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='DSMZ';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='MfN';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SGN';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SMNS';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='SNSB';
UPDATE gfbio_dataprovider SET otherobjects = true WHERE label ='ZFMK';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='ENA';
UPDATE gfbio_dataprovider SET otherobjects = false WHERE label ='PANGAEA';


----------------------------------------------------------------------------------------------
-------------------------------------     user sso      --  --------------------
----------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS
     gfbio_usersso;

CREATE TABLE gfbio_usersso
(
  userId bigint NOT NULL,
  token text,
  lastmodifieddate timestamp without time zone,
  CONSTRAINT gfbio_usersso_pkey PRIMARY KEY (userId)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_usersso
  OWNER TO liferay_gfbio;
  
  
----------------------------------------------------------------------------------------------
---------------------------------     researchobject user      -- 02.08.2016 -----------------
----------------------------------------------------------------------------------------------


CREATE TABLE gfbio_researchobject_user
(
  researchobjectid bigint NOT NULL,
  userid bigint NOT NULL,
  startdate timestamp with time zone,
  enddate timestamp with time zone,
  usertype character(40),
  researchobjectversion integer,
  CONSTRAINT gfbio_researchobject_user_pkey PRIMARY KEY (researchobjectid, userid),
  CONSTRAINT gfbio_researchobject_fkey FOREIGN KEY (researchobjectid, researchobjectversion)
      REFERENCES gfbio_researchobject (researchobjectid, researchobjectversion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gfbio_researchobject_user
  OWNER TO liferay_gfbio;

  
--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 30.08.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1800','11','30' ,'1801','1800');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1802','11','31' ,'1801','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1803','11','32' ,'1801','other');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1804','11','33' ,'1801','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1805','11','34' ,'1801','');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     metadata      -- 31.08.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1806','11','30' ,'1807','1806');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1808','11','31' ,'1807','ABCD 2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1809','11','32' ,'1807','ABCD');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1810','11','33' ,'1807','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1811','11','34' ,'1807','2.06');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1812','11','30' ,'1813','1812');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1814','11','31' ,'1813','Dublin Core (Metadata Elements Set V1.1)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1815','11','32' ,'1813','Dublin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1816','11','33' ,'1813','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1817','11','34' ,'1813','Metadata Elements Set V1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1818','11','30' ,'1819','1818');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1820','11','31' ,'1819','Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1821','11','32' ,'1819','Darwin Core');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1822','11','33' ,'1819','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1823','11','34' ,'1819','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1824','11','30' ,'1825','1824');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1826','11','31' ,'1825','EDM (Europeana Data Model V5.2.5)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1827','11','32' ,'1825','EDM');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1828','11','33' ,'1825','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1829','11','34' ,'1825','V5.2.5');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1830','11','30' ,'1831','1830');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1832','11','31' ,'1831','EML (Ecological Metadata Language V2.1.1)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1833','11','32' ,'1831','EML');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1834','11','33' ,'1831','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1835','11','34' ,'1831','V2.1.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1836','11','30' ,'1837','1836');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1838','11','31' ,'1837','ESE (Europeana Semantic Elements V3.4.1)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1839','11','32' ,'1837','ESE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1840','11','33' ,'1837','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1841','11','34' ,'1837','V3.4.1');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1842','11','30' ,'1843','1842');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1844','11','31' ,'1843','MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1845','11','32' ,'1843','MIxS');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1846','11','33' ,'1843','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1847','11','34' ,'1843','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1848','11','30' ,'1849','1848');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1850','11','31' ,'1849','INSPIRE (VO (EG) Nr. 1205/2008)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1851','11','32' ,'1849','INSPIRE');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1852','11','33' ,'1849','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1853','11','34' ,'1849','VO (EG) Nr. 1205/2008');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1854','11','30' ,'1855','1854');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1856','11','31' ,'1855','ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1857','11','32' ,'1855','ISO 19115');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1858','11','33' ,'1855','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1859','11','34' ,'1855','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1860','11','30' ,'1861','1860');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1862','11','31' ,'1861','pansimple DC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1863','11','32' ,'1861','pansimple DC');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1864','11','33' ,'1861','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1865','11','34' ,'1861','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1866','11','30' ,'1867','1866');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1868','11','31' ,'1867','Biological Collections Ontology (BCO)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1869','11','32' ,'1867','BCO');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1870','11','33' ,'1867','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1871','11','34' ,'1867','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1872','11','30' ,'1873','1872');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1874','11','31' ,'1873','Biological Collections Ontology (BCO)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1875','11','32' ,'1873','BCO');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1876','11','33' ,'1873','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1877','11','34' ,'1873','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1878','11','30' ,'1879','1878');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1880','11','31' ,'1879','Biodiversity Ecosystem Functioning Data (BEFDATA)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1881','11','32' ,'1879','BEFDATA');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1882','11','33' ,'1879','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1883','11','34' ,'1879','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1884','11','30' ,'1885','1884');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1886','11','31' ,'1885','Chemical Entities of Biological Interest (ChEBI)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1887','11','32' ,'1885','ChEBI');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1888','11','33' ,'1885','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1889','11','34' ,'1885','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1890','11','30' ,'1891','1890');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1892','11','31' ,'1891','Geographic Region Ontology (GEOREGION)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1893','11','32' ,'1891','GEOREGION');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1894','11','33' ,'1891','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1895','11','34' ,'1891','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1896','11','30' ,'1897','1896');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1898','11','31' ,'1897','Phenotypic Quality Ontology (PATO)');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1899','11','32' ,'1897','PATO');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1900','11','33' ,'1897','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1901','11','34' ,'1897','');


--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     license      -- 31.08.2016 ---------------------
--------------------------------------------------------------------------------------------

INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1902','8','23','1903','1902');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1904','8','24','1903','Creative Commons Zero');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1905','8','25','1903','CC0');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1906','8','26','1903','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1907','8','26','1903','');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1908','8','27','1903','');

--------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ----------------------------------
--------------------------------------     license      -- 07.09.2016 ---------------------
--------------------------------------------------------------------------------------------



UPDATE 	gfbio_content 	SET cellcontent = 'Other License' 											WHERE 	contentid =1466;
UPDATE 	gfbio_content 	SET cellcontent = 'other' 													WHERE 	contentid =1467;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Zero' 									WHERE 	contentid =1470;
UPDATE 	gfbio_content 	SET cellcontent = 'CC0' 													WHERE 	contentid =1471;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution' 							WHERE 	contentid =1474;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY' 													WHERE 	contentid =1475;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-ShareAlike' 				WHERE 	contentid =1478;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-SA' 												WHERE 	contentid =1479;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NoDerivs' 					WHERE 	contentid =1482;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC-SA' 											WHERE 	contentid =1483;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NonCommercial' 				WHERE 	contentid =1486;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC' 												WHERE 	contentid =1487;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NonCommercial-ShareAlike' 	WHERE 	contentid =1490;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC-SA' 											WHERE 	contentid =1491;

UPDATE 	gfbio_content 	SET cellcontent = 'Creative Commons Attribution-NonCommercial-NoDerivs' 	WHERE 	contentid =1904;
UPDATE 	gfbio_content 	SET cellcontent = 'CC BY-NC-ND' 											WHERE 	contentid =1905;