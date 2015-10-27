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

package org.gfbio.service.base;

import org.gfbio.service.SubmissionRegistryServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class SubmissionRegistryServiceClpInvoker {
	public SubmissionRegistryServiceClpInvoker() {
		_methodName104 = "getBeanIdentifier";

		_methodParameterTypes104 = new String[] {  };

		_methodName105 = "setBeanIdentifier";

		_methodParameterTypes105 = new String[] { "java.lang.String" };

		_methodName110 = "getArchivepidsOfENA";

		_methodParameterTypes110 = new String[] { "java.lang.String" };

		_methodName111 = "getArchivepidsWithTypeSampleOfENA";

		_methodParameterTypes111 = new String[] { "java.lang.String" };

		_methodName112 = "getArchivepidWithTypeStudyOfENA";

		_methodParameterTypes112 = new String[] { "java.lang.String" };

		_methodName113 = "getLatestSubmissionByIds";

		_methodParameterTypes113 = new String[] { "long", "java.lang.String" };

		_methodName114 = "getLatestSubmissionsByArchive";

		_methodParameterTypes114 = new String[] { "java.lang.String" };

		_methodName115 = "getLatestSubmissionsByResearchobjectid";

		_methodParameterTypes115 = new String[] { "long" };

		_methodName116 = "getLatestSubmissions";

		_methodParameterTypes116 = new String[] {  };

		_methodName117 = "getSubmissionRegistriesByBrokerSubmissionId";

		_methodParameterTypes117 = new String[] { "org.json.simple.JSONObject" };

		_methodName118 = "getSubmissionRegistriesByResearchObjectId";

		_methodParameterTypes118 = new String[] { "org.json.simple.JSONObject" };

		_methodName119 = "createSubmissionRegistry";

		_methodParameterTypes119 = new String[] { "org.json.simple.JSONObject" };

		_methodName120 = "updateSubmissionRegistry";

		_methodParameterTypes120 = new String[] { "org.json.simple.JSONObject" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getBeanIdentifier();
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			SubmissionRegistryServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getArchivepidsOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getArchivepidsWithTypeSampleOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getArchivepidWithTypeStudyOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getLatestSubmissionByIds(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getLatestSubmissionsByArchive((java.lang.String)arguments[0]);
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getLatestSubmissionsByResearchobjectid(((Long)arguments[0]).longValue());
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getLatestSubmissions();
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getSubmissionRegistriesByBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return SubmissionRegistryServiceUtil.getSubmissionRegistriesByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			return SubmissionRegistryServiceUtil.createSubmissionRegistry((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return SubmissionRegistryServiceUtil.updateSubmissionRegistry((org.json.simple.JSONObject)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
}