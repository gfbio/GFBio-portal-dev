<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="projectprofileURL" var="projectprofileURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/docroot/js/main.js"       type="text/javascript"></script>  <!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/docroot/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->






<body >

	<%if (PortalUtil.getUser(request)==null){ %>
	
		<div class="portlet-msg-alert">
			Please sign in to use the project profile.
		</div>

	<%}else { %>

		<%
			Long userID = PortalUtil.getUserId(request);
			List <Project> projectList = new ArrayList<Project>();
			projectList = null;
			try {
				 projectList = ProjectLocalServiceUtil.getProjectList(userID);
			} catch (NoSuchModelException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		%>

		<%
			userID = PortalUtil.getUserId(request);
			List <String> attributList = new ArrayList<String>();
			attributList.add("projectID");
			attributList.add("name");
			attributList.add("label");
			attributList.add("description");
			attributList.add("startDate");
			attributList.add("endDate");
			attributList.add("status");
			projectList = null;
			try {
				 projectList = ProjectLocalServiceUtil.getProjectList(userID);
			} catch (NoSuchModelException e)	{e.printStackTrace();
			} catch (SystemException e) 		{e.printStackTrace();}
		%>

		<p/>

		<h2>Project Profile</h2>
		<br>

		<br>
		All data that we store for the user, have an user or a project reference. Here you can see all of the stored data to a selected project.<br>
		<br>

		<div class="portlet-msg-alert">
			Please use the form yyyy-mm-dd for all Dates in the project profile.
		</div>

		<!------------------------------------------------ First New Project -------------------------------------------------------------------->

		<%if (projectList.size()==0){ %>

			<% String stProjI;
				stProjI = "newprous_".concat(new Integer(0).toString()); %>
			<div class="swHide">
				<div class="rowLato"> <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(0) %></label></div>
				<div class="hidden"> <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
				<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="0" /></div>
			</div>
			<% for (int i = 1; i < attributList.size(); i++) { %>
				<% stProjI = "newprous_".concat(new Integer(i).toString()); %>
				<div class="row">
					<div class="rowLato"> <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(i) %></label></div>
					<div class="hidden"> <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
					<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></div>
				</div>
			<% } %>
			<div class="row">
				<div class="rowLato">&nbsp;</div>
				<div class="rowLava">&nbsp;</div>
				<div class="rowFieldB"> <input  type="button" class="widthL" value="new Project"  onclick="newProject('<%= projectprofileURL %>', 'newProject','newprous', '<%= attributList.size() %>', '102', <%= userID %>)" /></div>
			</div>

			<div class="swHide" id="hide_102">
				<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
					Create new Project is complete.
				</div>
			</div>

			<div class="swHide" id="hide_202">
				<div class="portlet-msg-error">
					Create new Project failed. Please check the form of your Dates
				</div>
			</div>

		<%}else { %>

			<!------------------------------------------------ Choose Project -------------------------------------------------------------------->

			<% projectList = null;
				try {
					 projectList = ProjectLocalServiceUtil.getProjectList(userID);
				} catch (NoSuchModelException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			%>

			Please select one of your projects or start a new one.<br>
			<br>

			<form action="select.html">
				<select id="choPro" name="<portlet:namespace/>choPro" onchange="chooseProject('<%= projectprofileURL %>','choosePro',this.form.choPro.options[this.form.choPro.selectedIndex].value, '103')" size="1" style="width:50%">
					<option selected value="none">None </option>
					<%if (projectList.size()>0){for (int i = 0; i < projectList.size(); i++) { %>
						<option value="<%= projectList.get(i).getProjectID() %>"> <%= projectList.get(i).getLabel() %> </option>
					<%} } %>
				</select>
			</form>

			<div class="swHide" id="hide_103">
				<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
					Switch to selected project.
				</div>
			</div>

			<div id="hide_but_newpro" onclick="pseudoaccordion('newpro')" style="cursor:pointer;">
				<h4 > <span id="h_newpro">+</span> new project </h4>
			</div>

			<% PortletPreferences prefs = renderRequest.getPreferences();
				String projectID =(String)prefs.getValue("choPro", "none"); %>

			<!-- ----------------------------------------------- New Project -------------------------------------------------------- -->

			<div class="swHide" id="hide_newpro">

				<% String stProjI;
					stProjI = "newpro_".concat(new Integer(0).toString()); %>

				<div class="swHide"><div class="row">
					<div class="rowLato"> <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(0) %></label></div>
					<div class="hidden"> <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
					<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="0" /></div>
				</div></div>

				<%for (int i = 1; i < attributList.size(); i++) { %>
					<% stProjI = "newpro_".concat(new Integer(i).toString()); %>
					<div class="row">
						<div class="rowLato"> <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(i) %></label></div>
						<div class="hidden"> <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
						<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></div>
					</div>
				<% } %>

				<div class="row">
					<div class="rowLato">&nbsp;</div>
					<div class="rowLava">&nbsp;</div>
					<div class="rowFieldB"> <input  type="button" class="widthL" value="new Project"  onclick="newProject('<%= projectprofileURL %>', 'newProject','newpro', '<%= attributList.size() %>', '100001', <%= userID %>)" /></div>
				</div>

				<div class="swHide" id="hide_100001">
					<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
						Create new Project is complete.
					</div>
				</div>

				<div class="swHide" id="hide_200001">
					<div class="portlet-msg-error">
						Create new Project failed. Please check the form of your Dates
					</div>
				</div>

			</div>
			
			<!-- -------------------------------- choose project check ------------------------------------------------->

			<%	String checkID = "none";
				Boolean checker = false;

				if (projectID.equals("none")){}
				else {
					for (int i = 0; i < projectList.size();i++)
						if (projectList.get(i).getProjectID() == Long.valueOf(projectID).longValue())
							checker = true;
					if (checker == false)
						checkID = "none";
					else
						checkID = projectID.toString();
				}
				
				if (checkID.equals("none")){}
				else {
			%>

			<!-- -------------------------------------------- Change Project data ---------------------------------------------------------------->

				<div id="updateProject">
					<h3> general project data</h3>

					<% Project project = ProjectLocalServiceUtil.getProject(Long.valueOf(projectID).longValue());
						Map <String, Object> projectMap = project.getModelAttributes();
						stProjI = "project_".concat(new Integer(0).toString());
					%>

					<div class="row">
						<div class="swHide">
							<div class="rowLato"><label id="<%= "lato".concat(stProjI) %>"><%= attributList.get(0) %></label></div>
							<div class="hidden"><label id="<%= "lava".concat(stProjI) %>"><%= projectMap.get(attributList.get(0)) %></label></div>
							<div class="rowField"><input type="hidden" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= project.getProjectID() %>"    /></div>
						</div>
					</div>

					<% for (int i = 1; i < attributList.size(); i++) { %>
						<div class="row">
							<% stProjI = "project_".concat(new Integer(i).toString());
							Map <String, Object> foo = project.getModelAttributes(); %>
							<div class="rowLato"><label id="<%= "lato".concat(stProjI) %>"><%= attributList.get(i) %></label></div>
							<div class="hidden"><label id="<%= "lava".concat(stProjI) %>"><%= projectMap.get(attributList.get(i)) %></label></div>
							<div class="rowField"><input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= projectMap.get(attributList.get(i)) %>"    /></div>
						</div>
					<% } %>

					<div class="row">
						<div class="rowLato">&nbsp;</div>
						<div class="rowLava">&nbsp;</div>
						<div class="rowFieldB"><input type="button" class="widthL" value="Change"  onclick=" updateProject('<%= projectprofileURL %>', 'updateProject', 'project', '<%= attributList.size() %>', '104', '<%= userID %>')" /></div>
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

					<!-- ------------------------------------------Research Object ----------------------------------------------------------- -->

					<h3>research object</h3>

					<%List <ResearchObject> researchObjectList = ProjectLocalServiceUtil.getResearchObjectList(Long.valueOf(projectID).longValue(), userID); %>

					<div id="hide_but_roseq" onclick="pseudoaccordion('roseq')" style="cursor:pointer;">
						<h4 > <span id="h_roseq">+</span> sequence data (<%= researchObjectList.size() %>)</h4>
					</div>

					<div id= "hide_roseq" class="swHide">

						<p>

						<% if (researchObjectList.size() != 0){for (int j = 0; j < researchObjectList.size(); j++) { %>
								<% int h = j+1;
									ResearchObject researchObject = researchObjectList.get(j);
									long researchObjectID = researchObject.getResearchObjectID();
									JSONParser parser = new JSONParser();
										JSONObject metadata = new JSONObject();
										try {
											metadata = (JSONObject) parser.parse(researchObject.getExtendeddata());
										} catch (ParseException e1) {
											e1.printStackTrace();
										}
										Set <String> keySet = metadata.keySet();
										String[] keyArray = keySet.toArray(new String[0]);
								%>

								<p>

								<div id=<%= "accordion_seq_header_"+h %> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls=<%= "accordion_seq_panel_"+h %> aria-selected="false"  tabindex="0"    >
									<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
									<%= "MIxS-compliant Genomic Contextual Data of ".concat(researchObject.getLabel()) %>
								</div>

								<div id=<%= "accordion_seq_panel_"+h %> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby=<%= "accordion_seq_header_"+h %>   role="tabpanel" aria-expanded="false" aria-hidden="true"   >
									<% if (metadata.size() !=0){ %>
										<%String stSeqI = "mole_".concat(new Integer(j).toString()).concat("_0") ; %>

										<div class="row">
											<div class="rowLato"><label id="<%= "lato".concat(stSeqI) %>"><%= keyArray[0] %></label></div>
											<div class="rowLava"><label id="<%= "lava".concat(stSeqI) %>"><%= metadata.get(keyArray[0]) %></label></div>
											<div class="swHide"><input type="hidden"  class="widthL" id="<%= stSeqI %>" name="<portlet:namespace/><%= stSeqI %>" value="<%= metadata.get(keyArray[0]) %>"    /></div>
										</div>

										<%if (keyArray.length>1){for (int i = 1; i < keyArray.length; i++) { %>
												<% stSeqI = "mole_".concat(new Integer(j).toString()).concat("_").concat(new Integer(i).toString()); %>
												<div class="row">
													<div class="rowLato"><label id="<%= "lato".concat(stSeqI) %>"><%= keyArray[i] %></label></div>
													<div class="rowLava"><label id="<%= "lava".concat(stSeqI) %>"><%= metadata.get(keyArray[i]) %></label></div>
													<div class="swHide"><input type="text"  class="widthL" id="<%= stSeqI %>" name="<portlet:namespace/><%= stSeqI %>" value="<%= metadata.get(keyArray[i]) %>"    /></div>
												</div>
										<%} } %>

										<div class="swHide">
											<div class="rowLato">&nbsp;</div>
											<div class="rowLava">&nbsp;</div>
											<div class="rowField"><input type="button" class="widthL" value="Change" onclick="resourceMethod_JI('<%=projectprofileURL %>', 'changeMolecular','mole','<%= j %>','<%=metadata.size() %>')" /></div>
										</div>
									<%} %>
								</div>
						<%} } %>
					</div>
				</div>
	<% } }} %>



</body>