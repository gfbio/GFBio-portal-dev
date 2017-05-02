# GFBio-portal-dev
This is the main development repository for GFBio Portal. The master branch is reserved for the release. We keep track of all the contents/tools/application that are presented on our GFBio Portal. 
   - DataLifeCycle_SVG : contains .html and .svg scripts for the visualisation of data cycle.
   - Liferay7 : is a new version of Liferay portal. We need to separate it from the current development, since there are a lot of differences.
   - liferay-plugins-sdk-6.2GA4 : the current working repository. Most of the changes related to the portal (besides the web content) must be changed here.
   - WebContent : contains the latest web content. 
   
## liferay-plugins-sdk-6.2GA4
Implemented codes must be kept here. Each type of codes are differentiated by the function and purpose.
   - db
   - gadgets
   - hooks
   - layouttpl
   - portlets
   - themes

# TO-DO
* Revise this readme, add more general information.
* Remove webcontent folder.
* There was an issue of build version number, please add it here as QA.
