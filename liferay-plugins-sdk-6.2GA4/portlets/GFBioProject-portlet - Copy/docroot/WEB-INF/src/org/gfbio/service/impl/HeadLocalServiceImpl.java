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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchContentException;
import org.gfbio.model.Column;
import org.gfbio.model.Head;
import org.gfbio.model.Content;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.base.HeadLocalServiceBaseImpl;
import org.gfbio.service.persistence.HeadFinderUtil;
import org.json.simple.JSONArray;
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
	
	
	///////////////////////////////////// Delete Functions ///////////////////////////////////////////////////
	
	
	//delete a table/entity (head, column and content) an their relations
	@SuppressWarnings("rawtypes")
	public void deleteTableByHeadId(long headId){
		
		Boolean check=false;
		try {
			check = ColumnLocalServiceUtil.checkHaveTableRelationsById(headId);
		} catch (NoSuchHeadException | SystemException e2) {e2.printStackTrace();}
		
		if (check){
			String tableName="";
			try {
				tableName = getTableNameById(headId);
			} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
			List relationList = ColumnLocalServiceUtil.getHeadIdsByColumnName(tableName);
			for (int i=0; i <relationList.size();i++)
				deleteTableByHeadIdWithoutCheck((long)relationList.get(i));
		}
		deleteTableByHeadIdWithoutCheck(headId);
	}
	
	
	//delete a table/entity (head, column and content) 
	public void deleteTableByHeadIdWithoutCheck(long headId){
		
		try {
			ContentLocalServiceUtil.deleteContentsByHeadId(headId);
		} catch (SystemException e1) {e1.printStackTrace();	}
		ColumnLocalServiceUtil.deleteColumnsByHeadId(headId);
		try {
			deleteHead(headId);
		} catch (PortalException | SystemException e) {e.printStackTrace();}
	}
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getTableNamesByTableType(JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		if (requestJson.containsKey("tabletype"))
			responseJson = getTableNamesByTableType((String) requestJson.get("tabletype"));
		else
			responseJson.add("ERROR: The json need minimal 'tabletype' as String.");
		return responseJson;
		
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
		
		
	//get Table_names of a List of heads selected by TableType
	public String[] getArrayOfTableNames(String tableType){
		
		List <Head> headList = null;
		String[] names =null;
			try {
			headList = getHeadsByTableType(tableType);
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
			contentList = contentPersistence.findByHeadId(headId);
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
	
	
	//get the Entities that have a relation to a specific headId
	@SuppressWarnings("rawtypes")
	public List getEntitiesByHeadId(long headId) {
		return HeadFinderUtil.getEntitiesByHeadId(headId);
	}
	

	//get ID of a head by tableName
	@SuppressWarnings("rawtypes")
	public Long getHeadIdByTableName(String tableName) throws NoSuchHeadException, SystemException {
		Long headId =(long) 0;
		List headIdList = HeadFinderUtil.getHeadIdByTableName(tableName);
		if (headIdList.size() >0)
			headId = (Long) headIdList.get(0);
		return headId;
	}
	
	
	//get all heads with a specific table type
	public List<Head> getHeadsByTableType(String tableType) throws SystemException {
		return headPersistence.findByTableType(tableType);
	}
	
		
	//get content of a specific entity in a TableArray
	@SuppressWarnings("rawtypes")
	public long[][] getIdTableAsArray(long headId){
		
		long[][] table = null;
		try {table = new long[((ColumnLocalServiceUtil.getCountofColumns(headId))+1)][(ContentLocalServiceUtil.getCountOfRows(headId)+1)];}
		catch (SystemException e) {e.printStackTrace();}
			
		//head of table
		table[0][0]= headId;
		List<Column> columnList = null;
		try {columnList = columnPersistence.findByHeadId(headId);}
		catch (SystemException e1) {e1.printStackTrace();}
		
		for (int x =0; x < columnList.size();x++)
			table[x+1][0]= columnList.get(x).getColumnID();
		
		//body of table
		List rowIdList = ContentLocalServiceUtil.getRowIds(headId);
		for (int y = 1; y < table[0].length;y++){
			table[0][y]= (long) rowIdList.get(y-1);
			for (int x =1;x< table.length;x++)
				try {table[x][y] = ContentLocalServiceUtil.getContentIdByTableIds(Long.valueOf(table[0][y]).longValue(), Long.valueOf(table[x][0]).longValue());}
				catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
		}
		
		return table;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = HeadFinderUtil.getMaxId();
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
	}
	
	
	//get IDs  of a specific entity in a TableArray
	public String[][] getTableAsArray(long headId){
		
		long [][] idTable = getIdTableAsArray(headId);
		String[][] returnTable = new String[idTable.length][idTable[0].length];
		
		try {
			returnTable[0][0] = getTableNameById(headId);
		} catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}

		for (int y = 1; y < idTable[0].length;y++)
			returnTable[0][y]=Long.toString(idTable[0][y]);
		
		for (int x =1;x< idTable.length;x++)
			returnTable[x][0]= ColumnLocalServiceUtil.getColumnNameById(idTable[x][0]);
		
		for (int y = 1; y < idTable[0].length;y++)
			for (int x =1;x< idTable.length;x++)
				try {returnTable[x][y]= contentPersistence.findByContentId(idTable[x][y]).getCellContent();}
				catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
			
		return returnTable;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getTableAsJSONArrayByName(JSONObject requestJson){

		JSONArray responseJson = new JSONArray();
		if (requestJson.containsKey("tablename"))
			try {responseJson = getTableAsJSONArray(getHeadIdByTableName((String)requestJson.get("tablename")));} 
			catch (NoSuchHeadException | SystemException e) {responseJson.add("ERROR: No key table with tablename '"+(String)requestJson.get("tablename")+"' exist.");}
		else
			responseJson.add("ERROR: No key 'tablename' exist.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	public JSONArray getTableAsJSONArray(long headId){
		
		JSONArray responseJson = new JSONArray();
		List <Long> rowList= ContentLocalServiceUtil.getRowIds(headId);
		int rowCount =0;
		
		try {rowCount = ContentLocalServiceUtil.getCountOfRows(headId);}
		catch (SystemException e) {e.printStackTrace();}
		for (int i=0; i < rowCount;i++)
			responseJson.add(ContentLocalServiceUtil.getRowInformationById(rowList.get(i)));

		return responseJson;
	}
	
	
	//get an Array of TableNames with a specific table type
	public String[] getTableNameArray(String tableType) throws SystemException  {

		List<Head> headList;
		if (tableType.equals(""))
			headList = null;
		else
			headList = getHeadsByTableType(tableType);
		return getTableNameArray(headList);
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
	
	
	//get tableName of a specific head  
	@SuppressWarnings("rawtypes")
	public String getTableNameById(long headId) throws NoSuchHeadException, SystemException {
		String name ="";
		List nameList =  HeadFinderUtil.getTableNameById(headId);
		if (nameList.size()>0)
			name =  (String) nameList.get(0);
		return name;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public JSONArray getTableNamesByTableType(String tableType){
		
		JSONArray responseJson = new JSONArray();;
		List responseList = (ArrayList)	HeadFinderUtil.getTableNamesByTableType(tableType);
		for(int i=0; i< responseList.size();i++)
			responseJson.add(responseList.get(i));

		return responseJson;
	}
	
		
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	
	//construt a JSON with  the head attributs
	@SuppressWarnings("unchecked")
	public JSONObject constructHeadJson(Head head){
		JSONObject json = new JSONObject();
		json.put("headid", head.getHeadID());
		json.put("table_name", head.getTable_name());
		json.put("table_type", head.getTable_type());
		json.put("lastmodifieddate", head.getLastModifiedDate());
		return json;
	}
	
	
	
	//construt a JSON with  the head attributs
	@SuppressWarnings("unchecked")
	public JSONObject constructHeadJson(long headId, String tableName, String tableType, Date lastModifiedDate){
		JSONObject json = new JSONObject();
		json.put("headid", Long.toString(headId));
		json.put("table_name", tableName);
		json.put("table_type", tableType);
		json.put("lastmodifieddate", lastModifiedDate);
		return json;
	}
	
	
	//construct the relation name (String) of two entity names
	public String constructRelationName(String mtable, String ntable){
		mtable = mtable.trim();
		ntable = ntable.trim();
		List <String> tableNames = new ArrayList<String>();
		tableNames.add(mtable);
		tableNames.add(ntable);
		Collections.sort(tableNames);
		mtable = tableNames.get(0).substring(6);
		ntable = tableNames.get(1).substring(6);
		
		return "gfbio_".concat(mtable).concat("_").concat(ntable);
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
	
	
	//update or build a new the head
	public Boolean updateHead (long headId, String tableName, String tableType){
		Boolean check = false;
		Head head = null;
		try {head = getHead(headId);}
		catch (PortalException | SystemException e1) {System.out.println("No Head exists with the primary key "+headId);}

		if (head == null){
			try {head = headPersistence.findByTableName(tableName);}
			catch (NoSuchHeadException | SystemException e1) {System.out.println("No Head exists with the primary key "+headId);}
			
			// the tableName of a table must be unique
			if (head == null){
				try {
					head = headPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
					head.setTable_name(tableName);
					head.setTable_type(tableType);
					head.setLastModifiedDate(new Timestamp(new Date().getTime()));
					try {
						super.updateHead(head);
						check = true;
					}
					catch (SystemException e) {e.printStackTrace();}
				} 
				catch (SystemException e) {e.printStackTrace();}
				
				if(tableType.equals("entity"))
					ColumnLocalServiceUtil.updateColumn(0,head.getHeadID(),"id");
					ColumnLocalServiceUtil.updateColumn(0,head.getHeadID(),"lastmodifieddate");
				
				
			}else 
				check = false;
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
				try {headCheck = headPersistence.findByTableName(tableName);}
				catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
				if (headCheck == null){
					head.setTable_name(tableName);
					head.setTable_type(tableType);
					head.setLastModifiedDate(new Timestamp(new Date().getTime()));
					try {
						super.updateHead(head);
						check = true;
					} 
					catch (SystemException e) {e.printStackTrace();}
				}else
					check = false;
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
			check = updateHead(Long.valueOf((String) json.get(headKey)).longValue(), (String) json.get(tableNameKey), (String) json.get(tableTypeKey));
		return check;
	}
	
	
	//update or build a new the head
	public long updateHeadWithLongRequest (JSONObject json){
		
		long headid =0;
		String headKey ="headid";
		String tableNameKey = "table_name";
		String tableTypeKey = "table_type";
		if (json.containsKey(headKey) && json.containsKey(tableNameKey) && json.containsKey(tableTypeKey))
			headid = updateHeadWithLongRequest(Long.valueOf((String) json.get(headKey)).longValue(), (String) json.get(tableNameKey), (String) json.get(tableTypeKey));
		return headid;
	}
	
	//update or build a new the head
	public long updateHeadWithLongRequest (long headId, String tableName, String tableType){
		
		long id=0;
		Head head = null;
		try {head = getHead(headId);} 
		catch (PortalException | SystemException e1) {System.out.println("No Head exists with the primary key "+headId);}

		if (head == null){
			try {head = headPersistence.findByTableName(tableName);	}
			catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
			
			// the tableName of a table must be unique
			if (head == null){
				try {
					head = headPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
					head.setTable_name(tableName);
					head.setTable_type(tableType);
					head.setLastModifiedDate(new Timestamp(new Date().getTime()));
					try {
						super.updateHead(head);
						id = head.getHeadID();
					} catch (SystemException e) {e.printStackTrace();}
				} catch (SystemException e) {e.printStackTrace();}
			}else 
				id =0;
		}else{
			if (head.getTable_name().equals(tableName.trim())){
				head.setTable_type(tableType);
				head.setLastModifiedDate(new Timestamp(new Date().getTime()));
				try {
					super.updateHead(head);
					id = head.getHeadID();
				} catch (SystemException e) {e.printStackTrace();}
			} else {
				//check to test, that the new table name is unique
				Head headCheck = null;
				try {
					headCheck = headPersistence.findByTableName(tableName);
				} catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}
				if (headCheck == null){
					head.setTable_name(tableName);
					head.setTable_type(tableType);
					head.setLastModifiedDate(new Timestamp(new Date().getTime()));
					try {
						super.updateHead(head);
						id = head.getHeadID();
					} catch (SystemException e) {e.printStackTrace();}
				}else
					id = 0;
			}
		}
		if (head != null) 
			id = head.getHeadID(); 

		return id;
	}
	
	
	//update or build a new head and their columns and contents
	@SuppressWarnings("unchecked")
	public Boolean updateHeadWithColumns (JSONObject json){

		Boolean check = updateHead(json);
		long headid = updateHeadWithLongRequest(json);
		int i=0;
		long rowId = 0;
		long tsContentId=0;
		JSONArray futureResponseJson = new JSONArray();

		while (json.containsKey(new Integer (i).toString())){
			JSONObject columnjson = (JSONObject) json.get(new Integer (i).toString());
			columnjson.remove("headid");
			columnjson.put("headid", Long.toString(headid));

			if (columnjson.containsKey("0")){
				JSONObject contentJson = (JSONObject) columnjson.get("0");
				if (rowId==0){
					if (((String)contentJson.get("rowid")).equals("0"))
						rowId= ContentLocalServiceUtil.constructNewId();
					else
						rowId = Long.valueOf((String)contentJson.get("rowid"));
				}
				contentJson.remove("rowid");
				contentJson.put("rowid", Long.toString(rowId));
				if (tsContentId !=0){
					contentJson.put("tscontentid", tsContentId);
				}
				contentJson.remove("headid");
				contentJson.put("headid", Long.toString(headid));
				columnjson.remove("0");
				columnjson.put("0", contentJson);
			}
			futureResponseJson =  ColumnLocalServiceUtil.updateColumnWithContents(columnjson);
			if (futureResponseJson.size()>0){
				tsContentId = (long) ((JSONArray) futureResponseJson.get(0)).get(1);
				check= true;
			}else
				check = false;
			i++;
		}
		return check;
	}
	
	
	//update or build a new head and their columns and contents
	@SuppressWarnings("unchecked")
	public Boolean updateHeadWithColumns2 (JSONObject json){

		Boolean check = updateHead(json);
		long headid = updateHeadWithLongRequest(json);
		int i=0;
		long rowId = 0;
		long tsContentId=0;
		JSONArray futureResponseJson = new JSONArray();
		
		while (json.containsKey(new Integer (i).toString()) &&check){
			JSONObject columnJson = (JSONObject) json.get(new Integer (i).toString());
			columnJson.remove("headid");
			columnJson.put("headid", Long.toString(headid));

			if (columnJson.containsKey("0")){
				JSONObject contentJson = (JSONObject) columnJson.get("0");
				if (rowId==0)
					if (((long)contentJson.get("rowid"))==0)
						rowId= ContentLocalServiceUtil.constructNewId();
					else
						rowId = (long)contentJson.get("rowid");
				contentJson.remove("rowid");
				contentJson.put("rowid", Long.toString(rowId));
				
				if (tsContentId !=0){
					contentJson.put("tscontentid", tsContentId);
				}
				
				contentJson.remove("headid");
				contentJson.put("headid", Long.toString(headid));
				columnJson.remove("0");
				columnJson.put("0", contentJson);
				
				
			}
			futureResponseJson = ColumnLocalServiceUtil.updateColumnWithContents2(columnJson);
			if (futureResponseJson.size()>0){
				tsContentId = (long) ((JSONArray) futureResponseJson.get(0)).get(1);
				check= true;
			}else
				check = false;
			i++;
		}
		return check;
	}
	
	//update or build a relation table 
	@SuppressWarnings("unchecked")
	public Boolean updateParentRelationTable(long headId, String tableName){

		Boolean check = true;
		if (headId == 0){
			JSONObject json = constructHeadJson(headId,  tableName.concat("parent"), "parentrelationship", new Timestamp(new Date().getTime()));
			json.put(new Integer (0).toString(), ColumnLocalServiceUtil.constructColumnJson(0, headId, tableName, new Timestamp(new Date().getTime())));
			json.put(new Integer (1).toString(), ColumnLocalServiceUtil.constructColumnJson(0, headId, "parent", new Timestamp(new Date().getTime())));
			check =updateHeadWithColumns(json);
		}else
			check = false;

		return check;
	}
	
	
	//update or build a relation table with content -> build a relationship
	@SuppressWarnings("unchecked")
	public Boolean updateParentRelationTableWithContent(long headIdOfColumn, long contentId1, long contentId2){
		
		Boolean check = true;
		long headId =0;
		String tableName ="";
		try {tableName = getTableNameById(headIdOfColumn).concat("parent");}
		catch (NoSuchHeadException | SystemException e1) {e1.printStackTrace();}

		try {headId = getHeadIdByTableName(tableName);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}
		
		JSONObject json = constructHeadJson(headId, tableName, "parentrelationship", new Timestamp(new Date().getTime()));
		JSONObject jsonColumn1 = null;
		JSONObject jsonColumn2 = null;
		JSONObject jsonContent1 = null;
		JSONObject jsonContent2 = null;
		
		try {jsonColumn1 = ColumnLocalServiceUtil.constructColumnJson(columnPersistence.findByHeadIdAndColumnName(headId, getTableNameById(headIdOfColumn)).get(0).getColumnID(), headId, getTableNameById(headIdOfColumn), new Timestamp(new Date().getTime()));}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}
		try {jsonColumn2 = ColumnLocalServiceUtil.constructColumnJson(columnPersistence.findByHeadIdAndColumnName(headId, "parent").get(0).getColumnID(), headId, "parent", new Timestamp(new Date().getTime()));}
		catch (SystemException e) {e.printStackTrace();	}

		try {jsonContent1 = ContentLocalServiceUtil.constructContentJson(0, headId, columnPersistence.findByHeadIdAndColumnName(headId, getTableNameById(headIdOfColumn)).get(0).getColumnID(), 0, Long.toString(ContentLocalServiceUtil.getRowIdById(contentId1)), new Timestamp(new Date().getTime()));}
		catch (SystemException | PortalException e) {e.printStackTrace();	}
		
		try {jsonContent2 = ContentLocalServiceUtil.constructContentJson(0, headId, columnPersistence.findByHeadIdAndColumnName(headId, "parent").get(0).getColumnID(), 0, Long.toString(ContentLocalServiceUtil.getRowIdById(contentId2)), new Timestamp(new Date().getTime()));}
		catch (SystemException e) {e.printStackTrace();	}

		jsonColumn1.put("0", jsonContent1);
		jsonColumn2.put("0", jsonContent2);
		json.put("0", jsonColumn1);
		json.put("1", jsonColumn2);
		
		check =updateHeadWithColumns2(json);
		
		return check;
	}
	
	
	//update or build a relation table 
	@SuppressWarnings("unchecked")
	public Boolean updateRelationTable(long headId, String mtable, String ntable){

		Boolean check = true;
		if (headId == 0){
			
			mtable = mtable.trim();
			ntable = ntable.trim();
			List <String> tableNames = new ArrayList<String>();
			
			tableNames.add(mtable);
			tableNames.add(ntable);
			Collections.sort(tableNames);
				
			JSONObject json = constructHeadJson(headId, constructRelationName(mtable, ntable), "relationship", new Timestamp(new Date().getTime()));
			for (int i =0; i < 2 ;i++)
				json.put(new Integer (i).toString(), ColumnLocalServiceUtil.constructColumnJson(0, headId, tableNames.get(i), new Timestamp(new Date().getTime())));
			check =updateHeadWithColumns(json);
		}else
			check = false;

		return check;
	}
	
	
	
	//update or build a relation table with content -> build a relationship
	@SuppressWarnings("unchecked")
	public Boolean updateRelationTableWithContent(long headId1, long headId2, long contentId1, long contentId2){
		
		Boolean check = true;
		long headId =0;
		String tableName="";

		try {tableName = constructRelationName(getTableNameById(headId1), getTableNameById(headId2));}
		catch (NoSuchHeadException | SystemException e1) {System.out.println("No Head exists with the primary key "+headId);}

		try {	headId = getHeadIdByTableName(tableName);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}
		
		JSONObject json = constructHeadJson(headId, tableName, "relationship", new Timestamp(new Date().getTime()));
		JSONObject jsonColumn1 = null;
		JSONObject jsonColumn2 = null;
		JSONObject jsonContent1 = null;
		JSONObject jsonContent2 = null;
		
		try {
			jsonColumn1 = ColumnLocalServiceUtil.constructColumnJson(columnPersistence.findByHeadIdAndColumnName(headId, getTableNameById(headId1)).get(0).getColumnID(), headId, getTableNameById(headId1), new Timestamp(new Date().getTime()));
			jsonColumn2 = ColumnLocalServiceUtil.constructColumnJson(columnPersistence.findByHeadIdAndColumnName(headId, getTableNameById(headId2)).get(0).getColumnID(), headId, getTableNameById(headId2), new Timestamp(new Date().getTime()));
		}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}

		
		try {
			jsonContent1 = ContentLocalServiceUtil.constructContentJson(0, headId1, columnPersistence.findByHeadIdAndColumnName(headId, getTableNameById(headId1)).get(0).getColumnID(), 0, Long.toString(ContentLocalServiceUtil.getRowIdById(contentId1)), new Timestamp(new Date().getTime()));
			jsonContent2 = ContentLocalServiceUtil.constructContentJson(0, headId2, columnPersistence.findByHeadIdAndColumnName(headId, getTableNameById(headId2)).get(0).getColumnID(), 0, Long.toString(ContentLocalServiceUtil.getRowIdById(contentId2)), new Timestamp(new Date().getTime()));
		} 
		catch (SystemException | PortalException e) {e.printStackTrace();	}

		jsonColumn1.put("0", jsonContent1);
		jsonColumn2.put("0", jsonContent2);
		json.put("0", jsonColumn1);
		json.put("1", jsonColumn2);
		
		check =updateHeadWithColumns2(json);
		
		return check;
	}
	
	
	//update or build a new head with their columns and their contents
	public Boolean updateTable (JSONObject json){
		
		Boolean check = updateHead(json);
		int i=0;
		JSONArray futureResponseJson = new JSONArray();
		while (json.containsKey(i)){
			JSONObject columnjson = (JSONObject) json.get(i);
			futureResponseJson = ColumnLocalServiceUtil.updateColumnWithContents(columnjson);
			if (futureResponseJson.size()>0){
				check= true;
			}else
				check = false;
			i++;
		}
		return check;
	}
	
	
	//update or build a relation table with content -> build a relationship
	@SuppressWarnings("unchecked")
	public Boolean updateInterfaceTableWithContent(String nonHccTableName, long nonHccContentId, String hccTableName, long hccContentId){

		Boolean check = false;
		long headId =0;
		String tableName="";

		tableName = constructRelationName(nonHccTableName, hccTableName);
		
		try {headId = getHeadIdByTableName(tableName);}
		catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}

		check = ContentLocalServiceUtil.checkKeyPairInRelationship(headId,  Long.toString(nonHccContentId),  Long.toString(hccContentId));
		
		if (check){
			JSONObject json = constructHeadJson(headId, tableName, "relationship",new Timestamp(new Date().getTime()));
			JSONObject jsonColumn1 = null;
			JSONObject jsonColumn2 = null;
			JSONObject jsonContent1 = null;
			JSONObject jsonContent2 = null;
			
			
			jsonColumn1 = ColumnLocalServiceUtil.constructColumnJson(ColumnLocalServiceUtil.getColumnIdByNames(tableName, nonHccTableName), headId, nonHccTableName, new Timestamp(new Date().getTime()));
			jsonColumn2 = ColumnLocalServiceUtil.constructColumnJson(ColumnLocalServiceUtil.getColumnIdByNames(tableName, hccTableName), headId, hccTableName, new Timestamp(new Date().getTime()));
			
			try {jsonContent1 = ContentLocalServiceUtil.constructContentJson(0, getHeadIdByTableName(nonHccTableName), ColumnLocalServiceUtil.getColumnIdByNames(tableName, nonHccTableName), 0, Long.toString(nonHccContentId), new Timestamp(new Date().getTime()));} 
			catch (SystemException | PortalException e) {e.printStackTrace();	}
			try {jsonContent2 = ContentLocalServiceUtil.constructContentJson(0, getHeadIdByTableName(hccTableName), ColumnLocalServiceUtil.getColumnIdByNames(tableName, hccTableName), 0, Long.toString(hccContentId), new Timestamp(new Date().getTime()));} 
			catch (SystemException | PortalException e) {e.printStackTrace();	}
			
			jsonColumn1.put("0", jsonContent1);
			jsonColumn2.put("0", jsonContent2);
			json.put("0", jsonColumn1);
			json.put("1", jsonColumn2);
			
			check =updateHeadWithColumns2(json);
		}
		return check;
	}

}