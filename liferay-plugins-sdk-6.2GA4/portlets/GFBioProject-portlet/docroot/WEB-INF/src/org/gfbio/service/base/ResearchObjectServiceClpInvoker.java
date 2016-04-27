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
		_methodName114 = "getBeanIdentifier";

		_methodParameterTypes114 = new String[] {  };

		_methodName115 = "setBeanIdentifier";

		_methodParameterTypes115 = new String[] { "java.lang.String" };

		_methodName120 = "getResearchObjectAbsolutParent";

		_methodParameterTypes120 = new String[] { "org.json.simple.JSONObject" };

		_methodName121 = "getResearchObjectById";

		_methodParameterTypes121 = new String[] { "java.lang.String" };

		_methodName122 = "getResearchObjectParent";

		_methodParameterTypes122 = new String[] { "org.json.simple.JSONObject" };

		_methodName123 = "getResearchObjectsByParent";

		_methodParameterTypes123 = new String[] { "org.json.simple.JSONObject" };

		_methodName124 = "createResearchObject";

		_methodParameterTypes124 = new String[] { "java.lang.String" };

		_methodName125 = "updateResearchObject";

		_methodParameterTypes125 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return ResearchObjectServiceUtil.getBeanIdentifier();
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			ResearchObjectServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectAbsolutParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectById((java.lang.String)arguments[0]);
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectsByParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return ResearchObjectServiceUtil.createResearchObject((java.lang.String)arguments[0]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return ResearchObjectServiceUtil.updateResearchObject((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
}