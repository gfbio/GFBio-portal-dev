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
 * Provides the local service utility for Head. This utility wraps
 * {@link org.gfbio.service.impl.HeadLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Felicitas Loeffler
 * @see HeadLocalService
 * @see org.gfbio.service.base.HeadLocalServiceBaseImpl
 * @see org.gfbio.service.impl.HeadLocalServiceImpl
 * @generated
 */
public class HeadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.HeadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the head to the database. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head addHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHead(head);
	}

	/**
	* Creates a new head with the primary key. Does not add the head to the database.
	*
	* @param headID the primary key for the new head
	* @return the new head
	*/
	public static org.gfbio.model.Head createHead(long headID) {
		return getService().createHead(headID);
	}

	/**
	* Deletes the head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param headID the primary key of the head
	* @return the head that was removed
	* @throws PortalException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head deleteHead(long headID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteHead(headID);
	}

	/**
	* Deletes the head from the database. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head deleteHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteHead(head);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.Head fetchHead(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHead(headID);
	}

	/**
	* Returns the head with the primary key.
	*
	* @param headID the primary key of the head
	* @return the head
	* @throws PortalException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head getHead(long headID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHead(headID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> getHeads(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeads(start, end);
	}

	/**
	* Returns the number of heads.
	*
	* @return the number of heads
	* @throws SystemException if a system exception occurred
	*/
	public static int getHeadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeadsCount();
	}

	/**
	* Updates the head in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head updateHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHead(head);
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

	public static void deleteCompleteHead(long headId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCompleteHead(headId);
	}

	public static int getColumnCount(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getColumnCount(headId);
	}

	public static java.lang.String getColumnName(long headId, int i)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getColumnName(headId, i);
	}

	public static int getColumnByName(long headId, java.lang.String column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getColumnByName(headId, column);
	}

	public static java.lang.Long getHeadID(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getHeadID(name);
	}

	public static org.gfbio.model.Head getHeadById(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getHeadById(headId);
	}

	public static org.gfbio.model.Head getHeadbyName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getHeadbyName(name);
	}

	public static java.util.List<org.gfbio.model.Head> getHeads()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeads();
	}

	public static java.util.List<org.gfbio.model.Head> getHeadsByTask(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeadsByTask(task);
	}

	public static java.lang.String getName(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getName(headId);
	}

	public static java.lang.String[] getNameArray(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNameArray(task);
	}

	public static java.lang.String[] getNameArray(
		java.util.List<org.gfbio.model.Head> headList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNameArray(headList);
	}

	public static java.lang.Boolean setStandard()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().setStandard();
	}

	public static java.lang.Boolean updateHead(long headId,
		java.lang.String name, java.lang.String task,
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
		return getService()
				   .updateHead(headId, name, task, column01, column02,
			column03, column04, column05, column06, column07, column08,
			column09, column10, column11, column12, column13, column14,
			column15, column16, column17, column18, column19, column20);
	}

	public static java.lang.Boolean updateRelationTable(long headId,
		java.lang.String mtable, java.lang.String ntable)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException, org.gfbio.NoSuchPositionException {
		return getService().updateRelationTable(headId, mtable, ntable);
	}

	public static void clearService() {
		_service = null;
	}

	public static HeadLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HeadLocalService.class.getName());

			if (invokableLocalService instanceof HeadLocalService) {
				_service = (HeadLocalService)invokableLocalService;
			}
			else {
				_service = new HeadLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(HeadLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(HeadLocalService service) {
	}

	private static HeadLocalService _service;
}