<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="tablebuilderURL" var="tablebuilderURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<script src="${pageContext.request.contextPath}/js/main.js"  type="text/javascript"></script>  <!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->

<% List <String> headAttributList = new ArrayList<String>();
	headAttributList.add("headID");
	headAttributList.add("name");
	headAttributList.add("column01");
	headAttributList.add("column02");
	headAttributList.add("column03");
	headAttributList.add("column04");
	headAttributList.add("column05");
	headAttributList.add("column06");
	headAttributList.add("column07");
	headAttributList.add("column08");
	headAttributList.add("column09");
	headAttributList.add("column10");
	headAttributList.add("column11");
	headAttributList.add("column12");
	headAttributList.add("column13");
	headAttributList.add("column14");
	headAttributList.add("column15");
	headAttributList.add("column16");
	headAttributList.add("column17");
	headAttributList.add("column18");
	headAttributList.add("column19");
	headAttributList.add("column20"); %>

<portlet:defineObjects />

<!-- -------------------------------------------- Explanation ---------------------------------------------------------------->

<div id=<%= "accordion_seq_header_explanation" %> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls="accordion_seq_panel_explanation" aria-selected="false"  tabindex="0"    >
	<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
	Explanation
</div>

<div id=<%= "accordion_seq_panel_explanation" %> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby="accordion_seq_header_explanation"   role="tabpanel" aria-expanded="false" aria-hidden="true"   >
	short how to of this functions
</div>

<!-- -------------------------------------------- New Table ---------------------------------------------------------------->

<div id=<%= "accordion_seq_header_newTable" %> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls="accordion_seq_panel_newTable" aria-selected="false"  tabindex="0"    >
	<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
	New Table
</div>

<div id=<%= "accordion_seq_panel_newTable" %> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby="accordion_seq_header_newTable"   role="tabpanel" aria-expanded="false" aria-hidden="true"   >

	<% String stTabI = "newtab_".concat(new Integer(0).toString()); %>

	<div class="swHide"><div class="row">
			<div class="rowLato"> <label id="<%= "lato".concat(stTabI) %>"><%=headAttributList.get(0) %></label></div>
			<div class="hidden"> <label id="<%= "lava".concat(stTabI) %>"></label>&nbsp;</div>
			<div class="rowField"> <input type="text" class="widthL" id="<%= stTabI %>" name="<portlet:namespace/><%= stTabI %>"  value="0" /></div>
	</div></div>

	<%for (int i = 1; i < headAttributList.size(); i++) { %>
		<% stTabI = "newtab_".concat(new Integer(i).toString()); %>
		<div class="row">
			<div class="rowLato"> <label id="<%= "lato".concat(stTabI) %>"><%=headAttributList.get(i) %></label></div>
			<div class="hidden"> <label id="<%= "lava".concat(stTabI) %>"></label>&nbsp;</div>
			<div class="rowField"> <input type="text" class="widthL" id="<%= stTabI %>" name="<portlet:namespace/><%= stTabI %>"  value="" /></div>
		</div>
	<% } %>

	<div class="row">
		<div class="rowLato">&nbsp;</div>
		<div class="rowLava">&nbsp;</div>
		<div class="rowFieldB"> <input  type="button" class="widthL" value="new Table"  onclick="newTable('<%= tablebuilderURL %>', 'newTable','newtab', '<%= headAttributList.size() %>', 'newtab')" /></div>
	</div>

	<div class="swHide" id="hide_newtab_true">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Create new Table is complete.
		</div>
	</div>

	<div class="swHide" id="hide_newtab_false">
		<div class="portlet-msg-error">
			Create new Table failed.
		</div>
	</div>

</div>

<!-- -------------------------------------------- Choose Table ---------------------------------------------------------------->

<div id=<%= "accordion_seq_header_updateTable" %> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls="accordion_seq_panel_updateTable" aria-selected="false"  tabindex="0"    >
	<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
	Change Table Columns
</div>

