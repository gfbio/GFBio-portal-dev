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
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.model.Column;
import org.gfbio.model.Head;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.base.ColumnLocalServiceBaseImpl;
import org.gfbio.service.persistence.ColumnFinderUtil;
import org.gfbio.service.persistence.ContentFinderUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the column local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ColumnLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * <p>
 * Column is a part of the Head, Column, Content System (HCC). 
 * This three classes (Head, Column, Content) / entities (gfbio_head, gfbio_column, gfbio_content) are high toothed and represent a lot of arbitrary tables (HCC tables).
 * </p>
 * 
 * <p>
 * In HCC, the Column has the function of the columns in the HCC table. Every entry in gfbio_column is a column in a HCC table. HeadID is the foreign key to Head.
 * </P>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ColumnLocalServiceBaseImpl
 * @see org.gfbio.service.ColumnLocalServiceUtil
 * @see org.gfbio.service.HeadLocalServiceImpl
 * @see org.gfbio.service.ContentLocalServiceImpl
 */
public class ColumnLocalServiceImpl extends ColumnLocalServiceBaseImpl {

	
	///////////////////////////////////// Delete Functions ///////////////////////////////////////////////////////
	
	
	/**
	 * Delete all column entries of a specific head.
	 * 
	 * @param 	headId		from type long, is the PK of entity gfbio_head
	 */
	public void deleteColumnsByHeadId (long headId){
		
		List <Column> columnList = null;
		try {
			columnList = columnPersistence.findByHeadId(headId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (columnList != null)
			for (int i =0; i < columnList.size();i++)
				try {
					ColumnLocalServiceUtil.deleteColumn(columnList.get(i).getColumnID());
				} catch (PortalException | SystemException e) {e.printStackTrace();}
	}
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////////
	
	
	//
	@SuppressWarnings("rawtypes")
	public long getColumnIdByNames (String tableName, String columnName){
		long columnId = 0;
		
		List idList = ColumnFinderUtil.getColumnIdByNames(tableName, columnName);
		if (idList.size()>0)
			columnId = (long) idList.get(0);
		return columnId;
	}
	
	
	/**
	 * Returns the name of a column entry. 
	 * 
	 * @param	columnId	from type long, is the PK of entity gfbio_column
	 * @returns	name		from type String, is the content of attribute 'column_name' of entity gfbio_column
	 */
	@SuppressWarnings("rawtypes")
	public String getColumnNameById (long columnId){
		String name ="";
		List nameList = ColumnFinderUtil.getColumnNameById(columnId);
		if (nameList.size()>0)
			name =  (String) nameList.get(0);
		return name;
	}
	
		
	/**
	 * Returns all column entries, that have a specific content of attribute 'headid' of entity gfbio_column
	 * 
	 * @param 	headId	from type long, is a foreign key of entity gfbio_column to entity gfbio_head
	 * @return			List from type Column, consists of all column entries with a specific HeadID
	 */
	public List<Column> getColumnsByHeadId(long headId) throws SystemException {
		return columnPersistence.findByHeadId(headId);
	}
	
	
	/**
	 * Returns all column entries, that have table type 'relationship' (table type is a attribute in entity gfbio_head) and a specific content of attribute 'column_name' of entity gfbio_column. This method was written to find specific columns per 'table_names' (attribute in gfbio_head, that is the column name in relationship tables)
	 * 
	 * @param	columnName	from type String, is a specific content of attribute 'column_name' of entity content
	 * @return				List from type Column, consists of all columns, that have table type 'relationship' and the parameter columnName are equal to the content of attribute 'column_name' of entity gfbio_column
	 */
	public List<Column> getColumnsWithRelation(String columnName) throws SystemException{
		return ColumnFinderUtil.getColumnsWithRelation(columnName);
	}
	
	
	// get the count of columns of a specific head
	/**
	 * 
	 */
	public int getCountofColumns (long headId) throws SystemException{
		return (int) ColumnFinderUtil.getCountofColumns(headId).get(0);
	}
	

	//get a head id to the column id
	@SuppressWarnings("rawtypes")
	public long getHeadIdById(long columnId) throws PortalException, SystemException {
		long headId =0;
		List headIdList = (List) ColumnLocalServiceUtil.getColumn(columnId);
		if (headIdList.size() >0)
			headId = (long) headIdList.get(0);
		return headId;
	}

	
	//get a head id to the column id
	@SuppressWarnings("rawtypes")
	public List getHeadIdsByColumnName(String columnName) {
		return ColumnFinderUtil.getHeadIdsByColumnName(columnName);
	}	
	
	
	/**
	 * Returns all head id's of entries of entity gfbio_head, that have no table type 'relationship' (table type is a attribute in entity gfbio_head) and have a column with a specific name
	 * 
	 * @param	columnName	from type String, is a specific content of attribute 'column_name' of entity gfbio_content
	 * @return				List from type long, consists of head id's 
	 */
	@SuppressWarnings("rawtypes")
	public List getHeadIdsWithoutRelationshipsByColumnName(String columnName) throws SystemException{
		return ColumnFinderUtil.getHeadIdsWithoutRelationshipsByColumnName(columnName);
	}
	
	
	//get the maximal count of columns of a List of heads
	public int getMaxCountofColumns (List <Head> headList) throws SystemException{
		int maxcolumncount = 0;
		for (int i = 0; i < headList.size();i++)
			if (maxcolumncount < ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID()))
				maxcolumncount = ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID());
		return maxcolumncount;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = ColumnFinderUtil.getMaxId();
		System.out.println(idList);
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
	}
	

	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////////
		
	
	
