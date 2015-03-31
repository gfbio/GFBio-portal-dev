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

import org.gfbio.service.BasketServiceUtil;

import java.util.Arrays;

/**
 * @author Felicitas Loeffler
 * @generated
 */
public class BasketServiceClpInvoker {
	public BasketServiceClpInvoker() {
		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "getBasketsByUserId";

		_methodParameterTypes54 = new String[] { "long" };

		_methodName55 = "getBasketsByUserAndPeriod";

		_methodParameterTypes55 = new String[] { "long", "int" };

		_methodName56 = "getBasketsIdByUserId";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "getBasketsIdByUserAndPeriod";

		_methodParameterTypes57 = new String[] { "long", "int" };

		_methodName58 = "getBasketById";

		_methodParameterTypes58 = new String[] { "long" };

		_methodName59 = "getBasketsByIds";

		_methodParameterTypes59 = new String[] { "long[][]" };

		_methodName60 = "updateBasket";

		_methodParameterTypes60 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName61 = "removeBasket";

		_methodParameterTypes61 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return BasketServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			BasketServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return BasketServiceUtil.getBasketsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return BasketServiceUtil.getBasketsByUserAndPeriod(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return BasketServiceUtil.getBasketsIdByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return BasketServiceUtil.getBasketsIdByUserAndPeriod(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return BasketServiceUtil.getBasketById(((Long)arguments[0]).longValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return BasketServiceUtil.getBasketsByIds((long[])arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return BasketServiceUtil.updateBasket(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return BasketServiceUtil.removeBasket(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
}