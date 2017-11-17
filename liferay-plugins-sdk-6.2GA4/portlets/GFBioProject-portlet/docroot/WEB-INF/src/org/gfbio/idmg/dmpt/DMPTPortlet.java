package org.gfbio.idmg.dmpt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.gfbio.idmg.dto.DMPTInput;
import org.gfbio.idmg.dto.GCategory;
import org.gfbio.idmg.dto.GLegalRequirement;
import org.gfbio.idmg.dto.GLicense;
import org.gfbio.idmg.dto.GMetadata;
import org.gfbio.idmg.util.ContentUtil;
import org.gfbio.model.DataManagementPlan;
import org.gfbio.model.impl.DataManagementPlanImpl;
import org.gfbio.service.DataManagementPlanLocalServiceUtil;
import org.gfbio.service.impl.DataManagementPlanLocalServiceImpl;

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

		// Setting email and username if user is logged in
		String username = "";
		String email = "";
		List<Phone> phones = null;
		List<DataManagementPlan> dmps = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
		}
	}

	private void finishWizard(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		// Get DMPTInput
		String jsonInput = resourceRequest.getParameter("json");
		_log.info("JSONString: " + jsonInput);

		String response = "";

		try {
			
			// Set DMPTInput to PortletSession
			PortletSession session = resourceRequest.getPortletSession();
			session.setAttribute("dmptInput", jsonInput, PortletSession.PORTLET_SCOPE);

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
		String jsonInput = (String) session.getAttribute("dmptInput");
		
		Gson gson = new Gson();
		DMPTInput input = gson.fromJson(jsonInput, DMPTInput.class);
		
		// Get Project Name
		String projectName = resourceRequest.getParameter("name");
		String response = "";
		
		if (userId > -1 && !projectName.isEmpty()) {
		
			DataManagementPlanImpl plan = new DataManagementPlanImpl();
			plan.setDmpTInput(gson.toJson(input));
			plan.setUserID(userId);
			plan.setName(projectName);
			_log.info("Plan: " + plan);
			
			try {
				plan = (DataManagementPlanImpl) DataManagementPlanLocalServiceUtil.updateDataManagementPlan(plan);
				response = "DMP saved in db with id " + plan.getDmpID() + ".";
				_log.info("DMP saved in database!");
			} catch (SystemException e) {
				_log.error("Error while saving DMP in database!", e);
			}
		} else {
			response = "DMP is not valid!";
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
		Long dmpID = Long.parseLong(resourceRequest.getParameter("dmpID"));
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<DataManagementPlan> dmps = DataManagementPlanLocalServiceUtil.getdmpListByUserId(themeDisplay.getUserId());
		
		String dmptInput = "";
		
		for (DataManagementPlan d : dmps) {
			if (d.getDmpID() == dmpID) {
				dmptInput = d.getDmpTInput();
			}
		}
		_log.info("DmptInput: " + dmptInput);
		if (dmptInput.equals("")) {
			_log.info("DMP not found for dmpID " + dmpID);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(dmptInput);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
}
