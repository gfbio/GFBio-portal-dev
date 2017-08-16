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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserSSO. This utility wraps
 * {@link org.gfbio.service.impl.UserSSOLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see UserSSOLocalService
 * @see org.gfbio.service.base.UserSSOLocalServiceBaseImpl
 * @see org.gfbio.service.impl.UserSSOLocalServiceImpl
 * @generated
 */
public class UserSSOLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.UserSSOLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user s s o to the database. Also notifies the appropriate model listeners.
	*
	* @param userSSO the user s s o
	* @return the user s s o that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO addUserSSO(
		org.gfbio.model.UserSSO userSSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserSSO(userSSO);
	}

	/**
	* Creates a new user s s o with the primary key. Does not add the user s s o to the database.
	*
	* @param userID the primary key for the new user s s o
	* @return the new user s s o
	*/
	public static org.gfbio.model.UserSSO createUserSSO(long userID) {
		return getService().createUserSSO(userID);
	}

	/**
	* Deletes the user s s o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user s s o
	* @return the user s s o that was removed
	* @throws PortalException if a user s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO deleteUserSSO(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSSO(userID);
	}

	/**
	* Deletes the user s s o from the database. Also notifies the appropriate model listeners.
	*
	* @param userSSO the user s s o
	* @return the user s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO deleteUserSSO(
		org.gfbio.model.UserSSO userSSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSSO(userSSO);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.UserSSO fetchUserSSO(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserSSO(userID);
	}

	/**
	* Returns the user s s o with the primary key.
	*
	* @param userID the primary key of the user s s o
	* @return the user s s o
	* @throws PortalException if a user s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO getUserSSO(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSSO(userID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user s s os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user s s os
	* @param end the upper bound of the range of user s s os (not inclusive)
	* @return the range of user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.UserSSO> getUserSSOs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSSOs(start, end);
	}

	/**
	* Returns the number of user s s os.
	*
	* @return the number of user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserSSOsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSSOsCount();
	}

	/**
	* Updates the user s s o in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSSO the user s s o
	* @return the user s s o that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO updateUserSSO(
		org.gfbio.model.UserSSO userSSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserSSO(userSSO);
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

	public static int authenticateToken(java.lang.String token, long userID)
		throws java.lang.Exception {
		return getService().authenticateToken(token, userID);
	}

	public static java.lang.String getToken(long userID) {
		return getService().getToken(userID);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserSSOLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserSSOLocalService.class.getName());

			if (invokableLocalService instanceof UserSSOLocalService) {
				_service = (UserSSOLocalService)invokableLocalService;
			}
			else {
				_service = new UserSSOLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserSSOLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserSSOLocalService service) {
	}

	private static UserSSOLocalService _service;
}