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

import org.gfbio.service.ResearchObjectServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ResearchObjectServiceClpInvoker {
	public ResearchObjectServiceClpInvoker() {
		_methodName104 = "getBeanIdentifier";

		_methodParameterTypes104 = new String[] {  };

		_methodName105 = "setBeanIdentifier";

		_methodParameterTypes105 = new String[] { "java.lang.String" };

		_methodName110 = "getAllChildren";

		_methodParameterTypes110 = new String[] { "long" };

		_methodName111 = "getResearchObjectAbsolutParent";

		_methodParameterTypes111 = new String[] { "org.json.simple.JSONObject" };

		_methodName112 = "getResearchObjectsByParent";

		_methodParameterTypes112 = new String[] { "org.json.simple.JSONObject" };

		_methodName113 = "getResearchObjectById";

		_methodParameterTypes113 = new String[] { "long" };

		_methodName114 = "getResearchObjectParent";

		_methodParameterTypes114 = new String[] { "org.json.simple.JSONObject" };

		_methodName115 = "createResearchObject";

		_methodParameterTypes115 = new String[] { "org.json.simple.JSONObject" };

		_methodName116 = "updateResearchObject";

		_methodParameterTypes116 = new String[] { "org.json.simple.JSONObject" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return ResearchObjectServiceUtil.getBeanIdentifier();
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			ResearchObjectServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return ResearchObjectServiceUtil.getAllChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectAbsolutParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectsByParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return ResearchObjectServiceUtil.getResearchObjectParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return ResearchObjectServiceUtil.createResearchObject((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return ResearchObjectServiceUtil.updateResearchObject((org.json.simple.JSONObject)arguments[0]);
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
}