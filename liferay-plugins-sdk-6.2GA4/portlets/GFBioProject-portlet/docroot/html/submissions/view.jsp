<%@ page import="org.gfbio.service.ResearchObjectLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<portlet:defineObjects />



<%long userID = PortalUtil.getUserId(request); %>
<%if (userID==0){ %>

			<div class="portlet-msg-alert">
				Please sign in to explore your submissions.
			</div>

<%}else { %>
<%JSONArray ResearchObjects = new JSONArray();
	try{
ResearchObjects=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(userID);
}catch(Exception e) {
System.out.println("Error");
} %>


<%if (ResearchObjects!=null && ResearchObjects.size()>0){ %>
<h2>Your GfBio datasets</h2><br>
<table><tr>
<td>Dataset Name </td><td>Version</td><td>Status</td></tr>
<% for (int i = 0; i < ResearchObjects.size(); i++) {
JSONObject responseJson = (JSONObject) ResearchObjects.get(i); %>
<tr><td><%= responseJson.get("researchobjectname") %> <%= responseJson.get("researchobjectid") %> </td>
<td><%= (Integer) ((JSONObject )ResearchObjects.get(i)).get("researchobjectversion") %></td>

<td><%= responseJson.get("status") %></td>
<td><button onclick="GetResearchObjectById(<%= responseJson.get("researchobjectid") %>)">Get details</button></td>
</tr>
<%} %>
</table>
<%}} %>
<Div ID="SubmissionInfo"></Div>

<div id="tabs" class="container">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">DataSet</li>
		<li class="tab-link" data-tab="tab-2">Project</li>
		<li class="tab-link" data-tab="tab-3">Submissions</li>
		<li class="tab-link" data-tab="tab-4">License</li>
	</ul>

	<div id="tab-1" class="tab-content current">
	</div>
	<div id="tab-2" class="tab-content">
	</div>
	<div id="tab-3" class="tab-content">
	</div>
	<div id="tab-4" class="tab-content">
	</div>

</div><!-- container -->
<Div></Div>
<Div></Div>
<Div></Div>
<script>

	function GetResearchObjectById(researchobjectid)
	{

		var requestJson = {"researchobjectid":researchobjectid,"kindofresponse":"extended"};
		console.log(requestJson);
		var requestArray = [requestJson];
		console.log(requestArray);

		
		Liferay.Service(
				'/GFBioProject-portlet.researchobject/get-research-object-by-id',{
					requestJson: JSON.stringify(requestArray)
				},
				function(obj) {
					var response = obj[0];
					console.log(response);
					buildDatasetInformation (response);
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
				success : function(obj) {
				document.getElementById("gwf_ro_author").innerHTML= obj.fullname;
				}
			});
		*/
	}

	function buildDatasetInformation(researchObjectInformation)
	{
		//var div = $("#tabs");
		//[div].visible = true;
		//var elem = document.getElementById('tabs');
		//elem.style.visibility = 'visible';
		console.log(researchObjectInformation);
		var firstcolum = "30%";
	    var secoundcolum = "2%";
	    var thirdcolum = "65%";
	    
	    var extdata = researchObjectInformation.extendeddata;
	    console.log(extdata);
	   // var div = $("#SubmissionInfo");
	    var div = $("#tab-1");
	    div.empty();
	    div.append(
	    	//"<h3>Dataset Information</h3>"+
	    	"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Title </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.name+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Description </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.description+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Label </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.label+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Version </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.researchobjectversion+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Data Collection Time </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+extdata.datacollectiontime+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Last Modified Date</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.lastmodifieddate+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Embargo Time </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+extdata.embargo+ "</span>"+
				"</div >"+
				// Extended
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Publications </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+extdata.publications+ "</span>"+
				"</div >"+
				//license
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >License Label </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.licenselabel+ "</span>"+
				"</div >"
			
	    );
	    
	    var div = $("#tab-2");
	    div.empty();
	    div.append(
	    	
	    	"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Title </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.name+ "</span>"+
				"</div >"
				
				
			
			
	    );
	    
	    
	    

	}
	
	$(document).ready(function(){
		
		$('ul.tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		})

	})
<%--
		</div >

		<div class="control-group">
			<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Description </span>
			<span style="width:<%= secoundcolum %>; display:inline-block"></span>
			<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description' ><%= researchObject.get("description") %> </span>
		</div >

		<div class="control-group">
			<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Label </span>
			<span style="width:<%= secoundcolum %>; display:inline-block"></span>
			<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description' ><%= researchObject.get("label") %> </span>
		</div >

		<div class="control-group">
			<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Version </span>
			<span style="width:<%= secoundcolum %>; display:inline-block"></span>
			<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description'
> <%= researchObject.get("researchobjectversion") %> </span>
		</div >

		<div class="control-group">
			<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Last modification date </span>
			<span style="width:<%= secoundcolum %>; display:inline-block"></span>
			<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description' ><%= researchObject.get("lastmodifieddate") %>
</span>
		</div >


		<!-- better for the extendedData is a loop over all key of
extendedData, for example David sent us more extended data as only data
collection time publications and embargo-->
		<div class="control-group">
			<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Data collection time </span>
			<span style="width:<%= secoundcolum %>; display:inline-block"></span>
			<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description' ><%= extendData.get("datacollectiontime") %>
</span>
		</div >

		<hr>

		<%for (int i =0;i<extendDataKeySet.length;i++){ %>
			<% if (extendData.get(extendDataKeySet[i].toString())!=null){ %>
				<div class="control-group">
					<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'
> <%= extendDataKeySet[i].toString() %> </span>
					<span style="width:<%= secoundcolum %>; display:inline-block"></span>
					<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description'
> <%= extendData.get(extendDataKeySet[i].toString() ) %> </span>
				</div >
			<%} %>
		<%} %>

		<hr>

		<!-- optional parameter and extended data-->
		<% if (extendData.get("embargo")!=null){ %>
			<div class="control-group">
				<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Embargo </span>
				<span style="width:<%= secoundcolum %>; display:inline-block"></span>
				<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description' ><%= extendData.get("embargo") %> </span>
			</div >
		<%} %>


		<!-- optional parameter and extended data-->

			<div class="control-group">
				<span style='width:<%= firstcolum %>; display:inline-block;
font-weight:bold' class='field-description' >Parental Dataset ID </span>
				<span style="width:<%= secoundcolum %>; display:inline-block"></span>
				<% if (researchObject.get("parentresearchobjectid")!=null){ %>
					<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description'
> <%= researchObject.get("parentresearchobjectid") %> </span>
				<%}else { %>
					<span style='width:<%= thirdcolum %>; display:inline-block'
class='field-description' >N/A </span>
				<%} %>
			</div >

*/ --%>

</script>
<style>
body{
			margin-top: 100px;
			font-family: 'Trebuchet MS', serif;
			line-height: 1.6
		}
		.container{
			width: 800px;
			margin: 0 auto;
		}

		ul.tabs{
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		ul.tabs li{
			background: none;
			color: #222;
			display: inline-block;
			padding: 10px 15px;
			cursor: pointer;
		}

		ul.tabs li.current{
			background: #ededed;
			color: #222;
		}

		.tab-content{
			display: none;
			background: #ededed;
			padding: 15px;
		}

		.tab-content.current{
			display: inherit;
		}

</style>