package org.gfbio.submissionworkflow;

//import LiferayWebserviceClientCallPortalServices;


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.IOUtils; //wichtig für fileupdate, auch wenn es hier als ungenutzt angezeigt wird
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.gfbio.helper.Helper;
import org.gfbio.model.DataManagementPlan;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.DataManagementPlanLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



/**
 * Portlet implementation class WorkflowGeneric
 */
@SuppressWarnings("deprecation")
public class WorkflowGeneric extends GenericPortlet {
	
    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(WorkflowGeneric.class);
    
    
	public void init() {
		   	
		viewTemplate = getInitParameter("view-template");
    }

    
    public void doView( RenderRequest renderRequest, RenderResponse renderResponse)     throws IOException, PortletException {
	 
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

			//
			if ("createsubmissionregistry".toString().equals(request.getParameter("responseTarget").toString()))
				createSubmissionRegistry(request, response);
			
			//
			if ("delsubreg".toString().equals(request.getParameter("responseTarget").toString()))
				deleteSubmissionRegistryEntry(request, response);
			
			//
			if ("getbrokersubmissionid".toString().equals(request.getParameter("responseTarget").toString()))
				getBrokerSubmissionId(request, response);
			
			//starts getRowInformationsOfRelationshipsOfSpecificCellContent of content
			if ("getresearchfieldinformations".toString().equals(request.getParameter("responseTarget").toString()))
				getRowInformationsOfRelationshipsOfSpecificCellContent(request, response);
			
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
			if ("registerfileupload".toString().equals(request.getParameter("responseTarget").toString()))
				registerFileUpload(request, response);
			
			//
			if ("resetportletsession".toString().equals(request.getParameter("responseTarget").toString())){
				resetPortletSession(request, response);
			}
			
			//
			if ("startsubmission".toString().equals(request.getParameter("responseTarget").toString()))
				startSubmission(request, response);


			
		}else{
			uploadFile(request, response);
		}
	}
	
	
	//////////////////////////////////////////////////////////// delete functions ////////////////////////////////////////
	
	
	//
	public void deleteSubmissionRegistryEntry(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
        JSONObject parseJson = getDataJsonAsObject (request);
        
		responseJson = SubmissionLocalServiceUtil.deleteSubmission(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}	
	
	
	//
	public void resetPortletSession(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		PortletSession session = request.getPortletSession();
		session.removeAttribute("physical",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("taxon",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("alive",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("sequenced",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("dataCenter",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("category",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("physical",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("material",PortletSession.APPLICATION_SCOPE);
		session.removeAttribute("possibleDataCenter",PortletSession.APPLICATION_SCOPE);
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.flush();
		writer.close();

		super.serveResource(request, response);
	}	
	
	
	////////////////////////////////////////////////////////////// get functions //////////////////////////////////////////	
		
	//
	
	public void getBrokerSubmissionId(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		
		JSONObject responseJson = new JSONObject();
		JSONObject parseJson = getDataJsonAsObject (request);

		responseJson = SubmissionLocalServiceUtil.getBrokerSubmissionId(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
	
	
	//
	public void getResearchObjectById(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		 
		JSONArray responseJson = new JSONArray();
        JSONArray parseJson = getDataJsonAsArray (request);

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
        JSONObject parseJson = getDataJsonAsObject (request);

		responseJson = HeadLocalServiceUtil.getTableAsJSONArrayByName(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
	
	
	//
	public void getUserExtentionById(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		JSONObject responseJson = new JSONObject();
        JSONObject parseJson = getDataJsonAsObject (request);

		responseJson = UserExtensionLocalServiceUtil.getUserExtentionById(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
	
	
	////////////////////////////////////////////////////////////// helper functions //////////////////////////////////////////
 

/*    //
    private static JSONObject getBrokerAuthorization(String path) throws IOException, PortletException {
    	
    	JSONObject responseJson = new JSONObject();
		JSONParser parser = new JSONParser();	
		File file = new File(path.trim() +"..\\..\\..\\server_specific_identification\\brokeragent.txt");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			int content;
			String preJson ="";
			
			while ((content = fis.read()) != -1)
				preJson = preJson+(char) content;
			
			try {responseJson = (JSONObject) parser.parse(preJson);}
			catch (ParseException e) {e.printStackTrace();}
	
		} catch (IOException e) {e.printStackTrace();}
		finally {
			try {if (fis != null)fis.close();} 
			catch (IOException ex) {ex.printStackTrace();}
		}
		
		return responseJson;
	}
    */
	
	//
	private JSONArray getDataJsonAsArray (ResourceRequest request){

		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {parseJson = (JSONArray) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		return parseJson;
	}
	
	
	//
	private JSONObject getDataJsonAsObject (ResourceRequest request){

		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		return parseJson;
	}
	
	
    //
    @SuppressWarnings({ "unchecked", "unused" })
    private static String getJSON_Body(JSONObject requestJson){
    	   	
      	JSONParser parser = new JSONParser();
      	String archive = "GFBio collections";
		
		//preparation data source
		
/*    	System.out.println("--------------------------------");
    	System.out.println(requestJson);
    	System.out.println("--------------------------------");*/
    	 
    	_log.info("--------------------------------");
    	_log.info(requestJson);
    	_log.info("--------------------------------");
    	
		JSONObject projectJson = new JSONObject();
    	projectJson = (JSONObject) requestJson.get("mrr");
    	    	
    	JSONObject researchObjectJson = new JSONObject();
    	researchObjectJson = (JSONObject) projectJson.get("researchobjects");

		JSONObject submitterJson = new JSONObject();
		submitterJson.put("userid", (long) researchObjectJson.get("userid"));
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

        
        //ticket basic informations
        try {project.put("key", Helper.getServerInformation((String) requestJson.get("path"),"jiraprojectkey"));}
        catch (IOException | PortletException e1) {e1.printStackTrace();}
        fields.put("project", project);
        issuetype.put("name", "Data Submission");
        fields.put("issuetype", issuetype);	
        reporter.put("name", submitterJson.get("emailaddress"));
        fields.put("reporter", reporter);	
        try {fields.put("customfield_10010", Helper.getServerInformation((String) requestJson.get("path"),"jiracustomfield10010"));}
        catch (IOException | PortletException e1) {e1.printStackTrace();}
        if (researchObjectJson.containsKey("name")){
        	String name = Helper.getStringFromJson(researchObjectJson, "name");
        	if (name.length()>47)
        		name = name.substring(0, 44).concat("...");
        	name = JSONObject.escape(name);
        	fields.put("summary",name);
        }
   		else
   			fields.put("summary", "Automated Data Submission");

        
        //project informations
        
        
        //project id
        if (projectJson.containsKey("projectid")){
        	String projectIdString = Helper.getStringFromJson(projectJson, "projectid");
        	if (!projectIdString.equals("0"))
        		fields.put("customfield_10314", projectIdString);
        }
        
        
        //dcrt information
        
        
        //assignee
          
        
        if (projectJson.containsKey("dcrtassignee")){
	        if (!((Helper.getStringFromJson(projectJson, "dcrtassignee")).toLowerCase().equals("none"))){
	        	JSONObject assignee = new JSONObject();
	        	assignee.put("name", (Helper.getStringFromJson(projectJson, "dcrtassignee")).toLowerCase()) ;
	            fields.put("assignee", assignee);	
	            archive = Helper.getStringFromJson(projectJson, "dcrtassignee");
        	}
        }  
    
        
        //recommendation
        if (projectJson.containsKey("dcrtrecommendation")){
        	String dcrtRecommendation = Helper.getStringFromJson(projectJson, "dcrtrecommendation");
        	if(!dcrtRecommendation.equals("null") && !dcrtRecommendation.equals("")){
	        	JSONArray dcrtInformationArray = new JSONArray();
	        	List<String> items = Arrays.asList(dcrtRecommendation.split(","));
	        	for(int i=0; i < items.size();i++){
	        		JSONObject dcrtInformationJson = new JSONObject();
	        		dcrtInformationJson.put("value", (items.get(i)).trim());
	            	dcrtInformationArray.add(dcrtInformationJson);
	        	}
	        	fields.put("customfield_10217", dcrtInformationArray);
        	}
        }
        
       
        //information / input
        if (projectJson.containsKey("dcrtinput")){
        	if (Helper.getJsonObjectFromJson(projectJson, "dcrtinput").size()>0)
        		fields.put("customfield_10500", Helper.getStringFromJson(projectJson, "dcrtinput"));
        }
                
        
        //dataset informations
        
        
        //dataset indetifier
        if (researchObjectJson.containsKey("researchobjectid")){
        	fields.put("customfield_10309",JSONObject.escape(Helper.getStringFromJson(researchObjectJson, "researchobjectid")));
        	fields.put("customfield_10310",JSONObject.escape(Helper.getStringFromJson(researchObjectJson, "researchobjectversion")));
        }

        
        //dataset title
        fields.put("customfield_10201", JSONObject.escape(Helper.getStringFromJson(researchObjectJson,"name"))); 							
        
        //dataset label
        datasetlabelArray.add((Helper.getStringFromJson(researchObjectJson, "label")).trim().replace(' ', '_'));
        fields.put("customfield_10308", datasetlabelArray); 			
        
        //dataset description
        fields.put("customfield_10208", JSONObject.escape(Helper.getStringFromJson(researchObjectJson, "description")));

        
        //dataset author
        if (researchObjectJson.containsKey("authornames")){
        	if (!(researchObjectJson.get("authornames").equals(""))){
        		
        		JSONParser parser2 = new JSONParser();
				JSONArray parseJson = new JSONArray();
				try {parseJson = (JSONArray) parser2.parse((String) researchObjectJson.get("authornames"));}
				catch (ParseException e) {e.printStackTrace();}

				if (parseJson.size()>0){
	        		String inputString ="";
	        		for (int i =0; i< parseJson.size();i++){
	        			String author = ((String) parseJson.get(i)).trim();
	        			inputString = inputString.concat(author).concat(", ");
	        		}
	        		inputString = inputString.substring(0, inputString.length()-2);
	        		
	        		fields.put("customfield_10205", JSONObject.escape(inputString));
				}
        	}
        }
        
        //dataset collection time
        if (extendeddataJsonResearchObject.containsKey("datacollectiontime"))
        	if (!(extendeddataJsonResearchObject.get("datacollectiontime").equals("")))
        		fields.put("customfield_10311", JSONObject.escape((String) extendeddataJsonResearchObject.get("datacollectiontime"))); 			
        
        
        //related publications
        if (extendeddataJsonResearchObject.containsKey("publications"))
        	if (!(extendeddataJsonResearchObject.get("publications").equals("")))
        		fields.put("customfield_10307", JSONObject.escape((String) extendeddataJsonResearchObject.get("publications")));		
        
       //metadata shema description
        if (researchObjectJson.containsKey("metadataid")){
        	if (Helper.getLongFromJson(researchObjectJson, "metadataid")!=0){
        	
	        	String metadataId = JSONObject.escape(Helper.getStringFromJson(researchObjectJson, "metadataid"));     	
	            String metadataName = "";
				JSONArray metadataValueArray = new JSONArray();
				
	            		
	            JSONObject commandJson = new JSONObject();
	            commandJson.put("tablename","gfbio_metadata");
	            JSONArray allMetadataArray = new JSONArray();
	            allMetadataArray = HeadLocalServiceUtil.getTableAsJSONArrayByName(commandJson);
	
	       		int i =0;
	       		while (i <allMetadataArray.size()){
	       			JSONObject metadataInformations =  (JSONObject) allMetadataArray.get(i);
	        		if ((metadataId.equals((String) metadataInformations.get("id")))){
	        			metadataName = (String)metadataInformations.get("label");
	       				i = allMetadataArray.size();
	        		}else{
	        			if ((metadataId.equals((String) metadataInformations.get("label")))){
	            			metadataName = (String)metadataInformations.get("label");
	           				i = allMetadataArray.size();
	        			}else{
	        				i = i+1;
	        			}
	        		}
	        	}
	            metadata.put("value", JSONObject.escape(metadataName));
	            metadataArray.add(metadata);
	            fields.put("customfield_10229", metadataArray);	
        	}
        }
        
        //Embargo
        if (extendeddataJsonResearchObject.containsKey("embargo"))
        	if (!(Helper.getStringFromJson(extendeddataJsonResearchObject, "embargo").equals("")))
        		fields.put("customfield_10200", JSONObject.escape(Helper.getStringFromJson(extendeddataJsonResearchObject, "embargo")));
        
        //Category/Keywords
        if (researchObjectJson.containsKey("categoryids")){
        	if (!(researchObjectJson.get("categoryids").equals(""))){
        		JSONArray categoryArray = (JSONArray) researchObjectJson.get("categoryids");
        		if (categoryArray.size()>0){
	        		String categoryString = "";
	        		
	        		if (categoryArray.size()>0){
	        			for (int i=0;i<categoryArray.size();i++)
	        				categoryString = categoryString.concat(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdByCellContent("gfbio_category", "id", (String) categoryArray.get(i)), "name")).concat(", ");
	        			categoryString = categoryString.substring(0, categoryString.length()-2);
	        		}
	                fields.put("customfield_10313", JSONObject.escape(categoryString)); 	
        		}
        	}
        }
        
        //legal requirements
         if (extendeddataJsonResearchObject.containsKey("legalrequirements")){
        	if (!(extendeddataJsonResearchObject.get("legalrequirements").equals(""))){
        		JSONArray legalRequirementArray = new JSONArray();
        		JSONArray legalRequirementIdArray = (JSONArray) extendeddataJsonResearchObject.get("legalrequirements");
        		if (legalRequirementIdArray.size()>0){
	        		//String legalRequirementString = "";
	        		for (int i=0;i<legalRequirementIdArray.size();i++){
        				//legalRequirementString = legalRequirementString.concat(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdByCellContent("gfbio_legalrequirement", "id", (String) legalRequirementIdArray.get(i)), "name")).concat(", ");
        				JSONObject legalRequirements = new JSONObject();
 	        			legalRequirements.put("value", JSONObject.escape(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdByCellContent("gfbio_legalrequirement", "id", (String) legalRequirementIdArray.get(i)), "name")));
 	        		  	legalRequirementsArray.add(legalRequirements);
	        		}
	        		//legalRequirementString = legalRequirementString.substring(0, legalRequirementString.length()-2);
	        		fields.put("customfield_10216", legalRequirementsArray);                 	
        		}
        	}
        }
         
        
        //license Question
        if (researchObjectJson.containsKey("licenseid")){
        	if (Helper.getLongFromJson(researchObjectJson, "licenseid")!=0){

	        	String licenseName = "";
	        	JSONArray licenseArray = new JSONArray();
	         	String licenseId = JSONObject.escape(Helper.getStringFromJson(researchObjectJson, "licenseid"));
		                    		
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
	        	license.put("value", JSONObject.escape(licenseName));
	        	fields.put("customfield_10202", license);
        	}
        }
        
        if (researchObjectJson.containsKey("primarydata")){
        	JSONObject primaryData = Helper.getJsonObjectFromJson(researchObjectJson, "primarydata");
        	String primaryDataPath = Helper.getStringFromJson(primaryData, "path");
        	fields.put("customfield_10600 ", primaryDataPath);
        	
        }
        

        long researchObjectId =Helper.getLongFromJson(researchObjectJson, "researchobjectid");
        int researchObjectVersion = Helper.getIntFromJson(researchObjectJson, "researchobjectversion");
        _log.info("archive: |"+archive+"|");
        fields.put("customfield_10303", (SubmissionLocalServiceUtil.getBrokerSubmissionIdByIds(researchObjectId, researchObjectVersion, archive.trim())).trim());

        //this line ist for testing and stop the submission to JIRA
        //fields.put("customfield_1", "stopper");
        
        
        json.put("archive", archive);
        json.put("fields", fields);
        json.put("submittingUser", (long) researchObjectJson.get("userid"));
        try {json.put("authorization", "Token "+Helper.getServerInformation((String) requestJson.get("path"),"brokeragenttoken"));}
        catch (IOException | PortletException e) {e.printStackTrace();}
       	
       
        String response = json.toJSONString();
             
        response = response.replaceAll("\\\\\\\\n", "----n");
        response = response.replaceAll("\\\\\\\\t", "----t");
        response = response.replaceAll("\\\\\\\\", "------");
        response = response.replaceAll("------------", "\\\\\\\\");
        response = response.replaceAll("------", "");
        response = response.replaceAll("----n", "\\\\n");
        response = response.replaceAll("----t", "\\\\t");
        
      System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println(response);
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        
        _log.info("--------------------------------");
    	_log.info(response);
    	_log.info("--------------------------------");
	           
        return response;
    }
    

	////////////////////////////////////////////////////////////// update functions //////////////////////////////////////////
		
	
	//
	@SuppressWarnings("unchecked")
	public void createResearchObject (ResourceRequest request, ResourceResponse response){
		
        String responseString = "";
        JSONObject parseJson = getDataJsonAsObject (request);
		responseString = (ResearchObjectLocalServiceUtil.createResearchObjectByJson(parseJson)).toString();
		
		if (parseJson.containsKey("primarydata")){
			JSONObject primaryDataJson = new JSONObject();
			primaryDataJson = Helper.getJsonObjectFromJson(parseJson, "primarydata");
			JSONParser parser = new JSONParser();
			try {parseJson = (JSONObject) parser.parse(responseString);}
			catch (ParseException e) {e.printStackTrace();}
			if (parseJson.containsKey("researchobjectid")){
				primaryDataJson.put("researchobjectid", Helper.getLongFromJson(parseJson, "researchobjectid"));
				primaryDataJson.put("researchobjectversion", Helper.getLongFromJson(parseJson, "researchobjectversion"));
			}
			parseJson = PrimaryDataLocalServiceUtil.createPrimaryData(primaryDataJson);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}
	}
	
	
	//
	public void createSubmissionRegistry (ResourceRequest request, ResourceResponse response){
    	
        String responseString = "";
		
		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
				
		responseString = (SubmissionLocalServiceUtil.createSubmission(parseJson)).toString();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}

	}
	
	
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @SuppressWarnings({ "unchecked", "resource" })
	public void startSubmission (ResourceRequest request, ResourceResponse response){

    	String responseString = "";    	
        JSONObject parseJson = getDataJsonAsObject (request);
/*        try {_log.info("result: "+requestDB());}
        catch (UnsupportedEncodingException e1) {e1.printStackTrace();}*/
        
        try {
       
        	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost post = new HttpPost("https://helpdesk.gfbio.org/rest/api/2/issue/");
            post.addHeader("Content-Type","application/json");
            post.addHeader("Accept","application/json");
            post.addHeader("setDoInput","true");
            post.addHeader("setDoOutput","true");
            
            String userpass= Helper.getServerInformation((String) ((JSONObject) parseJson).get("path"),"jirauserpass");
            String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
            if (basicAuth != null) 
                post.addHeader("Authorization", basicAuth);

            String jiraRequestString = getJSON_Body((JSONObject) parseJson);
            
            HttpEntity entity = new ByteArrayEntity(jiraRequestString.getBytes(StandardCharsets.UTF_8));
            post.setEntity(entity);
            HttpResponse resp = httpclient.execute(post);
             
            if (!((resp.getStatusLine().toString()).contains("HTTP/1.1 201"))) {
            	_log.info("Failed : HTTPS error code : "+resp.getStatusLine());
            	throw new RuntimeException("Failed : HTTPS error code : " + resp.getStatusLine());
	        }else{
 	        
	        	String result = EntityUtils.toString(resp.getEntity());
	        	_log.info("Output from Server .... \n");
	        	_log.info("result: "+result);
	            
	        	JSONParser parser = new JSONParser();
	        	JSONObject jiraResponseJson = new JSONObject();
	        	try {jiraResponseJson = (JSONObject) parser.parse(result);}
	        	catch (ParseException e) {e.printStackTrace();}
				
	        	JSONObject jiraRequestJson = new JSONObject();
	        	try {jiraRequestJson = (JSONObject) parser.parse(jiraRequestString);}
				catch (ParseException e) {e.printStackTrace();}
					
				JSONObject fieldJson = (JSONObject) jiraRequestJson.get("fields");
				long researchObjectId = Long.parseLong((String)fieldJson.get("customfield_10309"));
				int researchObjectVersion = Integer.parseInt((String) fieldJson.get("customfield_10310"));
				//String archive = (String) jiraRequestJson.get("archive");
				String archive = Helper.getStringFromJson(jiraRequestJson, "archive");
				_log.info("archive: "+archive);
				SubmissionLocalServiceUtil.updateJiraKey(researchObjectId, researchObjectVersion, archive, (String) jiraResponseJson.get("key"));
				SubmissionLocalServiceUtil.updateJiraId (researchObjectId, researchObjectVersion, archive, (String) jiraResponseJson.get("id"));

				if (PrimaryData_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId,researchObjectVersion)){
					List <Long> idList = PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDataIdsByResearchObjectIdAndVersion(researchObjectId,researchObjectVersion);
					Boolean check = true;
					int i =0;
					while (i<idList.size() && check){
						check = addAttachmentToIssue(userpass, (String) jiraResponseJson.get("id"), (String) PrimaryDataLocalServiceUtil.getPathByPrimaryDataId(idList.get(i)));
						i = i+1;
					}
					jiraResponseJson.put("fileToJiraResponse", check);
				}
				responseString = responseString.concat(jiraResponseJson.toString());
	        }
            httpclient.getConnectionManager().shutdown();
            
        }catch (Exception e) {
        	e.printStackTrace();
        	_log.info(e);
        }
                    
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {
			e.printStackTrace();
			_log.info(e.toString());
		}
    }


    //
	@SuppressWarnings("resource")
	public Boolean addAttachmentToIssue(String userpass, String issueKey, String path){

		try{
			
			URL url = new URL("https://helpdesk.gfbio.org/rest/api/2/issue/"+issueKey+"/attachments");

			String auth = new String(org.apache.commons.codec.binary.Base64.encodeBase64((userpass).getBytes()));

		    HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost(url.toString());
		    httppost.setHeader("X-Atlassian-Token", "nocheck");
		    httppost.setHeader("Authorization", "Basic "+auth);
		    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

		    File fileToUpload = new File(path);
		    FileBody fileBody = new FileBody(fileToUpload, "application/octet-stream");
		    entity.addPart("file", fileBody);

		    httppost.setEntity(entity);
		    HttpResponse response = null;
		    try {response = httpclient.execute(httppost);}
		    catch (ClientProtocolException e) {return false;}
		    catch (IOException e) {return false; }
		    
		    //HttpEntity result = response.getEntity();
		    if(response.getStatusLine().getStatusCode() == 200)
		        return true;
		    else
		        return false;
			
	    } catch (IOException e) {e.printStackTrace();}
		
		return null;
	}

    
    //
	public HttpServletRequest getOriginalHttpServletRequest(PortletRequest request) {
        return PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
    }
    
	
    ////////////////////////////////////////////////////////////  Upload  //////////////////////////////////////////////////////////////////////////////////
    
	
    //
	@SuppressWarnings("unchecked")
	public void uploadFile (ResourceRequest request, ResourceResponse response){
		
		JSONArray dbJson = new JSONArray(); 
		File file = null;
		file = new File("test");
		final HttpServletRequest originalHttpServletRequest = getOriginalHttpServletRequest(request);
	    final boolean multipartContent = FileUploadBase.isMultipartContent(new ServletRequestContext(originalHttpServletRequest));

	    if (multipartContent) {

	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(10000000);
	        factory.setRepository(file);
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setSizeMax(10000000);
	        List<FileItem> items = null;
	        try {items = upload.parseRequest(originalHttpServletRequest);}
	        catch (FileUploadException e1) {e1.printStackTrace(); }
	    	long researchObjectId = 0;
	    	int  researchObjectVersion = 0;
	    	long  userId = 0;
	    	String path = "C:\\liferay-primary-data-folder";
	        Iterator<FileItem> iter = items.iterator();
	        
	        while (iter.hasNext()) {
	        	
	        	FileItem thisItem = (FileItem) iter.next();
	        	if ((thisItem.getName()).equals("uploadInformation.txt")) {
	        		JSONObject roJson = new JSONObject();
	        		JSONParser parser = new JSONParser();
	    			try {roJson = (JSONObject) parser.parse(thisItem.getString());}
	    			catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
	        		researchObjectId = (long) roJson.get("researchobjectid");
	        		researchObjectVersion = (int) (long) roJson.get("researchobjectversion");
	        		userId = (long) roJson.get("userid");
	        	} else {
	        		String userPath = path+File.separator+userId+File.separator+researchObjectId+File.separator+researchObjectVersion;
	        		File files = new File(userPath);
	        		if (!files.exists()) 
	        	     	files.mkdirs(); 
	        		JSONObject fileJson = new JSONObject();
	        		fileJson.put("researchobjectid", researchObjectId);
	        		fileJson.put("researchobjectversion", researchObjectVersion);
	        		fileJson.put("name", thisItem.getName());
	        		fileJson.put("path", userPath);
	        		dbJson.add(fileJson);
	        		File fileOut = new File(userPath, thisItem.getName());
	        		try {thisItem.write(fileOut);} 
	        		catch (Exception e) {e.printStackTrace();}
	        	}
	        }
	        PrimaryDataLocalServiceUtil.createPrimaryData(dbJson);
	    }
	}

	
	//
	public void registerFileUpload(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		
		JSONArray responseJson = new JSONArray();
        JSONArray parseJson = getDataJsonAsArray (request);

		responseJson = PrimaryDataLocalServiceUtil.createPrimaryData(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
	}
	
	
	
	
	
	
	
	
	
	
	


}
