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
public interface ResearchObject_UserFinder {
	public java.util.List<java.lang.Boolean> getCheckOfResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion);

	public java.util.List<java.lang.Long> getOwnerIdsByResearchObjectIds(
		long researchObjectId, int researchObjectVersion);

	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjectsByUserId(
		long userId);

	public java.util.List getUserIdsByResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion);
}