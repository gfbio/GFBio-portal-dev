<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="org.gfbio.service.ResearchObjectLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<link href="${pageContext.request.contextPath}/css/submission_dashboard/sub_dash.css"	rel="stylesheet" 	type="text/css"> <!-- main.css imports -->


<portlet:defineObjects />
<theme:defineObjects />
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
<Div style='margin-left: 15%;margin-right: 15%'>
  <div ID="datasets"  >
  <%String userName = themeDisplay.getUser().getFullName();
  System.out.println(userName);%>
  <h2> GFBio datasets for <%=userName%></h2><br>
  <div >
  	<span style='width:60% ; display:inline-block; font-weight:bold' class='field-description' >DataSet name</span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:12% ; display:inline-block; font-weight:bold' class='field-description' >Status</span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:23% ; display:inline-block; font-weight:bold' class='field-description' ></span>
  </div>
<% for (int i = 0; i < ResearchObjects.size(); i++) {
JSONObject responseJson = (JSONObject) ResearchObjects.get(i); %>
<div >
  <span style='width:60% ; display:inline-block' class='field-description' ><%= responseJson.get("researchobjectname") %></span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:11% ; display:inline-block' class='field-description' ><%= responseJson.get("status") %></span>
	<span style='width:2%; display:inline-block'></span>
	<span style='width:23% ; display:inline-block' class='field-description' >	<span   style='width:100%' onclick="GetResearchObjectById(<%= responseJson.get("researchobjectid") %>)" class='btn btn-primary'><i class='fa fa-file-text-o'  aria-hidden='true'>&nbsp; &nbsp;  </i>Get details</span></span>
</div><br>
	<%} %>
  </div>
 <%}} %>	

<div id="tabs" class="container" style='display:none' >

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
</div>

