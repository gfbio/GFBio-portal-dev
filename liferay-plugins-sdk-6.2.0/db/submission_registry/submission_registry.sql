-- DROP TABLE IF EXISTS submission_registry;


CREATE TYPE submission_status AS ENUM ('sent', 'archived');

--LOGIC: Contains one entry per research_object+archive combination.
CREATE TABLE submission_registry (
research_object_id bigint NOT NULL REFERENCES gfbio_researchobject (researchobjectId),
research_object_version smallint NOT NULL,
archive text NOT NULL REFERENCES data_provider (label), --FOREIGN KEY
archive_pid text DEFAULT NULL,
archive_pid_type bigint DEFAULT NULL REFERENCES gfbio_content (contentid), --FOREIGN KEY
broker_submission_id UUID NOT NULL,
--submission_data json NOT NULL, --NOT NULL
last_changed timestamp NOT NULL DEFAULT now(),
person smallint NOT NULL REFERENCES person (user_id) ON UPDATE CASCADE ON DELETE RESTRICT,
status submission_status NOT NULL DEFAULT 'sent',
is_public boolean NOT NULL DEFAULT FALSE,
public_after timestamp NOT NULL DEFAULT now() + interval '6 months',
PRIMARY KEY (research_object_id,research_object_version,archive),
UNIQUE (research_object_id,archive,archive_pid)
);


CREATE OR REPLACE VIEW latest_submissions AS
SELECT * FROM (
       SELECT *,
       	      rank() OVER (PARTITION BY research_object_id,archive ORDER BY research_object_version DESC) AS pos
       FROM submission_registry) AS iq
       WHERE pos=1
;

CREATE OR REPLACE FUNCTION get_submission_history(roid bigint) RETURNS SETOF submission_registry AS $$
   BEGIN
       RETURN QUERY SELECT * FROM submission_registry WHERE research_object_id=roid;
       RETURN;
   END;
$$ LANGUAGE plpgsql;
