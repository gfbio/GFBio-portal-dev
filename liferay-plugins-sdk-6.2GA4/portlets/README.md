# Portlets of GFBio

All non liferay default or plugin portlets are stored in the portlets folder.

## GFBioProject portlet

The GFBioProject portlet is the container of the most GFBio portlets which have a relation to the GFBio database. 

### relation to the database (service builder)

Liferay provide the service builder. With this useful tool you can create easy a powerful connection to your database and build web services (for more information, please read the liferay documentation. Over the table builder the GFBioProject portlet has the main part of our relations to the database.

### portlets

#### Data Center Recommendation Tool (DCRT)
**Displayed Name:** Data Center Recommendation Tool
**Portlet Name:** dcrt
**Status:** public
**Description:** This portlet support the user, to find suitable data centers / archives for his data.

#### Data Managment Planing Tool (DMPT)
**Displayed Name:** Data Managment Planing Tool
**Portlet Name:** dmpt
**Status: ** work in process
**Description:** This portlet support the user, to create a Data Management Plan.

#### Data Provider Management
**Displayed Name:** Data Provider Management
**Portlet Name:** dataprovidermanagement
**Status: ** work in process
**Description:** The target of this is a graphical interface for the data provider information in our database. Some tools, like the DCRT, use data provider related information from the database to there processes. This information may change over time. For example, a data center can get a new focus or expertise in a research field. The data provider related information are in normal tables and in the head column content system. So the user can't use the table builder to to adjust all of this information. The solution is this specific portlet.

#### Submission Dashboard
**Displayed Name:** Submissions
**Portlet Name:** submissions
**Status: ** prototype
**Description:** This portlet show the status and information to the submissions of a user and show advanced information like details to the selected licenses.

#### Submission Workflow of Generic Data
**Displayed Name:** Workflow Generic
**Portlet Name:** workflowgeneric
**Status: ** public
**Description:** The submission form of the generic workflow is implemented in this portlet. The generic workflow includes the way to sent submission information to the GFBio JIRA and so to the curators of our collections and data center. The information will be stored in our database too. So it is possible to have an overview with the submission dashboard portal.

#### Submission Workflow of Molecular Data
**Displayed Name:** Workflow ENA
**Portlet Name:** workflowena
**Status: ** public
**Description:** The submission form of the molecular workflow is implemented in this portlet. This portlet is the border of the code library (css and java script) from our partners.

#### Table Builder
**Displayed Name:** Table Builder
**Portlet Name:** tablebuilder
**Status: ** work in process
**Description:** The target of this is a graphical interface for the head column content system of our gfbio database. So you can create, manipulate, connect, delete and fill the head column content tables.

### web services
As a part of the liferay service builder, we integrated web services in the GFBioProject portlet. The web services are divided to Basket, Project, ResearchObject, Submission UserExtention and UserSSO.
