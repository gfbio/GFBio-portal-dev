



<%@ taglib uri="http://java.sun.com/portlet_2_0" 	prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" 	prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" 	prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" 	prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" 		prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" 			prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" 		prefix="liferay-util" %>


<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.NoSuchModelException" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.taglib.util.IncludeTag" %>

<%@ page import="java.util.*" %>


<%@ page import="javax.portlet.*" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.RenderResponse"%>


<%@ page import="org.gfbio.model.Head" %>
<%@ page import="org.gfbio.model.Project" %>
<%@ page import="org.gfbio.model.ResearchObject" %>
<%@ page import="org.gfbio.service.HeadLocalServiceUtil" %>
<%@ page import="org.gfbio.service.ProjectLocalServiceUtil" %>

<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
 

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />

<portlet:renderURL var="jspProjectProfile">
	<portlet:param name="jspPage" value="/projectprofile.jsp" />
</portlet:renderURL>









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
		Liferay.on('gadget:gfbio.archiving.submit', function(topic, data, subscriberData){
			if (data == undefined){}
			else
				submitAnswer(data);
		});
	});
	
	function submitAnswer(data){
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
	
	function ajaxRequest(archivingURL, method, data){
		$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: false,
			success : function() {
			}
		});
	}
	
	function ajaxValueResponse(archivingURL, method, data){
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
	
	//////////////////////////////////////// content //////////////////////////////////////////////////////////
	
	


	
</script>



