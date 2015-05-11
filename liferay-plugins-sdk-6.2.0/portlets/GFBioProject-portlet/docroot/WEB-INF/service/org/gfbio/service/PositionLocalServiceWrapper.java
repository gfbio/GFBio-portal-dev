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
 * Provides a wrapper for {@link PositionLocalService}.
 *
 * @author Felicitas Loeffler
 * @see PositionLocalService
 * @generated
 */
public class PositionLocalServiceWrapper implements PositionLocalService,
	ServiceWrapper<PositionLocalService> {
	public PositionLocalServiceWrapper(
		PositionLocalService positionLocalService) {
		_positionLocalService = positionLocalService;
	}

	/**
	* Adds the position to the database. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position addPosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.addPosition(position);
	}

	/**
	* Creates a new position with the primary key. Does not add the position to the database.
	*
	* @param positionID the primary key for the new position
	* @return the new position
	*/
	@Override
	public org.gfbio.model.Position createPosition(long positionID) {
		return _positionLocalService.createPosition(positionID);
	}

	/**
	* Deletes the position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param positionID the primary key of the position
	* @return the position that was removed
	* @throws PortalException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position deletePosition(long positionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.deletePosition(positionID);
	}

	/**
	* Deletes the position from the database. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position deletePosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.deletePosition(position);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _positionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Position fetchPosition(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.fetchPosition(positionID);
	}

	/**
	* Returns the position with the primary key.
	*
	* @param positionID the primary key of the position
	* @return the position
	* @throws PortalException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position getPosition(long positionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPosition(positionID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of positions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Position> getPositions(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositions(start, end);
	}

	/**
	* Returns the number of positions.
	*
	* @return the number of positions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPositionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsCount();
	}

	/**
	* Updates the position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position updatePosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.updatePosition(position);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _positionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_positionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _positionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getColumnContent(long positionId, int i)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getColumnContent(positionId, i);
	}

	@Override
	public java.lang.String[] getNameArray(long headId)
		throws org.gfbio.NoSuchHeadException {
		return _positionLocalService.getNameArray(headId);
	}

	@Override
	public org.gfbio.model.Position getPositionbyId(long positionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return _positionLocalService.getPositionbyId(positionId);
	}

	@Override
	public org.gfbio.model.Position getPositionByHeadIdAndName(long headId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionByHeadIdAndName(headId, name);
	}

	@Override
	public java.util.List<org.gfbio.model.Position> getPositionsbyHeadId(
		long headId) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsbyHeadId(headId);
	}

	@Override
	public java.lang.String[][] getTable(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _positionLocalService.getTable(headID);
	}

	@Override
	public java.lang.Boolean setStandard() {
		return _positionLocalService.setStandard();
	}

	@Override
	public java.lang.Boolean updatePosition(long positionID, long headID,
		java.lang.String column01, java.lang.String column02,
		java.lang.String column03, java.lang.String column04,
		java.lang.String column05, java.lang.String column06,
		java.lang.String column07, java.lang.String column08,
		java.lang.String column09, java.lang.String column10,
		java.lang.String column11, java.lang.String column12,
		java.lang.String column13, java.lang.String column14,
		java.lang.String column15, java.lang.String column16,
		java.lang.String column17, java.lang.String column18,
		java.lang.String column19, java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.updatePosition(positionID, headID,
			column01, column02, column03, column04, column05, column06,
			column07, column08, column09, column10, column11, column12,
			column13, column14, column15, column16, column17, column18,
			column19, column20);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PositionLocalService getWrappedPositionLocalService() {
		return _positionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPositionLocalService(
		PositionLocalService positionLocalService) {
		_positionLocalService = positionLocalService;
	}

	@Override
	public PositionLocalService getWrappedService() {
		return _positionLocalService;
	}

	@Override
	public void setWrappedService(PositionLocalService positionLocalService) {
		_positionLocalService = positionLocalService;
	}

	private PositionLocalService _positionLocalService;
}