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

		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "deleteSubmission";

		_methodParameterTypes168 = new String[] { "org.json.simple.JSONObject" };

		_methodName170 = "getAllUserIdsByResearchObject";

		_methodParameterTypes170 = new String[] { "org.json.simple.JSONObject" };

		_methodName171 = "getResearchObjectsAsJsonById";

		_methodParameterTypes171 = new String[] { "org.json.simple.JSONArray" };

		_methodName172 = "getResearchObjectAsJsonById";

		_methodParameterTypes172 = new String[] { "org.json.simple.JSONObject" };

		_methodName173 = "getResearchObjectAbsolutParent";

		_methodParameterTypes173 = new String[] { "org.json.simple.JSONObject" };

		_methodName174 = "getResearchObjectInformationByUserId";

		_methodParameterTypes174 = new String[] { "org.json.simple.JSONObject" };

		_methodName175 = "getResearchObjectsByProjectId";

		_methodParameterTypes175 = new String[] { "long" };

		_methodName176 = "getResearchObjectsByUserId";

		_methodParameterTypes176 = new String[] { "long" };

		_methodName177 = "getResearchObjectsByParent";

		_methodParameterTypes177 = new String[] { "org.json.simple.JSONObject" };

		_methodName178 = "getResearchObjectParent";

		_methodParameterTypes178 = new String[] { "org.json.simple.JSONObject" };

		_methodName179 = "getResearchObjectInformationByUserId";

		_methodParameterTypes179 = new String[] { "long" };

		_methodName180 = "getAllChildren";

		_methodParameterTypes180 = new String[] { "long" };

		_methodName181 = "getDirectChildren";

		_methodParameterTypes181 = new String[] { "long" };

		_methodName182 = "getDirectParent";

		_methodParameterTypes182 = new String[] { "long" };

		_methodName183 = "getLatestResearchObjectById";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "getLatestVersionById";

		_methodParameterTypes184 = new String[] { "long" };

		_methodName186 = "getProjectIdByIds";

		_methodParameterTypes186 = new String[] { "long", "int" };

		_methodName187 = "getResearchObjectById";

		_methodParameterTypes187 = new String[] { "long" };

		_methodName188 = "getResearchObjectVersionsById";

		_methodParameterTypes188 = new String[] { "long" };

		_methodName189 = "getResearchObjectVersionFromJson";

		_methodParameterTypes189 = new String[] { "org.json.simple.JSONObject" };

		_methodName190 = "getTopParent";

		_methodParameterTypes190 = new String[] { "long" };

		_methodName191 = "getUserIdsByIds";

		_methodParameterTypes191 = new String[] { "long", "int" };

		_methodName192 = "checkForIgnoredParameter";

		_methodParameterTypes192 = new String[] {
				"java.lang.Object[][]", "java.util.Set"
			};

		_methodName193 = "checkHCCBackground";

		_methodParameterTypes193 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName194 = "checkNullParent";

		_methodParameterTypes194 = new String[] { "org.json.simple.JSONObject" };

		_methodName195 = "checkParentAttributById";

		_methodParameterTypes195 = new String[] { "long" };

		_methodName196 = "checkResearchObjectId";

		_methodParameterTypes196 = new String[] { "long" };

		_methodName197 = "checkResearchObjectIdAndVersion";

		_methodParameterTypes197 = new String[] { "long", "int" };

		_methodName198 = "constructNewId";

		_methodParameterTypes198 = new String[] {  };

		_methodName199 = "constructResearchObjectJson";

		_methodParameterTypes199 = new String[] { "org.gfbio.model.ResearchObject" };

		_methodName200 = "constructExtendedResearchObjectJson";

		_methodParameterTypes200 = new String[] { "org.gfbio.model.ResearchObject" };

		_methodName201 = "constructResearchObjectsJson";

		_methodParameterTypes201 = new String[] { "java.util.List" };

		_methodName202 = "createResearchObjectByJson";

		_methodParameterTypes202 = new String[] { "org.json.simple.JSONArray" };

		_methodName203 = "createResearchObjectByJson";

		_methodParameterTypes203 = new String[] { "org.json.simple.JSONObject" };

		_methodName204 = "updateResearchObjectByJson";

		_methodParameterTypes204 = new String[] { "org.json.simple.JSONArray" };

		_methodName206 = "updateResearchObjectByJson";

		_methodParameterTypes206 = new String[] { "org.json.simple.JSONObject" };
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

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			ResearchObjectLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.deleteSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getAllUserIdsByResearchObject((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsAsJsonById((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectAbsolutParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsByProjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsByParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectInformationByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getAllChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getDirectChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getDirectParent(((Long)arguments[0]).longValue());
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getLatestResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getLatestVersionById(((Long)arguments[0]).longValue());
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getProjectIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectVersionsById(((Long)arguments[0]).longValue());
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectVersionFromJson((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getTopParent(((Long)arguments[0]).longValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getUserIdsByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkForIgnoredParameter((java.lang.Object[])arguments[0],
				(java.util.Set<java.lang.String>)arguments[1]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkHCCBackground((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkNullParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkParentAttributById(((Long)arguments[0]).longValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructNewId();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructResearchObjectJson((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructExtendedResearchObjectJson((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructResearchObjectsJson((java.util.List<org.gfbio.model.ResearchObject>)arguments[0]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObjectByJson((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObjectByJson((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectByJson((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectByJson((org.json.simple.JSONObject)arguments[0]);
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
	private String _methodName177;
	private String[] _methodParameterTypes177;
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
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName206;
	private String[] _methodParameterTypes206;
}