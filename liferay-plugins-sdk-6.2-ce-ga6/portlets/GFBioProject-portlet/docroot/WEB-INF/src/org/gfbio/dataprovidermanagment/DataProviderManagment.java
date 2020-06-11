package org.gfbio.dataprovidermanagment;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.helper.Helper;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class DataProviderManagment
 */
public class DataProviderManagment extends GenericPortlet {

	
    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(DataProviderManagment.class);
	
    public void init() {
        viewTemplate = getInitParameter("view-template");
    }
    

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }
    

    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 

    
    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		response.setContentType("text/html");
		if (request.getParameter("responseTarget") != null) {
			
			//choose a data provider
			if ("chooseDP".toString().equals(request.getParameter("responseTarget").toString()))
				chooseDataProvider(request, response);
			
		}
	}
    
  //--------------------------------------------------------------------------------------------------------------------
  	//------------------------------------------------- functions --------------------------------------------------------
  	//--------------------------------------------------------------------------------------------------------------------
  	
  	
  	//
  	@SuppressWarnings("unchecked")
  	public void chooseDataProvider(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
  		
  		JSONObject responseJson = new JSONObject();
  		String dataJson = request.getParameter("data");
  		JSONParser parser = new JSONParser();
  		JSONObject parseJson = new JSONObject();
  		try {parseJson = (JSONObject) parser.parse(dataJson);}
  		catch (ParseException e) {e.printStackTrace();}
  		
  		if (parseJson.containsKey("label")) {
  			
  			if (!(((String) parseJson.get("label")).equals("none")))
				responseJson = DataProviderLocalServiceUtil.getDataProviderByLabel(((String) parseJson.get("label")).trim());
  			else
  				responseJson.put("label", "0");
  			
  			if (responseJson.containsKey("lastmodifieddate")){
  				responseJson.put("lastmodifieddate", Helper.getStringFromJson(responseJson, "lastmodifieddate"));
  			}
  				
  			System.out.println(responseJson);
  			  	        
  		}
  		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");	        
		response.getWriter().write(responseJson.toString());

  	}

}
