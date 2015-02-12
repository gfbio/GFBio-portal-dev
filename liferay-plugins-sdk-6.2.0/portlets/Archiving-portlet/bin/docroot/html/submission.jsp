
<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  jqery.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />


<!------------------------------------------------    Submit Part     -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->


<%
	String path = "D:\\GFBIO_code\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\docroot\\xml\\userdata.xml";
	org.jdom2.Document doc = ContactToDMS.getData(path);

	String userId 		  = new Long(PortalUtil.getUser(request).getUserId()).toString();
	Boolean userCheck =  ContactToDMS.checkUserId(Long.toString(PortalUtil.getUser(request).getUserId()), doc);

	String notPro = "muster";

	if (userCheck.equals(true))
		userId = Long.toString(PortalUtil.getUser(request).getUserId());
	else
		userId = notPro;

	List<Object> proList = ContactToDMS.getProList(doc, userId);
%>


<div class="dBorder">
	<p>
	<h3>Data Submission</h3>
	<p>
	Text + how-do-this-work-graphic  
	<p>
	<input type="hidden" id="archivingURL" value="<%=archivingURL%>">
	<input type="hidden" id="submissionCheck" value="true">
	
	<form action="select.htm">
		<select  style="width:100%" name="choWorkflow" id="choWorkflow"  size="1" onchange="radiohide(this.form.choWorkflow.options[this.form.choWorkflow.selectedIndex].value)">
			<option selected value=""		>None	 </option>
			<option  		 value="-10"	>BGBM	 </option>
			<option  		 value="-10"	>DSMZ	 </option>
			<option 		 value="-11"	>ENA / PANGAEA (Molecular Sequence Data)	 </option>
			<option  		 value="-10"	>MfN	 </option>
			<option  		 value="-10"	>PANGAEA (Ecology)	 </option>
			<option  		 value="-10"	>SGN	 </option>
			<option  		 value="-10"	>SMNS	 </option>
			<option  		 value="-10"	>SNSB	 </option>
			<option  		 value="-10"	>ZFMK	 </option>
		</select>
	</form>

	

	<br>
	
	<!--------------------------------------------------------------GCDJ-Widget ---------------------------------------------------->
	<div id="hide_-11" class="swHide">
		<h4>ENA / PANGAEA (Molecular Sequence Data)</h4>
		<br>
		Please select the project to which the data is / should be linked. <br>
		<br>
		<form action="select.htm">
			<select  style="width:100%" name="<portlet:namespace/>chooPro" id="chooPro" size="1" onchange="checkContent(this.form.chooPro.options[this.form.chooPro.selectedIndex].value)">
				<option selected value="none"		>None	 </option>
				<%if (userId!=notPro){ for(int i = 0; i < proList.size(); i++) {
					Content content = (Content) proList.get(i);
					List<Element> projdata = ContactToDMS.getProject(doc, content.getValue()).getChildren();
					%>
					<option 	value="<%=content.getValue()  %>">	<%=projdata.get(1).getText() %>    </option> 
				<%}	}%>
			</select>
		</form>
	</div>
	
	<!-- -------------------------------------------------------------    Rest ------------------------------------------------------->
	<div id="hide_-10" class="swHide">
		
		<div class="portlet-msg-alert" >
			This Archiving Workflow will be build to a later time.
		</div>
	</div>
	
	<div id="hide_-20" class="swHide">
		<div class="portlet-msg-alert" style="background-color: #C6E0B4; border-color: #548235; color:#375623">
			Data Submission complete.
		</div>
	</div>
	
	
	
	
</div>	
