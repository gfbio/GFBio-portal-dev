package org.gfbio.submissionworkflow;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class WorkflowGeneric
 */
public class WorkflowGeneric extends GenericPortlet {

    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(WorkflowGeneric.class);
    
	public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

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
    
    
    
    //
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		response.setContentType("text/html");
		
		if (request.getParameter("responseTarget") != null) {
			
			//starts getResearchObjectById of researchobject
			if ("getresearchobjectbyid".toString().equals(request.getParameter("responseTarget").toString()))
				getResearchObjectById(request, response);
			
			//starts service getTableAsJSONArrayByName of head 
			if ("gettablebyname".toString().equals(request.getParameter("responseTarget").toString()))
				getTableAsJsonArrayByName(request, response);
			
			//starts getUserExtentionById of userExtention
			if ("getuserbyid".toString().equals(request.getParameter("responseTarget").toString()))
				getUserExtentionById(request, response);
			

		}
	}
	
	
	//
	public void getResearchObjectById(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONArray responseJson = new JSONArray();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {parseJson = (JSONArray) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}

		responseJson = ResearchObjectLocalServiceUtil.getResearchObjectsAsJsonById(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());

	}
	
	
	//
	public void getTableAsJsonArrayByName(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONArray responseJson = new JSONArray();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}

		responseJson = HeadLocalServiceUtil.getTableAsJSONArrayByName(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
	
	
	//
	public void getUserExtentionById(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}

		responseJson = UserExtensionLocalServiceUtil.getUserExtentionById(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
 


}
