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

package org.gfbio.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.gfbio.service.SubmissionRegistryServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.SubmissionRegistryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.SubmissionRegistrySoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.SubmissionRegistry}, that is translated to a
 * {@link org.gfbio.model.SubmissionRegistrySoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryServiceHttp
 * @see org.gfbio.model.SubmissionRegistrySoap
 * @see org.gfbio.service.SubmissionRegistryServiceUtil
 * @generated
 */
public class SubmissionRegistryServiceSoap {
	public static java.lang.String[] getArchivepidsOfENA(
		java.lang.String archivePId) throws RemoteException {
		try {
			java.util.List<java.lang.String> returnValue = SubmissionRegistryServiceUtil.getArchivepidsOfENA(archivePId);

			return returnValue.toArray(new java.lang.String[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String[] getArchivepidsWithTypeSampleOfENA(
		java.lang.String archivePId) throws RemoteException {
		try {
			java.util.List<java.lang.String> returnValue = SubmissionRegistryServiceUtil.getArchivepidsWithTypeSampleOfENA(archivePId);

			return returnValue.toArray(new java.lang.String[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getArchivepidWithTypeStudyOfENA(
		java.lang.String archivePId) throws RemoteException {
		try {
			java.lang.String returnValue = SubmissionRegistryServiceUtil.getArchivepidWithTypeStudyOfENA(archivePId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.SubmissionRegistrySoap getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive)
		throws RemoteException {
		try {
			org.gfbio.model.SubmissionRegistry returnValue = SubmissionRegistryServiceUtil.getLatestSubmissionByIds(researchObjectId,
					archive);

			return org.gfbio.model.SubmissionRegistrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.SubmissionRegistrySoap[] getLatestSubmissionsByArchive(
		java.lang.String archive) throws RemoteException {
		try {
			java.util.List<org.gfbio.model.SubmissionRegistry> returnValue = SubmissionRegistryServiceUtil.getLatestSubmissionsByArchive(archive);

			return org.gfbio.model.SubmissionRegistrySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.SubmissionRegistrySoap[] getLatestSubmissionsByResearchobjectid(
		long researchObjectId) throws RemoteException {
		try {
			java.util.List<org.gfbio.model.SubmissionRegistry> returnValue = SubmissionRegistryServiceUtil.getLatestSubmissionsByResearchobjectid(researchObjectId);

			return org.gfbio.model.SubmissionRegistrySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.SubmissionRegistrySoap[] getLatestSubmissions()
		throws RemoteException {
		try {
			java.util.List<org.gfbio.model.SubmissionRegistry> returnValue = SubmissionRegistryServiceUtil.getLatestSubmissions();

			return org.gfbio.model.SubmissionRegistrySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status) throws RemoteException {
		try {
			java.lang.Boolean returnValue = SubmissionRegistryServiceUtil.updateStatus(researchObjectId,
					researchObjectVersion, archive, status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Boolean updateSubmissionregistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brockerSubmissionId,
		java.lang.String archivePId, java.util.Date lastChanged, long userID,
		java.lang.Boolean isPublic, java.util.Date publicAfter)
		throws RemoteException {
		try {
			java.lang.Boolean returnValue = SubmissionRegistryServiceUtil.updateSubmissionregistry(researchObjectId,
					researchObjectVersion, archive, brockerSubmissionId,
					archivePId, lastChanged, userID, isPublic, publicAfter);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Boolean updateSubmissionregistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brockerSubmissionId,
		java.lang.String archivePId, java.util.Date lastChanged, long userID,
		java.lang.Boolean isPublic, java.util.Date publicAfter,
		java.lang.String status) throws RemoteException {
		try {
			java.lang.Boolean returnValue = SubmissionRegistryServiceUtil.updateSubmissionregistry(researchObjectId,
					researchObjectVersion, archive, brockerSubmissionId,
					archivePId, lastChanged, userID, isPublic, publicAfter,
					status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Boolean updateSubmissionregistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brockerSubmissionId,
		java.lang.String archivePId, long archivePIdType,
		java.util.Date lastChanged, long userID, java.lang.Boolean isPublic,
		java.util.Date publicAfter, java.lang.String status)
		throws RemoteException {
		try {
			java.lang.Boolean returnValue = SubmissionRegistryServiceUtil.updateSubmissionregistry(researchObjectId,
					researchObjectVersion, archive, brockerSubmissionId,
					archivePId, archivePIdType, lastChanged, userID, isPublic,
					publicAfter, status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SubmissionRegistryServiceSoap.class);
}