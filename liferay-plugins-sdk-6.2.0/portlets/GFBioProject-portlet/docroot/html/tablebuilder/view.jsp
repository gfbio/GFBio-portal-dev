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
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editplus")%>" 	class="icon-plus" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= columnCount+1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu','<%=i %>')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editminus")%>" 	class="icon-minus" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= columnCount-1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu','<%=i %>')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(i).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(i).toString()) %>', '<%= columnCount %>',   'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu','<%=i %>')"  /></i>
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
					<i style="cursor:pointer" id="<%="newta_".concat("newok")%>" 		class="icon-ok" 	onclick="updateTable('updateTable', '<%="newta" %>', '<%= k+1 %>', 'entity','tabTableMenu', '/html/tablebuilder/view.jsp #tabTableMenu','<%=l %>')"  /></i>
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
		
		<!-- -------------------------------------------- Choose Table for new Content (Position) ---------------------------------------------------------------->
	
		
		<% String[] names = HeadLocalServiceUtil.getArrayOfTableNames("entity"); %>
		
		
		<%	for (int h=0; h<names.length;h++){ %>
		
			<div id="<%="hide_accordion_".concat(names[h])%>" onclick="pseudoaccordion('<%=names[h] %>')" style="cursor:pointer;">
				<h4 > <span id="<%="h_".concat(names[h])%>">+</span> <%= names[h] %></h4>
			</div>
					
			<div id= "<%="hide_".concat(names[h])%>" class="swHide">
			
			
				<br>
				<% 	
					String[][] contentTable = HeadLocalServiceUtil.getTableAsArray(HeadLocalServiceUtil.getHeadIdByTableName(names[h])); 
					long[][]        idTable = HeadLocalServiceUtil.getIdTableAsArray(HeadLocalServiceUtil.getHeadIdByTableName(names[h]));
				%>
				
				<!-- head of content table -->
				
				<div class="row" >
					<div class="dynamicTable1st">&nbsp;</div>
					<div class="dynamicIcon">&nbsp;</div>		
						
					<% for(int x =1; x <contentTable.length;x++){ %>
						<div class="dynamicHeadIst">	<%=contentTable[x][0] %>		</div>
						<input 	type="hidden" 	id="<%= "dycon_".concat(new Integer(x).toString()).concat("_columID") %>" 	value="<%=idTable[x][0] %>" />
					<%} %>
				</div>	
					
				<!-- body of table -->
				
				<% int runningNumber = 0; %>
					
				<%	for(int y=1;y < contentTable[0].length;y++){%>
						
					<div class="row" >
						
						
						
						<div class="dynamicTable1st">
							<%=(y) %>
							<% runningNumber=(y); %>
							<input 	type=hidden 	id="<%= "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(runningNumber).toString()).concat("_rowID") %>" 	value="<%=idTable[0][y] %>" />
						</div>
							
						<!-- manage icons -->
						
						<div class="dynamicIcon">
							<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("edit")%>" 				class="icon-edit"  		  onclick="hideswitch('<%="97".concat(new Integer(h).toString()).concat(new Integer(y).toString()) %>','<%="98".concat(new Integer(h).toString()).concat(new Integer(y).toString()) %>')"></i>&nbsp;
							<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("icon-resize-small")%>" 	class="icon-resize-small" onclick="showhide('<%="93".concat(new Integer(h).toString()).concat(new Integer(y).toString()) %>')"></i>&nbsp;
							<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("remove")%>" 				class="icon-remove"		  onclick="deleteContent('deleteContent', '<%= contentTable[0][y]%>', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu')"></i>
						</div>
							
							
						<!-- default information -->
						
						<div id="<%="hide_97".concat(new Integer(h).toString()).concat(new Integer(y).toString()) %>" class="swMain">
							<div class="dynamicTableIst">
								<label  id="<%= "lavadycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("_").concat(new Integer(1).toString()) %>"><%=contentTable[1][y]%></label>
							</div>
							<%if(contentTable.length>1){	for (int x =2; x < contentTable.length;x++){ %>
									<div class="dynamicTableIst">
										<label  id="<%= "lavadycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString()) %>"><%=contentTable[x][y] %></label>
									</div>
							<%}} %>
						</div>
							
							
						<!-- change information -->
						
						<div id="<%="hide_98".concat(new Integer(h).toString()).concat(new Integer(y).toString()) %>" class="swHide">

							<div>
								<input 	type="hidden" 	id="<%= "topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString()) %>" 	value="contentID" />
								<input 	type="hidden"	id="<%=    "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>"   	value="<%=contentTable[0][y].trim() %>" />
								<input 	type="hidden"	id="<%="lavadycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>" 	value="<%=contentTable[0][y].trim() %>" />
							</div>
							<% int x =0; %>
							<%	for (int xsub =1; xsub < (contentTable.length);xsub++){ %>
								<div class="dynamicTableIst">
									<input 					type="hidden" 	id="<%="topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(xsub).toString()) %>"  	value="<%=idTable[xsub][y] %>" />
									<input class="widthM" 	type="text" 	id="<%=   "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(xsub).toString()) %>"   	value="<%=contentTable[xsub][y].trim() %>" />
								</div>
								<%x=xsub; %>
							<%} %>
							<%x=x+1; %>
							<div>
								<input 	type="hidden" 	id="<%= "topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString()) %>" 	value="headID" />
								<input 	type="hidden"	id="<%=    "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString())%>"   	value="<%=HeadLocalServiceUtil.getHeadIdByTableName(names[h]) %>" />
								<input 	type="hidden"	id="<%="lavadycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString())%>" 	value="<%=HeadLocalServiceUtil.getHeadIdByTableName(names[h]) %>" />
							</div>
								
							<div class="dynamicIcon">
								<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateContent', '<%="dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>', '<%= x-1 %>', 'entity','tabContentMenu','<%="/html/tablebuilder/view.jsp #tabContentMenu"%>','<%=h %>')"  /></i>
							</div>
								
						</div>
						
					</div>
	
				<%} %>
				
					
				<!---- add new row ---->
					
				<div class="row" >
					
					<!--  running number -->
						
					<div class="dynamicTable1st">
						
						<% runningNumber++; %>
						<%=(runningNumber) %>
						<%int y = runningNumber; %>
						<input 	type=hidden 	id="<%= "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(runningNumber).toString()).concat("_rowID") %>" 	value="0" />
					</div>
							
						
					<!-- manage icons -->
						
					<div class="dynamicIcon">
						
						<i style="cursor:pointer" id="<%="dycon_".concat("newplus")%>" 	class="icon-plus" 	onclick="showhide('<%="99".concat(new Integer(h).toString()) %>')"></i>
					</div>
						
						
					<!-- add content -->
						
					<div id="<%="hide_99".concat(new Integer(h).toString()) %>" class="swHide">
						
						<% int x =0; %>
						<div>
							<input 	type="hidden" 	id="<%= "topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>" 	value="contentID" />
							<input 	type="hidden"	id="<%=    "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>"   	value="0" />
							<input 	type="hidden"	id="<%="lavadycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>" 	value="0" />
						</div>
								
						<%	for (int xsub =1; xsub < contentTable.length;xsub++){ %>
							<div class="dynamicTableIst">
								<input 					type="hidden" 	id="<%="topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(xsub).toString()) %>"  	value="0" />
								<input class="widthM" 	type="text" 	id="<%=   "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(xsub).toString()) %>"   	value="" />
							</div>
							<%x=xsub; %>
						<%} %>
						<%x=x+1; %>
							
						<div>
							<input 	type="hidden" 	id="<%= "topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>" 	value="headID" />
							<input 	type="hidden"	id="<%=    "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString())%>"   	value="<%=HeadLocalServiceUtil.getHeadIdByTableName(names[h]) %>" />
							<input 	type="hidden"	id="<%="lavadycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString())%>" 		value="<%=HeadLocalServiceUtil.getHeadIdByTableName(names[h]) %>" />
						</div>
							
						<div class="dynamicIcon">
							<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(x).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateContent', '<%="dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>', '<%= x-1 %>', 'entity','tabContentMenu', '/html/tablebuilder/view.jsp #tabContentMenu','<%=h %>')"  /></i>

						</div>
						
					</div>		
				</div>
			</div>
		<%} %>
	</div>

<!---------------------------------------------------------------------------------------------------------------------------------------------------->


</div>