package org.gfbio;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class Landing extends MVCPortlet{
	
	public void search(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = (String)actionRequest.getAttribute(
			WebKeys.PORTLET_ID);
		
		String pageName=PropsUtil.get("landing.gfbio.redirect.URL");
		
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);

		long plid = 0L;
		try {
		 plid = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, pageName).getPlid();
		} catch (Exception e) {
		e.printStackTrace();
        }

		/*PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletId);*/
		
		String searchTerm = actionRequest.getParameter("searchTerm");
		
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,plid,PortletRequest.RENDER_PHASE);
		
		String redirect = redirectURL.toString();
		
		if(searchTerm!=null){
	 	 redirect = HttpUtil.addParameter(redirect, "q="+searchTerm,true);
		}
		System.out.println(redirect);
		 actionResponse.sendRedirect(redirect); 

	}
}
