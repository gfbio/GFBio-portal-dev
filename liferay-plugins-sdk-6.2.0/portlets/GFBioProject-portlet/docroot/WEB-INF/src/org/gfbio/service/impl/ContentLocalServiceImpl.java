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

import org.gfbio.NoSuchContentException;
import org.gfbio.model.Content;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.base.ContentLocalServiceBaseImpl;
import org.gfbio.service.persistence.ContentFinderUtil;
import org.json.simple.JSONObject;

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

	@SuppressWarnings("unchecked")
	public JSONObject constructColumnJson(long contentId, long headId, long columnId, long rowId, String cellContent){
		JSONObject json = new JSONObject();
		json.put("contentid", contentId);
		json.put("headid", headId);
		json.put("columnid", columnId);
		json.put("rowid", rowId);
		json.put("cellcontent", cellContent);
		return json;
	}
	
	
	//delete content 
	public void deleteContentById (long contentId)  {
		try {
			ContentLocalServiceUtil.deleteContent(contentId);
		} catch (PortalException | SystemException e) {e.printStackTrace();	}
	}

	
	//delete contents of a specific column
	public void deleteContentsByColumnId (long columnId){
		
		List <Content> contentList = null;
		try {
			contentList = ContentLocalServiceUtil.getContentsByColumnId(columnId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null)
			for (int i =0; i < contentList.size();i++)
				ContentLocalServiceUtil.deleteContentById(contentList.get(i).getRowID());
	}
	
	
	//delete cells/relations of contents
	public void deleteContentsByHeadId(long headId) throws SystemException{
		List <Content> contentList = ContentLocalServiceUtil.getContentsByHeadId(headId);
		for (int i =0; i<contentList.size();i++){
			ContentLocalServiceUtil.deleteContentById(contentList.get(i).getContentID());
		}
	}
	
	
	//delete contents of a specific row
	public void deleteContentsByRowId (long rowId){
		
		List <Content> contentList = null;
		try {
			contentList = ContentLocalServiceUtil.getContentsByRowId(rowId);
		} catch (SystemException e) {e.printStackTrace();}
		
		if (contentList != null)
			for (int i =0; i < contentList.size();i++)
				ContentLocalServiceUtil.deleteContentById(contentList.get(i).getRowID());
	}
	
	
	//get a content object by the content id
	public Content getContentById(long contentId) throws NoSuchContentException, SystemException {
		return contentPersistence.findByContentId(contentId);
	}	
			
	
	//get a List of contents of a specific head
	public List<Content> getContentsByColumnId(long columnId) throws SystemException {
		return contentPersistence.findByColumnId(columnId);
	}
	
	
	//get a List of contents of a specific head
	public List<Content> getContentsByHeadId(long headId) throws SystemException {
		return contentPersistence.findByHeadId(headId);
	}
	
	
	// get a List of Contents with a specific content in a specific column
	public List<Content> getContentsByRowId(long rowId) throws SystemException{
		return contentPersistence.findByRowId(rowId);
	}
	
	
	//get Content of a Cell in a specific row and column
	public String getCellContentByTableIds(long rowId, long columnId)  {
		try {
			return contentPersistence.findByTableIds(columnId, rowId).getCellContent();
		} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
		return null;
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

	
	public JSONObject getContentInformationAsJSONBycontentId (long contentId){
		
		JSONObject json = new JSONObject();
		Content content = null;
		try {
			content = ContentLocalServiceUtil.getContentById(contentId);
		} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
		if (content != null)
			json = ContentLocalServiceUtil.constructColumnJson(content.getContentID(), content.getHeadID(), content.getColumnID(), content.getRowID(), content.getCellContent());
		return json;
	}
	
	
	//get the basic Information of the Contents of a specific row as JSON
	@SuppressWarnings("unchecked")
	public JSONObject getContentInformationAsJSONByRowId (long rowId){
	
		JSONObject json = new JSONObject();
		List <Content> contentList = null;
		
		try {
			contentList = ContentLocalServiceUtil.getContentsByRowId(rowId);
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
			contentList = ContentLocalServiceUtil.getContentsByRowId(rowId);
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
	
	public int getCountOfRows(long headId) throws SystemException{
		int count =0;
		List list = ContentLocalServiceUtil.getRowIds(headId);
		if (list != null)
			count = list.size();
		else
			count = 0;
		return count;
	}
	
	
	//get a List of rowIds of specific head
	public List  getRowIds (long headId){
		return ContentFinderUtil.getRowIds(headId);
	}
	
		
	// get the columnId of a specific content.
	public long getColumnIdById(long contentId) throws SystemException, PortalException{
		return ContentLocalServiceUtil.getContent(contentId).getColumnID();
	}
	
	
	// get a List of Contents with a specific content
	public List<Content> getContentsByContent(String cellContent) throws SystemException{
		return contentPersistence.findByCellContent(cellContent);
	}
	
	
	// get a List of Contents with a specific content in a specific column
	public List<Content> getContentsByContentOfColumn(String cellContent, long columnId) throws SystemException{
		return contentPersistence.findByCellContentOfColumn(cellContent, columnId);
	}
	
	
	// get the columnId of a specific content.
	public long getRowIdById(long contentId) throws SystemException, PortalException{
		return ContentLocalServiceUtil.getContent(contentId).getRowID();
	}

		
	//update or build a new the content
	public Boolean updateContent (long contentId, long headId, long columnId, long rowId, String cellContent){
		
		Boolean check = false;
		Content content = null;

		try {
			content = ContentLocalServiceUtil.getContent(contentId);
		} catch (PortalException | SystemException e) {e.printStackTrace();	}

		// if it true, then must be build a new content with a new primary keay else update the content
		if (content == null)
			try {
				content = contentPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			} catch (SystemException e) {e.printStackTrace();}
		if (rowId ==0)
			try {
				rowId= constructNewId();
			} catch (SystemException e1) {e1.printStackTrace();}
		content.setHeadID(headId);
		content.setColumnID(columnId);
		content.setHeadID(rowId);
		content.setCellContent(cellContent);
		try {
			super.updateContent(content);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	public long constructNewId() throws SystemException{
		return contentPersistence.create(CounterLocalServiceUtil.increment(getModelClassName())).getContentID();
	}
	
	
	//update or build a new the content with a json as input
	public Boolean updateContent (JSONObject json){
		
		
		Boolean check = false;
		String contentIdKey ="contentid";
		String headKey ="headid";
		String columnKey ="columnid";
		String rowKey = "rowid";
		String contentKey = "cellcontent";
		if (json.containsKey(contentKey) && json.containsKey(headKey) && json.containsKey(columnKey) && json.containsKey(rowKey) && json.containsKey(contentKey))
			check = ContentLocalServiceUtil.updateContent(Long.valueOf((String) json.get(contentIdKey)).longValue(), Long.valueOf((String) json.get(headKey)).longValue(), Long.valueOf((String) json.get(columnKey)).longValue(), Long.valueOf((String) json.get(rowKey)).longValue(), (String) json.get(contentKey));
		return check;
	}
	
}