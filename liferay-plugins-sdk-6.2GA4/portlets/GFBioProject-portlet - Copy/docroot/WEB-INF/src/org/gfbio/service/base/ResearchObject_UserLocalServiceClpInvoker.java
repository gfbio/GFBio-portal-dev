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

import org.gfbio.service.ResearchObject_UserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ResearchObject_UserLocalServiceClpInvoker {
	public ResearchObject_UserLocalServiceClpInvoker() {
		_methodName0 = "addResearchObject_User";

		_methodParameterTypes0 = new String[] {
				"org.gfbio.model.ResearchObject_User"
			};

		_methodName1 = "createResearchObject_User";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.ResearchObject_UserPK"
			};

		_methodName2 = "deleteResearchObject_User";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.ResearchObject_UserPK"
			};

		_methodName3 = "deleteResearchObject_User";

		_methodParameterTypes3 = new String[] {
				"org.gfbio.model.ResearchObject_User"
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

		_methodName10 = "fetchResearchObject_User";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.ResearchObject_UserPK"
			};

		_methodName11 = "getResearchObject_User";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.ResearchObject_UserPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getResearchObject_Users";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getResearchObject_UsersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateResearchObject_User";

		_methodParameterTypes15 = new String[] {
				"org.gfbio.model.ResearchObject_User"
			};

		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "getUserIdsByResearchObject";

		_methodParameterTypes168 = new String[] { "org.json.simple.JSONObject" };

		_methodName169 = "getFullNamesAsString";

		_methodParameterTypes169 = new String[] { "org.json.simple.JSONArray" };

		_methodName170 = "getOwnerAndPiByResearchObjectId";

		_methodParameterTypes170 = new String[] { "long" };

		_methodName171 = "getOwnerIdsByResearchObjectIds";

		_methodParameterTypes171 = new String[] { "long" };

		_methodName172 = "getOwnerIdsByResearchObjectIds";

		_methodParameterTypes172 = new String[] { "long", "int" };

		_methodName174 = "getResearchObjectsByUserId";

		_methodParameterTypes174 = new String[] { "long" };

		_methodName175 = "getResearchObjectIdList";

		_methodParameterTypes175 = new String[] { "long" };

		_methodName176 = "checkResearchObjectIdAndVersion";

		_methodParameterTypes176 = new String[] { "long", "int" };

		_methodName177 = "updateResearchObjectUser";

		_methodParameterTypes177 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName178 = "updateResearchObjectUser";

		_methodParameterTypes178 = new String[] {
				"long", "int", "long", "java.lang.String"
			};

		_methodName179 = "updateResearchObjectUser";

		_methodParameterTypes179 = new String[] {
				"long", "int", "long", "java.util.Date", "java.util.Date",
				"java.lang.String"
			};

		_methodName180 = "updateResearchObjectVersion";

		_methodParameterTypes180 = new String[] { "long", "long", "int", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.addResearchObject_User((org.gfbio.model.ResearchObject_User)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.createResearchObject_User((org.gfbio.service.persistence.ResearchObject_UserPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.deleteResearchObject_User((org.gfbio.service.persistence.ResearchObject_UserPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.deleteResearchObject_User((org.gfbio.model.ResearchObject_User)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.fetchResearchObject_User((org.gfbio.service.persistence.ResearchObject_UserPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getResearchObject_User((org.gfbio.service.persistence.ResearchObject_UserPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getResearchObject_Users(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getResearchObject_UsersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.updateResearchObject_User((org.gfbio.model.ResearchObject_User)arguments[0]);
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			ResearchObject_UserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getUserIdsByResearchObject((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getFullNamesAsString((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getOwnerAndPiByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getOwnerIdsByResearchObjectIds(((Long)arguments[0]).longValue());
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getOwnerIdsByResearchObjectIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getResearchObjectsByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.getResearchObjectIdList(((Long)arguments[0]).longValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.checkResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.updateResearchObjectUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.updateResearchObjectUser(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.updateResearchObjectUser(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				(java.util.Date)arguments[4], (java.lang.String)arguments[5]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ResearchObject_UserLocalServiceUtil.updateResearchObjectVersion(((Long)arguments[0]).longValue(),
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
}