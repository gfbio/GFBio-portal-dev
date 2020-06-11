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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gfbio.NoSuchContentException;
import org.gfbio.NoSuchHeadException;
import org.gfbio.helper.Helper;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

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

	private static Log _log = LogFactoryUtil.getLog(ContentLocalServiceImpl.class);
	
	///////////////////////////////////// Delete Functions ///////////////////////////////////////////////////
	
	
	//delete contents of a specific column
	public void deleteContentsByColumnId (long columnId){
		
		List <Content> contentList = null;
		try {contentList = contentPersistence.findByColumnId(columnId);}
		catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null)
			for (int i =0; i < contentList.size();i++)
				try {deleteContent(contentList.get(i).getContentID());} 
				catch (PortalException | SystemException e) {e.printStackTrace();}
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
	
	
	//
	public void deleteRelationContentByCellContent(String cellcontent1, String cellcontent2 ){
		long rowId = getRowIdOfRelation(cellcontent1, cellcontent2);
		deleteContentsByRowId (rowId);
	}
	
	
	//
	public void deleteRelationContentsByCellContent(String relationTable, String columnName, String cellContent){
		List<Long> rowIdList = getRowIdsByCellContent(relationTable, columnName, cellContent);
		if (rowIdList != null)
			for (int i =0; i<rowIdList.size();i++)
				deleteContentsByRowId(rowIdList.get(i));
		
	}
	
	
	//
	public void deleteRelationContentOfCategoryWithSpecificType(String typeName, long relatedId, String relationTable){
		List <Long> rowIdList= null;
		try {rowIdList= getRowIdsOfCategoryWithSpecificType(typeName, relatedId, relationTable);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		
		if (rowIdList != null)
			for (int i =0; i<rowIdList.size();i++)
				deleteContentsByRowId(rowIdList.get(i));
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
	
	
	// get the columnId of a specific content.
	public long getColumnIdById(long contentId) throws SystemException, PortalException{
		return (long) ContentFinderUtil.getColumnIdById(contentId).get(0);
	}
	
	
	@SuppressWarnings("rawtypes")
	public long 	getContentIdByRowIdAndColumnName(long rowId, String columnName) {
		long contentId =0;
		List contentIdList = ContentFinderUtil.getContentIdByRowIdAndColumnName(rowId, columnName);
		if (contentIdList != null && contentIdList.size()>0)
			contentId = (long) contentIdList.get(0);
		return contentId;
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
	
	
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getContentIdsOfRelationshipsOfSpecificCellContent(String relationTableName, String entitiyTableName, String entityTableCellContent){
		List <Long> idList = new ArrayList ();
		try {idList = ContentFinderUtil.getContentIdsOfRelationshipsOfSpecificCellContent(HeadLocalServiceUtil.getHeadIdByTableName(relationTableName), HeadLocalServiceUtil.getHeadIdByTableName(entitiyTableName), entityTableCellContent);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}
		return idList;
	}	
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getContentIdsOfRelationshipsOfSpecificCellContent(long relationTableHeadId, long entitiyTableHeadId, String entityTableCellContent){
		return ContentFinderUtil.getContentIdsOfRelationshipsOfSpecificCellContent(relationTableHeadId, entitiyTableHeadId, entityTableCellContent);
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
			json = constructContentJson(content);
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
				subJson.put("lastmodifieddate", contentList.get(i).getLastModifiedDate());
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
	
	
	//
	@SuppressWarnings("rawtypes")
	public long getHeadIdByRowId(long rowId){
		long headId =0;
		List headIdList = (List) ContentFinderUtil.getHeadIdByRowId(rowId);
		if (headIdList.size() >0)
			headId = (long) headIdList.get(0);
		return headId;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = ContentFinderUtil.getMaxId();
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
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
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getOppositeCellContentsOfRelationsByCellContent(long headId, long columnId, String cellContent){
		List <String> responseList = ContentFinderUtil.getOppositeCellContentsOfRelationsByCellContentAndColumn(headId, columnId, cellContent);
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {parseJson = (JSONArray) parser.parse(responseList.toString());}
		catch (ParseException e) {e.printStackTrace();}

		return parseJson;
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
		try {headId = HeadLocalServiceUtil.getHeadIdByTableName(tableName);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		
		if(headId !=0)
			rowId = getRowIdByCellContent(headId, columnName, cellContent);

		return rowId;
	}
	
	
	// 
	@SuppressWarnings("unchecked")
	private List <Long> getRowIdsByCellContent(long headId, String columnName, String cellContent){
		List <Long> rowIdList = null;
		rowIdList =  ContentFinderUtil.getRowIdByCellContent(headId, columnName, cellContent);
		return rowIdList;
	}
	
	
	// 
	private List <Long> getRowIdsByCellContent(String tableName, String columnName, String cellContent){
		List <Long> rowId = null;
		long headId =0;
		try {headId = HeadLocalServiceUtil.getHeadIdByTableName(tableName);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		
		if(headId !=0)
			rowId = getRowIdsByCellContent(headId, columnName, cellContent);
		
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
	
	
	//
	private List<Long> getRowIdsOfCategoryWithSpecificType(String typeName, long relatedId, String relationTable) throws NoSuchHeadException, SystemException{
		return  getRowIdsOfCategoryWithSpecificType(typeName, Long.toString(relatedId), relationTable);
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	private List<Long> getRowIdsOfCategoryWithSpecificType(String typeName, String relatedId, String relationTable) throws NoSuchHeadException, SystemException{
		long typeHeadId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_type");
		long typeColumnId= ColumnLocalServiceUtil.getColumnIdByNames("gfbio_type", "id");
		long categoryTypeHeadId=HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_type");
		long categoryTypeCategoryColumnId=ColumnLocalServiceUtil.getColumnIdByNames("gfbio_category_type", "gfbio_category");
		long relationTableHeadId=HeadLocalServiceUtil.getHeadIdByTableName(relationTable);
		
		return  ContentFinderUtil.getRowIdsOfCategoryWithSpecificType(typeHeadId, typeName, typeColumnId, categoryTypeHeadId, categoryTypeCategoryColumnId, relationTableHeadId, relatedId);
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
	
	
	//get a List of rowIds of specific head
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONObject  getRowInformationById (long rowId){
		
		 JSONObject responseJson = new JSONObject();
		 List response =  (ArrayList) ContentFinderUtil.getRowInformationByRowId (rowId);
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
	

	//get List of content Informations from a relationship between two entities. The list has only Informations from one of the entities. The not list entity has a condition in cell content column. Example: The function get all category entries of the relationship between category and types, where the type cell content is 'research field'
	@SuppressWarnings("unchecked")
	public JSONArray getRowInformationsOfRelationshipsOfSpecificCellContent(JSONObject requestJson){
		
		Set<String> set = new HashSet<String>();
		String [] keySet = {"relationtablename","entitytablename", "entitytablecellcontent"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		JSONArray responseJson = new JSONArray();
		if (requestJson.containsKey("relationtablename") && requestJson.containsKey("entitytablename") && requestJson.containsKey("entitytablecellcontent"))
			responseJson = getRowInformationsOfRelationshipsOfSpecificCellContent((String)requestJson.get("relationtablename"), (String)requestJson.get("entitytablename"), (String)requestJson.get("entitytablecellcontent"));
		else
			responseJson.add("ERROR: To get the Informations, the json need minimal 'relationtablename', 'entitytablename' and 'entitytablecellcontent' as Strings.");

		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		return responseJson;
	}
	
	
	//get List of content Informations from a relationship between two entities. The list has only Informations from one of the entities. The not list entity has a condition in cell content column. Example: The function get all category entries of the relationship between category and types, where the type cell content is 'research field'
	@SuppressWarnings({ "unchecked" })
	public JSONArray getRowInformationsOfRelationshipsOfSpecificCellContent(String relationTableName, String entitiyTableName, String entityTableCellContent){
		JSONArray responseJson = new JSONArray();
		List <Long> idList = getContentIdsOfRelationshipsOfSpecificCellContent(relationTableName, entitiyTableName, entityTableCellContent);
		if (idList.size()>0)
			for (int i =0; i < idList.size();i++)
				responseJson.add(getRowInformationByContentId(idList.get(i)));
		else
			responseJson.add("Error: No relationsships exists, with this conditions.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONArray getRowInformationOfRelationshipsOfSpecificCellContent(long relationTableHeadId, long entitiyTableHeadId, String entityTableCellContent){
		
		JSONArray responseJson = new JSONArray();;
		List responseList = null;
		responseList = getContentIdsOfRelationshipsOfSpecificCellContent (relationTableHeadId, entitiyTableHeadId, entityTableCellContent);
		if (responseList.size()>0)
			for (int i =0; i < responseList.size();i++)
				responseJson.add(getRowInformationById(ContentLocalServiceUtil.getRowIdById((long)responseList.get(i))));
		else
			responseJson.add("Error: No relationsships exists, with this conditions.");
		return responseJson;
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
	
	
	//
	public String checkForIgnoredParameter (Object[] objects, Set<String> keyList){

		String ignoredParameter = "WARNING:";
		Boolean check = false;
		for (int i =0; i < objects.length;i++)
			if (!keyList.contains((objects[i]))){
				ignoredParameter = ignoredParameter.concat(" ").concat(objects[i].toString()).concat(",");
				check = true;
			}
		if (check == true)
			ignoredParameter = ignoredParameter.substring(0, ignoredParameter.length()-1).concat(" are not parameters of this method.");
		else
			ignoredParameter ="";
		return ignoredParameter;
	}
	
	
	//Are pk1 and pk2 in table with headid, the Boolean is false, because the function will is useing in relationship table update
	public Boolean checkKeyPairInRelationship(long headId, String pk1, String pk2) {
		return (Boolean) ContentFinderUtil.checkKeyPairInRelationship (headId, pk1, pk2).get(0);
	}
	
	
	//build a content entry to a JSON
	@SuppressWarnings("unchecked")
	public JSONObject constructContentJson(Content content){
		JSONObject json = new JSONObject();
		json.put("contentid", content.getContentID());
		json.put("headid", content.getHeadID());
		json.put("columnid", content.getColumnID());
		json.put("rowid", content.getRowID());
		json.put("cellcontent", content.getCellContent());
		json.put("lastmodifieddate", content.getLastModifiedDate());
		return json;
	}
	
	
	//build a content entry to a JSON
	@SuppressWarnings("unchecked")
	public JSONObject constructContentJson(long contentId, long headId, long columnId, long rowId, String cellContent, Date lastModifiedDate){
		JSONObject json = new JSONObject();
		json.put("contentid", contentId);
		json.put("headid", headId);
		json.put("columnid", columnId);
		json.put("rowid", rowId);
		json.put("cellcontent", cellContent);
		json.put("lastmodifieddate", lastModifiedDate);
		return json;
	}
	
	
	//tableName, {{columnnames:[name, label]}{name: foo},{label:foolabel},...}
	@SuppressWarnings("unchecked")
	public JSONArray constructContenRowInputJson (String tableName, long contentId, long rowId, JSONObject rowInformationJson){
		
		JSONArray responseJson = new JSONArray();
		JSONArray columnNames = (JSONArray) rowInformationJson.get("columnnames");
		
		for (int i=0;i<columnNames.size();i++){
			JSONObject contentJson = new JSONObject();
			contentJson.put("tablename", tableName);
			contentJson.put("columnname", columnNames.get(i));
			contentJson.put("cellcontent", rowInformationJson.get(columnNames.get(i)));
			if (contentId >0)
				contentJson.put("contentid", contentId);
			if (rowId >0)
				contentJson.put("rowid", rowId);
			responseJson.add(contentJson);
		}

		return responseJson;
	}
	

	//
	public long constructNewId(){
		long id = 0;
		try {
			if (CounterLocalServiceUtil.increment(getModelClassName())<getMaxId())
				CounterLocalServiceUtil.reset(getModelClassName(), getMaxId());
			id = CounterLocalServiceUtil.increment(getModelClassName());
		} 
		catch (SystemException e) {e.printStackTrace();}
		return id;
	}
	
		
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	@SuppressWarnings("unchecked")
	public JSONArray createContent (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		
		if ((requestJson.containsKey("headid") || requestJson.containsKey("tablename")) && requestJson.containsKey("cellcontent") && (requestJson.containsKey("columnid") || requestJson.containsKey("columnname"))){
			long columnId = 0;
			long headId = 0;
			String key="";
			
			key = "headid";
			if (requestJson.containsKey(key))
				headId = Helper.getLongFromJson(requestJson, key);
			else
				try {headId = HeadLocalServiceUtil.getHeadIdByTableName((String) requestJson.get("tablename"));}
				catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}	

			if (headId >0){
				if (requestJson.containsKey("columnid"))
					columnId = (long) requestJson.get("columnid");
				else
					try {columnId = HeadLocalServiceUtil.getHeadIdByTableName((String) requestJson.get("columnname"));}
					catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}

				if (columnId >0){
					long contentId  = updateKernalContent(headId, columnId, 0,(String) requestJson.get("cellcontent"));
					responseJson.add(contentId);
			
					if (contentId > 0){
						long rowId =0;
						key = "rowid";
						if (requestJson.containsKey(key))
							rowId = Helper.getLongFromJson(requestJson, key);

						if (rowId > 0){
							rowId = updateRowId(contentId, rowId);
						}
					}
				}
			}
		}
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createContentWithTS (JSONObject requestJson){
		
		JSONArray responseJson = createContent(requestJson);
		
		if (responseJson.size()>0){
			long contentId = (long) responseJson.get(0);
			
			Content content = null;
			try {content = getContent(contentId);}
			catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}
			
			if (content != null){
				long tsContentId =0;
				if (requestJson.containsKey("tscontentid"))
					tsContentId = Helper.getLongFromJson(requestJson, "tscontentid");
				contentId = updateRowTimeStamp (content.getHeadID(), content.getRowID(), tsContentId);
				responseJson.add(contentId);
			}
		}
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createContentRow (JSONArray requestJson){
		JSONArray responseJson = new JSONArray();
		for (int i =0; i < requestJson.size();i++)
			responseJson.add(createContent((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateContent (JSONObject requestJson){

		JSONArray responseJson = new JSONArray();
		if (requestJson.containsKey("contentid")){
			
			long contentId = Helper.getLongFromJson(requestJson, "contentid");
			if (contentId >0){
									
				if (contentId > 0){
					
					Content content = null;
					try {content = getContent(contentId);}
					catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}

					if (content != null){

						responseJson.add(contentId);
						
						if (requestJson.containsKey("cellcontent"))
							updateCellContent(contentId, Helper.getStringFromJson(requestJson, "cellcontent"));
	
						if (requestJson.containsKey("rowid"))
							updateRowId(contentId, Helper.getLongFromJson(requestJson, "rowid"));
					
					}
				}else{
					if ((requestJson.containsKey("headid") || requestJson.containsKey("tablename")) && requestJson.containsKey("cellcontent") && (requestJson.containsKey("columnid") || requestJson.containsKey("columnname")))
						responseJson = createContent(requestJson);
					}
			}else{
				if ((requestJson.containsKey("headid") || requestJson.containsKey("tablename")) && requestJson.containsKey("cellcontent") && (requestJson.containsKey("columnid") || requestJson.containsKey("columnname")))
					responseJson = createContent(requestJson);
			}
		}else{
			if ((requestJson.containsKey("headid") || requestJson.containsKey("tablename")) && requestJson.containsKey("cellcontent") && (requestJson.containsKey("columnid") || requestJson.containsKey("columnname")))
				responseJson = createContent(requestJson);
		}

		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateContentWithTS (JSONObject requestJson){
		
		JSONArray responseJson = updateContent(requestJson);
		
		if (responseJson.size()>0){
			long contentId = (long) responseJson.get(0);
			
			Content content = null;
			try {content = getContent(contentId);}
			catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}
			
			if (content != null){
				long tsContentId =0;
				if (requestJson.containsKey("tscontentid"))
					tsContentId = Helper.getLongFromJson(requestJson, "tscontentid");
				contentId = updateRowTimeStamp (content.getHeadID(), content.getRowID(), tsContentId);
				responseJson.add(contentId);
			}
		}
		
		return responseJson;
	}	
	
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateContentRow (JSONArray requestJson){
		JSONArray responseJson = new JSONArray();
		for (int i =0; i < requestJson.size();i++)
			responseJson.add(updateContentWithTS((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	//----------------------------------- Update Functions -------------------------------------------------//
	
	
	//
	public long updateKernalContent(long headId, long columnId, long contentId, String cellContent){
		
		Content content = null;
		try {content = getContent(contentId);}
		catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}

		if (content == null){
			contentId  = constructNewId();
			content = contentPersistence.create(contentId);
		}
		
		content.setHeadID(headId);
		content.setColumnID(columnId);
		content.setCellContent(cellContent);
		content.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {super.updateContent(content);}
		catch (SystemException e) {e.printStackTrace();}

		return contentId;
	}
	
	
	//
	public long  updateKernelContent (long headId, long columnId, long contentId, long rowId, String cellContent){

		Content content = null;
		try {content = getContent(contentId);}
		catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}
		
		// if it true, then must be build a new content with a new primary key else update the content
		if (content == null){
			try {
				if (contentId ==0)
					contentId  = constructNewId();
				content = contentPersistence.create(contentId);
				Column column = null;
				try {column = ColumnLocalServiceUtil.getColumn(columnId);}
				catch (PortalException e) {e.printStackTrace();}
				if (column != null)
					if (ColumnLocalServiceUtil.getColumnNameById(columnId).equals("id"))
						cellContent = Long.toString(content.getContentID());
			} 
			catch (SystemException e) {e.printStackTrace();}
			
			if (rowId ==0)
				rowId  = constructNewId();
		}else
			if (rowId ==0)
				rowId = ContentLocalServiceUtil.getRowIdById(contentId);

		content.setHeadID(headId);
		content.setColumnID(columnId);
		content.setRowID(rowId);
		content.setCellContent(cellContent);
		content.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {super.updateContent(content);}
		catch (SystemException e) {e.printStackTrace();}
		return contentId;
	}	
	
	
	//
	public long updateRowTimeStamp (long headId, long rowId, long contentId){

		Boolean check = false;
		String columnName = "lastmodifieddate";
		if (contentId ==0)	
			contentId = getContentIdByRowIdAndColumnName(rowId, columnName);
		
		if (contentId !=0){
			check = updateCellContent(contentId, (new Timestamp(new Date().getTime()).toString()));
		}
		else{
			if (!ColumnLocalServiceUtil.checkExistenceOfColumn(headId, columnName))
				ColumnLocalServiceUtil.updateColumn( 0,  headId,  columnName);
			long columnId = 0;
			try {columnId = ColumnLocalServiceUtil.getColumnIdByNames(HeadLocalServiceUtil.getTableNameById(headId), columnName);}
			catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
			contentId = updateKernelContent ( headId, columnId, constructNewId(), rowId,  (new Timestamp(new Date().getTime())).toString());
			
			if (contentId > 0)
				check = true;
		}
		
		if (!check)
			contentId =0;

		return contentId;
	}
	
	
	
	
	//update or build a new the content
	@SuppressWarnings("unchecked")
	public JSONObject updateContent (long headId, long columnId, long contentId, long rowId, String cellContent, long tsContentId){
		_log.info(headId+"|"+columnId+"|"+ contentId+"|"+rowId+"|"+ cellContent+"|"+tsContentId);
		JSONObject responseJson = new JSONObject();
		Content content = null;
		long timeStampeContentId=0;
		
		contentId = updateKernelContent (headId, columnId, contentId, rowId, cellContent);

		try {content = getContent(contentId);}
		catch (PortalException | SystemException e) {e.printStackTrace();}
		
		if (content != null)
			timeStampeContentId = updateRowTimeStamp (content.getHeadID(), content.getRowID(), tsContentId);
		
		
		responseJson.put("contentid", contentId);
		responseJson.put("tscontentid", timeStampeContentId);
		
		return responseJson;
	}
	
	


	
/*	//update or build a new the content with a json as input
	public long updateContent (JSONObject json){

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
			contentId = updateContent(contentId, headId, columnId, rowId, cellcontent);
		return contentId;
	}*/
	
	
	//update or build a new the content with a json as input
	public long updateContent2 (JSONObject json){
		
		String headKey ="headid";
		String columnKey ="columnid";
		String rowKey = "rowid";
		String contentKey = "cellcontent";
		String contentIdKey = "contentid";
		long contentId =0;
		contentId = Helper.getLongFromJson(json, contentIdKey);
		long headId = Long.valueOf((String) json.get(headKey)).longValue();
		long columnId = (long) json.get(columnKey);
		long rowId = Long.valueOf((String) json.get(rowKey)).longValue();
		String cellcontent = (String) json.get(contentKey);
		if (json.containsKey(contentKey) && json.containsKey(headKey) && json.containsKey(columnKey) && json.containsKey(rowKey) && json.containsKey(contentKey)){
			long tsContentId =0;
			if (json.containsKey("tscontentid"))
				tsContentId = Helper.getLongFromJson(json, "tscontentid");
			JSONObject responseJson = updateContent(contentId, headId, columnId, rowId, cellcontent, tsContentId);
			contentId = (long) responseJson.get("contentId");
		}
		
		return contentId;
	}
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
	
	

	
	
	//
	private Boolean updateCellContent(long contentId, String cellContent){
		
		Boolean check = false;
		Content content = null;

		try {content = getContent(contentId);}
		catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}

		// if it true, then must be build a new content with a new primary key else update the content
		if (content != null){
			content.setCellContent(cellContent);
			content.setLastModifiedDate(new Timestamp(new Date().getTime()));
			
			try {
				super.updateContent(content);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	private long updateRowId(long contentId, long rowId){
		
		Content content = null;
		if (rowId ==0)
			rowId = ContentLocalServiceUtil.constructNewId();

		try {content = getContent(contentId);}
		catch (PortalException | SystemException e) {_log.info("No Content exists with the primary key "+contentId);}

		if (content != null){
			content.setRowID(rowId);
			content.setLastModifiedDate(new Timestamp(new Date().getTime()));
			
			try {super.updateContent(content);}
			catch (SystemException e) {e.printStackTrace();rowId =0;}
		}
		return rowId;
	}
	
}