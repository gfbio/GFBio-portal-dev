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

package org.gfbio;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.webform.util.PortletPropsValues;
import com.liferay.webform.util.WebFormUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/*
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gfbio.idmg.jiraclient.model.AttachmentInput;
*/

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;

//import com.liferay.portal.util.PrefsPropsUtil;
//import com.liferay.portal.util.PropsValues;
/**
 * @author Daniel Weisser
 * @author Jorge Ferrer
 * @author Alberto Montero
 * @author Julio Camarero
 * @author Brian Wing Shun Chan
 */
public class ContactFormToHelpdeskPortlet extends MVCPortlet {
	public static final String PREFERENCES_PREFIX = "preferences--";
    //private static Log _log = LogFactoryUtil.getLog(ContactFormToHelpdeskPortlet.class);


	public void deleteData(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);

		PortletPermissionUtil.check(
			themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
			portletId, ActionKeys.CONFIGURATION);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);

		if (Validator.isNotNull(databaseTableName)) {
			ExpandoTableLocalServiceUtil.deleteTable(
				themeDisplay.getCompanyId(), WebFormUtil.class.getName(),
				databaseTableName);
		}
	}

	public void saveData(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = (String)actionRequest.getAttribute(
			WebKeys.PORTLET_ID);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletId);
		
		String emailFromAddress = actionRequest.getParameter("fromAddress");
		String emailFromName = actionRequest.getParameter("fromName");
		String emailSubject = actionRequest.getParameter("fromSubject");
				
		preferences.setValue("emailFromAddress",emailFromAddress);
		preferences.setValue("emailFromName",emailFromName);
		preferences.setValue("emailSubject", emailSubject);
		
		boolean requireCaptcha = GetterUtil.getBoolean(
		preferences.getValue("requireCaptcha", StringPool.BLANK));
		
		String successURL = GetterUtil.getString(
			preferences.getValue("successURL", StringPool.BLANK));
		boolean sendAsEmail = GetterUtil.getBoolean(
			preferences.getValue("sendAsEmail", StringPool.BLANK));
		boolean saveToDatabase = GetterUtil.getBoolean(
			preferences.getValue("saveToDatabase", StringPool.BLANK));
		String databaseTableName = GetterUtil.getString(
			preferences.getValue("databaseTableName", StringPool.BLANK));
		boolean saveToFile = GetterUtil.getBoolean(
			preferences.getValue("saveToFile", StringPool.BLANK));
		String fileName = GetterUtil.getString(
			preferences.getValue("fileName", StringPool.BLANK));
		
		Boolean validCapatcha=false;
//check  the reCaptcha 
		try {
			//_log.info("validatechallenge called "+actionRequest);

			validCapatcha= validateChallenge(actionRequest);
			_log.info("valid Capatcha "+validCapatcha);

			//_log.info("ActionRequest"+actionRequest);
			//_log.info("--------------------------"+"emailFromAddress" +emailFromAddress+ " g-recaptcha-response ");
		}
		catch (CaptchaTextException cte) {
			SessionErrors.add(
				actionRequest, CaptchaTextException.class.getName());

			return;
		}
		
