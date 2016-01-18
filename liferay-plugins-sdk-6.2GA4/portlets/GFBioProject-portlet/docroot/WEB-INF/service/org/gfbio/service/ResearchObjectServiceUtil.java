/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.gfbio.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ResearchObject. This utility wraps
 * {@link org.gfbio.service.impl.ResearchObjectServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Marcel Froemming
 * @see ResearchObjectService
 * @see org.gfbio.service.base.ResearchObjectServiceBaseImpl
 * @see org.gfbio.service.impl.ResearchObjectServiceImpl
 * @generated
 */
public class ResearchObjectServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.ResearchObjectServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.json.simple.JSONObject getResearchObjectAbsolutParent(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectAbsolutParent(requestJson);
	}

	public static org.json.simple.JSONArray getResearchObjectById(
		java.lang.String requestJson) {
		return getService().getResearchObjectById(requestJson);
	}

	public static org.json.simple.JSONObject getResearchObjectParent(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectParent(requestJson);
	}

	public static org.json.simple.JSONArray getResearchObjectsByParent(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectsByParent(requestJson);
	}

	public static org.json.simple.JSONArray createResearchObject(
		java.lang.String requestJson) {
		return getService().createResearchObject(requestJson);
	}

	public static java.lang.String getTest(java.lang.String requestJson) {
		return getService().getTest(requestJson);
	}

	public static java.lang.String createTest(
		org.json.simple.JSONObject requestJson) {
		return getService().createTest(requestJson);
	}

	public static org.json.simple.JSONArray updateResearchObject(
		java.lang.String requestJson) {
		return getService().updateResearchObject(requestJson);
	}

	public static void clearService() {
		_service = null;
	}

	public static ResearchObjectService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ResearchObjectService.class.getName());

			if (invokableService instanceof ResearchObjectService) {
				_service = (ResearchObjectService)invokableService;
			}
			else {
				_service = new ResearchObjectServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ResearchObjectServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ResearchObjectService service) {
	}

	private static ResearchObjectService _service;
}