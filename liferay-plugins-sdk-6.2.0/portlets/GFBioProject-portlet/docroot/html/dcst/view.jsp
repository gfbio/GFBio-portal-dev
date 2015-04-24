<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/dcst/init.jsp"%>

<!-- 
 <jsp:useBean class="java.lang.String" id="keyWords" scope="request" /> 
-->

Das ist unser tolles Portlet

<%
long userid = PortalUtil.getUserId(request);
ProjectLocalServiceUtil.getProjectList(userid);
%>