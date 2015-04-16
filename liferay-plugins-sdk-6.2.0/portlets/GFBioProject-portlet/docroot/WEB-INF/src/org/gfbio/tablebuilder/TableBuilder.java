package org.gfbio.tablebuilder;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.gfbio.NoSuchHeadException;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PositionLocalServiceUtil;
import org.gfbio.test.TestPortlet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;



public class TableBuilder extends GenericPortlet {
	

    protected String viewTemplate;
    private static Log _log = LogFactoryUtil.getLog(TestPortlet.class);

	
    
 	
    public void init() {
        viewTemplate = getInitParameter("view-template");
    }
 
	 public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {
		 
/*		String[] column = new String[20];
		for(int i = 0;i<column.length;i++)
			column[i]= new Integer (i).toString();
		
		
		for (int i=0; i <20;i++){
	    	long headID = i;
	    	String name = "test_2_".concat(new Long (i).toString());
	    	column[i] = "test";
	    	
	    	try {
				Boolean check = HeadLocalServiceUtil.updateHead(headID, name, column[0], column[1], column[2], column[3], column[4], column[5], column[6], column[7], column[8], column[9], column[10], column[11], column[12], column[13], column[14], column[15], column[16], column[17], column[18], column[19] );
				System.out.println(check);
	    	} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */
		 
		/* String[] column = new String[20];
			for(int i = 0;i<column.length;i++)
				column[i]= new Integer (i).toString();
				
		String [] names = HeadLocalServiceUtil.getNameArray();
			
		for (int j=0; j <names.length;j++){
			long headID =0;
			try {
				headID = HeadLocalServiceUtil.getHeadID(names[j]);
			} catch (NoSuchHeadException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   	for (int i=0; i<5;i++ ){
		   		Boolean check;
		   		long positionID = i * j * j;
				try {
					check = PositionLocalServiceUtil.updatePosition(positionID, headID, column[0], column[1], column[2], column[3], column[4], column[5], column[6], column[7], column[8], column[9], column[10], column[11], column[12], column[13], column[14], column[15], column[16], column[17], column[18], column[19] );
					System.out.println(check + " | "+ positionID);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   		
		   	}
  		}*/
		 
		/* long headID = 1514;

		 try {
			String[][] foobar = PositionLocalServiceUtil.getTable(headID);
			for (int i = 0; i < foobar[0].length;i++){
				System.out.print("| ");
				for (int j =0; j < foobar.length;j++)
					System.out.print(" "+foobar[j][i]+ " | ");
				System.out.println();
			}
		} catch (NoSuchHeadException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
		 
		 
		 
		 
/*		 try {
			Boolean check = HeadLocalServiceUtil.setStandard();
			 System.out.println(check);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		 

		
			
		 

		
        include(viewTemplate, renderRequest, renderResponse);
	
	 }
	 
	 protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	 
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {

		response.setContentType("text/html");
				
		if(request.getParameter("responseTarget")  != null){
				
			//choose Table
			if ("chooseTable".toString().equals(request.getParameter("responseTarget").toString()))
				chooseTable(request, response);
			
			//new Table
			if ("newTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);
			
			//update Table
			if ("updateTable".toString().equals(request.getParameter("responseTarget").toString()))
				updateTable(request, response);
			

		}
	}
	
	
	// choose Dataset
	public  void chooseTable(ResourceRequest request, ResourceResponse response) throws ValidatorException, IOException {

		String name  = request.getParameter("data").substring(1, request.getParameter("data").length()-1);
		System.out.println(name);
		PortletPreferences prefs = request.getPreferences();
				
		if (name != null) {
	    	try {
				prefs.setValue("choTab", Long.toString(HeadLocalServiceUtil.getHeadID(name)));
			} catch (NoSuchHeadException | ReadOnlyException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	prefs.store();
		}
	}
	
	public void updateTable(ResourceRequest request, ResourceResponse response){

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();

		try {
			json = (JSONObject) parser.parse(request.getParameter("data"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			Boolean check = HeadLocalServiceUtil.updateHead(Long.valueOf((String) json.get("headID")).longValue(), (String) json.get("name"), (String) json.get("column01"), (String) json.get("column02"), (String) json.get("column03"), (String) json.get("column04"), (String) json.get("column05"), (String) json.get("column06"), (String) json.get("column07"), (String) json.get("column08"), (String) json.get("column09"), (String) json.get("column10"), (String) json.get("column11"), (String) json.get("column12"), (String) json.get("column13"), (String) json.get("column14"), (String) json.get("column15"), (String) json.get("column16"), (String) json.get("column17"), (String) json.get("column18"), (String) json.get("column19"), (String) json.get("column20"));
			System.out.println("new Table: "+check);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		

		
	}	
	 
	 
	 

}
