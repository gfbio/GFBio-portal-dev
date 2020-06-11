package org.gfbio.submissionworkflow;

//import LiferayWebserviceClientCallPortalServices;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.IOUtils; //wichtig für fileupdate, auch wenn es hier als ungenutzt angezeigt wird
import org.gfbio.helper.Helper;
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
				org.gfbio.helper.ContactJira.startSubmission(request, response);
			


			
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
	public HttpServletRequest getOriginalHttpServletRequest(PortletRequest request) {
        return PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
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
	        factory.setSizeThreshold(20971520);
	        factory.setRepository(file);
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setSizeMax(20971520);
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
