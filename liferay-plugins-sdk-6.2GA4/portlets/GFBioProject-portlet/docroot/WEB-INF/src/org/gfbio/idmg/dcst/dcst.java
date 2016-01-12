package org.gfbio.idmg.dcst;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.gfbio.model.Project;
import org.gfbio.service.ProjectLocalServiceUtil;

/**
 * Portlet implementation class dcst
 */
public class dcst extends GenericPortlet {

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		/*try {
			ProjectLocalServiceUtil.updateProject(0, "Test", "Mein erstes Testprojekt");
		} catch (SystemException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}
*/
		try {
			Project project = ProjectLocalServiceUtil.getProject(1);
			System.out.print(project.getName());
		} catch (PortalException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (SystemException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		include(viewTemplate, renderRequest, renderResponse);
	}

	public void init() {
		viewTemplate = getInitParameter("view-template");
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

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(dcst.class);

}