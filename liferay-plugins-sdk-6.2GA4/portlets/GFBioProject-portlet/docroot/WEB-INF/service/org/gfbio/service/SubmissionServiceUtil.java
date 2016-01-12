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
 * Provides the remote service utility for Submission. This utility wraps
 * {@link org.gfbio.service.impl.SubmissionServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Marcel Froemming
 * @see SubmissionService
 * @see org.gfbio.service.base.SubmissionServiceBaseImpl
 * @see org.gfbio.service.impl.SubmissionServiceImpl
 * @generated
 */
public class SubmissionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.SubmissionServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static org.json.simple.JSONArray getLatestPublicSubmissions(
		org.json.simple.JSONObject requestJson) {
		return getService().getLatestPublicSubmissions(requestJson);
	}

	public static org.json.simple.JSONArray getSubmisionsByBrokerSubmissionId(
		org.json.simple.JSONObject requestJson) {
		return getService().getSubmisionsByBrokerSubmissionId(requestJson);
	}

	public static org.json.simple.JSONArray getSubmisionsByResearchObjectId(
		org.json.simple.JSONObject requestJson) {
		return getService().getSubmisionsByResearchObjectId(requestJson);
	}

	public static org.json.simple.JSONArray createSubmision(
		java.lang.String requestJson) {
		return getService().createSubmision(requestJson);
	}

	public static org.json.simple.JSONArray updateSubmision(
		java.lang.String requestJson) {
		return getService().updateSubmision(requestJson);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubmissionService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubmissionService.class.getName());

			if (invokableService instanceof SubmissionService) {
				_service = (SubmissionService)invokableService;
			}
			else {
				_service = new SubmissionServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SubmissionServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SubmissionService service) {
	}

	private static SubmissionService _service;
}