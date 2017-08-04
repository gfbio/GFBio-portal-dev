<%@ page import="org.gfbio.service.ResearchObjectLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="submissiondashboardURL" var="submissiondashboardURL" />
<meta charset="UTF-8">

	<input type="hidden" class="widthL" id="submissiondashboardurl"  	value="<%=submissiondashboardURL %>" />



<%long userID = PortalUtil.getUserId(request); %>
<%if (userID==0){ %>

			<div class="portlet-msg-alert">
				Please sign in to explore your submissions.
			</div>

<%}else { %>
<%JSONArray ResearchObjects = new JSONArray();
try
{ResearchObjects=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(userID);
}catch(Exception e)
	{
System.out.println("Error");
	} %>


<%if (ResearchObjects!=null && ResearchObjects.size()>0){ %>
  <div "ID=datasets" style='width:100%'>
  <h2>Your GfBio datasets</h2><br>
  <div style='width:100%'>
  	<span style='width:60% ; display:inline-block; font-weight:bold' class='field-description' >DataSet name</span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:12% ; display:inline-block; font-weight:bold' class='field-description' >Status</span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:23% ; display:inline-block; font-weight:bold' class='field-description' ></span>
  </div>
<% for (int i = 0; i < ResearchObjects.size(); i++) {
JSONObject responseJson = (JSONObject) ResearchObjects.get(i); %>
<div style='width:100%'>
  <span style='width:60% ; display:inline-block' class='field-description' ><%= responseJson.get("researchobjectname") %></span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:11% ; display:inline-block' class='field-description' ><%= responseJson.get("status") %></span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:23% ; display:inline-block' class='field-description' >	<span   style='width:100%' onclick="GetResearchObjectById(<%= responseJson.get("researchobjectid") %>)" class='btn btn-primary'><i class='fa fa-file-text-o'  aria-hidden='true'>&nbsp; &nbsp;  </i>Get details</span></span>
</div><br>
	<%} %>
  </div>
  		


<%}} %>	
  		
<%-- <h2>Your GfBio datasets</h2><br>
<table><tr>
<td>Dataset Name </td><td>Status</td></tr>
<% for (int i = 0; i < ResearchObjects.size(); i++) {
JSONObject responseJson = (JSONObject) ResearchObjects.get(i); %>
<tr><td><%= responseJson.get("researchobjectname") %> </td>

<td><%= responseJson.get("status") %></td>
<td><button onclick="GetResearchObjectById(<%= responseJson.get("researchobjectid") %>)">Get details</button></td>
</tr>
<%} %>
</table> --%>

<Div ID="SubmissionInfo"></Div>

<div id="tabs" class="container">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">DataSet</li>
		<li class="tab-link" data-tab="tab-2">Projects</li>
		<li class="tab-link" data-tab="tab-3">Submissions</li>
		<li class="tab-link" data-tab="tab-4">License</li>
		 <li class="tab-link" data-tab="tab-5">Extended Information</li>
	</ul>

	<div id="tab-1" class="tab-content current">	</div>
	<div id="tab-2" class="tab-content">	</div>
	<div id="tab-3" class="tab-content">	</div>
	<div id="tab-4" class="tab-content">	</div>
	<div id="tab-5" class="tab-content">	</div>

</div><!-- container -->

<br>
<br>
<br>
<br>
<script>

	function GetResearchObjectById(researchobjectid)
	{

		var requestJson = {"researchobjectid":researchobjectid,"kindofresponse":"extraextended"};
		console.log(requestJson);
/* 		var requestArray = [requestJson];
		console.log(requestArray); */

		
/* 		Liferay.Service(
				'/GFBioProject-portlet.researchobject/get-research-object-by-id',{
					requestJson: JSON.stringify(requestArray)
				},
				function(obj) {
					console.log(obj);
					var response = obj[0];
					console.log(response);
					buildDatasetInformation (response);
				}
		); */
		var url = document.getElementById('submissiondashboardurl').value;
		var ajaxData = requestJson;
		$.ajax({
			"type" : "POST",
			"url": url.concat('/SubmissionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "getresearchobjectinformation"
			},
			async: false,
			success : function(obj) {

 				var response = {};
				response = obj;
				console.log(response);
				buildDatasetInformation (response); 
			},
			error : function(request,status,errorThrown) {
				console.log("error");
				console.log(request);
				console.log(status);
				console.log(errorThrown);
			}
		});
	}

	function buildDatasetInformation(bundle)
	{
		var researchObjectInformation = bundle.researchobject;
		/*  if(researchObjectInformation.)
		var parentresearchObjectInformation = bundle.parentresearchobject;
		*/
		var license=bundle.license;
		var metadata=bundle.metadata;
		var projects=bundle.projects[0];
		console.log(projects);
		var primarydata=bundle.primarydatas[0];
		var submissions=bundle.submissions[0];

		var extdata = researchObjectInformation.extendeddata;
			
		//var ParentResearchObject= bundle.parentresearchobject;
		
		//var div = $("#tabs");
		//[div].visible = true;
		//var elem = document.getElementById('tabs');
		//elem.style.visibility = 'visible';
		console.log(researchObjectInformation);
		var firstcolum = "30%";
	    var secoundcolum = "2%";
	    var thirdcolum = "65%";
	    
	   
	    console.log(extdata);
	   // var div = $("#SubmissionInfo");
	    var div = $("#tab-1");
	    div.empty();
	    div.append(
	    	//"<h3>Dataset Information</h3>"+
	    	// check if parentresearchobjectid is null so no parentresearchobject in the bundle
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
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Embargo Time </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+extdata.embargo+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Last Modified Date</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+researchObjectInformation.lastmodifieddate+ "</span>"+
				"</div >"+
				// Extended
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Publications </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+extdata.publications+ "</span>"+
				"</div >"
				
			
	    );
	    var div = $("#tab-2");
	    div.empty();
	    div.append(
	    	
	    		//license
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Name </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+projects.name+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Label</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+projects.label+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Description</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+projects.description+ "</span>"+
				"</div >"+
				
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Status</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+projects.status+ "</span>"+
				"</div >"
			
	    );
	    var div = $("#tab-3");
	    div.empty();
	    div.append(
	    	
	    		//license
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Name </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+submissions.archive+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Status</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+submissions.status+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Is public</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+submissions.ispublic+ "</span>"+
				"</div >"+
				
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Last change</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+submissions.lastchanged+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >JIRAkey</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+submissions.jirakey+ "</span>"+
				"</div >"
			
			
	    );
	    
	    
	    
	    
	    var div = $("#tab-4");
	    div.empty();
	    div.append(
	    	
	    		//license
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Name </span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+license.name+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Label</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+license.label+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Version</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+license.version+ "</span>"+
				"</div >"+
				
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Discription</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+license.description+ "</span>"+
				"</div >"+
				"<div class='control-group'>"+
				"<span style='width:"+firstcolum+" ; display:inline-block; font-weight:bold' class='field-description' >Weblink</span>"+
				"<span style='width:"+secoundcolum+"; display:inline-block'></span>"+
				"<span style='width:"+thirdcolum+ "; display:inline-block' class='field-description' >"+license.extendeddata+ "</span>"+
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