/*		
		if (requireCaptcha) {
			try {
				CaptchaUtil.check(actionRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(
					actionRequest, CaptchaTextException.class.getName());

				return;
			}
		}
*/		
		//validation of fix fields (emailFromName, emailFromAddress, subject) 
		
		//check if emailAddress is ok
		String[] emailAdresses = WebFormUtil.split(preferences.getValue("emailFromAddress", StringPool.BLANK));

		Set<String> validationFixFieldsErrors = null;
		try {
			validationFixFieldsErrors = validateFixFields(emailAdresses,emailFromName, emailSubject);
		}
		catch (Exception e) {
			SessionErrors.add(
				actionRequest, "validationScriptError", e.getMessage().trim());

			return;
		}
		if(!validCapatcha)
		{
			validationFixFieldsErrors.add("captchanotverified");

		}
		
	

		Map<String, String> fieldsMap = new LinkedHashMap<String, String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);

			String fieldType = preferences.getValue(
				"fieldType" + i, StringPool.BLANK);

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			if (StringUtil.equalsIgnoreCase(fieldType, "paragraph")) {
				continue;
			}

			fieldsMap.put(fieldLabel, actionRequest.getParameter("field" + i));
		}

		Set<String> validationErrors = null;

		try {
			validationErrors = validate(fieldsMap, preferences);
			
		}
		catch (Exception e) {
			SessionErrors.add(
				actionRequest, "validationScriptError", e.getMessage().trim());

			return;
		}
		
		

		if (validationErrors.isEmpty() && validationFixFieldsErrors.isEmpty()) {
			boolean emailSuccess = true;
			boolean databaseSuccess = true;
			boolean fileSuccess = true;

			if (sendAsEmail) {
				emailSuccess = sendEmail(
					themeDisplay.getCompanyId(), fieldsMap, preferences);
			}

			if (saveToDatabase) {
				if (Validator.isNull(databaseTableName)) {
					databaseTableName = WebFormUtil.getNewDatabaseTableName(
						portletId);

					preferences.setValue(
						"databaseTableName", databaseTableName);

					preferences.store();
				}

				databaseSuccess = saveDatabase(
					themeDisplay.getCompanyId(), fieldsMap, preferences,
					databaseTableName);
			}

			if (saveToFile) {
				fileSuccess = saveFile(fieldsMap, fileName);
			}

			if (emailSuccess && databaseSuccess && fileSuccess) {
				SessionMessages.add(actionRequest, "success");
			}
			else {
				SessionErrors.add(actionRequest, "error");
			}
		}
		else {
			for (String badField : validationErrors) {
				SessionErrors.add(actionRequest, "error" + badField);
			}
			for (String badField : validationFixFieldsErrors) {
				_log.info(badField);
				SessionErrors.add(actionRequest, badField);
			}
		}
		
		

		if (SessionErrors.isEmpty(actionRequest) &&
			Validator.isNotNull(successURL)) {

			actionResponse.sendRedirect(successURL);
		}
	}
