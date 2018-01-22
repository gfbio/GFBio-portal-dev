package org.gfbio.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Helper {

	static String FILEPATH = ".."+File.separator+".."+File.separator+".."+File.separator+"server_specific_identification"+File.separator+"serverfile.txt";
	static int jiraTextareaSmallLimit  = 2000;
	static int jiraTextareaLimit  = 15000;
	static int jiraTextfieldLimit = 200;

	private static Log _log = LogFactoryUtil.getLog(Helper.class);
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
 
    
    //
    public static JSONObject getAllServerInformation(String path) throws IOException, PortletException {
    	
    	JSONObject responseJson = new JSONObject();
		JSONParser parser = new JSONParser();	
		File file = new File(path.trim() +FILEPATH);
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
	public static Boolean getBooleanFromJson(JSONObject requestJson, String key){
		
		Boolean responseBoolean = null;
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.Boolean"))
				responseBoolean = (Boolean) requestJson.get(key);
			else
				if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.String")){
					String responseString = "";
					responseString = ((String) requestJson.get(key)).trim();
					if (responseString.equals("true"))		responseBoolean = true;
					if (responseString.equals("false"))		responseBoolean = false;
				}
		
			

		return responseBoolean;
	}
	
	
	//
	public static Date getDateFromJson(JSONObject requestJson, String key){
		
		Date responseDate = null;
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Date"))
				responseDate = (Date) requestJson.get(key);
			else
				if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.String")){
					String dateString = (String) requestJson.get(key);
					if (!dateString.equals(""))
						try {
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							responseDate = dateFormat.parse(dateString);	
						} catch (java.text.ParseException e) {e.printStackTrace();}
				}else
					if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Long"))
						responseDate = new Date ((long) requestJson.get(key));
					else
						_log.info("function getDateFromJson has no "+(((requestJson.get(key)).getClass())));
		

		return responseDate;
	}
    
    
	//
	public static int getIntFromJson(JSONObject requestJson, String key){
		
		int responseInt = 0;
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Integer"))
				responseInt = (int)requestJson.get(key);
			else
				if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Long"))
					responseInt = (int)(long)requestJson.get(key);
				else 
					if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String"))
						responseInt = Integer.valueOf((String) requestJson.get(key)).intValue();
		
		
		return responseInt;
	}
	
	
	
	//
	public static int getJiraTextareaLimit(){
		return jiraTextareaLimit;
	}
	
	
	//
	public static int getJiraTextareaSmallLimit(){
		return jiraTextareaSmallLimit;
	}
	
	
	//
	public static int getJiraTextfieldLimit(){
		return jiraTextfieldLimit;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public static JSONArray getJsonArrayFromJson(JSONObject requestJson, String key){
		
		JSONArray responseJson = new JSONArray();
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.JSONArray")){
				responseJson = (JSONArray) requestJson.get(key);
			}else{
				if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String")){
					JSONParser parser = new JSONParser();
					try {responseJson = (JSONArray) parser.parse((String) requestJson.get(key));}
					catch (ParseException e) {e.printStackTrace();}
				}else{
					if (((requestJson.get(key).getClass()).toString()).equals("class java.util.ArrayList")){
						List<String> responseList = new ArrayList<String> ();
						responseList = ((List<String>) requestJson.get(key));
						responseJson.addAll(responseList);
					}else
						_log.info("function getJsonArrayFromJson has no " +((requestJson.get(key).getClass()).toString()));
				}
			}
		

		return responseJson;
	}
	
	
	//
	public static JSONArray getJsonArrayFromString(String requestString){
		
		JSONParser parser = new JSONParser();
		JSONArray responseJson = new JSONArray();
		try {responseJson = (JSONArray) parser.parse(requestString);}
		catch (ParseException e) {e.printStackTrace();}
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static JSONObject getJsonObjectFromJson(JSONObject requestJson, String key){
		
		JSONObject responseJson = new JSONObject();
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.JSONObject"))
				responseJson = (JSONObject) requestJson.get(key);
			else
				if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String")){
					JSONParser parser = new JSONParser();
					try {responseJson = (JSONObject) parser.parse((String) requestJson.get(key));}
					catch (ParseException e) {e.printStackTrace();}
				}else
					if (((requestJson.get(key).getClass()).toString()).equals("class java.util.HashMap"))
						responseJson.putAll((HashMap) requestJson.get(key));
		

		return responseJson;
	}
	
	
    //
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static JSONObject getJsonObjectFromJsonArray(JSONArray requestJson, int i){
    	JSONObject responseJson = new JSONObject();
    	
		if ((requestJson.get(i))!=null && !((requestJson.get(i)).toString()).equals("null"))
			if (((requestJson.get(i).getClass()).toString()).equals("class org.json.simple.JSONObject"))
				responseJson = (JSONObject) requestJson.get(i);
			else
				if (((requestJson.get(i).getClass()).toString()).equals("class java.lang.String")){
					JSONParser parser = new JSONParser();
					try {responseJson = (JSONObject) parser.parse((String) requestJson.get(i));}
					catch (ParseException e) {e.printStackTrace();}
				}else
					if (((requestJson.get(i).getClass()).toString()).equals("class java.util.HashMap"))
						responseJson.putAll((HashMap) requestJson.get(i));
		
			
		
    	
    	return responseJson;
    	
    }

    
	//
	public static long getLongFromJson(JSONObject requestJson, String key){
		
		long responseLong = 0;
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Long"))
				responseLong = (long)requestJson.get(key);
			else 
				if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Integer"))
					responseLong = (long)(int)requestJson.get(key);
				else
					if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String"))
						responseLong = Long.valueOf((String) requestJson.get(key)).longValue();
		
		return responseLong;
	}
	
	
	//
	public static String getStringFromJson(JSONObject requestJson, String key){
		
		String responseString ="";
		if ((requestJson.get(key))!=null && !((requestJson.get(key)).toString()).equals("null"))
			if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String"))
				responseString = ((String) requestJson.get(key)).trim();
			else
				if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.JSONObject"))
					responseString = (((JSONObject) requestJson.get(key)).toString()).trim();
				else 
					if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.JSONArray"))
						responseString = (((JSONArray) requestJson.get(key)).toString()).trim();
					else
						if ((((requestJson.get(key)).getClass()).toString()).equals("class java.lang.Long"))
							responseString = (Long.toString((long)requestJson.get(key))).trim();

		return responseString;
	}
	
	
    //
	public static String getStringFromJsonArray(JSONArray requestJson, int i){
    	String responseString ="";
    	if ((requestJson.get(i))!=null && !((requestJson.get(i)).toString()).equals("null"))
	    	if (((requestJson.get(i).getClass()).toString()).equals("class java.lang.String"))
				responseString = ((String) requestJson.get(i)).trim();
			else
				if (((requestJson.get(i).getClass()).toString()).equals("class org.json.simple.JSONObject"))
					responseString = (((JSONObject) requestJson.get(i)).toString()).trim();
				else 
					if (((requestJson.get(i).getClass()).toString()).equals("class org.json.simple.JSONArray"))
						responseString = (((JSONArray) requestJson.get(i)).toString()).trim();
					else
						if ((((requestJson.get(i)).getClass()).toString()).equals("class java.lang.Long"))
							responseString = (Long.toString((long)requestJson.get(i))).trim();
    	
    	return responseString;
    }
	
	
    //
