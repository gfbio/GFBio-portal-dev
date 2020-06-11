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

import org.gfbio.service.HeadLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class HeadLocalServiceClpInvoker {
	public HeadLocalServiceClpInvoker() {
		_methodName0 = "addHead";

		_methodParameterTypes0 = new String[] { "org.gfbio.model.Head" };

		_methodName1 = "createHead";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteHead";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteHead";

		_methodParameterTypes3 = new String[] { "org.gfbio.model.Head" };

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

		_methodName10 = "fetchHead";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getHead";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getHeads";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getHeadsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateHead";

		_methodParameterTypes15 = new String[] { "org.gfbio.model.Head" };

		_methodName176 = "getBeanIdentifier";

		_methodParameterTypes176 = new String[] {  };

		_methodName177 = "setBeanIdentifier";

		_methodParameterTypes177 = new String[] { "java.lang.String" };

		_methodName182 = "deleteTableByHeadId";

		_methodParameterTypes182 = new String[] { "long" };

		_methodName183 = "deleteTableByHeadIdWithoutCheck";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "getTableNamesByTableType";

		_methodParameterTypes184 = new String[] { "org.json.simple.JSONObject" };

		_methodName185 = "getArrayOfTableNames";

		_methodParameterTypes185 = new String[] { "java.lang.String" };

		_methodName186 = "getCountOfColumns";

		_methodParameterTypes186 = new String[] { "long" };

		_methodName187 = "getDescriptionByHeadId";

		_methodParameterTypes187 = new String[] { "long" };

		_methodName188 = "getEntitiesByHeadId";

		_methodParameterTypes188 = new String[] { "long" };

		_methodName189 = "getHeadIdByTableName";

		_methodParameterTypes189 = new String[] { "java.lang.String" };

		_methodName190 = "getHeadsByTableType";

		_methodParameterTypes190 = new String[] { "java.lang.String" };

		_methodName191 = "getIdTableAsArray";

		_methodParameterTypes191 = new String[] { "long" };

		_methodName193 = "getTableAsArray";

		_methodParameterTypes193 = new String[] { "long" };

		_methodName194 = "getTableAsJSONArrayByName";

		_methodParameterTypes194 = new String[] { "org.json.simple.JSONObject" };

		_methodName195 = "getTableAsJSONArray";

		_methodParameterTypes195 = new String[] { "long" };

		_methodName196 = "getTableNameArray";

		_methodParameterTypes196 = new String[] { "java.lang.String" };

		_methodName197 = "getTableNameArray";

		_methodParameterTypes197 = new String[] { "java.util.List" };

		_methodName198 = "getTableNameById";

		_methodParameterTypes198 = new String[] { "long" };

		_methodName199 = "getTableNamesByTableType";

		_methodParameterTypes199 = new String[] { "java.lang.String" };

		_methodName200 = "constructHeadJson";

		_methodParameterTypes200 = new String[] { "org.gfbio.model.Head" };

		_methodName201 = "constructHeadJson";

		_methodParameterTypes201 = new String[] {
				"long", "java.lang.String", "java.lang.String", "java.util.Date"
			};

		_methodName202 = "constructRelationName";

		_methodParameterTypes202 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName203 = "constructNewId";

		_methodParameterTypes203 = new String[] {  };

		_methodName204 = "updateHead";

		_methodParameterTypes204 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName205 = "updateHead";

		_methodParameterTypes205 = new String[] { "org.json.simple.JSONObject" };

		_methodName206 = "updateHeadWithLongRequest";

		_methodParameterTypes206 = new String[] { "org.json.simple.JSONObject" };

		_methodName207 = "updateHeadWithLongRequest";

		_methodParameterTypes207 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName208 = "updateHeadWithColumns";

		_methodParameterTypes208 = new String[] { "org.json.simple.JSONObject" };

		_methodName209 = "updateHeadWithColumns2";

		_methodParameterTypes209 = new String[] { "org.json.simple.JSONObject" };

		_methodName210 = "updateParentRelationTable";

		_methodParameterTypes210 = new String[] { "long", "java.lang.String" };

		_methodName211 = "updateParentRelationTableWithContent";

		_methodParameterTypes211 = new String[] { "long", "long", "long" };

		_methodName212 = "updateRelationTable";

		_methodParameterTypes212 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName213 = "updateRelationTableWithContent";

		_methodParameterTypes213 = new String[] { "long", "long", "long", "long" };

		_methodName214 = "updateTable";

		_methodParameterTypes214 = new String[] { "org.json.simple.JSONObject" };

		_methodName215 = "updateInterfaceTableWithContent";

		_methodParameterTypes215 = new String[] {
				"java.lang.String", "long", "java.lang.String", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return HeadLocalServiceUtil.addHead((org.gfbio.model.Head)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return HeadLocalServiceUtil.createHead(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return HeadLocalServiceUtil.deleteHead(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return HeadLocalServiceUtil.deleteHead((org.gfbio.model.Head)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return HeadLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return HeadLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return HeadLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return HeadLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return HeadLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return HeadLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return HeadLocalServiceUtil.fetchHead(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return HeadLocalServiceUtil.getHead(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return HeadLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return HeadLocalServiceUtil.getHeads(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return HeadLocalServiceUtil.getHeadsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return HeadLocalServiceUtil.updateHead((org.gfbio.model.Head)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return HeadLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			HeadLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			HeadLocalServiceUtil.deleteTableByHeadId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			HeadLocalServiceUtil.deleteTableByHeadIdWithoutCheck(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNamesByTableType((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return HeadLocalServiceUtil.getArrayOfTableNames((java.lang.String)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return HeadLocalServiceUtil.getCountOfColumns(((Long)arguments[0]).longValue());
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return HeadLocalServiceUtil.getDescriptionByHeadId(((Long)arguments[0]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return HeadLocalServiceUtil.getEntitiesByHeadId(((Long)arguments[0]).longValue());
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return HeadLocalServiceUtil.getHeadIdByTableName((java.lang.String)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return HeadLocalServiceUtil.getHeadsByTableType((java.lang.String)arguments[0]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return HeadLocalServiceUtil.getIdTableAsArray(((Long)arguments[0]).longValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return HeadLocalServiceUtil.getTableAsArray(((Long)arguments[0]).longValue());
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return HeadLocalServiceUtil.getTableAsJSONArrayByName((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return HeadLocalServiceUtil.getTableAsJSONArray(((Long)arguments[0]).longValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNameArray((java.lang.String)arguments[0]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNameArray((java.util.List<org.gfbio.model.Head>)arguments[0]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNameById(((Long)arguments[0]).longValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNamesByTableType((java.lang.String)arguments[0]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return HeadLocalServiceUtil.constructHeadJson((org.gfbio.model.Head)arguments[0]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return HeadLocalServiceUtil.constructHeadJson(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.util.Date)arguments[3]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return HeadLocalServiceUtil.constructRelationName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return HeadLocalServiceUtil.constructNewId();
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return HeadLocalServiceUtil.updateHead(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return HeadLocalServiceUtil.updateHead((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithLongRequest((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithLongRequest(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithColumns((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithColumns2((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return HeadLocalServiceUtil.updateParentRelationTable(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return HeadLocalServiceUtil.updateParentRelationTableWithContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return HeadLocalServiceUtil.updateRelationTable(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return HeadLocalServiceUtil.updateRelationTableWithContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return HeadLocalServiceUtil.updateTable((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return HeadLocalServiceUtil.updateInterfaceTableWithContent((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], ((Long)arguments[3]).longValue());
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
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName205;
	private String[] _methodParameterTypes205;
	private String _methodName206;
	private String[] _methodParameterTypes206;
	private String _methodName207;
	private String[] _methodParameterTypes207;
	private String _methodName208;
	private String[] _methodParameterTypes208;
	private String _methodName209;
	private String[] _methodParameterTypes209;
	private String _methodName210;
	private String[] _methodParameterTypes210;
	private String _methodName211;
	private String[] _methodParameterTypes211;
	private String _methodName212;
	private String[] _methodParameterTypes212;
	private String _methodName213;
	private String[] _methodParameterTypes213;
	private String _methodName214;
	private String[] _methodParameterTypes214;
	private String _methodName215;
	private String[] _methodParameterTypes215;
}