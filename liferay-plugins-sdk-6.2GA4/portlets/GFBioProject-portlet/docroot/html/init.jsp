


<%@ taglib uri="http://java.sun.com/portlet_2_0" 	prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" 	prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" 	prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" 	prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" 		prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" 			prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" 		prefix="liferay-util" %>

<%@ page import="com.liferay.portal.NoSuchModelException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.util.*" %>

<%@ page import="javax.portlet.*" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>

<%@ page import="org.gfbio.model.Head" %>
<%@ page import="org.gfbio.model.Content" %>
<%@ page import="org.gfbio.model.Column" %>
<%@ page import="org.gfbio.model.Project" %>
<%@ page import="org.gfbio.model.ResearchObject" %>
<%@ page import="org.gfbio.service.ColumnLocalServiceUtil" %>
<%@ page import="org.gfbio.service.DataProviderLocalServiceUtil" %>
<%@ page import="org.gfbio.service.HeadLocalServiceUtil" %>
<%@ page import="org.gfbio.service.ProjectLocalServiceUtil" %>
<%@ page import="org.gfbio.service.ResearchObjectLocalServiceUtil" %>

<%@ page import="org.json.simple.JSONArray" %> 
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL escapeXml="false" id="archivingURL" var="archivingURL" />
<!--
<portlet:renderURL var="jspProjectProfile">
	<portlet:param name="jspPage" value="/projectprofile.jsp" />
</portlet:renderURL>
-->





<script type="text/javascript">

	/////////////////////////////////////////   GCDJ Widget  //////////////////////////////////////////////

	
	//hide GCDJ Widget
	function hideSubmission(hidecode) {
		var toHide = { "hidecode" : hidecode };
		Liferay.fire('gadget:gfbio.archiving.submit', toHide);
	}
	

	//GCDJ Widget Publish
	function SubmitGCDJ(hidecode, showhide) {
		var toSubmit = {
			     "hidecode" : hidecode,
			     "showhide" : showhide,
			     "projId" : document.getElementById("chooPro").value
			   };
		Liferay.fire('gadget:gfbio.archiving.submit', toSubmit);
	}
	
	

	//GCDJ Submit Answer
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.archiving.submit', function(topic, data, subscriberData) {
			if (data == undefined){}
			else
				submitAnswer(data);
		});
	});
	

	//
	function submitAnswer(data) {
		$.ajax({
			"type" : "POST",
			"url": document.getElementById("archivingURL").value.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : data,
				"<portlet:namespace />projId" : document.getElementById("chooPro").value,
				"<portlet:namespace />responseTarget" : "GCDJWidget"
			},
			success : function(data) {
			}
		});
		visibleShow("-20");
		window.setTimeout('reload()',1);
	}


	/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////
	
	
	//
	function ajaxRequest(archivingURL, method, data, as) {
		console.log("ajaxRequest: "+archivingURL+" | "+ method+" | "+JSON.stringify(data)+" | "+as);
 		$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function() {
				console.log("true");
			}
		});
	}

	
	//
	function ajaxValueResponse(archivingURL, method, data) {
		
		$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: false,
			success : function(data) {
				callbackSuccess(data);
			}
		});
	}
	
	
	/////////////////////////////////////////   ActionRequest  //////////////////////////////////////////////

	
	//
	function ajaxActionRequest_Choose(archivingURL, method, data, withoutRelationship, withRelationship, as) {
		console.log("ajaxRequest: "+archivingURL+" | "+ method+" | "+JSON.stringify(data)+" | "+as);
 		$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function(data) {
				
				var withoutRelation = data.withoutRelationIdList;
				var withoutSelect = $("#".concat(withoutRelationship));  
				withoutSelect.empty();
				
				var withRelation = data.withRelationIdList;
				var withSelect = $("#".concat(withRelationship));   
				withSelect.empty();
				
				for (y = 0; y < withoutRelation.length; y++){
					withoutSelect.append("<option value='" + withoutRelation[y]+ "'>" + data.withoutJson[withoutRelation[y]] + "</option>");
				}

				for (y = 0; y < withRelation.length; y++){
					withSelect.append("<option value='" + withRelation[y]+ "'>" + data.withJson[withRelation[y]] + "</option>");
				}
					
			}
		});
	}
	
/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////
	
	
	//Message from hide managment
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.submissionmanager.hidemanagment', function(data) {
			
			if (data == undefined){}
			else{
				var dataSubmission =   $("#dataSubmission");
				dataSubmission.attr("class", data.view);			
			}
		});
	});
	
	
	//Message from Submission Manager
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.submissionmanager.datasubmission', function(data) {
			
			if (data == undefined){}
			else{
				var dataSubmission =   $("#dataSubmission");
				dataSubmission.attr("class", data.view);	
			}
		});
	});
	
	

 	
	




	


</script>