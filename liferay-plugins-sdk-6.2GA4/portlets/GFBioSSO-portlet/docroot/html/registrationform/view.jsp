<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:resourceURL var="thisURL" id="thisURL" escapeXml="false" /> 

<p>SSO Password Settings</p>
<p>Please fill in the password for SSO authentication (only once):</p>
<form action="<portlet:actionURL/>" method="post">
<table>
	<tr><td>Username: </td><td><input type="text" name = "username" readonly value="<%=renderRequest.getAttribute("username")%>"></td></tr>
	<tr><td>Email: </td><td><input type="text" name = "email" readonly value="<%=renderRequest.getAttribute("email")%>"></td></tr>
	<tr><td>Firstname: </td><td><input type="text" name = "firstname" readonly value="<%=renderRequest.getAttribute("firstname")%>"></td></tr>
	<tr><td>Lastname: </td><td><input type="text" name = "lastname" readonly value="<%=renderRequest.getAttribute("lastname")%>"></td></tr>
	<tr><td>Password:</td><td><input type="password" name="<portlet:namespace/>passwordform" required <%=renderRequest.getAttribute("password")%>></td></tr>
	<tr><td></td><td><input type="submit" value="SUBMIT" <%=renderRequest.getAttribute("submit")%>></td></tr>
</table>
</form>