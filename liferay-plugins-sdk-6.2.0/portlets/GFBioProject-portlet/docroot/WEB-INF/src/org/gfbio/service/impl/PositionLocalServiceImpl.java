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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.NoSuchPositionException;
import org.gfbio.model.Position;
import org.gfbio.service.PositionLocalServiceUtil;
import org.gfbio.service.base.PositionLocalServiceBaseImpl;
import org.json.simple.JSONObject;

/**
 * The implementation of the position local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.PositionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.PositionLocalServiceBaseImpl
 * @see org.gfbio.service.PositionLocalServiceUtil
 */

public class PositionLocalServiceImpl extends PositionLocalServiceBaseImpl {


	//delete position 
	public void deletePositionById (long positionId)  {
		try {
			PositionLocalServiceUtil.deletePosition(positionId);
		} catch (PortalException | SystemException e) {e.printStackTrace();	}
	}

	
	//delete positions of a specific column
	public void deletePositionsByColumnId (long columnId){
		
		List <Position> positionList = null;
		try {
			positionList = PositionLocalServiceUtil.getPositionsByColumnId(columnId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (positionList != null)
			for (int i =0; i < positionList.size();i++)
				PositionLocalServiceUtil.deletePositionById(positionList.get(i).getRowID());
	}
	
	
	//delete cells/relations of positions
	public void deleteCompletePositionsByHeadId(long headId) throws SystemException{
		List <Position> positionList = PositionLocalServiceUtil.getPositionsByHeadId(headId);
		for (int i =0; i<positionList.size();i++){
			PositionLocalServiceUtil.deletePositionById(positionList.get(i).getPositionID());
		}
	}
	
	
	//delete positions of a specific row
	public void deletePositionsByRowId (long rowId){
		
		List <Position> positionList = null;
		try {
			positionList = PositionLocalServiceUtil.getPositionsByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (positionList != null)
			for (int i =0; i < positionList.size();i++)
				PositionLocalServiceUtil.deletePositionById(positionList.get(i).getRowID());
	}
		
	
	//get the count of columns from a specific row
	public int getCountOfColumns(long rowId) throws SystemException{
		return positionPersistence.findByRowId(rowId).size();
	}	
	
	
	//get the count of rows from a specific column 
	public int getCountOfRows(long columnId) throws SystemException{
		return positionPersistence.findByColumnId(columnId).size();
	}
		
	
	//get a position object by the position id
	public Position getPositionById(long positionId) throws NoSuchPositionException, SystemException {
		return positionPersistence.findByPositionId(positionId);
	}	
			
	
	//get a List of positions of a specific head
	public List<Position> getPositionsByColumnId(long columnId) throws SystemException {
		return positionPersistence.findByColumnId(columnId);
	}
	
	
	//get a List of positions of a specific head
	public List<Position> getPositionsByHeadId(long headId) throws SystemException {
		return positionPersistence.findByHeadId(headId);
	}

	
	// get a List of Positions with a specific content in a specific column
	public List<Position> getPositionsByRowId(long rowId) throws SystemException{
		return positionPersistence.findByRowId(rowId);
	}
	
	
	//get the basic Information of the Positions of a specific row as JSON
	@SuppressWarnings("unchecked")
	public JSONObject getPositionInformationAsJSONByRowId (long rowId){
	
		JSONObject json = new JSONObject();
		List <Position> positionList = null;
		
		try {
			positionList = PositionLocalServiceUtil.getPositionsByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (positionList != null)
			for(int i =0;i<positionList.size();i++)
				json.put(Long.toString(positionList.get(i).getColumnID()), Long.toString(positionList.get(i).getPositionID()));
		
		return json;
	}
	
		
	//get the basic Information of the Positions of a specific row as JSON
	@SuppressWarnings("unchecked")
	public JSONObject getPositionsAsJSONByRowId (long rowId){
	
		JSONObject json = new JSONObject();
		List <Position> positionList = null;
		
		try {
			positionList = PositionLocalServiceUtil.getPositionsByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (positionList != null)
			for(int i =0;i<positionList.size();i++){
				JSONObject subJson = new JSONObject();
				subJson.put("headId", Long.toString(positionList.get(i).getHeadID()));
				subJson.put("columnId", Long.toString(positionList.get(i).getColumnID()));
				subJson.put("rowId", Long.toString(positionList.get(i).getRowID()));
				subJson.put("content", positionList.get(i).getContent());
				json.put(Long.toString(positionList.get(i).getPositionID()), subJson);
			}
		return json;
	}
	
	
	// get the columnId of a specific position.
	public long getColumnIdById(long positionId) throws SystemException, PortalException{
		return PositionLocalServiceUtil.getPosition(positionId).getColumnID();
	}
	
	
	// get a List of Positions with a specific content
	public List<Position> getPositionsByContent(String content) throws SystemException{
		return positionPersistence.findByContent(content);
	}
	
	
	// get a List of Positions with a specific content in a specific column
	public List<Position> getPositionsByContentOfColumn(String content, long columnId) throws SystemException{
		return positionPersistence.findByContentOfColumn(content, columnId);
	}
	
	
	// get the columnId of a specific position.
	public long getRowIdById(long positionId) throws SystemException, PortalException{
		return PositionLocalServiceUtil.getPosition(positionId).getRowID();
	}

	
	//get Content of a Cell in a specific position and column
	public String getContentByTableIds(long columnId, int rowId)  {
		try {
			return positionPersistence.findByTableIds(columnId, rowId).getContent();
		} catch (NoSuchPositionException | SystemException e) {e.printStackTrace();}
		return null;
	}
	
	
	//update or build a new the position
	public Boolean updatePosition (long positionId, long headId, long columnId, long rowId, String content){
		
		Boolean check = false;
		Position position = null;

		try {
			position = PositionLocalServiceUtil.getPosition(positionId);
		} catch (PortalException | SystemException e) {e.printStackTrace();	}

		// if it true, then must be build a new position with a new primary keay else update the position
		if (position == null)
			try {
				position = positionPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			} catch (SystemException e) {e.printStackTrace();}
		position.setHeadID(headId);
		position.setColumnID(columnId);
		position.setRowID(rowId);
		position.setContent(content);
		try {
			super.updatePosition(position);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//update or build a new the position with a json as input
	public Boolean updatePosition (JSONObject json){
		
		Boolean check = false;
		String positionKey ="positionId";
		String headKey ="headId";
		String columnKey ="columnId";
		String rowKey = "rowId";
		String contentKey = "content";
		if (json.containsKey(positionKey) && json.containsKey(headKey) && json.containsKey(columnKey) && json.containsKey(rowKey) && json.containsKey(contentKey))
			check = PositionLocalServiceUtil.updatePosition((long) json.get(positionKey), (long) json.get(headKey), (long) json.get(columnKey), (long) json.get(rowKey), (String) json.get(contentKey));
		return check;
	}
	

}