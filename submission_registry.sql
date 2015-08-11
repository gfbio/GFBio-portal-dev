-- DROP TABLE IF EXISTS submission_registry;


CREATE TYPE submission_status AS ENUM ('sent', 'archived');

--LOGIC: Contains one entry per research_object+archive combination.
CREATE TABLE submission_registry (
research_object_id bigint NOT NULL REFERENCES research_object (research_object_id),
research_object_version smallint NOT NULL,
archive text NOT NULL REFERENCES data_provider (label), --FOREIGN KEY
archive_pid text DEFAULT NULL,
archive_pid_type text DEFAULT NULL REFERENCES persistent_identifier (label), --FOREIGN KEY
broker_submission_id UUID NOT NULL,
--submission_data json NOT NULL, --NOT NULL
last_changed timestamp NOT NULL DEFAULT now(),
person smallint NOT NULL REFERENCES person (user_id) ON UPDATE CASCADE ON DELETE RESTRICT,
status submission_status NOT NULL DEFAULT 'sent',
is_public boolean NOT NULL DEFAULT FALSE,
public_after timestamp NOT NULL DEFAULT now() + interval '6 months',
PRIMARY KEY (research_object_id,research_object_version,archive)
--FOREIGN KEY (research_object_id,research_object_version) REFERENCES research_object (research_object_id,research_object_version) -- cannot use this because updates on object might come later
);
