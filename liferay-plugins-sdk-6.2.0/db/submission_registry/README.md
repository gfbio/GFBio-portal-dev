# wrapper.sql
Combines the files below for easier testing. By default, the wrapper does everything in a single transaction which is rolled back at the end of the execution, so no artefacts are left in the database. All objects are placed in a newly created schema - the execution is aborted if a schema with the same name already exists. In such a case, choose a new schema name in wrapper.sql.

The intended use for testing is:
psql -f wrapper.sql

You can execute any of the scripts below separately. However, be aware that they do not set the search path (this is done by the wrapper), so the database objects will be created in the schema defined by your current search path.

# helper_objects.sql
Database objects which are needed for testing the functionality of the Submission Registry. These are mostly mockups of tables developed elsewhere.

# submission_registry.sql
All definitions for the Submission Registry.

# tests.sql
Some rudimentary testing of functionality.
