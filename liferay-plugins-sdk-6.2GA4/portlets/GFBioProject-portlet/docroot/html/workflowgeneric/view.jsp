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

 
  

<%if (PortalUtil.getUser(request)==null){ %>
	<div class="portlet-msg-alert">
		Only logged in users get access to the different submission workflows. Please <a href="<%=PortalUtil.getPortalURL(request) %>/sign-in?saveLastPath=0"><span style="color:#006400; font-weight:bold">sign in</span></a> to continue the process. 
	</div>


<%} else{%>

	<input type="hidden" class="widthL" id="path"  					value="<%=request.getContextPath()%>" />
	<input type="hidden" class="widthL" id="workflowgenericurl"  	value="<%=workflowgenericURL %>" />
<br>

	<%
		PortletSession ps = renderRequest.getPortletSession();
		String dataCenter = (String)ps.getAttribute("dataCenter",PortletSession.APPLICATION_SCOPE);
		String possibleDataCenter = (String)ps.getAttribute("possibleDataCenter",PortletSession.APPLICATION_SCOPE);
		
		//session muss dann noch sauber gemacht werden bei request submission und reset information
		
		JSONObject dcrtInput = new JSONObject();
		if (dataCenter!=null)
			if (!dataCenter.equals("")){
				if ((String)ps.getAttribute("physical",PortletSession.APPLICATION_SCOPE)!=null)
					dcrtInput.put("physical", (String)ps.getAttribute("physical",PortletSession.APPLICATION_SCOPE));
				
				if ((String)ps.getAttribute("taxon",PortletSession.APPLICATION_SCOPE)!=null)
					dcrtInput.put("taxon", (String)ps.getAttribute("taxon",PortletSession.APPLICATION_SCOPE));
				
				if ((String)ps.getAttribute("alive",PortletSession.APPLICATION_SCOPE)!=null)
					dcrtInput.put("alive", (String)ps.getAttribute("alive",PortletSession.APPLICATION_SCOPE));
				
				if ((String)ps.getAttribute("sequenced",PortletSession.APPLICATION_SCOPE)!=null)
					dcrtInput.put("sequenced", (String)ps.getAttribute("sequenced",PortletSession.APPLICATION_SCOPE));
				
				if (!((String)ps.getAttribute("category",PortletSession.APPLICATION_SCOPE)).equals("default"))
					dcrtInput.put("category", ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById(Long.parseLong((String)ps.getAttribute("category",PortletSession.APPLICATION_SCOPE))),"name"));	
	
				if (!((String)ps.getAttribute("material",PortletSession.APPLICATION_SCOPE)).equals("default"))
					dcrtInput.put("material", ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById(Long.parseLong((String)ps.getAttribute("material",PortletSession.APPLICATION_SCOPE))),"name"));
			}
		
		
	%>

	<div id="generic"></div>
	<div id="gwf_dcrtassignee" 			class="swHide"><%=dataCenter %></div>
	<div id="gwf_dcrtinput" 			class="swHide"><%=dcrtInput %></div>
	<div id="gwf_dcrtrecommendation" 	class="swHide"><%=possibleDataCenter %></div>
		
	<div id="gwf_user_path" class="swHide">
		<%= getServletContext().getRealPath("/")%>
	</div>

	<br>

<%} %>	

