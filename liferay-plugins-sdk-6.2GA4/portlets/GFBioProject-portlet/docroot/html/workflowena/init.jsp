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

<script>


	/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////

	
	//Message from Hide Managment
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			var submissionManager =   $("#ena");
			if (data == undefined || !(data.hidecode==="ena"))
				submissionManager.attr("class", "swHide");
			else 
				submissionManager.attr("class", "swMain");
		});
	});
	
	
</script>