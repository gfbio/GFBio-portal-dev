<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<style>
/* Style for password tooltip box */
[data-tip] {
	position:relative;
}
/* hides the tooltip when not hovered */
[data-tip]:after {
	display:none;
	content:attr(data-tip);
	position:absolute;
	top:60px;
	left:0px;
	padding:5px 8px;
	background:#1a1a1a;
	color:#fff;
	z-index:100;
	font-size: 0.75em;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	word-wrap:normal;
}
[data-tip]:hover:after {
	display:table;
}
</style>

<%@ include file="/html/portlet/users_admin/init.jsp"%>

<%-- <%
	User selUser = (User) request.getAttribute("user.selUser");

	PasswordPolicy passwordPolicy = (PasswordPolicy) request.getAttribute("user.passwordPolicy");

	boolean passwordResetDisabled = false;

	if (((selUser == null) || (selUser.getLastLoginDate() == null)) && ((passwordPolicy == null)
			|| (passwordPolicy.isChangeable() && passwordPolicy.isChangeRequired()))) {
		passwordResetDisabled = true;
	}

	boolean passwordReset = false;

	if (passwordResetDisabled) {
		passwordReset = true;
	} else {
		passwordReset = BeanParamUtil.getBoolean(selUser, request, "passwordReset");
	}

	String passwordRules = "";
	if (passwordPolicy.isCheckSyntax()) {
		/*if (passwordPolicy.isAllowDictionaryWords()) {
			passwordRules += "The new password should not contain dictionary words. ";
		}*/
		int passMinAlp = passwordPolicy.getMinAlphanumeric();
		int passMinLen = passwordPolicy.getMinLength();
		int passMinLowCase = passwordPolicy.getMinLowerCase();
		int passMinNum = passwordPolicy.getMinNumbers();
		int passMinSym = passwordPolicy.getMinSymbols();
		int passMinUppCase = passwordPolicy.getMinUpperCase();

		passwordRules += "A minimum length is "+Integer.toString(passMinLen);
		
		if (passMinAlp>0 || passMinLowCase>0 || passMinUppCase>0 || passMinNum>0 || passMinSym>0)
			passwordRules += " including at least ";
		if (passMinAlp>0) {
			passwordRules += Integer.toString(passMinAlp)+" alphabet and number character";
			if (passMinAlp>1) passwordRules +="s";
		}
		if (passMinLowCase>0) {
			if (passMinAlp>0) passwordRules += ", ";
			passwordRules += Integer.toString(passMinLowCase)+" lowercase letter";
			if (passMinLowCase>1) passwordRules +="s";
		}
		if (passMinUppCase>0) {
			if (passMinAlp>0 || passMinLowCase>0) passwordRules += ", ";
			passwordRules += Integer.toString(passMinUppCase)+ " uppercase letter";
			if (passMinUppCase>1) passwordRules +="s";
		}
		if (passMinNum>0){
			if (passMinAlp>0 || passMinLowCase>0 || passMinUppCase>0) passwordRules += ", ";
			passwordRules += Integer.toString(passMinNum)+" number";
			if (passMinNum>1) passwordRules +="s";
		}
		if (passMinSym>0){
			if (passMinAlp>0 || passMinLowCase>0 || passMinUppCase>0 || passMinNum>0) 
				passwordRules += ", ";
			passwordRules += Integer.toString(passMinSym)+" symbol(s)";
		}
		passwordRules += ". ";
		/*
		String passRegex = passwordPolicy.getRegex();
		if (!passRegex.isEmpty()) {
			passwordRules += "\nPlease set your password following this regular expression: "
							+passRegex+" ";
		}*/
	}

	if (passwordPolicy.isHistory()) {
		passwordRules += "The old password cannot be reused. ";
	}
%>
<liferay-ui:error-marker key="errorSection" value="password" />

<aui:model-context bean="<%=selUser%>" model="<%=User.class%>" />
 --%>
<h3>
	<liferay-ui:message key="password" />
</h3>

