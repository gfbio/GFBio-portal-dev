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
		
		System.out.println("yeah");
		
		if (request.getParameter("responseTarget") != null) {

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
	
   
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public String startSubmission (ResourceRequest request, ResourceResponse response){
    	
		JSONArray responseJson = new JSONArray();
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		
		System.out.println("Es hat begonnen");
		System.out.println(parseJson);
		
        String response2 = "";

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
                response2 = response2.concat(output);
            } 

            conn.disconnect();
         } catch (Exception e) {e.printStackTrace();}
       
        return response2;
    }
   
   
    @SuppressWarnings("unchecked")
    private static String getJSON_Body(JSONObject requestJson){
        
    	JSONObject projectJson = new JSONObject();
    	JSONObject researchObjectJson = new JSONObject();
    	JSONObject submitterJson = new JSONObject();
    	
    	//JSONObject exdataJson = new JSONObject();
    	//JSONObject exdataJsonProject = new JSONObject();
    	//JSONArray  roArray = new JSONArray();
    	
    	JSONObject exdataJsonRO = new JSONObject();
    	
    	submitterJson = (JSONObject) requestJson.get("submissionregistry");
    	projectJson = (JSONObject) requestJson.get("mrr");
    	researchObjectJson = (JSONObject) projectJson.get("researchobjects");
    	//exdataJsonProject = (JSONObject) requestJson.get("extendeddata");
    	//roArray = (JSONObject) requestJson.get("researchobjects");
    	
    	exdataJsonRO = (JSONObject) researchObjectJson.get("extendeddata");
    	
        JSONObject json = new JSONObject();
        JSONObject fields = new JSONObject();
        
        JSONObject project = new JSONObject();
        JSONObject issuetype = new JSONObject();
        JSONObject reporter = new JSONObject();
        
        JSONArray keywordArray = new JSONArray();
        JSONArray projectlabelArray = new JSONArray();
        JSONObject submitter = new JSONObject();
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
        reporter.put("name", "testuser1");
        fields.put("reporter", reporter);	
        fields.put("customfield_10010", "sand"+"/"+"collection-data2");
        fields.put("summary", "Automated Data Submission");

        //project informations
        fields.put("customfield_10302", (long) projectJson.get("projectid"));								//project id
        fields.put("customfield_10206", projectJson.get("name"));		//project title
        projectlabelArray.add(projectJson.get("label"));
        fields.put("customfield_10300", projectlabelArray);				//project label
        fields.put("customfield_10207", "test PI");						//project PI
        fields.put("customfield_10301",  projectJson.get("description"));			//project description
        keywordArray.add("bioKeywordTest");
        fields.put("customfield_10306", keywordArray);					//keywords

        
        //submission information
        fields.put("customfield_10304", "submitter id");				//submitter id
        submitter.put("name", "testuser1");
        fields.put("customfield_10305", submitter);						//submitter name
        //fields.put("customfield_10309", "1");							//submitter mail
        
       //dataset informations
       // fields.put("customfield_10309",roJson.get("researchobjectid"));							//dataset id
       fields.put("customfield_10201", researchObjectJson.get("name")); 						//dataset title
       /*fields.put("customfield_10310", researchObjectJson.get("researchobjectversion")); 							//dataset version
        datasetlabelArray.add(researchObjectJson.get("label"));
        fields.put("customfield_10308", datasetlabelArray); 			//dataset label
        fields.put("customfield_10205", researchObjectJson.get("authornames")); 					//dataset author	
        */fields.put("customfield_10311", exdataJsonRO.get("datacollectiontime")); 			//dataset collection time
        fields.put("customfield_10208", researchObjectJson.get("description"));	//dataset description
        fields.put("customfield_10307", exdataJsonRO.get("publications"));		//related publications
        metadata.put("value", "Darwin Core");
        metadataArray.add(metadata);
        fields.put("customfield_10229", metadataArray);					//metadata shema description
        nagoja.put("value", "Nagoya");
        nagojaArray.add(nagoja);
        fields.put("customfield_10216", nagojaArray);					//nagoja Question        
        license.put("value", "CC BY");
        fields.put("customfield_10202", license);						//license Question
       /* */
        json.put("fields", fields);

        //System.out.println(json);
        String response = json.toJSONString();
        System.out.println("json-test: "+response);
        response = response.replaceAll("\\\\", "");
        System.out.println("json-test: "+response);
           
        return response;
    }
	
	
}
