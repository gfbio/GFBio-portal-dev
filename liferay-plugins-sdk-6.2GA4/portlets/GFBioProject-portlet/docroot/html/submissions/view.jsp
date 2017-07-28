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
<td><button onclick="GetResearchObjectById(<%=responseJson.get("researchobjectid") %>)">Get details</button></td>
</tr>
<%}%>
</table> 
<%}}%>
<Div ID="SubmissionInfo"></Div>

<script>

function GetResearchObjectById(researchobjectid)
{

	var requestJson = {"researchobjectid":researchobjectid,"kindofresponse":"extended"};
	console.log(requestJson);
	var requestArray = [requestJson];
	console.log(requestArray);
	
	;
	Liferay.Service(
			  '/GFBioProject-portlet.researchobject/get-research-object-by-id',
			  {
			    requestJson: JSON.stringify(requestArray)
			  },
			  function (obj)
			  {console.log("Before calling");
				  console.log(obj[0]);
				  buildDatasetInformation ();
				buildDatasetInformation (obj[0]);
			    
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

function buildDatasetInformation()
{console.log("Empty test");}

function buildDatasetInformation(researchObjectInformation)
{
	console.log("test");
    console.log(researchObjectInformation);

	    var firstcolum = "30%";
	    var secoundcolum = "2%";
	    var thirdcolum = "65%";
	    var div =   $("#SubmissionInfo");
	    div.Empty();
	    div.append(
	    	"<div 	  class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description'	>Title </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"span style='width:"+thirdcolum+ "; display:inline-block' class='field-description'	>"+researchObjectInformation.name+ "</span>"+
				"</div >"
	    );
	    console.log(div);
<%-- 		
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Description </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("description") %>	</span>
		</div >

		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Label </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("label") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Version </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'
> <%=researchObject.get("researchobjectversion") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Last modification date </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("lastmodifieddate") %>
</span>
		</div >
		
		
		
		<!--  better for the extendedData is a loop over all key of
extendedData, for example David sent us more extended data as only data
collection time publications and embargo-->
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Data collection time </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=extendData.get("datacollectiontime") %>
</span>
		</div >
		
		
		<hr>
		
		<%for (int i =0;i<extendDataKeySet.length;i++){ %>
			<% if (extendData.get(extendDataKeySet[i].toString())!=null){ %>
				<div 	  class='control-group'>
					<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'
> <%=extendDataKeySet[i].toString() %> </span>
					<span style='width:<%=secoundcolum %>; display:inline-block'></span>
					<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'
> <%=extendData.get(extendDataKeySet[i].toString() ) %>	</span>
				</div >
			<%} %>
		<%} %>
		
		<hr>
		
		<!--  optional parameter and extended data-->
		<% if (extendData.get("embargo")!=null){ %>
			<div 	  class='control-group'>
				<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Embargo </span>
				<span style='width:<%=secoundcolum %>; display:inline-block'></span>
				<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=extendData.get("embargo") %>	</span>
			</div >
		<%} %>
		
		
		
		<!--  optional parameter and extended data-->
		
			<div 	  class='control-group'>
				<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Parental Dataset ID </span>
				<span style='width:<%=secoundcolum %>; display:inline-block'></span>
				<% if (researchObject.get("parentresearchobjectid")!=null){ %>
					<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'
> <%=researchObject.get("parentresearchobjectid") %>	</span>
				<%}else{ %>
					<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	>N/A	</span>
				<%} %>
			</div >

*/ --%>
}
</script>

 
