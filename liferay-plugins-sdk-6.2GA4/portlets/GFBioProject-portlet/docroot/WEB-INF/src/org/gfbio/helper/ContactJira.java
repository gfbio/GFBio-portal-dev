package org.gfbio.helper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.codec.binary.Base64;
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
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




import com.liferay.portal.model.User;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;


public class ContactJira {
	
	
	private static Log _log = LogFactoryUtil.getLog(ContactJira.class);
   
	
	
	//
	static private JSONObject getDataJsonAsObject (ResourceRequest request){

		String dataJson = request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONObject parseJson = new JSONObject();
		try {parseJson = (JSONObject) parser.parse(dataJson);}
		catch (ParseException e) {e.printStackTrace();}
		return parseJson;
	}
	
	
	//
    @SuppressWarnings({ "unchecked", "unused", "static-access" })
    public static String getJSON_Body(JSONObject requestJson){
    	   	
      	JSONParser parser = new JSONParser();
      	String archive = "GFBio collections";
		
		//preparation data source
		
    	 
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

        
        project.put("key", PropsUtil.get("jira.gfbio.submission.projectkey"));
        fields.put("project", project);
        issuetype.put("name", "Data Submission");
        fields.put("issuetype", issuetype);	
        reporter.put("name", submitterJson.get("emailaddress"));
        fields.put("reporter", reporter);	
        fields.put("customfield_10010", PropsUtil.get("jira.gfbio.submission.requesttyp"));
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
        }else{
        	fields.put("customfield_10205", submitterJson.escape("fullname"));
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
        	fields.put("customfield_10600", primaryDataPath);
        	
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
        json.put("authorization", "Token "+PropsUtil.get("jira.gfbio.submission.brokeragenttoken"));
       	
       
        String response = json.toJSONString();
             
        response = response.replaceAll("\\\\\\\\n", "----n");
        response = response.replaceAll("\\\\\\\\t", "----t");
        response = response.replaceAll("\\\\\\\\", "------");
        response = response.replaceAll("------------", "\\\\\\\\");
        response = response.replaceAll("------", "");
        response = response.replaceAll("----n", "\\\\n");
        response = response.replaceAll("----t", "\\\\t");
                
        _log.info("--------------------------------");
    	_log.info(response);
    	_log.info("--------------------------------");
	           
        return response;
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
	//
    @SuppressWarnings({ "unchecked", "unused" })
    public static JSONObject jiraJsonToPortalJson(JSONObject requestJson){
   	
      	JSONParser parser = new JSONParser();
		
		//preparation data source
		
      	JSONObject fieldJson = Helper.getJsonObjectFromJson(requestJson, "fields");
      	String tempString;
      	int tempIndexi;
      	JSONObject tempJson = new JSONObject();
      	JSONArray tempJsonArray = new JSONArray();
      	
      	
      	tempJson = Helper.getJsonObjectFromJson(fieldJson, "reporter");
      	
      	String userMail = Helper.getStringFromJson(tempJson, "emailAddress");
      	User user = UserExtensionLocalServiceUtil.getUserExtentionByEmailAddress(userMail);
      	
      	JSONObject responseJson = new JSONObject();
		JSONObject extendeddataJsonResearchObject = new JSONObject();
      	JSONObject projectJson = new JSONObject();
      	JSONObject researchObjectJson = new JSONObject();
      	JSONObject submissionJson = new JSONObject();
  	 	
    	
    	//research Object
    	researchObjectJson.put("userid", user.getUserId());
    	researchObjectJson.put("researchobjecttype", "Dataset");
    	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10309", "researchobjectid", "java.lang.Long", researchObjectJson);
    	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10310", "researchobjectversion", "java.lang.Integer", researchObjectJson);
    	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10201", "name", "java.lang.String", researchObjectJson);
     	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10308", "label", "java.lang.String", researchObjectJson);
       	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10208", "description", "java.lang.String", researchObjectJson);
     	tempString = Helper.getStringFromJson(fieldJson, "customfield_10205");
       	_log.info("Authornames |"+tempString+"|");
       	tempIndexi =0;
       	while (tempIndexi < tempString.length()){
       		tempIndexi = tempString.indexOf("\n");
       		_log.info("result |"+tempString.substring(0, tempIndexi-1)+"|");
       		tempJsonArray.add(tempString.substring(0, tempIndexi-1));
       		
       		tempString = tempString.substring(tempIndexi+1, tempString.length());
       		_log.info("|"+tempString+"|");
       	}
       	_log.info("size"+tempIndexi+ " vs. "+tempString.length());
       	tempJsonArray.add(tempString.substring(0, tempString.length()));
    	_log.info("authorList"+tempJsonArray);
       	//researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10205", "authornames", "java.lang.String", researchObjectJson);
    	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10311", "datacollectiontime", "java.lang.String", researchObjectJson);
     	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10307", "publications", "java.lang.String", researchObjectJson);
    	researchObjectJson = Helper.addValueFromJson ( fieldJson, "customfield_10200", "embargo", "java.lang.Date", researchObjectJson);
    	
    	
    	 /*       //metadata shema description
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
        }*/
    	
    	if (Helper.getLongFromJson(researchObjectJson, "researchobjectid")==0){
    		researchObjectJson.remove("researchobjectid");
    		researchObjectJson.remove("researchobjectversion");
    	}
   	   	     	              	
    	_log.info("project");
     	
    	//project
        projectJson = Helper.addValueFromJson ( fieldJson, "customfield_10314", "projectid", "java.lang.Long", projectJson);
    	if (Helper.getLongFromJson(projectJson, "projectid")==0)
    		projectJson.remove("projectid");
    	
        
    	_log.info("submission");    	
    	
    	//submission
    	submissionJson = Helper.addValueFromJson ( requestJson, "id",  "jiraid",  "java.lang.String", submissionJson);
    	submissionJson = Helper.addValueFromJson ( requestJson, "key", "jirakey", "java.lang.String", submissionJson);
    	submissionJson.put("status", "sent");
    	submissionJson.put("userid", user.getUserId());
    	if (fieldJson.containsKey("assignee")){
    		//tempJson = Helper.getJsonObjectFromJson(fieldJson, "assignee");
    		submissionJson = Helper.addValueFromJson ( Helper.getJsonObjectFromJson(fieldJson, "assignee"), "name", "archive", "java.lang.String UpperCase", submissionJson);
    		//submissionJson.put("archive", "BGBM");
    	}
    	
    	_log.info("all");
    	
    	// zusammenführerung
    	if (!projectJson.isEmpty())
    		responseJson.put("project", projectJson);
    	if (!extendeddataJsonResearchObject.isEmpty())
    		researchObjectJson.put("extendeddata",extendeddataJsonResearchObject);
      	if (!researchObjectJson.isEmpty())
      		responseJson.put("researchobject", researchObjectJson);
      	if (!submissionJson.isEmpty())
      		responseJson.put("submission", submissionJson);
    	
    	_log.info("ready");    
        
        //dataset informations
        
/*        long researchObjectId =Helper.getLongFromJson(researchObjectJson, "researchobjectid");
        int researchObjectVersion = Helper.getIntFromJson(researchObjectJson, "researchobjectversion");
        _log.info("archive: |"+archive+"|");
        fields.put("customfield_10303", (SubmissionLocalServiceUtil.getBrokerSubmissionIdByIds(researchObjectId, researchObjectVersion, archive.trim())).trim());
*/
        //this line ist for testing and stop the submission to JIRA
        //fields.put("customfield_1", "stopper");
        
    	_log.info("*********************************");
    	_log.info(responseJson);
    	_log.info("*********************************");
    	
             

	           
        return responseJson;
        
        /*        //recommendation
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
        *
        */
        
       
        /*
              
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
        
        */
        
        
    }
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @SuppressWarnings({ "unchecked", "deprecation" })
	public static JSONObject startSubmission (JSONObject requestJson){
    	
    	JSONObject responseJson = new JSONObject();
    	
        try {
            
        	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost post = new HttpPost(PropsUtil.get("jira.gfbio.submission.urlissue"));
            post.addHeader("Content-Type","application/json");
            post.addHeader("Accept","application/json");
            post.addHeader("setDoInput","true");
            post.addHeader("setDoOutput","true");
            
            String userpass= PropsUtil.get("jira.gfbio.submission.userpass");
            String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
            if (basicAuth != null) 
                post.addHeader("Authorization", basicAuth);

            String jiraRequestString = getJSON_Body((JSONObject) requestJson);
            
			System.out.println(" jira"+jiraRequestString);
            
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
				responseJson = jiraResponseJson;
				//responseString = responseString.concat(jiraResponseJson.toString());
	        }
            httpclient.getConnectionManager().shutdown();
            
        }catch (Exception e) {
        	e.printStackTrace();
        	_log.info(e);
        }
        
        return responseJson;
    
    }
    
    
    //
    public static void startSubmission (ResourceRequest request, ResourceResponse response){
   	
    	String responseString = "";    	
        JSONObject parseJson = getDataJsonAsObject (request);
/*        try {_log.info("result: "+requestDB());}
        catch (UnsupportedEncodingException e1) {e1.printStackTrace();}*/
        
		JSONObject jiraResponseJson = startSubmission (parseJson);
		responseString = responseString.concat(jiraResponseJson.toString());
        
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {response.getWriter().write(responseString);}
		catch (IOException e) {
			e.printStackTrace();
			_log.info(e.toString());
		}
    }


    //
	@SuppressWarnings({ "resource", "deprecation" })
	static public Boolean addAttachmentToIssue(String userpass, String issueKey, String path){

		try{
			
			URL url = new URL(PropsUtil.get("jira.gfbio.submission.urlissue")+issueKey+"/attachments");

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

    



}
