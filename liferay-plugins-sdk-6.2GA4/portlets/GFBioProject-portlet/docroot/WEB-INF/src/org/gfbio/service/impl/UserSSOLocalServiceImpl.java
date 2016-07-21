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

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;

import org.gfbio.NoSuchUserSSOException;
import org.gfbio.model.UserSSO;
import org.gfbio.service.UserSSOLocalServiceUtil;
import org.gfbio.service.base.UserSSOLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;

/**
 * The implementation of the user s s o local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.UserSSOLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.UserSSOLocalServiceBaseImpl
 * @see org.gfbio.service.UserSSOLocalServiceUtil
 */
public class UserSSOLocalServiceImpl extends UserSSOLocalServiceBaseImpl {
	private UserSSO updateUserSSO(long userID, String token) {
		UserSSO sso = null;
		Date now = new Date();
		try {
			// update userSSO
			sso = userSSOPersistence.findByPrimaryKey(userID);
			sso.setToken(token);
			sso.setLastModifiedDate(now);
			UserSSO ret = UserSSOLocalServiceUtil.updateUserSSO(sso);

		} catch (Exception e){
			e.printStackTrace();
		}
		
		return sso;
	}
	private UserSSO createUserSSO(long userID, String token){
		UserSSO sso = null;
		Date now = new Date();
		// create new userSSO
		try {
			sso = userSSOPersistence.create(userID);
			sso.setToken(token);
			sso.setLastModifiedDate(now);
			UserSSO ret = UserSSOLocalServiceUtil.addUserSSO(sso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sso;
	}
	
	// return 	0 : success, 1 : token expired, 
	//			2 : no record found, 3 token mismatched,
	// 			4 : unknown error;
	public int authorizeToken(String token, long userID) throws Exception {
		int success = 4;
		try {
			UserSSO sso = userSSOPersistence.findByUserID(userID);
			Date tokenDate = sso.getLastModifiedDate();
			// only for the valid token
			if (getDifferentDates(tokenDate) < 7) {
				String savedToken = sso.getToken();
				if (savedToken.equals(token)) {
					success = 0;
				}
				else{
					success = 3;
				}
			}
			else {
				success = 1;
			}

		} catch (Exception e) {
			success = 2; //no record
			e.printStackTrace();
		}
		return success;
	}

	public String getToken(long userID) {
		String token = "";
		try{
			UserSSO sso = this.userSSOPersistence.findByUserID(userID);

			Date tokenDate = sso.getLastModifiedDate();
			if (getDifferentDates(tokenDate) >= 7) {
				token = generateNewToken();
				// update token to db
				updateUserSSO(userID,token);
			} else {// use the existing one
				token = sso.getToken();
			}

		} catch (NoSuchUserSSOException e) {
			token = generateNewToken();
			// create new row in db
			createUserSSO(userID,token);
		} catch (Exception e){
			System.out.println(e);
		}
		return token;
	}

	private String generateNewToken() {
		SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[20];
	    random.nextBytes(bytes);
	    String token = bytes.toString();
		return token;
	}

	private long getDifferentDates(Date refDate) {
		// check if the existing token is older than a week
		Date now = getNow();
		long diff = now.getTime() - refDate.getTime();
		long diffDays = diff / (1000 * 60 * 60 * 24);
		return diffDays;
	}

	private Date getNow() {
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now".
		Date now = calendar.getTime();
		// 3) a java current time (now) instance
		// Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return now;
	}

}