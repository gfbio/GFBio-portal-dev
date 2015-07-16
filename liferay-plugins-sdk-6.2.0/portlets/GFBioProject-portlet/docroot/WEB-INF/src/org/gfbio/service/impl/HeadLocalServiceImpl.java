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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.model.Column;
import org.gfbio.model.Head;
import org.gfbio.model.Position;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PositionLocalServiceUtil;
import org.gfbio.service.base.HeadLocalServiceBaseImpl;
import org.gfbio.service.persistence.HeadFinderUtil;
import org.json.simple.JSONObject;

/**
 * The implementation of the head local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.HeadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.HeadLocalServiceBaseImpl
 * @see org.gfbio.service.HeadLocalServiceUtil
 */
public class HeadLocalServiceImpl extends HeadLocalServiceBaseImpl {
	

	//ColumnLocalServiceUtil.deleteColumnsByHeadId ( headId);
	public void deleteHeadByHeadId(long headId) throws SystemException, PortalException{
		HeadLocalServiceUtil.deleteHead(headId);
	}
	
	
	//get the Counts of Column of a specific head 
	public int getCountOfColumns(long headId){
		
		int count =0;
		List <Position> positionList = null;
		try {
			positionList = PositionLocalServiceUtil.getPositionsByHeadId(headId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (positionList != null){
			for( int i=0; i <positionList.size();i++){
				try {
					if (count < PositionLocalServiceUtil.getCountOfColumns(positionList.get(i).getRowID()))
							count = PositionLocalServiceUtil.getCountOfColumns(positionList.get(i).getRowID());
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	
	//get the count of rows of a specific head
	public int getCountOfRows(long headId) throws SystemException{
		return PositionLocalServiceUtil.getPositionsByHeadId(headId).size();
	}
	
	
	//get the Entities that have a relation to a specific headId
	public List getEntitiesByHeadId(long headId) {
		return HeadFinderUtil.getEntitiesByHeadId(headId);
	}
	

	public List<Head> getHeadBetweenHeadId(int start, int end) {
		return HeadFinderUtil.getHeadBetweenHeadIds(start, end);
	}
	
		
	//get head by headID
	public Head getHeadById(long headId) throws NoSuchHeadException, SystemException {
		return headPersistence.findByHeadId(headId);
	}
	
	
	//get head by tableName of the table
	public Head getHeadByTableName(String tableName) throws NoSuchHeadException, SystemException {
		return headPersistence.findByTableName(tableName);
	}

	
	//get ID of a head by tableName
	public Long getHeadIdByTableName(String tableName) throws NoSuchHeadException, SystemException {
		return headPersistence.findByTableName(tableName).getHeadID();
	}
	
	
	//get all heads
	public List<Head> getHeads() throws SystemException {
		return headPersistence.findAll();
	}
	
	
	//get all heads with a specific table type
	public List<Head> getHeadsByTableType(String tableType) throws SystemException {
		return headPersistence.findByTableType(tableType);
	}
	
/*	
	//get the Head with all Cells as JSON
	public JSONObject getHeadAsJSONById (long headId){
	
		JSONObject json = new JSONObject();
		Head head = null;
		
	try {
		head = HeadLocalServiceUtil.getHead(headId);
	} catch (PortalException | SystemException e) {e.printStackTrace();}
		
		if (head != null){
			json.put("headId", head.getHeadID());
			json.put("tableName", head.getTable_name());
			json.put("table_type", head.getTable_type());
			try {
				for (int i =0; i < HeadLocalServiceUtil.getColumnCount(headId);i++)
					json.put(new Integer(i).toString(), CellLocalServiceUtil.getCell(Cell_HeadLocalServiceUtil.getCellId(headId, i)));
			} catch (SystemException | PortalException e) {e.printStackTrace();	}
		}
		return json;
	}*/
	
	
	//get Entities of a specific head in a TableArray
	public long[][] getTableAsArray(long headId){
		
		long[][] table = null;
		Head head = null;
		Column column = null;
		Position position = null;
		List list = HeadLocalServiceUtil.getEntitiesByHeadId(headId);
		
		if (list !=null){

			try {
				table = new long[PositionLocalServiceUtil.getCountOfRows(headId)+1][ColumnLocalServiceUtil.getCountofColumns(headId)+1];
			} catch (SystemException e) {e.printStackTrace();}
			
			//head of table
			Object[] arrayobject = (Object[]) list.get(0);
			head=(Head)arrayobject[0];
			table[0][0]= head.getHeadID();
			for (int j=1;j < table[0].length;j++){
				column=(Column)arrayobject[j-1];
				table[0][j]=column.getColumnID();
			}
			
			//body of table
			for (int i = 1; i < table.length;i++){
				
				position =(Position)arrayobject[2];
				table[i][0]= position.getRowID();
				for (int j =1;j< table[0].length;j++){
					table[i][j] = PositionLocalServiceUtil.getPositionIdByTableIds(i, j);
				}
			}
				
				
		       	
		       	
		       position =(Position)arrayobject[2];
		       	     	System.out.println(head.getTable_name() + " | " + column.getColumn_name() + " | " + position.getContent());
			}
		return table;
		}
		
	
	

	//get tableName of a specific head
	public String getTableName(long headId) throws NoSuchHeadException, SystemException {
		return headPersistence.findByHeadId(headId).getTable_name();
	}
	
	
	//get an Array of TableNames with a specific table type
	public String[] getTableNameArray(String tableType) throws SystemException  {

		List<Head> headList;
		if (tableType.equals(""))
			headList = null;
		else
			headList = getHeadsByTableType(tableType);
		return HeadLocalServiceUtil.getTableNameArray(headList);
	}
	
	//get an Array of Tablenames with a specific table type out of a List of heads
	public String[] getTableNameArray(List<Head> headList) throws SystemException {

		String[] tableNames = null;
		if (headList == null)
			headList = headPersistence.findAll();

		tableNames = new String[headList.size()];
		if (headList!= null)
			for (int i = 0; i<headList.size(); i++)
				tableNames[i] = headList.get(i).getTable_name();

		return tableNames;
	}
	
	
	
/*	//update or build a new the head
	public Boolean updateHead (long headId, String tableName, String tableType){
		
		Boolean check = false;
		Head head = null;

		try {
			head = HeadLocalServiceUtil.getHeadByTableName(tableName);
		} catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}


		// the tableName of a table must be unique
		if (head == null){

			try {
				head = HeadLocalServiceUtil.getHead(headId);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}

			// if it true, then must be build a new head else update the head
			if (head == null){
				try {
					head = headPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				} catch (SystemException e) {e.printStackTrace();}
			}
			head.setTable_name(tableName);
			head.setTable_type(tableType);
			try {
				super.updateHead(head);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}

		return check;
	}
	
	public Boolean updateHead (JSONObject content){
		
		Boolean check = false;
		String headKey ="headId";
		String tableNameKey = "tableName";
		String tableTypeKey = "tableType";
		if (content.containsKey(headKey) && content.containsKey(tableNameKey) && content.containsKey(tableTypeKey))
			check = HeadLocalServiceUtil.updateHead((long) content.get(headKey), (String) content.get(tableNameKey), (String) content.get(tableTypeKey));
		return check;
	}
	
	public Boolean updateHeadWithCells (long headId, String tableName, String tableType, JSONObject json){
		
		Boolean check = HeadLocalServiceUtil.updateHead(headId, tableName, tableType);
		for (int i=0;i <json.size();i++){
			try {
				check = CellLocalServiceUtil.updateCellOfHead(Cell_HeadLocalServiceUtil.getCellId(headId, i), "head", (String) json.get(new Integer(i).toString()), headId, i);
			} catch (NoSuchCell_HeadException | SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	

	
	//get the Table with Head and all Cells
	public String[][] getTable(long headId) throws SystemException, NoSuchHeadException, NoSuchCellException, NoSuchCell_HeadException, NoSuchCell_PositionException {

		List<Position> rows = PositionLocalServiceUtil.getPositionsByHeadId(headId);
		String[][] table = new String[(1 + HeadLocalServiceUtil.getColumnCount(headId))][(rows.size()+1)];

		//Head of Table
		table[0][0]= "ID";
		for (int j = 1; j < table.length; j++)
			table[j][0]= HeadLocalServiceUtil.getColumnName(headId, j-1);
		
		//Content of Table
		
		for (int i = 1; i < (table[0].length); i++) 
			for (int j = 0; j < table.length; j++)
				if (j == 0)
					table[j][i] = Long.toString(rows.get(i-1).getPositionID());
				else
					table[j][i] = getColumnContent(rows.get(i-1).getPositionID(), j-1);
			
		

		return table;
	}
	
	
	//update or build a relation table 
	public Boolean updateRelationTable(long headId, String mtable, String ntable){

		Boolean check = true;
		mtable = mtable.trim();
		ntable = ntable.trim();
		List<Head> headList = null;
		try {
			headList = HeadLocalServiceUtil.getHeadsByTableType("relation");
		} catch (SystemException e) {e.printStackTrace();}
		
		
		if (mtable.equals(ntable))
			check = false;
		else{
			
			//sort table tableNames
			List <String> tableNames = new ArrayList<String>();
			tableNames.add(mtable);
			tableNames.add(ntable);
			Collections.sort(tableNames);
			mtable = tableNames.get(0);
			ntable = tableNames.get(1);
			
			//check, that relation table do not existing
			for (int i =0;i < headList.size();i++){
				try {
					if (mtable.equals(CellLocalServiceUtil.getCellOfHeadByIdAndColumn(headList.get(i).getHeadID(), 1)))
						if (ntable.equals(CellLocalServiceUtil.getCellOfHeadByIdAndColumn(headList.get(i).getHeadID(), 1)))
							check = false;
				} catch (PortalException | SystemException e) {e.printStackTrace();	}
				try {
					if (ntable.equals(CellLocalServiceUtil.getCellOfHeadByIdAndColumn(headList.get(i).getHeadID(), 1)))
						if (mtable.equals(CellLocalServiceUtil.getCellOfHeadByIdAndColumn(headList.get(i).getHeadID(), 1)))
							check = false;
				} catch (PortalException | SystemException e) {e.printStackTrace();	}
			}
		}
		
		JSONObject json = new JSONObject();
		json.put("1", mtable);
		json.put("2", ntable);
				
		if (check == true)
			check =HeadLocalServiceUtil.updateHeadWithCells(headId, mtable.substring(6).concat("_").concat(ntable.substring(6)), "relation", json );

		return check;
	}
*/
}