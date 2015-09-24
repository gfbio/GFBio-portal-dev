


-------------------------------------------------------------------------------------------
------------------------------------ Head, Cell & Content ---------------------------------
--------------------------------------     Content     ------------------------------------
-------------------------------------------------------------------------------------------



------------------------------------- Head Table Content -------------------------------------


---- tables  ----
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('1','gfbio_category','entity');
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('2','gfbio_researchfield','entity');
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('4','gfbio_dataprovider','entity');
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('5','gfbio_persistentidentifier','entity');



--- relations ----
INSERT INTO gfbio_head (headid, table_name, table_type)VALUES('3','gfbio_category_researchfield','relationship');




------------------------------------- Column Table Content -------------------------------------


 
---- tables  ----
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('100','1','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('101','1','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('102','2','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('103','2','description');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('106','4','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('107','5','name');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('108','5','label');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('109','1','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('110','2','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('111','4','id');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('112','5','id');



--- relations ----
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('104','3','gfbio_category');
INSERT INTO gfbio_column (columnid, headid, column_name)VALUES('105','3','gfbio_researchfield');



------------------------------------- Content Table Content -------------------------------------


------------
--- entities
------------


--- gfbio_category
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1022','1','109','10','1022');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1000','1','100','10','Fishes');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1001','1','101','10','Pisces');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1023','1','109','11','1023');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1002','1','100','11','Sea urchin');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1003','1','101','11','Echinoidea');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1024','1','109','12','1024');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1004','1','100','12','E.coli');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1005','1','101','12','Escherichia coli');


--- persistent_identifier
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)  VALUES ('1029', '5', '112', '20','1029');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)  VALUES ('1018', '5', '107', '20','Accession Number');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)  VALUES ('1019', '5', '108', '20','ACCESSION');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)  VALUES ('1030', '5', '112', '21','1030');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)  VALUES ('1020', '5', '107', '21','Digital Object Identifier');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)  VALUES ('1021', '5', '108', '21','DOI');


--- gfbio_researchfield
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1025','2','110','13','1025');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1006','2','102','13','Oceanography');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1007','2','103','13','Branch of Earth science that studies the ocean.');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1026','2','110','14','1026');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1008','2','102','14','Microbiology');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1009','2','103','14','It is the study of microscopic organisms.');



-----------------
--- relationships
-----------------


--- gfbio_category_researchfield
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1010','3','104','15','10');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1011','3','105','15','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1012','3','104','16','11');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1013','3','105','16','13');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1014','3','104','17','12');
INSERT INTO gfbio_content (contentid, headid, columnid, rowid, cellcontent)VALUES('1015','3','105','17','14');



--------------------------------------------------------------------------------------------
--------------------------------------- Other entity ---------------------------------------
--------------------------------------    Content    ---------------------------------------
--------------------------------------------------------------------------------------------



------------------------------------- Content Data Provider -------------------------------------


INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('1', 'PANGAEA - Data Publisher for Earth & Environmental Science', 'PANGAEA');
INSERT INTO gfbio_dataprovider (dataproviderid, name, label)  VALUES ('2', 'European Nucleotide Archive', 'ENA');


------------------------------------- Content Research Object -------------------------------------


INSERT INTO gfbio_researchobject (researchobjectid, version, label,type) VALUES ('1','1','s1','sample');
INSERT INTO gfbio_researchobject (researchobjectid, version, label,type) VALUES ('2','1','s2','sample');
INSERT INTO gfbio_researchobject (researchobjectid, version, label,type) VALUES ('3','1','s4','sample');
INSERT INTO gfbio_researchobject (researchobjectid, version, label,type) VALUES ('4','1','E1','experiment');


------------------------------------- Content Submission Registry -------------------------------------


INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (1,1,'ENA',1029,'tENA01',10199,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'local');
INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (2,1,'PANGAEA',1030,'tPAN01',10199,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'local');
INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (3,1,'ENA',1029,'tENA02',10199,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95', 'local');
INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (3,1,'PANGAEA',1030,'tPAN02',10199,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95', 'local');


--------------------------------------------------------------------------------------------
----------------------------------- Other relationships ------------------------------------
--------------------------------------    Content    ---------------------------------------
--------------------------------------------------------------------------------------------


INSERT INTO gfbio_dataprovider_persistentidentifier (gfbio_dataprovider, gfbio_persistentidentifier) VALUES ('1','1030');
INSERT INTO gfbio_dataprovider_persistentidentifier (gfbio_dataprovider, gfbio_persistentidentifier) VALUES ('2','1029');
