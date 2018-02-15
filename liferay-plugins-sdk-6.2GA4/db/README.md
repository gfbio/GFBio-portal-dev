# GFBio-portal-dev

## files
There are three parts in this folder. 
The **run_sql.csh** for Linux (or the **.cmd** for Windows) has a script to start the **create/function/insert_[tablename].sql** files in a specific sequence, to build the database and the important content of this. The created database will has the status of the last release.
The **create sql files** create new database tables. Sometimes we need specific information for some of the portlets. Then this content will be a fix part in the scripts. This scripts are in the **insert sql files**. Mainly in the head column context system  context we need some support scripts. This scripts are in the **function sql files**.
The current changes made during development are in the **release_new** file. If you run the run_sql and then the release_new then you have the most current status of the database structure. After a release, we integrate the changes of release_new to the create/function/insert sql files and are adjusting the run_sql.

## head column content (hcc)
In the database, there are many small tables with specific expert knowledge. The most of this tables is saved over the head column content system. There are three tables, the gfbio_head, the gfbio_coumn and the gfbio_content. The gfbio_head stores the basic information about tables, like name. The gfbio_column stores the information about the columns of the tables of gfbio_head. And the gfbio_content stores the cell content of the tables of gfbio_head. With the functions of the GFBioProject portlet you get the complete structured information of this hcc tables.

## entities

### gfbio_basket
This table is a support table for the Visualization, Aggregation & Transformation Tool (VAT).

### gfbio_category (hcc)
This table we store keywords for some tools. The most of this keywords have a biological background, like 'Ecology'. This table have a strong relation to 'gfbio_type'.

### gfbio_column
This table is a part of the head column content system.

### gfbio_content
This table is a part of the head column content system.

### gfbio_datamanagmentplan
This table is a support table for the Data Management Planing Tool (DMPT).

### gfbio_dataprovider
This table stores the information about our data center and archives.

### gfbio_externalperson (hcc)
In this table we store non user persons, that are related with GFBio. For example authors of a dataset or contact persons of an archive. A user can be a user and an external person to the same time.

### gfbio_fundingagency (hcc)
In this table we store information of funding agencies, that are related with the GFBio context. For example via DMP Tool.

### gfbio_fundingprogram (hcc)
In this table we store information of funding programs, that are related with the GFBio context. For example via DMP Tool.

### gfbio_head
This table is a part of the head column content system.

### gfbio_institution (hcc)
In this table we store information of institutions, that are related with GFBio as partner or from the user.

### gfbio_legalrequirement (hcc)
In this table we store information about the legal requirement, that we use in GFBio. 

### gfbio_license (hcc)
In this table we store information about the licenses, that we use in GFBio.

### gfbio_metadata (hcc)
In this table we store information about the metadata, that we use in GFBio. 

### gfbio_persistentidentifier (hcc)
In this table we store the information about persistent identifier, that our archives/datacenter use.

### gfbio_policy (hcc)
In this table we store information about the policies, that we use in GFBio. 

### gfbio_primarydata
In this table we stored the information where the research object related files are stored.

### gfbio_project
This table stored the main information of projects. So it's connected to other tables to describe the project further.

### gfbio_researchobject
This table stored the main information of research objects, like the datasets by a submission. So it's connected to other tables to describe the object further.

### gfbio_submission
If a research object will be submitted, we stored the information which research object goes to which archive/datacenter and has what identifier and status by this process.

### gfbio_type (hcc)
The types of this table specify the categories of 'gfbio_category'.

### gfbio_usersso
This table is a support table for the Singe Sign On (SSO).