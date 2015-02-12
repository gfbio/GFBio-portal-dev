package org.gfbio;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.jdom2.Element;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;






public class GFBioArchiving extends GenericPortlet {

	
    ////////////////////////////////////// Initialization and Main methods ///////////////////////////////////////////////
    
	
    protected String viewTemplate;
    protected String userData;
    private static Log _log = LogFactoryUtil.getLog(GFBioArchiving.class);
	
    
    public void init() {
        viewTemplate = getInitParameter("view-template");
        userData = getInitParameter("userData");
    }
	
    public void doView(RenderRequest request, RenderResponse response)
        throws IOException, PortletException {
    	
        include(viewTemplate, request, response);
    }
    



	protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
        	_log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 

	// main method for Resource Request
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		
		response.setContentType("text/html");
		String path =  "C:\\Users\\froemm\\GFBio\\git\\GFBio_Jena_dev\\liferay-plugins-sdk-6.2.0\\portlets\\Archiving-portlet\\docroot\\xml\\userdata.xml";
    	//String path = "C:\\liferay-portal-6.2.0-ce-ga1\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
		//String path = "D:\\liferay\\liferay-portal-tomcat-6.2-gfbio\\tomcat-7.0.42\\webapps\\GFBio_Archiving-portlet\\xml\\userdata.xml";
		
