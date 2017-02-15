package org.gfbio.submissionworkflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
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
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class WorkflowGeneric
 */
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

			//
			if ("registerfileupload".toString().equals(request.getParameter("responseTarget").toString()))
				registerFileUpload(request, response);
			
		}else{
			uploadFile(request, response);
		}
	}
	
	
	////////////////////////////////////////////////////////////// get functions //////////////////////////////////////////	
	
	
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
 

    //
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
		
		//preparation data source
		
		JSONObject projectJson = new JSONObject();
    	projectJson = (JSONObject) requestJson.get("mrr");
    	
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
        project.put("key", "SAND");
        fields.put("project", project);
        issuetype.put("name", "Data Submission");
        fields.put("issuetype", issuetype);	
        reporter.put("name", submitterJson.get("emailaddress"));
        fields.put("reporter", reporter);	
        fields.put("customfield_10010", "sand"+"/"+"generic-data");
        fields.put("summary", "Automated Data Submission");

        
        //project informations
        
        
        //project id
        if (projectJson.containsKey("projectid"))
        	if (!((String) projectJson.get("projectid")).equals("0"));
        		fields.put("customfield_10314", (String) projectJson.get("projectid"));					
        

        //dataset informations
        
        		
        if (researchObjectJson.containsKey("researchobjectid"))
        	if (!((String) projectJson.get("researchobjectid")).equals("0")){
        		
        		//dataset id 
        		fields.put("customfield_10309",String.valueOf((long) researchObjectJson.get("researchobjectid")));	
        		
                //dataset version
                fields.put("customfield_10310", String.valueOf((long) researchObjectJson.get("researchobjectversion"))); 		
        	}
        
        //dataset title
        fields.put("customfield_10201", researchObjectJson.get("name")); 							
        
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
            
			String metadataId ="";
			if (((researchObjectJson.get("metadataid").getClass()).toString()).equals("class java.lang.Long"))
            	metadataId = String.valueOf((long) researchObjectJson.get("metadataid"));
            else
            	metadataId = (String) researchObjectJson.get("metadataid");
            		
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
            metadata.put("value", metadataName);
            metadataArray.add(metadata);
            fields.put("customfield_10229", metadataArray);	
        }
               
        //Embargo
        if (extendeddataJsonResearchObject.containsKey("embargo"))
        	if (!(extendeddataJsonResearchObject.get("embargo").equals("")))
      		fields.put("customfield_10200", extendeddataJsonResearchObject.get("embargo"));
        
        //nagoya Question 	
        if (extendeddataJsonResearchObject.containsKey("legalrequirements"))
        	if (!(extendeddataJsonResearchObject.get("legalrequirements").equals(""))){
        		legalRequirements.put("value", (String) extendeddataJsonResearchObject.get("legalrequirements"));
    		  	legalRequirementsArray.add(legalRequirements);
    			fields.put("customfield_10216", legalRequirementsArray);
        	}
			       
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
	      
        json.put("fields", fields);
        json.put("submittingUser", (long) researchObjectJson.get("submitterid"));
        try {json.put("authorization", "Token "+WorkflowENAPortlet.getServerToken((String) requestJson.get("path"),"token"));}
        catch (IOException | PortletException e) {e.printStackTrace();}
       	      
        String response = json.toJSONString();
        response = response.replaceAll("\\\\", "");
	           
        return response;
    }
    	
	
	////////////////////////////////////////////////////////////// update functions //////////////////////////////////////////
		
	
	//
	public void createResearchObject (ResourceRequest request, ResourceResponse response){
    	
        String responseString = "";
        JSONObject parseJson = getDataJsonAsObject (request);
	
		responseString = (ResearchObjectLocalServiceUtil.createResearchObjectByJson(parseJson)).toString();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}
		
		
	}
	
	
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void startSubmission (ResourceRequest request, ResourceResponse response){
   
    	String responseString = "";    	
        JSONObject parseJson = getDataJsonAsObject (request);
        
        //JSONObject Authorization = getBrokerAuthorization("");
        
    	try {
	        
	        URL url = new URL("https://c103-171.cloud.gwdg.de/api/submissions/generic/");
		        
	        System.setProperty("javax.net.ssl.trustStore", "C:/Users/froemm/GFBio/GFBio-portal-dev/workspace/LiferayWebserviceTest/jssecacerts");
	        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
	
	        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
	        
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
	        conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Accept", "application/json");
	        
/*	        String userpass = "gfbio-dev:iekieta4ooH$o;i[";
	        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
	        conn.addRequestProperty ("Authorization", basicAuth);*/
	
	        String encodedData = getJSON_Body((JSONObject) parseJson);
	        OutputStream os = conn.getOutputStream();
	        os.write(encodedData.getBytes());
	        os.flush();       
	        
	        if (conn.getResponseCode() != 201) 
	           throw new RuntimeException("Failed : HTTPS error code : " + conn.getResponseCode());
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null){
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
	public HttpServletRequest getOriginalHttpServletRequest(PortletRequest request) {
        return PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
    }
    
	
    ////////////////////////////////////////////////////////////  Upload  //////////////////////////////////////////////////////////////////////////////////
    
	
    //
	public void uploadFile (ResourceRequest request, ResourceResponse response){
		
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
	        
/*	        System.out.println("1 "+items.size());
	        System.out.println("2 "+originalHttpServletRequest.getContentLength());
	        System.out.println("3 "+originalHttpServletRequest.getContextPath());
	        System.out.println("4 "+originalHttpServletRequest.getLocalName());
	        System.out.println("5 "+originalHttpServletRequest.getParameterNames().toString());
	        System.out.println("6 "+originalHttpServletRequest.getParameterMap().keySet().toString());
	        System.out.println("7 "+originalHttpServletRequest.getParameter("p_p_state"));
	        System.out.println("8 "+originalHttpServletRequest.getParameter("p_p_lifecycle"));
	        System.out.println("9 "+originalHttpServletRequest.getParameter("p_p_resource_id"));
	        System.out.println("0 "+originalHttpServletRequest.getParameter("p_p_id"));
	        System.out.println("a "+originalHttpServletRequest.getParameter("p_l_id"));
	        System.out.println("b "+originalHttpServletRequest.getParameter("p_p_col_count"));
	        System.out.println("c "+originalHttpServletRequest.getParameter("p_p_col_id"));
	        System.out.println("d "+originalHttpServletRequest.getParameter("p_p_cacheability"));
	        System.out.println("e "+originalHttpServletRequest.getParameter("p_p_mode"));
	        System.out.println("f "+originalHttpServletRequest.getParameter("p_v_l_s_g_id"));*/
	        
	        Iterator<FileItem> iter = items.iterator();
	        while (iter.hasNext()) {
	        	
	        	FileItem thisItem = (FileItem) iter.next();
	        		        	
	        	if ((thisItem.getName()).equals("uploadInformation.txt")) {
			        
	        		JSONObject roJson = new JSONObject();
	        		JSONParser parser = new JSONParser();
	    			try {roJson = (JSONObject) parser.parse(thisItem.getString());}
	    			catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
	        		researchObjectId = (long) roJson.get("researchobjectid");
	        		researchObjectVersion = ResearchObjectLocalServiceUtil.getResearchObjectVersionFromJson(roJson);
	        		userId = (long) roJson.get("userid");
	        	} else {
	        		String path = "C:"+File.separator+"Users"+File.separator+"froemm"+File.separator+"Desktop"+File.separator+File.separator+"Neuer Ordner (2)"+File.separator+userId+File.separator+researchObjectId+File.separator+researchObjectVersion;
	        		File files = new File(path);
	        		if (!files.exists()) 
	        	     	files.mkdirs(); 
	        	            
	        		File fileOut = new File(path, thisItem.getName());
	        		fileOut.deleteOnExit();
	        		try {thisItem.write(fileOut);} 
	        		catch (Exception e) {e.printStackTrace();}
	        	}
	        }
	    }
	}

	
	
	public void registerFileUpload(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		
		JSONArray responseJson = new JSONArray();
        JSONArray parseJson = getDataJsonAsArray (request);

		responseJson = PrimaryDataLocalServiceUtil.createPrimaryData(parseJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseJson.toString());
        
        
	}
	
    


}
