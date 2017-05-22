<%@page import="org.gfbio.service.ResearchObjectLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<portlet:defineObjects />

 
 
 <%long userID = PortalUtil.getUserId(request);%>
 <%if (userID==0){ %>
		
			<div class="portlet-msg-alert">
				Please sign in to explore your submissions.
			</div>
			
<%}else { %>
<%JSONArray  ResearchObjects = new JSONArray();
ResearchObjects = null;
ResearchObjects=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(135812);%>
<%if (ResearchObjects.size()>0){%>
<h2>Your GfBio datasets</h2><br>
<table><tr>
<td>Dataset Name </td><td>Status </td></tr>
<% for (int i = 0; i < ResearchObjects.size(); i++) { 
JSONObject responseJson = (JSONObject) ResearchObjects.get(i);%>
<tr><td><%=responseJson.get("researchobjectname") %></td>
<td><%= (String) ((JSONObject )ResearchObjects.get(i)).get("researchobjectversion")%></td> </tr>
</table>
<%}}}%>

 
