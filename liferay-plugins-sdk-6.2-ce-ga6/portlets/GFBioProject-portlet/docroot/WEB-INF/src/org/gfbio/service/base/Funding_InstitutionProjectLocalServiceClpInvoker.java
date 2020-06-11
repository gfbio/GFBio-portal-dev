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

import org.gfbio.service.Funding_InstitutionProjectLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class Funding_InstitutionProjectLocalServiceClpInvoker {
	public Funding_InstitutionProjectLocalServiceClpInvoker() {
		_methodName0 = "addFunding_InstitutionProject";

		_methodParameterTypes0 = new String[] {
				"org.gfbio.model.Funding_InstitutionProject"
			};

		_methodName1 = "createFunding_InstitutionProject";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.Funding_InstitutionProjectPK"
			};

		_methodName2 = "deleteFunding_InstitutionProject";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.Funding_InstitutionProjectPK"
			};

		_methodName3 = "deleteFunding_InstitutionProject";

		_methodParameterTypes3 = new String[] {
				"org.gfbio.model.Funding_InstitutionProject"
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

		_methodName10 = "fetchFunding_InstitutionProject";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.Funding_InstitutionProjectPK"
			};

		_methodName11 = "getFunding_InstitutionProject";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.Funding_InstitutionProjectPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getFunding_InstitutionProjects";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getFunding_InstitutionProjectsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateFunding_InstitutionProject";

		_methodParameterTypes15 = new String[] {
				"org.gfbio.model.Funding_InstitutionProject"
			};

		_methodName176 = "getBeanIdentifier";

		_methodParameterTypes176 = new String[] {  };

		_methodName177 = "setBeanIdentifier";

		_methodParameterTypes177 = new String[] { "java.lang.String" };

		_methodName182 = "checkForIgnoredParameter";

		_methodParameterTypes182 = new String[] {
				"java.lang.Object[][]", "java.util.Set"
			};

		_methodName183 = "createFundingInstitutionProject";

		_methodParameterTypes183 = new String[] { "org.json.simple.JSONObject" };

		_methodName184 = "saveUpdateFundingInstitutionProject";

		_methodParameterTypes184 = new String[] { "long", "long", "long", "long" };

		_methodName185 = "updateFundingInstitutionProject";

		_methodParameterTypes185 = new String[] { "long", "long", "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.addFunding_InstitutionProject((org.gfbio.model.Funding_InstitutionProject)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.createFunding_InstitutionProject((org.gfbio.service.persistence.Funding_InstitutionProjectPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.deleteFunding_InstitutionProject((org.gfbio.service.persistence.Funding_InstitutionProjectPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.deleteFunding_InstitutionProject((org.gfbio.model.Funding_InstitutionProject)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.fetchFunding_InstitutionProject((org.gfbio.service.persistence.Funding_InstitutionProjectPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.getFunding_InstitutionProject((org.gfbio.service.persistence.Funding_InstitutionProjectPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.getFunding_InstitutionProjects(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.getFunding_InstitutionProjectsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.updateFunding_InstitutionProject((org.gfbio.model.Funding_InstitutionProject)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			Funding_InstitutionProjectLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.checkForIgnoredParameter((java.lang.Object[])arguments[0],
				(java.util.Set<java.lang.String>)arguments[1]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.createFundingInstitutionProject((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.saveUpdateFundingInstitutionProject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return Funding_InstitutionProjectLocalServiceUtil.updateFundingInstitutionProject(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
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
}