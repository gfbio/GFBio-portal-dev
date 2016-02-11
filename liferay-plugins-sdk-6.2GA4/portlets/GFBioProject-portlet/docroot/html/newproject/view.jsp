<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="newprojecturl" var="newprojectURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<%@ include file="/html/newproject/init.jsp" %> <!-- library imports -->
<script src="${pageContext.request.contextPath}/js/main.js"       			type="text/javascript"></script>  	<!-- main.js  imports -->
<script src="${pageContext.request.contextPath}/js/newProject.js"       	type="text/javascript"></script>  	<!-- newProject.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" 	type="text/css"> 					<!-- main.css imports -->


<input type="hidden" class="widthL" id="path"  			value="<%=request.getContextPath()%>" />
<input type="hidden" class="widthL" id="newprojecturl"  value="<%=newprojectURL%>" />


<body >
	<div id="newProject">
		<h2> New Project</h2>
		<br>
	
		<%if (PortalUtil.getUser(request)==null){ %>
		
			<div class="portlet-msg-alert">
				Please sign in to use the project profile.
			</div>
	
		<%}else { %>
		
		
			<div class="portlet-msg-alert">
				Please use the form yyyy-mm-dd HH:mmZ (for example: 1963-11-23 20:15-0700) for all Dates in the project profile.
			</div>
	
			<!------------------------------------------------ First New Project -------------------------------------------------------------------->
		
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
				attributList.add("name");
				attributList.add("label");
				attributList.add("description");
				attributList.add("startdate");
				attributList.add("enddate");
				attributList.add("status");
				projectList = null;
				try {
					 projectList = ProjectLocalServiceUtil.getProjectList(userID);
				} catch (NoSuchModelException e)	{e.printStackTrace();
				} catch (SystemException e) 		{e.printStackTrace();}
			%>
	
			<h3>basic data</h3>
	
			<% 
				String stProjI;
				stProjI = "newpro_".concat(new Integer(0).toString()); 
			%>
	
			<% for (int i = 0; i < attributList.size(); i++) { %>
				<% stProjI = "newpro_".concat(new Integer(i).toString()); %>
				<div class="row">
					<div class="rowLato"> <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(i) %></label></div>
					<div class="hidden"> <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
					<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></div>
				</div>
			<% } %>
			
			
			<h3>extended data</h3>
			
			<div>
				[ToDo]
			</div>
			
			<div class="row">
				<div class="rowLato">&nbsp;</div>
				<div class="rowLava">&nbsp;</div>
				<div class="rowFieldB"> <input  type="button" class="widthL" value="new Project"  onclick="newProject('newProject','newpro', '<%= attributList.size() %>',  <%= userID %>)" /></div>
			</div>
	
	
				
		
		
		<%} %>
		
	</div>	
</body>