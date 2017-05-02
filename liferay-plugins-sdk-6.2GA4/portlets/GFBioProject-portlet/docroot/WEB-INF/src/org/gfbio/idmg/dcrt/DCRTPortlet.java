package org.gfbio.idmg.dcrt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.NoSuchHeadException;
import org.gfbio.idmg.dcrt.dao.GCategory;
import org.gfbio.idmg.dcrt.jiraclient.JIRAApi;
import org.gfbio.idmg.dcrt.jiraclient.connection.Communicator;
import org.gfbio.idmg.dcrt.jiraclient.model.Assignee;
import org.gfbio.idmg.dcrt.jiraclient.model.Customfield_10217;
import org.gfbio.idmg.dcrt.jiraclient.model.Fields;
import org.gfbio.idmg.dcrt.jiraclient.model.Issue;
import org.gfbio.idmg.dcrt.jiraclient.model.IssueType;
import org.gfbio.idmg.dcrt.jiraclient.model.Project;
import org.gfbio.idmg.dcrt.jiraclient.model.Reporter;
import org.gfbio.model.DataProvider;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import static j2html.TagCreator.*;

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
		List<GCategory> researchfields = getCategoryList("research field");
		List<GCategory> materials = getCategoryList("material kind");
		
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

		_log.info("==========VALUES=========");
		_log.info("Physical: " + physical);
		_log.info("Taxon: " + taxon);
		_log.info("Alive: " + alive);
		_log.info("Sequenced: " + sequenced);

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		List<DataProvider> recommendedProviders = setRecommendedProviders(physical, taxon, alive, sequenced);
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
			recommendedProviders = setRecommendedProviders(physical, taxon, alive, sequenced);
		} else {
			recommendedProviders = setRecommendedProvidersWithCategory(physical, taxon, alive, sequenced, category);
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
									.attr("style",
											"padding-left: 1.5em;")
									.with(span().withId(label).withName("dataCenter").withText(name)),
							div().withClass("col-xs-12 col-sm-4 col-lg-3").attr("style", "text-align: center;")
									.with(button().withClass("dcrtbutton contact").withText("Contact")
											.withName("contactButton").withType("button").withValue(label),
											// button().withClass("dcrtbutton
											// submission").withText("Submission").withName("submissionButton")
											// .withType("button").attr("style",
											// "margin-left: 2px; margin-right:
											// 2px").withValue(label),
											button().withClass("dcrtbutton details").withText("Details")
													.withName("detailsButton").withType("button").withValue(label)
													.attr("style", "margin-left: 2px;")))
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
		Project project = new Project("SAND");
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
			// Get List of all possible Data Centers if GFBio default contact is
			// used
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

		String customfield_10010 = PropsUtil.get("jira.gfbio.requesttype");
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

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		writer.println("Submission: " + dataCenter);

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

	/*
	 * Set recommended datacenters in consideration of the radio input selection
	 * which was made
	 */
	private List<DataProvider> setRecommendedProviders(String physicalInput, String taxonInput, String aliveInput,
			String sequencedInput) {

		List<DataProvider> tempProviders = getDataProviders();
		List<DataProvider> recommendedProviders = new ArrayList<DataProvider>();
		for (DataProvider dp : tempProviders) {
			recommendedProviders.add(dp);
		}
		// List<DataProvider> allProviders = getDataProviders();
		boolean physical;
		boolean taxon;
		boolean alive;
		boolean sequenced;

		if (physicalInput != null) {
			physical = Boolean.valueOf(physicalInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (physical) {
					if (!p.getPhysicalobjectpossible()) {
						providersToDelete.add(p);
					}
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}

		if (taxonInput != null) {
			taxon = Boolean.valueOf(taxonInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (taxon) {
					if (p.getTaxonbased() != taxon) {
						providersToDelete.add(p);
					}
				} else {
					if (p.getNotaxonbased() == taxon) {
						providersToDelete.add(p);
					}
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}
		if (aliveInput != null) {
			alive = Boolean.valueOf(aliveInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (alive) {
					if (p.getLivingobjects() != alive) {
						providersToDelete.add(p);
					}
				} else {
					if (p.getDeadobjects() == alive) {
						providersToDelete.add(p);
					}
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}
		if (sequencedInput != null) {
			sequenced = Boolean.valueOf(sequencedInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (p.getSequencedata() != sequenced) {
					providersToDelete.add(p);
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}

		return recommendedProviders;
	}

	/*
	 * Set recommended datacenters in consideration of the radio input and
	 * category selection which was made
	 */
	private List<DataProvider> setRecommendedProvidersWithCategory(String physical, String taxon, String alive,
			String sequenced, String category) {

		JSONArray providerIdList = new JSONArray();

		try {
			providerIdList = ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(
					HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_dataprovider"), category);
		} catch (NoSuchHeadException | SystemException e) {
			e.printStackTrace();
		}
		// Results for Category
		List<DataProvider> providersForCategory = new ArrayList<>();

		for (int i = 0; i < providerIdList.size(); i++) {
			try {
				providersForCategory.add(DataProviderLocalServiceUtil.getDataProvider((long) providerIdList.get(i)));
			} catch (PortalException | SystemException e) {
				_log.error("Something went wrong in DataProviderLocalServiceUtil!", e);
			}
		}
		// Results For Radio-Button Inputs
		List<DataProvider> providersForRadioButtons = setRecommendedProviders(physical, taxon, alive, sequenced);

		List<DataProvider> temp = new ArrayList<>();

		for (DataProvider dp : providersForCategory) {
			if (!providersForRadioButtons.contains(dp)) {
				temp.add(dp);
			}
		}
		providersForCategory.removeAll(temp);
		Collections.sort(providersForCategory);
		return providersForCategory;
	}

	/* Get a list of all datacenters from db */
	public static List<DataProvider> getDataProviders() {
		List<DataProvider> providers = null;

		providers = DataProviderLocalServiceUtil.getDataProviderByProviderType("GFBio Archive");

		return providers;
	}

	/* Get a list of all categories from db regarding to their type */
	public static List<GCategory> getCategoryList(String type) {

		List<GCategory> categories = null;
		try {
			long relationTableHeadId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_type");
			long entitiyTableHeadId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_type");

			String entityTableCellContent = type;
			JSONArray json = ContentLocalServiceUtil.getRowInformationOfRelationshipsOfSpecificCellContent(
					relationTableHeadId, entitiyTableHeadId, entityTableCellContent);

			categories = transformJsonArrayToGCategory(json);
			categories = sortCategories(categories);

		} catch (NoSuchHeadException | SystemException ex) {
			_log.error("Error while getting HeadId by HeadLocalServiceUtil");
		}
		return categories;
	}

	/* Sort categories alphabetically */
	private static List<GCategory> sortCategories(List<GCategory> categories) {
		if (!categories.isEmpty()) {
			Collections.sort(categories, new Comparator<GCategory>() {
				@Override
				public int compare(final GCategory object1, final GCategory object2) {
					return object1.getName().compareTo(object2.getName());
				}
			});
		}
		for (GCategory category : categories) {
			if (category.getName().equalsIgnoreCase("other")) {
				categories.remove(category);
				categories.add(category);
				break;
			}
		}
		return categories;
	}

	/* Transform JSONArray to List of categories */
	public static List<GCategory> transformJsonArrayToGCategory(JSONArray categoryJson) {
		List<GCategory> categories = new ArrayList<GCategory>();

		if (categoryJson.size() > 0)
			for (int i = 0; i < categoryJson.size(); i++)
				categories.add(new GCategory((JSONObject) categoryJson.get(i)));

		return categories;
	}
}