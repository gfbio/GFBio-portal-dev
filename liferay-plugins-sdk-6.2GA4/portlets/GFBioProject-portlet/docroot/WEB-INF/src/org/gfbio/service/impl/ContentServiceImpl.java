/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.gfbio.service.impl;


import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.base.ContentServiceBaseImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



/**
 * The implementation of the content remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ContentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ContentServiceBaseImpl
 * @see org.gfbio.service.ContentServiceUtil
 */
public class ContentServiceImpl extends ContentServiceBaseImpl {

	
	//
	public  String getContentIdsWithRelationships(long rowId, String tableName1, String tableName2){
		return ContentLocalServiceUtil.getContentIdsWithRelationships(rowId, tableName1, tableName2).toString();
	}
	
	
	//get List of content IDs, with content of relationship tables between a HCC and a normal table
	public  String getContentIdsWithNormalTableRelationships(long rowId, String tableName, String columnName1, String columnName2) {
		String response =  ContentLocalServiceUtil.getContentIdsWithNormalTableRelationships(rowId, tableName, columnName1, columnName2).toString();
		return response.substring(1, response.length()-1);
	}
	
	
	//get a row as JSON
	public JSONObject  getRowInformationByContentId (long contentId){
		return ContentLocalServiceUtil.getRowInformationByContentId(contentId);
	}
	
	
	//
	public JSONArray  getRowInformationOfRelationByContentId (long contentId, String tableName1, String tableName2){
		return  ContentLocalServiceUtil.getRowInformationOfRelationByContentId (contentId, tableName1,  tableName2);
	}
	
	
	//
	public JSONArray  getRowInformationsOfRelationshipsOfSpecificCellContent (JSONObject requestJson){
		return  ContentLocalServiceUtil.getRowInformationsOfRelationshipsOfSpecificCellContent (requestJson);
	}
	
}