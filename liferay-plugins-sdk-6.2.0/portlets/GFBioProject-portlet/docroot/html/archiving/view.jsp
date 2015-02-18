<input type='hidden' name='csrfmiddlewaretoken' value='HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C' />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%!RenderResponse renderResponse;%>


<jsp:useBean id="keyWords" class="java.lang.String" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />
<meta charset="UTF-8">



<%@include file="/html/archiving/init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  main.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->
 
 
 


 
<!---------------------------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------        Tabs        -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->



<body >

<%=request.getContextPath()%>
<%=themeDisplay.getUser().getDefaultUser()%>
<%=archivingURL%>

</body>










