package org.gfbio.submissionworkflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.codec.binary.Base64;
import org.gfbio.helper.Helper;
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
 * Portlet implementation class WorkflowEnvironmental
 */
public class WorkflowEnvironmental extends GenericPortlet {

    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(WorkflowEnvironmental.class);
	
    public void init() {viewTemplate = getInitParameter("view-template");
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
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
 

    
    //
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		response.setContentType("text/html");
				
		if (request.getParameter("responseTarget") != null) {
			
			//
			if ("createresearchobject".toString().equals(request.getParameter("responseTarget").toString()))
				createResearchObject(request, response);	
			
			//starts getResearchObjectById of researchobject
			if ("getresearchobjectbyid".toString().equals(request.getParameter("responseTarget").toString()))
				getResearchObjectById(request, response);
			
			//starts service getTableAsJSONArrayByName of head 
			if ("gettablebyname".toString().equals(request.getParameter("responseTarget").toString()))
				getTableAsJsonArrayByName(request, response);
			
			//starts getUserExtentionById of userExtention
			if ("getuserbyid".toString().equals(request.getParameter("responseTarget").toString()))
				getUserExtentionById(request, response);
			
			//
			if ("startsubmission".toString().equals(request.getParameter("responseTarget").toString()))
				startSubmission(request, response);

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
 
	
	
	////////////////////////////////////////////////////////////// update functions //////////////////////////////////////////
	
	
	//
	public void createResearchObject (ResourceRequest request, ResourceResponse response){
    	

		
		
        String responseString = "";
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
	
		System.out.println("create" + dataJson);
		
		responseString = (ResearchObjectLocalServiceUtil.createResearchObjectByJson(parseJson)).toString();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}
		
		
	}
	
	
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void startSubmission (ResourceRequest request, ResourceResponse response){
    	
    	
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
        String responseString = "";

        try {

//        	URL url = new URL("http://helpdesk.gfbio.org/rest/api/2/issue/");
        	URL url = new  URL("http://c103-170.cloud.gwdg.de/brokerage/submissions/pangaea");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept","application/json");
           
            String userpass= Helper.getServerInformation((String) ((JSONObject) parseJson).get("path"),"jirauserpass");
            String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
            conn.addRequestProperty ("Authorization", basicAuth);
          
            String encodedData = getJSON_Body((JSONObject) parseJson);
            OutputStream os = conn.getOutputStream();
            os.write(encodedData.getBytes());
            os.flush();       
   
            if (conn.getResponseCode() != 201)
               throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null){
            	System.out.println("output");
                responseString = responseString.concat(output);
            } 

            conn.disconnect();
         } catch (Exception e) {e.printStackTrace();}
       
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}
    }
   
   
    //
    @SuppressWarnings({ "unchecked", "unused" })
    private static String getJSON_Body(JSONObject requestJson){
    	

    	JSONParser parser = new JSONParser();
		
		//preparation data source
		
		JSONObject projectJson = new JSONObject();
    	projectJson = (JSONObject) requestJson.get("mrr");
    	
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    	System.out.println(requestJson);
    	System.out.println(projectJson);
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

    	JSONObject researchObjectJson = new JSONObject();
    	researchObjectJson = (JSONObject) projectJson.get("researchobjects");

		JSONObject submitterJson = new JSONObject();
		submitterJson.put("userid", (long) researchObjectJson.get("submitterid"));
    	submitterJson = UserExtensionLocalServiceUtil.getUserExtentionById(submitterJson);
    	   	
		JSONObject extendeddataJsonResearchObject = new JSONObject();
		extendeddataJsonResearchObject = (JSONObject) researchObjectJson.get("extendeddata");
    	
		
		//preparation data target
		
        JSONObject json = new JSONObject();
        JSONObject fields = new JSONObject();
        
        JSONObject project = new JSONObject();
        JSONObject issuetype = new JSONObject();
        JSONObject reporter = new JSONObject();
        
        JSONArray keywordArray = new JSONArray();
        JSONArray projectlabelArray = new JSONArray();
        JSONArray datasetlabelArray = new JSONArray();
        JSONObject metadata = new JSONObject();
        JSONArray metadataArray = new JSONArray();
        JSONObject license = new JSONObject();
        JSONArray legalRequirementsArray = new JSONArray();
        JSONObject legalRequirements = new JSONObject();
        
        
        //ticket basic informations
        try {project.put("key", Helper.getServerInformation((String) requestJson.get("path"),"jiraprojectkey"));}
        catch (IOException | PortletException e1) {e1.printStackTrace();}
        fields.put("project", project);
        issuetype.put("name", "Data Submission");
        fields.put("issuetype", issuetype);	
        reporter.put("name", submitterJson.get("emailaddress"));
        fields.put("reporter", reporter); 
        fields.put("customfield_10010", "sand"+"/"+"environmental-data2");
        fields.put("summary", "Automated Data Submission");

        
        //project informations

        //dataset informations
               
        //dataset title
        fields.put("customfield_10201", researchObjectJson.get("name")); 						
        
        //dataset description
        fields.put("customfield_10208", researchObjectJson.get("description"));	
        
        //dataset author
        if (extendeddataJsonResearchObject.containsKey("authornames"))
        	if (!(extendeddataJsonResearchObject.get("authornames").equals("")))
        		fields.put("customfield_10205", extendeddataJsonResearchObject.get("authornames")); 						
	
        //related publications
        if (extendeddataJsonResearchObject.containsKey("publications"))
        	if (!(extendeddataJsonResearchObject.get("publications").equals("")))
        		fields.put("customfield_10307", extendeddataJsonResearchObject.get("publications"));		
             
        //license Question
        if (researchObjectJson.containsKey("licenseid")){

        	String licenseName = "";
        	JSONArray licenseArray = new JSONArray();
	            
        	String licenseId ="";
        	if (((researchObjectJson.get("licenseid").getClass()).toString()).equals("class java.lang.Long"))
        		licenseId = String.valueOf((long) researchObjectJson.get("licenseid"));
        	else
        		licenseId = (String) researchObjectJson.get("licenseid");
	                    		
        	JSONObject commandJson = new JSONObject();
        	commandJson.put("tablename","gfbio_license");
        	JSONArray allLicenseArray = new JSONArray();
        	allLicenseArray = HeadLocalServiceUtil.getTableAsJSONArrayByName(commandJson);

        	int i =0;
        	while (i <allLicenseArray.size()){
        		JSONObject licenseInformations =  (JSONObject) allLicenseArray.get(i);
        		if ((licenseId.equals((String) licenseInformations.get("id")))){
        			licenseName = (String)licenseInformations.get("label");
        			i = allLicenseArray.size();
        		}else
        			i = i+1;
        	}
        	license.put("value", licenseName);
        	fields.put("customfield_10202", license);
        }
	      
        fields.put("fooo", "fooo");
	      
        json.put("fields", fields);
        json.put("submittingUser", (long) researchObjectJson.get("submitterid"));
        try {json.put("authorization", "Token "+Helper.getServerInformation((String) requestJson.get("path"),"brokeragenttoken"));}
        catch (IOException | PortletException e) {e.printStackTrace();}
       
	
        System.out.println("---------------------");
        System.out.println("submission: "+json);
        System.out.println("---------------------");
	      
        String response = json.toJSONString();
        response = response.replaceAll("\\\\", "");
	           
        return response;
    }

}
