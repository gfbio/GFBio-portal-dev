package org.gfbio.idmg.dcst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.NoSuchHeadException;
import org.gfbio.idmg.dcst.dao.GCategory;
import org.gfbio.idmg.dcst.dao.GContentDAO;
import org.gfbio.model.Column;
import org.gfbio.model.Content;
import org.gfbio.model.DataProvider;
import org.gfbio.model.Head;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.json.simple.JSONArray;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class dcst
 */
public class DCSTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DCSTPortlet.class);
	protected String viewTemplate;

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		if (resourceRequest.getResourceID().equals("radio")) {
			ajaxRadio(resourceRequest, resourceResponse);
		} else if (resourceRequest.getResourceID().equals("category")) {
			ajaxCategory(resourceRequest, resourceResponse);
		}

	}

	private void ajaxRadio(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String physical = resourceRequest.getParameter("physical");
		String taxon = resourceRequest.getParameter("taxon");
		String alive = resourceRequest.getParameter("alive");
		String sequenced = resourceRequest.getParameter("sequenced");

		// String data2 = ParamUtil.getString(resourceRequest, "physical");
		System.out.println("==========VALUES=========");
		System.out.println("Physical: " + physical);
		System.out.println("Taxon: " + taxon);
		System.out.println("Alive: " + alive);
		System.out.println("Sequenced: " + sequenced);

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();

		List<DataProvider> recommendedProviders = setRecommendedProviders(
				physical, taxon, alive, sequenced);
		System.out.println("============RECOMMENDED=DATAPROVIDERS============ ");
		if (recommendedProviders.isEmpty()) {
			writer.println("There are no providers available");
		} else {
			for (DataProvider p : recommendedProviders) {
				System.out.println(p.getName());
				writer.println(p.getName() + "</br>");
			}
		}

		writer.flush();
		writer.close();

		super.serveResource(resourceRequest, resourceResponse);
	}

	private void ajaxCategory(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String value = resourceRequest.getParameter("val");
		System.out.println("Value " + value);
		
		JSONArray providerIdList = new JSONArray();
		
		try {
			providerIdList = ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_dataprovider"), value);
		} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		
				
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		System.out.println("Ich war hier");
		
//		List<GCategory> categories = getCategoryList();
		
		if(providerIdList.isEmpty()) {
			writer.println("There are no categories available");
		} else {
			for (int i =0; i < providerIdList.size();i++) {
				String label = DataProviderLocalServiceUtil.getNameById((long) providerIdList.get(i));
				System.out.println(label);
				writer.println("<div style=\"display:block; margin-bottom: 10px;\">");
				//writer.println("<input name=\"" + c.getLabel().toLowerCase() + "\" style=\"margin-bottom: 7px\" type=\"radio\" value=\"true\" onClick=\"\" />");
				writer.println("<span id=\"" + label + "\" onclick=\"categoryalert('" + label + "');\" >" + label + "</span>");
				writer.println("</div>");
			}
		}
	}

	public List<DataProvider> setRecommendedProviders(String physicalSt,
			String taxonSt, String aliveSt, String sequencedSt) {

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

		if (physicalSt != null) {
			physical = Boolean.valueOf(physicalSt);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (p.getPhysicalobjects() != physical) {
					providersToDelete.add(p);
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}

		if (taxonSt != null) {
			taxon = Boolean.valueOf(taxonSt);
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
		if (aliveSt != null) {
			alive = Boolean.valueOf(aliveSt);
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
		if (sequencedSt != null) {
			sequenced = Boolean.valueOf(sequencedSt);
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

	public static String ajaxProviders(ResourceRequest req, ResourceResponse res) {
		return "Hello Ajax";
	}

	/*
	 * Adds a sample project to DB
	 */
	public static void sampleProject(ActionRequest req, ActionResponse res) {

		getCategoryDataproviderContent();

	}

	public static List<DataProvider> getDataProviders() {
		List<DataProvider> providers = null;
		try {
			providers = DataProviderLocalServiceUtil.getDataProviders(0,
					DataProviderLocalServiceUtil.getDataProvidersCount());
		} catch (SystemException e) {
			_log.error("Bad boys bad boys what you gonna do? -> SystemException");
		}
		return providers;
	}
	
	public static GContentDAO getCategoryContent() {

		GContentDAO categories = getContent(1);

		_log.error(categories.getColumnNames().toString());
		_log.error(categories.getContents().toString());

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

		_log.error(types.getColumnNames().toString());
		_log.error(types.getContents().toString());
	}

	public static void getCategoryTypeContent() {

		GContentDAO categoryDataprovider = getContent(6);

		_log.error(categoryDataprovider.getColumnNames().toString());
		_log.error(categoryDataprovider.getContents().toString());
	}

	public static void getCategoryDataproviderContent() {

		GContentDAO categoryDataprovider = getContent(7);

		_log.error(categoryDataprovider.getColumnNames().toString());
		_log.error(categoryDataprovider.getContents().toString());
	}

//	public static GContentDAO getCategoryResearchField() {
//
//		GContentDAO categoryResearchField = getContent(4);
//
//		_log.error(categoryResearchField.getColumnNames().toString());
//		_log.error(categoryResearchField.getContents().toString());
//
//		return categoryResearchField;
//	}

//	public static List<GCategoryResearchField> getCategoryResearchFieldList() {
//		GContentDAO content = getCategoryResearchField();
//		List<GCategoryResearchField> list = new ArrayList<GCategoryResearchField>();
//		GCategoryResearchField categoryResearchField;
//
//		for (HashMap<Long, String> map : content.getContents()) {
//			categoryResearchField = new GCategoryResearchField();
//			for (Long key : map.keySet()) {
//				if (key == 10) {
//					Long id = Long.parseLong(map.get(key));
//					categoryResearchField.setCategoryId(id);
//					;
//				}
//				if (key == 11) {
//					Long id = Long.parseLong(map.get(key));
//					categoryResearchField.setResearchFieldId(id);
//				}
//			}
//			list.add(categoryResearchField);
//		}
//		for (GCategoryResearchField g : list) {
//			_log.error(g.toString());
//		}
//		return list;
//	}

	private static GContentDAO getContent(long headId) {

		@SuppressWarnings("unchecked")
		List<Object> fields = HeadLocalServiceUtil.getEntitiesByHeadId(headId);
		_log.error("Size: " + fields.size());

		GContentDAO entityContent = new GContentDAO();
		List<Long> columnIds = new ArrayList<Long>();
		List<HashMap<Long, String>> contents = new ArrayList<HashMap<Long, String>>();
		List<HashMap<Long, String>> columnNames = new ArrayList<HashMap<Long, String>>();

		HashMap<Long, String> columnIdAndContentMap = new HashMap<Long, String>();
		long firstcolumnid = 0;
		boolean firstLoopSkip = false;

		for (Object field : fields) {
			// String head = "";
			// String column = "";
			// String content = "";

			for (Object o : (Object[]) field) {
				if (o instanceof Head) {
					// head = ((Head)o).toString();
				} else if (o instanceof Column) {
					// column = ((Column)o).toString();
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
					// content = ((Content)o).toString();

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
					_log.error("Object o is not instance of head, column or content!");
				}
			}
			// _log.error("Head: " + head + " | Column: " + column +
			// " | Content: " + content);
			// contents.add(columnIdAndContentMap);
		}

		entityContent.setContents(contents);
		entityContent.setColumnNames(columnNames);

		return entityContent;
	}
}