
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui"    prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.taglib.util.IncludeTag" %>


<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.RenderResponse"%>
<%@ page import="java.util.*" %>


<%@ page import="org.gfbio.ContactToDMS" %>
<%@ page import="org.gfbio.GFBioID" %>

<%@ page import="org.jdom2.Content" %>
<%@ page import="org.jdom2.Element" %>
<%@ page import="org.jdom2.JDOMException" %>


<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 

 



<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />


<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" 	type="text/javascript"></script> 	<!--  jqery.js  imports --> 

<script type="text/javascript">

	/////////////////////////////////////////   GCDJ Widget  //////////////////////////////////////////////

	//hide GCDJ Widget
	function hideSubmission(hidecode) {
		var toHide = { "hidecode" : hidecode };
		Liferay.fire('gadget:gfbio.archiving.submit', toHide);
	}
	
	//GCDJ Widget Publish
	function SubmitGCDJ(hidecode) {
		var toSubmit = { 
			     "hidecode" : hidecode,
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
		window.location.reload(true);

		
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
			success : function(data) {
			}
		});
	}
	

	
</script>



