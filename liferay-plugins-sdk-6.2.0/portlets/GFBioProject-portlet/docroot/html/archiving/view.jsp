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


	<%if (PortalUtil.getUser(request)==null){ %>

		<div class="section" id="tabNoSubmission">
			<div id="noSignSubmission">
				<p>
				<h2>Submission Workflows</h2>
				<p>
				Please select a data center in order to start a submission workflow.
				<br>
				<input id="archivingURL" type="hidden" value="<%= archivingURL %>">
				<input id="submissionCheck" type="hidden" value="true">

				<form action="select.htm">
					<select  style="width:50%" name="<portlet:namespace />choWorkflow" id="choWorkflow"  size="1" onchange="ENAradio(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
						<option selected value="none">None </option>
						<option value="-1010">BGBM </option>
						<option value="-1010">DSMZ </option>
						<option value="-1011" style="color: black; font-weight:bold">ENA (molecular sequence data) </option>
						<option value="-1010">MfN </option>
						<option value="-1010">PANGAEA </option>
						<option value="-1010">SGN </option>
						<option value="-1010">SMNS </option>
						<option value="-1010">SNSB </option>
						<option value="-1010">ZFMK </option>
					</select>
				</form>

				<br>

				<!--------------------------------------------------------------GCDJ-Widget ---------------------------------------------------->
				<div class="swHide" id="hide_-1011">
				</div>

				<div class="swHide" id="hide_-1010">
					<div class="portlet-msg-alert">
						This part will be build at later time.
					</div>
				</div>
			</div>
		</div>

	<%}else { %>

		<div class="section" id="tabSubmission">

			<p>
			<h2>Submission Workflows</h2>
			<p>
			Please select a data center in order to start a submission workflow.
			<br>
			<input id="archivingURL" type="hidden" value="<%= archivingURL %>">
			<input id="submissionCheck" type="hidden" value="true">

			<form action="select.htm">
				<select  style="width:75%" name="<portlet:namespace />choWorkflow" id="choWorkflow"  size="1" onchange="ENAradio(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
					<option selected value="none">None </option>
					<option value="-10">BGBM </option>
					<option value="-10">DSMZ </option>
					<option value="-11" style="color: black; font-weight:bold">ENA (molecular sequence data) </option>
					<option value="-10">MfN </option>
					<option value="-10">PANGAEA </option>
					<option value="-10">SGN </option>
					<option value="-10">SMNS </option>
					<option value="-10">SNSB </option>
					<option value="-10">ZFMK </option>
				</select>
			</form>
			<br>

			<!--------------------------------------------------------------GCDJ-Widget ---------------------------------------------------->
			<div class="swHide" id="hide_-11">
			</div>

			<!-- ------------------------------------------------------------- Rest ------------------------------------------------------->
			<div class="swHide" id="hide_-10">

				<div class="portlet-msg-alert">
					This function is still not available. Please select ENA (molecular sequence data).
				</div>
			</div>

			<!-- ------------------------------------------------------------- complete Submission ----------------------------------------------->
			<div class="swHide" id="hide_-20">
				<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
					Thank you for your submission! The data submission has been successful. You can view your data in the <a href="<portlet:renderURL><portlet:param name="jspPage" value="view.jsp#tab-3" /></portlet:renderURL>">project profile</a>.
				</div>
			</div>
	  	</div>

	<%} %>
</body>