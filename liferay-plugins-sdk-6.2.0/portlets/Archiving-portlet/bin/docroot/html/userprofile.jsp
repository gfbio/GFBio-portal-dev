<meta charset="UTF-8">



<%@include file="../init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  jqery.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />

<!------------------------------------------------    User Profile    -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->

<h3 >User Profile</h3>
<br>


<!------------------------------------------------      User Data      -------------------------------------------------------------------->


	<table>
		<tr>
			<td style="width:25%">User ID:</td>
			<td style="width:50%"><%=PortalUtil.getUser(request).getUserId() %></td>
			<td style="width:25%"></td>
		</tr>
		<tr>
			<td style="width:25%">User Name:</td>
			<td style="width:50%"> <%=PortalUtil.getUser(request).getScreenName() %></td>
			<td style="width:25%"> <input type="hidden" name="stUserI"  value="<%=PortalUtil.getUser(request).getScreenName() %>"   /></td> 
		</tr>
		<tr>
			<td style="width:25%">Full Name:</td>
			<td style="width:50%"> <%=PortalUtil.getUser(request).getFullName() %></td>
			<td style="width:25%"> <input type="text" name="stUserI"  value="<%=PortalUtil.getUser(request).getFullName() %>"   /></td>
		</tr>
		<tr>
			<td style="width:25%">Email Address:</td>
			<td style="width:50%"> <%=PortalUtil.getUser(request).getEmailAddress() %></td>
			<td style="width:25%"> <input type="text" name="stUserI"  value="<%=PortalUtil.getUser(request).getEmailAddress() %>"   /></td> 
		</tr>	
	</table>	
	


