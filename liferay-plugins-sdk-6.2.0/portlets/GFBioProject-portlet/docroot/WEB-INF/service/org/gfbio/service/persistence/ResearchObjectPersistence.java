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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.ResearchObject;

/**
 * The persistence interface for the research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObjectPersistenceImpl
 * @see ResearchObjectUtil
 * @generated
 */
public interface ResearchObjectPersistence extends BasePersistence<ResearchObject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResearchObjectUtil} to access the research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the research objects where name = &#63;.
	*
	* @param name the name
	* @return the matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research objects where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research objects where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the first research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the last research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research objects before and after the current research object in the ordered set where name = &#63;.
	*
	* @param researchObjectPK the primary key of the current research object
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject[] findByName_PrevAndNext(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Removes all the research objects where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research objects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research objects where label = &#63;.
	*
	* @param label the label
	* @return the matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research objects where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByLabel(
		java.lang.String label, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research objects where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByLabel(
		java.lang.String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByLabel_First(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the first research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByLabel_First(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByLabel_Last(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the last research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByLabel_Last(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research objects before and after the current research object in the ordered set where label = &#63;.
	*
	* @param researchObjectPK the primary key of the current research object
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject[] findByLabel_PrevAndNext(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK,
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Removes all the research objects where label = &#63; from the database.
	*
	* @param label the label
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research objects where label = &#63;.
	*
	* @param label the label
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object where researchObjectID = &#63; and researchObjectVersion = &#63; or throws a {@link org.gfbio.NoSuchResearchObjectException} if it could not be found.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the research object where researchObjectID = &#63; and researchObjectVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object where researchObjectID = &#63; and researchObjectVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByIDAndVersion(
		long researchObjectID, int researchObjectVersion,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the research object where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject removeByIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the number of research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByIDAndVersion(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research objects where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research objects where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the first research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the last research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research objects before and after the current research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectPK the primary key of the current research object
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject[] findByResearchObjectID_PrevAndNext(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK,
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Removes all the research objects where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research objects where parentResearchObjectID = &#63;.
	*
	* @param parentResearchObjectID the parent research object i d
	* @return the matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByParentID(
		long parentResearchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research objects where parentResearchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentResearchObjectID the parent research object i d
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByParentID(
		long parentResearchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research objects where parentResearchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentResearchObjectID the parent research object i d
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findByParentID(
		long parentResearchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research object in the ordered set where parentResearchObjectID = &#63;.
	*
	* @param parentResearchObjectID the parent research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByParentID_First(
		long parentResearchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the first research object in the ordered set where parentResearchObjectID = &#63;.
	*
	* @param parentResearchObjectID the parent research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByParentID_First(
		long parentResearchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research object in the ordered set where parentResearchObjectID = &#63;.
	*
	* @param parentResearchObjectID the parent research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByParentID_Last(
		long parentResearchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the last research object in the ordered set where parentResearchObjectID = &#63;.
	*
	* @param parentResearchObjectID the parent research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByParentID_Last(
		long parentResearchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research objects before and after the current research object in the ordered set where parentResearchObjectID = &#63;.
	*
	* @param researchObjectPK the primary key of the current research object
	* @param parentResearchObjectID the parent research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject[] findByParentID_PrevAndNext(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK,
		long parentResearchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Removes all the research objects where parentResearchObjectID = &#63; from the database.
	*
	* @param parentResearchObjectID the parent research object i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentID(long parentResearchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research objects where parentResearchObjectID = &#63;.
	*
	* @param parentResearchObjectID the parent research object i d
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentID(long parentResearchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the research object in the entity cache if it is enabled.
	*
	* @param researchObject the research object
	*/
	public void cacheResult(org.gfbio.model.ResearchObject researchObject);

	/**
	* Caches the research objects in the entity cache if it is enabled.
	*
	* @param researchObjects the research objects
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.ResearchObject> researchObjects);

	/**
	* Creates a new research object with the primary key. Does not add the research object to the database.
	*
	* @param researchObjectPK the primary key for the new research object
	* @return the new research object
	*/
	public org.gfbio.model.ResearchObject create(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK);

	/**
	* Removes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object that was removed
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject remove(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	public org.gfbio.model.ResearchObject updateImpl(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object with the primary key or throws a {@link org.gfbio.NoSuchResearchObjectException} if it could not be found.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject findByPrimaryKey(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException;

	/**
	* Returns the research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object, or <code>null</code> if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject fetchByPrimaryKey(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research objects.
	*
	* @return the research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.ResearchObject> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research objects.
	*
	* @return the number of research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}