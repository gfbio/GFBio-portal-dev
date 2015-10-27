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

	public static java.util.List<java.lang.String> getArchivepidsOfENA(
		java.lang.String archivePId) {
		return getService().getArchivepidsOfENA(archivePId);
	}

	public static java.util.List<java.lang.String> getArchivepidsWithTypeSampleOfENA(
		java.lang.String archivePId) {
		return getService().getArchivepidsWithTypeSampleOfENA(archivePId);
	}

	public static java.lang.String getArchivepidWithTypeStudyOfENA(
		java.lang.String archivePId) {
		return getService().getArchivepidWithTypeStudyOfENA(archivePId);
	}

	public static org.gfbio.model.SubmissionRegistry getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return getService().getLatestSubmissionByIds(researchObjectId, archive);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return getService().getLatestSubmissionsByArchive(archive);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByResearchobjectid(
		long researchObjectId) {
		return getService()
				   .getLatestSubmissionsByResearchobjectid(researchObjectId);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissions() {
		return getService().getLatestSubmissions();
	}

	public static org.json.simple.JSONObject getSubmissionRegistriesByBrokerSubmissionId(
		org.json.simple.JSONObject json) {
		return getService().getSubmissionRegistriesByBrokerSubmissionId(json);
	}

	public static org.json.simple.JSONObject getSubmissionRegistriesByResearchObjectId(
		org.json.simple.JSONObject json) {
		return getService().getSubmissionRegistriesByResearchObjectId(json);
	}

	public static org.json.simple.JSONObject createSubmissionRegistry(
		org.json.simple.JSONObject json) {
		return getService().createSubmissionRegistry(json);
	}

	public static org.json.simple.JSONObject updateSubmissionRegistry(
		org.json.simple.JSONObject json) {
		return getService().updateSubmissionRegistry(json);
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