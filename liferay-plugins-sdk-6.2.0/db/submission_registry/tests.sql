INSERT INTO person (screenname) VALUES ('ivo'),('marc');
SELECT * FROM person;

INSERT INTO gfbio_researchobject (label,type) VALUES ('s1','sample'), ('s2','sample');
SELECT * FROM gfbio_researchobject;

UPDATE gfbio_researchobject SET label='s3' WHERE researchobjectId=1;
SELECT * FROM gfbio_researchobject;

INSERT INTO data_provider (label) VALUES ('ENA');
INSERT INTO data_provider (label) VALUES ('PANGAEA');
SELECT * FROM data_provider;

INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,archive_pid_type,person,broker_submission_id)
     VALUES (1,2,'ENA',1111,1,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11');
INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,archive_pid_type,person,broker_submission_id)
     VALUES (1,2,'PANGAEA',1113,1,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11');

SELECT * FROM gfbio_submission_registry;

UPDATE gfbio_submission_registry
     SET archive_pid='10.1594/PANGAEA.843778', status='archived'
     WHERE research_object_id=1 AND archive='PANGAEA' AND broker_submission_id='a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11';

UPDATE gfbio_submission_registry
     SET archive_pid='ACX092372', status='archived'
     WHERE research_object_id=1 AND archive='ENA' AND broker_submission_id='a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11';

SELECT * FROM gfbio_submission_registry;
       
/***
* TEST CASE 2
***/

INSERT INTO gfbio_researchobject (label,type) VALUES ('s4','sample');
SELECT * FROM gfbio_researchobject;

INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,person,broker_submission_id)
     VALUES (3,1,'ENA',2,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95');
INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,person,broker_submission_id)
     VALUES (3,1,'PANGAEA',2,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95');

SELECT * FROM gfbio_submission_registry;

UPDATE gfbio_researchobject SET type='experiment' WHERE researchobjectId=3;

UPDATE gfbio_submission_registry
     SET archive_pid='10.24355/PANGAEA.927462', status='archived'
     WHERE research_object_id=3 AND archive='PANGAEA' AND broker_submission_id='E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95';

UPDATE gfbio_submission_registry
     SET archive_pid='ARX05463', status='archived'
     WHERE research_object_id=3 AND archive='ENA' AND broker_submission_id='E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95';

SELECT * FROM gfbio_submission_registry;

/***
* TEST CASE 3 - use function to add research object and get id back
***/
SELECT add_research_object('E1','experiment');
SELECT * FROM gfbio_researchobject;

/***
* TEST CASE 4 - views on submission registry
* USE CASE: Research object is submitted in version 1, then it is updated and submitted again (the broker agent handles that as an update).
***/

INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,person,broker_submission_id)
     VALUES (2,1,'ENA',1,'b1ddcd00-9c0b-4ef8-bb6d-6bb9bd380a11');
INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,person,broker_submission_id)
     VALUES (2,1,'PANGAEA',1,'b1ddcd00-9c0b-4ef8-bb6d-6bb9bd380a11');

UPDATE gfbio_researchobject SET label='B1' WHERE researchobjectId=2;

INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,person,broker_submission_id)
     VALUES (2,2,'ENA',2,'46BE1BB9-243B-4DBA-81ED-1F0CAB54F27A');
INSERT INTO gfbio_submission_registry (research_object_id,research_object_version,archive,person,broker_submission_id)
     VALUES (2,2,'PANGAEA',2,'46BE1BB9-243B-4DBA-81ED-1F0CAB54F27A');

SELECT * FROM latest_submissions;

    SELECT sh.*, p.screenname
      FROM get_submission_history(2) AS sh
INNER JOIN person p ON  p.user_id=sh.person
     WHERE archive='ENA';

/***
* TEST CASE 5 - update on research object without introducing a change does not increment the version number
***/
SELECT add_research_object('E5','experiment');
SELECT * FROM gfbio_researchobject WHERE label='E5';
UPDATE gfbio_researchobject SET type='experiment' WHERE label='E5';
SELECT * FROM gfbio_researchobject WHERE label='E5';
