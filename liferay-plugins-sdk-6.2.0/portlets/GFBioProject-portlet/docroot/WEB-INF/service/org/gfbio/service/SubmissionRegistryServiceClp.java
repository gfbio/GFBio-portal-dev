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

import com.liferay.portal.service.InvokableService;

/**
 * @author Marcel Froemming
 * @generated
 */
public class SubmissionRegistryServiceClp implements SubmissionRegistryService {
	public SubmissionRegistryServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getArchivepidsOfENA";

		_methodParameterTypes3 = new String[] { "java.lang.String" };

		_methodName4 = "getArchivepidsWithTypeSampleOfENA";

		_methodParameterTypes4 = new String[] { "java.lang.String" };

		_methodName5 = "getArchivepidWithTypeStudyOfENA";

		_methodParameterTypes5 = new String[] { "java.lang.String" };

		_methodName6 = "getLatestSubmissionByIds";

		_methodParameterTypes6 = new String[] { "long", "java.lang.String" };

		_methodName7 = "getLatestSubmissionsByArchive";

		_methodParameterTypes7 = new String[] { "java.lang.String" };

		_methodName8 = "getLatestSubmissionsByResearchobjectid";

		_methodParameterTypes8 = new String[] { "long" };

		_methodName9 = "getLatestSubmissions";

		_methodParameterTypes9 = new String[] {  };

		_methodName10 = "updateStatus";

		_methodParameterTypes10 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName11 = "updateSubmissionregistry";

		_methodParameterTypes11 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "long",
				"java.lang.Boolean", "java.util.Date"
			};

		_methodName12 = "updateSubmissionregistry";

		_methodParameterTypes12 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "long",
				"java.lang.Boolean", "java.util.Date", "java.lang.String"
			};

		_methodName13 = "updateSubmissionregistry";

		_methodParameterTypes13 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.Boolean", "java.util.Date", "java.lang.String"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.List<java.lang.String> getArchivepidsOfENA(
		java.lang.String archivePId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(archivePId) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<java.lang.String> getArchivepidsWithTypeSampleOfENA(
		java.lang.String archivePId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(archivePId) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getArchivepidWithTypeStudyOfENA(
		java.lang.String archivePId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(archivePId) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public org.gfbio.model.SubmissionRegistry getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						researchObjectId,
						
					ClpSerializer.translateInput(archive)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.gfbio.model.SubmissionRegistry)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(archive) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.gfbio.model.SubmissionRegistry>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByResearchobjectid(
		long researchObjectId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8, new Object[] { researchObjectId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.gfbio.model.SubmissionRegistry>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissions() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.gfbio.model.SubmissionRegistry>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						researchObjectId,
						
					researchObjectVersion,
						
					ClpSerializer.translateInput(archive),
						
					ClpSerializer.translateInput(status)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Boolean)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Boolean updateSubmissionregistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brockerSubmissionId, java.lang.String archivePId,
		java.util.Date lastChanged, long userID, java.lang.Boolean isPublic,
		java.util.Date publicAfter) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						researchObjectId,
						
					researchObjectVersion,
						
					ClpSerializer.translateInput(archive),
						
					ClpSerializer.translateInput(brockerSubmissionId),
						
					ClpSerializer.translateInput(archivePId),
						
					ClpSerializer.translateInput(lastChanged),
						
					userID,
						
					ClpSerializer.translateInput(isPublic),
						
					ClpSerializer.translateInput(publicAfter)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Boolean)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Boolean updateSubmissionregistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brockerSubmissionId, java.lang.String archivePId,
		java.util.Date lastChanged, long userID, java.lang.Boolean isPublic,
		java.util.Date publicAfter, java.lang.String status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						researchObjectId,
						
					researchObjectVersion,
						
					ClpSerializer.translateInput(archive),
						
					ClpSerializer.translateInput(brockerSubmissionId),
						
					ClpSerializer.translateInput(archivePId),
						
					ClpSerializer.translateInput(lastChanged),
						
					userID,
						
					ClpSerializer.translateInput(isPublic),
						
					ClpSerializer.translateInput(publicAfter),
						
					ClpSerializer.translateInput(status)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Boolean)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Boolean updateSubmissionregistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brockerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userID,
		java.lang.Boolean isPublic, java.util.Date publicAfter,
		java.lang.String status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] {
						researchObjectId,
						
					researchObjectVersion,
						
					ClpSerializer.translateInput(archive),
						
					ClpSerializer.translateInput(brockerSubmissionId),
						
					ClpSerializer.translateInput(archivePId),
						
					archivePIdType,
						
					ClpSerializer.translateInput(lastChanged),
						
					userID,
						
					ClpSerializer.translateInput(isPublic),
						
					ClpSerializer.translateInput(publicAfter),
						
					ClpSerializer.translateInput(status)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.Boolean)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
}