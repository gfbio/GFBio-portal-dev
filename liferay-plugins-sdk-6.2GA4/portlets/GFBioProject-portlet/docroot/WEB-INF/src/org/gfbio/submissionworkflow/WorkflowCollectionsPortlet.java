package org.gfbio.submissionworkflow;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.service.ProjectLocalServiceUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class WorkflowCollectionsPortlet
 */
public class WorkflowCollectionsPortlet extends GenericPortlet {
	
    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(WorkflowCollectionsPortlet.class);

    
    //
    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    
    //
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    
    //
    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
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

		System.out.println("test");
		response.setContentType("text/html");
		
		if (request.getParameter("responseTarget") != null) {

			//get project
			if ("getproject".toString().equals(request.getParameter("responseTarget").toString()))
				getproject(request, response);


		}
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public void getproject(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		System.out.println("testererer");
		JSONObject responseJson = new JSONObject();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {
			parseJson = (JSONObject) parser.parse(dataJson);
		} catch (ParseException e) {e.printStackTrace();}

		
		if (parseJson.containsKey("projectid")) {
			if (!(((String) parseJson.get("projectid")).equals("none")))
				responseJson.put("researchobjects", ProjectLocalServiceUtil.getProjectById(parseJson));
			else
				responseJson.put("projectid", 0);
			
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseJson.toString());
		}
	}
    
}
