<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  main.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />

<!------------------------------------------------    User Profile    -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->


<h3 >User Profile</h3>
<br>


<!------------------------------------------------      User Data      -------------------------------------------------------------------->


<br>


	<div class="row">
		<div class="rowLato" > User ID:</div>
		<div class="rowLava" > <label id="<%= "lavaStUserID"%>" ><%=PortalUtil.getUser(request).getUserId() %></label></div>
		<div class="rowField"> <input type="hidden" class="widthL" name="stUserI"  value=""   /></div> 
	</div >
	<div class="row">
		<div class="rowLato" > User Name:</div>
		<div class="rowLava" > <%=PortalUtil.getUser(request).getScreenName() %></div>
		<div class="rowField"> <input type="hidden" class="widthL" name="stUserI"  value="<%=PortalUtil.getUser(request).getScreenName() %>"   /></div> 
	</div>
	<div class="row">
		<div class="rowLato" > Full Name:</div>
		<div class="rowLava" > <%=PortalUtil.getUser(request).getFullName() %></div>
		<div class="rowField"> <input type="hidden" class="widthL" name="stUserI"  value="<%=PortalUtil.getUser(request).getFullName() %>"   /></div> 
	</div>
	<div class="row">
		<div class="rowLato" > Email Address:</div>
		<div class="rowLava" > <%=PortalUtil.getUser(request).getEmailAddress() %></div>
		<div class="rowField"> <input type="hidden" class="widthL" name="stUserI"  value="<%=PortalUtil.getUser(request).getEmailAddress() %>"   /></div> 
	</div>


<br>

	
