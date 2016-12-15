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

import org.gfbio.service.SearchFeedbackServiceUtil;

import java.util.Arrays;

/**
 * @author Kobkaew Opasjumruskit
 * @generated
 */
public class SearchFeedbackServiceClpInvoker {
	public SearchFeedbackServiceClpInvoker() {
		_methodName24 = "getBeanIdentifier";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "setBeanIdentifier";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName30 = "getSearchFeedbackById";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "getSearchFeedbackByIds";

		_methodParameterTypes31 = new String[] { "long[][]" };

		_methodName32 = "getSearchFeedbackIDByUserId";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "getSearchFeedbackIdByUserAndPeriod";

		_methodParameterTypes33 = new String[] { "long", "int" };

		_methodName34 = "getSearchFeedbackIdByRating";

		_methodParameterTypes34 = new String[] { "int[][]" };

		_methodName35 = "getSearchFeedbackIdByRatingsAndPeriod";

		_methodParameterTypes35 = new String[] { "int[][]", "int" };

		_methodName36 = "getSearchFeedbackIdByQueryString";

		_methodParameterTypes36 = new String[] { "java.lang.String" };

		_methodName37 = "getSearchFeedbackIdByQueryStringAndPeriod";

		_methodParameterTypes37 = new String[] { "java.lang.String", "int" };

		_methodName38 = "getSearchFeedbackIdByPeriod";

		_methodParameterTypes38 = new String[] { "int" };

		_methodName39 = "updateSearchFeedback";

		_methodParameterTypes39 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "int"
			};

		_methodName40 = "removeSearchFeedback";

		_methodParameterTypes40 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SearchFeedbackServiceUtil.getBeanIdentifier();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			SearchFeedbackServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackById(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackByIds((long[])arguments[0]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIDByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIdByUserAndPeriod(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIdByRating((int[])arguments[0]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIdByRatingsAndPeriod((int[])arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIdByQueryString((java.lang.String)arguments[0]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIdByQueryStringAndPeriod((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SearchFeedbackServiceUtil.getSearchFeedbackIdByPeriod(((Integer)arguments[0]).intValue());
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return SearchFeedbackServiceUtil.updateSearchFeedback(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return SearchFeedbackServiceUtil.removeSearchFeedback(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
}