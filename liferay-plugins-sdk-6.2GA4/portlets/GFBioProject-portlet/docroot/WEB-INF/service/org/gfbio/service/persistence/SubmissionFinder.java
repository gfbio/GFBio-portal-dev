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

package org.gfbio.service.persistence;

/**
 * @author Marcel Froemming
 */
public interface SubmissionFinder {
	public java.util.List getArchivePIdsOfENA(java.lang.String archivePId);

	public java.util.List getArchivePIdsWithTypeOfENA(
		java.lang.String archivePId, java.lang.String researchObjectType);

	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive);

	public java.util.List<org.gfbio.model.Submission> getLatestSubmissions();

	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByArchive(
		java.lang.String archive);

	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByResearchObjectId(
		long researchObjectId);

	public java.util.List<org.gfbio.model.Submission> getLatestXPublicSubmissionsByX(
		int latestX);

	public java.util.List getResearchObjectVersion(long researchObjectId,
		java.lang.String archive, java.lang.String brokerSubmissionId);

	public java.util.List getStatusByIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive);

	public java.util.List getSubmissionIdByIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive);

	public java.util.List<org.gfbio.model.Submission> getSubmission(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive);
}