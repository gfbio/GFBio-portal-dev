<%@page import="org.gfbio.service.ResearchObjectLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->


<portlet:defineObjects />

 Hello GFBio!!!!!!!!
 
 <%long userID = PortalUtil.getUserId(request);%>
 <%if (userID==0){ %>
		
			<div class="portlet-msg-alert">
				Please sign in to explore your submissions.
			</div>
			
<%}else { %>
<%JSONArray  ResearchObjects = new JSONArray();
	try{
ResearchObjects=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(userID);
}catch(Exception e){
 System.out.println("Error");
}%>
<a href="<portlet:renderURL><portlet:param name="view" value="/html/submissions/datasetinformation.jsp" />
</portlet:renderURL>" target="_blank">NewWindow</A>

    <portlet:renderURL var="other">
    <portlet:param name="jspPage" value="/html/submissions/datasetinformation.jsp"/>
     </portlet:renderURL>
      <a href="<%=other%>">click me</a>
      
<%if (ResearchObjects!=null && ResearchObjects.size()>0){%>
<h2>Your GfBio datasets</h2><br>
<table><tr>
<td>Dataset Name </td><td>Version</td><td>Status</td></tr>
<% for (int i = 0; i < ResearchObjects.size(); i++) { 
JSONObject responseJson = (JSONObject) ResearchObjects.get(i);%>
<tr><td><%=responseJson.get("researchobjectname") %> ++++<%=responseJson.get("researchobjectid") %> </td>
<td><%= (Integer) ((JSONObject )ResearchObjects.get(i)).get("researchobjectversion")%></td>

<td><%=responseJson.get("status") %></td> 
<td><button onclick="GetResearchObjectById()">Get details</button></td>
</tr>
<%}%>
</table> 
<%}}%>

<script>
function myFunction()
{}
function GetResearchObjectById()
{
Liferay.Service(
		  '/GFBioProject-portlet.researchobject/get-research-object-by-id',
		  {
		    requestJson: '[{"researchobjectid":1,"kindofresponse":"extended"}]'
		  },
		  function(obj) {
		    console.log(obj);
		  }
		);
/*var ajaxData = {"userid":data.userid};
	$.ajax({
	"type" : "POST",
	"url": url.concat('/WorkflowGenericPortlet'),
	"data" : {
		"<portlet:namespace />data" : JSON.stringify(ajaxData),
		"<portlet:namespace />responseTarget" : "getuserbyid"
	},
	async: false,
		success :  function (obj){
		document.getElementById("gwf_ro_author").innerHTML= obj.fullname;
		}
	});
*/
}

</script>

 
