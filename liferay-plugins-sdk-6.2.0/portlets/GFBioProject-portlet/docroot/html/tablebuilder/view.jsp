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

<!------------------------------------------------        Tab: Table Menu        -------------------------------------------------------------------->
<!--------------------------------------------------------------------------------------------------------------------------------------------------->



	<div class="section" id='tabTableMenu'>
	
		<%	List <Head> headList = HeadLocalServiceUtil.getHeadsByTableType("entity"); 
			int maxcolumncount = ColumnLocalServiceUtil.getMaxCountofColumns(headList); 
		%>
	
		<br>
		<h2>table menu</h2>
		<br>
		
				<!-------- head table with icons to manage the table  -------->
		
		<%int l=0;// running number %>
		
		
		<!-- head of table -->
		
		<div class="row" >
			<div class="dynamicTable1st">&nbsp;</div>
			<div class="dynamicIcon">&nbsp;</div>		
			<div class="dynamicHeadIst">Table Name</div>
			<% for(int j =0; j <maxcolumncount;j++){ %>
				<div class="dynamicHeadIst">	<%="Column ".concat(new Integer(j+1).toString()) %>		</div>
			<%} %>
			<div id="hide_95" class="swHide">
				<%	for (int j =maxcolumncount; j < 15;j++){ %>
					<div class="dynamicHeadIst">	<%="Column ".concat(new Integer(j+1).toString()) %>		</div>
				<%} %>
			</div>
		</div>
		
		<br>
		
		<!-- body of table -->
		
		<%	for(int i=0;i < headList.size();i++){%>
			<div class="row" >
			
				<%
					long headId = headList.get(i).getHeadID();
					int columnCount = ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID());
					List<Column> columnList = ColumnLocalServiceUtil.getColumnsByHeadId(headId);
			
				%>
				
				
				<!--  running number -->
				
				<div class="dynamicTable1st">
					<%=(i+1) %>
					<%l=(i+1); %>
				</div>
				
				
				<!-- manage icons -->
				
				<div class="dynamicIcon">
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("link")%>" 				class="icon-file"  		  onclick="showDiv('#tabContentMenu','<%=headList.get(i).getTable_name() %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("edit")%>" 				class="icon-edit"  		  onclick="hideswitch('<%="91".concat(new Integer(i).toString()) %>','<%="92".concat(new Integer(i).toString()) %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("icon-resize-small")%>" 	class="icon-resize-small" onclick="showhide('<%="93".concat(new Integer(i).toString()) %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("remove")%>" 				class="icon-remove"		  onclick="deleteTable('deleteTable', '<%= headList.get(i).getHeadID()%>', 'tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu')"></i>
				</div>
				
				
				<!-- default information -->
				
				<div id="<%="hide_91".concat(new Integer(i).toString()) %>" class="swMain">
					<div class="dynamicTableIst">
						<label  id="<%= "lavadyta_".concat(new Integer(i).toString()).concat("_").concat("table_name") %>"><%=headList.get(i).getTable_name() %></label>
					</div>
					<%	for (int j =0; j < columnCount;j++){ %>
						<div class="dynamicTableIst">
							<label  id="<%= "lavadyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"><%=columnList.get(j).getColumn_name()  %></label>
						</div>
					<%} %>
				</div>
				

				<!-- change information -->
				<div id="<%="hide_92".concat(new Integer(i).toString()) %>" class="swHide">
					<%int k=0; %>
					
					<!-- hidden informations -->
					<div class="dynamicTableIst">
						<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat("table_name") %>"  	value="<%=headList.get(i).getHeadID() %>" />
						<input class="widthM" 	type="text"		id="<%="dyta_".concat(new Integer(i).toString()).concat("_").concat("table_name")%>"   		value="<%=headList.get(i).getTable_name() %>" />
					</div>
										
					<!-- build change line -->
					<%	for (int j =0; j < columnCount;j++){ %>
						<div class="dynamicTableIst">
							<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString()) %>"  	value="<%=columnList.get(j).getColumnID() %>" />
							<input class="widthM" 	type="text" 	id="<%="dyta_".concat(new Integer(i).toString()).concat("_").concat(new Integer(j).toString())%>"   	value="<%=columnList.get(j).getColumn_name()  %>" />
						</div>
					<%} %>
					
					<!-- icons -->
					<div class="dynamicIcon">
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editplus")%>" 	class="icon-plus" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= columnCount+1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editminus")%>" 	class="icon-minus" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= columnCount-1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= columnCount %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu')"  /></i>
					</div>
				</div>
				
				
				<!-- connection between head tables -->
				
				<div id="<%="hide_93".concat(new Integer(i).toString()) %>" class="swHide">
					<br>
					test
					<br>
				</div>
				
			</div>
		<%} %>
		
		
		<!-- add new Table -->
		
		<div class="row" >
				
			<!--  lus icon -->
			<div class="dynamicTable1st">
				<%=(l+1) %>
			</div>
				
			<!-- manage icons -->
			<div class="dynamicIcon">
				<i style="cursor:pointer" id="<%="newta_".concat("newplus")%>" 	class="icon-plus" 	onclick="iconshowhide('95','96','<%="newta_".concat("newplus")%>')"  /></i>
			</div>
			
			<div id="hide_96" class="swHide">
			
				<%int k=0; %>
				<div class="dynamicTableIst">
					<input 					type="hidden" 	id="<%="topnewta_".concat(new Integer(k).toString()) %>"  		value="<%="name" %>" />
					<input class="widthM" 	type="text"		id="<%="newta_".concat(new Integer(k).toString())%>"   			value="" />
				</div>
				
				<%	for (int j =0; j < 15;j++){ %>
					<div class="dynamicTableIst">
						<%	if(j<10){%>
							<input 				type="hidden" 	id="<%="topnewta_".concat(new Integer(j).toString()) %>"  	value="<%="column0".concat(new Integer(j).toString()) %>" />
						<%}else{ %>
							<input 				type="hidden" 	id="<%="topnewta_".concat(new Integer(j).toString()) %>"  	value="<%="column".concat(new Integer(j).toString()) %>" />
						<%} %>
						<input class="widthM" 	type="text" 	id="<%="newta_".concat(new Integer(j).toString())%>"   		value="" />
					</div>
					<%k=j; %>
				<%} %>
				<%k=k+1; %>
				<div>
					<input 	type="hidden" 	id="<%="topnewta_".concat(new Integer(k).toString()) %>" 	value="<%="headID" %>" />
					<input 	type="hidden"	id="<%="newta_".concat(new Integer(k).toString())%>"   		value="<%="0"%>" />
					<input 	type="hidden"	id="<%="lavanewta_".concat(new Integer(k).toString())%>" 	value="<%="0"%>" />
				</div>
				<div class="dynamicIcon">
					<i style="cursor:pointer" id="<%="newta_".concat("newok")%>" 		class="icon-ok" 	onclick="updateTable('updateTable', '<%="newta" %>', '<%= k+1 %>', 'table','tabTableMenu', '/html/tablebuilder/view.jsp #tabTableMenu')"  /></i>
				</div>
			</div>
		</div>
		
		
	</div>
	


	
<!-------------------------------------------------        Tab: Content Menu       ------------------------------------------------------------------>
<!--------------------------------------------------------------------------------------------------------------------------------------------------->
	
	<div class="section" id='tabContentMenu'>
	
		<br>
		<h2>content menu</h2>	
		<br>
		
		<% String[] names = HeadLocalServiceUtil.getArrayOfTableNames("table"); %>
		
		<%	for (int h=0; h<names.length;h++){ %>
		
			<br>
		
			<div id="<%="hide_accordion_".concat(names[h])%>" onclick="pseudoaccordion('<%=names[h] %>')" style="cursor:pointer;">
				<h4 > <span id="<%="h_".concat(names[h])%>">+</span> <%= names[h] %></h4>
			</div>
					
			<div id= "<%="hide_".concat(names[h])%>" class="swHide">
			
				<br>
				<% 	long[][] contentTable = HeadLocalServiceUtil.getTableAsArray(HeadLocalServiceUtil.getHeadIdByTableName(names[h])); 	%>
				
			</div>
			
		<%} %>
	</div>

<!---------------------------------------------------------------------------------------------------------------------------------------------------->


</div>