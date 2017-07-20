<%@page import="com.google.gson.stream.JsonReader"%>
<%@page import="org.gfbio.service.ResearchObjectLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<portlet:defineObjects />

 Hallooooooooo
 Long userId; 
 userId = <%=session.getAttribute("sessionId") %>
 
JSONArray requestJson = new JSONArray();
requestJson.put("researchobjectid", 70101);
requestJson.put("kindofresponse", "extended");


System.out.println(ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById(requestJson));
  
<br/>
<br/>

