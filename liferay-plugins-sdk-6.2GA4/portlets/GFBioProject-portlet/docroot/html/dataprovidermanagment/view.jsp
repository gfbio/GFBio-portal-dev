<input name="csrfmiddlewaretoken" type="hidden" value="HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C" />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%!RenderResponse renderResponse; %>

<jsp:useBean class="java.lang.String" id="keyWords" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL escapeXml="false" id="dataprovidermanagmentURL" var="dataprovidermanagmentURL" />
<meta charset="UTF-8">


<%@ include file="/html/init.jsp" %> 																			<!-- library imports -->
<%@ include file="/html/dataprovidermanagment/init.jsp" %> 																<!-- library imports -->
<script  src="${pageContext.request.contextPath}/js/main.js"       					type="text/javascript"></script>  	<!-- main.js  imports -->
<script  src="${pageContext.request.contextPath}/js/dataprovidermanagment.js"      	type="text/javascript"></script>  	<!-- main.js  imports -->
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" 		type="text/css"> 					<!-- main.css imports -->

<input type="hidden" class="widthL" id="path"  						value="<%=request.getContextPath()%>" />
<input type="hidden" class="widthL" id="dataprovidermanagmenturl"  	value="<%=dataprovidermanagmentURL %>" />


<body >
	<h2>Data Provider Menu</h2>

	<%if (PortalUtil.getUser(request)==null){ %>
	
		<div class="portlet-msg-alert">
			Please sign in to use the data provider menu.
		</div>

	<%}else { %>
		<%
			List <String> dpList = new ArrayList<String>();
			dpList = null;
			dpList = DataProviderLocalServiceUtil.getLabels ();

		%>

		<%if (dpList.size()==0){ %>
	
			<div class="portlet-msg-alert">
				Fail by find the list of Data Provider's
			</div>

		<%}else { %>
			
			<!------------------------------------------------ Choose Data Provider -------------------------------------------------------------------->
	
			Please select one of the Data Provider (DataCenter or Archive).<br>
				
			<br>
	
			<form action="select.html">
				<select id="choDP" name="<portlet:namespace/>choDP" onchange="choosedpmaDataProvider('chooseDP',this.form.choDP.options[this.form.choDP.selectedIndex].value, 'dpmaDataProvider')" size="1" style="width:50%">
					<option selected value="none">None </option>
					<%if (dpList.size()>0){for (int i = 0; i < dpList.size(); i++) { %>
						<option value="<%=  dpList.get(i) %>"> <%= dpList.get(i) %> </option>
					<%} } %>
				</select>
			</form>
						
		
			<div id="dpmaDataProvider">
			
			</div>
	
		<% } %>
	<% } %>
</body>