	//
	public Boolean checkExistenceOfColumn(String tableName, String columnName) {
		Boolean check = false;
		long headId = 0;
		try {headId = HeadLocalServiceUtil.getHeadIdByTableName(tableName);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		if (headId !=0)
			check = checkExistenceOfColumn(headId, columnName);
		return check;
	}
	
	//
	public Boolean checkExistenceOfColumn(long headId, String columnName) {
		return (Boolean) ColumnFinderUtil.checkExistenceOfColumn(headId, columnName).get(0);
	}
	
	
	//check: "if this tableName in Column as columnName". By TRUE have the head with this tableName a relationship to a other head 
	public Boolean checkHaveTableRelationsById(long  headId) throws NoSuchHeadException, SystemException{
		return ColumnLocalServiceUtil.checkHaveTableRelationsByName(HeadLocalServiceUtil.getTableNameById(headId));
	}

	
	//check: "if this tableName in Column as columnName". By TRUE have the head with this tableName a relationship to a other head 
	@SuppressWarnings("rawtypes")
	public Boolean checkHaveTableRelationsByName(String tableName){
		Boolean check = false;
		List list = getHeadIdsByColumnName(tableName);
		if (list != null)
			check = true;
		return check;
	}
	
	
	//construct a JSON of Column
	@SuppressWarnings("unchecked")
	public JSONObject constructColumnJson(Column column){
		JSONObject json = new JSONObject();
		json.put("columnid", Long.toString(column.getColumnID()));
		json.put("headid", Long.toString(column.getHeadID()));
		json.put("column_name", column.getColumn_name());
		json.put("lastmodifieddate", column.getLastModifiedDate());
		return json;
	}
	
	
	//construct a JSON of Column
	@SuppressWarnings("unchecked")
	public JSONObject constructColumnJson(long columnId, long headId, String columnName, Date lastModifiedDate ){
		JSONObject json = new JSONObject();
		json.put("columnid", Long.toString(columnId));
		json.put("headid", Long.toString(headId));
		json.put("column_name", columnName);
		json.put("lastmodifieddate", lastModifiedDate);
		return json;
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
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////////
	
	
	//update or build a new the column
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Boolean updateColumn (long columnId, long headId, String content){
		
		Boolean check = false;
		JSONArray futureResponseJson = new JSONArray();
		Column column = null;
		try {column = getColumn(columnId);}
		catch (PortalException | SystemException e) {System.out.println("No Column exists with the primary key "+columnId);}

		// if it true, then must be build a new content with a new primary key else update the content
		if (column == null)
			column = columnPersistence.create(constructNewId());

		column.setHeadID(headId);
		column.setColumn_name(content);
		column.setLastModifiedDate(new Timestamp(new Date().getTime()));
		
		try {
			super.updateColumn(column);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		if (columnId ==0){
			List rowCount = ContentLocalServiceUtil.getRowIds(headId);
			if (rowCount.size()>0){
				int i =0;
				while (i<rowCount.size() && check == true){
					JSONObject contentJson = new JSONObject();
					contentJson.put("contentid", 0);
					contentJson.put("headid", headId);
					contentJson.put("columnid", column.getColumnID());
					contentJson.put("rowid", (long) rowCount.get(i));
					contentJson.put("cellcontent", "");
					JSONArray tempJson = (JSONArray) ContentLocalServiceUtil.updateContent(contentJson);
					futureResponseJson.add(tempJson);
					if (tempJson.size() ==0)
						check = false;
					i++;
				}
			}
		}
		return check;
	}

	
	//update or build a new the column with a json as input
	public Boolean updateColumn (JSONObject json){
		
		Boolean check = false;
		String columnKey ="columnid";
		String headKey ="headid";
		String columnNameKey = "column_name";
		if (json.containsKey(columnKey) && json.containsKey(headKey) && json.containsKey(columnNameKey))
			check = updateColumn(Long.valueOf((String) json.get(columnKey)).longValue(),  Long.valueOf((String) json.get(headKey)).longValue(), (String) json.get(columnNameKey));
		return check;
	}
	
	
	//update or build a new the column and their content with a json as input
	@SuppressWarnings("unchecked")
	public JSONArray updateColumnWithContents (JSONObject json){

		JSONArray futureResponseJson = new JSONArray();
		Boolean check = true;
		check = updateColumn(json);
		int i=0;
		while (json.containsKey(new Integer (i).toString()) && check == true){
			JSONObject contentJson = (JSONObject) json.get(new Integer (i).toString());
			JSONArray tempJson = (JSONArray) ContentLocalServiceUtil.updateContentWithTS(contentJson);
			futureResponseJson.add(tempJson);
			if (tempJson.size() ==0)
				check = false;
			i++;
		}
		return futureResponseJson;
	}
	
	
	//update or build a new the column and their content with a json as input
	@SuppressWarnings("unchecked")
	public JSONArray updateColumnWithContents2 (JSONObject json){
		
		JSONArray futureResponseJson = new JSONArray();
		Boolean check = true;
		check = updateColumn(json);
		int i=0;
		while (json.containsKey(new Integer (i).toString()) && check == true){
			JSONObject contentJson = (JSONObject) json.get(new Integer (i).toString());
			JSONArray tempJson = (JSONArray) ContentLocalServiceUtil.createContentWithTS(contentJson);
			futureResponseJson.add(tempJson);
			if (tempJson.size() ==0)
				check = false;
			i++;
		}
	
		return futureResponseJson;
	}
	
}