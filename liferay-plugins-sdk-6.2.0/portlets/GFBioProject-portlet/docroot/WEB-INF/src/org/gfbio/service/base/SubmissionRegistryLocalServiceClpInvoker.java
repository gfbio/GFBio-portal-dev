/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import org.gfbio.service.SubmissionRegistryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class SubmissionRegistryLocalServiceClpInvoker {
	public SubmissionRegistryLocalServiceClpInvoker() {
		_methodName0 = "addSubmissionRegistry";

		_methodParameterTypes0 = new String[] {
				"org.gfbio.model.SubmissionRegistry"
			};

		_methodName1 = "createSubmissionRegistry";

		_methodParameterTypes1 = new String[] {
				"org.gfbio.service.persistence.SubmissionRegistryPK"
			};

		_methodName2 = "deleteSubmissionRegistry";

		_methodParameterTypes2 = new String[] {
				"org.gfbio.service.persistence.SubmissionRegistryPK"
			};

		_methodName3 = "deleteSubmissionRegistry";

		_methodParameterTypes3 = new String[] {
				"org.gfbio.model.SubmissionRegistry"
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

		_methodName10 = "fetchSubmissionRegistry";

		_methodParameterTypes10 = new String[] {
				"org.gfbio.service.persistence.SubmissionRegistryPK"
			};

		_methodName11 = "getSubmissionRegistry";

		_methodParameterTypes11 = new String[] {
				"org.gfbio.service.persistence.SubmissionRegistryPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSubmissionRegistries";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSubmissionRegistriesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSubmissionRegistry";

		_methodParameterTypes15 = new String[] {
				"org.gfbio.model.SubmissionRegistry"
			};

		_methodName120 = "getBeanIdentifier";

		_methodParameterTypes120 = new String[] {  };

		_methodName121 = "setBeanIdentifier";

		_methodParameterTypes121 = new String[] { "java.lang.String" };

		_methodName126 = "getSubmissionRegistriesByBrokerSubmissionId";

		_methodParameterTypes126 = new String[] { "org.json.simple.JSONObject" };

		_methodName127 = "getSubmissionRegistriesByResearchObjectId";

		_methodParameterTypes127 = new String[] { "org.json.simple.JSONObject" };

		_methodName128 = "getArchivePIdsOfENA";

		_methodParameterTypes128 = new String[] { "java.lang.String" };

		_methodName129 = "getArchivePIdsWithTypeOfENA";

		_methodParameterTypes129 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName130 = "getArchivePIdsWithTypeSampleOfENA";

		_methodParameterTypes130 = new String[] { "java.lang.String" };

		_methodName131 = "getArchivePIdWithTypeStudyOfENA";

		_methodParameterTypes131 = new String[] { "java.lang.String" };

		_methodName132 = "getLatestSubmissionByIds";

		_methodParameterTypes132 = new String[] { "long", "java.lang.String" };

		_methodName133 = "getLatestSubmissionsByArchive";

		_methodParameterTypes133 = new String[] { "java.lang.String" };

		_methodName134 = "getLatestSubmissionsByResearchObjectId";

		_methodParameterTypes134 = new String[] { "long" };

		_methodName135 = "getLatestSubmissions";

		_methodParameterTypes135 = new String[] {  };

		_methodName136 = "getSubmissionRegistriesByBrokerSubmissionId";

		_methodParameterTypes136 = new String[] { "java.lang.String" };

		_methodName137 = "getSubmissionRegistriesByResearchObjectId";

		_methodParameterTypes137 = new String[] { "long" };

		_methodName138 = "GetStatusByIds";

		_methodParameterTypes138 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName139 = "constructSubmissionRegistriesJson";

		_methodParameterTypes139 = new String[] { "java.util.List" };

		_methodName140 = "constructSubmissionRegistryJson";

		_methodParameterTypes140 = new String[] {
				"org.gfbio.model.SubmissionRegistry"
			};

		_methodName141 = "constructStatus";

		_methodParameterTypes141 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName142 = "createSubmissionRegistry";

		_methodParameterTypes142 = new String[] { "org.json.simple.JSONObject" };

		_methodName143 = "updateSubmissionRegistry";

		_methodParameterTypes143 = new String[] { "org.json.simple.JSONObject" };

		_methodName144 = "updateSubmissionRegistry";

		_methodParameterTypes144 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "long"
			};

		_methodName145 = "updateSubmissionRegistry";

		_methodParameterTypes145 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long"
			};

		_methodName146 = "updateSubmissionRegistry";

		_methodParameterTypes146 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "long", "java.lang.String"
			};

		_methodName147 = "updateSubmissionRegistry";

		_methodParameterTypes147 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String"
			};

		_methodName148 = "updateSubmissionRegistry";

		_methodParameterTypes148 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String", "java.lang.Boolean", "java.util.Date"
			};

		_methodName149 = "updateSubmissionRegistryWithoutPId";

		_methodParameterTypes149 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.util.Date", "long", "java.lang.String"
			};

		_methodName150 = "updateArchivePId";

		_methodParameterTypes150 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName151 = "updateArchivePIdType";

		_methodParameterTypes151 = new String[] {
				"long", "int", "java.lang.String", "long"
			};

		_methodName152 = "updateBrokerSubmissionId";

		_methodParameterTypes152 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName153 = "updateIsPublic";

		_methodParameterTypes153 = new String[] {
				"long", "int", "java.lang.String", "java.lang.Boolean"
			};

		_methodName154 = "updateLastChanged";

		_methodParameterTypes154 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName155 = "updatePublicAfter";

		_methodParameterTypes155 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName156 = "updateStatus";

		_methodParameterTypes156 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName157 = "updateUserId";

		_methodParameterTypes157 = new String[] {
				"long", "int", "java.lang.String", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.addSubmissionRegistry((org.gfbio.model.SubmissionRegistry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.createSubmissionRegistry((org.gfbio.service.persistence.SubmissionRegistryPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.deleteSubmissionRegistry((org.gfbio.service.persistence.SubmissionRegistryPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.deleteSubmissionRegistry((org.gfbio.model.SubmissionRegistry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.fetchSubmissionRegistry((org.gfbio.service.persistence.SubmissionRegistryPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistry((org.gfbio.service.persistence.SubmissionRegistryPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry((org.gfbio.model.SubmissionRegistry)arguments[0]);
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			SubmissionRegistryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getArchivePIdsOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getArchivePIdsWithTypeOfENA((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getArchivePIdsWithTypeSampleOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getArchivePIdWithTypeStudyOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getLatestSubmissionByIds(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getLatestSubmissionsByArchive((java.lang.String)arguments[0]);
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getLatestSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getLatestSubmissions();
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByBrokerSubmissionId((java.lang.String)arguments[0]);
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.GetStatusByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.constructSubmissionRegistriesJson((java.util.List<org.gfbio.model.SubmissionRegistry>)arguments[0]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.constructSubmissionRegistryJson((org.gfbio.model.SubmissionRegistry)arguments[0]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.constructStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.createSubmissionRegistry((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.util.Date)arguments[5],
				((Long)arguments[6]).longValue());
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.util.Date)arguments[5],
				((Long)arguments[6]).longValue(), (java.lang.String)arguments[7]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(), (java.lang.String)arguments[8]);
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				(java.lang.Boolean)arguments[9], (java.util.Date)arguments[10]);
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistryWithoutPId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.util.Date)arguments[4], ((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateArchivePId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateArchivePIdType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], ((Long)arguments[3]).longValue());
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateBrokerSubmissionId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateIsPublic(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.Boolean)arguments[3]);
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateLastChanged(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updatePublicAfter(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return SubmissionRegistryLocalServiceUtil.updateUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
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
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
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
}