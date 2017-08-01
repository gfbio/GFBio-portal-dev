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

<%--  <% 

	JSONObject requestJson = new JSONObject();
	requestJson.put("researchobjectid", 1);
	requestJson.put("kindofresponse", "extended");

	JSONObject  researchObject = new JSONObject();
    try{researchObject=(JSONObject)ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById(requestJson);
	}catch(Exception e){System.out.println("Error"+e.toString());}
    
    String extendDataString = (String) researchObject.get("extendeddata");
    JSONObject  extendData = new JSONObject();
    JSONParser parser = new JSONParser();
	try {extendData = (JSONObject) parser.parse(extendDataString);}
	catch (ParseException e) {e.printStackTrace();}
	Object[] extendDataKeySet = (extendData.keySet()).toArray();
    
    String firstcolum = "30%";
    String secoundcolum = "2%";
    String thirdcolum = "65%";
%>

<%= researchObject%><br>
<br>
<%= extendData%>

		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Title </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=researchObject.get("name") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Description </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=researchObject.get("description") %>	</span>
		</div >

		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Label </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=researchObject.get("label") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Version </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=researchObject.get("researchobjectversion") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Last modification date </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=researchObject.get("lastmodifieddate") %>	</span>
		</div >
		
		
		
		<!--  better for the extendedData is a loop over all key of extendedData, for example David sent us more extended data as only data collection time publications and embargo--> 
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Data collection time </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=extendData.get("datacollectiontime") %>	</span>
		</div >
		
		
		<hr>
		
		<%for (int i =0;i<extendDataKeySet.length;i++){ %>
			<% if (extendData.get(extendDataKeySet[i].toString())!=null){ %>
				<div 	  class='control-group'>
					<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	><%=extendDataKeySet[i].toString() %> </span>
					<span style='width:<%=secoundcolum %>; display:inline-block'></span>
					<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=extendData.get(extendDataKeySet[i].toString() ) %>	</span>
				</div >
			<%} %>
		<%} %>
		
		<hr>
		
		<!--  optional parameter and extended data-->
		<% if (extendData.get("embargo")!=null){ %>
			<div 	  class='control-group'>
				<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Embargo </span>
				<span style='width:<%=secoundcolum %>; display:inline-block'></span>
				<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=extendData.get("embargo") %>	</span>
			</div >
		<%} %>
		
		
		
		<!--  optional parameter and extended data-->
		
			<div 	  class='control-group'>
				<span style='width:<%=firstcolum %>; display:inline-block; font-weight:bold' class='field-description'	>Parental Dataset ID </span>
				<span style='width:<%=secoundcolum %>; display:inline-block'></span>
				<% if (researchObject.get("parentresearchobjectid")!=null){ %>
					<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	><%=researchObject.get("parentresearchobjectid") %>	</span>
				<%}else{ %> 
					<span style='width:<%=thirdcolum %>; display:inline-block' class='field-description'	>N/A	</span>
				<%} %>
			</div >
 --%>				
		
		





<script>



</script>