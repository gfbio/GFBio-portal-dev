package org.gfbio.idmg.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.idmg.dao.GCategory;
import org.gfbio.idmg.dao.GContentDAO;
import org.gfbio.idmg.dao.GMetadata;
import org.gfbio.model.Column;
import org.gfbio.model.Content;
import org.gfbio.model.Head;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ContentUtil {

	private static Log _log = LogFactoryUtil.getLog(ContentUtil.class);
	
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
	
	
	public static List<GMetadata> getMetadataList() {
		
		List<GMetadata> metadata = new ArrayList<>();
		try {
			long entitiyTableHeadId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_metadata");
			
			@SuppressWarnings("unchecked")
			List<Long> rowIds = ContentLocalServiceUtil.getRowIds(entitiyTableHeadId);
			
			for (long i : rowIds) {
				JSONObject json = ContentLocalServiceUtil.getContentsAsJSONByRowId(i);
				JSONObject json2 = ContentLocalServiceUtil.getRowInformationById(i);
				
			}
			
			//JSONArray json = ContentLocalServiceUtil... JSON would be nice
		} catch(NoSuchHeadException | SystemException ex) {
			_log.error("Error while getting HeadId by HeadLocalServiceUtil");
		}
		return metadata;
	}
	
	private static GContentDAO getContent(long headId) {

		@SuppressWarnings("unchecked")
		List<Object> fields = HeadLocalServiceUtil.getEntitiesByHeadId(headId);
		//_log.info("Size: " + fields.size());

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
