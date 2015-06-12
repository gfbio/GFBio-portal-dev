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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Cell_Position. This utility wraps
 * {@link org.gfbio.service.impl.Cell_PositionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see Cell_PositionLocalService
 * @see org.gfbio.service.base.Cell_PositionLocalServiceBaseImpl
 * @see org.gfbio.service.impl.Cell_PositionLocalServiceImpl
 * @generated
 */
public class Cell_PositionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.Cell_PositionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cell_ position to the database. Also notifies the appropriate model listeners.
	*
	* @param cell_Position the cell_ position
	* @return the cell_ position that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position addCell_Position(
		org.gfbio.model.Cell_Position cell_Position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCell_Position(cell_Position);
	}

	/**
	* Creates a new cell_ position with the primary key. Does not add the cell_ position to the database.
	*
	* @param cell_PositionPK the primary key for the new cell_ position
	* @return the new cell_ position
	*/
	public static org.gfbio.model.Cell_Position createCell_Position(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK) {
		return getService().createCell_Position(cell_PositionPK);
	}

	/**
	* Deletes the cell_ position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position that was removed
	* @throws PortalException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position deleteCell_Position(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCell_Position(cell_PositionPK);
	}

	/**
	* Deletes the cell_ position from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_Position the cell_ position
	* @return the cell_ position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position deleteCell_Position(
		org.gfbio.model.Cell_Position cell_Position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCell_Position(cell_Position);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.gfbio.model.Cell_Position fetchCell_Position(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCell_Position(cell_PositionPK);
	}

	/**
	* Returns the cell_ position with the primary key.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position
	* @throws PortalException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position getCell_Position(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCell_Position(cell_PositionPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cell_ positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @return the range of cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> getCell_Positions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCell_Positions(start, end);
	}

	/**
	* Returns the number of cell_ positions.
	*
	* @return the number of cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static int getCell_PositionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCell_PositionsCount();
	}

	/**
	* Updates the cell_ position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cell_Position the cell_ position
	* @return the cell_ position that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position updateCell_Position(
		org.gfbio.model.Cell_Position cell_Position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCell_Position(cell_Position);
	}

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

	public static void clearService() {
		_service = null;
	}

	public static Cell_PositionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Cell_PositionLocalService.class.getName());

			if (invokableLocalService instanceof Cell_PositionLocalService) {
				_service = (Cell_PositionLocalService)invokableLocalService;
			}
			else {
				_service = new Cell_PositionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Cell_PositionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Cell_PositionLocalService service) {
	}

	private static Cell_PositionLocalService _service;
}