/*    public static String getServerInformation(String path, String key) throws IOException, PortletException {
    	
		String value ="";
		JSONObject fileJson = getAllServerInformation(path);
		
		if (fileJson.containsKey(key))
			value = (String) fileJson.get(key);
		else
			value = "ERROR: You sent a wrong server type.";
			
		return value;
	}*/
    
    
    //
    @SuppressWarnings("unchecked")
	public static JSONObject addValueFromJson (JSONObject requestJson, String requestKey, String responseKey, String type, JSONObject responseJson){

    	if (requestJson.containsKey(requestKey))
    		if (!(Helper.getStringFromJson(requestJson, requestKey)).contains("null"))
    			if(type.equals("java.lang.Boolean"))
    				responseJson.put(responseKey, getBooleanFromJson(requestJson, requestKey));
    			else
    				if(type.equals("java.lang.Date"))
    					responseJson.put(responseKey, getDateFromJson(requestJson, requestKey));
    				else
        				if(type.equals("java.lang.Integer"))
        					responseJson.put(responseKey, getIntFromJson(requestJson, requestKey));
        				else
        					if(type.equals("java.lang.JSONArray"))
        						responseJson.put(responseKey, getJsonArrayFromJson(requestJson, requestKey));
        					else
        	    				if(type.equals("java.lang.JSONObject"))
        	    					responseJson.put(responseKey, getJsonObjectFromJson(requestJson, requestKey));
        	    				else
        	        				if(type.equals("java.lang.Long"))
        	        					responseJson.put(responseKey, getLongFromJson(requestJson, requestKey));
        	        				else
        	            				if(type.equals("java.lang.String"))
        	            					 responseJson.put(responseKey, getStringFromJson(requestJson, requestKey));
        	            				else
            	            				if(type.equals("java.lang.String UpperCase")){
            	            					String archive = getStringFromJson(requestJson, requestKey);
            	            					if (!archive.equals("GFBio collections"))
            	            						archive = archive.toUpperCase();
            	            					
            	            					responseJson.put(responseKey, archive);
            	            				}
            	            					 
    
    	return responseJson;
    }
	
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	public static String checkForIgnoredParameter (Object[] objects, Set<String> keyList){

		String ignoredParameter = "WARNING:";
		Boolean check = false;
		
		for (int i =0; i < objects.length;i++)
			if (!keyList.contains((objects[i]))){
				ignoredParameter = ignoredParameter.concat(" ").concat(objects[i].toString()).concat(",");
				check = true;
			}
		if (check == true)
			ignoredParameter = ignoredParameter.substring(0, ignoredParameter.length()-1).concat(" are not parameters of this method.");
		else
			ignoredParameter ="";
		
		return ignoredParameter;
	}
}
