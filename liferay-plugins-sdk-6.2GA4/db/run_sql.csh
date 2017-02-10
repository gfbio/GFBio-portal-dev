#!/bin/bash 

command='/Library/PostgreSQL/9.4/bin/psql -h localhost -p 5432 -U liferay_gfbio -d gfbio -a -f'

export PGPASSWORD=$command 1

# Reihenfolge beachten
   

$command create_dataprovider.sql
$command create_head.sql
$command create_primarydata.sql
$command create_project.sql
$command create_researchobject.sql


$command create_basket.sql
$command create_column.sql
$command create_primarydata_researchobject.sql
$command create_project_researchobject.sql
$command create_project_user.sql
$command create_researchobject_user.sql
$command create_usersso.sql
$command insert_gfbio_dataprovider.sql


$command create_content.sql


$command insert_gfbio_category.sql
$command insert_gfbio_externalperson.sql
$command insert_gfbio_fundingagency.sql
$command insert_gfbio_fundingprogram.sql
$command insert_gfbio_institution.sql
$command insert_gfbio_license.sql
$command insert_gfbio_metadata.sql
$command insert_gfbio_persistentidentifier.sql
$command insert_gfbio_researchfield.sql
$command insert_gfbio_type.sql


$command create_dataprovider_persistentidentifiert.sql
$command create_funding_institutionproject.sql
$command create_funding_personproject.sql
$command create_submission.sql
$command insert_gfbio_category_dataprovider.sql
$command insert_gfbio_category_project.sql
$command insert_gfbio_category_researchobject.sql
$command insert_gfbio_category_type.sql
$command insert_gfbio_categoryparent.sql
$command insert_gfbio_externalperson_researchobject.sql
$command insert_gfbio_fundingagency_fundingprogram.sql


$command insert_gfbio_dataprovider_persistentidentifier.sql
