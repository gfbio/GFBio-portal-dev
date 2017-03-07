package org.gfbio.submissionworkflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

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

			//
			if ("createsubmissionregistry".toString().equals(request.getParameter("responseTarget").toString()))
				createSubmissionRegistry(request, response);
			
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
			if ("startsubmission".toString().equals(request.getParameter("responseTarget").toString()))
				startSubmission(request, response);


			
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
    	
    	//https://helpdesk.gfbio.org/rest/api/2/issue/createmeta?projectKeys=SAND&issuetypeNames=Data Submission&expand=projects.issuetypes.fields

    	JSONParser parser = new JSONParser();
		
		//preparation data source
		
    	System.out.println("--------------------------------");
    	System.out.println(requestJson);
    	System.out.println("--------------------------------");
    	
		JSONObject projectJson = new JSONObject();
    	projectJson = (JSONObject) requestJson.get("mrr");
    	
    	System.out.println(projectJson);
    	
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
        	if (((projectJson.get("projectid")).getClass()).toString().equals("class java.lang.Long")){
        		if (!((long) projectJson.get("projectid")==0));
        			fields.put("customfield_10314", String.valueOf((long) projectJson.get("projectid")));
        	}else
	        	if (!((String) projectJson.get("projectid")).equals("0"))
	        		fields.put("customfield_10314", (String) projectJson.get("projectid"));	
        
        
        
        //dataset informations
        
        
        //dataset indetifier
        if (researchObjectJson.containsKey("researchobjectid"))
        	if (((researchObjectJson.get("researchobjectid")).getClass()).toString().equals("class java.lang.Long")){
	        	if (!((long) researchObjectJson.get("researchobjectid")==0)){
	        		
	        		//dataset id 
	        		fields.put("customfield_10309",String.valueOf((long) researchObjectJson.get("researchobjectid")));	
	        		
	                //dataset version
	                fields.put("customfield_10310", String.valueOf((long) researchObjectJson.get("researchobjectversion"))); 		
	        	}
        	}else
 	        	if (!((String) researchObjectJson.get("researchobjectid")).equals("0")){
		        	fields.put("customfield_10309",(String) researchObjectJson.get("researchobjectid"));	
		            fields.put("customfield_10310", (String) researchObjectJson.get("researchobjectversion")); 		
	        	}

        
        //dataset title
        fields.put("customfield_10201", (String) researchObjectJson.get("name")); 							
        
        //dataset label
        datasetlabelArray.add((String) researchObjectJson.get("label"));
        fields.put("customfield_10308", datasetlabelArray); 			
        
        //dataset description
        System.out.println("customfield_10208: "+(String) researchObjectJson.get("description"));
        fields.put("customfield_10208", (String) researchObjectJson.get("description"));	
        
        //dataset author
        if (researchObjectJson.containsKey("authornames")){
        	if (!(researchObjectJson.get("authornames").equals(""))){
        		JSONParser parser2 = new JSONParser();
				JSONArray parseJson = new JSONArray();
				try {parseJson = (JSONArray) parser2.parse((String) researchObjectJson.get("authornames"));}
				catch (ParseException e) {e.printStackTrace();}
        		fields.put("customfield_10205", parseJson);
        		String inputString ="";
        		for (int i =0; i< parseJson.size();i++)
        			inputString = inputString.concat(((String) parseJson.get(i)).trim());//.concat(", ");
        		fields.put("customfield_10205", inputString);
        	}
        }
        
        //dataset collection time
        if (extendeddataJsonResearchObject.containsKey("datacollectiontime"))
        	if (!(extendeddataJsonResearchObject.get("datacollectiontime").equals("")))
        		fields.put("customfield_10311", (String) extendeddataJsonResearchObject.get("datacollectiontime")); 			
        
        
        //related publications
        if (extendeddataJsonResearchObject.containsKey("publications"))
        	if (!(extendeddataJsonResearchObject.get("publications").equals("")))
        		fields.put("customfield_10307", (String) extendeddataJsonResearchObject.get("publications"));		
        
        
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
      		fields.put("customfield_10200", (String) extendeddataJsonResearchObject.get("embargo"));
        
        
        //Category/Keywords
        if (researchObjectJson.containsKey("categoryids"))
        	if (!(researchObjectJson.get("categoryids").equals(""))){
        		JSONArray categoryArray = (JSONArray) researchObjectJson.get("categoryids");
        		String categoryString = "";
        		
        		if (categoryArray.size()>0){
        			for (int i=0;i<categoryArray.size();i++)
        				categoryString = categoryString.concat(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdByCellContent("gfbio_category", "id", (String) categoryArray.get(i)), "name")).concat(", ");
        			categoryString = categoryString.substring(0, categoryString.length()-2);
        		}
                fields.put("customfield_10313", categoryString); 	
        		
           	}
        
        
        //legal requirements
        if (extendeddataJsonResearchObject.containsKey("legalrequirements"))
        	if (!(extendeddataJsonResearchObject.get("legalrequirements").equals(""))){
        		JSONArray lrArray = (JSONArray) extendeddataJsonResearchObject.get("legalrequirements");
        		for (int i = 0; i < lrArray.size();i++){
        			JSONObject legalRequirements = new JSONObject();
        			System.out.println(lrArray.get(i));
        			legalRequirements.put("value", (String) lrArray.get(i));
        		  	legalRequirementsArray.add(legalRequirements);
        		}
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
        
        long researchObjectId =(long) researchObjectJson.get("researchobjectid");
        int researchObjectVersion = (int) (long) researchObjectJson.get("researchobjectversion");
        
        fields.put("customfield_10303", SubmissionLocalServiceUtil.getBrokerSubmissionIdByIds(researchObjectId, researchObjectVersion, "GFBio collections"));

        
        //fields.put("customfield_10312", "C:\\Users\\froemm\\Desktop\\uploadtest.xlsx");
        
        //
        fields.put("customfield_1", "foo");
        
        
        json.put("fields", fields);
        json.put("submittingUser", (long) researchObjectJson.get("userid"));
        try {json.put("authorization", "Token "+WorkflowENAPortlet.getServerToken((String) requestJson.get("path"),"token"));}
        catch (IOException | PortletException e) {e.printStackTrace();}
       	      
        String response = json.toJSONString();
        response = response.replaceAll("\\\\", "");
        
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println(response);
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
	           
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
    
    
    public void startSubmission (ResourceRequest request, ResourceResponse response){
   
    	System.out.println("start submission =)");

    	String responseString = "";    	
        JSONObject parseJson = getDataJsonAsObject (request);
        
    	try {

            URL url = new URL("https://helpdesk.gfbio.org/rest/api/2/issue/");
            //String path = "C:\\Users\\froemm\\Desktop\\uploadtest.xlsx";
            
 /*            String fileComment ="nope";
            String user = "tester2";
            if ( fileComment.equals("") | fileComment.equals(" ") | fileComment.equals(null)){
                fileComment = user + "-" + path;
            };*/
            
            

            System.setProperty("javax.net.ssl.keyStore", System.getenv("JAVA_Home") +"/jre/lib/security/cacerts");
            System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
	        	        
	        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
	        
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
	        conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Accept", "application/json");
	        
	        
	        
	        System.out.println("5");  
	        
            String userpass = "uni-jena:GFBIOhelpdesk123";
            String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
	        conn.addRequestProperty ("Authorization", basicAuth);
	        
/*	        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
	        File fileToUpload = new File(path);
			FileBody fileBody = new FileBody(fileToUpload, fileComment, "application/octet-stream", "UTF-8");
	        entity.addPart("file", fileBody);
	        System.out.println(entity.toString() );*/
	        //conn.setEntity(entity);
	        
/*	        FileReader fr = null;
	        
	        fr = new FileReader(path);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
	        */
			

	        
	        System.out.println("6");
	        
	        String encodedData = getJSON_Body((JSONObject) parseJson);
	        
	        System.out.println("7.0");
	        
	        OutputStream os = conn.getOutputStream();
	        
/*	        File file;
	        file = new File(path);
	        os = new FileOutputStream(file);*/
	        
	        System.out.println("7.1");

	        
	        os.write(encodedData.getBytes());
	        
	        System.out.println("7.2");
	        
	        os.flush();  
	        os.close();
	        
	        System.out.println("8");
	        
	        if (conn.getResponseCode() != 201) 
	           throw new RuntimeException("Failed : HTTPS error code : " + conn.getResponseCode());
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null){
	           System.out.println(output); 
	           responseString = responseString.concat(output);
			JSONParser parser = new JSONParser();
			JSONObject pj = new JSONObject();
			try {pj = (JSONObject) parser.parse(output);}
			catch (ParseException e) {e.printStackTrace();}
			System.out.println(pj);
	           
			
	        }
	        conn.disconnect();
	     } catch (Exception e) {e.printStackTrace();}
        
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {e.printStackTrace();}
		
        
    }
    
    
 /*   public boolean addAttachmentToIssue(String issueKey, String fullfilename) throws IOException{
    	 
        CloseableHttpClient httpclient = HttpClients.createDefault();
         
        HttpPost httppost = new HttpPost(jira_attachment_baseURL+"/api/latest/issue/"+issueKey+"/attachments");
        httppost.setHeader("X-Atlassian-Token", "nocheck");
        httppost.setHeader("Authorization", "Basic "+jira_attachment_authentication);
         
        File fileToUpload = new File(fullfilename);
        FileBody fileBody = new FileBody(fileToUpload);
         
        HttpEntity entity = MultipartEntityBuilder.create()
                .addPart("file", fileBody)
                .build();
         
        httppost.setEntity(entity);
        String mess = "executing request " + httppost.getRequestLine();
        logger.info(mess);
         
        CloseableHttpResponse response;
         
        try {
            response = httpclient.execute(httppost);
        } finally {
            httpclient.close();
        }
         
        if(response.getStatusLine().getStatusCode() == 200)
            return true;
        else
            return false;
     
    }*/

    
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
	        		System.out.println(thisItem.getString());
	        		JSONObject roJson = new JSONObject();
	        		JSONParser parser = new JSONParser();
	    			try {roJson = (JSONObject) parser.parse(thisItem.getString());}
	    			catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
	    			System.out.println(roJson);
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
	        		fileOut.deleteOnExit();
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
