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

		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "deleteTableByHeadId";

		_methodParameterTypes168 = new String[] { "long" };

		_methodName169 = "deleteTableByHeadIdWithoutCheck";

		_methodParameterTypes169 = new String[] { "long" };

		_methodName170 = "getTableNamesByTableType";

		_methodParameterTypes170 = new String[] { "org.json.simple.JSONObject" };

		_methodName171 = "getArrayOfTableNames";

		_methodParameterTypes171 = new String[] { "java.lang.String" };

		_methodName172 = "getCountOfColumns";

		_methodParameterTypes172 = new String[] { "long" };

		_methodName173 = "getEntitiesByHeadId";

		_methodParameterTypes173 = new String[] { "long" };

		_methodName174 = "getHeadIdByTableName";

		_methodParameterTypes174 = new String[] { "java.lang.String" };

		_methodName175 = "getHeadsByTableType";

		_methodParameterTypes175 = new String[] { "java.lang.String" };

		_methodName176 = "getIdTableAsArray";

		_methodParameterTypes176 = new String[] { "long" };

		_methodName178 = "getTableAsArray";

		_methodParameterTypes178 = new String[] { "long" };

		_methodName179 = "getTableAsJSONArrayByName";

		_methodParameterTypes179 = new String[] { "org.json.simple.JSONObject" };

		_methodName180 = "getTableAsJSONArray";

		_methodParameterTypes180 = new String[] { "long" };

		_methodName181 = "getTableNameArray";

		_methodParameterTypes181 = new String[] { "java.lang.String" };

		_methodName182 = "getTableNameArray";

		_methodParameterTypes182 = new String[] { "java.util.List" };

		_methodName183 = "getTableNameById";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "getTableNamesByTableType";

		_methodParameterTypes184 = new String[] { "java.lang.String" };

		_methodName185 = "constructHeadJson";

		_methodParameterTypes185 = new String[] { "org.gfbio.model.Head" };

		_methodName186 = "constructHeadJson";

		_methodParameterTypes186 = new String[] {
				"long", "java.lang.String", "java.lang.String", "java.util.Date"
			};

		_methodName187 = "constructRelationName";

		_methodParameterTypes187 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName188 = "constructNewId";

		_methodParameterTypes188 = new String[] {  };

		_methodName189 = "updateHead";

		_methodParameterTypes189 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName190 = "updateHead";

		_methodParameterTypes190 = new String[] { "org.json.simple.JSONObject" };

		_methodName191 = "updateHeadWithLongRequest";

		_methodParameterTypes191 = new String[] { "org.json.simple.JSONObject" };

		_methodName192 = "updateHeadWithLongRequest";

		_methodParameterTypes192 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName193 = "updateHeadWithColumns";

		_methodParameterTypes193 = new String[] { "org.json.simple.JSONObject" };

		_methodName194 = "updateHeadWithColumns2";

		_methodParameterTypes194 = new String[] { "org.json.simple.JSONObject" };

		_methodName195 = "updateParentRelationTable";

		_methodParameterTypes195 = new String[] { "long", "java.lang.String" };

		_methodName196 = "updateParentRelationTableWithContent";

		_methodParameterTypes196 = new String[] { "long", "long", "long" };

		_methodName197 = "updateRelationTable";

		_methodParameterTypes197 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName198 = "updateRelationTableWithContent";

		_methodParameterTypes198 = new String[] { "long", "long", "long", "long" };

		_methodName199 = "updateTable";

		_methodParameterTypes199 = new String[] { "org.json.simple.JSONObject" };

		_methodName200 = "updateInterfaceTableWithContent";

		_methodParameterTypes200 = new String[] {
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

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return HeadLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			HeadLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			HeadLocalServiceUtil.deleteTableByHeadId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			HeadLocalServiceUtil.deleteTableByHeadIdWithoutCheck(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNamesByTableType((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return HeadLocalServiceUtil.getArrayOfTableNames((java.lang.String)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return HeadLocalServiceUtil.getCountOfColumns(((Long)arguments[0]).longValue());
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return HeadLocalServiceUtil.getEntitiesByHeadId(((Long)arguments[0]).longValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return HeadLocalServiceUtil.getHeadIdByTableName((java.lang.String)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return HeadLocalServiceUtil.getHeadsByTableType((java.lang.String)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return HeadLocalServiceUtil.getIdTableAsArray(((Long)arguments[0]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return HeadLocalServiceUtil.getTableAsArray(((Long)arguments[0]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return HeadLocalServiceUtil.getTableAsJSONArrayByName((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return HeadLocalServiceUtil.getTableAsJSONArray(((Long)arguments[0]).longValue());
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNameArray((java.lang.String)arguments[0]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNameArray((java.util.List<org.gfbio.model.Head>)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNameById(((Long)arguments[0]).longValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return HeadLocalServiceUtil.getTableNamesByTableType((java.lang.String)arguments[0]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return HeadLocalServiceUtil.constructHeadJson((org.gfbio.model.Head)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return HeadLocalServiceUtil.constructHeadJson(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.util.Date)arguments[3]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return HeadLocalServiceUtil.constructRelationName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return HeadLocalServiceUtil.constructNewId();
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return HeadLocalServiceUtil.updateHead(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return HeadLocalServiceUtil.updateHead((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithLongRequest((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithLongRequest(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithColumns((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return HeadLocalServiceUtil.updateHeadWithColumns2((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return HeadLocalServiceUtil.updateParentRelationTable(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return HeadLocalServiceUtil.updateParentRelationTableWithContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return HeadLocalServiceUtil.updateRelationTable(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return HeadLocalServiceUtil.updateRelationTableWithContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return HeadLocalServiceUtil.updateTable((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
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
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
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
	private String _methodName192;
	private String[] _methodParameterTypes192;
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
}