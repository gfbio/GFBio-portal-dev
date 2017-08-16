<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="backtosubmissionmanagerURL" var="backtosubmissionmanagerURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> <!-- library imports -->
<%@ include file="/html/backtosuma/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/js/main.js"       								type="text/javascript"></script>  <!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/submissionManager.js"     					type="text/javascript"></script>  <!--  main.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css"				rel="stylesheet" 	type="text/css"> <!-- main.css imports -->
<link href="${pageContext.request.contextPath}/css/submissionManager.css" 	rel="stylesheet" 	type="text/css"> <!-- main.css imports -->


<body >
	<div id="backtosubmissionManager">
		<div style="height:100px; allgin:right">
			<div id="suma_backToSuMa"   class="button_back" onclick=" backToSuMa()">back to Submission Manager</div>
		</div>
	</div>
</body>
