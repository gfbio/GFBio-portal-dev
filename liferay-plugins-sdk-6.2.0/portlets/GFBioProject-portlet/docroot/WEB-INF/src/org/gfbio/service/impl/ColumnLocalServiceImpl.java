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

import org.gfbio.NoSuchColumnException;
import org.gfbio.model.Column;
import org.gfbio.model.Head;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
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
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ColumnLocalServiceBaseImpl
 * @see org.gfbio.service.ColumnLocalServiceUtil
 */
public class ColumnLocalServiceImpl extends ColumnLocalServiceBaseImpl {

	
	@SuppressWarnings("unchecked")
	public JSONObject constructColumnJson(long columnId, long headId, String columnName){
		JSONObject json = new JSONObject();
		json.put("columnid", Long.toString(columnId));
		json.put("headid", Long.toString(headId));
		json.put("column_name", columnName);
		return json;
	}
	
	
	//delete column 
	public void deleteColumnById (long columnId)  {
		System.out.println("delColumn: "+columnId);
		ContentLocalServiceUtil.deleteContentsByColumnId(columnId);
		try {
			ColumnLocalServiceUtil.deleteColumn(columnId);
		} catch (PortalException | SystemException e) {e.printStackTrace();	}
	}
	
	
	//delete columns of a specific head
	public void deleteColumnsByHeadId (long headId){
		
		List <Column> columnList = null;
		try {
			columnList = ColumnLocalServiceUtil.getColumnsByHeadId(headId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (columnList != null)
			for (int i =0; i < columnList.size();i++)
				ColumnLocalServiceUtil.deleteColumnById(columnList.get(i).getColumnID());
	}
	
	
	// get the column by id
	public Column getColumnById(long columnId){
		try {
			return columnPersistence.findByColumnId(columnId);
		} catch (NoSuchColumnException | SystemException e) {e.printStackTrace();}
		return null;
	}
	
		
	// get a List of Columns by headid
	public List<Column> getColumnsByHeadId(long headId) throws SystemException {
		return columnPersistence.findByHeadId(headId);
	}
	
	
	//get a List of Columns by headid and column name
	public List<Column> getColumnsByHeadIdAndName(long headId, String columnName) throws SystemException{
		return columnPersistence.findByHeadIdAndColumnName(headId, columnName);
	}
	
	

	public List<Column> getColumnsWithRelation(String columnName) throws SystemException{
		return ColumnFinderUtil.getColumnsWithRelation(columnName);
	}
	
	@SuppressWarnings("rawtypes")
	public List getColumnIdsWithoutRelation(String columnName) throws SystemException{
		return ColumnFinderUtil.getColumnIdsWithoutRelation(columnName);
	}
	
	
	// get the count of columns of a specific head
	public int getCountofColumns (long headId) throws SystemException{
		return ColumnLocalServiceUtil.getColumnsByHeadId(headId).size();
	}
	

	
	
	//get a head id to the column id
	public long getHeadIdById(long columnId) throws PortalException, SystemException {
		return ColumnLocalServiceUtil.getColumn(columnId).getHeadID();
	}
	
	
/*	
	//
	public String[] getNameArray(long headId) throws SystemException, NoSuchCellException, NoSuchCell_HeadException, NoSuchCell_ContentException  {

		List<Content> contentList;
		String[] names = null;

		contentList = ContentLocalServiceUtil.getContentsByHeadId(headId);
		names = new String[contentList.size()];
			
		for (int j =1;j<= 20;j++)
			if (HeadLocalServiceUtil.getColumnName(headId, j).trim().equals("name"))
				if (contentList!= null)
					for (int i = 0; i<contentList.size(); i++)
						names[i] = getColumnContent(contentList.get(i).getContentID(),j);
		return names;
	}
	*/
	
	
	//get the maximal count of columns of a List of heads
	public int getMaxCountofColumns (List <Head> headList) throws SystemException{
		int maxcolumncount = 0;
		for (int i = 0; i < headList.size();i++)
			if (maxcolumncount < ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID()))
				maxcolumncount = ColumnLocalServiceUtil.getCountofColumns(headList.get(i).getHeadID());
		return maxcolumncount;
	}
	
	
	//update or build a new the column
	public Boolean updateColumn (long columnId, long headId, String content){
		
		System.out.println("columnID: "+columnId+ ", headID: "+headId+", Content: "+content);
		Boolean check = false;
		Column column = null;

		try {
			column = ColumnLocalServiceUtil.getColumn(columnId);
		} catch (PortalException | SystemException e) {e.printStackTrace();}


		// if it true, then must be build a new content with a new primary keay else update the content
		if (column == null)
			try {
				column = columnPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				System.out.println("columnID: "+column.getColumnID()+ ", headID: "+headId+", Content: "+content);
			} catch (SystemException e) {e.printStackTrace();}

		column.setHeadID(headId);
		column.setColumn_name(content);


		try {
			super.updateColumn(column);
			check = true;
			if (columnId ==0){
				@SuppressWarnings("rawtypes")
				List rowCount = ContentLocalServiceUtil.getRowIds(headId);
				if (rowCount.size()>0)
					for (int i =0;i<rowCount.size();i++)
						ContentLocalServiceUtil.updateContent(0, headId, column.getColumnID(), (long) rowCount.get(i), "");
			}
		} catch (SystemException e) {e.printStackTrace();}
		

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
		System.out.println("column: "+json);
		Boolean check = false;
		check = ColumnLocalServiceUtil.updateColumn(json);
		int i=0;
		while (json.containsKey(new Integer (i).toString())){
			JSONObject contentjson = (JSONObject) json.get(new Integer (i).toString());
			System.out.println(contentjson);
			check = ContentLocalServiceUtil.updateContent(contentjson);
			i++;
		}
	
		return check;
	}
	
}