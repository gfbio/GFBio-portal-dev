package org.gfbio.idmg.dcrt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.NoSuchHeadException;
import org.gfbio.idmg.dcrt.dao.GCategory;
import org.gfbio.idmg.dcrt.dao.GContentDAO;
import org.gfbio.idmg.dcrt.dao.GMaterial;
import org.gfbio.model.Column;
import org.gfbio.model.Content;
import org.gfbio.model.DataProvider;
import org.gfbio.model.Head;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.json.simple.JSONArray;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import static j2html.TagCreator.*;

/**
 * Portlet implementation class dcrt
 */
public class DCRTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DCRTPortlet.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		if (resourceRequest.getResourceID().equals("radio")) {
			ajaxRadio(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("category")) {
			ajaxCategory(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("material")) {
			ajaxMaterial(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("contact")) {
			ajaxContactButton(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("submission")) {
			ajaxSubmissionButton(resourceRequest, resourceResponse);
		}
	}

	//Method for ajax functionality of Radio Buttons
	private void ajaxRadio(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
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

		List<DataProvider> recommendedProviders = setRecommendedProviders(
				physical, taxon, alive, sequenced);
		_log.info("============RECOMMENDED=DATAPROVIDERS============ ");
		if (recommendedProviders.isEmpty()) {
			writer.println("There are no providers available");
		} else {
			dataproviderOutput(writer, recommendedProviders);
		}

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

	//Method for ajax functionality of Category DropDown
	private void ajaxCategory(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		//Category-DropDown Selection
		String category = resourceRequest.getParameter("category");
		_log.info("Category " + category);
		//Radio-Inputs
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");
		
		List <DataProvider> recommendedProviders;
		if (category.equals("noselection")) {
			recommendedProviders = setRecommendedProviders(physical, taxon, alive, sequenced);
		} else {
			recommendedProviders = setRecommendedProvidersWithCategory(physical, taxon, alive, sequenced, category);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		if(recommendedProviders.isEmpty()) {
			writer.println("There are no data providers available");
		} else {
			dataproviderOutput(writer, recommendedProviders);
		}
		
		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	//Method for ajax functionality of Material DropDown
	private void ajaxMaterial(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException { 
		//Material-DropDown Selection
		String material = resourceRequest.getParameter("material");
		_log.info("Material " + material);
		//Radio-Inputs
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");
		
		List <DataProvider> recommendedProviders;
		if (material.equals("noselection")) {
			recommendedProviders = setRecommendedProviders(physical, taxon, alive, sequenced);
		} else {
			recommendedProviders = setRecommendedProvidersForMaterial(material);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		if(recommendedProviders.isEmpty()) {
			writer.println("There are no data providers available");
		} else {
			dataproviderOutput(writer, recommendedProviders);
		}
		
		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void dataproviderOutput(PrintWriter writer, List<DataProvider> providers) {
		
		//ContainerTag htmlTable = new ContainerTag("tr");
		writer.println("<table style=\"width: 100%;\">");
		
		for (DataProvider dp : providers) {
		String name = dp.getName();
		String label = dp.getLabel().trim();
		_log.info(name);
		
		writer.print(
			tr().withClass("dcrttr").with(
				th().attr("style", "width: 20%; padding-right: 5px;").with(
					img().withSrc("/GFBioProject-portlet/images/" + label + ".jpg").attr("style", "width: 60px;")
				),
				th().attr("style", "width: 40%").with(
					span().withId(name).withText(name)
				),
				th().attr("style", "width: 12%").with(
					button().withClass("dcrtbutton contact").withText("Contact").withName("contactButton").withType("button").withValue(label)
				),
				th().attr("style", "width: 16%").with(
					button().withClass("dcrtbutton submission").withText("Submission").withName("submissionButton").withType("button").withValue(label)
				),
				th().attr("style", "width: 12%").with(
						button().withClass("dcrtbutton details").withText("Details").withName("detailsButton").withType("button").withValue(label)
				)
			).render()
		);
		}
		
		writer.println("</table>");
		
//		Old way for generating HTML output
//		writer.println("<div style=\"display:block; margin-bottom: 10px;\">");
//		writer.println("<img src=\"/GFBioProject-portlet/images/" + label + ".jpg\" alt=\"" + label + "\" style=\"width:60px;height:46px;\">");
//		writer.println("<span id=\"" + name + "\" >" + name + "</span>");
//		writer.println("<button class=\"dcrtbutton contact\">Test</button>");
//		writer.println("<button class=\"dcrtbutton submission\">Test</button>");
//		writer.println("</div>");
	}
	
	//Method for Contact Button
	private void ajaxContactButton(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		_log.info("Contact Button Method reached!");
		
		//Get Button Value
		String value = resourceRequest.getParameter("value");
		String text = resourceRequest.getParameter("text");
		
		_log.info("Value: " + value + ", Text: " + text);

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		writer.println("Hello contact: " + value + ", " + text);
		
		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	//Method for Submission Button
	private void ajaxSubmissionButton(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		_log.info("Submission Button Method reached!");
		
		//Get Button Value
		String value = resourceRequest.getParameter("value");
		String text = resourceRequest.getParameter("text");
		
		_log.info("Value: " + value + ", Text: " + text);
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		
		writer.println("Hello submission: " + value + ", " + text);
		
		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private List<DataProvider> setRecommendedProviders(String physicalInput,
			String taxonInput, String aliveInput, String sequencedInput) {

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
					if (!p.getPhysicalobjects()) {
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
	
	private List<DataProvider> setRecommendedProvidersWithCategory(String physical,
			String taxon, String alive, String sequenced, String category) {
		
		JSONArray providerIdList = new JSONArray();
		
		try {
			providerIdList = ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_dataprovider"), category);
		} catch (NoSuchHeadException | SystemException e) {
			e.printStackTrace();
		}
		//Results for Category
		List<DataProvider> providersForCategory = new ArrayList<>();
		
		for (int i = 0; i < providerIdList.size(); i++) {
			try {
				providersForCategory.add(DataProviderLocalServiceUtil.getDataProvider((long) providerIdList.get(i)));
			} catch (PortalException | SystemException e) {
				_log.error("Something went wrong in DataProviderLocalServiceUtil!", e);
			}
		}
		//Results For Radio-Button Inputs
		List<DataProvider> providersForRadioButtons = setRecommendedProviders(
				physical, taxon, alive, sequenced);
		
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

	public static List<GMaterial> getMaterials() {
		
		List<GMaterial> enumValues = Arrays.asList(GMaterial.values());
		return enumValues;
	}
	
	private List<DataProvider> setRecommendedProvidersForMaterial(String material) {
		List<DataProvider> allProviders = getDataProviders();
		List<DataProvider> recommendedProviders = new ArrayList<>();
		
		if (material.equals(GMaterial.BOTANICAL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isBotanicalObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.BOTANICAL_DNA.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isBotanicalDnaSamples()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.BOTANICAL_ETHANOL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isBotanicalObjectsInEthanol()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.BOTANICAL_MICROSCOPIC.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isBotanicalMicroscopicSlides()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.BOTANICAL_TISSUE.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isBotanicalTissueObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.MYCOLOGICAL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isMycologicalObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.MYCOLOGICAL_DNA.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isMycologicalDnaSamples()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.MYCOLOGICAL_ETHANOL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isMycologicalObjectsInEthanol()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.MYCOLOGICAL_MICROSCOPIC.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isMycologicalMicroscopicSlides()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.MYCOLOGICAL_TISSUE.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isMycologicalTissueObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.PALEONTOLOGICAL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isPaleontologicalObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.ZOOLOGICAL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isZoologicalObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.ZOOLOGICAL_DNA.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isZoologicalDnaSamples()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.ZOOLOGICAL_ETHANOL.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isZoologicalObjectsInEthanol()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.ZOOLOGICAL_MICROSCOPIC.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isZoologicalMicroscopicSlides()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.ZOOLOGICAL_TISSUE.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isZoologicalTissueObjects()) {
					recommendedProviders.add(d);
				}
			}
		} else if (material.equals(GMaterial.OTHER_OBJECTS.toString())) {
			for (DataProvider d : allProviders) {
				if (d.isOtherObjects()) {
					recommendedProviders.add(d);
				}
			}
		}
		
		return recommendedProviders;
	}

	//private void 
	
	public static List<DataProvider> getDataProviders() {
		List<DataProvider> providers = null;
		try {
			providers = DataProviderLocalServiceUtil.getDataProviders(0,
					DataProviderLocalServiceUtil.getDataProvidersCount());
		} catch (SystemException e) {
			_log.error("Something went wrong in DataProviderLocalServiceUtil!", e);
		}
		return providers;
	}
	
	public static GContentDAO getCategoryContent() {

		GContentDAO categories = getContent(1);

		_log.info(categories.getColumnNames().toString());
		_log.info(categories.getContents().toString());

		return categories;
	}

	public static List<GCategory> getCategoryList() {
		GContentDAO content = getCategoryContent();
		List<GCategory> categories = new ArrayList<GCategory>();

		GCategory category;
		for (HashMap<Long, String> map : content.getContents()) {
			category = new GCategory();
			for (Long key : map.keySet()) {
				if (key == 1) {
					Long id = Long.parseLong(map.get(key));
					category.setId(id);
				}
				if (key == 2) {
					category.setName(map.get(key));
				}
				if (key == 3) {
					category.setLabel(map.get(key));
				}
			}
			categories.add(category);
		}
		return categories;
	}

	public static void getTypeContent() {

		GContentDAO types = getContent(5);

		_log.info(types.getColumnNames().toString());
		_log.info(types.getContents().toString());
	}

	public static void getCategoryTypeContent() {

		GContentDAO categoryDataprovider = getContent(6);

		_log.info(categoryDataprovider.getColumnNames().toString());
		_log.info(categoryDataprovider.getContents().toString());
	}

	public static void getCategoryDataproviderContent() {

		GContentDAO categoryDataprovider = getContent(7);

		_log.info(categoryDataprovider.getColumnNames().toString());
		_log.info(categoryDataprovider.getContents().toString());
	}

	private static GContentDAO getContent(long headId) {

		@SuppressWarnings("unchecked")
		List<Object> fields = HeadLocalServiceUtil.getEntitiesByHeadId(headId);
		_log.info("Size: " + fields.size());

		GContentDAO entityContent = new GContentDAO();
		List<Long> columnIds = new ArrayList<Long>();
		List<HashMap<Long, String>> contents = new ArrayList<HashMap<Long, String>>();
		List<HashMap<Long, String>> columnNames = new ArrayList<HashMap<Long, String>>();

		HashMap<Long, String> columnIdAndContentMap = new HashMap<Long, String>();
		long firstcolumnid = 0;
		boolean firstLoopSkip = false;

		for (Object field : fields) {
			for (Object o : (Object[]) field) {
				if (o instanceof Column) {
					long id = ((Column) o).getColumnID();

					if (firstcolumnid == 0) {
						firstcolumnid = id;
					}

					if (!columnIds.contains(id)) {
						columnIds.add(id);
						HashMap<Long, String> columnIdAndColumnNamesMap = new HashMap<Long, String>();
						columnIdAndColumnNamesMap.put(id,
								((Column) o).getColumn_name());
						columnNames.add(columnIdAndColumnNamesMap);
					}
				} else if (o instanceof Content) {
					if (((Content) o).getColumnID() == firstcolumnid
							&& firstLoopSkip) {
						contents.add(columnIdAndContentMap);
						columnIdAndContentMap = new HashMap<Long, String>();
					}
					firstLoopSkip = true;

					if (((Content) o).getHeadID() == headId) {

						columnIdAndContentMap.put(((Content) o).getColumnID(),
								((Content) o).getCellContent());
					}
				} else {
					if (!(o instanceof Head)) {
						_log.error("Object o is not instance of head, column or content!");
					}
				}
			}
		}

		entityContent.setContents(contents);
		entityContent.setColumnNames(columnNames);

		return entityContent;
	}
}