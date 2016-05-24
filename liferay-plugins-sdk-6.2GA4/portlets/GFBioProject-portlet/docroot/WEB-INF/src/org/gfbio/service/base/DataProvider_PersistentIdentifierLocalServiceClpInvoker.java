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

import org.gfbio.service.DataProvider_PersistentIdentifierLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class DataProvider_PersistentIdentifierLocalServiceClpInvoker {
	public DataProvider_PersistentIdentifierLocalServiceClpInvoker() {
		_methodName0 = "addDataProvider_PersistentIdentifier";

		_methodParameterTypes0 = new String[] {
				"org.gfbio.model.DataProvider_PersistentIdentifier"
			};

		_methodName1 = "createDataProvider_PersistentIdentifier";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK"
			};

		_methodName2 = "deleteDataProvider_PersistentIdentifier";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK"
			};

		_methodName3 = "deleteDataProvider_PersistentIdentifier";

		_methodParameterTypes3 = new String[] {
				"org.gfbio.model.DataProvider_PersistentIdentifier"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchDataProvider_PersistentIdentifier";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK"
			};

		_methodName11 = "getDataProvider_PersistentIdentifier";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getDataProvider_PersistentIdentifiers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getDataProvider_PersistentIdentifiersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateDataProvider_PersistentIdentifier";

		_methodParameterTypes15 = new String[] {
				"org.gfbio.model.DataProvider_PersistentIdentifier"
			};

		_methodName122 = "getBeanIdentifier";

		_methodParameterTypes122 = new String[] {  };

		_methodName123 = "setBeanIdentifier";

		_methodParameterTypes123 = new String[] { "java.lang.String" };

		_methodName128 = "getDataProviderIds";

		_methodParameterTypes128 = new String[] { "long" };

		_methodName129 = "getPersistentIdentiferIds";

		_methodParameterTypes129 = new String[] { "long" };

		_methodName130 = "updateDataProvider_PersistentIdentifier";

		_methodParameterTypes130 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.addDataProvider_PersistentIdentifier((org.gfbio.model.DataProvider_PersistentIdentifier)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.createDataProvider_PersistentIdentifier((org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.deleteDataProvider_PersistentIdentifier((org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.deleteDataProvider_PersistentIdentifier((org.gfbio.model.DataProvider_PersistentIdentifier)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.fetchDataProvider_PersistentIdentifier((org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getDataProvider_PersistentIdentifier((org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getDataProvider_PersistentIdentifiers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getDataProvider_PersistentIdentifiersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.updateDataProvider_PersistentIdentifier((org.gfbio.model.DataProvider_PersistentIdentifier)arguments[0]);
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			DataProvider_PersistentIdentifierLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getDataProviderIds(((Long)arguments[0]).longValue());
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.getPersistentIdentiferIds(((Long)arguments[0]).longValue());
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return DataProvider_PersistentIdentifierLocalServiceUtil.updateDataProvider_PersistentIdentifier(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
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
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
}