<br>
<br>
<br>
<br>
<script>
function IsDataNotAvailable(data)
{
	// check DataNotAvailable
	if(Data=="")
		return true;
	else 
		return false;
}
function IsDataNull(data)
{
	// check the null data
	if(data==null)
		return true;
	else 
		return false;
	
}
function AppendDiv(div, firstcolumn,thirdcolumn)
{
	var firstcolumstyle = "30%";
    var secoundcolumstyle = "2%";
    var thirdcolumstyle = "65%";
    
    
	div.append(
			"<div class='control-group'>"+
			"<span style='width:"+firstcolumstyle+" ; display:inline-block; font-weight:bold' class='field-description' >"+firstcolumn+ "</span>"+
			"<span style='width:"+secoundcolumstyle+"; display:inline-block'></span>"+
			"<span style='width:"+thirdcolumstyle+ "; display:inline-block' class='field-description' >"+thirdcolumn+ "</span>"+
			"</div >");
	
}

	function GetResearchObjectById(researchobjectid)
	{

		var requestJson = {"researchobjectid":researchobjectid,"kindofresponse":"extraextended"};
		console.log(requestJson);

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
		//empty Divs
		//check parentresearchobject
		
	    var researchObjectInformation = bundle.researchobject;
		var extdata = researchObjectInformation.extendeddata;
		
		
		
		var elem = document.getElementById('tabs');
		elem.style.display = 'block';
		console.log(researchObjectInformation);
		var firstcolum = "30%";
	    var secoundcolum = "2%";
	    var thirdcolum = "65%";
	    
	   
	   // var div = $("#SubmissionInfo");
	    var div1 = $("#tab-1");
	    div1.empty();
	    AppendDiv(div1,"Title",researchObjectInformation.name);
	 	AppendDiv(div1,"Description",researchObjectInformation.description);	
	   	AppendDiv(div1,"Label",researchObjectInformation.label);							
		AppendDiv(div1,"Version",researchObjectInformation.researchobjectversion);	
				
		if(researchObjectInformation.parentresearchobjectid!=null)
		{
				if("parentresearchobject" in bundle)
					{
						var parentdataset=bundle.parentresearchobject;
						
						AppendDiv(div1,"Parent data set",parentdataset.name);			

					}
					else
				    {
				    	 AppendDiv(div1,"Parent data set","N/A");
				    }
		}
		AppendDiv(div1,"Data Collection Time",extdata.datacollectiontime);	
		AppendDiv(div1,"Embargo Time",extdata.embargo);			
		AppendDiv(div1,"Last Modified Date",researchObjectInformation.lastmodifieddate);
	    // Authors
	   
	      if (researchObjectInformation.authorname!=null && researchObjectInformation.authorname.length>0)
	    	{
	    	  
	    	 var authors="";
	    	 var i=1;
	    	 for ( var key in researchObjectInformation.authorname ) 
	    	 {	
	    		 if(i<researchObjectInformation.authorname.length)
	    		 {
	    			 authors=authors+researchObjectInformation.authorname[key]+" and ";
	    			 i=i+1;
	    		 }
	    		 else
	    		 authors=authors+researchObjectInformation.authorname[key];
	    		
	    	 }
	    	
	 		AppendDiv(div1,"Authors",authors);
		    	
		    } 
	     else
	       	 AppendDiv(div1,"Authors","N/A");
		  
	   // End Authors
			    
	    var div2 = $("#tab-2");
	    div2.empty();
	    
	    if ("projects" in bundle)
	    {
	    	var projects=bundle.projects;
	    	for ( var key in projects) 
	    	{	
	    		
	    	 AppendDiv(div2,"Name",projects[key].name);			
			 AppendDiv(div2,"Label",projects[key].label);	
			 AppendDiv(div2,"Description",projects[key].description);
		     AppendDiv(div2,"Status",projects[key].status);

	    	 }
	    }
		
	    else
		    AppendDiv(div2,"projects","N/A");
	    
	  
	    var div3 = $("#tab-3");
	    div3.empty();
	    if ("submissions" in bundle)
	    {
	    var submissions=bundle.submissions;
	    
	    /* 		var requestArray = [requestJson];
		console.log(requestArray); */
/* 
		Liferay.Service( '/GFBioProject-portlet.userextension/get-user-by-id', 
				{ requestJson: {"userid":userid} }, 
				function(obj) { 
					console.log("User---");
					console.log(obj);
					var name=obj.fullname;
					} 
				); */

 		/* Liferay.Service(
				'/GFBioProject-portlet.researchobject/get-user-by-id',{
					requestJson: JSON.stringify(requestArray)
				},
				function(obj) {
					console.log(obj);
					var response = obj[0];
					console.log(response);
					buildDatasetInformation (response);
				}
		);  */
		var userid, name, name2;
	    for ( var key in submissions) 
   	 	{
	    	
	    	AppendDiv(div3,"Name",submissions[key].archive);	
		    AppendDiv(div3,"Submission id",submissions[key].brokersubmissionid);
			AppendDiv(div3,"Status",submissions[key].status);
			AppendDiv(div3,"Is public",submissions[key].ispublic);
			AppendDiv(div3,"Last change",submissions[key].lastchanged);
			userid=submissions[key].userid;
			// submitter name userid
				Liferay.Service( '/GFBioProject-portlet.userextension/get-user-by-id', 
				{ requestJson: {"userid":userid} }, 
				function(obj) { 
					console.log("User---");
					console.log(obj);
					if ("fullname" in obj) name2=obj["fullname"];
					AppendDiv(div3,"Submitter name",name2);
					console.log(name2);
					
					} 
				);
			
				
			//
			AppendDiv(div3,"Public after",submissions[key].publicafter);
		    AppendDiv(div3,"JIRAkey",submissions[key].jirakey);
	
	    }
	   }
	    
	    else
	    	AppendDiv(div3,"submissions","N/A");
  	
	    	    
	    var div4 = $("#tab-4");
	    div4.empty();
	    if ("license" in bundle)
	    {
	    	var license=bundle.license;
			AppendDiv(div4,"Name",license.name);
			AppendDiv(div4,"Label",license.label);	
			AppendDiv(div4,"Version",license.version);	
			AppendDiv(div4,"Discription",license.description);	
			AppendDiv(div4,"Weblink",license.extendeddata);

	    }
	    else
			AppendDiv(div4,"License","N/A");  	
	    
	    var div5 = $("#tab-5");
	    div5.empty();
		AppendDiv(div5,"Publications",extdata.publications);
	 // primarydatas
	    if ("primarydatas" in bundle)
	    {
	    	var primarydatas=bundle.primarydatas;
	    	AppendDiv(div5,"Primary data","");
	    	
	    	 for ( var key in primarydatas ) 
	    	 {	
	 	    	AppendDiv(div5,"Name",primarydatas[key].name); 		
	 	    	/* var firstcolumstyle = "30%";
	 	       var secoundcolumstyle = "2%";
	 	       var thirdcolumstyle = "65%";
	 	       
	 	       
	 	   	div5.append(
	 	   			"<div class='control-group' style='margin-left: 1em;'>"+
	 	   			"<span style='width:"+firstcolumstyle+" ; display:inline-block; font-weight:bold' class='field-description' >"+"Name"+ "</span>"+
	 	   			"<span style='width:"+secoundcolumstyle+"; display:inline-block'></span>"+
	 	   			"<span style='width:"+thirdcolumstyle+ "; display:inline-block' class='field-description' >"+primarydatas[key].name+ "</span>"+
	 	   			"</div >"); */
		 	    AppendDiv(div5,"Url",primarydatas[key].path);

	    	 }
	    }
	    else
 	    	AppendDiv(div5,"Primary data","N/A");
	    
	   //metadata
	      if ("metadata" in bundle)
	    {
	    	var metadata=bundle.metadata;
	    	AppendDiv(div5,"Metadata","");
	    	AppendDiv(div5,"Label",metadata.label);
	    	AppendDiv(div5,"Name",metadata.name);
	    	AppendDiv(div5,"Version",metadata.version);
	    }
	    else
	    {
 	    	AppendDiv(div5,"Metadata","N/A");
	    }
	 //legal requir
	// extdata.legalrequirements
	if (extdata.legalrequirements!=null && extdata.legalrequirements.length>0)
	    	{
	    	  
	    	 var Legalrequirements="";
	    	 var i=1;
	    	 for ( var key in extdata.legalrequirements) 
	    	 {	
	    		 if(i<extdata.legalrequirements.length)
	    		 {
	    			 Legalrequirements=Legalrequirements+extdata.legalrequirements[key]+" and ";
	    			 i=i+1;
	    		 }
	    		 else
	    		  Legalrequirements=Legalrequirements+extdata.legalrequirements[key];
	    		
	    		 
	    	 }
	 	    	AppendDiv(div5,"Legal requirements",Legalrequirements);

		    	
		    } 
	     else
	 	    	AppendDiv(div5,"Legal requirements","N/A");
	   
	  
	

	}
	////////
	
	$(document).ready(function(){
		
		$('ul.tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		})

	})


</script>
