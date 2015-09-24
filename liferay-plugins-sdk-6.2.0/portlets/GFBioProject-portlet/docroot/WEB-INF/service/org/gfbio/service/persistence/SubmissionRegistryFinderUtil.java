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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Marcel Froemming
 */
public class SubmissionRegistryFinderUtil {
	public static java.util.List getArchivePIdsOfENA(
		java.lang.String archivePId) {
		return getFinder().getArchivePIdsOfENA(archivePId);
	}

	public static java.util.List getArchivePIdsWithTypeOfENA(
		java.lang.String archivePId, java.lang.String researchObjectType) {
		return getFinder()
				   .getArchivePIdsWithTypeOfENA(archivePId, researchObjectType);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return getFinder().getLatestSubmissionByIds(researchObjectId, archive);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissions() {
		return getFinder().getLatestSubmissions();
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return getFinder().getLatestSubmissionsByArchive(archive);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByResearchObjectId(
		long researchObjectId) {
		return getFinder()
				   .getLatestSubmissionsByResearchObjectId(researchObjectId);
	}

	public static java.util.List getStatusByIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive) {
		return getFinder()
				   .getStatusByIds(researchObjectId, researchObjectVersion,
			archive);
	}

	public static SubmissionRegistryFinder getFinder() {
		if (_finder == null) {
			_finder = (SubmissionRegistryFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					SubmissionRegistryFinder.class.getName());

			ReferenceRegistry.registerReference(SubmissionRegistryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SubmissionRegistryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SubmissionRegistryFinderUtil.class,
			"_finder");
	}

	private static SubmissionRegistryFinder _finder;
}