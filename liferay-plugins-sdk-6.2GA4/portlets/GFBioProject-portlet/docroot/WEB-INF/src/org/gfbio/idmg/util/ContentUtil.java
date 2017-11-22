package org.gfbio.idmg.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.idmg.dto.GCategory;
import org.gfbio.idmg.dto.GFunding;
import org.gfbio.idmg.dto.GLegalRequirement;
import org.gfbio.idmg.dto.GLicense;
import org.gfbio.idmg.dto.GMetadata;
import org.gfbio.idmg.dto.GPolicy;
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
	public static List<GCategory> getCategoryListByType(String type) {

		List<GCategory> categories = null;
		try {
			long relationTableHeadId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_type");
			long entitiyTableHeadId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_type");

			JSONArray json = ContentLocalServiceUtil.getRowInformationOfRelationshipsOfSpecificCellContent(
					relationTableHeadId, entitiyTableHeadId, type);
			
			categories = transformJsonArrayToGCategory(json);
			categories = sortListAlphabetically(categories);
			
			for (GCategory c : categories) {
				_log.info(c.toString());
			}

		} catch (NoSuchHeadException | SystemException ex) {
			_log.error("Error while getting HeadId by HeadLocalServiceUtil");
		}
		return categories;
	}

	/* Transform JSONArray to List of categories */
	private static List<GCategory> transformJsonArrayToGCategory(JSONArray categoryJson) {
		List<GCategory> categories = new ArrayList<GCategory>();

		if (categoryJson.size() > 0)
			for (int i = 0; i < categoryJson.size(); i++)
				categories.add(new GCategory((JSONObject) categoryJson.get(i)));

		return categories;
	}
	
	public static <T extends Comparable<T>> List<T> getListByTableName (Class<T> cl, String tableName) {
		
		List<T> list = new ArrayList<T>();
		try {
			long entitiyTableHeadId = HeadLocalServiceUtil.getHeadIdByTableName(tableName);
			
			@SuppressWarnings("unchecked")
			List<Long> rowIds = ContentLocalServiceUtil.getRowIds(entitiyTableHeadId);
			
			for (long i : rowIds) {
				JSONObject json = ContentLocalServiceUtil.getRowInformationById(i);
				T inst = cl.newInstance();
				
				if(inst instanceof GMetadata)
		        {
					GMetadata md = new GMetadata(json);
					if (md.isPreferredByGfbio()) list.add(cl.cast(md));
					
		        }
		        else if(inst instanceof GLicense)
		        {
		        	GLicense license = new GLicense(json);
		        	if (license.isPreferredByGfbio()) list.add(cl.cast(license));
		        }
		        else if(inst instanceof GFunding)
		        {
		        	GFunding funding = new GFunding(json);
		        	list.add(cl.cast(funding));
		        }
		        else if(inst instanceof GLegalRequirement)
		        {
		        	GLegalRequirement requirement = new GLegalRequirement(json);
		        	list.add(cl.cast(requirement));
		        }
		        else if(inst instanceof GPolicy)
		        {
		        	GPolicy policy = new GPolicy(json);
		        	list.add(cl.cast(policy));
		        }
				
			}
			
			list = sortListAlphabetically(list);

			for(T e : list) {
				_log.info(e.toString());
			}
			
		} catch(NoSuchHeadException | SystemException ex) {
			_log.error("Error while getting HeadId by HeadLocalServiceUtil");
		} catch (InstantiationException e) {
			_log.error("Error while instatiating object");
		} catch (IllegalAccessException e) {
			_log.error("Error while accessing list object");
		}
		
		return list;
	}
	
	private static <T extends Comparable<T>> List<T> sortListAlphabetically(List<T> list) {
		if (!list.isEmpty()) {
			Collections.sort(list);
		}
		return list;
	}
	
}
