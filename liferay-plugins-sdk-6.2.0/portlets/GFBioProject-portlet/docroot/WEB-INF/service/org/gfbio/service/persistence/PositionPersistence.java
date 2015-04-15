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

import org.gfbio.model.Position;

/**
 * The persistence interface for the position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see PositionPersistenceImpl
 * @see PositionUtil
 * @generated
 */
public interface PositionPersistence extends BasePersistence<Position> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PositionUtil} to access the position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the position where positionID = &#63; or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	*
	* @param positionID the position i d
	* @return the matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param positionID the position i d
	* @return the matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param positionID the position i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByPositionID(long positionID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the position where positionID = &#63; from the database.
	*
	* @param positionID the position i d
	* @return the position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position removeByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the number of positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Position> findByHeadID(long headID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Position> findByHeadID(long headID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByHeadID_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByHeadID_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByHeadID_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByHeadID_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Position[] findByHeadID_PrevAndNext(
		long positionID, long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the position in the entity cache if it is enabled.
	*
	* @param position the position
	*/
	public void cacheResult(org.gfbio.model.Position position);

	/**
	* Caches the positions in the entity cache if it is enabled.
	*
	* @param positions the positions
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Position> positions);

	/**
	* Creates a new position with the primary key. Does not add the position to the database.
	*
	* @param positionID the primary key for the new position
	* @return the new position
	*/
	public org.gfbio.model.Position create(long positionID);

	/**
	* Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param positionID the primary key of the position
	* @return the position that was removed
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position remove(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	public org.gfbio.model.Position updateImpl(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the position with the primary key or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	*
	* @param positionID the primary key of the position
	* @return the position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByPrimaryKey(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param positionID the primary key of the position
	* @return the position, or <code>null</code> if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByPrimaryKey(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions.
	*
	* @return the positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Position> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Position> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the positions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions.
	*
	* @return the number of positions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}