<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="tablebuildertablemenuURL" var="tablebuildertablemenuURL" />
<meta charset="UTF-8">



<%@ include file="/html/init.jsp" %> 																				
<%@ include file="/html/tablebuilder/init.jsp" %>
<%@ include file="/html/tablebuilder/tablemenu/init.jsp" %> 	 																	
<script src="${pageContext.request.contextPath}/js/main.js" 								type="text/javascript"></script>  	<!--  main.js  imports -->
<script src="${pageContext.request.contextPath}/js/tableBuilder/tableBuilder.js"    		type="text/javascript"></script>  	<!--  tableBuilder.js  imports -->
<script src="${pageContext.request.contextPath}/js/tableBuilder/tableBuilderTableMenu.js"   type="text/javascript"></script>  	<!--  tableBuilder.js  imports -->
<%-- <link href="<%= request.getContextPath() %>/css/main.css"	 rel="stylesheet" 		type="text/css"> 	 --%>				<!--  main.css imports -->

<input type="hidden" class="widthL" id="path"  						value="<%=request.getContextPath()%>" />
<input type="hidden" class="widthL" id="tablebuilderurl"  				value="<%=tablebuildertablemenuURL %>" />


<div id="tableMenu"></div>



<script>

	//
	AUI().ready(function(A){
		initiateTableMenu('tableMenu');
	});

</script>