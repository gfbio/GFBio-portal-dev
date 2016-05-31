<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="archivingURL" var="archivingURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> <!-- library imports -->
<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/docroot/js/main.js"       			type="text/javascript"></script>  	<!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/workflow.js"			    	type="text/javascript"></script>  	<!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/docroot/css/main.css" rel="stylesheet" 	type="text/css">	 				<!-- main.css imports -->

<script>
	$( document ).ready(function() {
		$("#choWorkflow option[value='none']").attr("selected","selected");
	}); 
</script>


<body >


	<div id="dataSubmission">
		<%if (PortalUtil.getUser(request)==null){ %>
	
			<div class="portlet-msg-alert">
				Only logged in users get access to the different submission workflows. Please <span style="color:#006400;">sign in</span> to continue the process. 
			</div>
	
		<%}else { %>
	
			<p>
			<h2>Submission Workflows</h2>
			<p>
				
			<%
				Long userID = PortalUtil.getUserId(request);
				List <Project> projectList = new ArrayList<Project>();
				projectList = null;
				try {projectList = ProjectLocalServiceUtil.getProjectList(userID);}
				catch (NoSuchModelException e) {e.printStackTrace();}
				catch (SystemException e) {e.printStackTrace();	}
			%>
	
			<div id="chooseROX" class="swHide">
			
				<!-- 			<br>
				Please select an existing project, <br>or choose nothing.
				<br> -->
			
				<form action="select.html" id="choProjForm">
					<select style="width:90%" id="workflowChoPro" name="<portlet:namespace/>choPro" size="1"  onchange="chooseProjProProject('choosePro',this.form.workflowChoPro.options[this.form.workflowChoPro.selectedIndex].value, 'chooseROX')" >
						<option value="none"> </option>
						<%if (projectList.size()>0){for (int i = 0; i < projectList.size(); i++) { %>
							<option value="<%= projectList.get(i).getProjectID() %>"> <%= projectList.get(i).getLabel() %> </option>
						<%} } %>
					</select>
				</form>
					
			
			
			
				Please select an existing dataset, <br>or choose nothing.
						
				<form action='select.html' id="choROForm">
					<select id='workflowChooseRO' name='<portlet:namespace/>workflowChooseRO' size='1' style='width:90%'>
						<option value='none'> </option>
					</select>
				</form>	
	
			</div> 
	

	
			Please select a exploratory focus in order to start a submission workflow.
			<br>
			<input id="archivingURL" type="hidden" value="<%= archivingURL %>">
			<input id="submissionCheck" type="hidden" value="true">
	
			<form action="select.htm">
				<select  id="choWorkflow" style="width:90%" name="<portlet:namespace />choWorkflow"   size="1" onclick="startSubmissionWorkflow(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value, choROForm.workflowChooseRO.options[choROForm.workflowChooseRO.selectedIndex].value, choProjForm.workflowChoPro.options[choProjForm.workflowChoPro.selectedIndex].value, <%=PortalUtil.getUser(request).getUserId()%>)">
					<option  value="none"> </option>
					<option  value="ena">Molecular Sequence Data</option>
<!-- 					<option  value="collections">Collections</option> -->
				</select>
			</form>
			<br>
	
		<%} %>
	</div>
</body>