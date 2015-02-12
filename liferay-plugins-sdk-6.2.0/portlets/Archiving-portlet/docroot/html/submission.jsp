
<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  main.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />


<!------------------------------------------------    Submit Part     -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->


<%
	String path =  "C:\\Users\\froemm\\GFBio\\git\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\docroot\\xml\\userdata.xml";
	//String path = "C:\\liferay-portal-6.2.0-ce-ga1\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
	//String path = "D:\\liferay\\liferay-portal-tomcat-6.2-gfbio\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
	

%>

		

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
			<option  		 value="-10"	>BGBM 	 </option>
			<option  		 value="-10"	>DSMZ  </option>
			<option 		 value="-11"	>ENA (molecular sequence data)	 </option>
			<option  		 value="-10"	>MfN </option>
			<option  		 value="-10"	>PANGAEA </option>
			<option  		 value="-10"	>SGN </option>
			<option  		 value="-10"	>SMNS </option>
			<option  		 value="-10"	>SNSB </option>
			<option  		 value="-10"	>ZFMK </option>
		</select>
	</form>

	

	<br>
	
	<!--------------------------------------------------------------GCDJ-Widget ---------------------------------------------------->
	<div id="hide_-11" class="swHide">
		<h4>ENA / PANGAEA (Molecular Sequence Data)</h4>
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
		

		<%=PortalUtil.getUserId(request)
		%>
		<%
			org.jdom2.Document doc = ContactToDMS.getData(path);
			String userId 		  = new Long(PortalUtil.getUserId(request)).toString();
			
	
			Boolean userCheck =  ContactToDMS.checkUserId(Long.toString(PortalUtil.getUser(request).getUserId()), doc);
			String notPro = "muster";
			
			if (userCheck.equals(true))
				userId = Long.toString(PortalUtil.getUser(request).getUserId());
			else
				userId = notPro;
		
			List<Object> proList = ContactToDMS.getProList(doc, userId);
		%>
		
		Please select a project to which the data should be assigned. <br>
		If no project is available, please create a <a href="<%=jspProjectProfile%>">new project </a>.<br> 
		<br>
		<form action="select.htm">
			<select  style="width:50%" name="<portlet:namespace/>chooPro" id="chooPro" size="1" onchange="checkContent(this.form.chooPro.options[this.form.chooPro.selectedIndex].value)">
				<option selected value="none"		>None	 </option>
				<%if (userId!=notPro){ for(int i = 0; i < proList.size(); i++) {
						Content content = (Content) proList.get(i);
						List<Element> projdata = ContactToDMS.getProject(doc, content.getValue()).getChildren();%>
						<option selected value="<%=content.getValue()  %>"		><%=projdata.get(1).getText() %>	 </option>
				<%}	}%>
			</select>
		</form>

	</div>
	
	<!-- -------------------------------------------------------------    Rest ------------------------------------------------------->
	<div id="hide_-10" class="swHide">
		
		<div class="portlet-msg-alert" >
			This function is still not available. Please select ENA (molecular sequence data).
		</div>
	</div>
	<!-- ------------------------------------------------------------- complete Submission ----------------------------------------------->
	<div id="hide_-20" class="swHide">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Thank you for your submission! The data submission has been successful. You can view your data in the <a href="<portlet:renderURL><portlet:param name="jspPage" value="view.jsp#tab-3" /></portlet:renderURL>">project profile</a>. 
		</div>
	</div>
	
	

	
	

