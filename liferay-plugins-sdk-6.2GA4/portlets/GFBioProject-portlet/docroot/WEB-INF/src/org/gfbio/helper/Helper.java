package org.gfbio.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.portlet.PortletException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Helper {

	static String FILEPATH = "..\\..\\..\\server_specific_identification\\serverfile.txt";
	
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
}
