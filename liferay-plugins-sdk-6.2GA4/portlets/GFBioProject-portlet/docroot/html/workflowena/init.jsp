<%@ taglib uri="http://java.sun.com/portlet_2_0" 	prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" 	prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" 	prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" 	prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" 		prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" 			prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" 		prefix="liferay-util" %>

<%@ page import="com.liferay.portal.NoSuchModelException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticleDisplay" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>


<%@ page import="java.io.File" %>

<%@ page import="org.gfbio.submissionworkflow.WorkflowENAPortlet" %>
<%@ page import="org.gfbio.helper.Helper" %>



<script>
	/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////
	
/* 	//Message from Hide Managment
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			var submissionManager =   $("#ena");
			if (data == undefined || !(data.workflow==="ena"))
				submissionManager.attr("class", "swHide");
			else 
				submissionManager.attr("class", "swMain");
		});
	});
	 */
	
</script>