		if(request.getParameter("responseTarget")  != null){
			try {
			
				//choose a project
				if ("choosePro".toString().equals(request.getParameter("responseTarget").toString()))
					choosePro(request, response);
				
				//change data
				if ("changeMolecular".toString().equals(request.getParameter("responseTarget").toString()))
					changeMolecular(ContactToDMS.getSortArray(ContactToDMS.JSONtoList(request.getParameter("data"))), path);
				
				if ("changeProject".toString().equals(request.getParameter("responseTarget").toString()))
					changeProject(ContactToDMS.getSortArray(ContactToDMS.JSONtoList(request.getParameter("data"))), path);

			
				//new Molecular data over GCDJ Widget	
				if ("GCDJWidget".toString().equals(request.getParameter("responseTarget").toString()))
					newMolecular(request.getParameter("projId"),ContactToDMS.JSONtoArray(request.getParameter("data")), path);


				//new project
				if ("newProject".toString().equals(request.getParameter("responseTarget").toString()))
					newProject(ContactToDMS.getSortArray(ContactToDMS.JSONtoList(request.getParameter("data"))), path);
				
				if ("newProUser".toString().equals(request.getParameter("responseTarget").toString())){
					String[][] array = ContactToDMS.getSortArray(ContactToDMS.JSONtoList(request.getParameter("data")));
					newUser(array[0][1], path);
					newProject(array, path);
				}
				
				//ContactToDMS
				if ("getProjectSize".toString().equals(request.getParameter("responseTarget").toString())){
					int projSize  = ContactToDMS.getProject(ContactToDMS.getData(path), request.getParameter("data").substring(1, request.getParameter("data").length()-1)).getChildren().size();
					PrintWriter out = response.getWriter();
					out.print(new Integer(projSize).toString());
				}
				
				if ("getProjectTopic".toString().equals(request.getParameter("responseTarget").toString())){
					String[][] array = ContactToDMS.getSortArray(ContactToDMS.JSONtoList(request.getParameter("data")));
					String projTopic  = ContactToDMS.getProject(ContactToDMS.getData(path), array[1][1]).getChildren().get(new Integer(array[0][1])).getName();
					PrintWriter out = response.getWriter();
					out.print(projTopic);
				}
				
				
				
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// main method for Action Request
	public void  processAction(ActionRequest request, ActionResponse response) throws IOException, PortletException{


		//choose  Dataset
		//if(request.getParameter("choosePro") != null)
		//	if ("choosePro".toString().equals(request.getParameter("choosePro").toString()))
		//		choosePro(request, response);	


	}
	
	
	
	///////////////////////////////////////////// Change Data ///////////////////////////////////////////////////////////////
	
	
	public void  changeMolecular(String[][] array, String path) throws IOException, PortletException, ParseException{
		
		org.jdom2.Document doc = ContactToDMS.getData(path);
		Element ele = ContactToDMS.getMolecular(doc, array[0][1]);

		for (int i=1; i< ele.getChildren().size();i++)
			if (ele.getChildren().get(i).getText() != array[i][1])
				ele.getChildren().get(i).setText(array[i][1]);
		ContactToDMS.saveData(doc, path);
	}
	

	public void  changeProject(String[][] array, String path) throws IOException, PortletException{

		org.jdom2.Document doc = ContactToDMS.getData(path);
		Element ele = ContactToDMS.getProject(doc, array[0][1]);

		for (int i=1; i< ele.getChildren().size()-1;i++)
			if (ele.getChildren().get(i).getText() != array[i][1])
				ele.getChildren().get(i).setText(array[i][1]);
		ContactToDMS.saveData(doc, path);
	}
	
		
	
	///////////////////////////////////////////// Choose Datasets ///////////////////////////////////////////////////////////////
	
	// choose Dataset
	public  void choosePro(ResourceRequest request, ResourceResponse response) throws IOException, PortletException{

		String stProj  = request.getParameter("data").substring(1, request.getParameter("data").length()-1);
		PortletPreferences prefs = request.getPreferences();
				
		if (stProj != null) {
            prefs.setValue("choPro", stProj);
            prefs.store();
        }
	}
	

	///////////////////////////////////////////// new Datasets ///////////////////////////////////////////////////////////////
	
	public void  newMolecular(String projId, String[][] molArray, String path) throws IOException, PortletException{
		
		org.jdom2.Document doc = ContactToDMS.getData(path);

    	Element proj = ContactToDMS.getProject(doc, projId);
		Element mole = new Element("moleculardata");
		String id = doc.getRootElement().getChildText("molecularID");
		mole.setAttribute("id", id);
		Element child = new Element("id");
		child.setText(id);
		mole.addContent(child);
		
		for (int i=0; i< molArray.length;i++){
			child = new Element(molArray[i][0]);
			child.setText(molArray[i][1]);
			mole.addContent(child);
		}
		id = GFBioID.loadId(doc,path, "molecularID");
		proj.getChild("moleculardatas").addContent(mole);
		ContactToDMS.saveData(doc, path);
	}
	
	
	public void  newProject(String[][] array, String path) throws IOException, PortletException{

		org.jdom2.Document doc = ContactToDMS.getData(path);
		
		Element muster = ContactToDMS.getProject(doc, "muster");
		Element user = ContactToDMS.getUser(doc, array[0][1]);
		Element proj = new Element("project");
		proj.setAttribute("id", doc.getRootElement().getChildText("projectID"));
			
		Element child = new Element(muster.getChildren().get(0).getName());
		child.setText(GFBioID.loadId(doc, path,"projectID"));
		proj.addContent(child);
		
		for (int i=1; i< muster.getChildren().size()-1;i++){
			child = new Element(muster.getChildren().get(i).getName());
			child.setText(array[i][1]);
			proj.addContent(child);
		}
		proj.addContent(new Element ("moleculardatas"));
		user.getChild("projects").addContent(proj);
		ContactToDMS.saveData(doc, path);
	}

	public void  newUser(String userId, String path) throws IOException, PortletException{

		org.jdom2.Document doc = ContactToDMS.getData(path);
		
		Element user = new Element("user");
		user.setAttribute("id", userId);
		Element id = new Element("id");
		id.setText(userId);
		user.addContent(id);
		Element projects = new Element ("projects");
		user.addContent(projects);
		ContactToDMS.getRoot(doc).addContent(user);
		ContactToDMS.saveData(doc, path);
	}
	
}
