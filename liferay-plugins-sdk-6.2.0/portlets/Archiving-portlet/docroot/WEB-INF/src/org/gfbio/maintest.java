package org.gfbio;


import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jdom2.output.XMLOutputter;
import org.jdom2.Content;
import org.jdom2.Element;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class maintest {
	public static void main(String[] args) throws IOException{
		

		String foo = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(foo);
			//System.out.println("foo: "+json.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Boolean checker = true;
		if (checker.booleanValue())
		
		System.out.println("Start");
		
		String path = "C:\\Users\\froemm\\GFBio\\git\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\docroot\\xml\\userdata.xml";
		
		String proId ="4o7x1bdm";
		org.jdom2.Document doc = ContactToDMS.getData(path);
		String userId = "10201"; 
		Element proj = ContactToDMS.getProject(doc, proId);
		List<Element> projdata = proj.getChildren();
		System.out.println(proj.getContentSize()+ " "+projdata.get(1).getText() + " "+projdata.get(2).toString());
		
		System.out.println("end");
		
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
		System.out.println("-------------------------------------------------");
	   
		ContactToDMS cap = new ContactToDMS();
		int h=4;
		String userid = "show/hide molecular data".concat(new Integer(h).toString());
		String projid = "00000000";
		
		
		//xml laden
		


		/*System.out.println("------------------------");
		System.out.println(cap.checkUserId("11572", doc));
		System.out.println(cap.checkUserId("10201", doc));
		System.out.println("------------------------");**/
		
		//Ausgabe
		XMLOutputter fmt = new XMLOutputter();
		//fmt.output(doc, System.out);
		//System.out.println();
		
		//Userliste
		List<Object> userList = cap.getUserList(doc);
		//System.out.println(userList.size());
		
         
		//Userauswahl
		Element user = cap.getUser(doc, userid);
		
		String stUsers = user.getChildText("name_portal");
		String stInstitutions = user.getChildText("institution");
		//List<Element> test = user.getChildren();
		//for (int i=0; i<user.getChildren().size()-1;i++){
		//    String childn =user.getChildren().get(i).getName();
		//    String childv =user.getChildren().get(i).getText();
		//    System.out.println(childn + ": " + childv);
		//}
		
		List<Object> proList = cap.getProList(doc, userid);
		//System.out.println(proList.size() + proList.get(0).toString());
		//for (int i = 0; i< proList.size();i++){
		//	System.out.println(proList.get(i).toString());
		//}
		
		//System.out.println("heho: "+ stUsers + " von " + stInstitutions);
		//fmt.output(user, System.out);
		//System.out.println();
		
		
		
		//Projecktauswahl
		//Element project = cap.getProject(doc, userid, projid);
		//fmt.output(project, System.out);
		//System.out.println();         
		
		
		//Projecktauswahl
		Element project2 = cap.getProject(doc, projid);
		fmt.output(project2, System.out);
		System.out.println();
		
		
		//String userId = "0a";
		//String proId = "00000001";
		List<Object> moleList = cap.getMoleList(doc, userId, proId); 

		if (moleList.size()!=0){for(int j = 0; j < moleList.size(); j++) {
				Content content = (Content) moleList.get(j);
				String moleId =content.getValue().toString();
				Element mole = cap.getMolecular(doc, userId, proId, moleId );
				List<Element> moledata = mole.getChildren();
				if (moledata.size() !=0){for(int i = 0; i < moledata.size(); i++) {
						System.out.println( mole.getChildren().get(i).getName() );
						System.out.println( mole.getChildren().get(i).getText() );
				}
					System.out.println( );
				}
			}
		}


		int j = 0;
		System.out.println("mole1: "+"mole_".concat(new Integer(j).toString()).concat("_0"));
		
		//Speichern
		//Capsule.saveData(doc);
 
		//String v = new String();
	}
}
