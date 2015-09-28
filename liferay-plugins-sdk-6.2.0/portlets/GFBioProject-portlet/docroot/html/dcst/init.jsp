


<%@ taglib uri="http://java.sun.com/portlet_2_0" 	prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" 	prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" 	prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" 	prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" 		prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" 			prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" 		prefix="liferay-util" %>

<%@ page import="com.liferay.portal.NoSuchModelException" %><%@
page import="com.liferay.portal.kernel.exception.SystemException" %><%@
page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.util.*" %>

<%@ page import="javax.portlet.*" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>

<%@ page import="org.gfbio.model.Head" %>
<%@ page import="org.gfbio.model.Project" %>
<%@ page import="org.gfbio.model.Position" %>
<%@ page import="org.gfbio.model.ResearchObject" %>
<%@ page import="org.gfbio.service.HeadLocalServiceUtil" %>
<%@ page import="org.gfbio.service.PositionLocalServiceUtil" %>
<%@ page import="org.gfbio.service.impl.PositionLocalServiceImpl" %>
<%@ page import="org.gfbio.service.ProjectLocalServiceUtil" %>

<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<portlet:resourceURL escapeXml="false" id="dcstURL" var="dcstURL" />

<script type="text/javascript">

function ajaxGetCategory(category) {
	console.log(document.getElementById("dcstURL").value);
	$.ajax({
		"type" : "GET",
		"url": document.getElementById("dcstURL").value.concat("/GFBioDCST"),
		"data" : {
			"<portlet:namespace />category" : JSON.stringify(category)
		},
		success : function(data) {
		}
	});
	visibleShow("-20");
	window.setTimeout('reload()',1);
}


/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////

function ajaxRequest(archivingURL, method, data, as) {
	$.ajax({
		"type" : "POST",
		"url": archivingURL.concat("/GFBioArchiving"),
		"data" : {
			"<portlet:namespace />data" : JSON.stringify(data),
			"<portlet:namespace />responseTarget" : method
		},
		async: as,
		success : function() {
		}
	});
}

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
</script>
