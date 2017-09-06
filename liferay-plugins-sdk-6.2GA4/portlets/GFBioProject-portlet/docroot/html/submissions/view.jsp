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
<!-- 	 --end of for -->  
</div>
 <%} else {%>
			<div class="portlet-msg-alert">
				Please add submissions to explore your submission dashboard.
			</div>
 <%} %>
<%} %>
<!-- end of outer else -->
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
function AppendDiv(div, firstcolumn,thirdcolumn,marginleft)
{
	var firstcolumstyle = "30%";
    var secoundcolumstyle = "2%";	
    var thirdcolumstyle = "65%";
    

    
     if (marginleft)
    	{
		div.append("<div class='control-group' style='margin-left: 2em;'>");
		console.log("indented");
    	}
	else
		div.append("<div class='control-group'>"); 
		
	//div.append("<div class='control-group' style='margin-left: 2em;'>");
		//div.append("<div class='control-group'>");
	div.append(
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
	    AppendDiv(div1,"Title",researchObjectInformation.name,false);
	 	AppendDiv(div1,"Description",researchObjectInformation.description,false);	
	   	AppendDiv(div1,"Label",researchObjectInformation.label,false);							
		AppendDiv(div1,"Version",researchObjectInformation.researchobjectversion,false);	
				
		if(researchObjectInformation.parentresearchobjectid!=null)
		{
				if("parentresearchobject" in bundle)
					{
						var parentdataset=bundle.parentresearchobject;
						
						AppendDiv(div1,"Parent data set",parentdataset.name,false);			

					}
					else
				    {
				    	 AppendDiv(div1,"Parent data set","N/A",false);
				    }
		}
		AppendDiv(div1,"Data Collection Time",extdata.datacollectiontime,false);	
		AppendDiv(div1,"Embargo Time",extdata.embargo,false);			
		AppendDiv(div1,"Last Modified Date",researchObjectInformation.lastmodifieddate,false);
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
	    	
	 		AppendDiv(div1,"Authors",authors,false);
		    	
		    } 
	     else
	       	 AppendDiv(div1,"Authors","N/A",false);
		  
	   // End Authors
			    
	    var div2 = $("#tab-2");
	    div2.empty();
	    
	    if ("projects" in bundle)
	    {
	    	var projects=bundle.projects;
	    	for ( var key in projects) 
	    	{	
	    		
	    	 AppendDiv(div2,"Name",projects[key].name,false);			
			 AppendDiv(div2,"Label",projects[key].label,true);	
			 AppendDiv(div2,"Description",projects[key].description,true);
		     AppendDiv(div2,"Status",projects[key].status,true);

	    	 }
	    }
		
	    else
		    AppendDiv(div2,"projects","N/A",false);
	    
	  
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
	    	
	    	AppendDiv(div3,"Name",submissions[key].archive,false);	
		    AppendDiv(div3,"Submission id",submissions[key].brokersubmissionid,true);
			AppendDiv(div3,"Status",submissions[key].status,true);
			AppendDiv(div3,"Is public",submissions[key].ispublic,true);
			AppendDiv(div3,"Last change",submissions[key].lastchanged,true);
			userid=submissions[key].userid;
			// submitter name userid
				Liferay.Service( '/GFBioProject-portlet.userextension/get-user-by-id', 
				{ requestJson: {"userid":userid} }, 
				function(obj) { 
					console.log("User---");
					console.log(obj);
					if ("fullname" in obj) name2=obj["fullname"];
					console.log(name2);
					AppendDiv(div3,"Submitter name",name2,true);
					AppendDiv(div3,"Public after",submissions[key].publicafter,true);
				    AppendDiv(div3,"JIRAkey",submissions[key].jirakey,true);
					
					
					} 
				);
	    }
	   }
	    
	    else
	    	AppendDiv(div3,"submissions","N/A",false);
  	
	    	    
	    var div4 = $("#tab-4");
	    div4.empty();
	    if ("license" in bundle)
	    {
	    	var license=bundle.license;
			AppendDiv(div4,"Name",license.name,false);
			AppendDiv(div4,"Label",license.label,false);	
			AppendDiv(div4,"Version",license.version,false);	
			AppendDiv(div4,"Discription",license.description,false);	
			AppendDiv(div4,"Weblink",license.extendeddata,false);

	    }
	    else
			AppendDiv(div4,"License","N/A",false);  	
	    
	    var div5 = $("#tab-5");
	    div5.empty();
		AppendDiv(div5,"Publications",extdata.publications,false);
	 // primarydatas
	    if ("primarydatas" in bundle)
	    {
	    	var primarydatas=bundle.primarydatas;
	    	AppendDiv(div5,"Primary data","",false);
	    	
	    	 for ( var key in primarydatas ) 
	    	 {	
	 	    	AppendDiv(div5,"Name",primarydatas[key].name,true); 		
	 	    	 var firstcolumstyle = "30%";
	 	       var secoundcolumstyle = "2%";
	 	       var thirdcolumstyle = "65%";
	 	       
	 	       
	 	   /* 	div5.append(
	 	   			"<div class='control-group' style='margin-left: 1em;'>");
	 	   		div5.append(		
	 	   			"<span style='width:"+firstcolumstyle+" ; display:inline-block; font-weight:bold' class='field-description' >"+"Name"+ "</span>"+
	 	   			"<span style='width:"+secoundcolumstyle+"; display:inline-block'></span>"+
	 	   			"<span style='width:"+thirdcolumstyle+ "; display:inline-block' class='field-description' >"+primarydatas[key].name+ "</span>"+
	 	   			"</div >"); 
	 	   	
	 		div5.append(
	 	   			"<div class='control-group' style='margin-left: 1em;'>"+
	 	   			"<span style='width:"+firstcolumstyle+" ; display:inline-block; font-weight:bold' class='field-description' >"+"Url"+ "</span>"+
	 	   			"<span style='width:"+secoundcolumstyle+"; display:inline-block'></span>"+
	 	   			"<span style='width:"+thirdcolumstyle+ "; display:inline-block' class='field-description' >"+primarydatas[key].path+ "</span>"+
	 	   			"</div >");  */
		 	    AppendDiv(div5,"Url",primarydatas[key].path,true);

	    	 }
	    }
	    else
 	    	AppendDiv(div5,"Primary data","N/A",false);
	    
	   //metadata
	      if ("metadata" in bundle)
	    {
	    	var metadata=bundle.metadata;
	    	AppendDiv(div5,"Metadata","",false);
	    	AppendDiv(div5,"Label",metadata.label,true);
	    	AppendDiv(div5,"Name",metadata.name,true);
	    	AppendDiv(div5,"Version",metadata.version,true);
	    }
	    else
	    {
 	    	AppendDiv(div5,"Metadata","N/A",false);
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
	 	    	AppendDiv(div5,"Legal requirements",Legalrequirements,false);

		    	
		    } 
	     else
	 	    	AppendDiv(div5,"Legal requirements","N/A",false);
	   
	  
	

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
