<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="projectprofileURL" var="projectprofileURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<%@ include file="/html/projectprofile/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/js/main.js"       			type="text/javascript"></script>  <!--  main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/projectProfile.js"      type="text/javascript"></script>  <!--  main.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->

<input type="hidden" class="widthL" id="path"  				value="<%=request.getContextPath()%>" />
<input type="hidden" class="widthL" id="projectprofileurl"  value="<%=projectprofileURL %>" />


<body >

	<h2>Project Profile</h2>
	<br>
	All data that we store for the user, have an user or a project reference. Here you can see all of the stored data to a selected project.<br>
	<br>

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

		<%if (projectList.size()==0){ %>

			<div class="portlet-msg-alert">
				Please create a project.
			</div>
			UserId: <%=userID %>

		<%}else { %>
		
			<!------------------------------------------------ Choose Project -------------------------------------------------------------------->

			Please select one of your projects or start a new one.<br>
			
			<br>

			<form action="select.html">
				<select id="choPro" name="<portlet:namespace/>choPro" onchange="chooseProject('choosePro',this.form.choPro.options[this.form.choPro.selectedIndex].value, 'projectProfileProject')" size="1" style="width:50%">
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


			<% PortletPreferences prefs = renderRequest.getPreferences();
				String projectID =(String)prefs.getValue("choPro", "none"); 
			%>
				
			<div id="projectProfileProject">
			
			</div>

		<% } %>
	<% } %>



</body>