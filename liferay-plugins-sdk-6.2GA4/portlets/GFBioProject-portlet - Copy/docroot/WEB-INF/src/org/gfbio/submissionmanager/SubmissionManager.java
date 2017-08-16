package org.gfbio.submissionmanager;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.projectprofile.ProjectProfile;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;



/**
 * Portlet implementation class SubmissionManager
 */
public class SubmissionManager extends GenericPortlet {
	
	
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
		
 

}
