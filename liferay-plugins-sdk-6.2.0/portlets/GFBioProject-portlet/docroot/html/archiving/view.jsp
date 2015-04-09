<input type='hidden' name='csrfmiddlewaretoken' value='HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C' />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%!RenderResponse renderResponse;%>


<jsp:useBean id="keyWords" class="java.lang.String" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />
<meta charset="UTF-8">



<%@include 	file="/html/archiving/init.jsp"%>																		<!--  library imports -->
<script 	src="${pageContext.request.contextPath}/docroot/js/main.js" 				  type="text/javascript"></script> 	<!--  main.js  imports -->  
<link 		rel="stylesheet"	href="<%=request.getContextPath()%>/docroot/css/main.css" type="text/css"	>				<!--  main.css imports -->
 
 
 


 
<!---------------------------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------        Tabs        -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->




<body >

	<%if (PortalUtil.getUser(request)==null){ %>

		<div class="section" id='tabNoSubmission'>
			<div id="noSignSubmission">
				<p>
				<h2>Data Submission</h2>
				<p>
				Please select a data center in order to start an archiving workflow.
				<br>
				<input type="hidden" id="archivingURL" value="<%=archivingURL%>">
				<input type="hidden" id="submissionCheck" value="true">
				
				<form action="select.htm">
					<select  style="width:50%" name="<portlet:namespace />choWorkflow" id="choWorkflow"  size="1" onchange="radiohide(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
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
					<h3>ENA / PANGAEA (Molecular Sequence Data)</h3>
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
				    All your submitted data is accessible in the project profile to which the data has been assigned.<br>
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
		</div>
	
	<%}else{ %>

		<div class="section" id='tabSubmission'>

			<p>
			<h2>Data Submission</h2>
			<p>
			Please select a data center in order to start an archiving workflow.
			<br>
			<input type="hidden" id="archivingURL" value="<%=archivingURL%>">
			<input type="hidden" id="submissionCheck" value="true">
				
			<form action="select.htm">
				<select  style="width:50%" name="<portlet:namespace />choWorkflow" id="choWorkflow"  size="1" onchange="radiohide(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
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
			
				<h3>ENA / PANGAEA (Molecular Sequence Data)</h3>
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
			    All your submitted data is accessible in the<a href="#" onclick="showSection('#tabProjProfile')"> project profile to which the data has been assigned</a>.<br>
				<br>
				<br>
	
				<%
					Long userID  = PortalUtil.getUserId(request);
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
					

					
				Please select a project to which the data should be assigned. <br>
				If no project is available, please create a <a href="#" onclick="showSection('#tabProjProfile')">new project</a>.<br> 
				<br>
				<form action="select.htm">
					<select  style="width:50%" name="<portlet:namespace/>chooPro" id="chooPro" size="1" onchange="checkContent(this.form.chooPro.options[this.form.chooPro.selectedIndex].value)">
						<option selected value="none"		>None	 </option>
						<%if (projectList!=null){ for(int i = 0; i < projectList.size(); i++) {%>
								<option selected value="<%=projectList.get(i).getProjectID()  %>"		><%=projectList.get(i).getLabel() %>	 </option>
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
	  	</div>
	
	<%} %>	  	
</body>





















