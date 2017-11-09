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
   - themes (Themes - component for web design)
   

# Installation Guide (in progress)

* Java version
* Eclipse version
* Ant version
* How to integrate the current development environment into eclipse?
* build.properties
* DB setup up
   
# FAQs   
* There was an issue of build version number, please add it here as QA.


# TO-DO
* Remove webcontent folder (it is enough to keep it in the portal-release repository).
* add license file
* describe gadgets, hooks, portlets, layouttpls and themes in more details
