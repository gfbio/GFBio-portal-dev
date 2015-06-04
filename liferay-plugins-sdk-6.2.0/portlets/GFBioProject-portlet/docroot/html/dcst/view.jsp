<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/dcst/init.jsp"%>

<!-- 
 <jsp:useBean class="java.lang.String" id="keyWords" scope="request" /> 
-->

Das ist unser tolles Portlet

<%
long userid = PortalUtil.getUserId(request);
List <Project> projectList = new ArrayList<Project>();
projectList = null;
try {
	 projectList = ProjectLocalServiceUtil.getProjectList(userid);
} catch (NoSuchModelException e) {
	e.printStackTrace();
} catch (SystemException e) {
	e.printStackTrace();
}
%>
Es gibt <%=projectList.size() %> Projekte. Ich bin User <%=userid %>>
	<table> 
		<% if (projectList!=null){ for (int i = 0; i < projectList.size(); i++) { %>
		<tr> 
			<td><%= projectList.get(i).getLabel() %></td> 
		</tr> 
		<%} } %>
	</table>
	

<div id="datacenters">
	<% 	Long headId = HeadLocalServiceUtil.getHeadID("gfbio_dataprovider");
		List<Position> positionList = PositionLocalServiceUtil.getPositionsbyHeadId(headId); %>
	<%	for(int i = 0; i < positionList.size();i++){ %>
		<div id=<%="hide_datacenter_".concat(new Integer(i).toString()) %> class="swMain"> <%=PositionLocalServiceUtil.getColumnContent(positionList.get(i).getPositionID(), HeadLocalServiceUtil.getColumnByName(headId, "name") ) %></div>
	<%	} %>
</div>
