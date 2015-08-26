package org.gfbio.tablebuilder;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;



import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TableBuilder extends GenericPortlet {

	protected String viewTemplate;
	private static Log _log = LogFactoryUtil.getLog(TableBuilder.class);

	
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)	throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)	throws IOException, PortletException {

		/*System.out.println("---|1|---");
		System.out.println("---|1|---");
		System.out.println("---|1|---");
		System.out.println("---|1|---");
		List<Head> headList= null;
		headList = HeadLocalServiceUtil.getHeadBetweenHeadId(0, 3);
		if (headList !=null)
			for (int i = 0; i < headList.size();i++)
				System.out.println(headList.get(i).getTable_name());
		else
			System.out.println("");
		System.out.println("---|2|---");
		System.out.println("---|2|---");
		System.out.println("---|2|---");
		System.out.println("---|2|---");
		Head head = null;
		Column column = null;
		Content position = null;
		List list = HeadLocalServiceUtil.getEntitiesByHeadId(1);
		
		if (list !=null){
			System.out.println(list.size());
			for (int i = 0; i < list.size();i++){
				Object[] arrayobject = (Object[]) list.get(i);
		       	head=(Head)arrayobject[0];
		       	column=(Column)arrayobject[1];
		       position =(Content)arrayobject[2];
		       	     	System.out.println(head.getTable_name() + " | " + column.getColumn_name() + " | " + position.getContent());
			}
		}
		else
			System.out.println("");
		System.out.println("---|3|---");
		System.out.println("---|3|---");
		System.out.println("---|3|---");
		System.out.println("---|3|---");*/

		
		include(viewTemplate, renderRequest, renderResponse);
	}

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}
	

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		response.setContentType("text/html");
		
		if (request.getParameter("responseTarget") != null) {

			
/*			//choose Table
			if ("chooseTable".toString().equals(request.getParameter("responseTarget").toString()))
				chooseTable(request, response);*/
			
			//delete Content
			if ("deleteContent".toString().equals(request.getParameter("responseTarget").toString()))
				deleteContent(request, response);
			
			//delete Table
			if ("deleteTable".toString().equals(request.getParameter("responseTarget").toString()))
				deleteTable(request, response);
			
			//new Table
			if ("newTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);		

/*			//new Relationship between tables
			if ("relationTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateRelationTable(request, response);*/
									
			//new Content of a Table
			if ("updateContent".toString().equals(request.getParameter("responseTarget").toString())) 
				updateContent(request, response);
			
			//update Table
			if ("updateTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);
		
		}
	}
	
	
/*	// choose Row in Content
	public void chooseRow(ResourceRequest request, ResourceResponse response) throws ValidatorException, IOException  {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		String name = (String) json.get("name");
		long headID =(Long) json.get("id");
		
		Content position=null;
		try {
			position = ContentLocalServiceUtil.getContentByHeadIdAndName(headID, name);
		} catch (SystemException e1) {e1.printStackTrace();}
		PortletPreferences prefs = request.getPreferences();
		if (name != null) {
		try {
			prefs.setValue("choRow", Long.toString(position.getContentID()));
		} catch (ReadOnlyException e) {e.printStackTrace();	}
		prefs.store();
		}
	}*/
	
/*	// choose Row in Head
	public void chooseTable(ResourceRequest request, ResourceResponse response) throws IOException, ValidatorException {

		String name = request.getParameter("data").substring(1, request.getParameter("data").length()-1);
		System.out.println(name);
		
		        PrintWriter writer = response.getWriter();
        writer.print(name);
        
		response.setContentType("text/html");
		response.getWriter().println(name);
		response.setProperty("chooseTable", name);
		
		PortletPreferences prefs = request.getPreferences();
		

		if (name != null) {
		try {
			prefs.setValue("choTab", Long.toString(HeadLocalServiceUtil.getHeadID(name)));
		} catch (NoSuchHeadException | ReadOnlyException | SystemException e) {e.printStackTrace();	}
		prefs.store();
		}
	}*/
	
	public void deleteContent (ResourceRequest request, ResourceResponse response){
		
		try {
			ContentLocalServiceUtil.deleteContent(Long.valueOf(request.getParameter("data").substring(1, request.getParameter("data").length()-1)).longValue());
		} catch (PortalException | SystemException e) {e.printStackTrace();}
	}
	
	public void deleteTable (ResourceRequest request, ResourceResponse response){
		
		Long headId = Long.valueOf(request.getParameter("data").substring(1, request.getParameter("data").length()-1)).longValue();
		HeadLocalServiceUtil.deleteTableByHeadId(headId);

	}
	

	public void updateContent(ResourceRequest request, ResourceResponse response)  {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		Boolean check = false;
		//System.out.println(json);
		check = HeadLocalServiceUtil.updateTable(json);
		//System.out.println("new Content: "+check);

	}
	
	
/*	public void updateRelationTable(ResourceRequest request, ResourceResponse response)  {
	
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		Boolean check;
		check = HeadLocalServiceUtil.updateRelationTable(0, (String) json.get("mtable"), (String) json.get("ntable"));
		System.out.println("new connection: "+check);

	}*/
	

	public void updateTable(ResourceRequest request, ResourceResponse response) {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		
		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		//System.out.println(json.toJSONString());
		Boolean check = HeadLocalServiceUtil.updateHeadWithColumns(json);
		//System.out.println("update Table: "+check);

	}





}