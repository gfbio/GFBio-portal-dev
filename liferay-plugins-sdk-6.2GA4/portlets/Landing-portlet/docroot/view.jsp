<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
 
%>

<%@ include file="/init.jsp" %>
<%
String searchTerm = portletPreferences.getValue("searchTerm", StringPool.BLANK);
		 
%>

<portlet:actionURL var="searchURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="search" />
</portlet:actionURL>

<portlet:actionURL var="facetEnvURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="facetEnvironment" />
</portlet:actionURL>

<section id="home-slider" style="height:100%"><!--<div class="col-xs-12 text-center abcen1 landing-flex">-->
<div class="container">
<div id ="landing-row" class="row" >

<div class="col-sm-4">

<img alt="" height="169" src="${gfbio_logo}" width="300" />


<h1 class="landing-h1" id="claim-header">FAIR - Research - Data </span></h1>
<span class="landing-h1-sub center-block">Biodiversity, Ecology &amp; Environmental Studies </span>
</div>

<div class="col-sm-8">
<div class="landing-boxes">

<div class="row">
<div class="landing-grey-headline">
Search & Visualization
</div>
</div>

<div class="row">
<div class="landing-search">
<!-- lfr-input-text-container  -->
<aui:form action="<%= searchURL %>" method="post" name="fm">
<div id="landing-input">
<aui:input label="" name="searchTerm" value="<%= searchTerm %>" placeholder="Search for organisms, data parameters or locations..."/>
</div>
<aui:button class="btn btn-primary icon-landing-flex" type="submit" value="search"/>
 <!-- icon="icon-search4" iconAlign="left"--> 
</aui:form>
</div>
</div>

<div class="row">
<div class="col-sm-4">
    <figure class="landing-figure">
<img alt="Environmental Data" class="landing-img" src="${env_img}" />
<figcaption class="landing-figcaption">

<aui:form action="<%= facetEnvURL %>" method="post" name="fm">
<h3>Environmental Data</h3>
<aui:button class="btn btn-primary icon-landing-flex" type="submit" value="search"/>
<!-- filter=[{"term"%3A{"dataCenterFacet"%3A"PANGAEA%3A Data Publisher for Earth %26 Environmental Science"}}] -->
</aui:form>
</figcaption>	
</figure>
</div>

<div class="col-sm-4">
  box2
</div>
<div class="col-sm-4">
  box3
</div>
</div>
</div>
</div>
</div>
</div>
</section>