/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
 * Provides the remote service utility for SubmissionRegistry. This utility wraps
 * {@link org.gfbio.service.impl.SubmissionRegistryServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryService
 * @see org.gfbio.service.base.SubmissionRegistryServiceBaseImpl
 * @see org.gfbio.service.impl.SubmissionRegistryServiceImpl
 * @generated
 */
public class SubmissionRegistryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.SubmissionRegistryServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static org.json.simple.JSONArray getSubmissionRegistriesByBrokerSubmissionId(
		org.json.simple.JSONObject requestJson) {
		return getService()
				   .getSubmissionRegistriesByBrokerSubmissionId(requestJson);
	}

	public static org.json.simple.JSONArray getSubmissionRegistriesByResearchObjectId(
		org.json.simple.JSONObject requestJson) {
		return getService()
				   .getSubmissionRegistriesByResearchObjectId(requestJson);
	}

	public static org.json.simple.JSONArray createSubmissionRegistry(
		java.lang.String requestJson) {
		return getService().createSubmissionRegistry(requestJson);
	}

	public static org.json.simple.JSONArray updateSubmissionRegistry(
		java.lang.String requestJson) {
		return getService().updateSubmissionRegistry(requestJson);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubmissionRegistryService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubmissionRegistryService.class.getName());

			if (invokableService instanceof SubmissionRegistryService) {
				_service = (SubmissionRegistryService)invokableService;
			}
			else {
				_service = new SubmissionRegistryServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SubmissionRegistryServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SubmissionRegistryService service) {
	}

	private static SubmissionRegistryService _service;
}