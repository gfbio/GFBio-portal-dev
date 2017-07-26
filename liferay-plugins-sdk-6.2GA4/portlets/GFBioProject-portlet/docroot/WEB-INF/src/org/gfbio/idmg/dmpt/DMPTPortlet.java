package org.gfbio.idmg.dmpt;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.gfbio.idmg.dcrt.DCRTPortlet;
import org.gfbio.idmg.dto.GCategory;
import org.gfbio.idmg.dto.GLegalRequirement;
import org.gfbio.idmg.dto.GLicense;
import org.gfbio.idmg.dto.GMetadata;
import org.gfbio.idmg.util.ContentUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Phone;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DMPTPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(DCRTPortlet.class);
	
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
	
		//Setting Lists for dropdowns
		List<GCategory> researchfields = ContentUtil.getCategoryListByType("research field");
		List<GMetadata> metadata = ContentUtil.getListByTableName(GMetadata.class, "gfbio_metadata");
		List<GLicense> licenses = ContentUtil.getListByTableName(GLicense.class, "gfbio_license");
		List<GLegalRequirement> requirements = ContentUtil.getListByTableName(GLegalRequirement.class, "gfbio_legalrequirement");
		//List<GFunding> fundings = ContentUtil.getListByTableName(GFunding.class, "gfbio_funding...");
		//List<GPolicy> policies = ContentUtil.getListByTableName(GPolicy.class, "gfbio_policy");

		renderRequest.setAttribute("researchfields", researchfields);
		renderRequest.setAttribute("metadata", metadata);
		renderRequest.setAttribute("licenses", licenses);
		renderRequest.setAttribute("requirements", requirements);
		//renderRequest.setAttribute("fundings", fundings);
		//renderRequest.setAttribute("policies", policies);
		
		//Setting email and username if user is logged in
		String username = "";
		String email = "";
		List<Phone> phones = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			username = themeDisplay.getUser().getFullName();
			email = themeDisplay.getUser().getEmailAddress();
			try {
				phones = themeDisplay.getUser().getPhones();
			} catch (SystemException e) {
				_log.error("Error while getting phonenumbers from themedisplay", e);
			}
		}
		
		renderRequest.setAttribute("username", username);
		renderRequest.setAttribute("email", email);
		if (phones != null && !phones.isEmpty()) {
			for (Phone p : phones) {
				if (p.isPrimary()) {
					renderRequest.setAttribute("phone", p.getNumber());
				}
			}
		}
		
		//Setting variable for context path
		String contextPath = renderResponse.encodeURL(renderRequest.getContextPath());
		renderRequest.setAttribute("contextPath", contextPath);
	    
		super.render(renderRequest, renderResponse); 
	}
	
}
