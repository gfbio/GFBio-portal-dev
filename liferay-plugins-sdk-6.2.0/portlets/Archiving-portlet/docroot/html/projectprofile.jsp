<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  main.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />


<!-- -------------------------------------------------- preparation the choose project steps ----------------------------------------------->

 <body> 
 <body onload="buildPage('<%=archivingURL%>',  '<portlet:namespace/>', '<%=new Long(PortalUtil.getUser(request).getUserId()).toString() %>' )">
 
<portlet:actionURL name="changeUser" var="addDetailsURL" /> 


 <%
 					
	String path =  "C:\\Users\\froemm\\GFBio\\git\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\docroot\\xml\\userdata.xml";
	//String path = "C:\\liferay-portal-6.2.0-ce-ga1\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
	//String path = "D:\\liferay\\liferay-portal-tomcat-6.2-gfbio\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
%>
<%	
	org.jdom2.Document doc = ContactToDMS.getData(path);
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String userId 		  = new Long(PortalUtil.getUser(request).getUserId()).toString();
	Boolean userCheck =  ContactToDMS.checkUserId(Long.toString(PortalUtil.getUser(request).getUserId()), doc);


	String notPro = "muster";
	if (userCheck.equals(true))
		userId = Long.toString(PortalUtil.getUser(request).getUserId());
	else
		userId = notPro;
	List<Object> proList = ContactToDMS.getProList(doc, userId);
%>

<p/>


<h3>Project Profile</h3>
<br>






<br>
All data that we store for the user, have an user or a project reference. Here you can see all of the stored data to a selected project.
<br>
	

<!------------------------------------------------    New Project & User -------------------------------------------------------------------->
Please start a new Project.
<br>
<%if (userId.equals(notPro)){ %>
		
	<%
	userId = Long.toString(PortalUtil.getUser(request).getUserId()); 
	String stProjI;
	List<Element> projmuster = ContactToDMS.getProject(doc, "muster").getChildren();
	%>

	<div class="row">
		<%stProjI = "newprous_".concat(new Integer(0).toString())  ;%>
		<div class="rowLato" > <input class="widthL" type="hidden"  id="<%= stProjI %>" name="<portlet:namespace/>newproj"   value="<%=userId %>"   /> </div>
	</div>
	<%for(int i = 1; i < projmuster.size()-1; i++) {%>
		<% stProjI = "newprous_".concat(new Integer(i).toString()); %>
		<div class="rowLato" > <label id="<%= "lato".concat(stProjI) %>"><%=projmuster.get(i).getName() %></label></div>
		<div class="rowLava" > <label id="<%= "lava".concat(stProjI) %>"></label>&nbsp;</div>
		<div class="rowField"> <input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></div>
	<% } %>
	<div class="rowLato" >&nbsp;</div>
	<div class="rowLava" >&nbsp;</div>
	<div class="rowField"> <input  type="button" class="widthL" value="new Project"  onclick="newProUser('<%=archivingURL %>', 'newProUser','newprous', '<%=projmuster.size()-1%>')" /></div>


	<div id="hide_102" class="swHide">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Create new Project is complete.
		</div>
	</div>
		
<%}else{
	userId = Long.toString(PortalUtil.getUser(request).getUserId()); %>


	<!------------------------------------------------    Choose Project    -------------------------------------------------------------------->
	<br>
	Please select one of your projects or start a new one.
	<br>
	
	<form action="select.htm">
		<select  style="width:50%" name="<portlet:namespace/>choPro" id="choPro" size="1" onchange="chooseProject('<%=archivingURL %>','choosePro',this.form.choPro.options[this.form.choPro.selectedIndex].value, '103')">
			<option selected value="none">None	 </option>
			<%if (userId!=notPro){for(int i = 0; i < proList.size(); i++) {
				Content content = (Content) proList.get(i);
				List<Element> projdata = ContactToDMS.getProject(doc, content.getValue()).getChildren();%>
				<option 	value="<%=content.getValue()  %>">	<%=projdata.get(1).getText()%>    </option> 
			<%}	}%>
		</select>
	</form>
	
	<div id="hide_103" class="swHide">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Switch to selected project.
		</div>
	</div>
		
	<input  class="widthL" type="button" id="hide_but_-2" name="hide_but_-2" value="show the form to build a new Project"    onclick="showhide(-2)">

	<br>
	<br>

	
	<%String proId =(String)prefs.getValue("choPro", "none");	%>
				
	<!-- -----------------------------------------------       New Project           -------------------------------------------------------- -->
			
			
			
			
	<%
		String stProjI;
		List<Element> projmuster = ContactToDMS.getProject(doc, "muster").getChildren();
	%>
	


	
			
	<div id="hide_-2" class="swHide">
		<br>
		<h4> New Project</h4><br>
		<div id="newProject"></div>
	</div>	
	
	<div id="hide_100001" class="swHide">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			<!-- Create new Project is complete. -->
		</div>
	</div>
		
	<% 
	String none = "none";
	if(proId.equals(none)){%>
		
	<%}else{%>
	
		<%
		Element proj = ContactToDMS.getProject(doc, proId);
		List<Element> projdata = proj.getChildren();
		Object[] a = ContactToDMS.getProList(doc, new Long(PortalUtil.getUser(request).getUserId()).toString()).toArray();
		Boolean checker = false;
		for (int i =0; i < a.length;i++)
			if (a[i].toString().contains(proj.getChildren().get(0).getText()))
				checker = true;
		%>
		
		<%if ( checker) {%>

		
			<!-- --------------------------------------------  Change Project data ---------------------------------------------------------------->
			
			<br>
			<h4> Generall Project Data</h4>
			<br>		
			
			<div id="changeProject"></div>
			
				<div class="row">
					<%  stProjI = "proj_".concat(new Integer(0).toString())  ; %>
					<div class="rowLato" ><label id="<%= "lato".concat(stProjI) %>"><%= proj.getChildren().get(0).getName() %></label></div>
					<div class="rowLava" ><label id="<%= "lava".concat(stProjI) %>"><%= proj.getChildren().get(0).getText() %></label></div>
					<div class="rowField"><input type="hidden" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= proj.getChildren().get(0).getText() %>"    /></div>
				</div>
				<% if (proj.getChildren().size()>1){for(int i = 1; i < projdata.size()-1; i++) {%>
						<div class="row" >
							<% stProjI = "proj_".concat(new Integer(i).toString());%>
							<div class="rowLato" ><label id="<%= "lato".concat(stProjI) %>"><%= proj.getChildren().get(i).getName() %></label></div>
							<div class="rowLava" ><label id="<%= "lava".concat(stProjI) %>"><%= proj.getChildren().get(i).getText() %></label></div>
							<div class="rowField"><input type="text" class="widthL" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= proj.getChildren().get(i).getText() %>"    /></div>
						</div>
					<% 	}
				} %>
				<div class="row" >
					<div class="rowLato" >&nbsp;</div>
					<div class="rowLava" >&nbsp;</div>
					<div class="rowField"><input type="button" class="widthL" value="Change"  onclick="resourceMethod_I('<%=archivingURL %>', 'changeProject','proj', '<%=projdata.size()-1%>')" /></div>
				</div>
				
					
			<p/>
				
			<!-- ------------------------------------------Molecular data ----------------------------------------------------------- -->
			
			<!-- <div 
					id="ui-accordion-1-header-5" 
					class="toggler ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons" 
					role="tab" 
					aria-controls="ui-accordion-1-panel-5" 
					aria-selected="false" 
					tabindex="0">
		    <span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-e"></span>
			Freie Universität Berlin
			</div>
			<div id="ui-accordion-1-panel-5" class="accordion ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom" style="display: none;" aria-labelledby="ui-accordion-1-header-5" role="tabpanel" aria-expanded="false" aria-hidden="true"></div>		
			 -->		
					
			<h4> Molecular data</h4>
			<br>
			<input  style="width:22%" type="button" name="hide_mol" id="hide_but_0" value="show molecular data" onclick="showhide(0)">
			<div id="hide_0" class="swHide" >
				<p>
				<%List<Object> moleList = ContactToDMS.getMoleList(doc, userId, proId);
				if(moleList.size() != 0){for(int j = 0; j < moleList.size(); j++) {
						int h = j+1;
						Content content = (Content) moleList.get(j);
						String moleId =content.getValue().toString();
						Element mole = ContactToDMS.getMolecular(doc, userId, proId, moleId );
						List<Element> moledata = mole.getChildren();%>
						<p>
						<input type="button" class="widthM" name="hide_but" id=<%="hide_but_"+h%> value="<%= "show ".concat(moleId) %>" onclick="<%="showhide("%><%=h%><%=")"%>">
						<div id=<%= "hide_"+h %> class="swHide">
							<div class="row"><%
								if (moledata.size() !=0){ %>
									<%String stMoleI = "mole_".concat(new Integer(j).toString()).concat("_0")  ; %>
									<div class="row">
										<div class="rowLato" ><label id="<%= "lato".concat(stMoleI) %>"><%= mole.getChildren().get(0).getName() %></label></div>
										<div class="rowLava" ><label id="<%= "lava".concat(stMoleI) %>"><%= mole.getChildren().get(0).getText() %></label></div>
										<div class="rowField"><input type="hidden"	 class="widthL" id="<%= stMoleI %>"	name="<portlet:namespace/><%= stMoleI %>"	value="<%= mole.getChildren().get(0).getText() %>"    /></div>
									</div>
									<%if (mole.getChildren().size()>1){for(int i = 1; i < moledata.size(); i++) {%>
											<% stMoleI = "mole_".concat(new Integer(j).toString()).concat("_").concat(new Integer(i).toString()); %>
											<div class="row">
												<div class="rowLato" ><label id="<%= "lato".concat(stMoleI) %>"><%= mole.getChildren().get(i).getName() %></label></div>
												<div class="rowLava" ><label id="<%= "lava".concat(stMoleI) %>"><%= mole.getChildren().get(i).getText() %></label></div>
												<div class="rowField"><input type="text"  class="widthL"	id="<%= stMoleI %>" name="<portlet:namespace/><%= stMoleI %>"	value="<%= mole.getChildren().get(i).getText() %>"    /></div>
											</div>
										<%}
									}%>
									<div class="row">
										<div class="rowLato" >&nbsp;</div>
										<div class="rowLava" >&nbsp;</div>
										<div class="rowField"><input type="button" class="widthL"	value="Change" onclick="resourceMethod_JI('<%=archivingURL %>', 'changeMolecular','mole','<%= j %>','<%=moledata.size() %>')" /></div>
									</div>
								<%}%>
							</div>
						</div>
					<%}
				} %>
			</div>	

		<%} %>

	<%} %>
<% }%>		

</body>