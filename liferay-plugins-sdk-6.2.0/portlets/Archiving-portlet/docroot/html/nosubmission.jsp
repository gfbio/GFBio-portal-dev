
<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  main.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />


<!------------------------------------------------    Submit Part     -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->


    <%
    String Uname=request.getParameter("usnername");
    String Usecret=request.getParameter("password");
    out.println(Uname);
    out.println(Usecret);
    %>
    <%=Uname %>
    <%=Usecret %>


<div id="noSignSubmission">
	<p>
	<h3>Data Submission</h3>
	<p>
	Please select a data center in order to start an archiving workflow.
	<br>
	<input type="hidden" id="archivingURL" value="<%=archivingURL%>">
	<input type="hidden" id="submissionCheck" value="true">
	
	<form action="select.htm">
		<select  style="width:50%" name="choWorkflow" id="choWorkflow"  size="1" onchange="radiohide(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
			<option selected value="none"	>None	 </option>
			<option  		 value="-1010"	>BGBM 	 </option>
			<option  		 value="-1010"	>DSMZ  </option>
			<option 		 value="-1011"	>ENA (molecular sequence data)	 </option>
			<option  		 value="-1010"	>MfN </option>
			<option  		 value="-1010"	>PANGAEA </option>
			<option  		 value="-1010"	>SGN </option>
			<option  		 value="-1010"	>SMNS </option>
			<option  		 value="-1010"	>SNSB </option>
			<option  		 value="-1010"	>ZFMK </option>
		</select>
	</form>

	

	<br>
	
	<!--------------------------------------------------------------GCDJ-Widget ---------------------------------------------------->
	<div id="hide_-1011" class="swHide">
		<h4>ENA / PANGAEA (Molecular Sequence Data)</h4>
		<br>
		Welcome to the molecular data submission workflow!
		The workflow consists of five major parts:
		<br>
		Welcome to the molecular data submission workflow!
		The workflow consists of five major parts:
		<br/><br/>
		1.) At first, you enter describing information about the sequence (metadata) and upload the sequence files.
		<br/>
		2.) The metadata and the sequence data will be transfered to the ENA data center. If the submission is successful, an ENA accession number will be delivered. 
		<br/>
		3.) The metadata and the ENA accession number will be send to PANGAEA. A data curator will review the submitted data and a DOI will be generated.
		<br/>
		4.) The ENA will obtain a notification about the generated DOI.
		<br/>
		5.) You will receive a confirmation about the data submission with DOI and ENA accession number.
		<br/><br/>
		Both identifiers, DOI and ENA accession number ensure the connection between the submitted data.
	    All your submitted data is accessible in the <a href="<portlet:renderURL><portlet:param name="jspPage" value="view.jsp#tab-3" /></portlet:renderURL>">project profile to which the data has been assigned</a>.<br>
		<br>
		<br>
		

		<div class="portlet-msg-alert" >
			Please sign in to continue the submission process.
		</div>
		
		

	</div>
	
	<div id="hide_-1010" class="swHide">
		
		<div class="portlet-msg-alert" >
			This part will be build at later time.
		</div>
	</div>


</div>