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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.Position;

import java.util.List;

/**
 * The persistence utility for the position service. This utility wraps {@link PositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see PositionPersistence
 * @see PositionPersistenceImpl
 * @generated
 */
public class PositionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Position position) {
		getPersistence().clearCache(position);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Position> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Position update(Position position) throws SystemException {
		return getPersistence().update(position);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Position update(Position position,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(position, serviceContext);
	}

	/**
	* Returns the position where positionID = &#63; or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	*
	* @param positionID the position i d
	* @return the matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position findByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence().findByPositionId(positionID);
	}

	/**
	* Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param positionID the position i d
	* @return the matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position fetchByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPositionId(positionID);
	}

	/**
	* Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param positionID the position i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position fetchByPositionId(long positionID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPositionId(positionID, retrieveFromCache);
	}

	/**
	* Removes the position where positionID = &#63; from the database.
	*
	* @param positionID the position i d
	* @return the position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position removeByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence().removeByPositionId(positionID);
	}

	/**
	* Returns the number of positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPositionId(positionID);
	}

	/**
	* Returns all the positions where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Position> findByHeadId(
		long headID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadId(headID);
	}

	/**
	* Returns a range of all the positions where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Position> findByHeadId(
		long headID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadId(headID, start, end);
	}

	/**
	* Returns an ordered range of all the positions where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Position> findByHeadId(
		long headID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHeadId(headID, start, end, orderByComparator);
	}

	/**
	* Returns the first position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position findByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence().findByHeadId_First(headID, orderByComparator);
	}

	/**
	* Returns the first position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position fetchByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId_First(headID, orderByComparator);
	}

	/**
	* Returns the last position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position findByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence().findByHeadId_Last(headID, orderByComparator);
	}

	/**
	* Returns the last position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position fetchByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId_Last(headID, orderByComparator);
	}

	/**
	* Returns the positions before and after the current position in the ordered set where headID = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position[] findByHeadId_PrevAndNext(
		long positionID, long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence()
				   .findByHeadId_PrevAndNext(positionID, headID,
			orderByComparator);
	}

	/**
	* Removes all the positions where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHeadId(headID);
	}

	/**
	* Returns the number of positions where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadId(headID);
	}

	/**
	* Caches the position in the entity cache if it is enabled.
	*
	* @param position the position
	*/
	public static void cacheResult(org.gfbio.model.Position position) {
		getPersistence().cacheResult(position);
	}

	/**
	* Caches the positions in the entity cache if it is enabled.
	*
	* @param positions the positions
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Position> positions) {
		getPersistence().cacheResult(positions);
	}

	/**
	* Creates a new position with the primary key. Does not add the position to the database.
	*
	* @param positionID the primary key for the new position
	* @return the new position
	*/
	public static org.gfbio.model.Position create(long positionID) {
		return getPersistence().create(positionID);
	}

	/**
	* Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param positionID the primary key of the position
	* @return the position that was removed
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position remove(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence().remove(positionID);
	}

	public static org.gfbio.model.Position updateImpl(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(position);
	}

	/**
	* Returns the position with the primary key or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	*
	* @param positionID the primary key of the position
	* @return the position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position findByPrimaryKey(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getPersistence().findByPrimaryKey(positionID);
	}

	/**
	* Returns the position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param positionID the primary key of the position
	* @return the position, or <code>null</code> if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position fetchByPrimaryKey(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(positionID);
	}

	/**
	* Returns all the positions.
	*
	* @return the positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Position> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gfbio.model.Position> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Position> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the positions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of positions.
	*
	* @return the number of positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PositionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PositionPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					PositionPersistence.class.getName());

			ReferenceRegistry.registerReference(PositionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PositionPersistence persistence) {
	}

	private static PositionPersistence _persistence;
}