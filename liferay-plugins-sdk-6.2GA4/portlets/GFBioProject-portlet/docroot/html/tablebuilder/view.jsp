<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="tablebuilderURL" var="tablebuilderURL" />
<portlet:actionURL  var="tablebuilderactionURL" portletMode="view"/>
<meta charset="UTF-8">

<%@ include file="/html/init.jsp" %> <!-- library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 					type="text/javascript"></script>  	<!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/css/main.css"	 rel="stylesheet" 	type="text/css"> 					<!-- main.css imports -->

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
	
		<%	
			List <Head> headList = HeadLocalServiceUtil.getHeadsByTableType("entity"); 
			int maxcolumncount = ColumnLocalServiceUtil.getMaxCountofColumns(headList); 
		%>
		<br>
		<h2>table menu</h2>
		<br>
		
		<!-------- head table with icons to manage the table  -------->
		
		<%int runningTableNumber=0;// running number %>
		
		
		<!-- head of table -->
		
		<div class="row" >
			<div class="dynamicTable1st">&nbsp;</div>
			<div class="dynamicIcon">&nbsp;</div>		
			<div class="dynamicHeadIst">Table Name</div>
			<% for(int x =0; x <maxcolumncount;x++){ %>
				<div class="dynamicHeadIst">	<%="Column ".concat(new Integer(x+1).toString()) %>		</div>
			<%} %>
			<div id="hide_95" class="swHide">
			</div>
		</div>
		<br>
		
		
		<!-- body of table -->
		
		<%	for(int y=0;y < headList.size();y++){%>
			<div class="row" >
			
				<%
					long headId = headList.get(y).getHeadID();
					int columnCount = ColumnLocalServiceUtil.getCountofColumns(headList.get(y).getHeadID());
					List<Column> columnList = ColumnLocalServiceUtil.getColumnsByHeadId(headId);
				%>
				
				
				<!--  running number -->
				
				<div class="dynamicTable1st">
					<%=(y+1) %>
					<%runningTableNumber=(y+1); %>
				</div>
				
				
				<!-- manage icons -->
				
				<div class="dynamicIcon">
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("link")%>" 				class="icon-file"  		  onclick="showDiv('#tabContentMenu','<%=headList.get(y).getTable_name() %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("edit")%>" 				class="icon-edit"  		  onclick="hideswitch('<%="91".concat(new Integer(y).toString()) %>','<%="92".concat(new Integer(y).toString()) %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("icon-resize-small")%>" 	class="icon-resize-small" onclick="showhide('<%="93".concat(new Integer(y).toString()) %>')"></i>&nbsp;
					<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("remove")%>" 				class="icon-remove"		  onclick="deleteTable('deleteTable', <%= headList.get(y).getHeadID()%>, 'tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu')"></i>
				</div>
				
				
				<!-- default information -->
				
				<div id="<%="hide_91".concat(new Integer(y).toString()) %>" class="swMain">
					<div class="dynamicTableIst">
						<label  id="<%= "lavadyta_".concat(new Integer(y).toString()).concat("_").concat("table_name") %>"><%=headList.get(y).getTable_name() %></label>
					</div>
					<%	for (int x =0; x < columnCount;x++){ %>
						<div class="dynamicTableIst">
							<label  id="<%= "lavadyta_".concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString()) %>"><%=columnList.get(x).getColumn_name()  %></label>
						</div>
					<%} %>
				</div>
				

				<!-- change information -->
				
				<div id="<%="hide_92".concat(new Integer(y).toString()) %>" class="swHide">
					<%int x=0; %>
					
					<!-- hidden informations -->
					<div class="dynamicTableIst">
						<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(y).toString()).concat("_").concat("table_name") %>"  	value="<%=headList.get(y).getHeadID() %>" />
						<input class="widthM" 	type="text"		id="<%="dyta_".concat(new Integer(y).toString()).concat("_").concat("table_name")%>"   		value="<%=headList.get(y).getTable_name() %>" />
					</div>
					
										
					<!-- build change line -->
					
					<%	for (int xsub =0; xsub < columnCount;xsub++){ %>
						<div class="dynamicTableIst">
							<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(y).toString()).concat("_").concat(new Integer(xsub).toString()) %>"  	value="<%=columnList.get(xsub).getColumnID() %>" />
							<input class="widthM" 	type="text" 	id="<%="dyta_".concat(new Integer(y).toString()).concat("_").concat(new Integer(xsub).toString())%>"   		value="<%=columnList.get(xsub).getColumn_name()  %>" />
						</div>
						<%x =xsub; %>
					<%} %>
					
					
					<!-- icons -->
					
					<div class="dynamicIcon">
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("editplus")%>" 	class="icon-plus" 	onclick="updateTable('addColumnToTable', '<%="dyta_".concat(new Integer(y).toString()) %>', '<%= columnCount+1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu','<%=y %>')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("editminus")%>" 	class="icon-minus" 	onclick="deleteColumn('deleteColumn', '<%=columnList.get(x).getColumnID() %>', 'tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu')"  /></i>&nbsp;
						<i style="cursor:pointer" id="<%="dyta_".concat(new Integer(y).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(y).toString()) %>', '<%= columnCount %>',   'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu','<%=y %>')"  /></i>
					</div>
				</div>
			</div>
				
				
			<!-- connection between head tables -->
			
			<div id="<%="hide_93".concat(new Integer(y).toString()) %>" class="swHide">
				<br>
				<%
					String tableName = headList.get(y).getTable_name();
					List <Column> withRelationList = ColumnLocalServiceUtil.getColumnsWithRelation(tableName);
					List  withoutRelationList = ColumnLocalServiceUtil.getHeadIdsWithoutRelationshipsByColumnName(tableName);
				%>
				<div class="row" >
					<div class="dynamicTable1st">&nbsp;	</div>
					<div class="dynamicIcon">&nbsp; </div>
					<div class="dynamicTableIst">No Relationship with:</div>
					<div class="dynamicTableIst">Relationship with:</div>
				</div>
					
				<div class="row" >
					<div class="dynamicTable1st">&nbsp;	</div>
					<div class="dynamicIcon">&nbsp; </div>
					<div class="dynamicTableIst">
						<form>	<select name="<%="withoutRelationship_".concat(new Integer(y).toString()) %>" size="<%=withoutRelationList.size() %>" onclick="updateRelationTable ('relationTable', '<%=tableName %>', <%="this.form.withoutRelationship_".concat(new Integer(y).toString()).concat(".options[this.form.withoutRelationship_").concat(new Integer(y).toString()).concat(".selectedIndex].value") %>,'tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu')"> 
								<%for(int ysub=0;ysub<withoutRelationList.size();ysub++){ %>
									<option value="<%=HeadLocalServiceUtil.getTableNameById( (Long) withoutRelationList.get(ysub)) %>"><%=HeadLocalServiceUtil.getTableNameById( (Long) withoutRelationList.get(ysub)) %></option> 
								<%} %>
						</select> </form>
					</div>
					&nbsp;
					<div class="dynamicTableIst">
						<form>	<select name="<%="withRelationship_".concat(new Integer(y).toString()) %>" size="<%=withRelationList.size() %>" onchange="deleteTable('deleteTable', <%="this.form.withRelationship_".concat(new Integer(y).toString()).concat(".options[this.form.withRelationship_").concat(new Integer(y).toString()).concat(".selectedIndex].value") %>, 'tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu')"> 
								<%for(int ysub=0;ysub<withRelationList.size();ysub++){ %>
									<option value=<%=HeadLocalServiceUtil.getHeadIdByTableName(HeadLocalServiceUtil.constructRelationName(tableName, withRelationList.get(ysub).getColumn_name()))%>><%=withRelationList.get(ysub).getColumn_name() %></option> 
								<%} %>
						</select> </form>
					</div>
				</div>
				<br>
			</div>
		<%} %>
		
		
		<!-- add new Table -->
		
		<div class="row" >
			<%
				if(runningTableNumber ==runningTableNumber)
				{
					int y = runningTableNumber;
			%>


				<!--  lus icon -->
				
				<div class="dynamicTable1st">
					<%=y+1 %>
				</div>
				
				
				<!-- manage icons -->
				
				<div class="dynamicIcon">
					<i style="cursor:pointer" id="<%="dyta_".concat("newplus")%>" 	class="icon-plus" 	onclick="iconshowhide('95','96','<%="dyta_".concat("newplus")%>')"  /></i>
				</div>
				
				<div id="hide_96" class="swHide">
				
					<div class="dynamicTableIst">
						<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(y).toString()).concat("_").concat("table_name") %>"  		value="<%="0" %>" />
						<input class="widthM" 	type="text"		id="<%="dyta_".concat(new Integer(y).toString()).concat("_").concat("table_name")%>"   			value="gfbio_" />
					</div>
					
					<% int columncount = 1; %>
					<%	for (int x =0; x < columncount;x++){ %>
						<div class="dynamicTableIst">
							<input 					type="hidden" 	id="<%="topdyta_".concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString()) %>"  	value="<%=0 %>" />
							<input class="widthM" 	type="text" 	id="<%="dyta_".concat(new Integer(y).toString()).concat("_").concat(new Integer(x).toString())%>"   	value="" />
						</div>
					<%} %>
					<div>
						<input 	type="hidden" 	id="<%="topdyta_".concat(new Integer(y).toString()) %>" 	value="<%="headID" %>" />
						<input 	type="hidden"	id="<%="dyta_".concat(new Integer(y).toString())%>"   		value="<%="0"%>" />
						<input 	type="hidden"	id="<%="lavadyta_".concat(new Integer(y).toString())%>" 	value="<%="0"%>" />
					</div>
					<div class="dynamicIcon">
						<i style="cursor:pointer" id="<%="dyta_".concat("newok")%>" 	class="icon-ok" 	onclick="updateTable('updateTable', '<%="dyta_".concat(new Integer(y).toString()) %>', '<%= columncount %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu','<%=y %>')"  /></i>
					</div>
				</div>
			<%} %>
		</div>
	</div>

	
