package org.gfbio.idmg.dmpt;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.gfbio.idmg.dao.GCategory;
import org.gfbio.idmg.dao.GFunding;
import org.gfbio.idmg.dao.GLicense;
import org.gfbio.idmg.dao.GMetadata;
import org.gfbio.idmg.dcrt.DCRTPortlet;
import org.gfbio.idmg.util.ContentUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DMPTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DCRTPortlet.class);
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
	
		//Setting categories for dropdowns
		List<GCategory> researchfields = ContentUtil.getCategoryListByType("research field");
		List<GMetadata> metadata = ContentUtil.getListByTableName(GMetadata.class, "gfbio_metadata");
		List<GLicense> licenses = ContentUtil.getListByTableName(GLicense.class, "gfbio_license");
		//List<GFunding> fundings = ContentUtil.getFundingList();
		//List<GCategory> materials = getCategoryList("material kind");

		renderRequest.setAttribute("researchfields", researchfields);
		renderRequest.setAttribute("metadata", metadata);
		renderRequest.setAttribute("licenses", licenses);
		//renderRequest.setAttribute("fundings", fundings);
		//renderRequest.setAttribute("materials", materials);
		
		//Setting email and username if user is logged in
		String username = "";
		String email = "";
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			username = themeDisplay.getUser().getFullName();
			email = themeDisplay.getUser().getEmailAddress();
		}
		
		renderRequest.setAttribute("username", username);
		renderRequest.setAttribute("email", email);
		
		super.render(renderRequest, renderResponse); 
	}
	
}
