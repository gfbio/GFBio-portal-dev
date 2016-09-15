<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" 	prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="workflowgenericURL" var="workflowgenericURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> <!-- library imports -->
<%@ include file="/html/workflowgeneric/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/js/main.js"       				type="text/javascript"></script>  <!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/workflowgeneric.js"     	type="text/javascript"></script>  <!--  main.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" 	type="text/css"> <!-- main.css imports -->

<%if (PortalUtil.getUser(request)!=null){ %>

	<input type="hidden" class="widthL" id="path"  					value="<%=request.getContextPath()%>" />
	<input type="hidden" class="widthL" id="workflowgenericurl"  	value="<%=workflowgenericURL %>" />

	<div id="generic"></div>
	
	<div id="gwf_user_path" class="swHide">
		<%= getServletContext().getRealPath("/")%>
	</div>
	<br>

<%} %>	