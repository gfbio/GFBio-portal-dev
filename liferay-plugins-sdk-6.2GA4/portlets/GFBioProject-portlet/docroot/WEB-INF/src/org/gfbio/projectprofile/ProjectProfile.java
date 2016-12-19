package org.gfbio.projectprofile;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ProjectProfile extends GenericPortlet {
	
	protected String viewTemplate;
	private static Log _log = LogFactoryUtil.getLog(ProjectProfile.class);

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		CacheRegistryUtil.clear();
		MultiVMPoolUtil.clear();
		WebCachePoolUtil.clear();
		include(viewTemplate, renderRequest, renderResponse);
	}

	
	public void init() {
		viewTemplate = getInitParameter("view-template");
	}
	

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
	
		if (portletRequestDispatcher == null) 
			_log.error(path + " is not a valid include");
		else 
			portletRequestDispatcher.include(renderRequest, renderResponse);
	}
	

	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		
		response.setContentType("text/html");

		if (request.getParameter("responseTarget") != null) {
			
			//choose a project
			if ("choosePro".toString().equals(request.getParameter("responseTarget").toString()))
				chooseProject(request, response);
			
			//choose a research object
			if ("chooseRO".toString().equals(request.getParameter("responseTarget").toString()))
				chooseResearchObject(request, response);


			//new ResearchObject / sequence meta data over GCDJ Widget
			if ("GCDJWidget".toString().equals(request.getParameter("responseTarget").toString())){}
				//newResearchObject(request, response);

			//update Project
			if ("updateProject".toString().equals(request.getParameter("responseTarget").toString()))
				updateProject(request, response);
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------- functions --------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	
	
	//
	@SuppressWarnings("unchecked")
	public void chooseProject(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {
			parseJson = (JSONObject) parser.parse(dataJson);
		} catch (ParseException e) {e.printStackTrace();}

		
		if (parseJson.containsKey("projectid")) {
			if (!(((String) parseJson.get("projectid")).equals("none"))){
				String projectid = (String) parseJson.get("projectid");
				parseJson.remove("projectid");
				parseJson.put("projectid", Long.valueOf(projectid).longValue());
				responseJson = ProjectLocalServiceUtil.getCompleteProjectById(parseJson);
			}else
				responseJson.put("projectid", 0);
			
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseJson.toString());
		}
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	public void chooseResearchObject(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {
			parseJson = (JSONObject) parser.parse(dataJson);
		} catch (ParseException e) {e.printStackTrace();}
	
		if (parseJson.containsKey("researchobjectid")) {
			if (!(((String) parseJson.get("researchobjectid")).equals("none"))){
				String projectid = (String) parseJson.get("researchobjectid");
				parseJson.remove("researchobjectid");
				parseJson.put("researchobjectid", Long.valueOf(projectid).longValue());
				JSONArray jsonArray = new JSONArray();
				jsonArray.add(parseJson);
				responseJson = (JSONObject) ResearchObjectLocalServiceUtil.getResearchObjectsAsJsonById(jsonArray).get(0);
			}else
				responseJson.put("researchobjectid", 0);
			
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseJson.toString());
		}
	}
	
	
	//
	public void updateProject(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {e1.printStackTrace();}

		long projectID = Long.valueOf((String) json.get("projectID")).longValue();
		long userID = 0;
		if ("updateProject".toString().equals(request.getParameter("responseTarget").toString()))
			userID = Long.valueOf((String) json.get("relationID")).longValue();
		else
			if ("newProject".toString().equals(request.getParameter("responseTarget").toString()))
				userID =(Long) json.get("relationID");
		String name = (String) json.get("name");
		String label = (String) json.get("label");
		String description = (String) json.get("description");
		String preDate = (String) json.get("startDate");

		for (int i = 0; i <preDate.length(); i++)
			if (preDate.subSequence(i, i+1).equals(" ")) {
				preDate = preDate.substring(0, i);
				break;
			}
		
		int yeahr = Integer.parseInt(preDate.substring(0, 4));

		int month;
		if (preDate.substring(6,7).equals("-"))
			month = Integer.parseInt(preDate.substring(5, 6))-1;
		else
			month = Integer.parseInt(preDate.substring(5, 7))-1;

		int day;
		if (preDate.substring(preDate.length()-2,preDate.length()-1).equals("-"))
			day = Integer.parseInt(preDate.substring(preDate.length()-1, preDate.length()));
		else
			day = Integer.parseInt(preDate.substring(preDate.length()-2, preDate.length()));

		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = new Date();
		try {
			startDate = dfm.parse(yeahr+"-"+month+"-"+day);
		} catch (java.text.ParseException e1) {e1.printStackTrace();}

		preDate = (String) json.get("endDate");

		for (int i = 0; i <preDate.length(); i++)
			if (preDate.subSequence(i, i+1).equals(" ")) {
				preDate = preDate.substring(0, i);
				break;
			}

		yeahr = Integer.parseInt(preDate.substring(0, 4));

		if (preDate.substring(6,7).equals("-"))
			month = Integer.parseInt(preDate.substring(5, 6))-1;
		else
			month = Integer.parseInt(preDate.substring(5, 7))-1;

		if (preDate.substring(preDate.length()-2,preDate.length()-1).equals("-"))
			day = Integer.parseInt(preDate.substring(preDate.length()-1, preDate.length()));
		else
			day = Integer.parseInt(preDate.substring(preDate.length()-2, preDate.length()));

		Date endDate = new Date();
		try {
			endDate = dfm.parse(yeahr+"-"+month+"-"+day);
		} catch (java.text.ParseException e1) {e1.printStackTrace();}

		String status = (String) json.get("status");
		String extendedData = "";
/*		try {
			projectID = ProjectLocalServiceUtil.updateProject(projectID, userID, name, label, description, extendedData, startDate, endDate, status);
		} catch (SystemException e) {e.printStackTrace();}*/
	}



}