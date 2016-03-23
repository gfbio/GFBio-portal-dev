<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="archivingURL" var="archivingURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/docroot/js/main.js"       				type="text/javascript"></script>  <!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/docroot/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->

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
				Please select a data center in order to start a submission workflow.
				<br>
				<input id="archivingURL" type="hidden" value="<%= archivingURL %>">
				<input id="submissionCheck" type="hidden" value="true">
	
				
	
				<form action="select.htm">
					<select  style="width:75%" name="<portlet:namespace />choWorkflow" id="choWorkflow"  size="1" onclick="ENAradio(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value, <%=PortalUtil.getUser(request).getUserId()%>)">
						<option  value="none"> </option>
						<option  value="-21">Molecular Sequence Data</option>
					</select>
				</form>
				<br>
	
		<%} %>
	</div>
</body>