/* 
private boolean httpRequest()
 {
	 String auth = new String(Base64.encodeBase64(LOGIN.getBytes()));
 	
 	//HTTPResponse response = client.attachFile(CREATE_TICKET_ENDPOINT + issueKey + "/attachments", HTTPConnectionFactory.RequestMethod.POST, new String(encodedBytes), path);
 	
 	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
     HttpPost httppost = new HttpPost(BASE_URL + CREATE_TICKET_ENDPOINT + issueKey + "/attachments");
     httppost.setHeader("X-Atlassian-Token", "nocheck");
     httppost.setHeader("Authorization", "Basic "+auth);
     
     MultipartEntityBuilder builder = MultipartEntityBuilder.create(); 
     builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

     for (AttachmentInput attachmentInput : attachments) {
			builder.addPart(FILE_BODY_TYPE, new InputStreamBody(attachmentInput.getInputStream(), attachmentInput.getFilename()));
		}

     HttpEntity entity = builder.build();
     httppost.setEntity(entity);
     HttpResponse response = null;
     try {
         response = httpClient.execute(httppost);
     } catch (ClientProtocolException e) {
     	_log.error(e);
         return false;
     } catch (IOException e) {
     	_log.error(e);
         return false;
     }
     HttpEntity result = response.getEntity();

     if(response.getStatusLine().getStatusCode() == 200) {
     	return true;
     } else {
     	_log.error("Response: " + response.toString());
     	_log.error("Result: " + result);
     	return false;
     }
 }
	
*/
private Set<String> validateFixFields(String[] emailAdresses, String emailFromName, String emailSubject) {
		Set<String> validationFixFieldsErrors = new HashSet<String>();
		
		if (emailAdresses.length == 0) {
			validationFixFieldsErrors.add("emailAddressRequired");
			System.out.println("EmailAddressRequired");
		}

		for (String emailAdress : emailAdresses) {
			emailAdress = emailAdress.trim();

			if (!isValidEmailAddress(emailAdress)) {		
				validationFixFieldsErrors.add("emailAddressInvalid");
				System.out.println("EmailAddressInvalid");
			}
		}
		
		if (Validator.isNull(emailFromName)) {
			validationFixFieldsErrors.add("emailFromNameRequired");
			System.out.println("EmailFromNameRequired");
		}
		
		if (Validator.isNull(emailSubject)) {
			validationFixFieldsErrors.add("emailSubjectRequired");
			System.out.println("EmailSubjectRequired");
		}
		
		return validationFixFieldsErrors;
		
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals("captcha")) {
				serveCaptcha(resourceRequest, resourceResponse);
			}
			else if (cmd.equals("export")) {
				exportData(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	protected void exportData(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(resourceRequest);

		PortletPermissionUtil.check(
			themeDisplay.getPermissionChecker(), themeDisplay.getPlid(),
			portletId, ActionKeys.CONFIGURATION);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(resourceRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);
		String title = preferences.getValue("title", "no-title");

		StringBuilder sb = new StringBuilder();

		List<String> fieldLabels = new ArrayList<String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);

			String localizedfieldLabel = LocalizationUtil.getPreferencesValue(
				preferences, "fieldLabel" + i, themeDisplay.getLanguageId());

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			fieldLabels.add(fieldLabel);

			sb.append("\"");
			sb.append(localizedfieldLabel.replaceAll("\"", "\\\""));
			sb.append("\";");
		}

		sb.deleteCharAt(sb.length() - 1);
		sb.append("\n");

		if (Validator.isNotNull(databaseTableName)) {
			List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(
				themeDisplay.getCompanyId(), WebFormUtil.class.getName(),
				databaseTableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (ExpandoRow row : rows) {
				for (String fieldName : fieldLabels) {
					String data = ExpandoValueLocalServiceUtil.getData(
						themeDisplay.getCompanyId(),
						WebFormUtil.class.getName(), databaseTableName,
						fieldName, row.getClassPK(), StringPool.BLANK);

					data = data.replaceAll("\"", "\\\"");

					sb.append("\"");
					sb.append(data);
					sb.append("\";");
				}

				sb.deleteCharAt(sb.length() - 1);
				sb.append("\n");
			}
		}

		String fileName = title + ".csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;

		PortletResponseUtil.sendFile(
			resourceRequest, resourceResponse, fileName, bytes, contentType);
	}

	protected String getMailBody(Map<String, String> fieldsMap) {
		StringBuilder sb = new StringBuilder();

		for (String fieldLabel : fieldsMap.keySet()) {
			String fieldValue = fieldsMap.get(fieldLabel);

			sb.append(fieldLabel);
			sb.append(" : ");
			sb.append(fieldValue);
			sb.append("\n");
		}

		return sb.toString();
	}

	protected boolean saveDatabase(
			long companyId, Map<String, String> fieldsMap,
			PortletPreferences preferences, String databaseTableName)
		throws Exception {

		WebFormUtil.checkTable(companyId, databaseTableName, preferences);

		long classPK = CounterLocalServiceUtil.increment(
			WebFormUtil.class.getName());

		try {
			for (String fieldLabel : fieldsMap.keySet()) {
				String fieldValue = fieldsMap.get(fieldLabel);

				ExpandoValueLocalServiceUtil.addValue(
					companyId, WebFormUtil.class.getName(), databaseTableName,
					fieldLabel, classPK, fieldValue);
			}

			return true;
		}
		catch (Exception e) {
			_log.error(
				"The web form data could not be saved to the database", e);

			return false;
		}
	}

	protected boolean saveFile(Map<String, String> fieldsMap, String fileName) {

		// Save the file as a standard Excel CSV format. Use ; as a delimiter,
		// quote each entry with double quotes, and escape double quotes in
		// values a two double quotes.

		StringBuilder sb = new StringBuilder();

		for (String fieldLabel : fieldsMap.keySet()) {
			String fieldValue = fieldsMap.get(fieldLabel);

			sb.append("\"");
			sb.append(StringUtil.replace(fieldValue, "\"", "\"\""));
			sb.append("\";");
		}

		String s = sb.substring(0, sb.length() - 1) + "\n";

		try {
			FileUtil.write(fileName, s, false, true);

			return true;
		}
		catch (Exception e) {
			_log.error("The web form data could not be saved to a file", e);

			return false;
		}
	}
    
	public boolean isValidEmailAddress(String email) {
		return Validator.isEmailAddress(email);
        /*String ePattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();*/
    }
    
	protected boolean sendEmail(
		long companyId, Map<String, String> fieldsMap,
		PortletPreferences preferences) {

		try {
			String emailFromAddress = preferences.getValue(
				"emailFromAddress", StringPool.BLANK);
			String emailFromName = preferences.getValue(
					"emailFromName", StringPool.BLANK);
			System.out.println("FromAddress:" +emailFromAddress);
			System.out.println("FromName:" +emailFromName);
			System.out.println(isValidEmailAddress(emailFromAddress));
			String emailAddresses = preferences.getValue("emailAddress", StringPool.BLANK);
			String emailSubject = preferences.getValue("emailSubject",  StringPool.BLANK);
			System.out.println("EmailSubject:" +emailSubject);
				
			
			/*
			if (Validator.isNull(emailAddresses) ) {
				_log.error(
					"The web form email cannot be sent because no email " +
						"address is configured");
			

				return false;
			}
			if (!isValidEmailAddress(emailFromAddress)){
				_log.error(
						"The web form email cannot be sent because invalid email " +
							"address is provided");
				
					return false;				
			}*/
			
						
			InternetAddress fromAddress = new InternetAddress(emailFromAddress,emailFromName);
			InternetAddress[] toAddress= InternetAddress.parse(emailAddresses);
			 
			String body = getMailBody(fieldsMap);
			

			MailMessage mailMessage = new MailMessage(
					fromAddress, emailSubject, body, false);
			
	
			mailMessage.setTo(toAddress);
					
			
		
			MailServiceUtil.sendEmail(mailMessage);

			return true;
		}
		catch (Exception e) {
			_log.error("The web form email could not be sent", e);
			e.printStackTrace();

			return false;
		}
	}

	protected void serveCaptcha(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	}

	
	protected boolean validateChallenge(PortletRequest portletRequest)
			throws CaptchaException {

			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				portletRequest);

			request = PortalUtil.getOriginalServletRequest(request);

			return validateChallenge(request);
	}
	
	protected boolean validateChallenge(HttpServletRequest request)
			throws CaptchaException {

			String reCaptchaResponse = ParamUtil.getString(
				request, "g-recaptcha-response");
			//_log.info("validate Challenge response"+reCaptchaResponse);
			Http.Options options = new Http.Options();

			try {
				options.addPart(
					"secret",
					PropsUtil.get("google.secretkey"));
			}
			catch (Exception se) {
				_log.error(se, se);
			}

			options.addPart("remoteip", request.getRemoteAddr());
			options.addPart("response", reCaptchaResponse);
			options.setLocation(PropsUtil.get("google.urlverify"));
			options.setPost(true);

			String content = null;

			try {
				content = HttpUtil.URLtoString(options);
				//_log.info("Content :"+content);
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);

				throw new CaptchaTextException();
			}

			if (content == null) {
				_log.error("reCAPTCHA did not return a result");

				throw new CaptchaTextException();
			}

			try {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(content);

				String success = jsonObject.getString("success");

				if (StringUtil.equalsIgnoreCase(success, "true")) {
					return true;
				}

				JSONArray jsonArray = jsonObject.getJSONArray("error-codes");

				if ((jsonArray == null) || (jsonArray.length() == 0)) {
					return false;
				}

				StringBundler sb = new StringBundler(jsonArray.length() * 2 - 1);

				for (int i = 0; i < jsonArray.length(); i++) {
					sb.append(jsonArray.getString(i));

					if (i < (jsonArray.length() - 1)) {
						sb.append(StringPool.COMMA_AND_SPACE);
					}
				}

				_log.error("reCAPTCHA encountered an error: " + sb.toString());

				return false;
			}
			catch (JSONException jsone) {
				_log.error("reCAPTCHA did not return a valid result: " + content);

				throw new CaptchaTextException();
			}
	}
	protected Set<String> validate(
			Map<String, String> fieldsMap, PortletPreferences preferences)
		throws Exception {

		Set<String> validationErrors = new HashSet<String>();

		for (int i = 0; i < fieldsMap.size(); i++) {
			String fieldType = preferences.getValue(
				"fieldType" + (i + 1), StringPool.BLANK);
			String fieldLabel = preferences.getValue(
				"fieldLabel" + (i + 1), StringPool.BLANK);
			String fieldValue = fieldsMap.get(fieldLabel);

			boolean fieldOptional = GetterUtil.getBoolean(
				preferences.getValue(
					"fieldOptional" + (i + 1), StringPool.BLANK));

			if (Validator.equals(fieldType, "paragraph")) {
				continue;
			}

			if (!fieldOptional && Validator.isNotNull(fieldLabel) &&
				Validator.isNull(fieldValue)) {

				validationErrors.add(fieldLabel);

				continue;
			}

			if (!PortletPropsValues.VALIDATION_SCRIPT_ENABLED) {
				continue;
			}

			String validationScript = GetterUtil.getString(
				preferences.getValue(
					"fieldValidationScript" + (i + 1), StringPool.BLANK));

			if (Validator.isNotNull(validationScript) &&
				!WebFormUtil.validate(
					fieldValue, fieldsMap, validationScript)) {

				validationErrors.add(fieldLabel);

				continue;
			}
		}

		return validationErrors;
	}
	
	public String getParameter(PortletRequest portletRequest, String name) {
		name = PREFERENCES_PREFIX.concat(name).concat(StringPool.DOUBLE_DASH);

		return ParamUtil.getString(portletRequest, name);
	}


	private static Log _log = LogFactoryUtil.getLog(ContactFormToHelpdeskPortlet.class);

}