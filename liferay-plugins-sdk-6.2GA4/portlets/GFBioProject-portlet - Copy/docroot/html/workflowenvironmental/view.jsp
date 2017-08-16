<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" 	prefix="portlet" %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="workflowenvironmentalURL" var="workflowenvironmentalURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> <!-- library imports -->
<%@ include file="/html/workflowenvironmental/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/js/main.js"       								type="text/javascript"></script>  <!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/workflowenvironmental.js"     				type="text/javascript"></script>  <!--  main.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" 					type="text/css"> <!-- main.css imports -->
	 
	 

	 
<%if (PortalUtil.getUser(request)!=null){ %>

	<input type="hidden" class="widthL" id="path"  						value="<%=request.getContextPath()%>" />
	<input type="hidden" class="widthL" id="workfloweinverionmentalurl"  	value="<%=workflowenvironmentalURL %>" />
	
	<input type="hidden" class="widthL" id="path"  						value="<%=request.getContextPath()%>" />
	<input type="hidden" class="widthL" id="workflowenvironmentalurl"  	value="<%=workflowenvironmentalURL %>" />
	
	<div id="environmental" class="projectportlet"></div>
	
	<div id="ewf_user_path" class="swHide">
		<%= getServletContext().getRealPath("/")%>
	</div>
	<br>

<%} %>	




	








