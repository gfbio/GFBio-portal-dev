#!/bin/bash 

command='/Library/PostgreSQL/9.4/bin/psql -h localhost -p 5432 -U liferay_gfbio -d gfbio -a -f'

export PGPASSWORD=$1

# Reihenfolge beachten
   
$command create_head.sql
$command create_column.sql
$command create_content.sql
$command create_basket.sql
$command create_dataprovider.sql
$command create_project.sql
$command create_researchobject.sql
$command create_submission.sql
$command create_project_researchobject.sql
$command create_project_user.sql
$command create_dataprovider_persistentidentifiert.sql


$command insert_gfbio_category_type.sql
$command insert_gfbio_category.sql
$command insert_gfbio_category_dataprovider.sql
$command insert_gfbio_category_researchfield.sql
$command insert_gfbio_dataprovider.sql
$command insert_gfbio_persistentidentifier.sql
$command insert_gfbio_researchfield.sql
$command insert_gfbio_type.sql
$command insert_gfbio_dataprovider_persistentidentifier.sql

$command change_categories_2.sql
