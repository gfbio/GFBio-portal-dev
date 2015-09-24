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
 * Provides a wrapper for {@link ResearchObjectService}.
 *
 * @author Marcel Froemming
 * @see ResearchObjectService
 * @generated
 */
public class ResearchObjectServiceWrapper implements ResearchObjectService,
	ServiceWrapper<ResearchObjectService> {
	public ResearchObjectServiceWrapper(
		ResearchObjectService researchObjectService) {
		_researchObjectService = researchObjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _researchObjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_researchObjectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _researchObjectService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getDirectChildren(
		long researchObjectId) {
		return _researchObjectService.getDirectChildren(researchObjectId);
	}

	@Override
	public org.gfbio.model.ResearchObject getDirectParent(long researchObjectId) {
		return _researchObjectService.getDirectParent(researchObjectId);
	}

	@Override
	public org.gfbio.model.ResearchObject getTopParent(long researchObjectId) {
		return _researchObjectService.getTopParent(researchObjectId);
	}

	@Override
	public long updateResearchObject(long projectID, long researchObjectID,
		java.lang.String name, java.lang.String label,
		java.lang.String metadata, java.lang.String formatmetadata)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectService.updateResearchObject(projectID,
			researchObjectID, name, label, metadata, formatmetadata);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResearchObjectService getWrappedResearchObjectService() {
		return _researchObjectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResearchObjectService(
		ResearchObjectService researchObjectService) {
		_researchObjectService = researchObjectService;
	}

	@Override
	public ResearchObjectService getWrappedService() {
		return _researchObjectService;
	}

	@Override
	public void setWrappedService(ResearchObjectService researchObjectService) {
		_researchObjectService = researchObjectService;
	}

	private ResearchObjectService _researchObjectService;
}