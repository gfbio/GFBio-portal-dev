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
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.json.simple.JSONArray;
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

		response.setContentType("text/html");
		
		if (request.getParameter("responseTarget") != null) {
			
			
			//
			if ("createproject".toString().equals(request.getParameter("responseTarget").toString()))
				createProject(request, response);
			
			//
			if ("createresearchobject".toString().equals(request.getParameter("responseTarget").toString()))
				createResearchObject(request, response);			
			
			
			//starts getCompleteProjectById of project
			if ("getfullnames".toString().equals(request.getParameter("responseTarget").toString()))
				getFullNamesAsString(request, response);
			
			//starts getCompleteProjectById of project
			if ("getproject".toString().equals(request.getParameter("responseTarget").toString()))
				getCompleteProjectById(request, response);
			
			//starts getResearchObjectById of researchobject
			if ("getresearchobjectbyid".toString().equals(request.getParameter("responseTarget").toString()))
				getResearchObjectById(request, response);
			
			//starts getRowInformationsOfRelationshipsOfSpecificCellContent of content
			if ("getresearchfieldinformations".toString().equals(request.getParameter("responseTarget").toString()))
				getRowInformationsOfRelationshipsOfSpecificCellContent(request, response);
			
			//starts service getTableAsJSONArrayByName of head 
			if ("gettablebyname".toString().equals(request.getParameter("responseTarget").toString()))
				getTableAsJsonArrayByName(request, response);
			
			//starts getUserExtentionById of userExtention
			if ("getuserbyid".toString().equals(request.getParameter("responseTarget").toString()))
				getUserExtentionById(request, response);
			
			//start submission
			if ("startsubmission".toString().equals(request.getParameter("responseTarget").toString()))
				startSubmission(request, response);

		}
	}
	
	
	
	
	///////////////////////////////////////////////get functions //////////////////////////////////////////////////

	//
	@SuppressWarnings("unchecked")
	public void getFullNamesAsString(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		if (parseJson.containsKey("projectid")) {
			if (((parseJson.get("projectid").getClass()).toString()).equals("class java.lang.Long"))
				responseJson.put("projectpi", Project_UserLocalServiceUtil.getFullNamesAsString(Project_UserLocalServiceUtil.getOwnerAndPiByProjectId((long) parseJson.get("projectid"))));
			else
				responseJson.put("projectpi", "");
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseJson.toString());
		}
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public void getCompleteProjectById(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		if (parseJson.containsKey("projectid")) {
			if (((parseJson.get("projectid").getClass()).toString()).equals("class java.lang.Long"))
				responseJson = ProjectLocalServiceUtil.getCompleteProjectById(parseJson);
			else
				responseJson.put("projectid", 0);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseJson.toString());
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
	public void getRowInformationsOfRelationshipsOfSpecificCellContent(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONArray responseJson = new JSONArray();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		
		responseJson = ContentLocalServiceUtil.getRowInformationsOfRelationshipsOfSpecificCellContent(parseJson);
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
	public void createProject (ResourceRequest request, ResourceResponse response){
    	
         String responseString = "";
		
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}

		responseString = (ProjectLocalServiceUtil.createProjectByJson(parseJson)).toString();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}

	}
	
	
	//
	public void createResearchObject (ResourceRequest request, ResourceResponse response){
    	
        String responseString = "";
		
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
	
		responseString = (ResearchObjectLocalServiceUtil.createResearchObjectByJson(parseJson)).toString();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}

	}
	
	
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void startSubmission (ResourceRequest request, ResourceResponse response){
    	
    	System.out.println("startSubmission");
    	
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		
		
		
		
        String responseString = "";

        try {

            URL url = new
            URL("http://helpdesk.gfbio.org/rest/api/2/issue/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept","application/json");
           
            String userpass = "uni-jena:GFBIOhelpdesk123";
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
            	System.out.println(output);
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

		System.out.println("request: "+requestJson);
		
		//preparation data source
		
		JSONObject projectJson = new JSONObject();
    	projectJson = (JSONObject) requestJson.get("mrr");
    	
		JSONObject submitterJson = new JSONObject();
    	submitterJson = UserExtensionLocalServiceUtil.getUserExtentionById((JSONObject) requestJson.get("submissionregistry"));
    	
    	String extendeddata ="";
    	JSONObject extendeddataJsonProject = new JSONObject();
    	extendeddata = (String) projectJson.get("extendeddata");
		try {extendeddataJsonProject = (JSONObject) parser.parse(extendeddata);}
		catch (ParseException e) {e.printStackTrace();}

    	JSONObject researchObjectJson = new JSONObject();
    	researchObjectJson = (JSONObject) projectJson.get("researchobjects");
		
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
        JSONArray nagojaArray = new JSONArray();
        JSONObject nagoja = new JSONObject();
        
        
        //ticket basic informations
        project.put("key", "SAND");
        fields.put("project", project);
        issuetype.put("name", "Data Submission");
        fields.put("issuetype", issuetype);	
        //reporter.put("name", "marcel.froemming@uni-jena.de");

        reporter.put("name", submitterJson.get("emailaddress"));
        fields.put("reporter", reporter);	
        fields.put("customfield_10010", "sand"+"/"+"collection-data2");
        fields.put("summary", "Automated Data Submission");

        
        //project informations
        
        //project id
        fields.put("customfield_10302", (long) projectJson.get("projectid"));					
        
        //project title
        fields.put("customfield_10206", projectJson.get("name"));								
        
        //project label
        projectlabelArray.add(projectJson.get("label"));
        fields.put("customfield_10300", projectlabelArray);										
        
        //project PI
        fields.put("customfield_10207", extendeddataJsonProject.get("pi"));						
        
        //project description
        fields.put("customfield_10301", projectJson.get("description"));						
  
        //project Keywords
        if (projectJson.containsKey("dcrtids")){
        	
        	JSONObject commandJson = new JSONObject();
        	commandJson.put("entitytablename","gfbio_type");
        	commandJson.put("relationtablename","gfbio_category_type");
        	commandJson.put("entitytablecellcontent","research field");
        	JSONArray allKeywordsArray = new JSONArray();
        	allKeywordsArray = ContentLocalServiceUtil.getRowInformationsOfRelationshipsOfSpecificCellContent(commandJson);
        	
        	String dcrtlabels = "";
        	JSONArray dcrtidArray = new JSONArray();
        	String dcrtids = (String) projectJson.get("dcrtids");
    		try {dcrtidArray = (JSONArray) parser.parse("["+dcrtids+"]");}
    		catch (ParseException e) {e.printStackTrace();}
    		
    		for (int i =0; i< dcrtidArray.size();i++){
    			int j =0;
    			while (j <allKeywordsArray.size()){
    				JSONObject keywordInformations =  (JSONObject) allKeywordsArray.get(j);
    				if ((String.valueOf((long) dcrtidArray.get(i))).equals((String) keywordInformations.get("id"))){
    					dcrtlabels = dcrtlabels.concat((String)keywordInformations.get("name"));
    					if (i < dcrtidArray.size()-1)
    						dcrtlabels = dcrtlabels.concat(", ");
    					j = allKeywordsArray.size();
    				}else
    					j = j+1;
    		}	}
        	keywordArray.add(dcrtlabels);
        	fields.put("customfield_10306", keywordArray);											
        }


        //dataset informations
        
        //dataset id 
        fields.put("customfield_10309",String.valueOf((long) researchObjectJson.get("researchobjectid")));						
        
        //dataset title
        fields.put("customfield_10201", researchObjectJson.get("name")); 						
        
        //dataset version
        fields.put("customfield_10310", String.valueOf((long) researchObjectJson.get("researchobjectversion"))); 							
        
        //dataset label
        datasetlabelArray.add(researchObjectJson.get("label"));
        fields.put("customfield_10308", datasetlabelArray); 			
        
        //dataset description
        fields.put("customfield_10208", researchObjectJson.get("description"));	
        
        //dataset author
        if (extendeddataJsonResearchObject.containsKey("authornames"))
        	if (!(extendeddataJsonResearchObject.get("authornames").equals("")))
        		fields.put("customfield_10205", extendeddataJsonResearchObject.get("authornames")); 						

        //dataset collection time
        if (extendeddataJsonResearchObject.containsKey("datacollectiontime"))
        	if (!(extendeddataJsonResearchObject.get("datacollectiontime").equals("")))
        		fields.put("customfield_10311", extendeddataJsonResearchObject.get("datacollectiontime")); 			
        
        //related publications
        if (extendeddataJsonResearchObject.containsKey("publications"))
        	if (!(extendeddataJsonResearchObject.get("publications").equals("")))
        		fields.put("customfield_10307", extendeddataJsonResearchObject.get("publications"));		
        
       //metadata shema description
        if (researchObjectJson.containsKey("metadataid")){
            
            String metadataName = "";
			JSONArray metadataValueArray = new JSONArray();
            
			String matadataId ="";
			if (((researchObjectJson.get("metadataid").getClass()).toString()).equals("class java.lang.Long"))
            	matadataId = String.valueOf((long) researchObjectJson.get("metadataid"));
            else
            	matadataId = (String) researchObjectJson.get("metadataid");
            
            		
            JSONObject commandJson = new JSONObject();
            commandJson.put("tablename","gfbio_metadata");
            JSONArray allMetadataArray = new JSONArray();
            allMetadataArray = HeadLocalServiceUtil.getTableAsJSONArrayByName(commandJson);

       		int i =0;
       		while (i <allMetadataArray.size()){
       			JSONObject metadataInformations =  (JSONObject) allMetadataArray.get(i);
        		if ((matadataId.equals((String) metadataInformations.get("id")))){
        			metadataName = (String)metadataInformations.get("label");
       				i = allMetadataArray.size();
        		}else
        			i = i+1;
        	}

            metadata.put("value", metadataName);
            metadataArray.add(metadata);
            fields.put("customfield_10229", metadataArray);	
        }
               
      //nagoja Question 	
      if (extendeddataJsonResearchObject.containsKey("nagoja"))
    	  if (!(extendeddataJsonResearchObject.get("nagoja").equals("")))
    		  if (extendeddataJsonResearchObject.get("nagoja").equals("yes")){
    			  nagoja.put("value", "Nagoja");
    			  nagojaArray.add(nagoja);
    			  fields.put("customfield_10216", nagojaArray);
    		  }
			       
	      //license Question
	      if (researchObjectJson.containsKey("licenseids")){
	    	  
		      	JSONObject commandJson = new JSONObject();
		      	commandJson.put("tablename","gfbio_license");
		      	JSONArray allLicensesArray = new JSONArray();
		      	allLicensesArray = HeadLocalServiceUtil.getTableAsJSONArrayByName(commandJson);
		      	String licenseName = "";
		      	JSONArray licenseArray = new JSONArray();
		      	String licenseids = (String) researchObjectJson.get("licenseids");
		  		try {licenseArray = (JSONArray) parser.parse("["+licenseids+"]");}
		  		catch (ParseException e) {e.printStackTrace();}
		  		
		  		for (int i =0; i< licenseArray.size();i++){
		  			int j =0;
		  			while (j <allLicensesArray.size()){
		  				JSONObject keywordInformations =  (JSONObject) allLicensesArray.get(j);
		  				if ((String.valueOf((long) licenseArray.get(i))).equals((String) keywordInformations.get("id"))){
		  					licenseName = licenseName.concat((String)keywordInformations.get("label"));
		  					if (i < licenseArray.size()-1)
		  						licenseName = licenseName.concat(", ");
		  					j = allLicensesArray.size();
		  				}else
		  					j = j+1;
		  		}	}
		        license.put("value", licenseName);
		        fields.put("customfield_10202", license);											
	      }
	      
	      json.put("fields", fields);
	
	      String response = json.toJSONString();
	      response = response.replaceAll("\\\\", "");
	      //System.out.println("json-test: "+response);
	           
	     return response;
    }
	
	
}