<div id=<%= "accordion_seq_panel_updateTable" %> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby="accordion_seq_header_updateTable"   role="tabpanel" aria-expanded="false" aria-hidden="true"   >

	<% String[] names = HeadLocalServiceUtil.getNameArray(); %>

	Please select one of the tables.<br>
	<br>

	<form action="select.html">
		<select id="choTab" name="<portlet:namespace/>choTab" onchange="chooseProject('<%= tablebuilderURL %>','chooseTable',this.form.choTab.options[this.form.choTab.selectedIndex].value, 'tab_103')" size="1" style="width:50%">
			<option selected value="none">None </option>
			<%if (names.length>0){for (int i = 0; i < names.length; i++) { %>
					<option value="<%= names[i] %>"> <%= names[i]%> </option>
			<%} } %>
		</select>
	</form>

	<div class="swHide" id="hide_tab_103">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Switch to selected project.
		</div>
	</div>

	<% PortletPreferences prefs = renderRequest.getPreferences();
		String headID =(String)prefs.getValue("choTab", "none");

		String checkID = "none";
		Boolean checker = false;

		if (headID.equals("none")){}
		else {
			for (int i = 0; i < names.length;i++)
			if (names[i].equals(HeadLocalServiceUtil.getName(Long.valueOf(headID).longValue())))
					checker = true;

			if (checker == false)
				checkID = "none";
			else
				checkID = headID.toString();
		}

		if (checkID.equals("none")){}
		else {
	%>

		<!-- -------------------------------------------- Change Table data ---------------------------------------------------------------->

		<div id="updateTable">

			<% Head head = HeadLocalServiceUtil.getRow(Long.valueOf(headID).longValue());
				Map <String, Object> headMap = head.getModelAttributes();
				stTabI = "head_".concat(new Integer(0).toString());
			%>

			<div class="row">
				<div class="swHide">
					<div class="rowLato"><label id="<%= "lato".concat(stTabI) %>"><%= headAttributList.get(0) %></label></div>
					<div class="hidden"><label id="<%= "lava".concat(stTabI) %>"><%= headMap.get(headAttributList.get(0)) %></label></div>
					<div class="rowField"><input type="hidden" class="widthL" id="<%= stTabI %>" name="<portlet:namespace/><%= stTabI %>" value="<%= head.getHeadID() %>"    /></div>
				</div>
			</div>

			<% for (int i = 1; i < headAttributList.size(); i++) { %>
				<div class="row">
				<% stTabI = "head_".concat(new Integer(i).toString());
					Map <String, Object> h = head.getModelAttributes(); %>
					<div class="rowLato"><label id="<%= "lato".concat(stTabI) %>"><%= headAttributList.get(i) %></label></div>
					<div class="hidden"><label id="<%= "lava".concat(stTabI) %>"><%= headMap.get(headAttributList.get(i)) %></label></div>
					<div class="rowField"><input type="text" class="widthL" id="<%= stTabI %>" name="<portlet:namespace/><%= stTabI %>" value="<%= headMap.get(headAttributList.get(i)) %>"    /></div>
				</div>
			<% } %>

			<div class="row">
				<div class="rowLato">&nbsp;</div>
				<div class="rowLava">&nbsp;</div>
				<div class="rowFieldB"><input type="button" class="widthL" value="Change"  onclick=" updateTable('<%=tablebuilderURL %>', 'updateTable', 'head', '<%= headAttributList.size() %>', '104')" /></div>
			</div>
			<p/>

			<div class="swHide" id="hide_104">
				<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
					Data set is updated.
				</div>
			</div>

			<div class="swHide" id="hide_204">
				<div class="portlet-msg-error">
					Update Project failed. Please check the form of your Dates
				</div>
			</div>

		</div>

	<% }; %>

</div>

<!-- -------------------------------------------- build relation between tables ---------------------------------------------------------------->

<div id=<%= "accordion_seq_header_relation" %> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls="accordion_seq_panel_relation" aria-selected="false"  tabindex="0"    >
	<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
	Build relation between tables
</div>

<div id=<%= "accordion_seq_panel_relation" %> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby="accordion_seq_header_relation"   role="tabpanel" aria-expanded="false" aria-hidden="true"   >

		<% String[] names3 = HeadLocalServiceUtil.getNameArray(); %>

	Please select one of the tables.<br>
	<br>

	<form action="select.html">
		<select id="choTab3" name="<portlet:namespace/>choTab3" onchange="chooseProject('<%= tablebuilderURL %>','chooseTable',this.form.choTab3.options[this.form.choTab3.selectedIndex].value, 'tab_1033')" size="1" style="width:50%">
			<option selected value="none">None </option>
			<%if (names3.length>0){for (int i = 0; i < names3.length; i++) { %>
					<option value="<%= names3[i] %>"> <%= names3[i]%> </option>
			<%} } %>
		</select>
	</form>

	<div class="swHide" id="hide_tab_1033">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Switch to selected project.
		</div>
	</div>

	<% prefs = renderRequest.getPreferences();
		String headID3 =(String)prefs.getValue("choTab", "none");

		String checkID3 = "none";
		Boolean checker3 = false;

		if (headID3.equals("none")){}
		else {
			for (int i = 0; i < names3.length;i++)
			if (names3[i].equals(HeadLocalServiceUtil.getName(Long.valueOf(headID3).longValue())))
					checker3 = true;

			if (checker3 == false)
				checkID3 = "none";
			else
				checkID3 = headID3.toString();
		}%>
		

	<%	if (checkID3.equals("none")){}
		else { %>
		
			<% 	String[] names4 = PositionLocalServiceUtil.getNameArray(HeadLocalServiceUtil.getHeadID("gfbio_keytable"));%>

			Please select the table, that will be conect with <%=HeadLocalServiceUtil.getName(Long.valueOf(headID3).longValue()) %>.<br>
			<br>
			
			<form action="select.html">	
				<select id="choTab4" name="<portlet:namespace/>choTab4" onchange="updateRelationTable('<%= tablebuilderURL %>','relationTable', this.form.choTab4.options[this.form.choTab4.selectedIndex].value,'<%=HeadLocalServiceUtil.getName(Long.valueOf(headID3).longValue())%>','tab_1034')" size="1" style="width:50%">
					<option selected value="none">None </option>
					<%if (names4.length>0){for (int i = 0; i < names4.length; i++) { %>
							<option value="<%= names4[i] %>"> <%= names4[i]%> </option>
					<%} } %>
				</select>
			</form>
			
		<div class="swHide" id="hide_tab_1034">
			<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
				Switch to selected project.
			</div>
		</div>
		
		<%} %>


