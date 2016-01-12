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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubmissionService}.
 *
 * @author Marcel Froemming
 * @see SubmissionService
 * @generated
 */
public class SubmissionServiceWrapper implements SubmissionService,
	ServiceWrapper<SubmissionService> {
	public SubmissionServiceWrapper(SubmissionService submissionService) {
		_submissionService = submissionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONArray getLatestPublicSubmissions(
		org.json.simple.JSONObject requestJson) {
		return _submissionService.getLatestPublicSubmissions(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getSubmisionsByBrokerSubmissionId(
		org.json.simple.JSONObject requestJson) {
		return _submissionService.getSubmisionsByBrokerSubmissionId(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getSubmisionsByResearchObjectId(
		org.json.simple.JSONObject requestJson) {
		return _submissionService.getSubmisionsByResearchObjectId(requestJson);
	}

	@Override
	public org.json.simple.JSONArray createSubmision(
		java.lang.String requestJson) {
		return _submissionService.createSubmision(requestJson);
	}

	@Override
	public org.json.simple.JSONArray updateSubmision(
		java.lang.String requestJson) {
		return _submissionService.updateSubmision(requestJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionService getWrappedSubmissionService() {
		return _submissionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionService(SubmissionService submissionService) {
		_submissionService = submissionService;
	}

	@Override
	public SubmissionService getWrappedService() {
		return _submissionService;
	}

	@Override
	public void setWrappedService(SubmissionService submissionService) {
		_submissionService = submissionService;
	}

	private SubmissionService _submissionService;
}