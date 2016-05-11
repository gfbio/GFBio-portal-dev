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

import java.util.ArrayList;
import java.util.List;

import org.gfbio.NoSuchContentException;
import org.gfbio.NoSuchHeadException;
import org.gfbio.model.Column;
import org.gfbio.model.Content;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.base.ContentLocalServiceBaseImpl;
import org.gfbio.service.persistence.ContentFinderUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ContentLocalServiceBaseImpl
 * @see org.gfbio.service.ContentLocalServiceUtil
 */
public class ContentLocalServiceImpl extends ContentLocalServiceBaseImpl {

	
	///////////////////////////////////// Delete Functions ///////////////////////////////////////////////////
	
	
	//delete contents of a specific column
	public void deleteContentsByColumnId (long columnId){
		
		List <Content> contentList = null;
		try {contentList = contentPersistence.findByColumnId(columnId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null)
			for (int i =0; i < contentList.size();i++)
				try {ContentLocalServiceUtil.deleteContent(contentList.get(i).getContentID());
				} catch (PortalException | SystemException e) {e.printStackTrace();}
	}
	
	
	//delete cells/relations of contents
	public void deleteContentsByHeadId(long headId) throws SystemException{
		List <Content> contentList = contentPersistence.findByHeadId(headId);
		for (int i =0; i<contentList.size();i++)
			try {ContentLocalServiceUtil.deleteContent(contentList.get(i).getContentID());
			} catch (PortalException e) {e.printStackTrace();}
	}
	
	
	//delete contents of a specific row
	public void deleteContentsByRowId (long rowId){
		
		List <Content> contentList = null;
		try {contentList = contentPersistence.findByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null)
			for (int i =0; i < contentList.size();i++)
				try {ContentLocalServiceUtil.deleteContent(contentList.get(i).getContentID());
				} catch (PortalException | SystemException e) {e.printStackTrace();}
	}
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//get Content of  a specific cell in HCC
	@SuppressWarnings("rawtypes")
	public List getCellContentByContentId(long contentId) {
		return ContentFinderUtil.getCellContentByContentId(contentId);
	}
	
	
	//get Content of  a specific cell in HCC
	@SuppressWarnings("rawtypes")
	public String getCellContentByRowIdAndColumnName(long rowId, String columnName) {
		String cellContent ="";
		List cellContentList = ContentFinderUtil.getCellContentByRowIdAndColumnName(rowId, columnName);
		if (cellContentList.size() > 0)
			cellContent = (String) cellContentList.get(0);
		 
		 return cellContent;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getOppositeCellContentsOfRelationsByCellContent(long headId, String cellContent){
		List <String> responseList = ContentFinderUtil.getOppositeCellContentsOfRelationsByCellContent(headId, cellContent);
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {parseJson = (JSONArray) parser.parse(responseList.toString());}
		catch (ParseException e) {e.printStackTrace();}

		return parseJson;
		
	}
	
	
	// get the columnId of a specific content.
	public long getColumnIdById(long contentId) throws SystemException, PortalException{
		return (long) ContentFinderUtil.getColumnIdById(contentId).get(0);
	}
	

	//get Content of  a specific row and column
	public Content getContentByTableIds(long rowId, long columnId) throws NoSuchContentException, SystemException  {
		return contentPersistence.findByTableIds(columnId, rowId);
	}
	
	
	//get ID of a Cell in a specific row and column
	public long getContentIdByTableIds(long rowId, long columnId) throws NoSuchContentException, SystemException  {
		long id =0;
		Content content = contentPersistence.findByTableIds(columnId, rowId);
		if (content != null)
			id = content.getContentID();
		else
			id=0;
		return id;
	}

	
	//get all contentId where the entry have the same rowId
	@SuppressWarnings("rawtypes")
	public List getContentIdsByRowId (long rowId){
		return ContentFinderUtil.getContentIdsByRowId(rowId);
	}
	
	
	//get List of content IDs, without content of relationship tables
	@SuppressWarnings("rawtypes")
	public List getContentIdsWithoutRelationships (long rowId, String tableName1, String tableName2){
		return ContentFinderUtil.getContentIdsWithoutRelationships(rowId, tableName1, tableName2);
	}
	
	
	//get List of content IDs, with content of relationship tables
	@SuppressWarnings("rawtypes")
	public  List getContentIdsWithRelationships(long rowId, String tableName1, String tableName2) {
		return ContentFinderUtil.getContentIdsWithRelationships(rowId, tableName1, tableName2);
	}
	
	
	//get List of content IDs, with content of relationship tables between a HCC and a normal table
	@SuppressWarnings("rawtypes")
	public  List getContentIdsWithNormalTableRelationships(long rowId, String tableName, String columnName1, String columnName2) {
		return ContentFinderUtil.getContentIdsWithNormalTableRelationships(rowId, tableName, columnName1, columnName2);
	}
	

	//get a Content Entry as JSON
	public JSONObject getContentInformationAsJSONByContentId (long contentId){
		
		JSONObject json = new JSONObject();
		Content content = null;
		try {content = contentPersistence.findByContentId(contentId);
		} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
		if (content != null)
			json = constructContentJson(content.getContentID(), content.getHeadID(), content.getColumnID(), content.getRowID(), content.getCellContent());
		return json;
	}
	
	
	//get the basic Information of the Contents of a specific row as JSON
	@SuppressWarnings("unchecked")
	public JSONObject getContentInformationAsJSONByRowId (long rowId){
	
		JSONObject json = new JSONObject();
		List <Content> contentList = null;
		try {
			contentList = contentPersistence.findByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		if (contentList != null)
			for(int i =0;i<contentList.size();i++)
				json.put(Long.toString(contentList.get(i).getColumnID()), Long.toString(contentList.get(i).getContentID()));

		return json;
	}
	
	
	//get the basic Information of the Contents of a specific row as JSON
	@SuppressWarnings("unchecked")
	public JSONObject getContentsAsJSONByRowId (long rowId){
	
		JSONObject json = new JSONObject();
		List <Content> contentList = null;
		
		try {
			contentList = contentPersistence.findByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null)
			for(int i =0;i<contentList.size();i++){
				JSONObject subJson = new JSONObject();
				subJson.put("headId", Long.toString(contentList.get(i).getHeadID()));
				subJson.put("columnId", Long.toString(contentList.get(i).getColumnID()));
				subJson.put("rowId", Long.toString(contentList.get(i).getRowID()));
				subJson.put("cellcontent", contentList.get(i).getCellContent());
				json.put(Long.toString(contentList.get(i).getContentID()), subJson);
			}
		return json;
	}
	
	
	//get the count of columns from a specific row
	public int getCountOfColumns(long rowId) throws SystemException{
		return contentPersistence.findByRowId(rowId).size();
	}	
	
	
	//get the count of rows from a specific column 
	@SuppressWarnings("rawtypes")
	public int getCountOfRows(long headId) throws SystemException{
		int count =0;
		List list = ContentLocalServiceUtil.getRowIds(headId);
		if (list != null)
			count = list.size();
		else
			count = 0;
		return count;
	}
	
	
	//get the first element of a list of contentId to a specific rowId
	@SuppressWarnings("rawtypes")
	public long getFirstContentIdByRowId (long rowId){
		long contentId =0;
		List contentIdList = (List) ContentFinderUtil.getContentIdsByRowId(rowId);
		if (contentIdList.size() >0)
			contentId = (long) contentIdList.get(0);
		return contentId;
	}

	
	//get the headId to a content entry
	@SuppressWarnings("rawtypes")
	public long getHeadIdById(long contentId){
		long headId =0;
		List headIdList = (List) ContentFinderUtil.getHeadIdById(contentId);
		if (headIdList.size() >0)
			headId = (long) headIdList.get(0);
		return headId;
	}
	

	//get the rowId of HCC table row by table id (headId), name of the column (columnName) and a specific Content of a cell - but its only unique with knowledge about the HCC table 
	@SuppressWarnings("rawtypes")
	public long getRowIdByCellContent(long headId, String columnName, String cellContent){
		long rowId =0;
		List rowIdList = (List)  ContentFinderUtil.getRowIdByCellContent(headId, columnName, cellContent);
		if (rowIdList.size() >0)
			rowId = (long) rowIdList.get(0);
		return rowId;
	}
	
	
	//get the rowId of HCC table row by table id (headId), name of the column (columnName) and a specific Content of a cell - but its only unique with knowledge about the HCC table 
	public long getRowIdByCellContent(String tableName, String columnName, String cellContent){
		long rowId =0;
		long headId =0;
		try {headId = HeadLocalServiceUtil.getHeadIdByTableName(tableName);
		} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		
		if(headId !=0){
			rowId = getRowIdByCellContent(headId, columnName, cellContent);
		}
		return rowId;
	}
	

	// get the columnId of a specific content.
	@SuppressWarnings("rawtypes")
	public long getRowIdById(long contentId) {
		long rowId =0;
		List rowIdList = ContentFinderUtil.getRowIdByContentId(contentId);
		if (rowIdList.size() >0)
			rowId = (long) rowIdList.get(0);
		return rowId;
	}
		
	
	//get a List of rowIds of specific head
	@SuppressWarnings("rawtypes")
	public long  getRowIdOfRelation (String cellContent1, String cellContent2){
		long rowId =0;
		List rowIdList = (List)  ContentFinderUtil.getRowIdOfRelation(cellContent1, cellContent2);
		if (rowIdList.size() >0)
			rowId = (long) rowIdList.get(0);
		return rowId;
	}
	
	
	//get a List of rowIds of specific head
	@SuppressWarnings("rawtypes")
	public List  getRowIds (long headId){
		return ContentFinderUtil.getRowIds(headId);
	}
	
	
	//get a List of rowIds of specific head
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONObject  getRowInformationByContentId (long contentId){

		 JSONObject responseJson = new JSONObject();
		 List response =  (ArrayList) ContentFinderUtil.getRowInformationByContentId (contentId);
		 for(Object object:response){
			 Object[] arrayobject=(Object[])object;
			 responseJson.put((String)arrayobject[0], (String)arrayobject[1]);
		 }
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	public JSONArray  getRowInformationOfRelationByContentId (long contentId, String tableName1, String tableName2){
		JSONArray responseArray = new JSONArray();
		JSONObject contentJson = new JSONObject();
		JSONObject  otherContentJson = new JSONObject();
		contentJson = getRowInformationByContentId (contentId);
		long rowId = getRowIdById(contentId);
		long  otherContentId = (long) ContentFinderUtil.getContentIdsWithRelationships(rowId, tableName1, tableName2).get(0);
		otherContentJson  = getRowInformationByContentId (otherContentId);
		responseArray.add(contentJson);
		responseArray.add(otherContentJson);

		return responseArray;
	}
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//Is  pk in table with table name, the Boolean is true
	public Boolean checkExistenceOfKeyId(String tableName, long pk) {
		return checkExistenceOfKeyId(tableName, Long.toString(pk));
	}
	
	
	//Is  pk in table with table name, the Boolean is true
	public Boolean checkExistenceOfKeyId(String tableName, String pk) {
		Boolean check = false;
		long headid =0;
		try {headid = HeadLocalServiceUtil.getHeadIdByTableName(tableName);} 
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		if (headid !=0)
			check =(Boolean) ContentFinderUtil.checkExistenceOfKeyId(headid, pk).get(0); 
		return check;
	}

	
	//Is  pk in table with headid, the Boolean is true
	public Boolean checkExistenceOfKeyId(long headId, String pk) {
		return (Boolean) ContentFinderUtil.checkExistenceOfKeyId(headId, pk).get(0);
	}
	
	
	//Are pk1 and pk2 in table with headid, the Boolean is false, because the function will is useing in relationship table update
	public Boolean checkKeyPairInRelationship(long headId, String pk1, String pk2) {
		return (Boolean) ContentFinderUtil.checkKeyPairInRelationship (headId, pk1, pk2).get(0);
	}
	
	//build a content entry to a JSON
	@SuppressWarnings("unchecked")
	public JSONObject constructContentJson(long contentId, long headId, long columnId, long rowId, String cellContent){
		JSONObject json = new JSONObject();
		json.put("contentid", contentId);
		json.put("headid", headId);
		json.put("columnid", columnId);
		json.put("rowid", rowId);
		json.put("cellcontent", cellContent);
		return json;
	}
	
	
	//create a ID in content context
	public long constructNewId() throws SystemException{
		return contentPersistence.create(CounterLocalServiceUtil.increment(getModelClassName())).getContentID();
	}

		
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//update or build a new the content
	public Boolean updateContent (long contentId, long headId, long columnId, long rowId, String cellContent){

		Boolean check = false;
		Content content = null;

		try {
			content = getContent(contentId);
		} catch (PortalException | SystemException e) {System.out.println("No Content exists with the primary key "+contentId);}

		// if it true, then must be build a new content with a new primary key else update the content
		if (content == null)
			try {
				content = contentPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				Column column = null;
				try {
					column = ColumnLocalServiceUtil.getColumn(columnId);
				} catch (PortalException e) {e.printStackTrace();}
				if (column != null)
					if (ColumnLocalServiceUtil.getColumnNameById(columnId).equals("id"))
						cellContent = Long.toString(content.getContentID());
			} catch (SystemException e) {e.printStackTrace();}

		if (rowId==0)
			try {
				rowId= constructNewId();
			} catch (SystemException e) {e.printStackTrace();}

		content.setHeadID(headId);
		content.setColumnID(columnId);
		content.setRowID(rowId);
		content.setCellContent(cellContent);
		try {
			super.updateContent(content);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		return check;
	}

	
	//update or build a new the content with a json as input
	public Boolean updateContent (JSONObject json){

		Boolean check = false;
		String contentIdKey ="contentid";
		String headKey ="headid";
		String columnKey ="columnid";
		String rowKey = "rowid";
		String contentKey = "cellcontent";
		long contentId = Long.valueOf((String) json.get(contentIdKey)).longValue();
		long headId = Long.valueOf((String) json.get(headKey)).longValue();
		long columnId = Long.valueOf((String) json.get(columnKey)).longValue();
		long rowId = Long.valueOf((String) json.get(rowKey)).longValue();
		String cellcontent = (String) json.get(contentKey);
		if (json.containsKey(contentKey) && json.containsKey(headKey) && json.containsKey(columnKey) && json.containsKey(rowKey) && json.containsKey(contentKey))
			check = updateContent(contentId, headId, columnId, rowId, cellcontent);
		return check;
	}
	
	
	//update or build a new the content with a json as input
	public Boolean updateContent2 (JSONObject json){
		
		Boolean check = false;
		String contentIdKey ="contentid";
		String headKey ="headid";
		String columnKey ="columnid";
		String rowKey = "rowid";
		String contentKey = "cellcontent";
		long contentId = (long) json.get(contentIdKey);
		long headId = Long.valueOf((String) json.get(headKey)).longValue();
		long columnId = (long) json.get(columnKey);
		long rowId = Long.valueOf((String) json.get(rowKey)).longValue();
		String cellcontent = (String) json.get(contentKey);
		if (json.containsKey(contentKey) && json.containsKey(headKey) && json.containsKey(columnKey) && json.containsKey(rowKey) && json.containsKey(contentKey))
			check = updateContent(contentId, headId, columnId, rowId, cellcontent);
		return check;
	}
	
}