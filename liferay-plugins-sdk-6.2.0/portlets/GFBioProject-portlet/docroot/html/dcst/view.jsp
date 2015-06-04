<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/dcst/init.jsp"%>
<script src="${pageContext.request.contextPath}/js/main.js"  					type="text/javascript"></script>  <!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css">

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
	

<div  class="toggler">
Type
</div>

<div class="accordion">

		<% 	Long typeId = HeadLocalServiceUtil.getHeadID("gfbio_type");
			List<Position> typeList = PositionLocalServiceUtil.getPositionsbyHeadId(typeId); 
			
			Long categoryId = HeadLocalServiceUtil.getHeadID("gfbio_category");
			
		%>
		
		<%	for(int i = 0; i < typeList.size();i++){ %>
		
			<div id="<%="hide_accordion_".concat("type").concat(new Integer(i).toString())%>" onclick="pseudoaccordion('<%="type".concat(new Integer(i).toString()) %>')" style="cursor:pointer;">
				<h4 > <span id="<%="h_".concat("type").concat(new Integer(i).toString())%>">+</span> <%= PositionLocalServiceUtil.getColumnContent(typeList.get(i).getPositionID(), HeadLocalServiceUtil.getColumnByName(typeId, "name") ) %></h4>
			</div>
					
			<div id= "<%="hide_".concat("type").concat(new Integer(i).toString())%>" class="swHide">
			
				<% 	
					%>
			
			</div>
		
		
		<%	} %>
	
</div>	

<div   class="toggler">
Research Field
</div>

<div  class="accordion">
test
</div>	
	

<div id="datacenters">
	<% 	Long headId = HeadLocalServiceUtil.getHeadID("gfbio_dataprovider");
		List<Position> positionList = PositionLocalServiceUtil.getPositionsbyHeadId(headId); %>
	<%	for(int i = 0; i < positionList.size();i++){ %>
		<div id=<%="hide_datacenter_".concat(new Integer(i).toString()) %> class="swMain"> <%=PositionLocalServiceUtil.getColumnContent(positionList.get(i).getPositionID(), HeadLocalServiceUtil.getColumnByName(headId, "name") ) %></div>
	<%	} %>
</div>
