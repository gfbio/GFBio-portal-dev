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
	
<!-- Acordion um die Types anzuzeigen -->
<div  class="toggler">
Type
</div>

<div class="accordion">

		<% 	//get the headid of table gfbio_type
			Long typeId = HeadLocalServiceUtil.getHeadID("gfbio_type");
		    //get the list of all Positions(all rows) for the specified typeid
			List<Position> typeList = PositionLocalServiceUtil.getPositionsbyHeadId(typeId); 
			
		    //get the headid of relation category_type
			Long categoryTypeId = HeadLocalServiceUtil.getHeadID("gfbio_category_type");
		    //get the list of all positions for categoy_type
			List<Position> categoryTypeList = PositionLocalServiceUtil.getPositionsbyHeadId(categoryTypeId); 
		    		
			//get the headid of relation category
			Long categoryId = HeadLocalServiceUtil.getHeadID("gfbio_category");	
			int catColumnNum = HeadLocalServiceUtil.getColumnByName(categoryId, "name");
						
		%>
		
		<%	for(int i = 0; i < typeList.size();i++){ 
			    //columnnumber for feature name of table type
				int headColNum = HeadLocalServiceUtil.getColumnByName(typeId, "name");%>
				
		<!-- PseudoAcordion um für jeden Type die entsprechende Categorieliste anzuzeigen -->
			<div id="<%="hide_accordion_".concat("type").concat(new Integer(i).toString())%>" onclick="pseudoaccordion('<%="type".concat(new Integer(i).toString()) %>')" style="cursor:pointer;">
				<!-- Display list of Types at column headColNum and row positionid for type  -->
				<h4 > <span id="<%="h_".concat("type").concat(new Integer(i).toString())%>">+</span> <%= PositionLocalServiceUtil.getColumnContent(typeList.get(i).getPositionID(), headColNum) %></h4>
			</div>
			
			<!-- Display the list of categories for every type -->		
			<div id= "<%="hide_".concat("type").concat(new Integer(i).toString())%>" class="swHide">
			
				<% 	//get columnnumber of category in relation category_type
					int catColNumb = HeadLocalServiceUtil.getColumnByName(categoryTypeId, "gfbio_category");
					//get columnnumber of type in relation category_type
					int typeColNumb = HeadLocalServiceUtil.getColumnByName(categoryTypeId, "gfbio_type");
					
					
										
					//positionPersistencefindbyColumn01("string");
					
					//get the positionid for the actual type
					String posTypeId = new Long(typeList.get(i).getPositionID()).toString();
					//List of all positions for a specific typeid ??in category_type relation
					List<Position> catList = PositionLocalServiceUtil.getPositionsbyColumnName(posTypeId, typeColNumb);
					
					%>
					
					<%for(int j=0; j<catList.size(); j++){ 
						String stringCatId_ij = PositionLocalServiceUtil.getColumnContent(catList.get(j).getPositionID(), catColNumb);
						Long catId_ij = Long.valueOf(stringCatId_ij).longValue();%>
						
						<div class="row">
							<div class="dynamicIcon1st">- </div>
							<label  class="dynamicTableIst" id="<%="type_".concat(new Integer(i).toString()).concat("_category_").concat(new Integer(j).toString())%> "
									onclick="getCategory('<%= PositionLocalServiceUtil.getColumnContent(catId_ij, catColumnNum) %>')"><%= PositionLocalServiceUtil.getColumnContent(catId_ij, catColumnNum) %></label><br/>
						</div>
						
						
					<% }	%>
			
			</div>
		
		
		<%	} %>
	
</div>	

<!-- Acordion um die Research Fields anzuzeigen -->
<div   class="toggler">
Research Field
</div>

<div  class="accordion">
test
</div>	
	

<div id="datacenters">
	<% 	//get the headid for table dataprovider
	    Long headId = HeadLocalServiceUtil.getHeadID("gfbio_dataprovider");
		//list of positions for dataprovider
		List<Position> positionList = PositionLocalServiceUtil.getPositionsbyHeadId(headId); %>
	<%	for(int i = 0; i < positionList.size();i++){ 
		    //get the columnnumber for feature name of table dataprovider
			int headColNum = HeadLocalServiceUtil.getColumnByName(headId, "name");%>
			<!-- Display the list of all DataCenter at column headColNum and row positionid_datacenter -->
		<div id=<%="hide_datacenter_".concat(new Integer(i).toString()) %> class="swMain"> <%=PositionLocalServiceUtil.getColumnContent(positionList.get(i).getPositionID(), headColNum ) %></div>
	<%	} %>
</div>
