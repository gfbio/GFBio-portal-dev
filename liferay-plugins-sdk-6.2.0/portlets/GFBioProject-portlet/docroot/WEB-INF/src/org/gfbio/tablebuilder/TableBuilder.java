package org.gfbio.tablebuilder;

import com.liferay.portal.kernel.exception.PortalException;
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
			
			//delete Table
			if ("deleteTable".toString().equals(request.getParameter("responseTarget").toString()))
				deleteTable(request, response);
			

			//new Content of a Table
			if ("updateContent".toString().equals(request.getParameter("responseTarget").toString())) 
				updateContent(request, response);

			//new Relationship between tables
			if ("relationTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateRelationTable(request, response);
						
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
		System.out.println(name);
		
		/*        PrintWriter writer = response.getWriter();
        writer.print(name);
        
		response.setContentType("text/html");
		response.getWriter().println(name);
		response.setProperty("chooseTable", name);*/
		
		/*PortletPreferences prefs = request.getPreferences();
		

		if (name != null) {
		try {
			prefs.setValue("choTab", Long.toString(HeadLocalServiceUtil.getHeadID(name)));
		} catch (NoSuchHeadException | ReadOnlyException | SystemException e) {e.printStackTrace();	}
		prefs.store();
		}*/
	}
	
	public void deleteTable (ResourceRequest request, ResourceResponse response){
		
		Long headId = Long.valueOf(request.getParameter("data").substring(1, request.getParameter("data").length()-1)).longValue();

		
		try {
			HeadLocalServiceUtil.deleteCompleteHead(headId);
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				System.out.println(json);
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
			String c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
			if (json.containsKey("column01")) c1=((String) json.get("column01")).trim(); else c1="";
			if (json.containsKey("column02")) c2=((String) json.get("column02")).trim(); else c2="";
			if (json.containsKey("column03")) c3=((String) json.get("column03")).trim(); else c3="";
			if (json.containsKey("column04")) c4=((String) json.get("column04")).trim(); else c4="";
			if (json.containsKey("column05")) c5=((String) json.get("column05")).trim(); else c5="";
			if (json.containsKey("column06")) c6=((String) json.get("column06")).trim(); else c6="";
			if (json.containsKey("column07")) c7=((String) json.get("column07")).trim(); else c7="";
			if (json.containsKey("column08")) c8=((String) json.get("column08")).trim(); else c8="";
			if (json.containsKey("column09")) c9=((String) json.get("column09")).trim(); else c9="";
			if (json.containsKey("column10")) c10=((String) json.get("column10")).trim(); else c10="";
			if (json.containsKey("column11")) c11=((String) json.get("column11")).trim(); else c11="";
			if (json.containsKey("column12")) c12=((String) json.get("column12")).trim(); else c12="";
			if (json.containsKey("column13")) c13=((String) json.get("column13")).trim(); else c13="";
			if (json.containsKey("column14")) c14=((String) json.get("column14")).trim(); else c14="";
			if (json.containsKey("column15")) c15=((String) json.get("column15")).trim(); else c15="";
			if (json.containsKey("column16")) c16=((String) json.get("column16")).trim(); else c16="";
			if (json.containsKey("column17")) c17=((String) json.get("column17")).trim(); else c17="";
			if (json.containsKey("column18")) c18=((String) json.get("column18")).trim(); else c18="";
			if (json.containsKey("column19")) c19=((String) json.get("column19")).trim(); else c19="";
			if (json.containsKey("column20")) c20=((String) json.get("column20")).trim(); else c20="";
			
			Boolean check = HeadLocalServiceUtil.updateHead(Long.valueOf((String) json.get("headID")).longValue(), ((String) json.get("name")).trim(), ((String) json.get("relationID")).trim(), c1, c2, c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20);
			System.out.println("update Table: "+check);
		} catch (SystemException e) {e.printStackTrace();}
	}





}