package org.gfbio.archiving;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class ArchivingPortlet
 */
public class ArchivingPortlet extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

	
//   		long projectID = 0;
//		long userID = 0;
//		long researchObjectID =0;
//    	
//    	//add or update a project
//		
//    	try {
//    		
//    		projectID = ProjectLocalServiceUtil.updateProject(projectID, userID, "DoctorToWarp", "it is a test", new Date(23, 11, 1963), new Date(05/04/2063), "fictive");
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//		if(projectID > 0)
//			System.out.println("Project "+projectID+ " created");
//		else
//			System.out.println("Project "+projectID+ " updated");
//
//		
//		//add or update Research Object
//		
//		try {
//			researchObjectID = ResearchObjectLocalServiceUtil.updateResearchObject(projectID, researchObjectID, "tester", "from the time to stars");
//		} catch (SystemException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		//get all Projects of a specific user in a List
//		
//		List <Project> projectList = new ArrayList<Project>();
//		projectList = null;
//		try {
//			 projectList = ProjectLocalServiceUtil.getProjectList(userID);
//		} catch (NoSuchModelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		for(int i = 0;i <projectList.size();i++)
//			System.out.println(projectList.get(i).getPrimaryKey());
//
//
//			
//		//get all Research Objects of a specific Project in a List
//		
//		projectID = 1501;
//		
//		List<ResearchObject> researchObjectList = new ArrayList<ResearchObject>();
//		projectList = null;
//		try {
//			researchObjectList = ProjectLocalServiceUtil.getResearchObjectList(projectID, userID);
//		} catch (NoSuchModelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		for(int i = 0;i <researchObjectList.size();i++)
//			System.out.println(researchObjectList.get(i).getPrimaryKey());
    	
    	
    	
    	
    	
    	
    	
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

    private static Log _log = LogFactoryUtil.getLog(ArchivingPortlet.class);

}
