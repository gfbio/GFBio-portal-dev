package org.gfbio.idmg.dcrt;

import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.img;
import static j2html.TagCreator.span;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.idmg.dto.GCategory;
import org.gfbio.idmg.jiraclient.JIRAApi;
import org.gfbio.idmg.jiraclient.connection.Communicator;
import org.gfbio.idmg.jiraclient.model.Assignee;
import org.gfbio.idmg.jiraclient.model.Customfield_10217;
import org.gfbio.idmg.jiraclient.model.Fields;
import org.gfbio.idmg.jiraclient.model.Issue;
import org.gfbio.idmg.jiraclient.model.IssueType;
import org.gfbio.idmg.jiraclient.model.Project;
import org.gfbio.idmg.jiraclient.model.Reporter;
import org.gfbio.idmg.util.ContentUtil;
import org.gfbio.idmg.util.DataProviderUtil;
import org.gfbio.model.DataProvider;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class dcrt
 */
public class DCRTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DCRTPortlet.class);

	/* Handling ajax requests by getting ResourceID's from resourceRequest */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (resourceRequest.getResourceID().equals("radio")) {
			ajaxRadio(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("category")) {
			ajaxCategory(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("contact")) {
			ajaxContactButton(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("submission")) {
			ajaxSubmissionButton(resourceRequest, resourceResponse);
		}
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
	
		//Setting categories for dropdowns
		List<GCategory> researchfields = ContentUtil.getCategoryListByType("research field");
		List<GCategory> materials = ContentUtil.getCategoryListByType("material kind");
		
		renderRequest.setAttribute("researchfields", researchfields);
		renderRequest.setAttribute("materials", materials);
		
		//Setting email and username if user is logged in
		String username = "";
		String email = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			username = themeDisplay.getUser().getFullName();
			email = themeDisplay.getUser().getEmailAddress();
		}
		
		renderRequest.setAttribute("username", username);
		renderRequest.setAttribute("email", email);
		
		super.render(renderRequest, renderResponse); 
	}

	/* Method for ajax functionality of Radio Buttons */
	private void ajaxRadio(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		List<DataProvider> recommendedProviders = DataProviderUtil.setRecommendedProviders(physical, taxon, alive, sequenced);
		_log.info("============RECOMMENDED=DATAPROVIDERS============ ");
		if (recommendedProviders.isEmpty()) {
			writer.println(
					"For your selection none of our Data Center is appropriate. Please get in contact with us to find an individual solution.");
		} else {
			dataproviderOutput(writer, recommendedProviders);
		}

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

	/* Method for ajax functionality of Category DropDown */
	private void ajaxCategory(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		//Test ApplicationScoped-Session Values
		//String s = "Hakuna Matata";
		//PortletSession session = resourceRequest.getPortletSession();
	    //session.setAttribute("sessionValue", s ,PortletSession.APPLICATION_SCOPE);
		//_log.info("Value set to PortletSession");

		// Category-DropDown Selection
		String category = resourceRequest.getParameter("category");
		_log.info("Category " + category);
		// Radio-Inputs
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");

		List<DataProvider> recommendedProviders;
		if (category.equals("noselection") || category.equals("default")) {
			recommendedProviders = DataProviderUtil.setRecommendedProviders(physical, taxon, alive, sequenced);
		} else {
			recommendedProviders = DataProviderUtil.setRecommendedProvidersWithCategory(physical, taxon, alive, sequenced, category);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		if (recommendedProviders.isEmpty()) {
			writer.println(
					"For your selection none of our Data Center is appropriate. Please get in contact with us to find an individual solution.");
		} else {
			dataproviderOutput(writer, recommendedProviders);
		}

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	/* Building the html output for the datacenter results */
	private void dataproviderOutput(PrintWriter writer, List<DataProvider> providers) {

		writer.println("<table style=\"width: 100%;\">");

		for (DataProvider dp : providers) {
			String name = dp.getName();
			String label = dp.getLabel().trim();
			_log.info(name);

			writer.print(div()
					.withClass("row dcrttable")
					.with(div().withClass("col-xs-3 col-sm-2 col-lg-2")
							.with(img().withClass("img-zoom").withSrc("/GFBioProject-portlet/images/" + label + ".jpg")
									.attr("style", "width: 80px;")),
							div().withName("recommendation").withClass("col-xs-9 col-sm-6 col-lg-7")
									.attr("style", "padding-left: 1.5em;")
									.with(span().withId(label).withName("dataCenter").withText(name)),
							div().withClass("col-xs-12 col-sm-4 col-lg-3").attr("style", "text-align: center;")
									.with(
											button().withClass("dcrtbutton contact").withText("Contact")
													.withName("contactButton").withType("button").withValue(label),
											button().withClass("dcrtbutton submission").withText("Submission").withName("submissionButton")
													.withType("button").attr("style","margin-left: 2px; margin-right: 2px").withValue(label),
											button().withClass("dcrtbutton details").withText("Details")
													.withName("detailsButton").withType("button").withValue(label)
													//.attr("style", "margin-left: 2px;")
											))
					.render());
		}

		writer.println("</table>");

	}

	/* Method for Contact Button */
	private void ajaxContactButton(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		_log.info("Contact Button Method reached!");

		// Get Data Center
		String dataCenter = resourceRequest.getParameter("dataCenter");

		// Get Radio-Inputs
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");

		// Get Category
		String category = resourceRequest.getParameter("category");

		// Get Dialog Inputs
		String name = resourceRequest.getParameter("contactName");
		String email = resourceRequest.getParameter("contactEmail");
		String message = resourceRequest.getParameter("message");

		_log.info("DataCenter: " + dataCenter + "Physical: " + physical + ", Taxon: " + taxon + ", Alive: " + alive
				+ ", Sequenced: " + sequenced);
		_log.info("Category: " + category + "Name: " + name + ", Email: " + email + ", Message: " + message);

		message = "Name: " + name + "E-Mail: " + email + "Message: " + message;

		// Create Issue
		//PropsUtil reads the property from portal-ext.properties
		Project project = new Project(PropsUtil.get("jira.gfbio.dcrt.projectkey"));
		IssueType issuetype = new IssueType("Question");
		Reporter reporter = new Reporter("testuser1");

		// If a user is signed in, the reporter will be set new with the email
		// address of the user
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			reporter = new Reporter(themeDisplay.getUser().getEmailAddress());
		}

		String summary = "Data Center Recommendation Request";

		// User for assignee value
		String user;

		if (dataCenter.equals("ENA")) {
			user = "brokeragent";
		} else {
			user = dataCenter.toLowerCase();
		}

		List<Customfield_10217> dataCenters = new ArrayList<>();
		if (dataCenter.equals("GFBio")) {
			user = "";
			// Get List of all possible Data Centers if GFBio default contact is used
			String[] dcs = resourceRequest.getParameterValues("dataCenterList[]");
			for (int i = 0; i < dcs.length; i++) {
				if (!dcs[i].equals("GFBio")) {
					dataCenters.add(new Customfield_10217(dcs[i]));
				}
			}
		} else {
			dataCenters.add(new Customfield_10217(dataCenter));
		}

		// Set assignee for the ticket
		Assignee assignee = new Assignee(user);

		//PropsUtil reads the property from portal-ext.properties
		String customfield_10010 = PropsUtil.get("jira.gfbio.dcrt.requesttype");
		String customfield_10500 = "Physical objects: " + physical + "\nTaxon based: " + taxon + "\nAlive: " + alive
				+ "\nPrimarily sequence Data: " + sequenced + "\nCategory: " + category;

		Fields fields = new Fields(project, summary, issuetype, reporter, message, assignee, customfield_10010,
				dataCenters, customfield_10500);
		Issue issue = new Issue(fields);

		// JIRA Request
		Communicator communicator = new Communicator();
		JIRAApi jiraApi = new JIRAApi(communicator);

		String response = jiraApi.createDataCenterTicket(issue);
		_log.info(response);

		// Response
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(response);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

	/* Method for Submission Button */
	private void ajaxSubmissionButton(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		_log.info("Submission Button Method reached!");

		// Get Button Value
		String dataCenter = resourceRequest.getParameter("dataCenter");
		
		String dataCenterList = "";
		String[] dcs = resourceRequest.getParameterValues("dataCenterList[]");
		for (int i = 0; i < dcs.length; i++) {
			if (!dcs[i].equals("GFBio")) {
				dataCenterList = dataCenterList.concat(dcs[i] + ", ");
			}
		}
		dataCenterList = dataCenterList.replaceAll(", $", "");
		_log.info(dataCenterList);
		
		// Get Radio-Inputs
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");

		// Get Category
		String category = resourceRequest.getParameter("category");
		String material = resourceRequest.getParameter("material");

		
		//Set Values to PortletSession for Submission Portlet
		PortletSession session = resourceRequest.getPortletSession();
	    session.setAttribute("physical", physical ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("taxon", taxon ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("alive", alive ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("sequenced", sequenced ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("dataCenter", dataCenter ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("category", category ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("material", material ,PortletSession.APPLICATION_SCOPE);
	    session.setAttribute("possibleDataCenter", dataCenterList,PortletSession.APPLICATION_SCOPE);
		//_log.info("Value set to PortletSession");
		
	    ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    String submissionLink = themeDisplay.getPortalURL() + "/data/submit/generic";
	    //String dmptLink = themeDisplay.getPortalURL() + "/web/guest/dmpt";
	    
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println(submissionLink);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

}