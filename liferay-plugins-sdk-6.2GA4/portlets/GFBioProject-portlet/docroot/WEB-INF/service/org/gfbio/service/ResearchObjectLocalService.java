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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ResearchObject. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Marcel Froemming
 * @see ResearchObjectLocalServiceUtil
 * @see org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ResearchObjectLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ResearchObjectLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResearchObjectLocalServiceUtil} to access the research object local service. Add custom service methods to {@link org.gfbio.service.impl.ResearchObjectLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the research object to the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.ResearchObject addResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new research object with the primary key. Does not add the research object to the database.
	*
	* @param researchObjectPK the primary key for the new research object
	* @return the new research object
	*/
	public org.gfbio.model.ResearchObject createResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK);

	/**
	* Deletes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object that was removed
	* @throws PortalException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.ResearchObject deleteResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the research object from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.ResearchObject deleteResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.ResearchObject fetchResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object with the primary key.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object
	* @throws PortalException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.ResearchObject getResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of research objects
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research objects.
	*
	* @return the number of research objects
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResearchObjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the research object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.ResearchObject updateResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getResearchObjectAsJsonById(
		org.json.simple.JSONArray requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getResearchObjectASJsonById(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getResearchObjectAbsolutParent(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getResearchObjectsByParent(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getResearchObjectParent(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.ResearchObject> getAllChildren(
		long researchObjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.ResearchObject> getDirectChildren(
		long researchObjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.ResearchObject getDirectParent(long researchObjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.ResearchObject getLatestResearchObjectById(
		long researchObjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLatestVersionById(long researchObjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getProjectIdByIds(long researchObjectId,
		int researchObjectVersion);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjectById(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.ResearchObject getTopParent(long researchObjectId);

	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList);

	public java.lang.Boolean checkParentAttributById(long researchObjectId);

	public org.json.simple.JSONObject checkNullParent(
		org.json.simple.JSONObject json);

	public java.lang.Boolean checkResearchObjectId(long researchObjectId);

	public java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion);

	public org.json.simple.JSONObject constructResearchObjectJson(
		org.gfbio.model.ResearchObject researchObject);

	public org.json.simple.JSONArray constructResearchObjectsJson(
		java.util.List<org.gfbio.model.ResearchObject> researchObjectList);

	public org.json.simple.JSONArray createResearchObjectByJson(
		org.json.simple.JSONArray requestJson);

	public org.json.simple.JSONObject createResearchObjectByJson(
		org.json.simple.JSONObject requestJson);

	public org.json.simple.JSONArray updateResearchObjectByJson(
		org.json.simple.JSONArray requestJson);

	public org.json.simple.JSONObject updateResearchObjectByJson(
		org.json.simple.JSONObject requestJson);

	public long createResearchObject(java.lang.String name,
		java.lang.String label, java.lang.String extendedData)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long updateKernelResearchObject(long researchObjectId,
		int researchObjectVersion, java.lang.String name,
		java.lang.String label, java.lang.String extendedData);

	public long updateResearchObjectWithProject(long projectId,
		long researchObjectId, int researchObjectVersion,
		java.lang.String name, java.lang.String label,
		java.lang.String extendedData, java.lang.String researchObjectType);

	public org.json.simple.JSONObject checkHCCBackground(
		java.lang.String tableName, java.lang.String columnName,
		java.lang.String label);

	public java.lang.Boolean updateLicenseId(long researchObjectId,
		int researchObjectVersion, java.lang.String licenseLabel);

	public java.lang.Boolean updateLicenseId(long researchObjectId,
		int researchObjectVersion, long licenseId);

	public java.lang.Boolean updateMetadataId(long researchObjectId,
		int researchObjectVersion, long metadataId);

	public java.lang.Boolean updateParentResearchObjectIdByIds(
		long researchObjectId, int researchObjectVersion,
		long parentResearchObjectId);

	public java.lang.Boolean updateResearchObjectType(long researchObjectId,
		int researchObjectVersion, java.lang.String researchObjectType);

	public int updateResearchObjectVersion(long researchObjectId,
		int researchObjectVersion);
}