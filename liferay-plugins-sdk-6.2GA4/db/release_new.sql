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



