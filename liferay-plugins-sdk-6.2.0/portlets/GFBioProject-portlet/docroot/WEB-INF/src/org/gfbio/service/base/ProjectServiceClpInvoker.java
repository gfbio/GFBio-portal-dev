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

import org.gfbio.service.ProjectServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ProjectServiceClpInvoker {
	public ProjectServiceClpInvoker() {
		_methodName104 = "getBeanIdentifier";

		_methodParameterTypes104 = new String[] {  };

		_methodName105 = "setBeanIdentifier";

		_methodParameterTypes105 = new String[] { "java.lang.String" };

		_methodName110 = "getProjectById";

		_methodParameterTypes110 = new String[] { "org.json.simple.JSONObject" };

		_methodName111 = "getProjectListByUserId";

		_methodParameterTypes111 = new String[] { "long" };

		_methodName112 = "updateProject";

		_methodParameterTypes112 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return ProjectServiceUtil.getBeanIdentifier();
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			ProjectServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return ProjectServiceUtil.getProjectById((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return ProjectServiceUtil.getProjectListByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return ProjectServiceUtil.updateProject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.util.Date)arguments[5],
				(java.util.Date)arguments[6], (java.lang.String)arguments[7]);
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
}