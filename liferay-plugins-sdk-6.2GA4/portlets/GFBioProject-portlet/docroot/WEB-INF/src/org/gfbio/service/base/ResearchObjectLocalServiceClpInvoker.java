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

import org.gfbio.service.ResearchObjectLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ResearchObjectLocalServiceClpInvoker {
	public ResearchObjectLocalServiceClpInvoker() {
		_methodName0 = "addResearchObject";

		_methodParameterTypes0 = new String[] { "org.gfbio.model.ResearchObject" };

		_methodName1 = "createResearchObject";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.ResearchObjectPK"
			};

		_methodName2 = "deleteResearchObject";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.ResearchObjectPK"
			};

		_methodName3 = "deleteResearchObject";

		_methodParameterTypes3 = new String[] { "org.gfbio.model.ResearchObject" };

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

		_methodName10 = "fetchResearchObject";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.ResearchObjectPK"
			};

		_methodName11 = "getResearchObject";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.ResearchObjectPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getResearchObjects";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getResearchObjectsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateResearchObject";

		_methodParameterTypes15 = new String[] { "org.gfbio.model.ResearchObject" };

		_methodName116 = "getBeanIdentifier";

		_methodParameterTypes116 = new String[] {  };

		_methodName117 = "setBeanIdentifier";

		_methodParameterTypes117 = new String[] { "java.lang.String" };

		_methodName122 = "getResearchObjectAsJsonById";

		_methodParameterTypes122 = new String[] { "org.json.simple.JSONArray" };

		_methodName123 = "getResearchObjectASJsonById";

		_methodParameterTypes123 = new String[] { "org.json.simple.JSONObject" };

		_methodName124 = "getResearchObjectAbsolutParent";

		_methodParameterTypes124 = new String[] { "org.json.simple.JSONObject" };

		_methodName125 = "getResearchObjectsByParent";

		_methodParameterTypes125 = new String[] { "org.json.simple.JSONObject" };

		_methodName126 = "getResearchObjectParent";

		_methodParameterTypes126 = new String[] { "org.json.simple.JSONObject" };

		_methodName127 = "getAllChildren";

		_methodParameterTypes127 = new String[] { "long" };

		_methodName128 = "getDirectChildren";

		_methodParameterTypes128 = new String[] { "long" };

		_methodName129 = "getDirectParent";

		_methodParameterTypes129 = new String[] { "long" };

		_methodName130 = "getLatestResearchObjectById";

		_methodParameterTypes130 = new String[] { "long" };

		_methodName131 = "getLatestVersionById";

		_methodParameterTypes131 = new String[] { "long" };

		_methodName132 = "getProjectIdByIds";

		_methodParameterTypes132 = new String[] { "long", "int" };

		_methodName133 = "getResearchObjectById";

		_methodParameterTypes133 = new String[] { "long" };

		_methodName134 = "getTopParent";

		_methodParameterTypes134 = new String[] { "long" };

		_methodName135 = "checkForIgnoredParameter";

		_methodParameterTypes135 = new String[] {
				"java.lang.Object[][]", "java.util.Set"
			};

		_methodName136 = "checkParentAttributById";

		_methodParameterTypes136 = new String[] { "long" };

		_methodName137 = "checkNullParent";

		_methodParameterTypes137 = new String[] { "org.json.simple.JSONObject" };

		_methodName138 = "checkResearchObjectId";

		_methodParameterTypes138 = new String[] { "long" };

		_methodName139 = "constructResearchObjectJson";

		_methodParameterTypes139 = new String[] { "org.gfbio.model.ResearchObject" };

		_methodName140 = "constructResearchObjectsJson";

		_methodParameterTypes140 = new String[] { "java.util.List" };

		_methodName141 = "createResearchObjectByJson";

		_methodParameterTypes141 = new String[] { "org.json.simple.JSONArray" };

		_methodName142 = "createResearchObjectByJson";

		_methodParameterTypes142 = new String[] { "org.json.simple.JSONObject" };

		_methodName143 = "updateResearchObjectByJson";

		_methodParameterTypes143 = new String[] { "org.json.simple.JSONArray" };

		_methodName144 = "updateResearchObjectByJson";

		_methodParameterTypes144 = new String[] { "org.json.simple.JSONObject" };

		_methodName145 = "createResearchObject";

		_methodParameterTypes145 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName146 = "updateResearchObject";

		_methodParameterTypes146 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName147 = "updateResearchObjectWithProject";

		_methodParameterTypes147 = new String[] {
				"long", "long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName148 = "updateParentResearchObjectIdByIds";

		_methodParameterTypes148 = new String[] { "long", "int", "long" };

		_methodName149 = "updateResearchObjectType";

		_methodParameterTypes149 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName150 = "updateResearchObjectVersion";

		_methodParameterTypes150 = new String[] { "long", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.addResearchObject((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObject((org.gfbio.service.persistence.ResearchObjectPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.deleteResearchObject((org.gfbio.service.persistence.ResearchObjectPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.deleteResearchObject((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.fetchResearchObject((org.gfbio.service.persistence.ResearchObjectPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObject((org.gfbio.service.persistence.ResearchObjectPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjects(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObject((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			ResearchObjectLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectASJsonById((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectAbsolutParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsByParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getAllChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getDirectChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getDirectParent(((Long)arguments[0]).longValue());
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getLatestResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getLatestVersionById(((Long)arguments[0]).longValue());
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getProjectIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getTopParent(((Long)arguments[0]).longValue());
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkForIgnoredParameter((java.lang.Object[])arguments[0],
				(java.util.Set<java.lang.String>)arguments[1]);
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkParentAttributById(((Long)arguments[0]).longValue());
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkNullParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructResearchObjectJson((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructResearchObjectsJson((java.util.List<org.gfbio.model.ResearchObject>)arguments[0]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObjectByJson((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObjectByJson((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectByJson((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectByJson((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObject((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObject(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectWithProject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6]);
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
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
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
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
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
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
}