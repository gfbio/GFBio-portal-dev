<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
 <%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<portlet:defineObjects />
<portlet:resourceURL var="thisURL" id="thisURL" escapeXml="false" /> 

<liferay-theme:defineObjects />
<liferay-ui:error key="error-key" />

<%
long userID = themeDisplay.getUserId();

String email = UserLocalServiceUtil.getUser(userID).getEmailAddress();
String firstname = UserLocalServiceUtil.getUser(userID).getFirstName();
String lastname = UserLocalServiceUtil.getUser(userID).getLastName();
String submit = "";
if (email=="" || firstname=="" || lastname==""){
	submit="disabled='true'";
}
%>
<p>SSO Password Settings</p>
<p>Please fill in the password for SSO authentication:</p>
<aui:form action="<portlet:actionURL/>" onSubmit="return validateForm()" method="post">
	<aui:input type="text" id="email" label="Username" name = "email" readonly="true" value="<%=email%>"/>
	<aui:input type="text" id="firstname" label="first-name" name = "firstname" readonly="true" value="<%=firstname%>"/>
	<aui:input type="text" id="lastname" label="last-name" name = "lastname" readonly="true" value="<%=lastname%>"/>
	<aui:input type="password" id="pass1" label="password" name="<portlet:namespace/>passwordform"  required="true"/>
	<aui:input type="password" id="pass2" label="confirm-password" name="<portlet:namespace/>passwordform2" required="true"/>
	<div id="msg"></div>
	</br>
	<input type="submit" value="SUBMIT" <%=submit%>></td></tr>

</aui:form>

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