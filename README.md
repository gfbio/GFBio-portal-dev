# GFBio-portal-dev
This is the source code repository for the GFBio Portal. 

## Branches
The following branches are active and recommended:

* master branch (all code that is released on gfbio.org)
* development (main development branch for new features)

All other branches are either feature branches or branches for specific releases. 

## Structure
   - DataLifeCycle_SVG : contains .html and .svg scripts for the visualisation of the data cycle (https://www.gfbio.org/training/materials/data-lifecycle).
   - Liferay7 : new 7.0 version of Liferay portal. We need to separate it from the current development since the build management is completely different.
   - liferay-plugins-sdk-6.2GA4 : the current working repository in Liferay's sdk environment (see separated section below)
   
## liferay-plugins-sdk-6.2GA4
This is the active development environment. Each type of code is differentiated by function and purpose.
   - db (Database changes)
   - gadgets (Gadgets/Widgets)
   - hooks (overwriting Liferay's default behaviour)
   - layouttpl (Layout Templates)
   - portlets (Portlets)
   - themes (Themes - main component for web design)
   

## Installation Guide (in progress)

###Software:
* **Java version:** Liferay 6.2 GA 4 don't support Java versions higher as 1.7. So, the current JDK is 1.7.80
* **IDE:** Liferay IDE Eclipse 2.2.4 ga5 
* **SDK:** Liferay Plugins SDK 6.2 ce ga4 (part of the GIT)
* **Liferay Server Bundle:**  Liferay portal tomcat 6.2 ce ga4
* **Data base:** PostgreSQL 9.3
* **Data base Managment System:** PGAdmin 3
* **Usual used OS Software:** Windows 7

### Initialisation
* Clone the GIT repository (for example to GFBio-portal-dev)
* Unpack the server bundle and IDE in this folder.
* Create a build.[operating-system-login-name].properties file in the SDK folder.
* write in this file:
```
#Managed by Liferay IDE (remove this comment to prevent future updates)
 #Wed Jan 06 11:00:17 CET 2016
 app.server.tomcat.lib.global.dir = [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42\\lib\\ext
 app.server.tomcat.deploy.dir =     [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42\\webapps
 app.server.parent.dir =            [path to folder]\\[repository folder name]\\[server bundle folder name]
 app.server.tomcat.dir =            [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42
 app.server.type = tomcat
 app.server.tomcat.portal.dir =     [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42\\webapps\\ROOT
 app.server.lib.global.dir =        [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42\\lib\\ext
 app.server.deploy.dir =            [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42\\webapps
 app.server.dir =                   [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42
 app.server.portal.dir =            [path to folder]\\[repository folder name]\\[server bundle folder name]\\tomcat-7.0.42\\webapps\\ROOT
```
* The IDE and the server bundle folders and the properties file have to be in the ignore list of the GIT

### IDE and Server
* Start the IDE/eclipse.
* Build a new workspace folder and switch to Liferay view.
  * If you would the workspace folder in your repository folder name, then add the workflow folder to your GIT ignore list. 
* Switch to the Liferay view of the Eclipse.
  * Build new server:
  * Go to File / New / Other / Server / Server. OR create a new server in the server tab.
  * Choose Liferay, Inc / Liferay v6.2 CE Server (Tomcat 7).
  * Choose by Server runtime environment: Liferay v.6.2 (Tomcat) GA4 or go to Add. Choose the correctTomcat directory ([repository folder name]\[server bundle folder name]\tomcat-7.0.42) and select jre7 as runtime JRE
  * !!! eclipse-mars IDE and higher requires Java 8 as Server runtime environment !!!


  
###Database integration
* GFBio use two databases. The liferay database for user management and the gfbio portal database for gfbio specific applications
* Create a portal-ext.properties file in the liferay-portal-6.2-ce-ga4 folder
```
 ############# Database #########################
 jdbc.default.driverClassName=org.postgresql.Driver
 jdbc.default.url=jdbc:postgresql://localhost:5432/lportal
 jdbc.default.username=gfbiodb
 jdbc.default.password=test
 jdbc.gfbio.username=gfbiodb
 jdbc.gfbio.password=test
 jdbc.gfbio.driverClassName=org.postgresql.Driver
 jdbc.gfbio.url=jdbc:postgresql://localhost:5432/gfbio?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
```
* If you change the database passwords, then you have to change the passwords in this file too

* Start the created server in the IDE.
* Answer the database question, so that the system build a PostgreSQL 9.3 database on localhost 5432.
* Start PGAdmin.
* Go to server PostgreSQL 9.3 (localhost: 5432).
* Create new login rolle with
  * **name:** gfbiodb,
  * **password:** test,
  * **Role privileges:** Can login, Inherits rights from parent roles, Superuser, Can create databases, Can modify catalog directly.
* Add new database (use the SQL option in task menu):
```
 CREATE DATABASE gfbio
 WITH OWNER = gfbiodb
      ENCODING = 'UTF8'
      TABLESPACE = pg_default
      LC_COLLATE = 'German_Germany.1252'
      LC_CTYPE = 'German_Germany.1252'
      CONNECTION LIMIT = -1;
```

* build a environmental variable 'PSQL_HOME' for the [..]\PostgreSQL\9.3\bin\ folder
* Start run_sql.cmd (windows) or run_sql.csh (Linux/Unix) to create the database tables or start the sql files individualy.
  * All this files are in [path to folder] / [repository folder name] / [sdk folder] / db.

* Liferay use automatic generate classes and services for the relations between database and Portal-Applications/APIs. This services are integrated in the GFBioProject-portlet. To use this services, you have to build the services (right click on GFBioProject-portlet / Liferay / Build Services)


## Contributing
Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors
* Felicitas Löffler
* Marcel Frömming
* Kobkaew Opasjumruskit

See also the list of [contributors](https://github.com/gfbio/GFBio-portal-dev/contributors) who participated in this project.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Live System
[dev.gfbio.org](https://dev.gfbio.org)

## FAQs   
This section describes known problems and frequent issues occuring during development.

### Error: build version number

Description: Each portlet has a service.properties file that will be updated at each deployment time. Instead of overwriting the existing file you should create a service-ext.properties file.

1.) stop you liferay server

2.) remove all deployed portlet code (e.g., GFBio-project-portlet) from your 'liferay/tomcat/webapps' folder and your 'liferay/tomcat/temp' folder

3.) go to your local liferay database and remove all entries in table 'servicecomponent' that have the build namespace 'gfbio'

(DELETE FROM servicecomponent where buildnamespace='gfbio')

4.) create a service-ext.properties file in your docroot/WEB-INF/src folder and add the following line:

build.number=1

5.) open your eclipse, clean your project, build services and deploy the code

6.) start your liferay server again

7.) have a look into the database, table 'servicecomponent', you are supposed to see a new entry with build space number 1


## TO-DO
* Remove webcontent folder (it is enough to keep it in the portal-release repository).
* add license file
* describe gadgets, hooks, portlets, layouttpls and themes in more details
