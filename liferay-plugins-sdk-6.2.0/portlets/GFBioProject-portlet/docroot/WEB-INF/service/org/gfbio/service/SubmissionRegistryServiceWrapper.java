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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubmissionRegistryService}.
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryService
 * @generated
 */
public class SubmissionRegistryServiceWrapper
	implements SubmissionRegistryService,
		ServiceWrapper<SubmissionRegistryService> {
	public SubmissionRegistryServiceWrapper(
		SubmissionRegistryService submissionRegistryService) {
		_submissionRegistryService = submissionRegistryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionRegistryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionRegistryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionRegistryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.lang.String> getArchivepidsOfENA(
		java.lang.String archivePId) {
		return _submissionRegistryService.getArchivepidsOfENA(archivePId);
	}

	@Override
	public java.util.List<java.lang.String> getArchivepidsWithTypeSampleOfENA(
		java.lang.String archivePId) {
		return _submissionRegistryService.getArchivepidsWithTypeSampleOfENA(archivePId);
	}

	@Override
	public java.lang.String getArchivepidWithTypeStudyOfENA(
		java.lang.String archivePId) {
		return _submissionRegistryService.getArchivepidWithTypeStudyOfENA(archivePId);
	}

	@Override
	public org.gfbio.model.SubmissionRegistry getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return _submissionRegistryService.getLatestSubmissionByIds(researchObjectId,
			archive);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return _submissionRegistryService.getLatestSubmissionsByArchive(archive);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByResearchobjectid(
		long researchObjectId) {
		return _submissionRegistryService.getLatestSubmissionsByResearchobjectid(researchObjectId);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissions() {
		return _submissionRegistryService.getLatestSubmissions();
	}

	@Override
	public java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status) {
		return _submissionRegistryService.updateStatus(researchObjectId,
			researchObjectVersion, archive, status);
	}

	@Override
	public java.lang.Boolean updateSubmissionregistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brockerSubmissionId, java.lang.String archivePId,
		java.util.Date lastChanged, long userID, java.lang.Boolean isPublic,
		java.util.Date publicAfter) {
		return _submissionRegistryService.updateSubmissionregistry(researchObjectId,
			researchObjectVersion, archive, brockerSubmissionId, archivePId,
			lastChanged, userID, isPublic, publicAfter);
	}

	@Override
	public java.lang.Boolean updateSubmissionregistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brockerSubmissionId, java.lang.String archivePId,
		java.util.Date lastChanged, long userID, java.lang.Boolean isPublic,
		java.util.Date publicAfter, java.lang.String status) {
		return _submissionRegistryService.updateSubmissionregistry(researchObjectId,
			researchObjectVersion, archive, brockerSubmissionId, archivePId,
			lastChanged, userID, isPublic, publicAfter, status);
	}

	@Override
	public java.lang.Boolean updateSubmissionregistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brockerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userID,
		java.lang.Boolean isPublic, java.util.Date publicAfter,
		java.lang.String status) {
		return _submissionRegistryService.updateSubmissionregistry(researchObjectId,
			researchObjectVersion, archive, brockerSubmissionId, archivePId,
			archivePIdType, lastChanged, userID, isPublic, publicAfter, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionRegistryService getWrappedSubmissionRegistryService() {
		return _submissionRegistryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionRegistryService(
		SubmissionRegistryService submissionRegistryService) {
		_submissionRegistryService = submissionRegistryService;
	}

	@Override
	public SubmissionRegistryService getWrappedService() {
		return _submissionRegistryService;
	}

	@Override
	public void setWrappedService(
		SubmissionRegistryService submissionRegistryService) {
		_submissionRegistryService = submissionRegistryService;
	}

	private SubmissionRegistryService _submissionRegistryService;
}