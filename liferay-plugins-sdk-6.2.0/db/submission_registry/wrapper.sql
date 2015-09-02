BEGIN;

CREATE SCHEMA gfbio_subreg;
SET search_path=gfbio_subreg;

CREATE ROLE liferay_gfbio;
GRANT USAGE ON SCHEMA gfbio_subreg TO liferay_gfbio;

\echo '--- CREATE GFBIO TABLES ---\n'
\i ../create_gfbio_tables2.sql

\echo '--- CREATE GFBIO CONTENT  ---\n' 
\i ../create_gfbio_content2.sql

\echo '--- HELPER OBJECTS ---\n'
\i ./helper_objects.sql

\echo '---  SUBMISSION REGISTRY ---\n'
\i ./submission_registry.sql

\echo '--- TESTS ---\n'
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA gfbio_subreg TO liferay_gfbio;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA gfbio_subreg TO liferay_gfbio;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA gfbio_subreg TO liferay_gfbio;

SET LOCAL ROLE liferay_gfbio;
\i ./tests.sql

ROLLBACK;
