


--------------------------------------------------------------------------------------------
-------------------------------------- Example Table ---------------------------------------
--------------------------------------    Content    ---------------------------------------
--------------------------------------------------------------------------------------------


------------------------------------- Content Research Object -------------------------------------


INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('1','1','s1','sample','4');
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('2','1','s2','sample','4');
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('3','1','s4','sample','4');
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('3','2','s4','sample','4');
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('3','3','s4','sample','4');
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('4','1','E1','study','5');
INSERT INTO gfbio_researchobject (researchobjectid, researchobjectversion, label,researchobjecttype, parentresearchobjectid) VALUES ('5','1','E1','test','0');


------------------------------------- Content Submission Registry -------------------------------------


INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (1,1,'ENA','tENA01',1265,47629,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'send');
INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (2,1,'PANGAEA','tPAN01',1268,47629,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'send');
--INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (2,2,'ENA','tENA02',1265,47629,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a12', 'send');
INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (3,1,'ENA','tENA03',1265,47629,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95', 'send');
INSERT INTO gfbio_submissionregistry (researchobjectid,researchobjectversion,archive,archive_pid,archive_pid_type,userid,brokersubmissionid, status) VALUES (3,1,'PANGAEA','tPAN02',1268,47629,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95', 'send');

