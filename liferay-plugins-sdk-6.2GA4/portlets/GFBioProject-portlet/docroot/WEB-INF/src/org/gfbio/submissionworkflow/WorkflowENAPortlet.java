package org.gfbio.submissionworkflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class WorkflowENAPortlet
 */
public class WorkflowENAPortlet extends GenericPortlet {
	
	
    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(WorkflowENAPortlet.class);


    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)throws IOException, PortletException {
        include(viewTemplate, renderRequest, renderResponse);
    }

    
    protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =  getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
    

    //
    public static String getServerToken(String path, String server) throws IOException, PortletException {
		
		String token ="";
		JSONParser parser = new JSONParser();	
		File file = new File(path +"html\\workflowena\\token.txt");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			int content;
			String preJson ="";
			
			while ((content = fis.read()) != -1)
				preJson = preJson+(char) content;
			
			JSONObject fileJson = new JSONObject();
			try {fileJson = (JSONObject) parser.parse(preJson);}
			catch (ParseException e) {e.printStackTrace();}
			
			if (fileJson.containsKey(server))
				token = (String) fileJson.get(server);
			else
				token = "ERROR: You sent a wrong server type.";
	
		} catch (IOException e) {e.printStackTrace();}
		finally {
			try {if (fis != null)fis.close();} 
			catch (IOException ex) {ex.printStackTrace();}
		}
		
		return token;
	}

}
