@echo on
set PGPASSWORD=test


"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_dataprovider.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_head.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_project.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_researchobject.sql


"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_basket.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_column.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_project_researchobject.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_project_user.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_dataprovider.sql


"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_content.sql


"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_category.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_externalperson.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_fundingagency.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_fundingprogram.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_institution.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_license.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_metadata.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_persistentidentifier.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_researchfield.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_type.sql


"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_dataprovider_persistentidentifiert.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_funding_institutionproject.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_funding_personproject.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_submission.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_category_dataprovider.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_category_project.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_category_researchfield.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_category_type.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_categoryparent.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_externalperson_researchobject.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_license_researchobject.sql
"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_fundingagency_fundingprogram.sql


"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  insert_gfbio_dataprovider_persistentidentifier.sql

"%PSQL_HOME%\psql.exe" -h localhost -U postgres -d gfbio -f  create_usersso.sql

pause