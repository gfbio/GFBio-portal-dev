package org.gfbio.idmg.dcst;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.gfbio.model.Project;
import org.gfbio.model.impl.ProjectImpl;
import org.gfbio.service.ProjectLocalServiceUtil;

/**
 * Portlet implementation class dcst
 */
public class DCSTPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(DCSTPortlet.class);
	protected String viewTemplate;
	
	/*
	 * Adds a sample project to DB
	 */
	public static void sampleProject(ActionRequest req, ActionResponse res)
	{
		// Im ThemeDisplay gibt es u.a. die aktuelle UserID
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("User " + themeDisplay.getUserId() + " starts creating a sample project");
		
		// Auslesen der Variablen aus dem Input der Form
		String name = ParamUtil.getString(req, "projectName");
		
		if(name == null || name.equals("")) {
			SessionErrors.add(req, "provide-a-name-for-project");
			return;
		}
		
		try {
			Project project = new ProjectImpl();
			project.setName(name);
			project.setLabel("Ein Label habe ich auch");
			project.setExtendeddata("Extended Kram");
			project.setDescription("Eine Beschreibung ohne Inhalt");
			project.setStartDate(new Date());
			project.setEndDate(new Date());
			project.setStatus("VERIFIED");
			
			ProjectLocalServiceUtil.addProject(project);
			
			SessionMessages.add(req, "success");
			
		} catch (Exception ex) {
			SessionErrors.add(req, "unable-to-create-project");
			_log.error("Unable to create sample project");
		}
	}
	
	public static List<Project> listProjects() {
		List<Project> allProjects = new ArrayList<>();
		try {
			allProjects = ProjectLocalServiceUtil.getProjects();
			
			// Die Abfrage muss scheinbar in Verbindung mit der UserId passieren? War zumindest im alten Code, daher muss das hier wohl noch mal geändert werden.
			
		} catch (SystemException ex) {
			_log.error("Unable to get list of projects");
		}
		
		return allProjects;
	}
}