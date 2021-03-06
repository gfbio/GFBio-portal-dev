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

package org.gfbio.service.impl;

import java.util.Date;

import org.gfbio.NoSuchUserGoesternIDException;
import org.gfbio.model.UserGoesternID;
import org.gfbio.service.UserGoesternIDLocalServiceUtil;
import org.gfbio.service.base.UserGoesternIDLocalServiceBaseImpl;
import org.gfbio.service.persistence.UserGoesternIDPK;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the user goestern i d local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.UserGoesternIDLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Felicitas L�ffler
 * @see org.gfbio.service.base.UserGoesternIDLocalServiceBaseImpl
 * @see org.gfbio.service.UserGoesternIDLocalServiceUtil
 */
public class UserGoesternIDLocalServiceImpl extends
		UserGoesternIDLocalServiceBaseImpl {

	/**
	 * updates the UserGoesternID entry, if no entry is available it creates a
	 * new entry
	 * 
	 * @param userID
	 * @param goeSternID
	 * @return
	 * @throws Exception
	 */
	public UserGoesternID updateUserGoesternID(long userID, String goeSternID)
			throws Exception {
		UserGoesternID userGoesternId = null;
		try {
			if (userID == 0) {
				throw new Exception("The userId is 0!");
			}

			if (goeSternID == null || goeSternID.isEmpty()) {
				throw new Exception("The goesternId is null or empty!");
			}

			UserGoesternIDPK userGoesternIDPK = new UserGoesternIDPK();
			userGoesternIDPK.setGoeSternID(goeSternID);
			userGoesternIDPK.setUserID(userID);

			userGoesternId = userGoesternIDPersistence.fetchByPrimaryKey(userGoesternIDPK);

			if (userGoesternId == null) {
				userGoesternId = userGoesternIDPersistence.create(userGoesternIDPK);		
					//UserGoesternIDLocalServiceUtil.createUserGoesternID(userGoesternIDPK);
			}

			userGoesternId.setLastModifiedDate(new Date());
			
			userGoesternId = super.updateUserGoesternID(userGoesternId);
			
			//UserGoesternIDLocalServiceUtil.updateUserGoesternID(userGoesternId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userGoesternId;
	}

	/**
	 * returns the userID of a user being identified by goesternID
	 * 
	 * @param goesternID
	 * @return
	 */
	public long getUserIdByGoesternID(String goesternID) {
		if (goesternID != null && goesternID.length() > 0) {
			try {
				UserGoesternID ug = userGoesternIDPersistence
						.findByGoeSternID(goesternID);
				if (ug != null) {
					return ug.getUserID();
				}
			} catch (NoSuchUserGoesternIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * returns the goesternID of a user being identified by userID
	 * 
	 * @param userID
	 * @return
	 */
	public String getGoesternIDByUserID(long userID) {
		if (userID > 0) {
			try {
				UserGoesternID ug = userGoesternIDPersistence
						.findByUserID(userID);
				if (ug != null) {
					return ug.getGoeSternID();
				}
			} catch (NoSuchUserGoesternIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}