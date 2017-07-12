package org.gfbio.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import javax.portlet.PortletException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Helper {

	static String FILEPATH = ".."+File.separator+".."+File.separator+".."+File.separator+"server_specific_identification"+File.separator+"serverfile.txt";
	static int jiraTextareaSmallLimit  = 2000;
	static int jiraTextareaLimit  = 15000;
	static int jiraTextfieldLimit = 200;

	
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
	public static int getIntFromJson(JSONObject requestJson, String key){
		
		int responseInt = 0;
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
	public static JSONArray getJsonArrayFromJson(JSONObject requestJson, String key){
		
		JSONArray responseJson = new JSONArray();
		if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.JSONArray"))
			responseJson = (JSONArray) requestJson.get(key);
		else
			if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String")){
				JSONParser parser = new JSONParser();
				try {responseJson = (JSONArray) parser.parse((String) requestJson.get(key));}
				catch (ParseException e) {e.printStackTrace();}
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
	public static JSONObject getJsonObjectFromJson(JSONObject requestJson, String key){
		
		JSONObject responseJson = new JSONObject();
		if (((requestJson.get(key).getClass()).toString()).equals("class org.json.simple.JSONObject"))
			responseJson = (JSONObject) requestJson.get(key);
		else
			if (((requestJson.get(key).getClass()).toString()).equals("class java.lang.String")){
				JSONParser parser = new JSONParser();
				try {responseJson = (JSONObject) parser.parse((String) requestJson.get(key));}
				catch (ParseException e) {e.printStackTrace();}
			}

		return responseJson;
	}
	
    
	//
	public static long getLongFromJson(JSONObject requestJson, String key){
		
		long responseLong = 0;
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
    public static String getServerInformation(String path, String key) throws IOException, PortletException {
    	
		String value ="";
		JSONObject fileJson = getAllServerInformation(path);
		
		if (fileJson.containsKey(key))
			value = (String) fileJson.get(key);
		else
			value = "ERROR: You sent a wrong server type.";
			
		return value;
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
