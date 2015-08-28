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
import org.gfbio.NoSuchContentException;
import org.gfbio.model.Column;
import org.gfbio.model.Head;
import org.gfbio.model.Content;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
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
	
	
	
	//construt a JSON with  the head attributs
	@SuppressWarnings("unchecked")
	public JSONObject constructHeadJson(long headId, String tableName, String tableType){
		JSONObject json = new JSONObject();
		json.put("headId", headId);
		json.put("tableName", tableName);
		json.put("tableType", tableType);
		return json;
	}
	

	//ColumnLocalServiceUtil.deleteColumnsByHeadId ( headId);
	public void deleteHeadByHeadId(long headId) throws SystemException, PortalException{
		HeadLocalServiceUtil.deleteHead(headId);
	}
	
	public void deleteTableByHeadId(long headId){
		try {
			ContentLocalServiceUtil.deleteContentsByHeadId(headId);
		} catch (SystemException e1) {e1.printStackTrace();	}
		ColumnLocalServiceUtil.deleteColumnsByHeadId(headId);
		try {
			HeadLocalServiceUtil.deleteHead(headId);
		} catch (PortalException | SystemException e) {e.printStackTrace();}
	}
	
		
	//get Table_names of a List of heads selected by TableType
	public String[] getArrayOfTableNames(String tableType){
		
		List <Head> headList = null;
		String[] names =null;
		
		try {
			headList = HeadLocalServiceUtil.getHeadsByTableType(tableType);
		} catch (SystemException e) {e.printStackTrace();}
		if (headList != null){
			names = new String[headList.size()];
			for (int i=0;i<headList.size();i++)
				names[i] = headList.get(i).getTable_name();
		}

		return names;
	}
	
	
	//get the Counts of Column of a specific head 
	public int getCountOfColumns(long headId){
		
		int count =0;
		List <Content> contentList = null;
		try {
			contentList = ContentLocalServiceUtil.getContentsByHeadId(headId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null){
			for( int i=0; i <contentList.size();i++){
				try {
					if (count < ContentLocalServiceUtil.getCountOfColumns(contentList.get(i).getRowID()))
							count = ContentLocalServiceUtil.getCountOfColumns(contentList.get(i).getRowID());
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	
	//get the count of rows of a specific head
	public int getCountOfRows(long headId) throws SystemException{
		return ContentLocalServiceUtil.getContentsByHeadId(headId).size();
	}
	
	
	//get the Entities that have a relation to a specific headId
	public List getEntitiesByHeadId(long headId) {
		return HeadFinderUtil.getEntitiesByHeadId(headId);
	}
	

	
	//it's a common sql query test method
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
		return HeadLocalServiceUtil.getHeadByTableName(tableName).getHeadID();
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
	public long[][] getIdTableAsArray(long headId){
		
		long[][] table = null;
		try {
			table = new long[((ColumnLocalServiceUtil.getCountofColumns(headId))+1)][(ContentLocalServiceUtil.getCountOfRows(headId)+1)];
		} catch (SystemException e) {e.printStackTrace();}
			
		//head of table
		table[0][0]= headId;
		List<Column> columnList = null;
		try {
			columnList = ColumnLocalServiceUtil.getColumnsByHeadId(headId);
		} catch (SystemException e1) {e1.printStackTrace();}
		
		for (int x =0; x < columnList.size();x++)
			table[x+1][0]= columnList.get(x).getColumnID();
		
		//body of table
		List rowIdList = ContentLocalServiceUtil.getRowIds(headId);
		for (int y = 1; y < table[0].length;y++){
			table[0][y]= (long) rowIdList.get(y-1);
			for (int x =1;x< table.length;x++)
				try {
					table[x][y] = ContentLocalServiceUtil.getContentIdByTableIds(Long.valueOf(table[0][y]).longValue(), Long.valueOf(table[x][0]).longValue());
				} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
		}
		
		return table;
	}
	
	public String[][] getTableAsArray(long headId){
		
		long [][] idTable = HeadLocalServiceUtil.getIdTableAsArray(headId);
		String[][] returnTable = new String[idTable.length][idTable[0].length];
		
		try {
			returnTable[0][0] = HeadLocalServiceUtil.getTableName(headId);
		} catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
		
		for (int y = 1; y < idTable[0].length;y++)
			returnTable[0][y]=Long.toString(idTable[0][y]);
		
		for (int x =1;x< idTable.length;x++)
			try {
				returnTable[x][0]= ColumnLocalServiceUtil.getColumn(idTable[x][0]).getColumn_name();
			} catch (PortalException | SystemException e) {e.printStackTrace();}
		
		for (int y = 1; y < idTable[0].length;y++){
			for (int x =1;x< idTable.length;x++)
				try {
					returnTable[x][y]= ContentLocalServiceUtil.getContentById(idTable[x][y]).getCellContent();
				} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
		}
		
		return returnTable;
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
	
	
	//update or build a new the head
	public Boolean updateHead (long headId, String tableName, String tableType){
		
		Boolean check = false;
		Head head = null;
		try {
			head = HeadLocalServiceUtil.getHead(headId);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (head == null){
			System.out.println("big null");
			try {
				head = HeadLocalServiceUtil.getHeadByTableName(tableName);
				
				// the tableName of a table must be unique
				if (head == null){
					System.out.println("small null");
					try {
						head = headPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
						head.setTable_name(tableName);
						head.setTable_type(tableType);
						try {
							super.updateHead(head);
							check = true;
						} catch (SystemException e) {e.printStackTrace();}
					} catch (SystemException e) {e.printStackTrace();}
				}else 
					check = false;
			} catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
		}else{
			if (head.getTable_name().equals(tableName.trim())){
				head.setTable_type(tableType);
				try {
					super.updateHead(head);
					check = true;
				} catch (SystemException e) {e.printStackTrace();}
			} else {
				//check to test, that the new table name is unique
				Head headCheck = null;
				try {
					headCheck = HeadLocalServiceUtil.getHeadByTableName(tableName);
				} catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
				if (headCheck == null){
					head.setTable_name(tableName);
					head.setTable_type(tableType);
					try {
						super.updateHead(head);
						check = true;
					} catch (SystemException e) {e.printStackTrace();}
				}else{
					check = false;
				}
			}
		}
		return check;
	}
	
	
	//update or build a new the head
	public Boolean updateHead (JSONObject json){
		
		Boolean check = false;
		String headKey ="headid";
		String tableNameKey = "table_name";
		String tableTypeKey = "table_type";
		if (json.containsKey(headKey) && json.containsKey(tableNameKey) && json.containsKey(tableTypeKey))
			check = HeadLocalServiceUtil.updateHead(Long.valueOf((String) json.get(headKey)).longValue(), (String) json.get(tableNameKey), (String) json.get(tableTypeKey));
		return check;
	}
	
	
	//update or build a new head and their columns
	public Boolean updateHeadWithColumns (JSONObject json){
		Boolean check = HeadLocalServiceUtil.updateHead(json);
		int i=0;
		while (json.containsKey(new Integer (i).toString())){
			JSONObject columnjson = (JSONObject) json.get(new Integer (i).toString());
			check = ColumnLocalServiceUtil.updateColumnWithContents(columnjson);
			i++;
		}
		return check;
	}
	
	
/*	//update or build a relation table 
	public Boolean updateRelationTable(long headId, String mtable, String ntable){

		Boolean check = true;
		mtable = mtable.trim();
		ntable = ntable.trim();
		
		
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
			
			JSONObject json = HeadLocalServiceUtil.constructHeadJson(headId, "gfbio_".concat(mtable).concat("_").concat(ntable), "relation");
			for (int i =0; i < 2 ;i++){
				Column column = null;
				column = ColumnLocalServiceUtil.getColumnsByHeadIdAndName(headId, mtable).get(0);
				json.put(i, value)
			}
			
			Column = ColumnLocalServiceUtil.getColumnsByHeadIdAndName(headId, mtable);
			json.put(1, .)
			check =HeadLocalServiceUtil.updateHead(json);
		}

		return check;
	}*/
		

	
	//update or build a new head with their columns and their contents
	@SuppressWarnings("unchecked")
	public Boolean updateTable (JSONObject json){
		
		Boolean check = HeadLocalServiceUtil.updateHead(json);
		int i=0;
		long rowId =0;
		while (json.containsKey(i)){
			JSONObject columnjson = (JSONObject) json.get(i);
/*			if (columnjson.containsKey("0")){
				JSONObject contentjson = (JSONObject) json.get(i);
				if ((long)contentjson.get("rowid")==0){
					if(rowId ==0)
						try {
							rowId= ContentLocalServiceUtil.constructNewId();
						} catch (SystemException e) {e.printStackTrace();}
					contentjson.remove("rowid");
					contentjson.put("rowid", rowId);
					columnjson.remove("0");
					columnjson.put("0", contentjson);
				}
			}*/
				
			check = ColumnLocalServiceUtil.updateColumnWithContents(columnjson);
			i++;
		}
		return check;
	}

}