<!-------------------------------------------------        Tab: Content Menu       ------------------------------------------------------------------>
<!--------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	<div class="section" id='tabContentMenu'>
	
		<br>
		<h2>content menu</h2>	
		<br>
		
		
		<!-- -------------------------------------------- Choose Table for new Content (Content) ---------------------------------------------------------------->
		
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
							<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("icon-resize-small")%>" 	class="icon-resize-small" onclick="showhide('<%="93_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>')"></i>&nbsp;
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
								<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(y).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateContent', '<%="dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>', '<%= x-1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu','tabContentMenu','<%="/html/tablebuilder/view.jsp #tabContentMenu"%>','<%=h %>')"  /></i>
							</div>
								
						</div>
						
					</div>
				
				
					<!---- manage the content relations ---->	
					
					<div id="<%="hide_93_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>" class="swHide">
						
						<%
							String tableName = headList.get(h).getTable_name();
							List <Column> withRelationList = ColumnLocalServiceUtil.getColumnsWithRelation(tableName);
						%>
						<div class="row" >
							<div class="dynamicTable1st">&nbsp;	</div>
							<div class="dynamicIcon">&nbsp; </div>
							<div class="dynamicTableIst">choose Entity:</div>
							<div class="dynamicTableIst">No Relationship with:</div>
							<div class="dynamicTableIst">Relationship with:</div>
						</div>
						
						<div class="row" >
							<div class="dynamicTable1st">&nbsp;	</div>
							<div class="dynamicIcon">&nbsp; </div>
							<div class="dynamicTableIst">
								<%
									int contentSize = 2;
									if (withRelationList.size()>2)
										contentSize = withRelationList.size();
								%>
								<form>	<select id="<%="entiesWithRelationship_".concat(new Integer(y).toString()) %>" name="<%="entiesWithRelationship_".concat(new Integer(y).toString()) %>" size="<%=contentSize %>" onclick="chooseTableForRelationship('chooseTableForRelationship', <%=idTable[0][y] %>, <%=idTable[0][0] %>,<%="this.form.entiesWithRelationship_".concat(new Integer(y).toString()).concat(".options[this.form.entiesWithRelationship_").concat(new Integer(y).toString()).concat(".selectedIndex].value") %>,'<%=tablebuilderURL%>','<%="withoutRelationship_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>', '<%="withRelationship_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>')"> 
										<%for(int ysub=0;ysub<withRelationList.size();ysub++){ %>
											<option value=<%=HeadLocalServiceUtil.getHeadIdByTableName(withRelationList.get(ysub).getColumn_name())%>><%=withRelationList.get(ysub).getColumn_name() %></option> 
										<%} %>
								</select> </form>
							</div>
							&nbsp;
							<div class="dynamicTableIst">
								<form>	<select id="<%="withoutRelationship_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>"  name="<%="withoutRelationship_".concat(new Integer(y).toString()) %>" size="<%=2 %>" onclick="updateRelationContent ('relationContent', '<%=tableName %>', <%=idTable[0][y] %> , <%="this.form.withoutRelationship_".concat(new Integer(y).toString()).concat(".options[this.form.withoutRelationship_").concat(new Integer(y).toString()).concat(".selectedIndex].value") %> ,'tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu' )"> 
										<%for(int ysub=0;ysub<0;ysub++){ %>
										<%} %>
								</select> </form>
							</div>
							&nbsp;
							<div class="dynamicTableIst">																																																	
								<form>	<select id="<%="withRelationship_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>" name="<%="withRelationship_".concat(new Integer(y).toString()) %>" size="<%=2 %>" onclick="deleteRelationContent('deleteRelationContent', <%=idTable[0][y] %> , <%="this.form.withRelationship_".concat(new Integer(y).toString()).concat(".options[this.form.withRelationship_").concat(new Integer(y).toString()).concat(".selectedIndex].value") %>, 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu')"> 
										<%for(int ysub=0;ysub<0;ysub++){ %>
										<%} %>
								</select> </form>
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
						<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat("_").concat("newplus")%>" 	class="icon-plus" 	onclick="iconshowhidesinmple('<%="99".concat(new Integer(h).toString()) %>','<%="dycon_".concat(new Integer(h).toString()).concat("_").concat("newplus")%>')"></i>
					</div>
						
						
					<!-- add content -->
						
					<div id="<%="hide_99".concat(new Integer(h).toString()) %>" class="swHide">
						
						<% int x =0; %>
						<div>
							<input 	type="hidden" 	id="<%= "topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>" 	value="contentID" />
							<input 	type="hidden"	id="<%=    "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>"   	value="0" />
							<input 	type="hidden"	id="<%="lavadycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(0).toString())%>" 	value="0" />
						</div>
								
						<div class="dynamicTableIst">
							<input 					type="hidden" 	id="<%="topdycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(1).toString()) %>"  	value="0" />
							<input class="widthM" 	type="hidden" 	id="<%=   "dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()).concat("_").concat(new Integer(1).toString()) %>"   	value="0" />
							<label class="widthM">  will be build</label>				
						</div>

						<%	for (int xsub =2; xsub < contentTable.length;xsub++){ %>
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
							<i style="cursor:pointer" id="<%="dycon_".concat(new Integer(h).toString()).concat(new Integer(x).toString()).concat("editok")%>" 		class="icon-ok" 	onclick="updateTable('updateContent', '<%="dycon_".concat(new Integer(h).toString()).concat("_").concat(new Integer(y).toString()) %>', '<%= x-1 %>', 'entity','tabTableMenu','/html/tablebuilder/view.jsp #tabTableMenu', 'tabContentMenu','/html/tablebuilder/view.jsp #tabContentMenu','<%=h %>')"  /></i>

						</div>
						
					</div>		
				</div>
			</div>
		<%} %>
	</div>
	
</div>