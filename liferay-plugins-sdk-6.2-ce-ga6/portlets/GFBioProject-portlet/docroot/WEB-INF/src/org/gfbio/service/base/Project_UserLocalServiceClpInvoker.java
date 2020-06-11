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

import org.gfbio.service.Project_UserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class Project_UserLocalServiceClpInvoker {
	public Project_UserLocalServiceClpInvoker() {
		_methodName0 = "addProject_User";

		_methodParameterTypes0 = new String[] { "org.gfbio.model.Project_User" };

		_methodName1 = "createProject_User";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.Project_UserPK"
			};

		_methodName2 = "deleteProject_User";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.Project_UserPK"
			};

		_methodName3 = "deleteProject_User";

		_methodParameterTypes3 = new String[] { "org.gfbio.model.Project_User" };

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

		_methodName10 = "fetchProject_User";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.Project_UserPK"
			};

		_methodName11 = "getProject_User";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.Project_UserPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getProject_Users";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getProject_UsersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateProject_User";

		_methodParameterTypes15 = new String[] { "org.gfbio.model.Project_User" };

		_methodName176 = "getBeanIdentifier";

		_methodParameterTypes176 = new String[] {  };

		_methodName177 = "setBeanIdentifier";

		_methodParameterTypes177 = new String[] { "java.lang.String" };

		_methodName182 = "getProjectIdsByUserId";

		_methodParameterTypes182 = new String[] { "org.json.simple.JSONObject" };

		_methodName183 = "getFullNamesAsString";

		_methodParameterTypes183 = new String[] { "org.json.simple.JSONArray" };

		_methodName184 = "getOwnerAndPiByProjectId";

		_methodParameterTypes184 = new String[] { "long" };

		_methodName185 = "getOwnerAndPiIdByProjectId";

		_methodParameterTypes185 = new String[] { "long" };

		_methodName186 = "getProjectIdList";

		_methodParameterTypes186 = new String[] { "long" };

		_methodName188 = "updateProjectUser";

		_methodParameterTypes188 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName189 = "updateProjectUser";

		_methodParameterTypes189 = new String[] {
				"long", "long", "java.util.Date", "java.util.Date",
				"java.lang.String"
			};

		_methodName190 = "getProjectIDList";

		_methodParameterTypes190 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return Project_UserLocalServiceUtil.addProject_User((org.gfbio.model.Project_User)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return Project_UserLocalServiceUtil.createProject_User((org.gfbio.service.persistence.Project_UserPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return Project_UserLocalServiceUtil.deleteProject_User((org.gfbio.service.persistence.Project_UserPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return Project_UserLocalServiceUtil.deleteProject_User((org.gfbio.model.Project_User)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return Project_UserLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return Project_UserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return Project_UserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return Project_UserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return Project_UserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return Project_UserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return Project_UserLocalServiceUtil.fetchProject_User((org.gfbio.service.persistence.Project_UserPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return Project_UserLocalServiceUtil.getProject_User((org.gfbio.service.persistence.Project_UserPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return Project_UserLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return Project_UserLocalServiceUtil.getProject_Users(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return Project_UserLocalServiceUtil.getProject_UsersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return Project_UserLocalServiceUtil.updateProject_User((org.gfbio.model.Project_User)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return Project_UserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			Project_UserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return Project_UserLocalServiceUtil.getProjectIdsByUserId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return Project_UserLocalServiceUtil.getFullNamesAsString((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return Project_UserLocalServiceUtil.getOwnerAndPiByProjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return Project_UserLocalServiceUtil.getOwnerAndPiIdByProjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return Project_UserLocalServiceUtil.getProjectIdList(((Long)arguments[0]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return Project_UserLocalServiceUtil.updateProjectUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return Project_UserLocalServiceUtil.updateProjectUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return Project_UserLocalServiceUtil.getProjectIDList(((Long)arguments[0]).longValue());
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
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
}