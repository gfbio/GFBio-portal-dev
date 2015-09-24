package org.gfbio.tablebuilder;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.NoSuchHeadException;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TableBuilder extends GenericPortlet {
	

	protected String viewTemplate;
	private static Log _log = LogFactoryUtil.getLog(TableBuilder.class);

	
	//
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)	throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	

	//
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)	throws IOException, PortletException {
		
		//List <String> list = SubmissionRegistryLocalServiceUtil.getArchivePIdsOfENA("tENA01");
		//System.out.println("doView "+list.size());
		
		include(viewTemplate, renderRequest, renderResponse);
	}

	
	//
	public void init() {
		viewTemplate = getInitParameter("view-template");
	}
	

	//main method of ResourceRequests. All Requests goes over this method. The method-String in responseTarget include the aim method
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		System.out.println("start1");
		response.setContentType("text/html");
		
		if (request.getParameter("responseTarget") != null) {
			System.out.println("start2");
			
			//choose Table
			if ("chooseTableForRelationship".toString().equals(request.getParameter("responseTarget").toString()))
				chooseTable(request, response);
			
			//add new Column to a Head
			if ("addColumnToTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);			
			
			//delete Content
			if ("deleteContent".toString().equals(request.getParameter("responseTarget").toString()))
				deleteContent(request, response);
			
			//delete Column
			if ("deleteColumn".toString().equals(request.getParameter("responseTarget").toString()))
				deleteColumn(request, response);
			

			//delete Table
			if ("deleteTable".toString().equals(request.getParameter("responseTarget").toString()))
				deleteTable(request, response);
			
			//delete Content of a relationship
			if ("deleteRelationContent".toString().equals(request.getParameter("responseTarget").toString()))
				deleteRelationContent(request, response);
			
			//new Table
			if ("newTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);		

			//new Relationship between tables
			if ("relationTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateRelationTable(request, response);
									
			
			//new Relationship between contents
			if ("relationContent".toString().equals(request.getParameter("responseTarget").toString()))
				updateRelationContent(request, response);
			
			//new Content of a Table
			if ("updateContent".toString().equals(request.getParameter("responseTarget").toString())) 
				updateContent(request, response);
			
			//update Table
			if ("updateTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);
		
		}
	}
	
	
	/////////////////////////////////////////////// Choose Functions //////////////////////////////////////////////
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void chooseTable(ResourceRequest request, ResourceResponse response) throws IOException {
		System.out.println("start3");
		
		
		JSONParser parser = new JSONParser();
		JSONObject requestJson = new JSONObject();

		try {
			requestJson = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		
		long   rowId = (long) requestJson.get("rowid");
		long   headId1 = (long) requestJson.get("headid1");
		long   headId2 = extractLongOutOfString((String) requestJson.get("headid2"));

		List withoutRelationIdList =null;
		List withRelationIdList =null;
		JSONObject withoutJson = new JSONObject();
		JSONObject withJson = new JSONObject();


		
		try {
			withoutRelationIdList = ContentLocalServiceUtil.getContentIdsWithoutRelationships(rowId, HeadLocalServiceUtil.getTableName(headId1), HeadLocalServiceUtil.getTableName(headId2));
		} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		try {
			withRelationIdList = ContentLocalServiceUtil.getContentIdsWithRelationships(rowId, HeadLocalServiceUtil.getTableName(headId1), HeadLocalServiceUtil.getTableName(headId2));
		} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		
		if (withoutRelationIdList !=null)
			for (int i=0;i<withoutRelationIdList.size();i++){
				try {
					withoutJson.put(withoutRelationIdList.get(i), ContentLocalServiceUtil.getContent((long)withoutRelationIdList.get(i)).getCellContent() );
				} catch (PortalException | SystemException e) {e.printStackTrace();	}
			}
		
		if (withRelationIdList !=null)
			for (int i=0;i<withRelationIdList.size();i++)
				try {
					withJson.put(withRelationIdList.get(i), ContentLocalServiceUtil.getContent((long)withRelationIdList.get(i)).getCellContent() );
				} catch (PortalException | SystemException e) {e.printStackTrace();	}
			
		
		
		
		JSONObject responseJson = new JSONObject();
		responseJson.put("withoutRelationIdList", withoutRelationIdList);
		responseJson.put("withRelationIdList", withRelationIdList);
		responseJson.put("withoutJson", withoutJson);
		responseJson.put("withJson", withJson);
		System.out.println(responseJson.toString());
	

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

	}
	
	
	///////////////////////////////////// Delete Functions ///////////////////////////////////////////////////
	
	
	//
	public void deleteContent (ResourceRequest request, ResourceResponse response){
		
		ContentLocalServiceUtil.deleteContentsByRowId(Long.valueOf(request.getParameter("data").substring(1, request.getParameter("data").length()-1)).longValue());
	}
	
	
	//
	public void deleteColumn (ResourceRequest request, ResourceResponse response){
		
		long columnId = Long.valueOf(request.getParameter("data").substring(1, request.getParameter("data").length()-1)).longValue();
		System.out.println(columnId);
		ContentLocalServiceUtil.deleteContentsByColumnId(columnId);
		ColumnLocalServiceUtil.deleteColumnById(columnId); 
	}
	
	
	//
	public void deleteTable (ResourceRequest request, ResourceResponse response){
		System.out.println("deleteTable: "+request.getParameter("data"));
		String headIdString = request.getParameter("data");
		if(headIdString.charAt(0)=='"')
			HeadLocalServiceUtil.deleteTableByHeadId(Long.valueOf(headIdString.substring(1,headIdString.length()-1)).longValue());
		else
			HeadLocalServiceUtil.deleteTableByHeadId(Long.valueOf(headIdString).longValue());
	}
	
	
	//
	public void deleteRelationContent (ResourceRequest request, ResourceResponse response){
		
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		String cellContent1 = null;
		String cellContent2 = null;
		cellContent1 = Long.toString(ContentLocalServiceUtil.getRowIdById(ContentLocalServiceUtil.getFirstContentIdByRowId((long) json.get("rowid"))));
		cellContent2 = Long.toString(ContentLocalServiceUtil.getRowIdById(Long.valueOf((String) json.get("contentid")).longValue()));
		
		long rowId = ContentLocalServiceUtil.getRowIdOfRelation(cellContent1, cellContent2);
		ContentLocalServiceUtil.deleteContentsByRowId(rowId);
	}


	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////////
		
		
	//
	private long extractLongOutOfString (String string){
	while (string.charAt(0)=='"')
	string = string.substring(1, string.length()-1);
	return Long.valueOf(string).longValue();
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//
	@SuppressWarnings("unused")
	public void updateContent(ResourceRequest request, ResourceResponse response)  {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		Boolean check = false;
		check = HeadLocalServiceUtil.updateHeadWithColumns(json);

	}
	
	
	//
	public Boolean updateRelationContent(ResourceRequest request, ResourceResponse response){
		
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		
		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		System.out.println(json.toString());
		
		long headId1=0;
		try {
			headId1 = HeadLocalServiceUtil.getHeadIdByTableName((String) json.get("tablename"));
		} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
		long contentId1 = ContentLocalServiceUtil.getFirstContentIdByRowId((long) json.get("rowid"));
		long contentId2 = Long.valueOf((String) json.get("contentid"));
		long headId2 = ContentLocalServiceUtil.getHeadIdById(contentId2);
		
		System.out.println(headId1+ " | "+ headId2+ " | "+contentId1+ " | "+contentId2);
		
		return HeadLocalServiceUtil.updateRelationTableWithContent(headId1, headId2, contentId1, contentId2);
		
	}
	
	
	//
	public void updateRelationTable(ResourceRequest request, ResourceResponse response)  {
	
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		System.out.println("json: "+ (String) json.get("mtable")+ " |"+ (String) json.get("ntable"));
		Boolean check;
		check = HeadLocalServiceUtil.updateRelationTable(0, (String) json.get("mtable"), (String) json.get("ntable"));
		System.out.println("new connection: "+check);

	}
	
	

	//
	public void updateTable(ResourceRequest request, ResourceResponse response) {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		
		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		System.out.println(json.toJSONString());
		Boolean check = HeadLocalServiceUtil.updateHeadWithColumns(json);
		System.out.println("update Table: "+check);
	}

	

	








}