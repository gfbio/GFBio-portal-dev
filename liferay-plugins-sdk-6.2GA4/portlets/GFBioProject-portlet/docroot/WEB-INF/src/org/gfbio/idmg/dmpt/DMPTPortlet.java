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

import org.gfbio.idmg.dto.GCategory;
import org.gfbio.idmg.dto.GLegalRequirement;
import org.gfbio.idmg.dto.GLicense;
import org.gfbio.idmg.dto.GMetadata;
import org.gfbio.idmg.jiraclient.model.Customfield_10217;
import org.gfbio.idmg.util.ContentUtil;
import org.gfbio.model.DataManagementPlan;
import org.gfbio.model.impl.DataManagementPlanImpl;
import org.gfbio.service.DataManagementPlanLocalServiceUtil;

import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.exception.PortalException;
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

		// Setting Lists for dropdowns
		List<GCategory> researchfields = ContentUtil.getCategoryListByType("research field");
		List<GMetadata> metadata = ContentUtil.getListByTableName(GMetadata.class, "gfbio_metadata");
		List<GLicense> licenses = ContentUtil.getListByTableName(GLicense.class, "gfbio_license");
		List<GLegalRequirement> requirements = ContentUtil.getListByTableName(GLegalRequirement.class,
				"gfbio_legalrequirement");
		// List<GFunding> fundings =
		// ContentUtil.getListByTableName(GFunding.class, "gfbio_funding...");
		// List<GPolicy> policies =
		// ContentUtil.getListByTableName(GPolicy.class, "gfbio_policy");

		renderRequest.setAttribute("researchfields", researchfields);
		renderRequest.setAttribute("metadata", metadata);
		renderRequest.setAttribute("licenses", licenses);
		renderRequest.setAttribute("requirements", requirements);
		// renderRequest.setAttribute("fundings", fundings);
		// renderRequest.setAttribute("policies", policies);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Portal URL
		String portalURL = themeDisplay.getPortalURL();
		
		// Setting email and username if user is logged in
		String username = "";
		String email = "";
		List<Phone> phones = null;
		List<DataManagementPlan> dmps = null;
		if (themeDisplay.isSignedIn()) {
			username = themeDisplay.getUser().getFullName();
			email = themeDisplay.getUser().getEmailAddress();
			dmps = DataManagementPlanLocalServiceUtil.getdmpListByUserId(themeDisplay.getUserId());
			try {
				phones = themeDisplay.getUser().getPhones();
			} catch (SystemException e) {
				_log.error("Error while getting phonenumbers from themedisplay", e);
			}
		}

		renderRequest.setAttribute("username", username);
		renderRequest.setAttribute("email", email);
		renderRequest.setAttribute("portalurl", portalURL);
		
		if (dmps != null && !dmps.isEmpty()) {
			renderRequest.setAttribute("dmpsforuser", dmps);
			renderRequest.setAttribute("hasDmps", "true");
		}
		if (phones != null && !phones.isEmpty()) {
			for (Phone p : phones) {
				if (p.isPrimary()) {
					renderRequest.setAttribute("phone", p.getNumber());
				}
			}
		}

		// Setting context path for downloading pdf 
		String contextPath = renderResponse.encodeURL(renderRequest.getContextPath());
		renderRequest.setAttribute("contextPath", contextPath);
		
		
				
		super.render(renderRequest, renderResponse);
	}

	/* Handling ajax requests by getting ResourceID's from resourceRequest */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (resourceRequest.getResourceID().equals("wizard")) {
			finishWizard(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("license")) {
			getLicenseData(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("savedmp")) {
			saveDMP(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("loaddmp")) {
			loadDMP(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("deletedmp")) {
			deleteDMP(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("senddmp")) {
			sendDMP(resourceRequest, resourceResponse);
		}
	}

	private void finishWizard(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		// Get DMPTInput
		String jsonInput = resourceRequest.getParameter("json");
		_log.info("JSONString: " + jsonInput);

		//DMPTInput input = null;
		String response = "";

		try {
			
			//Gson gson = new Gson();
			//input = gson.fromJson(jsonInput, DMPTInput.class);
			//_log.info("Input: " + input);
				
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 			
			// Set DMPTInput to PortletSession
			PortletSession session = resourceRequest.getPortletSession();
		    session.setAttribute("dmptInput", jsonInput, PortletSession.APPLICATION_SCOPE);
		    _log.info("From Session:" + (String) session.getAttribute("dmptInput", PortletSession.APPLICATION_SCOPE));
		    // ThemePath needed in DownloadUtil
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

	private void getLicenseData(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		// Get data
		String license = resourceRequest.getParameter("license");
		
		List<GLicense> licenses = ContentUtil.getListByTableName(GLicense.class, "gfbio_license");
		
		String url = "";
		String description = "";
		
		for (GLicense lic : licenses) {
			if (lic.getLabel().equals(license)) {
				url = lic.getUrl();
				description = lic.getDescription();
			}
		}
		
		if (url.isEmpty()) url = "url";
		if (description.isEmpty()) description = "desc";
		
		String response = url + "," + description;
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(response);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void saveDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		long userId = -1; //Must be validated before set in dmp 
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			userId = themeDisplay.getUserId();
		}
		
		PortletSession session = resourceRequest.getPortletSession();
		String jsonInput = (String) session.getAttribute("dmptInput", PortletSession.APPLICATION_SCOPE);
		//Not neccessary to convert?
		//Gson gson = new Gson();
		//DMPTInput input = gson.fromJson(jsonInput, DMPTInput.class);
		_log.info("Input: " + jsonInput);
		
		// Get Project Name
		String projectName = resourceRequest.getParameter("name");
		long dmpId = Long.parseLong(resourceRequest.getParameter("dmpId"));
		String response = "The Data Managemant Plan could not been saved.";
		
		if (userId > -1 && !projectName.isEmpty()) {
			DataManagementPlanImpl plan;
			
			try {
				if (dmpId > 0) {
					plan = (DataManagementPlanImpl) DataManagementPlanLocalServiceUtil.getDataManagementPlan(dmpId);
				} else {
					plan = new DataManagementPlanImpl();
					plan.setUserID(userId);
				}
				plan.setDmpTInput(jsonInput);
				plan.setName(projectName);
				_log.info("Plan: " + plan);
				
				if (userId == plan.getUserID()) {
					plan = (DataManagementPlanImpl) DataManagementPlanLocalServiceUtil.updateDataManagementPlan(plan);
					response = "The data managemant plan was saved successfully.";
					_log.info("DMP saved in database with id " + plan.getDmpID() + "!");
				} else {
					_log.error("The userId of the dmp is different from the userId in the portletsession!");
				}
			} catch (SystemException | PortalException e) {
				_log.error("Error while saving DMP in database!", e);
			}
		} else {
			_log.error("DMP is not valid!");
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(response);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void loadDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		//Get id
		Long dmpId = Long.parseLong(resourceRequest.getParameter("dmpId"));
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<DataManagementPlan> dmps = DataManagementPlanLocalServiceUtil.getdmpListByUserId(themeDisplay.getUserId());
		
		String dmptInput = "";
		String response = "";
		
		for (DataManagementPlan d : dmps) {
			if (d.getDmpID() == dmpId) {
				dmptInput = d.getDmpTInput();
			}
		}
		
		if (dmptInput.equals("")) {
			_log.error("DmptInput is empty!");
			response = "DMP could not been restored!";
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
		} else {
			response = dmptInput;
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(response);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void deleteDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		String response = "";
		
		//Get id
		Long dmpId = Long.parseLong(resourceRequest.getParameter("dmpId"));
		
		// Delete Dmp by id
		try {
			DataManagementPlanLocalServiceUtil.deleteDataManagementPlan(dmpId);
			response = "The data management plan was deleted successfully!";
			_log.info("DMP with the id " + dmpId + " was deleted successfully!");
		} catch (PortalException | SystemException e) {
			response = "The data management plan could not been deleted!";
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
			_log.error("DMP with the id " + dmpId + " could not been deleted!", e);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		writer.println(response);
		
		writer.flush();
		writer.close();
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void sendDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		_log.info("Send DMP Request");
		
		String[] services = resourceRequest.getParameterValues("services[]");
		for (int i = 0; i < services.length; i++) {
			_log.info("Service: " + services[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		String response = "Request sended!";
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		writer.println(response);
		
		writer.flush();
		writer.close();
		
		super.serveResource(resourceRequest, resourceResponse);
	}
}
