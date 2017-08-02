package org.gfbio.submissions;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class Submissions
 */
public class Submissions extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)   throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =  getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        } else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
    
     
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(Submissions.class);
    
    
    //
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		_log.info("a");
		response.setContentType("text/html");
				
		if (request.getParameter("responseTarget") != null) {
			
			_log.info("b");
					
			//
			if ("getresearchobjectinformation".toString().equals(request.getParameter("responseTarget").toString())){
				_log.info("c");
				getResearchObjectInformation(request, response);	
			}
		}
	}
	
	
	////////////////////////////////////////////////////////////// get functions //////////////////////////////////////////	
	
	//
	public void getResearchObjectInformation(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		
		_log.info("d");
		JSONObject responseJson = new JSONObject();
		JSONObject parseJson = getDataJsonAsObject (request);
		
		JSONObject testObject = new JSONObject();
		testObject.put("foo", "bar");

		responseJson = ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById(parseJson);
		_log.info("e "+responseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
	
	
	////////////////////////////////////////////////////////////// helper functions //////////////////////////////////////////

	
	//
	private JSONObject getDataJsonAsObject (ResourceRequest request){

		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		return parseJson;
	}


}
