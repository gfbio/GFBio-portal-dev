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

import org.gfbio.service.BasketServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class BasketServiceClpInvoker {
	public BasketServiceClpInvoker() {
		_methodName114 = "getBeanIdentifier";

		_methodParameterTypes114 = new String[] {  };

		_methodName115 = "setBeanIdentifier";

		_methodParameterTypes115 = new String[] { "java.lang.String" };

		_methodName120 = "getBasketById";

		_methodParameterTypes120 = new String[] { "long" };

		_methodName121 = "getBasketsByIds";

		_methodParameterTypes121 = new String[] { "long[][]" };

		_methodName122 = "getBasketsByUserAndPeriod";

		_methodParameterTypes122 = new String[] { "long", "int" };

		_methodName123 = "getBasketsByUserId";

		_methodParameterTypes123 = new String[] { "long" };

		_methodName124 = "getBasketsIdByUserAndPeriod";

		_methodParameterTypes124 = new String[] { "long", "int" };

		_methodName125 = "getBasketsIdByUserId";

		_methodParameterTypes125 = new String[] { "long" };

		_methodName126 = "updateBasket";

		_methodParameterTypes126 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName127 = "removeBasket";

		_methodParameterTypes127 = new String[] { "long", "long" };

		_methodName128 = "getBasketUsersIds";

		_methodParameterTypes128 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return BasketServiceUtil.getBeanIdentifier();
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			BasketServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return BasketServiceUtil.getBasketById(((Long)arguments[0]).longValue());
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			return BasketServiceUtil.getBasketsByIds((long[])arguments[0]);
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return BasketServiceUtil.getBasketsByUserAndPeriod(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return BasketServiceUtil.getBasketsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return BasketServiceUtil.getBasketsIdByUserAndPeriod(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return BasketServiceUtil.getBasketsIdByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return BasketServiceUtil.updateBasket(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return BasketServiceUtil.removeBasket(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return BasketServiceUtil.getBasketUsersIds(((Long)arguments[0]).longValue());
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
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
}