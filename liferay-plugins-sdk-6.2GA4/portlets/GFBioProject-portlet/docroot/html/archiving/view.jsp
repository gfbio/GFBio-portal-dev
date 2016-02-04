<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="archivingURL" var="archivingURL" />
<meta charset="UTF-8">


<%@ include file="/html/archiving/init.jsp" %> <!-- library imports -->
<script  src="${pageContext.request.contextPath}/docroot/js/main.js"       type="text/javascript"></script>  <!--  main.js  imports -->
<link href="<%= request.getContextPath() %>/docroot/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->




<body >
	<div id="dataSubmission">
		<%if (PortalUtil.getUser(request)==null){ %>
	
			<div class="portlet-msg-alert">
				Please sign in to use the project profile.
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
					<select  style="width:75%" name="<portlet:namespace />choWorkflow" id="choWorkflow"  size="1" onclick="ENAradio(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
						<option selected value="none"> </option>
						<option value="-21">Molecular Sequence Data</option>
					</select>
				</form>
				<br>
	
				<!--------------------------------------------------------------GCDJ-Widget ---------------------------------------------------->
				<div class="swHide" id="hide_-11">
				</div>
	
				<!-- ------------------------------------------------------------- Rest ------------------------------------------------------->
				<div class="swHide" id="hide_-10">
	
					<div class="portlet-msg-alert">
						This part will be build at later time. Please select ENA (molecular sequence data).
					</div>
				</div>
	
				<!-- ------------------------------------------------------------- complete Submission ----------------------------------------------->
				<div class="swHide" id="hide_-20">
					<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
						Thank you for your submission! The data submission has been successful. You can view your data in the project profile.
					</div>
				</div>
	
		<%} %>
	</div>
</body>