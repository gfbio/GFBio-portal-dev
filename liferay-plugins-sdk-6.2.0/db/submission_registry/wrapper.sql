BEGIN;

CREATE SCHEMA IF NOT EXISTS gfbio;
SET search_path=gfbio,public;

\echo '--- HELPER OBJECTS ---\n'
\i ./helper_objects.sql
\echo '---  SUBMISSION REGISTRY ---\n' 
\i ./submission_registry.sql
\echo '--- TESTS ---\n'
\i ./tests.sql

ROLLBACK;
