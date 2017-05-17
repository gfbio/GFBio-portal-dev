<%@page import="org.gfbio.service.ResearchObjectLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<portlet:defineObjects />

 <h2>Your GfBio submissions</b2><br>
 
 <%long userID = PortalUtil.getUserId(request);%>
 <%if (userID==0){ %>
		
			<div class="portlet-msg-alert">
				Please sign in to explore your submissions.
			</div>
			<table><tr>
 <td>Dataset Name
 
 </td><td>Status
 </td></tr>
		<%}else { %>
		<%
						
						JSONArray  ResearchObjects = new JSONArray();
						ResearchObjects = null;
						try {
							ResearchObjects=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(userID);
							
						} catch (NoSuchModelException e) {
							e.printStackTrace();
						} catch (SystemException e) {
							e.printStackTrace();
						}%>
						<%if (ResearchObjects.size()>0){for (int i = 0; i < ResearchObjects.size(); i++) { 
        JSONObject responseJson = (JSONObject) ResearchObjects.get(i);
       %>
       <tr><td><%=responseJson.get("researchobjectname") %></td>
       <td><%= (String) ((JSONObject )ResearchObjects.get(i)).get("researchobjectversion")%></td> </tr>
						<%}}}%>
											
										
 
 <tr><td> 
 </td><td> 
 </td></tr>
 <tr><td> 
 </td><td> 
 </td></tr>
 </table>
