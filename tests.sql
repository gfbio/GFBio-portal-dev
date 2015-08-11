INSERT INTO person (screenname) VALUES ('ivo'),('marc');
SELECT * FROM person;

INSERT INTO research_object (label,type) VALUES ('s1','sample'), ('s2','sample');
SELECT * FROM research_object;

UPDATE research_object SET label='s3' WHERE research_object_id=1;
SELECT * FROM research_object;

INSERT INTO data_provider (label) VALUES ('ENA');
INSERT INTO data_provider (label) VALUES ('PANGAEA');
SELECT * FROM data_provider;

INSERT INTO persistent_identifier (name,label) VALUES ('Accession Number','ACCESSION');
INSERT INTO persistent_identifier (name,label) VALUES ('Digital Object Identifier','DOI');
SELECT * FROM persistent_identifier;

INSERT INTO submission_registry (research_object_id,research_object_version,archive,archive_pid_type,person,broker_submission_id)
     VALUES (1,2,'ENA','ACCESSION',1,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11');
INSERT INTO submission_registry (research_object_id,research_object_version,archive,archive_pid_type,person,broker_submission_id)
     VALUES (1,2,'PANGAEA','DOI',2,'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11');

SELECT * FROM submission_registry;

UPDATE submission_registry
     SET archive_pid='10.1594/PANGAEA.843778', status='archived'
     WHERE research_object_id=1 AND archive='PANGAEA' AND broker_submission_id='a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11';

UPDATE submission_registry
     SET archive_pid='ACX092372', status='archived'
     WHERE research_object_id=1 AND archive='ENA' AND broker_submission_id='a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11';

SELECT * FROM submission_registry;
       
/***
* TEST CASE 2
***/

INSERT INTO research_object (label,type) VALUES ('s4','sample');
SELECT * FROM research_object;


INSERT INTO submission_registry (research_object_id,research_object_version,archive,archive_pid_type,person,broker_submission_id)
     VALUES (3,1,'ENA','ACCESSION',1,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95');
INSERT INTO submission_registry (research_object_id,research_object_version,archive,archive_pid_type,person,broker_submission_id)
     VALUES (3,1,'PANGAEA','DOI',2,'E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95');

SELECT * FROM submission_registry;

UPDATE research_object SET type='experiment' WHERE research_object_id=3;

UPDATE submission_registry
     SET archive_pid='10.24355/PANGAEA.927462', status='archived'
     WHERE research_object_id=3 AND archive='PANGAEA' AND broker_submission_id='E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95';

UPDATE submission_registry
     SET archive_pid='ARX05463', status='archived'
     WHERE research_object_id=3 AND archive='ENA' AND broker_submission_id='E7DAA13C-1AA7-40E7-AFCA-D0986F0AAC95';

SELECT * FROM submission_registry;

/***
* TEST CASE 3 - use function to add research object and get id back
***/
SELECT add_research_object('E1'::text,'experiment'::text);
SELECT * FROM research_object;
