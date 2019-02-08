package org.gfbio;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
	
	public void facetEnvironment(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

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

		
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,plid,PortletRequest.RENDER_PHASE);
		
		String redirect = redirectURL.toString();
		
		/*URL encoding replaces spaces with '+', that causes problems, filter facet only works without '+' */
		// String facetString=HTTPUtil.encodeURL("[{\"term\":{\"dataCenterFacet\":\"PANGAEA: Data Publisher for Earth & Environmental Science\"}}]");
		String facetString="[{\"term\"%3A{\"dataCenterFacet\"%3A\"PANGAEA%3A Data Publisher for Earth %26 Environmental Science\"}}]";
		
	 	redirect = HttpUtil.addParameter(redirect, "filter="+facetString,true);
	 	
	 	System.out.println(redirect);
		 actionResponse.sendRedirect(redirect); 

	}
	
	
	@Override
	 public void render(RenderRequest request, RenderResponse response)
	   throws PortletException, IOException {
	  String gfbio_logo = PropsUtil.get("landing.gfbio.logo.path");
	  String env_img = PropsUtil.get("landing.gfbio.env.img.path");
	  
	  request.setAttribute("env_img", env_img);
	  request.setAttribute("gfbio_logo", gfbio_logo);
	  
	  super.render(request, response);
	 }
}
