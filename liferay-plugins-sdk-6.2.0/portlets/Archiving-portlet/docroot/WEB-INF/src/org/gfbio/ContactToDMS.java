package org.gfbio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class ContactToDMS {
	
	String path =  "C:\\Users\\froemm\\GFBio\\git\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\xml\\userdata.xml";
	//String path = "C:\\liferay-portal-6.2.0-ce-ga1\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
      
	public ContactToDMS(){
		
	}
	
	
	//////////////////////////////////////////////// basic methods ///////////////////////////////////////////
	
	public static File getFile(String path){
		return  new File(path);
	}
	
	
	
	//load xml
	 public static org.jdom2.Document getData(String path) {
		org.jdom2.Document doc = null;
		try
		{
			SAXBuilder saxBuilder = new SAXBuilder();
		    doc = saxBuilder.build(getFile(path));
		    
 		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	//save xml
	public static void saveData(Document doc, String path) {
		
		XMLOutputter  xmlOutPutter = new XMLOutputter();
	    try {
	    	xmlOutPutter.output(doc, new FileWriter(getFile(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	///////////////////////////////////////////////////// check stuff ///////////////////////////////////////
	
	//check: Is UserID in the List of Data
	public static Boolean checkUserId(String userId, Document doc){
		Boolean check = false;
		List<String> list = ListOToListS(getUserList(doc));
		check = list.contains(userId);
		return check;
	}

	////////////////////////////////////////////////////// converter ///////////////////////////////////	
	
	// convert a List of Objects to a List of Strings
	public static List<String> ListOToListS (List<Object> listO){
		List<String> listS = new ArrayList<String>();
		for (int i = 0;i<listO.size();i++)
			listS.add(listO.get(i).toString().substring(7, listO.get(i).toString().length()-1));
		return listS;
	}
	
	
	public static String[][] JSONtoArray (String data) throws ParseException{

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(data);
		String[][] array = new String[json.size()][2];
		Set<String> set = json.keySet();
		String[] row = set.toArray(new String[set.size()+1]);
		
		
		for(int i=0; i < json.size(); i++){
			array[i][0]= row[i];
			array[i][1]= json.get(row[i]).toString();
		}
		return array;
	}
	
	//JSON-String to List of Pair
	public static List<Pair> JSONtoList (String data) throws ParseException{

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(data);
		Set<String> set = json.keySet();
		String[] row = set.toArray(new String[set.size()+1]);
		List <Pair> list = new ArrayList<Pair>();
		
		for(int i=0; i < json.size(); i++)
			list.add(new Pair(row[i], json.get(row[i]).toString()));
		
		return list;
	}
	
	//List of Pair to a sort array
	public static String[][] getSortArray (List<Pair> list){
		
		String[][] array = new String[list.size()+1][2];
		Collections.sort(list, new PairComparator());
		for(int i =0;i <list.size();i++){
			array[i][0]=list.get(i).getFirst();
			array[i][1]=list.get(i).getSecound();
		}
		return array;
	}
	
	//mapToArray
	public static String[][] mapToArray(Map<String, String[]> map){
		String[][] array = new String[map.size()][2];
		Object[] keys =  map.keySet().toArray();
		for (int row = 0; row < map.size(); row++) {
		    array[row][0] = (String) keys[row];
		    Object key =  keys[row];
			array[row][1] = map.get(key)[0];
		}
		return array;
	}

	
	///////////////////////////////////// Geter /////////////////////////////////////////////////////
	
	
	//get List of Users
	public static List<Object> getUserList(Document doc) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("/root/user/id/text()");
		return expr.evaluate(doc);
	}

	//get List of all Projects
	public static List<Object> getProList(Document doc) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("/root/user/projects/project/id/text()");
		List<Object> projList = expr.evaluate(doc);
		return projList;
	}
	
	//get List of Projects of a spezific user
	public static List<Object> getProList(Document doc, String userId) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("/root/user[@id='"+userId+"']/projects/project/id/text()");
		List<Object> proList = expr.evaluate(doc);
		return proList;
	}
	
	//get List of Moleculardata of a Project
	public static List<Object> getMoleList(Document doc, String userId, String projId) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("/root/user[@id='"+userId+"']/projects/project[@id='"+projId+"']/moleculardatas/moleculardata/id/text()");
		List<Object> moleList = expr.evaluate(doc);
		return moleList;
	}
	
	//get moleculardata 
	 public static Element getMolecular(Document doc, String moleId) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("root/user/projects/project/moleculardatas/moleculardata[@id='"+moleId+"']");
		return (Element) expr.evaluateFirst(doc);
	}
	
	//get moleculardata of a project of a User
	public static Element getMolecular(Document doc, String userId, String projId, String moleId) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("root/user[@id='"+userId+"']/projects/project[@id='"+projId+"']/moleculardatas/moleculardata[@id='"+moleId+"']");
		return (Element) expr.evaluateFirst(doc);
	}
		
	//get project
	public static Element getProject(Document doc, String proId) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("/root/user/projects/project[@id='"+proId+"']");
		return (Element) expr.evaluateFirst(doc);
	}
	
	//get project of a User
	public static Element getProject(Document doc, String userid, String projid) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("root/user[@id='"+userid+"']/projects/project[@id='"+projid+"']");
		return (Element) expr.evaluateFirst(doc);
	}
	
	//get root
	public static Element getRoot(Document doc) {
			XPathFactory xpathFactory = XPathFactory.instance();
			XPathExpression<Object> expr = xpathFactory.compile("/root");
			return (Element) expr.evaluateFirst(doc);
		}
	
	//get user
	public static Element getUser(Document doc, String id) {
		XPathFactory xpathFactory = XPathFactory.instance();
		XPathExpression<Object> expr = xpathFactory.compile("/root/user[@id='"+id+"']");
		return (Element) expr.evaluateFirst(doc);
	}


}
