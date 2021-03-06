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
<style type="text/css">
/* Hide the portlet title */
.portlet-title{
display:none;
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

<%@ include file="/html/portal/init.jsp"%>

<%
	String currentURL = PortalUtil.getCurrentURL(request);

	String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);

	String ticketKey = ParamUtil.getString(request, "ticketKey");

	if (referer.startsWith(themeDisplay.getPathMain() + "/portal/update_password")
			&& Validator.isNotNull(ticketKey)) {
		referer = themeDisplay.getPathMain();
	}
	
%>

<%
	User selUser = (User) request.getAttribute("user.selUser");

	PasswordPolicy passwordPolicy = user.getPasswordPolicy();

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
		/*String passRegex = passwordPolicy.getRegex();
		if (!passRegex.isEmpty()) {
			passwordRules += "\nPlease set your password following this regular expression: " + passRegex + " ";
		}*/
	}

	if (passwordPolicy.isHistory()) {
		passwordRules += "The old password cannot be reused. ";
	}
%>

<div class="wrapper" style="margin:20px auto; max-width:500px">
	<c:choose>
		<c:when
			test="<%=SessionErrors.contains(request, UserLockoutException.class.getName())%>">
			<div class="alert alert-error">
				<liferay-ui:message key="this-account-has-been-locked" />
			</div>
		</c:when>
		<c:otherwise>
			<aui:form
				action='<%=themeDisplay.getPathMain() + "/portal/update_password"%>'
				method="post" name="fm">
				<aui:input name="p_l_id" type="hidden"
					value="<%=layout.getPlid()%>" />
				<aui:input name="p_auth" type="hidden"
					value="<%=AuthTokenUtil.getToken(request)%>" />
				<aui:input name="doAsUserId" type="hidden"
					value="<%=themeDisplay.getDoAsUserId()%>" />
				<aui:input name="<%=Constants.CMD%>" type="hidden"
					value="<%=Constants.UPDATE%>" />
				<aui:input name="<%=WebKeys.REFERER%>" type="hidden"
					value="<%=referer%>" />
				<aui:input name="ticketKey" type="hidden" value="<%=ticketKey%>" />

<!-- 				<div class="alert alert-info">
					<liferay-ui:message key="please-set-a-new-password" />
					<c:if test="<%=!passwordRules.isEmpty()%>">
					</c:if>
				</div> -->

				<c:if
					test="<%=SessionErrors.contains(request, UserPasswordException.class.getName())%>">

					<%
						UserPasswordException upe = (UserPasswordException) SessionErrors.get(request,
												UserPasswordException.class.getName());
					%>

					<div class="alert alert-error">
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
							<%=LanguageUtil.format(pageContext,
										"that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters",
										String.valueOf(passwordPolicy.getMinLength()), false)%>
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
							Please try again with a strong password: <%=passwordRules %>
						</c:if>

						<c:if
							test="<%=upe.getType() == UserPasswordException.PASSWORD_TOO_YOUNG%>">
							<%=LanguageUtil.format(pageContext,
										"you-cannot-change-your-password-yet-please-wait-at-least-x-before-changing-your-password-again",
										LanguageUtil.getTimeDescription(pageContext, passwordPolicy.getMinAge() * 1000),
										false)%>
						</c:if>

						<c:if
							test="<%=upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH%>">
							<liferay-ui:message
								key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
						</c:if>
					</div>
				</c:if>
				
				<aui:fieldset>
					<div data-tip="<%=passwordRules%>">
					<aui:input autoFocus="<%=true%>" class="lfr-input-text-container" style="text-overflow: ellipsis;"
						label="new-password" name="password1" type="password" placeholder="<%=passwordRules%>"/>
					</div>
					<aui:input name="password2" type="hidden" />
					<!-- <aui:input class="lfr-input-text-container" label="enter-again"
						name="password2" type="password" /> -->
				</aui:fieldset>

				<div class="portlet-msg-info">
					Please note that you can use the same username and password to
					access the GFBio Help Center. </br> If you already have a Help Center
					account with a different email, please <a
						href="//helpdesk.gfbio.org/servicedesk/customer/portal/5/create/50">contact
						us</a>.
				</div>

				<aui:button-row>
					<aui:button type="submit" style="width:100%"
					onclick="document.getElementById('password2').value=document.getElementById('password1').value;"
					/>
				</aui:button-row>
			</aui:form>
		</c:otherwise>
	</c:choose>
</div>

<%
	String footerContent = "";
	try {
		String footerName = com.liferay.portal.kernel.util.PropsUtil.get("footer.name");
		JournalArticle journalArticle = JournalArticleLocalServiceUtil
				.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), footerName);
		String articleId = journalArticle.getArticleId();
		JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(themeDisplay.getScopeGroupId(),
				articleId, "", "", themeDisplay);
		footerContent = articleDisplay.getContent();
	} catch (Exception e) {
		footerContent = "Sorry, there is no web content with this title";
	}
%>
<p><%=footerContent%></p>