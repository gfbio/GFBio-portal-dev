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

import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.model.Column;
import org.gfbio.model.Head;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.base.ColumnLocalServiceBaseImpl;
import org.gfbio.service.persistence.ColumnFinderUtil;
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
	 * Returns all head id's of entries of entity gfbio_head, that have no table type 'relationship' (table type is a attribute in entity gfbio_head) and have a column with a specific name
	 * 
	 * @param	columnName	from type String, is a specific content of attribute 'column_name' of entity gfbio_content
	 * @return				List from type long, consists of head id's 
	 */
	@SuppressWarnings("rawtypes")
	public List getHeadIdsWithoutRelationshipsByColumnName(String columnName) throws SystemException{
		return ColumnFinderUtil.getHeadIdsWithoutRelationshipsByColumnName(columnName);
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
	
	
	//get the maximal count of columns of a List of heads
	public int getMaxCountofColumns (List <Head> headList) throws SystemException{
		int maxcolumncount = 0;
		for (int i = 0; i < headList.size();i++)
			if (maxcolumncount < ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID()))
				maxcolumncount = ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID());
		return maxcolumncount;
	}
	

	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////////
		
	
	//check: "if this tableName in Column as columnName". By TRUE have the head with this tableName a relationship to a other head 
	public Boolean checkHaveTableRelationsById(long  headId) throws NoSuchHeadException, SystemException{
		return ColumnLocalServiceUtil.checkHaveTableRelationsByName(HeadLocalServiceUtil.getTableNameById(headId));
	}
	
	
	//check: "if this tableName in Column as columnName". By TRUE have the head with this tableName a relationship to a other head 
	@SuppressWarnings("rawtypes")
	public Boolean checkHaveTableRelationsByName(String tableName){
		Boolean check = false;
		List list = ColumnLocalServiceUtil.getHeadIdsByColumnName(tableName);
		if (list != null)
			check = true;
		return check;
	}
	
	
	//construct a JSON of Column
	@SuppressWarnings("unchecked")
	public JSONObject constructColumnJson(long columnId, long headId, String columnName){
		JSONObject json = new JSONObject();
		json.put("columnid", Long.toString(columnId));
		json.put("headid", Long.toString(headId));
		json.put("column_name", columnName);
		return json;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////////
	
	
	//update or build a new the column
	@SuppressWarnings("rawtypes")
	public Boolean updateColumn (long columnId, long headId, String content){
		
		Boolean check = false;
		Column column = null;
		try {
			column = ColumnLocalServiceUtil.getColumn(columnId);
		} catch (PortalException | SystemException e) {e.printStackTrace();}

		// if it true, then must be build a new content with a new primary key else update the content
		if (column == null)
			try {
				column = columnPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			} catch (SystemException e) {e.printStackTrace();}

		column.setHeadID(headId);
		column.setColumn_name(content);
		try {
			super.updateColumn(column);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		if (columnId ==0){
			List rowCount = ContentLocalServiceUtil.getRowIds(headId);
			if (rowCount.size()>0)
				for (int i =0;i<rowCount.size();i++)
					check = ContentLocalServiceUtil.updateContent(0, headId, column.getColumnID(), (long) rowCount.get(i), "");
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
			check = ColumnLocalServiceUtil.updateColumn(Long.valueOf((String) json.get(columnKey)).longValue(),  Long.valueOf((String) json.get(headKey)).longValue(), (String) json.get(columnNameKey));
		return check;
	}
	
	
	//update or build a new the column and their content with a json as input
	public Boolean updateColumnWithContents (JSONObject json){

		Boolean check = false;
		check = ColumnLocalServiceUtil.updateColumn(json);
		int i=0;
		while (json.containsKey(new Integer (i).toString())){
			JSONObject contentJson = (JSONObject) json.get(new Integer (i).toString());
			check = ContentLocalServiceUtil.updateContent(contentJson);
			i++;
		}
		return check;
	}
	
	
	//update or build a new the column and their content with a json as input
	public Boolean updateColumnWithContents2 (JSONObject json){
		
		Boolean check = false;
		check = ColumnLocalServiceUtil.updateColumn(json);
		int i=0;
		while (json.containsKey(new Integer (i).toString())){
			JSONObject contentJson = (JSONObject) json.get(new Integer (i).toString());
			check = ContentLocalServiceUtil.updateContent2(contentJson);
			i++;
		}
	
		return check;
	}
	
}