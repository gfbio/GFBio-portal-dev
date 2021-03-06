<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="submissionmanagerURL" var="submissionmanagerURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> <!-- library imports -->
<%@ include file="/html/submissionmanager/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/js/main.js"       								type="text/javascript"></script>  <!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/submissionManager.js"     					type="text/javascript"></script>  <!--  main.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css"				rel="stylesheet" 	type="text/css"> <!-- main.css imports -->
<link href="${pageContext.request.contextPath}/css/submissionManager.css" 	rel="stylesheet" 	type="text/css"> <!-- main.css imports -->

<input type="hidden" class="widthL" id="path"  				value="<%=request.getContextPath()%>" />
<input type="hidden" class="widthL" id="submissionmanagerurl"  value="<%=submissionmanagerURL %>" />


<body >
	<div id="submissionManager">
	
		<h2>Submission Manager</h2>
		
		<%if (PortalUtil.getUser(request)==null){ %>
		
			<div class="portlet-msg-alert">
				Please sign in to use more options.
			</div>
		<%} %>
		
		<%JSONArray  ResearchObjects = new JSONArray();
	      ResearchObjects = null;
	      //try {
			long userId = PortalUtil.getUserId(request)  ;
	       	ResearchObjects=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(userId);
	       
	       	/*}
	            catch (NoSuchModelException e) { e.printStackTrace(); }
	       catch (SystemException e) {  e.printStackTrace(); } */
	      %>
	      <%if (ResearchObjects.size()>0){for (int i = 0; i < ResearchObjects.size(); i++) { 
	      	JSONObject responseJson = (JSONObject) ResearchObjects.get(i);
	      %>
	      <tr><td><%=responseJson.get("researchobjectname") %></td>
	      <td><%= ((JSONObject )ResearchObjects.get(i)).get("researchobjectversion")%></td> </tr>
		
		<%}}%>
		
		
		<div class="row">
			<div id="suma_left">
				<%if (PortalUtil.getUser(request)==null){ %>
					<div id="suma_left_top">
						<div>
							<div style="float:left; width:35%" onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_chooseProject.svg')"   onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">
								Please sign in to select one of your projects.<br>
								<br>
								<form action="select.html">
									<select style="width:100%" >
										<option selected value="none"> </option>
									</select>
								</form>
							</div>
							<div id="suma_Helpdesk"   		class="button_top_WIP" 	 onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_Helpdesk.svg')"   	onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Helpdesk</div>
							<div id="suma_curatorContact" 	class="button_top_grey"  onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_curatorContact.svg')" onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')" >Contact to Curator</div>
							<div id="suma_newProject" 		class="button_top_grey"  onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_newProject.svg')" 	onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')" >New Project</div>
						</div>
					</div>
				<%} else {%>
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
					<%=ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(PortalUtil.getUserId(request)) %>
					<div id="suma_left_top">
						<div>
							<div style="float:left; width:35%" onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_chooseProject.svg')"   onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">
								Please sign in to select one of your projects.<br>
								<br>
								<form action="select.html">
									<select id="suma_choPro" name="<portlet:namespace/>suma_choPro" onchange="chooseSuMaProject('choosePro',this.form.suma_choPro.options[this.form.suma_choPro.selectedIndex].value)" size="1" style="width:100%" >
										<option selected value="none"> </option>
										<%if (projectList.size()>0){for (int i = 0; i < projectList.size(); i++) { %>
											<option value="<%= projectList.get(i).getProjectID() %>"> <%= projectList.get(i).getLabel() %> </option>
										<%} } %>
									</select>
								</form>
							</div>
							<div id="suma_Helpdesk"   		class="button_top_WIP"  	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_Helpdesk.svg')"   		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Helpdesk</div>
							<div id="suma_curatorContact" 	class="button_top_WIP"  	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_curatorContact.svg')" 	onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')" >Contact to Curator</div>
							<div id="suma_newProject" 		class="button_top_green"  	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_newProject.svg')" 		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')" onclick="startNewProject()">New Project</div>
						</div>
					</div>
				<%} %>
				<div id="suma_left_botton" >
					<img id="suma_left_botton_img" src="${pageContext.request.contextPath}/html/submissionmanager/img_suma_default.svg" style="width:100%; position:relative;" />
				</div>
			</div>
			
			<div id="suma_rigth">
				<div id="suma_rigth_top" style="margin-top:40px">
					<div id="suma_projectProfile" 			class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/', 'img_suma_projectProfile.svg')" 	onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Project Profile</div>
					<div id="suma_changeProject" 			class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/', 'img_suma_changeProject.svg')"		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Change Project Information</div>
					<div id="suma_newRO"					class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_newRO.svg')" 				onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">New Research Object</div>
					<div id="suma_changeRO" 				class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/', 'img_suma_changeRO.svg')"			onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Change Research Object <br> Information</div>
					<div id="suma_uploadFile"				class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_uploadFile.svg')" 			onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">upload Example File</div>
				</div>
				<%if (PortalUtil.getUser(request)==null){ %>
					<div id="suma_rigth_botton">
							<div id="suma_managmentPlan"		class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_managmentPlan.svg')" 		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Managment Plan</div>
							<div id="suma_DCRT"					class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_DCRT.svg')" 				onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">DataCenter Recommendation Tool </div>
							<div id="suma_dataSubmission"		class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_dataSubmission.svg')" 		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Data Submission </div>
							<div id="suma_submissionRegistry"	class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_submissionRegistry.svg')" 	onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Submission Registry</div>
					</div>
				<%} else {%>
					<div id="suma_rigth_botton">
							<div id="suma_managmentPlan"		class="button_right_WIP" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_managmentPlan.svg')" 		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Managment Plan  <br/>(without project context)</div>
							<div id="suma_DCRT"					class="button_right_WIP" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_DCRT.svg')" 				onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">DataCenter Recommendation Tool  <br/>(without project context)</div>
							<div id="suma_dataSubmission"		class="button_right_WIP" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_dataSubmission.svg')" 		onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Data Submission <br/>(without project context))</div>
							<div id="suma_submissionRegistry"	class="button_right_grey" 	onmouseover="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_submissionRegistry.svg')" 	onmouseout="helpdeskInfo('${pageContext.request.contextPath}/html/submissionmanager/','img_suma_default.svg')">Submission Registry</div>
					</div>
				<%} %>
			</div>
		</div>
	</div>
</body>	
	
	
