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

import org.gfbio.model.Project;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;

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
		
		try {
			researchObjectID = ResearchObjectLocalServiceUtil.updateResearchObject(projectID, researchObjectID, "tester", "tester 0.1", "from the time to stars");
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
		
		
		// Test dynamic access to the table values
		Map <String, Object> projectMap = project.getModelAttributes();
		List <String> projectKey = new ArrayList<String> (projectMap.keySet());
		
		List <String> attributList = new ArrayList<String>();
		System.out.println(projectKey.get(1));
    	System.out.println(projectMap.get(projectKey.get(1)));
		
        include(viewTemplate, renderRequest, renderResponse);
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
