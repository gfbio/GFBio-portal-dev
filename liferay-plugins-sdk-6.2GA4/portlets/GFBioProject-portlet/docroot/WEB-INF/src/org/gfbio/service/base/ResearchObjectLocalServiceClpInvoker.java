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

		_methodName132 = "getBeanIdentifier";

		_methodParameterTypes132 = new String[] {  };

		_methodName133 = "setBeanIdentifier";

		_methodParameterTypes133 = new String[] { "java.lang.String" };

		_methodName138 = "getResearchObjectAsJsonById";

		_methodParameterTypes138 = new String[] { "org.json.simple.JSONArray" };

		_methodName139 = "getResearchObjectASJsonById";

		_methodParameterTypes139 = new String[] { "org.json.simple.JSONObject" };

		_methodName140 = "getResearchObjectAbsolutParent";

		_methodParameterTypes140 = new String[] { "org.json.simple.JSONObject" };

		_methodName141 = "getResearchObjectsByParent";

		_methodParameterTypes141 = new String[] { "org.json.simple.JSONObject" };

		_methodName142 = "getResearchObjectParent";

		_methodParameterTypes142 = new String[] { "org.json.simple.JSONObject" };

		_methodName143 = "getAllChildren";

		_methodParameterTypes143 = new String[] { "long" };

		_methodName144 = "getDirectChildren";

		_methodParameterTypes144 = new String[] { "long" };

		_methodName145 = "getDirectParent";

		_methodParameterTypes145 = new String[] { "long" };

		_methodName146 = "getLatestResearchObjectById";

		_methodParameterTypes146 = new String[] { "long" };

		_methodName147 = "getLatestVersionById";

		_methodParameterTypes147 = new String[] { "long" };

		_methodName148 = "getProjectIdByIds";

		_methodParameterTypes148 = new String[] { "long", "int" };

		_methodName149 = "getResearchObjectById";

		_methodParameterTypes149 = new String[] { "long" };

		_methodName150 = "getTopParent";

		_methodParameterTypes150 = new String[] { "long" };

		_methodName151 = "checkForIgnoredParameter";

		_methodParameterTypes151 = new String[] {
				"java.lang.Object[][]", "java.util.Set"
			};

		_methodName152 = "checkHCCBackground";

		_methodParameterTypes152 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName153 = "checkNullParent";

		_methodParameterTypes153 = new String[] { "org.json.simple.JSONObject" };

		_methodName154 = "checkParentAttributById";

		_methodParameterTypes154 = new String[] { "long" };

		_methodName155 = "checkResearchObjectId";

		_methodParameterTypes155 = new String[] { "long" };

		_methodName156 = "checkResearchObjectIdAndVersion";

		_methodParameterTypes156 = new String[] { "long", "int" };

		_methodName157 = "constructResearchObjectJson";

		_methodParameterTypes157 = new String[] { "org.gfbio.model.ResearchObject" };

		_methodName158 = "constructResearchObjectsJson";

		_methodParameterTypes158 = new String[] { "java.util.List" };

		_methodName159 = "createResearchObjectByJson";

		_methodParameterTypes159 = new String[] { "org.json.simple.JSONArray" };

		_methodName160 = "createResearchObjectByJson";

		_methodParameterTypes160 = new String[] { "org.json.simple.JSONObject" };

		_methodName161 = "updateResearchObjectByJson";

		_methodParameterTypes161 = new String[] { "org.json.simple.JSONArray" };

		_methodName162 = "updateResearchObjectByJson";

		_methodParameterTypes162 = new String[] { "org.json.simple.JSONObject" };

		_methodName163 = "createResearchObject";

		_methodParameterTypes163 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName164 = "updateKernelResearchObject";

		_methodParameterTypes164 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName165 = "updateResearchObjectWithProject";

		_methodParameterTypes165 = new String[] {
				"long", "long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName166 = "updateAuthorIds";

		_methodParameterTypes166 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName167 = "updateAuthorId";

		_methodParameterTypes167 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName168 = "updateAuthorId";

		_methodParameterTypes168 = new String[] { "long", "int", "long" };

		_methodName169 = "updateDescription";

		_methodParameterTypes169 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName170 = "updateLicenseId";

		_methodParameterTypes170 = new String[] { "long", "java.lang.String" };

		_methodName171 = "updateLicenseId";

		_methodParameterTypes171 = new String[] { "long", "long" };

		_methodName172 = "updateLicenseIds";

		_methodParameterTypes172 = new String[] {
				"long", "org.json.simple.JSONArray"
			};

		_methodName173 = "updateMetadataId";

		_methodParameterTypes173 = new String[] { "long", "int", "long" };

		_methodName174 = "updateParentResearchObjectIdByIds";

		_methodParameterTypes174 = new String[] { "long", "int", "long" };

		_methodName175 = "updateResearchObjectType";

		_methodParameterTypes175 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName176 = "updateResearchObjectVersion";

		_methodParameterTypes176 = new String[] { "long", "int" };
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

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			ResearchObjectLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectASJsonById((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectAbsolutParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectsByParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getAllChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getDirectChildren(((Long)arguments[0]).longValue());
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getDirectParent(((Long)arguments[0]).longValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getLatestResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getLatestVersionById(((Long)arguments[0]).longValue());
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getProjectIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getResearchObjectById(((Long)arguments[0]).longValue());
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.getTopParent(((Long)arguments[0]).longValue());
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkForIgnoredParameter((java.lang.Object[])arguments[0],
				(java.util.Set<java.lang.String>)arguments[1]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkHCCBackground((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkNullParent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkParentAttributById(((Long)arguments[0]).longValue());
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructResearchObjectJson((org.gfbio.model.ResearchObject)arguments[0]);
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.constructResearchObjectsJson((java.util.List<org.gfbio.model.ResearchObject>)arguments[0]);
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObjectByJson((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObjectByJson((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectByJson((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectByJson((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.createResearchObject((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateKernelResearchObject(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectWithProject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6]);
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateAuthorIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateAuthorId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateAuthorId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateDescription(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateLicenseId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateLicenseId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateLicenseIds(((Long)arguments[0]).longValue(),
				(org.json.simple.JSONArray)arguments[1]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateMetadataId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return ResearchObjectLocalServiceUtil.updateResearchObjectType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
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
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
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
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName154;
	private String[] _methodParameterTypes154;
	private String _methodName155;
	private String[] _methodParameterTypes155;
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
	private String _methodName160;
	private String[] _methodParameterTypes160;
	private String _methodName161;
	private String[] _methodParameterTypes161;
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName164;
	private String[] _methodParameterTypes164;
	private String _methodName165;
	private String[] _methodParameterTypes165;
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
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
}