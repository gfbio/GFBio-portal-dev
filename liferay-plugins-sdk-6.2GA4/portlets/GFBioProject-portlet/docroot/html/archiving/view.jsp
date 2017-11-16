<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="archivingURL" var="archivingURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> <!-- library imports -->
<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->

<script  src="${pageContext.request.contextPath}/js/main.js"       					type="text/javascript"></script>  	<!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/workflow.js"			    	type="text/javascript"></script>  	<!--  main.js  imports -->

<%-- <link href="<%= request.getContextPath() %>/docroot/css/main.css" rel="stylesheet" 	type="text/css">	 				<!-- main.css imports --> --%>
<link href="<%= request.getContextPath() %>/docroot/css/form.css" rel="stylesheet" 	type="text/css">	 				<!-- main.css imports -->

<input id="archivingURL" type="hidden" value="<%= archivingURL %>">
<input id="submissionCheck" type="hidden" value="true">

<body >
	<div id="msgid"></div>

	<div id="dataSubmission">
		<%if (PortalUtil.getUser(request)==null){ %>

	
			<div class="portlet-msg-alert">
				Only logged in users get access to the different submission workflows. Please <a href="<%=PortalUtil.getPortalURL(request) %>/sign-in?saveLastPath=0"><span style="color:#006400; font-weight:bold">sign in</span></a> to continue the process. 
			</div>
	
		<%}else { %>
		
<%-- 			<%	
				String s = "test01";
				PortletSession testSession = resourceRequest.getPortletSession();
				testSession.setAttribute("testSessionValue", s ,PortletSession.APPLICATION_SCOPE);
			%>
			<%="--------------" %>
			<%=s %>
			<%="--------------" %> --%>


				
			<%
				Long userID = PortalUtil.getUserId(request);
				
				List <Project> projectList = new ArrayList<Project>();
				projectList = null;
				try {projectList = ProjectLocalServiceUtil.getProjectList(userID);}
				catch (NoSuchModelException e) {e.printStackTrace();}
				catch (SystemException e) {e.printStackTrace();	} 
				 
				JSONArray roList = new JSONArray();
				roList = null;
				roList = ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(userID);
				
			%>
			
<!-- 			<br>
			Please select an existing project, or choose nothing.
			<br>  -->
			
<%-- 			<form action="select.html" id="choProjForm">
				<select style="width:90%" id="workflowChoPro" name="<portlet:namespace/>choPro" size="1"  onchange="chooseWorkflowProject('choosePro',this.form.workflowChoPro.options[this.form.workflowChoPro.selectedIndex].value, 'chooseROX', <%=PortalUtil.getUser(request).getUserId()%>)" >
					<option selected="selected" value="none">All project independent datasets of user</option>
 					<%if (projectList.size()>0){for (int i = 0; i < projectList.size(); i++) { %>
						<option id="<%= "workflowChoPro"+projectList.get(i).getProjectID() %>" value="<%= projectList.get(i).getProjectID() %>"> <%= projectList.get(i).getLabel() %> </option>
					<%} } %>  
				</select>
			</form>  --%>
				
			<div id ="workflowform" class="swMain">	
				<h3>0. Stored information</h3><hr>
					
				<p 	class='field-description'				id='gwf_ro_storedinformation_d'>If you have stored information to your datasets, you can choose the dataset to fill the form fields.</p>
							
				<form action='select.html' id="choROForm">
					<select id='workflowChooseRO' style='width:100%' name='<portlet:namespace/>workflowChooseRO' size='1'  onchange="chooseWorkflowResearchObject(<%=PortalUtil.getUser(request).getUserId()%>, this.form.workflowChooseRO.options[this.form.workflowChooseRO.selectedIndex].value)" >
						<option value='none' disabled selected> </option> 
						<% if (roList != null){ %>
		  					<%if (roList.size()>0){for (int i = 0; i < roList.size(); i++) { 
		  						JSONObject roJson =  new JSONObject();
		  						roJson = (JSONObject) roList.get(i);
		  						String text = (String) roJson.get("researchobjectname") + " with version "+roJson.get("researchobjectversion");
		  						if ((String) roJson.get("projectname")!=null)
		  							text = text +" from project "+(String) roJson.get("projectname");
		  						
		  						Long roId = (Long) roJson.get("researchobjectid"); %>
	 	  					    
 								<option value="<%= roId %>"> <%= text %> </option> 
							<%} }} %>  
					</select>
				</form>	
			</div>
			
		


	
<%-- 		Please select a exploratory focus in order to start a submission workflow.
			<br>
			<input id="archivingURL" type="hidden" value="<%= archivingURL %>">
			<input id="submissionCheck" type="hidden" value="true">
	
			<form action="select.htm">
				<select  id="choWorkflow" style="width:90%" name="<portlet:namespace />choWorkflow"   size="1" onclick="startSubmissionWorkflow(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value, choROForm.workflowChooseRO.options[choROForm.workflowChooseRO.selectedIndex].value, choProjForm.workflowChoPro.options[choProjForm.workflowChoPro.selectedIndex].value, <%=PortalUtil.getUser(request).getUserId()%>)">
					<option  value="none"> </option>
					<option  value="ena">Molecular Sequence Data</option>
 					<option  value="collections">Collections</option>
				</select>
			</form>
			<br> --%>
	
		<%} %>
	</div>
</body>