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

import org.gfbio.service.ColumnLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ColumnLocalServiceClpInvoker {
	public ColumnLocalServiceClpInvoker() {
		_methodName0 = "addColumn";

		_methodParameterTypes0 = new String[] { "org.gfbio.model.Column" };

		_methodName1 = "createColumn";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteColumn";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteColumn";

		_methodParameterTypes3 = new String[] { "org.gfbio.model.Column" };

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

		_methodName10 = "fetchColumn";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getColumn";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getColumns";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getColumnsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateColumn";

		_methodParameterTypes15 = new String[] { "org.gfbio.model.Column" };

		_methodName130 = "getBeanIdentifier";

		_methodParameterTypes130 = new String[] {  };

		_methodName131 = "setBeanIdentifier";

		_methodParameterTypes131 = new String[] { "java.lang.String" };

		_methodName136 = "deleteColumnsByHeadId";

		_methodParameterTypes136 = new String[] { "long" };

		_methodName137 = "getColumnIdByNames";

		_methodParameterTypes137 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName138 = "getColumnNameById";

		_methodParameterTypes138 = new String[] { "long" };

		_methodName139 = "getColumnsByHeadId";

		_methodParameterTypes139 = new String[] { "long" };

		_methodName140 = "getColumnsWithRelation";

		_methodParameterTypes140 = new String[] { "java.lang.String" };

		_methodName141 = "getCountofColumns";

		_methodParameterTypes141 = new String[] { "long" };

		_methodName142 = "getHeadIdById";

		_methodParameterTypes142 = new String[] { "long" };

		_methodName143 = "getHeadIdsByColumnName";

		_methodParameterTypes143 = new String[] { "java.lang.String" };

		_methodName144 = "getHeadIdsWithoutRelationshipsByColumnName";

		_methodParameterTypes144 = new String[] { "java.lang.String" };

		_methodName145 = "getMaxCountofColumns";

		_methodParameterTypes145 = new String[] { "java.util.List" };

		_methodName146 = "checkHaveTableRelationsById";

		_methodParameterTypes146 = new String[] { "long" };

		_methodName147 = "checkHaveTableRelationsByName";

		_methodParameterTypes147 = new String[] { "java.lang.String" };

		_methodName148 = "constructColumnJson";

		_methodParameterTypes148 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName149 = "updateColumn";

		_methodParameterTypes149 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName150 = "updateColumn";

		_methodParameterTypes150 = new String[] { "org.json.simple.JSONObject" };

		_methodName151 = "updateColumnWithContents";

		_methodParameterTypes151 = new String[] { "org.json.simple.JSONObject" };

		_methodName152 = "updateColumnWithContents2";

		_methodParameterTypes152 = new String[] { "org.json.simple.JSONObject" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ColumnLocalServiceUtil.addColumn((org.gfbio.model.Column)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ColumnLocalServiceUtil.createColumn(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ColumnLocalServiceUtil.deleteColumn(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ColumnLocalServiceUtil.deleteColumn((org.gfbio.model.Column)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ColumnLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ColumnLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ColumnLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ColumnLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ColumnLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ColumnLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ColumnLocalServiceUtil.fetchColumn(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumn(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ColumnLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumns(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumnsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ColumnLocalServiceUtil.updateColumn((org.gfbio.model.Column)arguments[0]);
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return ColumnLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			ColumnLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			ColumnLocalServiceUtil.deleteColumnsByHeadId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumnIdByNames((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumnNameById(((Long)arguments[0]).longValue());
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumnsByHeadId(((Long)arguments[0]).longValue());
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return ColumnLocalServiceUtil.getColumnsWithRelation((java.lang.String)arguments[0]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return ColumnLocalServiceUtil.getCountofColumns(((Long)arguments[0]).longValue());
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return ColumnLocalServiceUtil.getHeadIdById(((Long)arguments[0]).longValue());
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return ColumnLocalServiceUtil.getHeadIdsByColumnName((java.lang.String)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return ColumnLocalServiceUtil.getHeadIdsWithoutRelationshipsByColumnName((java.lang.String)arguments[0]);
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return ColumnLocalServiceUtil.getMaxCountofColumns((java.util.List<org.gfbio.model.Head>)arguments[0]);
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return ColumnLocalServiceUtil.checkHaveTableRelationsById(((Long)arguments[0]).longValue());
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return ColumnLocalServiceUtil.checkHaveTableRelationsByName((java.lang.String)arguments[0]);
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return ColumnLocalServiceUtil.constructColumnJson(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return ColumnLocalServiceUtil.updateColumn(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return ColumnLocalServiceUtil.updateColumn((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return ColumnLocalServiceUtil.updateColumnWithContents((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return ColumnLocalServiceUtil.updateColumnWithContents2((org.json.simple.JSONObject)arguments[0]);
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
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
	private String _methodName143;
	private String[] _methodParameterTypes143;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName146;
	private String[] _methodParameterTypes146;
	private String _methodName147;
	private String[] _methodParameterTypes147;
	private String _methodName148;
	private String[] _methodParameterTypes148;
	private String _methodName149;
	private String[] _methodParameterTypes149;
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName152;
	private String[] _methodParameterTypes152;
}