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
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.PositionLocalServiceUtil;
import org.gfbio.service.base.ColumnLocalServiceBaseImpl;
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

	//delete column 
	public void deleteColumnById (long columnId)  {
		PositionLocalServiceUtil.deletePositionsByColumnId(columnId);
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
	public List<Column> getColumnsByHeadId(long headId) throws SystemException{
		return columnPersistence.findByHeadId(headId);
	}
	
	
	//get a head id to the column id
	public long getHeadIdById(long columnId) throws PortalException, SystemException {
		return ColumnLocalServiceUtil.getColumn(columnId).getHeadID();
	}
	
	
/*	
	//
	public String[] getNameArray(long headId) throws SystemException, NoSuchCellException, NoSuchCell_HeadException, NoSuchCell_PositionException  {

		List<Position> positionList;
		String[] names = null;

		positionList = PositionLocalServiceUtil.getPositionsByHeadId(headId);
		names = new String[positionList.size()];
			
		for (int j =1;j<= 20;j++)
			if (HeadLocalServiceUtil.getColumnName(headId, j).trim().equals("name"))
				if (positionList!= null)
					for (int i = 0; i<positionList.size(); i++)
						names[i] = getColumnContent(positionList.get(i).getPositionID(),j);
		return names;
	}
	*/
	
	//update or build a new the column
	public Boolean updateColumn (long columnId, long headId, String content){
		
		Boolean check = false;
		Column column = null;

		try {
			column = ColumnLocalServiceUtil.getColumn(columnId);
		} catch (PortalException | SystemException e) {e.printStackTrace();}


		// if it true, then must be build a new position with a new primary keay else update the position
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

		return check;
	}
	
/*	
	//update or build a new the column with a json as input
	public Boolean updateColumn (JSONObject json){
		
		Boolean check = false;
		String columnKey ="columnId";
		String headKey ="headId";
		String contentKey = "content";
		if (json.containsKey(columnKey) && json.containsKey(headKey) && json.containsKey(contentKey))
			check = ColumnLocalServiceUtil.updateColumn((long) json.get(columnKey),  (long) json.get(headKey), (String) json.get(contentKey));
		return check;
	}*/
	
	
}