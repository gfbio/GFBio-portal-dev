<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:resourceURL var="thisURL" id="thisURL" escapeXml="false" /> 

<liferay-ui:error key="error-key" />

<p>SSO Password Settings</p>
<p>Please fill in the password for SSO authentication:</p>
<form action="<portlet:actionURL/>" onSubmit="return validateForm()" method="post">
<table>
	<tr><td>Username: </td><td><input type="text" id="username" name = "username" readonly value="<%=renderRequest.getAttribute("username")%>"></td></tr>
	<tr><td>Email: </td><td><input type="text" id="email" name = "email" readonly value="<%=renderRequest.getAttribute("email")%>"></td></tr>
	<tr><td>Firstname: </td><td><input type="text" id="firstname" name = "firstname" readonly value="<%=renderRequest.getAttribute("firstname")%>"></td></tr>
	<tr><td>Lastname: </td><td><input type="text" id="lastname" name = "lastname" readonly value="<%=renderRequest.getAttribute("lastname")%>"></td></tr>
	<tr><td>Password:</td><td><input type="password" id="pass1" name="<portlet:namespace/>passwordform"  required <%=renderRequest.getAttribute("password")%>></td></tr>
	<tr><td>Retype Password:</td><td><input type="password" id="pass2" name="<portlet:namespace/>passwordform2" required <%=renderRequest.getAttribute("password")%>></td></tr>
	<div id="msg"></div>
	<tr><td></td><td><input type="submit" value="SUBMIT" <%=renderRequest.getAttribute("submit")%>></td></tr>
</table>
</form>

<script>
    function validateForm() {
    	var msg = document.getElementById("msg");
        var password = document.getElementById("pass1").value;
        var password2 = document.getElementById("pass2").value;
        if (password!=password2) {
        	msg.innerHTML = "<font color='#ff0000'>Please type in matching password!<font color='#ff0000'>"
        	return false;
        }
		var user = document.getElementById("username").value;
		var mail = document.getElementById("email").value;
		var firstname = document.getElementById("firstname").value;
		var lastname = document.getElementById("lastname").value;
		if (user=="" || mail=="" || firstname=="" || lastname==""){
        	msg.innerHTML = "<font color='#ff0000'>Your information is incomplete, the user cannot be added.<font color='#ff0000'>";
			return false;
		}
		msg.innerHTML = "";
		return true;
    }
</script>