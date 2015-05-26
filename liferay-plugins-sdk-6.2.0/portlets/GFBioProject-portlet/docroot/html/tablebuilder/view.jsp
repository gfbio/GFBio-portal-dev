<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="tablebuilderURL" var="tablebuilderURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<script src="${pageContext.request.contextPath}/js/main.js"  					type="text/javascript"></script>  <!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->

<input type="hidden" class="widthL" id="path"  				value="<%=request.getContextPath()%>" />
<input type="hidden" class="widthL" id="tablebuilderurl"  	value="<%=tablebuilderURL %>" />

<script>
$(document).ready(function() {
	
	$( "#divTableMenu"   ).load( document.getElementById("path").value.concat("/html/tablebuilder/tablemenu.jsp"));
	
	
	
});
</script>





<!---------------------------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------        Tabs        -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->

<div class='navigator'>
	<ul class='tabs' id="verticalNav">
		<li><a id="linkTableMenu"	href='#tabTableMenu'	>Table Menu	 </a></li>
		<li><a id="linkContentMenu"	href='#tabContentMenu'	>Content Menu</a></li>
	</ul>
</div>

<div id="sections">
	<div class="section" id='tabTableMenu'>
		<%	List <Head> headList = HeadLocalServiceUtil.getHeadsByTask("table"); 
			int maxcolumncount = 0;
			for (int i = 0; i < headList.size();i++)
				if (maxcolumncount < HeadLocalServiceUtil.getColumnCount(headList.get(i).getHeadID()))
					maxcolumncount = HeadLocalServiceUtil.getColumnCount(headList.get(i).getHeadID());
		%>

		<br>
		<h2>table menu</h2>
		<br>
		
		
		
		
		<!-------- head table with icons to manage the table  -------->
		
		<!-- head of table -->
		<div class="row" >
			<div class="dynamicTable1st">&nbsp;</div>
			<div class="dynamicIcon">&nbsp;</div>		
			<div class="dynamicHeadIst">Table Name</div>
			<% for(int j =0; j <maxcolumncount;j++){ %>
				<div class="dynamicHeadIst">	<%="Column ".concat(new Integer(j+1).toString()) %>		</div>
			<%} %>
			<div id="hide_95" class="swHide">
				<%	if (maxcolumncount+1<20)
					for (int j =maxcolumncount+1; j < 20;j++){ %>
						<div class="dynamicHeadIst">	<%="Column ".concat(new Integer(j+1).toString()) %>		</div>
					<%} %>
			</div>
		</div>
		<br>
		
		<!-- body of table -->
		<%	for(int i=0;i < headList.size();i++){ %>
			<div class="row" >
				
				<!--  running number -->
				<div class="dynamicTable1st"><%=(i+1) %></div>
				
				<!-- manage icons -->
				<div class="dynamicIcon">
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("edit")%>" 				class="icon-edit"  		  onclick="hideswitch('<%="91".concat(new Integer(i).toString()) %>','<%="92".concat(new Integer(i).toString()) %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("icon-resize-small")%>" 	class="icon-resize-small" onclick="showhide('<%="93".concat(new Integer(i).toString()) %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("remove")%>" 				class="icon-remove"></i>
				</div>
				
				<!-- default information -->
				<div id="<%="hide_91".concat(new Integer(i).toString()) %>" class="swMain">
					<div class="dynamicTableIst">
						<label  id="<%= "lavadyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(0).toString()) %>"><%=headList.get(i).getName() %></label>
					</div>
					<%	for (int j =1; j <= HeadLocalServiceUtil.getColumnCount(headList.get(i).getHeadID());j++){ %>
						<div class="dynamicTableIst">
							<label  id="<%= "lavadyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"><%=HeadLocalServiceUtil.getColumnName(headList.get(i).getHeadID(), j)  %></label>
						</div>
					<%} %>
					
				</div>
				
				<!-- change information -->
				<div id="<%="hide_92".concat(new Integer(i).toString()) %>" class="swHide">
					<%int k=0; %>
					<div class="dynamicTableIst">
						<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(k).toString()) %>"  		value="<%="name" %>" />
						<input class="widthM" 	type="text"		id="<%="dyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(k).toString())%>"   		value="<%=headList.get(i).getName() %>" />
					</div>
					
					<%	for (int j =1; j <= HeadLocalServiceUtil.getColumnCount(headList.get(i).getHeadID());j++){ %>
						<div class="dynamicTableIst">
							<%	if(j<10){%>
								<input 				type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"  	value="<%="column0".concat(new Integer(j).toString()) %>" />
							<%}else{ %>
								<input 				type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"  	value="<%="column".concat(new Integer(j).toString()) %>" />
							<%} %>
							<input class="widthM" 	type="text" 	id="<%="dyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString())%>"   	value="<%=HeadLocalServiceUtil.getColumnName(headList.get(i).getHeadID(), j)  %>" />
						</div>
						<%k=j; %>
					<%} %>
					<div id="<%="hide_92".concat(new Integer(i).toString()).concat(new Integer(1).toString())%>" class="swHide">
						<%	if (HeadLocalServiceUtil.getColumnCount(headList.get(i).getHeadID())+1<20)
							for (int j =HeadLocalServiceUtil.getColumnCount(headList.get(i).getHeadID())+1; j < 20;j++){ %>
								<div class="dynamicTableIst">
									<%	if(j<10){%>
										<input 				type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"  	value="<%="column0".concat(new Integer(j).toString()) %>" />
									<%}else{ %>
										<input 				type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"  	value="<%="column".concat(new Integer(j).toString()) %>" />
									<%} %>
									<input class="widthM" 	type="text" 	id="<%="dyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString())%>"   	value="<%=HeadLocalServiceUtil.getColumnName(headList.get(i).getHeadID(), j)  %>" />
								</div>
								<%k=j; %>
						<%} %>
					</div>
					<%k=k+1; %>
					<div>
						<input 	type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(k).toString()) %>" 	value="<%="headID" %>" />
						<input 	type="hidden"	id="<%="dyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(k).toString())%>"   	value="<%=headList.get(i).getHeadID() %>" />
						<input 	type="hidden"	id="<%="lavadyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(k).toString())%>" 	value="<%=headList.get(i).getHeadID() %>" />
					</div>
					
					<div class="dynamicIcon">
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editplus")%>" 	class="icon-plus" 	onclick="iconshowhide('95','<%="92".concat(new Integer(i).toString()).concat(new Integer(1).toString()) %>','<%="dyta_".concat(new Integer(i).toString()).concat("editplus")%>')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editok")%>" 		class="icon-ok" 	onclick=" updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= k+1 %>', 'table','<%="91".concat(new Integer(i).toString()) %>','<%="92".concat(new Integer(i).toString()) %>')"  /></i>
					</div>
				</div>
				
				<!-- connection between head tables -->
				<div id="<%="hide_93".concat(new Integer(i).toString()) %>" class="swHide">
					<br>
					test
					<br>
				</div>
				
				
				
				
				<br>
			</div>
			<br>
		<% } %>
		
	</div>
	<div class="section" id='tabContentMenu'>	<div id="divContentMenu">	</div></div>
</div>