<%-- <liferay-ui:error exception="<%=UserPasswordException.class%>">

	<%
		UserPasswordException upe = (UserPasswordException) errorException;
	%>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_ALREADY_USED%>">
		<liferay-ui:message
			key="that-password-has-already-been-used-please-enter-in-a-different-password" />
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS%>">
		<liferay-ui:message
			key="that-password-uses-common-words-please-enter-in-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_INVALID%>">
		<liferay-ui:message
			key="that-password-is-invalid-please-enter-in-a-different-password" />
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_LENGTH%>">

		<%
			int passwordPolicyMinLength = PropsValues.PASSWORDS_DEFAULT_POLICY_MIN_LENGTH;

					if (passwordPolicy != null) {
						passwordPolicyMinLength = passwordPolicy.getMinLength();
					}
		%>

		<%=LanguageUtil.format(pageContext,
							"that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters",
							String.valueOf(passwordPolicyMinLength), false)%>
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_NOT_CHANGEABLE%>">
		<liferay-ui:message key="your-password-cannot-be-changed" />
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_SAME_AS_CURRENT%>">
		<liferay-ui:message
			key="your-new-password-cannot-be-the-same-as-your-old-password-please-enter-in-a-different-password" />
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL%>">
		<liferay-ui:message key="that-password-is-too-trivial" />
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORD_TOO_YOUNG%>">

		<%
			long passwordPolicyMinAge = PropsValues.PASSWORDS_DEFAULT_POLICY_MIN_AGE;

					if (passwordPolicy != null) {
						passwordPolicyMinAge = passwordPolicy.getMinAge();
					}
		%>

		<%=LanguageUtil.format(pageContext,
							"you-cannot-change-your-password-yet-please-wait-at-least-x-before-changing-your-password-again",
							LanguageUtil.getTimeDescription(pageContext, passwordPolicyMinAge * 1000), false)%>
	</c:if>

	<c:if
		test="<%=upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH%>">
		<liferay-ui:message
			key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
	</c:if>
</liferay-ui:error>

<aui:fieldset>

	<!-- LPS-38289 -->

	<input class="hide" />

	<!-- /LPS-38289 -->

	<c:if test="<%=portletName.equals(PortletKeys.MY_ACCOUNT)%>">
		<aui:input autocomplete="off" label="current-password"
			name="password0" size="30" type="password" />
	</c:if>
	<span>
	<div data-tip="<%=passwordRules%>">
	<aui:input autocomplete="off" label="new-password" name="password1" style="text-overflow: ellipsis;"
		size="30" type="password" placeholder="<%=passwordRules%>"/>
	</div>
	<aui:input autocomplete="off" label="enter-again" name="password2"
		size="30" type="password">
		<aui:validator name="equalTo">
			'#<portlet:namespace />password1'
		</aui:validator>
	</aui:input>

	<c:if
		test="<%=(selUser == null) || (user.getUserId() != selUser.getUserId())%>">
		<aui:input disabled="<%=passwordResetDisabled%>"
			label="password-reset-required" name="passwordReset" type="checkbox"
			value="<%=passwordReset%>" />
	</c:if>
</aui:fieldset>
 --%>
<div class="portlet-msg-info" style="font-size:13px;">
	Please change your password at GFBio's central SSO service: </br> 
	<a href="<%=PropsUtil.get("sign_in_url")%>">Sign In at GFBio's SSO</a>.
</div>

<%-- <c:if
	test="<%=PropsValues.USERS_REMINDER_QUERIES_ENABLED && portletName.equals(PortletKeys.MY_ACCOUNT)%>">
	<h3>
		<liferay-ui:message key="reminder" />
	</h3>

	<%
		boolean hasCustomQuestion = true;
	%>

	<aui:fieldset>
		<%@ include
			file="/html/portlet/users_admin/user/password_reminder_query_questions.jspf"%>

		<c:if
			test="<%=PropsValues.USERS_REMINDER_QUERIES_CUSTOM_QUESTION_ENABLED%>">
			<div id="<portlet:namespace />customQuestionDiv">
				<aui:input fieldParam="reminderQueryCustomQuestion"
					label="custom-question" name="reminderQueryQuestion" />
			</div>
		</c:if>

		<aui:input label="answer" maxlength="75" name="reminderQueryAnswer"
			size="50" value="<%=selUser.getReminderQueryAnswer()%>" />
	</aui:fieldset>

	<aui:script use="aui-base">
		var reminderQueryQuestion = A.one('#<portlet:namespace />reminderQueryQuestion');
		var customQuestionDiv = A.one('#<portlet:namespace />customQuestionDiv');

		if (<%=!hasCustomQuestion%> && customQuestionDiv) {
			customQuestionDiv.hide();
		}

		if (reminderQueryQuestion) {
			reminderQueryQuestion.on(
				'change',
				function(event) {
					if (event.target.val() == '<%=UsersAdmin.CUSTOM_QUESTION%>') {
						var reminderQueryCustomQuestion = A.one('#<portlet:namespace />reminderQueryCustomQuestion');

						if (customQuestionDiv) {
							customQuestionDiv.show();
						}

						<%
 	for (String question : PropsValues.USERS_REMINDER_QUERIES_QUESTIONS) {
 %>

							if (reminderQueryCustomQuestion && (reminderQueryCustomQuestion.val() == '<%=UnicodeFormatter.toString(question)%>')) {
								reminderQueryCustomQuestion.val('');
							}

						<%
 	}
 %>

						Liferay.Util.focusFormField(reminderQueryCustomQuestion);
					}
					else {
						if (customQuestionDiv) {
							customQuestionDiv.hide();
						}

						Liferay.Util.focusFormField(A.one('#<portlet:namespace />reminderQueryAnswer'));
					}
				}
			);
		}
	</aui:script>
</c:if> --%>