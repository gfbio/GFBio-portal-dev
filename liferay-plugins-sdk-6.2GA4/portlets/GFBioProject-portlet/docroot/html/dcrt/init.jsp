<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.NoSuchModelException" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.RenderResponse" %>

<%@ page import="org.gfbio.idmg.dcrt.DCRTPortlet" %>
<%@ page import="org.gfbio.model.DataProvider" %>
<%@ page import="org.gfbio.idmg.dcrt.dao.GCategory" %>

<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />