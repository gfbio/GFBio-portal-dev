<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  jqery.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />


<!-- -------------------------------------------------- preparation the choose project steps ----------------------------------------------->
 
<portlet:actionURL name="changeUser" var="addDetailsURL" /> 



 <%
	String path = "D:\\GFBIO_code\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\docroot\\xml\\userdata.xml";
	org.jdom2.Document doc = ContactToDMS.getData(path);
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String userId 		  = new Long(PortalUtil.getUser(request).getUserId()).toString();
	Boolean userCheck =  ContactToDMS.checkUserId(Long.toString(PortalUtil.getUser(request).getUserId()), doc);
	String proId ="gap";

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
Text of explanation and choose one of your projects or create a new project.
<br>
<br>	

<!------------------------------------------------    New Project & User -------------------------------------------------------------------->
<%if (userId.equals(notPro)){ %>
		
	<%
	userId = Long.toString(PortalUtil.getUser(request).getUserId()); 
	String stProjI;
	List<Element> projmuster = ContactToDMS.getProject(doc, "muster").getChildren();
	%>

	<table>
		<tr>
			<%stProjI = "newprous_".concat(new Integer(0).toString())  ;%>
			<td style="width:50%"><input type="hidden"  id="<%= stProjI %>" name="<portlet:namespace/>newproj"   value="<%=userId %>"   /> </td>
		</tr>
		<%for(int i = 1; i < projmuster.size()-1; i++) {%>
			<tr>
				<% stProjI = "newprous_".concat(new Integer(i).toString()); %>
				<td style="width:25%" ><label id="<%= "lato".concat(stProjI).concat(new Integer(i).toString()) %>"><%=projmuster.get(i).getName() %></label></td>
				<td style="width:50%" ><label id="<%= "lava".concat(stProjI) %>"></label></td>
				<td style="width:25%" ><input type="text"  id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></td>
			</tr>
		<% } %>
		<tr>
			<td style="width:25%"  ></td>
			<td style="width:50%"  ></td>
			<td style="width:50%"><input type="submit"  value="new Project"  onclick="newProUser('<%=archivingURL %>', 'newProUser','newprous', '<%=projmuster.size()-1%>')" /></td>
		</tr>
	</table>

		
<%}else{
	
	userId = Long.toString(PortalUtil.getUser(request).getUserId()); %>


	<!------------------------------------------------    Choose Project    -------------------------------------------------------------------->

	
		<form action="select.htm">
			<select  style="width:100%" name="<portlet:namespace/>choPro" id="choPro" size="1" onchange="chooseProject('<%=archivingURL %>','choosePro',this.form.choPro.options[this.form.choPro.selectedIndex].value, '-3')">
				<option selected value="none">None	 </option>
				<%if (userId!=notPro){for(int i = 0; i < proList.size(); i++) {
					Content content = (Content) proList.get(i);
					List<Element> projdata = ContactToDMS.getProject(doc, content.getValue()).getChildren();%>
					<option 	value="<%=content.getValue()  %>">	"<%=projdata.get(1).getText()%>"    </option> 
				<%}	}%>
			</select>
		</form>
	
	<input  type="button" id="hide_but_-2" name="hide_but_-2" value="show the Formular to build a new Project"    onclick="showhide(-2)">

	<br>
	<br>

	
	
	<% 	proId =(String)prefs.getValue("choPro", "gap");	%>
				

	<!-- -----------------------------------------------       New Project           -------------------------------------------------------- -->
			
	<%
		String stProjI;
		List<Element> projmuster = ContactToDMS.getProject(doc, "muster").getChildren();
	%>
	
			
	<div id="hide_-2" class="swHide">
		<br>
		<h4> New Project</h4><br>
		<table>
			<tr>
				<%stProjI = "newproj_".concat(new Integer(0).toString())  ;%>
				<td style="width:50%"><input type="hidden"  id="<%= stProjI %>" name="<portlet:namespace/>newproj"   value="<%=userId %>"   /> </td>
			</tr>
			<%for(int i = 1; i < projmuster.size()-1; i++) {%>
				<tr>
					<% stProjI = "newproj_".concat(new Integer(i).toString()); %>
					<td style="width:25%" ><label id="<%= "lato".concat(stProjI).concat(new Integer(i).toString()) %>"><%=projmuster.get(i).getName() %></label></td>
					<td style="width:50%" ><label id="<%= "lava".concat(stProjI) %>"></label></td>
					<td style="width:25%" ><input type="text"  id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>"  value="" /></td>
				</tr>
			<% } %>
			<tr>
				<td style="width:25%"  ></td>
				<td style="width:50%"  ></td>
				<td style="width:50%"><input type="submit"  value="new Project"  onclick="newProject('<%=archivingURL %>', 'newProject','newproj', '<%=projmuster.size()-1%>')" /></td>
			</tr>
		</table>
	</div>
	
	<div id="hide_-3" class="swHide">
	
		<% if(proId.equals("gap")){
				
		}else{
			proId =(String)prefs.getValue("choPro", "gap");
			doc = ContactToDMS.getData(path);
			userId = Long.toString(PortalUtil.getUser(request).getUserId()); 
			Element proj = ContactToDMS.getProject(doc, proId);
			List<Element> projdata = proj.getChildren();
		%>
			

		<!-- --------------------------------------------  Change Project data ---------------------------------------------------------------->
					
			<table>
				<tr>
				<%  stProjI = "proj_".concat(new Integer(0).toString())  ; %>
					<td style="width:25%" ><label id="<%= "lato".concat(stProjI) %>"><%= proj.getChildren().get(0).getName() %></label></td>
					<td style="width:50%" ><label id="<%= "lava".concat(stProjI) %>"><%= proj.getChildren().get(0).getText() %></label></td>
					<td style="width:25%" ><input type="hidden" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= proj.getChildren().get(0).getText() %>"    /></td>
				</tr>
				<% if (proj.getChildren().size()>1){for(int i = 1; i < projdata.size()-1; i++) {%>
					<tr>
						<% stProjI = "proj_".concat(new Integer(i).toString());%>
						<td style="width:25%" ><label id="<%= "lato".concat(stProjI) %>"><%= proj.getChildren().get(i).getName() %></label></td>
						<td style="width:50%" ><label id="<%= "lava".concat(stProjI) %>"><%= proj.getChildren().get(i).getText() %></label></td>
						<td style="width:25%" ><input  type="text" id="<%= stProjI %>" name="<portlet:namespace/><%= stProjI %>" value="<%= proj.getChildren().get(i).getText() %>"    /></td>
					</tr>
				<% 	}
					} %>
					<tr>
						<td style="width:25%"  ></td>
						<td style="width:50%"  ></td>
						<td style="width:25%" ><input type="submit"  value="Change"  onclick="resourceMethod_I('<%=archivingURL %>', 'changeProject','proj', '<%=projdata.size()-1%>')" /></td>
					</tr>
				</table>
				<input  type="hidden"  	id="<portlet:namespace/>changeProject"  name="<portlet:namespace/>changeProject" 			value="" />
			
			<p/>
			
	
			<!-- ------------------------------------------Molecular data ----------------------------------------------------------- -->
				
			<div class="dBorder">
			
				<h4> Molecular data</h4>
				<br>
			
				<input  type="button" name="hide_mol" id="hide_but_0" value="show molecular data" onclick="showhide(0)">
				<div id="hide_0" class="swHide" >
						<p/>
						<%List<Object> moleList = ContactToDMS.getMoleList(doc, userId, proId);
						if(moleList.size() != 0){for(int j = 0; j < moleList.size(); j++) {
							int h = j+1;
							Content content = (Content) moleList.get(j);
							String moleId =content.getValue().toString();
							Element mole = ContactToDMS.getMolecular(doc, userId, proId, moleId );
							List<Element> moledata = mole.getChildren();%>
							<p/>
							<input type="button" name="hide_but" id=<%="hide_but_"+h%> value="<%= "show ".concat(moleId) %>" onclick="<%="showhide("%><%=h%><%=")"%>">
							<div id=<%= "hide_"+h %> class="swHide">
								<table><%
									if (moledata.size() !=0){ %>
										<tr>
											<%String stMoleI = "mole_".concat(new Integer(j).toString()).concat("_0")  ; %>
											<td style="width:25%" ><label id="<%= "lato".concat(stMoleI) %>"><%= mole.getChildren().get(0).getName() %></label></td>
											<td style="width:50%" ><label id="<%= "lava".concat(stMoleI) %>"><%= mole.getChildren().get(0).getText() %></label></td>
											<td style="width:25%" ><input  type="hidden"	id="<%= stMoleI %>"	name="<portlet:namespace/><%= stMoleI %>"	value="<%= mole.getChildren().get(0).getText() %>"    /></td>
										</tr>
										<%if (mole.getChildren().size()>1){for(int i = 1; i < moledata.size(); i++) {%>
											<tr>
												<% stMoleI = "mole_".concat(new Integer(j).toString()).concat("_").concat(new Integer(i).toString()); %>
												<td style="width:25%"  ><label id="<%= "lato".concat(stMoleI) %>"><%= mole.getChildren().get(i).getName() %></label></td>
												<td style="width:50%"  ><label id="<%= "lava".concat(stMoleI) %>"><%= mole.getChildren().get(i).getText() %></label></td>
												<td style="width:25%" ><input  type="text"	id="<%= stMoleI %>" name="<portlet:namespace/><%= stMoleI %>"	value="<%= mole.getChildren().get(i).getText() %>"    /></td>
											</tr>
										<%}
										}%>
										<tr>
											<td style="width:25%" ></td>
											<td style="width:50%" ></td>
											<td style="width:25%" ><input  type="button" 	value="Change" onclick="resourceMethod_JI('<%=archivingURL %>', 'changeMolecular','mole','<%= j %>','<%=moledata.size() %>')" /></td>
										</tr>
									<%}%>
								</table>
							</div><%
							}
							} %>
					</div>
			</div>	
		</div>
		
	<%}
} %>