</div>


<!-- -------------------------------------------- Choose Table for new Content (Position) ---------------------------------------------------------------->

<div id=<%= "accordion_seq_header_newTableContent" %> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls="accordion_seq_panel_newTableContent" aria-selected="false"  tabindex="0"    >
	<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
	New Table Content
</div>

<div id=<%= "accordion_seq_panel_newTableContent" %> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby="accordion_seq_header_newTableContent"   role="tabpanel" aria-expanded="false" aria-hidden="true"   >



	<% String[] names2 = HeadLocalServiceUtil.getNameArray(); %>

	Please select one of the tables.<br>
	<br>

	<form action="select.html">
		<select id="choTab2" name="<portlet:namespace/>choTab2" onchange="chooseProject('<%= tablebuilderURL %>','chooseTable',this.form.choTab2.options[this.form.choTab2.selectedIndex].value, 'tab_1032')" size="1" style="width:50%">
			<option selected value="none">None </option>
			<%if (names2.length>0){for (int i = 0; i < names2.length; i++) { %>
					<option value="<%= names2[i] %>"> <%= names2[i]%> </option>
			<%} } %>
		</select>
	</form>

	<div class="swHide" id="hide_tab_1032">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Switch to selected project.
		</div>
	</div>

	<% prefs = renderRequest.getPreferences();
		String headID2 =(String)prefs.getValue("choTab", "none");

		String checkID2 = "none";
		Boolean checker2 = false;

		if (headID2.equals("none")){}
		else {
			for (int i = 0; i < names2.length;i++)
			if (names2[i].equals(HeadLocalServiceUtil.getName(Long.valueOf(headID2).longValue())))
					checker2 = true;

			if (checker2 == false)
				checkID2 = "none";
			else
				checkID2 = headID2.toString();
		}
		%>

		<%
		if (checkID2.equals("none")){}
		else { %>

		<!-- --------------------------------------- new content of a table -------------------------->

		<% String stContI = "newcont_".concat(new Integer(0).toString());
			int columncount = HeadLocalServiceUtil.getColumnCount(Long.valueOf(headID2).longValue()); %>

		<%
			List <String> positionAttributList = new ArrayList<String>();
			positionAttributList.add("positionID");
			positionAttributList.add("headID");
			for (int i =1; i <= columncount;i++) {
				positionAttributList.add(HeadLocalServiceUtil.getColumnName(Long.valueOf(headID2).longValue(),i).trim());
			}
		%>

		<div class="swHide"><div class="row">
				<% stContI = "newcont_".concat(new Integer(0).toString()); %>
				<div class="rowLato"> <label id="<%= "lato".concat(stContI) %>"><%=positionAttributList.get(0) %></label></div>
				<div class="hidden"> <label id="<%= "lava".concat(stContI) %>"></label>&nbsp;</div>
				<div class="rowField"> <input type="text" class="widthL" id="<%= stContI %>" name="<portlet:namespace/><%= stContI %>"  value="0" /></div>
		</div></div>

		<div class="swHide"><div class="row">
				<% stContI = "newcont_".concat(new Integer(1).toString()); %>
				<div class="rowLato"> <label id="<%= "lato".concat(stContI) %>"><%=positionAttributList.get(1) %></label></div>
				<div class="hidden"> <label id="<%= "lava".concat(stContI) %>"></label>&nbsp;</div>
				<div class="rowField"> <input type="text" class="widthL" id="<%= stContI %>" name="<portlet:namespace/><%= stContI %>"  value="<%=headID2 %>" /></div>
		</div></div>

		<%for (int i = 2; i < positionAttributList.size(); i++) { %>
			<% stContI = "newcont_".concat(new Integer(i).toString()); %>
			<div class="row">
				<div class="rowLato"> <label id="<%= "lato".concat(stContI) %>"><%=positionAttributList.get(i) %></label></div>
				<div class="hidden"> <label id="<%= "lava".concat(stContI) %>"></label>&nbsp;</div>
				<div class="rowField"> <input type="text" class="widthL" id="<%= stContI %>" name="<portlet:namespace/><%= stContI %>"  value="" /></div>
			</div>
		<% } %>

		<div class="row">
			<div class="rowLato">&nbsp;</div>
			<div class="rowLava">&nbsp;</div>
			<div class="rowFieldB"> <input  type="button" class="widthL" value="new Content"  onclick="updateTable('<%= tablebuilderURL %>', 'newContent','newcont', '<%= positionAttributList.size() %>', 'newcont')" /></div>
		</div>

		<div class="swHide" id="hide_newcont">
			<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
				Create new content of Table <%= HeadLocalServiceUtil.getName(Long.valueOf(headID2).longValue()) %> is complete.
			</div>
		</div>


	<%} %>

</div>