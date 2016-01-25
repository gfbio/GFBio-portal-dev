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

package org.gfbio.service.base;

import org.gfbio.service.ResearchObjectServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ResearchObjectServiceClpInvoker {
	public ResearchObjectServiceClpInvoker() {
		_methodName100 = "getBeanIdentifier";

		_methodParameterTypes100 = new String[] {  };

		_methodName101 = "setBeanIdentifier";

		_methodParameterTypes101 = new String[] { "java.lang.String" };

		_methodName106 = "getResearchObjectAbsolutParent";

		_methodParameterTypes106 = new String[] { "org.json.simple.JSONObject" };

		_methodName107 = "getResearchObjectById";

		_methodParameterTypes107 = new String[] { "java.lang.String" };

		_methodName108 = "getResearchObjectParent";

		_methodParameterTypes108 = new String[] { "org.json.simple.JSONObject" };

		_methodName109 = "getResearchObjectsByParent";

		_methodParameterTypes109 = new String[] { "org.json.simple.JSONObject" };

		_methodName110 = "createResearchObject";

		_methodParameterTypes110 = new String[] { "java.lang.String" };

		_methodName111 = "getTest";

		_methodParameterTypes111 = new String[] { "java.lang.String" };

		_methodName112 = "createTest";

		_methodParameterTypes112 = new String[] { "org.json.simple.JSONObject" };

		_methodName113 = "updateResearchObject";

		_methodParameterTypes113 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return ResearchObjectServiceUtil.getBeanIdentifier();
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			ResearchObjectServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectAbsolutParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectById((java.lang.String)arguments[0]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectsByParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return ResearchObjectServiceUtil.createResearchObject((java.lang.String)arguments[0]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return ResearchObjectServiceUtil.getTest((java.lang.String)arguments[0]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return ResearchObjectServiceUtil.createTest((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return ResearchObjectServiceUtil.updateResearchObject((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
}