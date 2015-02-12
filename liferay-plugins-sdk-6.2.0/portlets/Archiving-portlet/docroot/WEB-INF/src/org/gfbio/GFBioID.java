package org.gfbio;

import java.util.List;
import java.util.Random;

import org.jdom2.Content;
import org.jdom2.Document;

public class GFBioID {

	//build a individuell project ID
	public static String loadId(Document doc, String path, String stid){
		String id = doc.getRootElement().getChildText(stid);
		doc.getRootElement().getChild(stid).setText(getNewCleanProjectId(doc));
		ContactToDMS.saveData(doc, path);
		return id;
	}
		

	public static String getNewCleanProjectId(Document doc){
		String id = getNewIdString(8);					//8 is the length of ID's
		List<Object> idList = ContactToDMS.getProList(doc);
		for (int i =0;i<idList.size()-1;i++){
			Content content = (Content) idList.get(i); 
			if(id == content.getValue()){
				id = getNewCleanProjectId(doc);
			}
		}
		return id;
	}
		
	
	//build an ID char
	private static String getNewIdString(int max){
		String id ="";
		for (int i=0; i<max;i++)
		   id += getNewIdChar() ;
		return id;
	}
	
	//build an ID char
	private static char getNewIdChar(){
		Random r = new Random();
		final char[] source = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		int iIndex = r.nextInt( source.length );
		char id = source[iIndex] ;
		return id;
	}
	
	
	
}
