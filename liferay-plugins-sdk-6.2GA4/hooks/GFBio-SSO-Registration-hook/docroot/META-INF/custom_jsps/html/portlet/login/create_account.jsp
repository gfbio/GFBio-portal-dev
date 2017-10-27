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

<%@ include file="/html/portlet/login/init.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	
	String openId = ParamUtil.getString(request, "openId");
	boolean male = ParamUtil.getBoolean(request, "male", true);
	
	Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();
	
	birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
	birthdayCalendar.set(Calendar.DATE, 1);
	birthdayCalendar.set(Calendar.YEAR, 1970);

	User selUser = (User) request.getAttribute("user.selUser");

	PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getDefaultPasswordPolicy(company.getCompanyId());

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
			
		passwordRules += "The password should have at least "+Integer.toString(passMinLen)+" character";
		if (passMinLen>1) passwordRules +="s";
		
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
			passwordRules += "\nPlease set your password following this regular expression: "
							+passRegex+" ";
		}*/
	}

	if (passwordPolicy.isHistory()) {
		passwordRules += "The old password cannot be reused. ";
	}
%>
<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL">
	<portlet:param name="struts_action" value="/login/create_account" />
</portlet:actionURL>

<div class="wrapper" style="margin:20px auto; max-width:500px">
<aui:form action="<%= createAccountURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="openId" type="hidden" value="<%= openId %>" />

	<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactFullNameException.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-open-id-already-exists" />
	<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserIdException.class %>" message="the-user-id-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
		%>

		<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
			<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
	<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
	<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%= ReservedUserEmailAddressException.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserIdException.class %>" message="the-user-id-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= ReservedUserScreenNameException.class %>" message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserIdException.class %>" message="please-enter-a-valid-user-id" />

	<liferay-ui:error exception="<%= UserPasswordException.class %>">

		<%
		UserPasswordException upe = (UserPasswordException)errorException;
		%>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS %>">
			<liferay-ui:message key="that-password-uses-common-words-please-enter-in-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_INVALID %>">
			<liferay-ui:message key="that-password-is-invalid-please-enter-in-a-different-password" />
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_LENGTH %>">

			<%= LanguageUtil.format(pageContext, "that-password-is-too-short-or-too-long-please-make-sure-your-password-is-between-x-and-512-characters", String.valueOf(passwordPolicy.getMinLength()), false) %>
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORD_TOO_TRIVIAL %>">
			Please try again with a strong password: <%=passwordRules %>
		</c:if>

		<c:if test="<%= upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH %>">
			<liferay-ui:message key="the-passwords-you-entered-do-not-match-each-other-please-re-enter-your-password" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="please-enter-a-valid-screen-name" />
	<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

	<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
		<div class="alert alert-info">
			<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
		</div>
	</c:if>

	<aui:model-context model="<%= Contact.class %>" />

	<aui:fieldset>
			<%@ include file="/html/portlet/login/create_account_user_name.jspf" %>

			<c:if test="<%= !PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE) %>">
					
				<div class="portlet-msg-info" style="font-size:13px;margin-top:30px; margin-bottom:0px;">
					<div class="icon-info" title=""></div>
					Please do not use special characters, such as ' ' (space) or 'ä' (german umlaut), since this screenname will be used to create a URL.
				</div>
				<aui:input model="<%= User.class %>" name="screenName"  type="text">
				<aui:validator name="required" />
				</aui:input>
			</c:if>

			<aui:input autoFocus="<%= true %>" model="<%= User.class %>" name="emailAddress"  type="text" showRequiredLabel="<%= false %>" >
				<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
					<aui:validator name="required" />
				</c:if>
			</aui:input>

			<c:if test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
				
				<aui:input label="password" name="password1" size="30" type="password" value="" placeholder="<%=passwordRules%>" title="<%=passwordRules%>" showRequiredLabel="<%= false %>" >
					<aui:validator name="required" />
				</aui:input>
<!-- 			<aui:input label="enter-again" name="password2" size="30" type="password" value="">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>
				</aui:input> -->
	
			</c:if>

			<c:choose>
				<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY) %>">
					<aui:input name="birthday" value="<%= birthdayCalendar %>" />
				</c:when>
				<c:otherwise>
					<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
					<aui:input name="birthdayDay" type="hidden" value="1" />
					<aui:input name="birthdayYear" type="hidden" value="1970" />
				</c:otherwise>
			</c:choose>

			<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE) %>">
				<aui:select label="gender" name="male">
					<aui:option label="male" value="1" />
					<aui:option label="female" selected="<%= !male %>" value="0" />
				</aui:select>
			</c:if>

			<c:if test="<%= PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT %>">
				<portlet:resourceURL var="captchaURL">
					<portlet:param name="struts_action" value="/login/captcha" />
				</portlet:resourceURL>

				<liferay-ui:captcha url="<%= captchaURL %>" />
			</c:if>
			
			
	</aui:fieldset>

	<aui:button-row>
			<aui:button type="submit"  style="width:100%"/>
	</aui:button-row> 
</aui:form>
<liferay-util:include page="/html/portlet/login/navigation.jsp" />
</div>
<% 
String footerContent = "";
try{ 
	String footerName = com.liferay.portal.kernel.util.PropsUtil.get("footer.name");
	JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), footerName);
	String articleId = journalArticle.getArticleId();
	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(themeDisplay.getScopeGroupId(),articleId, "","",themeDisplay);
 	footerContent = articleDisplay.getContent();
} catch (Exception e){
	footerContent = "Sorry, there is no web content with this title";
}
%>
<p><%=footerContent%></p>