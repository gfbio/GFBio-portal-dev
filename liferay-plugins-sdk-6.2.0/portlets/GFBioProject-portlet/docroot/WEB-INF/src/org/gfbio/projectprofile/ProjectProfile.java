package org.gfbio.projectprofile;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.gfbio.archiving.ArchivingPortlet;
public class ProjectProfile extends GenericPortlet {

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

	CacheRegistryUtil.clear();
	MultiVMPoolUtil.clear();
	WebCachePoolUtil.clear();
	include(viewTemplate, renderRequest, renderResponse);
	}

	public void init() {
	viewTemplate = getInitParameter("view-template");
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

	PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

	if (portletRequestDispatcher == null) {
	_log.error(path + " is not a valid include");
	}
	else {
	portletRequestDispatcher.include(renderRequest, renderResponse);
	}
	}

		public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {
		}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(ProjectProfile.class);

}