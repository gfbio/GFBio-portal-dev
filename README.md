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

* Java version
* Eclipse version
* Ant version
* How to integrate the current development environment into eclipse?
* liferay server
* build.properties in sdk folder
* DB setup up
* build services
* deploy

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
