package org.gfbio.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.gfbio.archiving.JSONUnpackString;
import org.gfbio.model.Project;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.json.simple.JSONObject;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class TestPortlet
 */
public class TestPortlet extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

	
   		long projectID = 0;
		long userID = 0;
		try {
			if (PortalUtil.getUser(renderRequest)!=null)
				userID = PortalUtil.getUserId(renderRequest);
		} catch (PortalException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		long researchObjectID =0;
		
		Calendar cal = Calendar.getInstance();
		cal.set(1963,10,23);
		long ms = cal.getTimeInMillis();
		Date startDate = new Date(ms);
		cal.set(2063,4,4);
		ms = cal.getTimeInMillis();
		Date endDate = new Date(ms);
	    
		
    	
    	//add or update a project
		

    	try {
    		
    		projectID = ProjectLocalServiceUtil.updateProject(projectID, userID, "DoctorToWarp", "BlueBox 13","it is a test", startDate, endDate, "fictive");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		if(projectID > 0)
			System.out.println("Project "+projectID+ " created");
		else
			System.out.println("Project "+projectID+ " updated");

		
		//add or update Research Object
		
		JSONObject metadata = new JSONObject();
	    JSONObject sub = new JSONObject();

	    metadata.put("key_1", "value_1");
	    metadata.put("key_2", "value_2");
	    sub.put("key_3_1", "value_2_1");
	    sub.put("key_3_2", "value_2_2");
	    metadata.put("key_3", sub);
		
	      
	    String formatmetadata = unpackJSON(metadata.toString());
		
		try {
			researchObjectID = ResearchObjectLocalServiceUtil.updateResearchObject(projectID, researchObjectID, "tester", "tester 0.1", metadata.toString(),formatmetadata);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//get all Projects of a specific user in a List
		
		List <Project> projectList = new ArrayList<Project>();
		projectList = null;
		try {
			 projectList = ProjectLocalServiceUtil.getProjectList(userID);
		} catch (NoSuchModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		for(int i = 0;i <projectList.size();i++)
			System.out.println(projectList.get(i).getPrimaryKey());


			
		//get all Research Objects of a specific Project in a List
		
		//projectID = 1501;
		System.out.println();
		
		List<ResearchObject> researchObjectList = new ArrayList<ResearchObject>();
		projectList = null;
		try {
			researchObjectList = ProjectLocalServiceUtil.getResearchObjectList(projectID, userID);
		} catch (NoSuchModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		for(int i = 0;i <researchObjectList.size();i++)
			System.out.println(researchObjectList.get(i).getPrimaryKey());
    	
    	
		Project project = null;
		try {
			project = ProjectLocalServiceUtil.getProject(projectID);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		//pr¸ft Zeichen f¸r Zeichen den Text
		for (int i=k;i<origntext.length();i++){
			
			//wenn neues JSON gefunden wird
			if (origntext.charAt(i)==open){
				int j = i;
				//key des neuen JSON ausschlieﬂen
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
			//JSON abschlieﬂen
			if (origntext.charAt(i)==close){
				jsonUnpack.addText(origntext.substring(k,i));
				jsonUnpack.setIndex(i+1);
				return jsonUnpack;
			}
		}
		jsonUnpack.addText(origntext.substring(k,origntext.length()));
		return jsonUnpack;
	}
    
    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
    
    
 
    protected String viewTemplate;
    
    

    private static Log _log = LogFactoryUtil.getLog(TestPortlet.class);

}
