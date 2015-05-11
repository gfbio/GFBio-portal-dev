package org.gfbio.tablebuilder;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchPositionException;
import org.gfbio.model.Position;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PositionLocalServiceUtil;
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
		
		include(viewTemplate, renderRequest, renderResponse);
	}

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}
	

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		response.setContentType("text/html");

		if (request.getParameter("responseTarget") != null) {

			//choose Row
			if ("chooseRow".toString().equals(request.getParameter("responseTarget").toString()))
				chooseRow(request, response);
			
			//choose Table
			if ("chooseTable".toString().equals(request.getParameter("responseTarget").toString()))
				chooseTable(request, response);

			//new Content of a Table
			if ("updateContent".toString().equals(request.getParameter("responseTarget").toString())) 
				updateContent(request, response);

			//new Relationship between tables
			if ("relationTable".toString().equals(request.getParameter("responseTarget").toString())){
				System.out.println("relation table");
				updateRelationTable(request, response);
			}			
			//new Table
			if ("newTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);
			

			//update Table
			if ("updateTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);
		}
	}
	
	
	// choose Row in Position
	public void chooseRow(ResourceRequest request, ResourceResponse response) throws ValidatorException, IOException  {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		String name = (String) json.get("name");
		long headID =(Long) json.get("id");
		
		Position position=null;
		try {
			position = PositionLocalServiceUtil.getPositionByHeadIdAndName(headID, name);
		} catch (SystemException e1) {e1.printStackTrace();}
		PortletPreferences prefs = request.getPreferences();
		if (name != null) {
		try {
			prefs.setValue("choRow", Long.toString(position.getPositionID()));
		} catch (ReadOnlyException e) {e.printStackTrace();	}
		prefs.store();
		}
	}
	
	// choose Row in Head
	public void chooseTable(ResourceRequest request, ResourceResponse response) throws IOException, ValidatorException {

		String name = request.getParameter("data").substring(1, request.getParameter("data").length()-1);
		PortletPreferences prefs = request.getPreferences();

		if (name != null) {
		try {
			prefs.setValue("choTab", Long.toString(HeadLocalServiceUtil.getHeadID(name)));
		} catch (NoSuchHeadException | ReadOnlyException | SystemException e) {e.printStackTrace();	}
		prefs.store();
		}
	}
	

	public void updateContent(ResourceRequest request, ResourceResponse response)  {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		
		try {
			Boolean check = false;
			try {
				check = PositionLocalServiceUtil.updatePosition(Long.valueOf(
					(String) json.get("positionID")).longValue(), 
					Long.valueOf((String) json.get("headID")).longValue(),
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 1)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 2)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 3)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 4)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 5)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 6)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 7)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 8)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 9)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 10)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 11)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 12)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 13)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 14)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 15)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 16)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 17)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 18)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 19)).trim())	,
					(String) json.get((HeadLocalServiceUtil.getColumnName(Long.valueOf((String) json.get("headID")).longValue(), 20)).trim())	);
			} catch (NoSuchHeadException | NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("new Content: "+check);
		} catch (SystemException e) {e.printStackTrace();}
	}
	
	
	public void updateRelationTable(ResourceRequest request, ResourceResponse response)  {
	
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		System.out.println(json.toString());
		Boolean check;
		try {
			check = HeadLocalServiceUtil.updateRelationTable(0, (String) json.get("mtable"), (String) json.get("ntable"));
			System.out.println("new connection: "+check);
		} catch (NoSuchHeadException | NoSuchPositionException | SystemException e) {e.printStackTrace();}
	}
	

	public void updateTable(ResourceRequest request, ResourceResponse response) {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}
		
		try {
			Boolean check = HeadLocalServiceUtil.updateHead(Long.valueOf((String) json.get("headID")).longValue(), ((String) json.get("name")).trim(), ((String) json.get("relationID")).trim(), ((String) json.get("column01")).trim(), ((String) json.get("column02")).trim(), ((String) json.get("column03")).trim(), ((String) json.get("column04")).trim(), ((String) json.get("column05")).trim(), ((String) json.get("column06")).trim(), ((String) json.get("column07")).trim(), ((String) json.get("column08")).trim(), ((String) json.get("column09")).trim(), ((String) json.get("column10")).trim(), ((String) json.get("column11")).trim(), ((String) json.get("column12")).trim(), ((String) json.get("column13")).trim(), ((String) json.get("column14")).trim(), ((String) json.get("column15")).trim(), ((String) json.get("column16")).trim(), ((String) json.get("column17")).trim(), ((String) json.get("column18")).trim(), ((String) json.get("column19")).trim(), ((String) json.get("column20")).trim());
			System.out.println("update Table: "+check);
		} catch (SystemException e) {e.printStackTrace();}
	}





}