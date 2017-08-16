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
 * Provides the local service utility for ResearchObject_User. This utility wraps
 * {@link org.gfbio.service.impl.ResearchObject_UserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see ResearchObject_UserLocalService
 * @see org.gfbio.service.base.ResearchObject_UserLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ResearchObject_UserLocalServiceImpl
 * @generated
 */
public class ResearchObject_UserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.ResearchObject_UserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the research object_ user to the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_User the research object_ user
	* @return the research object_ user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject_User addResearchObject_User(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addResearchObject_User(researchObject_User);
	}

	/**
	* Creates a new research object_ user with the primary key. Does not add the research object_ user to the database.
	*
	* @param researchObject_UserPK the primary key for the new research object_ user
	* @return the new research object_ user
	*/
	public static org.gfbio.model.ResearchObject_User createResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK) {
		return getService().createResearchObject_User(researchObject_UserPK);
	}

	/**
	* Deletes the research object_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user that was removed
	* @throws PortalException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject_User deleteResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResearchObject_User(researchObject_UserPK);
	}

	/**
	* Deletes the research object_ user from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_User the research object_ user
	* @return the research object_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject_User deleteResearchObject_User(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResearchObject_User(researchObject_User);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.ResearchObject_User fetchResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchResearchObject_User(researchObject_UserPK);
	}

	/**
	* Returns the research object_ user with the primary key.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user
	* @throws PortalException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject_User getResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObject_User(researchObject_UserPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the research object_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @return the range of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject_User> getResearchObject_Users(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObject_Users(start, end);
	}

	/**
	* Returns the number of research object_ users.
	*
	* @return the number of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public static int getResearchObject_UsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObject_UsersCount();
	}

	/**
	* Updates the research object_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param researchObject_User the research object_ user
	* @return the research object_ user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject_User updateResearchObject_User(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateResearchObject_User(researchObject_User);
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

	public static org.json.simple.JSONArray getUserIdsByResearchObject(
		org.json.simple.JSONObject requestJson) {
		return getService().getUserIdsByResearchObject(requestJson);
	}

	public static java.lang.String getFullNamesAsString(
		org.json.simple.JSONArray requestJson) {
		return getService().getFullNamesAsString(requestJson);
	}

	public static org.json.simple.JSONArray getOwnerAndPiByResearchObjectId(
		long researchObjectId) {
		return getService().getOwnerAndPiByResearchObjectId(researchObjectId);
	}

	public static java.util.List<java.lang.Long> getOwnerIdsByResearchObjectIds(
		long researchObjectId) {
		return getService().getOwnerIdsByResearchObjectIds(researchObjectId);
	}

	public static java.util.List<java.lang.Long> getOwnerIdsByResearchObjectIds(
		long researchObjectId, int researchObjectVersion) {
		return getService()
				   .getOwnerIdsByResearchObjectIds(researchObjectId,
			researchObjectVersion);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getResearchObjectsByUserId(
		long userId) {
		return getService().getResearchObjectsByUserId(userId);
	}

	public static java.util.List<org.gfbio.model.ResearchObject_User> getResearchObjectIdList(
		long arg0) {
		return getService().getResearchObjectIdList(arg0);
	}

	public static java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getService()
				   .checkResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static java.lang.Boolean updateResearchObjectUser(
		long researchObjectId, long userId, java.lang.String userType) {
		return getService()
				   .updateResearchObjectUser(researchObjectId, userId, userType);
	}

	public static java.lang.Boolean updateResearchObjectUser(
		long researchObjectId, int researchObjectVersion, long userId,
		java.lang.String userType) {
		return getService()
				   .updateResearchObjectUser(researchObjectId,
			researchObjectVersion, userId, userType);
	}

	public static java.lang.Boolean updateResearchObjectUser(
		long researchObjectId, int researchObjectVersion, long userId,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String userType) {
		return getService()
				   .updateResearchObjectUser(researchObjectId,
			researchObjectVersion, userId, startDate, endDate, userType);
	}

	public static java.lang.Boolean updateResearchObjectVersion(long userId,
		long researchObjectId, int oldResearchObjectVersion,
		int newResearchObjectVersion) {
		return getService()
				   .updateResearchObjectVersion(userId, researchObjectId,
			oldResearchObjectVersion, newResearchObjectVersion);
	}

	public static void clearService() {
		_service = null;
	}

	public static ResearchObject_UserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ResearchObject_UserLocalService.class.getName());

			if (invokableLocalService instanceof ResearchObject_UserLocalService) {
				_service = (ResearchObject_UserLocalService)invokableLocalService;
			}
			else {
				_service = new ResearchObject_UserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ResearchObject_UserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ResearchObject_UserLocalService service) {
	}

	private static ResearchObject_UserLocalService _service;
}