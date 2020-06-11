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

import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class PrimaryData_ResearchObjectLocalServiceClpInvoker {
	public PrimaryData_ResearchObjectLocalServiceClpInvoker() {
		_methodName0 = "addPrimaryData_ResearchObject";

		_methodParameterTypes0 = new String[] {
				"org.gfbio.model.PrimaryData_ResearchObject"
			};

		_methodName1 = "createPrimaryData_ResearchObject";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.PrimaryData_ResearchObjectPK"
			};

		_methodName2 = "deletePrimaryData_ResearchObject";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.PrimaryData_ResearchObjectPK"
			};

		_methodName3 = "deletePrimaryData_ResearchObject";

		_methodParameterTypes3 = new String[] {
				"org.gfbio.model.PrimaryData_ResearchObject"
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

		_methodName10 = "fetchPrimaryData_ResearchObject";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.PrimaryData_ResearchObjectPK"
			};

		_methodName11 = "getPrimaryData_ResearchObject";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.PrimaryData_ResearchObjectPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getPrimaryData_ResearchObjects";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getPrimaryData_ResearchObjectsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updatePrimaryData_ResearchObject";

		_methodParameterTypes15 = new String[] {
				"org.gfbio.model.PrimaryData_ResearchObject"
			};

		_methodName176 = "getBeanIdentifier";

		_methodParameterTypes176 = new String[] {  };

		_methodName177 = "setBeanIdentifier";

		_methodParameterTypes177 = new String[] { "java.lang.String" };

		_methodName182 = "deletePrimaryDataResearchObject";

		_methodParameterTypes182 = new String[] { "org.json.simple.JSONObject" };

		_methodName187 = "getPrimaryDatasIdsByResearchObject";

		_methodParameterTypes187 = new String[] { "org.json.simple.JSONObject" };

		_methodName188 = "getResearchObjectsByPrimaryDataId";

		_methodParameterTypes188 = new String[] { "org.json.simple.JSONObject" };

		_methodName189 = "getPrimaryDataIdsByResearchObjectId";

		_methodParameterTypes189 = new String[] { "long" };

		_methodName190 = "getPrimaryDataIdsByResearchObjectIdAndVersion";

		_methodParameterTypes190 = new String[] { "long", "int" };

		_methodName192 = "checkPrimaryDataId";

		_methodParameterTypes192 = new String[] { "long" };

		_methodName193 = "checkResearchObjectIdAndVersion";

		_methodParameterTypes193 = new String[] { "long", "int" };

		_methodName194 = "checkResearchObjectId";

		_methodParameterTypes194 = new String[] { "long" };

		_methodName195 = "updatePrimaryDataResearchObject";

		_methodParameterTypes195 = new String[] { "long", "long" };

		_methodName196 = "updatePrimaryDataResearchObject";

		_methodParameterTypes196 = new String[] { "long", "long", "int" };

		_methodName197 = "updateResearchObjectVersion";

		_methodParameterTypes197 = new String[] { "long", "long", "int", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.addPrimaryData_ResearchObject((org.gfbio.model.PrimaryData_ResearchObject)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.createPrimaryData_ResearchObject((org.gfbio.service.persistence.PrimaryData_ResearchObjectPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryData_ResearchObject((org.gfbio.service.persistence.PrimaryData_ResearchObjectPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryData_ResearchObject((org.gfbio.model.PrimaryData_ResearchObject)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.fetchPrimaryData_ResearchObject((org.gfbio.service.persistence.PrimaryData_ResearchObjectPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryData_ResearchObject((org.gfbio.service.persistence.PrimaryData_ResearchObjectPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryData_ResearchObjects(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryData_ResearchObjectsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryData_ResearchObject((org.gfbio.model.PrimaryData_ResearchObject)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			PrimaryData_ResearchObjectLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryDataResearchObject((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDatasIdsByResearchObject((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getResearchObjectsByPrimaryDataId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDataIdsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDataIdsByResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.checkPrimaryDataId(((Long)arguments[0]).longValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.checkResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryDataResearchObject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryDataResearchObject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return PrimaryData_ResearchObjectLocalServiceUtil.updateResearchObjectVersion(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
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
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
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
}