package org.gfbio.idmg.dmpt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.idmg.dto.DMPTInput;
import org.gfbio.idmg.dto.GCategory;
import org.gfbio.idmg.dto.GLegalRequirement;
import org.gfbio.idmg.dto.GLicense;
import org.gfbio.idmg.dto.GMetadata;
import org.gfbio.idmg.util.ContentUtil;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Phone;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DMPTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DMPTPortlet.class);
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
	
		//Setting Lists for dropdowns
		List<GCategory> researchfields = ContentUtil.getCategoryListByType("research field");
		List<GMetadata> metadata = ContentUtil.getListByTableName(GMetadata.class, "gfbio_metadata");
		List<GLicense> licenses = ContentUtil.getListByTableName(GLicense.class, "gfbio_license");
		List<GLegalRequirement> requirements = ContentUtil.getListByTableName(GLegalRequirement.class, "gfbio_legalrequirement");
		//List<GFunding> fundings = ContentUtil.getListByTableName(GFunding.class, "gfbio_funding...");
		//List<GPolicy> policies = ContentUtil.getListByTableName(GPolicy.class, "gfbio_policy");

		renderRequest.setAttribute("researchfields", researchfields);
		renderRequest.setAttribute("metadata", metadata);
		renderRequest.setAttribute("licenses", licenses);
		renderRequest.setAttribute("requirements", requirements);
		//renderRequest.setAttribute("fundings", fundings);
		//renderRequest.setAttribute("policies", policies);
		
		//Setting email and username if user is logged in
		String username = "";
		String email = "";
		List<Phone> phones = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			username = themeDisplay.getUser().getFullName();
			email = themeDisplay.getUser().getEmailAddress();
			try {
				phones = themeDisplay.getUser().getPhones();
			} catch (SystemException e) {
				_log.error("Error while getting phonenumbers from themedisplay", e);
			}
		}
		
		renderRequest.setAttribute("username", username);
		renderRequest.setAttribute("email", email);
		if (phones != null && !phones.isEmpty()) {
			for (Phone p : phones) {
				if (p.isPrimary()) {
					renderRequest.setAttribute("phone", p.getNumber());
				}
			}
		}
		
		//Setting variable for context path
		String contextPath = renderResponse.encodeURL(renderRequest.getContextPath());
		renderRequest.setAttribute("contextPath", contextPath);
		_log.info(contextPath);
	    
		super.render(renderRequest, renderResponse); 
	}
	
	/* Handling ajax requests by getting ResourceID's from resourceRequest */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (resourceRequest.getResourceID().equals("wizard")) {
			finishWizard(resourceRequest, resourceResponse);
		} 
	}
	
	/* Method for ajax functionality of Radio Buttons */
	private void finishWizard(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		// Get DMPTInput
		_log.info("Handle Input Method reached");

		String jsonString = resourceRequest.getParameter("json");
		_log.info(jsonString);

		DMPTInput input = null;
		String response = "";
		
		try {
			Gson gson = new Gson();
			input = gson.fromJson(jsonString, DMPTInput.class);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			//Set DMPTInput to PortletSession
			PortletSession session = resourceRequest.getPortletSession();
		    session.setAttribute("dmptInput", input, PortletSession.APPLICATION_SCOPE);
		    session.setAttribute("themePath", themeDisplay.getPathThemeImages(), PortletSession.APPLICATION_SCOPE);
		    
		    response = "Parsing successful!";
		} catch (JsonSyntaxException e) {
			_log.error("Error while parsing jsonString to POJO", e);
			response = "Error while parsing jsonString to POJO!";
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(response);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
			
	}
}
