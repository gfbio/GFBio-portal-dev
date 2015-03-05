package org.gfbio.archiving;



import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.model.Project;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Portlet implementation class ArchivingPortlet
 */
public class ArchivingPortlet extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)  throws IOException, PortletException {

        CacheRegistryUtil.clear();
        MultiVMPoolUtil.clear();
        WebCachePoolUtil.clear(); 
        include(viewTemplate, renderRequest, renderResponse);
        
    }

    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(ArchivingPortlet.class);
    
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {

		response.setContentType("text/html");
			
		if(request.getParameter("responseTarget")  != null){
			
			//choose a project
			if ("choosePro".toString().equals(request.getParameter("responseTarget").toString()))
				chooseProject(request, response);

			//new project
			if ("newProject".toString().equals(request.getParameter("responseTarget").toString()))
				newProject(request, response);
			
			//new ResearchObject / sequence meta data over GCDJ Widget	
			if ("GCDJWidget".toString().equals(request.getParameter("responseTarget").toString()))
				newResearchObject(request, response);
			
			//update Project
			if ("updateProject".toString().equals(request.getParameter("responseTarget").toString()))
				updateProject(request, response);

		}
	}
	
	// choose Dataset
	public  void chooseProject(ResourceRequest request, ResourceResponse response) throws IOException, PortletException{

		String projectID  = request.getParameter("data").substring(1, request.getParameter("data").length()-1);
		PortletPreferences prefs = request.getPreferences();
				
		if (projectID != null) {
	    	prefs.setValue("choPro", projectID);
	    	prefs.store();
		}
	}
	
	
	public void newProject(ResourceRequest request, ResourceResponse response){
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		long projectID = Long.valueOf((String) json.get("projectID")).longValue();
		long userID =    (long) json.get("relationID");

		String name = (String) json.get("name");
		String label = (String) json.get("label");
		String description = (String) json.get("description");
		String preDate = (String) json.get("startDate");
		int yeahr = Integer.parseInt(preDate.substring(0,4));
		int month;
		if (preDate.substring(6,7).equals("-"))
			month = Integer.parseInt(preDate.substring(5,6))-1;
		else
			month = Integer.parseInt(preDate.substring(5,7))-1;
		int day;
		if (preDate.substring(preDate.length()-2,preDate.length()-1).equals("-"))
			day = Integer.parseInt(preDate.substring(preDate.length()-1,preDate.length()));
		else
			day = Integer.parseInt(preDate.substring(preDate.length()-2,preDate.length()));
		//Calendar cal = Calendar.getInstance();
		//cal.set(yeahr,month,day);
		//long ms = cal.getTimeInMillis();
		//Date startDate = new Date(ms);
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = new Date();
		try {
			startDate = dfm.parse(yeahr+"-"+month+"-"+day);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		preDate = (String) json.get("endDate");
		yeahr = Integer.parseInt(preDate.substring(0,4));
		if (preDate.substring(6,7).equals("-"))
			month = Integer.parseInt(preDate.substring(5,6))-1;
		else
			month = Integer.parseInt(preDate.substring(5,7))-1;
		if (preDate.substring(preDate.length()-2,preDate.length()-1).equals("-"))
			day = Integer.parseInt(preDate.substring(preDate.length()-1,preDate.length()));
		else
			day = Integer.parseInt(preDate.substring(preDate.length()-2,preDate.length()));
		//cal = Calendar.getInstance();
		//cal.set(yeahr,month,day);
		//ms = cal.getTimeInMillis();
		//Date endDate = new Date(ms);
		Date endDate = new Date();
		try {
			endDate = dfm.parse(yeahr+"-"+month+"-"+day);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		String status = (String) json.get("status");
		
		try {
			projectID = ProjectLocalServiceUtil.updateProject(projectID, userID, name, label,description, startDate, endDate, status);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	public void newResearchObject(ResourceRequest request, ResourceResponse response){
		try {
			long researchObjectID = 0;
			long projectID = Long.valueOf(request.getParameter("projId")).longValue();
			
			JSONParser parser = new JSONParser();
			JSONObject json = new JSONObject();
			try {
				json = (JSONObject) parser.parse(request.getParameter("data"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			String data = json.toString();
			String name = (String) json.get("project_name");
			String label = (String) json.get("project_name");
			
			String test = data;
			//String testend = checkJSON(test);
			
			researchObjectID = ResearchObjectLocalServiceUtil.updateResearchObject(projectID, researchObjectID, name, label, data);
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public static String unpackJSON(String json){
		
		JSONUnpackString jsonUnpack = new JSONUnpackString (json, "", 1);
		
		jsonUnpack = unpackJSONrek(jsonUnpack);
		json = "{".concat(jsonUnpack.getText()).concat("}");
		return json;
	}
	
	public static JSONUnpackString unpackJSONrek(JSONUnpackString jsonUnpack){
		String origntext = jsonUnpack.getOrigntext();
		String text = jsonUnpack.getText();
		int k = jsonUnpack.getIndex();
		char open = '{';
		char close = '}';
		char comma = ',';
		
		//prüft Zeichen für Zeichen den Text
		for (int i=k;i<origntext.length();i++){
			
			//wenn neues JSON gefunden wird
			if (origntext.charAt(i)==open){
				int j = i;
				//key des neuen JSON ausschließen
				while (origntext.charAt(j)!=comma && j>=k){
					j--;
				}
				if (k!=j){
					jsonUnpack.addText(origntext.substring(k,j+1));
				}
				jsonUnpack.setIndex(i+1);
				//und neue rekurssion starten
				jsonUnpack = unpackJSONrek(jsonUnpack);
				k = jsonUnpack.getIndex();
				i = jsonUnpack.getIndex();
			}
			//JSON abschließen
			if (origntext.charAt(i)==close){
				jsonUnpack.addText(origntext.substring(k,i));
				jsonUnpack.setIndex(i+1);
				return jsonUnpack;
			}
		}
		jsonUnpack.addText(origntext.substring(k,origntext.length()));
		return jsonUnpack;
	}
	
	//update Project data
	public  void updateProject(ResourceRequest request, ResourceResponse response) throws IOException, PortletException{
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		long projectID = Long.valueOf((String) json.get("projectID")).longValue();
		long userID =    Long.valueOf((String) json.get("relationID")).longValue();

		String name = (String) json.get("name");
		String label = (String) json.get("label");
		String description = (String) json.get("description");
		String preDate = (String) json.get("startDate");
		for (int i =0; i <preDate.length();i++)
			if (preDate.subSequence(i, i+1).equals(" ")){
				preDate = preDate.substring(0,i);
				break;
			}
		int yeahr = Integer.parseInt(preDate.substring(0,4));
		int month;
		if (preDate.substring(6,7).equals("-"))
			month = Integer.parseInt(preDate.substring(5,6))-1;
		else
			month = Integer.parseInt(preDate.substring(5,7))-1;
		int day;
		if (preDate.substring(preDate.length()-2,preDate.length()-1).equals("-"))
			day = Integer.parseInt(preDate.substring(preDate.length()-1,preDate.length()));
		else
			day = Integer.parseInt(preDate.substring(preDate.length()-2,preDate.length()));
		//Calendar cal = Calendar.getInstance();
		//cal.set(yeahr,month,day);
		//long ms = cal.getTimeInMillis();
		//Date startDate = new Date(ms);
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = new Date();
		try {
			startDate = dfm.parse(yeahr+"-"+month+"-"+day);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		
		preDate = (String) json.get("endDate");
		for (int i =0; i <preDate.length();i++)
			if (preDate.subSequence(i, i+1).equals(" ")){
				preDate = preDate.substring(0,i);
				break;
			}
		yeahr = Integer.parseInt(preDate.substring(0,4));
		if (preDate.substring(6,7).equals("-"))
			month = Integer.parseInt(preDate.substring(5,6))-1;
		else
			month = Integer.parseInt(preDate.substring(5,7))-1;
		if (preDate.substring(preDate.length()-2,preDate.length()-1).equals("-"))
			day = Integer.parseInt(preDate.substring(preDate.length()-1,preDate.length()));
		else
			day = Integer.parseInt(preDate.substring(preDate.length()-2,preDate.length()));
		//cal = Calendar.getInstance();
		//cal.set(yeahr,month,day);
		//ms = cal.getTimeInMillis();
		Date endDate = new Date();
		try {
			endDate = dfm.parse(yeahr+"-"+month+"-"+day);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		String status = (String) json.get("status");
		


		
		try {
			projectID = ProjectLocalServiceUtil.updateProject(projectID, userID, name, label,description, startDate, endDate, status);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
