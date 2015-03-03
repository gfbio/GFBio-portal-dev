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

		<div class='navigator'>
			<ul class='tabs' id="verticalNav">
				<li><a id="linkNoSubmission"href='#tabNoSubmission'	>Data Submission</a></li>
		  	</ul>
	  	</div>
	  	
	  	<div id="sections">

			<!-- No Submission -->	  	
	  	
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
		</div>	  	
	  	
	<%}else{ %>

		<div class='navigator'>
			<ul class='tabs' id="verticalNav">
				<li><a id="linkSubmission" 	href='#tabSubmission'	>Data Submission </a></li>
			    <li><a id="linkProjProfile" href='#tabProjProfile'	>Project Profile</a></li>
		  	</ul>
	  	</div>
	
	 	<div id="sections">
	 	
	 		<!-- Submission -->
	 	
  			<div class="section" id='tabSubmission'>

				<p>
				<h2>Data Submission</h2>
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
		</div>
	  		
	  		
		<!-- Project Profile -->
	
	
		<div class="section" id='tabProjProfile'>
			
			<%	
				userID  = PortalUtil.getUserId(request);
				List <String> attributList = new ArrayList<String>();
				attributList.add("projectID");
				attributList.add("name");
				attributList.add("label");
				attributList.add("description");
				attributList.add("startDate");
				attributList.add("endDate");
				attributList.add("status");
				projectList = null;
				try {
					 projectList = ProjectLocalServiceUtil.getProjectList(userID);
				} catch (NoSuchModelException e) {
					e.printStackTrace();
				} catch (SystemException e) {
						e.printStackTrace();
				}
			%>
	
			<p/>
	
			<h2>Project Profile</h2>
			<br>

			<br>
			All data that we store for the user, have an user or a project reference. Here you can see all of the stored data to a selected project.<br>
			<br>
			
			<div class="portlet-msg-alert" >
					Please use the form yyyy-mm-dd for all Dates in the project profile.
			</div>
			
			<!------------------------------------------------    First New Project    -------------------------------------------------------------------->
			
			<%if (projectList.size()==0){ %>
		
				<%
					String stProjI;
					stProjI = "newprous_".concat(new Integer(0).toString()); %>
				<div class="swHide">
					<div class="rowLato" > <label id="<%= "lato".concat(stProjI)%>" ><%=attributList.get(0) %></label></div>
					<div class="hidden" > <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
					<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="0" /></div>
				</div>
				<%for(int i = 1; i < attributList.size(); i++) {%>
					<% stProjI = "newprous_".concat(new Integer(i).toString()); %>
					<div class="row" >
						<div class="rowLato" > <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(i) %></label></div>
						<div class="hidden" > <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
						<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></div>
					</div>
				<% } %>
				<div class="row" >
					<div class="rowLato" >&nbsp;</div>
					<div class="rowLava" >&nbsp;</div>
					<div class="rowFieldB"> <input  type="button" class="widthL" value="new Project"  onclick="newProject('<%=archivingURL %>', 'newProject','newprous', '<%=attributList.size()%>', '102', <%=userID %>)" /></div>
				</div>
			
			
				<div id="hide_102" class="swHide">
					<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
						Create new Project is complete.
					</div>
				</div>
				

				
				
					
			<%}else{%>
			
				<!------------------------------------------------    Choose Project    -------------------------------------------------------------------->

				<%
					projectList = null;
					try {
						 projectList = ProjectLocalServiceUtil.getProjectList(userID);
					} catch (NoSuchModelException e) {
						e.printStackTrace();
					} catch (SystemException e) {
							e.printStackTrace();
					}
				%>

				Please select one of your projects or start a new one.<br>
				<br>
				
				<form action="select.html">
					<select  style="width:50%" name="<portlet:namespace/>choPro" id="choPro" size="1" onchange="chooseProject('<%=archivingURL %>','choosePro',this.form.choPro.options[this.form.choPro.selectedIndex].value, '103')">
						<option selected value="none">None	 </option>
						<%if (projectList.size()>0){for(int i = 0; i < projectList.size(); i++) {%>
								<option value="<%=projectList.get(i).getProjectID()  %>">	<%=projectList.get(i).getLabel()%> </option> 
						<%}	}%>
					</select>
				</form>
				
				<div id="hide_103" class="swHide">
					<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
						Switch to selected project.
					</div>
				</div>
					
				
				<div id="hide_but_newpro" onclick="pseudoaccordion('newpro')" style="cursor:pointer;">
					<h4 > <span id="h_newpro">+</span> new project </h4>
				</div>
		
				
				<%
					PortletPreferences prefs = renderRequest.getPreferences();
					String projectID =(String)prefs.getValue("choPro", "none");
				%>
				
				
				<!-- -----------------------------------------------       New Project           -------------------------------------------------------- -->
			
				<div id="hide_newpro" class="swHide">
				
					<%
						String stProjI;
						stProjI = "newpro_".concat(new Integer(0).toString()); %>
				
					<div class="swHide"><div class="row" >
						<div class="rowLato" > <label id="<%= "lato".concat(stProjI)%>" ><%=attributList.get(0) %></label></div>
						<div class="hidden" > <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
						<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="0" /></div>
					</div></div>
					<%for(int i = 1; i < attributList.size(); i++) {%>
						<% stProjI = "newpro_".concat(new Integer(i).toString()); %>
						<div class="row" >
							<div class="rowLato" > <label id="<%= "lato".concat(stProjI) %>"><%=attributList.get(i) %></label></div>
							<div class="hidden" > <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
							<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></div>
						</div>
					<% } %>
					<div class="row" >
						<div class="rowLato" >&nbsp;</div>
						<div class="rowLava" >&nbsp;</div>
						<div class="rowFieldB"> <input  type="button" class="widthL" value="new Project"  onclick="newProject('<%=archivingURL %>', 'newProject','newpro', '<%=attributList.size()%>', '100001', <%=userID %>)" /></div>
					</div>				
					<div id="hide_100001" class="swHide">
						<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
							Create new Project is complete.
						</div>
					</div>
				</div>
				

				<%
					String checkID = "None";
					Boolean checker = false; 
					for (int i = 0; i < projectList.size();i++)
						if (projectList.get(i).getProjectID() == Long.valueOf(projectID).longValue())
							checker = true;
					if (checker == false)
						checkID = "None";
					else
						checkID = projectID.toString();
					if (checkID.equals("None")){}
					else{
				%>
		
					<!-- --------------------------------------------  Change Project data ---------------------------------------------------------------->
					

					<div id="updateProject">
						<h3> general project data</h3>


						<%  Project project =  ProjectLocalServiceUtil.getProject(Long.valueOf(projectID).longValue()); 
							Map <String, Object> projectMap = project.getModelAttributes();
							stProjI = "project_".concat(new Integer(0).toString());
						%>					
						<div class="row">
							<div class="swHide">
								<div class="rowLato" ><label id="<%= "lato".concat(stProjI) %>"><%= attributList.get(0) %></label></div>
								<div class="hidden" ><label id="<%= "lava".concat(stProjI) %>"><%= projectMap.get(attributList.get(0))  %></label></div>
								<div class="rowField"><input type="hidden" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= project.getProjectID() %>"    /></div>
							</div>
						</div>
						<% for(int i = 1; i < attributList.size(); i++) {%>
							<div class="row" >
								<% stProjI = "project_".concat(new Integer(i).toString());
								Map <String, Object> foo = project.getModelAttributes(); %>
								<div class="rowLato" ><label id="<%= "lato".concat(stProjI) %>"><%= attributList.get(i) %></label></div>
								<div class="hidden" ><label id="<%= "lava".concat(stProjI) %>"><%= projectMap.get(attributList.get(i)) %></label></div>
								<div class="rowField"><input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= projectMap.get(attributList.get(i)) %>"    /></div>
							</div>
						<% 	} %>
						<div class="row" >
							<div class="rowLato" >&nbsp;</div>
							<div class="rowLava" >&nbsp;</div>
							<div class="rowFieldB"><input type="button" class="widthL" value="Change"  onclick=" updateProject('<%=archivingURL %>', 'updateProject', 'project', '<%=attributList.size()%>', '104', '<%=userID %>')" /></div>
						</div>
						<p/>
						
						<div id="hide_104" class="swHide">
							<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
								Data set  is updated.
							</div>
						</div>
						
						<!-- ------------------------------------------Sequence data ----------------------------------------------------------- -->
						
						<h3>research object</h3>
						
						<%List <ResearchObject> researchObjectList = ProjectLocalServiceUtil.getResearchObjectList(Long.valueOf(projectID).longValue(), userID);%>
						
						<div id="hide_but_roseq" onclick="pseudoaccordion('roseq')" style="cursor:pointer;">
							<h4 > <span id="h_roseq">+</span> sequence data (<%=researchObjectList.size() %>)</h4>
						</div>

						<div id= "hide_roseq" class="swHide">

							<p>
							
							<%if(researchObjectList.size() != 0){for(int j = 0; j < researchObjectList.size(); j++) {%>
									<%
										int h = j+1;
										ResearchObject researchObject = researchObjectList.get(j);
										long researchObjectID = researchObject.getResearchObjectID();
										JSONParser parser = new JSONParser();
										JSONObject metadata = new JSONObject();
										try {
											metadata = (JSONObject) parser.parse(researchObject.getMetadata());
										} catch (ParseException e1) {
											e1.printStackTrace();
										}
										Set <String> keySet = metadata.keySet();
										String[] keyArray = keySet.toArray(new String[0]);
									%>
									<p>
									
									
									<div id=<%="accordion_seq_header_"+h%> class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" role="tab" aria-controls=<%="accordion_seq_panel_"+h%> aria-selected="false"  tabindex="0"    >
										<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-s"></span>
										<%= "Descriptive data of sequence ".concat(researchObject.getLabel()) %>
									</div>
									
									<div id=<%="accordion_seq_panel_"+h%> class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby=<%="accordion_seq_header_"+h%>   role="tabpanel" aria-expanded="false" aria-hidden="true"   >
										<%	if (metadata.size() !=0){ %>
											<%String stSeqI = "mole_".concat(new Integer(j).toString()).concat("_0")  ; %>
											<div class="row">
												<div class="rowLato" ><label id="<%= "lato".concat(stSeqI) %>"><%= keyArray[0] %></label></div>
												<div class="rowLava" ><label id="<%= "lava".concat(stSeqI) %>"><%= metadata.get(keyArray[0]) %></label></div>
												<div class="swHide"><input type="hidden"	 class="widthL" id="<%= stSeqI %>"	name="<portlet:namespace/><%= stSeqI %>"	value="<%= metadata.get(keyArray[0]) %>"    /></div>
											</div>
											<%if (keyArray.length>1){for(int i = 1; i < keyArray.length; i++) {%>
													<% stSeqI = "mole_".concat(new Integer(j).toString()).concat("_").concat(new Integer(i).toString()); %>
													<div class="row">
														<div class="rowLato" ><label id="<%= "lato".concat(stSeqI) %>"><%= keyArray[i]  %></label></div>
														<div class="rowLava" ><label id="<%= "lava".concat(stSeqI) %>"><%= metadata.get(keyArray[i]) %></label></div>
														<div class="swHide"><input type="text"  class="widthL"	id="<%= stSeqI %>" name="<portlet:namespace/><%= stSeqI %>"	value="<%= metadata.get(keyArray[i]) %>"    /></div>
													</div>
												<%}
											}%>
											<div class="swHide">
												<div class="rowLato" >&nbsp;</div>
												<div class="rowLava" >&nbsp;</div>
												<div class="rowField"><input type="button" class="widthL"	value="Change" onclick="resourceMethod_JI('<%=archivingURL %>', 'changeMolecular','mole','<%= j %>','<%=metadata.size() %>')" /></div>
											</div>
										<%} %>
									</div>
							<%}	} %>
						</div>	
						

						
					</div>	
				<%} %>
			<%} %>
			

			

			
		</div>
	<%} %>	  	
</body>





















