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

import org.gfbio.service.SearchHistoryServiceUtil;

import java.util.Arrays;

/**
 * @author Kobkaew Opasjumruskit
 * @generated
 */
public class SearchHistoryServiceClpInvoker {
	public SearchHistoryServiceClpInvoker() {
		_methodName24 = "getBeanIdentifier";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "setBeanIdentifier";

		_methodParameterTypes25 = new String[] { "java.lang.String" };

		_methodName30 = "getSearchHistoryById";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "getSearchHistoryByIds";

		_methodParameterTypes31 = new String[] { "long[][]" };

		_methodName32 = "getSearchHistoryIdByUserId";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "getSearchHistoryIdByUserAndPeriod";

		_methodParameterTypes33 = new String[] { "long", "int" };

		_methodName34 = "getSearchHistoryIdByQueryString";

		_methodParameterTypes34 = new String[] { "java.lang.String" };

		_methodName35 = "getSearchHistoryIdByQueryStringAndPeriod";

		_methodParameterTypes35 = new String[] { "java.lang.String", "int" };

		_methodName36 = "getSearchHistoryIdByPeriod";

		_methodParameterTypes36 = new String[] { "int" };

		_methodName37 = "updateSearchHistory";

		_methodParameterTypes37 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName38 = "removeSearchHistory";

		_methodParameterTypes38 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return SearchHistoryServiceUtil.getBeanIdentifier();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			SearchHistoryServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryById(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryByIds((long[])arguments[0]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryIdByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryIdByUserAndPeriod(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryIdByQueryString((java.lang.String)arguments[0]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryIdByQueryStringAndPeriod((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return SearchHistoryServiceUtil.getSearchHistoryIdByPeriod(((Integer)arguments[0]).intValue());
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return SearchHistoryServiceUtil.updateSearchHistory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return SearchHistoryServiceUtil.removeSearchHistory(((Long)arguments[0]).longValue());
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
}