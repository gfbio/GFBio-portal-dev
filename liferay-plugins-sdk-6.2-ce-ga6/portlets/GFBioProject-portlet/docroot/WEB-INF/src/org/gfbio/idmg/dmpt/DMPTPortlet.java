package org.gfbio.idmg.dmpt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
import org.gfbio.idmg.jiraclient.JIRAApi;
import org.gfbio.idmg.jiraclient.connection.Communicator;
import org.gfbio.idmg.jiraclient.model.Assignee;
import org.gfbio.idmg.jiraclient.model.AttachmentInput;
import org.gfbio.idmg.jiraclient.model.Body;
import org.gfbio.idmg.jiraclient.model.Fields;
import org.gfbio.idmg.jiraclient.model.Issue;
import org.gfbio.idmg.jiraclient.model.IssueType;
import org.gfbio.idmg.jiraclient.model.JiraResponse;
import org.gfbio.idmg.jiraclient.model.Project;
import org.gfbio.idmg.jiraclient.model.Reporter;
import org.gfbio.idmg.util.ContentUtil;
import org.gfbio.idmg.util.TXTUtil;
import org.gfbio.model.DataManagementPlan;
import org.gfbio.model.impl.DataManagementPlanImpl;
import org.gfbio.service.DataManagementPlanLocalServiceUtil;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Phone;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DMPTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DMPTPortlet.class);
	
	private long dmpId;
	private long ticketId;
	
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
		} else if (resourceRequest.getResourceID().equals("updatedmp")) {
			updateDMP(resourceRequest, resourceResponse);
		}
	}

	private void finishWizard(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		// Get DMPTInput
		String jsonInput = resourceRequest.getParameter("json");
		String response = "";

		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 			
			// Set DMPTInput to PortletSession
			PortletSession session = resourceRequest.getPortletSession();
		    session.setAttribute("dmptInput", jsonInput, PortletSession.APPLICATION_SCOPE);
		    // ThemePath needed in DownloadUtil
		    session.setAttribute("themePath", themeDisplay.getPathThemeImages(), PortletSession.APPLICATION_SCOPE);
		    
			response = "Parsing successful!";
		} catch (JsonSyntaxException e) {
			_log.error("Error while parsing jsonString to POJO", e);
			response = "Error while parsing jsonString to POJO!";
		}

		serveResourceAction(response, resourceRequest, resourceResponse);
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
		
		serveResourceAction(response, resourceRequest, resourceResponse);
	}
	
	private void saveDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		String response = save(resourceRequest, resourceResponse, 0, Long.parseLong(resourceRequest.getParameter("dmpId")));
		
		serveResourceAction(response, resourceRequest, resourceResponse);
	}
	
	private String save(ResourceRequest resourceRequest, ResourceResponse resourceResponse, long ticId, long dmp) {
		long userId = -1; //Must be validated before set in dmp 
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			userId = themeDisplay.getUserId();
		}
		
		PortletSession session = resourceRequest.getPortletSession();
		String jsonInput = (String) session.getAttribute("dmptInput", PortletSession.APPLICATION_SCOPE);
		
		// Get Project Name
		String projectName = resourceRequest.getParameter("name");
		String response = "The Data Managemant Plan could not been saved.";
		
		if (userId > -1 && !projectName.isEmpty()) {
			DataManagementPlanImpl plan;
			
			try {
				if (dmp > 0) {
					plan = (DataManagementPlanImpl) DataManagementPlanLocalServiceUtil.getDataManagementPlan(dmp);
					_log.debug("Update DMP for user " + userId + " with dmpId " + dmp);
				} else {
					plan = new DataManagementPlanImpl();
					plan.setUserID(userId);
					_log.debug("Create DMP for user " + userId);
				}
				if (ticId > 0) {
					plan.setTicketID(ticId);
				}
				plan.setDmpTInput(jsonInput);
				plan.setName(projectName);
			
				if (userId == plan.getUserID()) {
					plan = (DataManagementPlanImpl) DataManagementPlanLocalServiceUtil.updateDataManagementPlan(plan);
					response = "The data managemant plan has been saved successfully.";
					dmpId = plan.getDmpID();
					_log.info("DMP saved in database with id " + plan.getDmpID());
				} else {
					_log.error("The userId of the dmp is different from the userId in the portletsession!");
				}
			} catch (SystemException | PortalException e) {
				_log.error("Error while saving DMP in database!", e);
			}
		} else {
			_log.warn("DMP is not valid or user is not signed in!");
		}
		
		return response;
	}
	
	private void loadDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		//Get id
		dmpId = Long.parseLong(resourceRequest.getParameter("dmpId"));
		ticketId = Long.parseLong(resourceRequest.getParameter("ticketId"));
		_log.info("Trying to load dmp with id: " + dmpId + " and ticketId: " + ticketId);
		
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
			response = "DMP could not be restored!";
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
		} else {
			response = dmptInput;
		}
		
		serveResourceAction(response, resourceRequest, resourceResponse);
	}
	
	private void deleteDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		String response = "";
		
		//Get id
		dmpId = Long.parseLong(resourceRequest.getParameter("dmpId"));
		
		// Delete Dmp by id
		try {
			DataManagementPlanLocalServiceUtil.deleteDataManagementPlan(dmpId);
			response = "The data management plan was deleted successfully!";
			_log.debug("DMP with the id " + dmpId + " was deleted successfully!");
		} catch (PortalException | SystemException e) {
			response = "The data management plan could not been deleted!";
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500");
			_log.error("DMP with the id " + dmpId + " could not been deleted!", e);
		}
		
		serveResourceAction(response, resourceRequest, resourceResponse);
	}
	
	private void sendDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// Get Request Parameter
		String[] services = resourceRequest.getParameterValues("services[]");
		String message = (String) resourceRequest.getParameter("infos");
		
		DMPTInput input = getDMPTInputFromSession(resourceRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Communicator communicator = new Communicator();
		JIRAApi jiraApi = new JIRAApi(communicator);
		
		String reporter = "";
		if (themeDisplay.isSignedIn()) {
			//TODO: Get goeId for user
			String email = themeDisplay.getUser().getEmailAddress();
			reporter = jiraApi.getJiraUsername(email, email, themeDisplay.getUser().getFullName());
		}
		Issue issue = createJiraIssue(input, services, message, resourceRequest, reporter);		

		// JIRA Request
		String response = jiraApi.createDataCenterTicket(issue);
		Gson gson = new Gson();
		JiraResponse ticket = gson.fromJson(response, JiraResponse.class);
		if (themeDisplay.isSignedIn()) {
    			ticket.setEmail(themeDisplay.getUser().getEmailAddress());
		} else {
    			ticket.setEmail(input.getEmail());
		}
		
		ticketId = ticket.getId();
		
		// Add Jira DMP Attachment
		addAttachment(jiraApi, ticketId, TXTUtil.getTXTAttachmentFromDMP(input));

		//Save
		save(resourceRequest, resourceResponse, ticketId, dmpId);
		
		serveResourceAction(gson.toJson(ticket), resourceRequest, resourceResponse);
	}
	
	private void updateDMP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
				
		// Get Request Parameter
		String message = (String) resourceRequest.getParameter("message");
		
		DMPTInput input = getDMPTInputFromSession(resourceRequest);
		
		// JIRA Request
		Communicator communicator = new Communicator();
		JIRAApi jiraApi = new JIRAApi(communicator);

		// Add Jira DMP Attachment
		addAttachment(jiraApi, ticketId, TXTUtil.getTXTAttachmentFromDMP(input));
		
		// Add additional comment to Jira ticket if not empty
		if (!message.isEmpty()) {
			boolean comment = jiraApi.addComment(ticketId, new Body(message));
			if (comment) {
				_log.info("Added comment to issue " + ticketId);
			} else {
				_log.error("Comment to issue " + ticketId + " could not been send");
			}
		}
		//Save
		save(resourceRequest, resourceResponse, ticketId, dmpId);
		
		serveResourceAction(String.valueOf(ticketId), resourceRequest, resourceResponse);
	}
	
	private Issue createJiraIssue(DMPTInput input, String[] services, String message, ResourceRequest resourceRequest, String reporter) {
		// Set fields
		String projectName = input.getProjectName();
		String projectAbstract = input.getProjectAbstract();
		String description = "";
		if (services != null && message != null) {
			description = message.concat(" - " + createCommaSeperatedString(Arrays.asList(services)));
		}
		String principalInvestigator = createCommaSeperatedString(input.getInvestigators());
		
		// Create Issue
		// PropsUtil reads the property from portal-ext.properties
		_log.info("projectkey: " + PropsUtil.get("jira.gfbio.dmpt.projectkey"));
		Project project = new Project(PropsUtil.get("jira.gfbio.dmpt.projectkey"));
		IssueType issuetype = new IssueType("DMP");
		Reporter rep = new Reporter("testuser1");
		if (!isNullOrEmpty(reporter)) {
			rep.setName(reporter);
		}
		
		// Get Requesttype
		String customfield_10010 = PropsUtil.get("jira.gfbio.dmpt.requesttype");

		// Set assignee for the ticket with user gfbio-ev
		Assignee assignee = new Assignee("");

		Fields fields = new Fields(project, "DMP Request", issuetype, rep, description, assignee, customfield_10010,
				projectName, projectAbstract, principalInvestigator);
		
		return new Issue(fields);
	}
	
	private void addAttachment(JIRAApi jiraApi, long ticketId, AttachmentInput... attachments) {
		boolean added = jiraApi.addAttachments(ticketId, attachments);
		if (added) {
			_log.info("Attachments added for issue " + ticketId);
		} else {
			_log.error("Attachment for issue " + ticketId + " could not been uploaded");
		}
	}
	
	private DMPTInput getDMPTInputFromSession(ResourceRequest resourceRequest) {
		// Get DMPTInput from Session and Convert to DTO
		PortletSession session = resourceRequest.getPortletSession();
		String jsonInput = (String) session.getAttribute("dmptInput", PortletSession.APPLICATION_SCOPE);
		
		Gson gson = new Gson();
		return gson.fromJson(jsonInput, DMPTInput.class);
	}
	
	private void serveResourceAction(String response, ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		writer.println(response);
		
		writer.flush();
		writer.close();
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private String createCommaSeperatedString(List<String> list) {
		String result = "";
		if(!isNullOrEmpty(list)) {
			for (String s : list) {
				result = result.concat(s + ", ");
			}
		}
		return result.replaceAll(", $",	"");
	}
	
	private boolean isNullOrEmpty(final List<String> values) {
		return values == null || values.isEmpty();
	}
	
	private boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}
}