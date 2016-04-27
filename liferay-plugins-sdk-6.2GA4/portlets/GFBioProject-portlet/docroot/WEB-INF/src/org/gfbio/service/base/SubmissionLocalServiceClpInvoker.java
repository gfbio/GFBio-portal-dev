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

import org.gfbio.service.SubmissionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class SubmissionLocalServiceClpInvoker {
	public SubmissionLocalServiceClpInvoker() {
		_methodName0 = "addSubmission";

		_methodParameterTypes0 = new String[] { "org.gfbio.model.Submission" };

		_methodName1 = "createSubmission";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSubmission";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSubmission";

		_methodParameterTypes3 = new String[] { "org.gfbio.model.Submission" };

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

		_methodName10 = "fetchSubmission";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSubmission";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSubmissions";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSubmissionsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSubmission";

		_methodParameterTypes15 = new String[] { "org.gfbio.model.Submission" };

		_methodName130 = "getBeanIdentifier";

		_methodParameterTypes130 = new String[] {  };

		_methodName131 = "setBeanIdentifier";

		_methodParameterTypes131 = new String[] { "java.lang.String" };

		_methodName136 = "getLatestXPublicSubmissionsByX";

		_methodParameterTypes136 = new String[] { "org.json.simple.JSONObject" };

		_methodName137 = "getSubmissionsByBrokerSubmissionId";

		_methodParameterTypes137 = new String[] { "org.json.simple.JSONObject" };

		_methodName138 = "getSubmissionsByResearchObjectId";

		_methodParameterTypes138 = new String[] { "org.json.simple.JSONObject" };

		_methodName139 = "getArchivePIdsOfENA";

		_methodParameterTypes139 = new String[] { "java.lang.String" };

		_methodName140 = "getArchivePIdsWithTypeOfENA";

		_methodParameterTypes140 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName141 = "getArchivePIdsWithTypeSampleOfENA";

		_methodParameterTypes141 = new String[] { "java.lang.String" };

		_methodName142 = "getArchivePIdType";

		_methodParameterTypes142 = new String[] { "java.lang.String" };

		_methodName143 = "getArchivePIdWithTypeStudyOfENA";

		_methodParameterTypes143 = new String[] { "java.lang.String" };

		_methodName144 = "getLatestSubmissionByIds";

		_methodParameterTypes144 = new String[] { "long", "java.lang.String" };

		_methodName145 = "getLatestSubmissionsByArchive";

		_methodParameterTypes145 = new String[] { "java.lang.String" };

		_methodName146 = "getLatestSubmissionsByResearchObjectId";

		_methodParameterTypes146 = new String[] { "long" };

		_methodName147 = "getLatestSubmissions";

		_methodParameterTypes147 = new String[] {  };

		_methodName148 = "getLatestXPublicSubmissionsByX";

		_methodParameterTypes148 = new String[] { "int" };

		_methodName149 = "getStatus";

		_methodParameterTypes149 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName150 = "getResearchObjectVersion";

		_methodParameterTypes150 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName151 = "getSubmissionsByBrokerSubmissionId";

		_methodParameterTypes151 = new String[] { "java.lang.String" };

		_methodName152 = "getSubmissionsByResearchObjectId";

		_methodParameterTypes152 = new String[] { "long" };

		_methodName153 = "GetStatusByIds";

		_methodParameterTypes153 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName154 = "getSubmissionIdByIds";

		_methodParameterTypes154 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName155 = "getSubmission";

		_methodParameterTypes155 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName156 = "checkForIgnoredParameter";

		_methodParameterTypes156 = new String[] {
				"java.lang.Object[][]", "java.util.Set"
			};

		_methodName157 = "constructSubmissionsJson";

		_methodParameterTypes157 = new String[] { "java.util.List" };

		_methodName158 = "constructSubmissionJson";

		_methodParameterTypes158 = new String[] { "org.gfbio.model.Submission" };

		_methodName159 = "createSubmission";

		_methodParameterTypes159 = new String[] { "org.json.simple.JSONArray" };

		_methodName160 = "createSubmission";

		_methodParameterTypes160 = new String[] { "org.json.simple.JSONObject" };

		_methodName161 = "updateSubmission";

		_methodParameterTypes161 = new String[] { "org.json.simple.JSONArray" };

		_methodName162 = "updateSubmission";

		_methodParameterTypes162 = new String[] { "org.json.simple.JSONObject" };

		_methodName163 = "updateKernelSubmission";

		_methodParameterTypes163 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String", "long"
			};

		_methodName164 = "updateSubmission";

		_methodParameterTypes164 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String"
			};

		_methodName165 = "updateSubmission";

		_methodParameterTypes165 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String", "java.lang.Boolean", "java.util.Date"
			};

		_methodName166 = "updateSubmissionWithoutPId";

		_methodParameterTypes166 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.util.Date", "long", "java.lang.String"
			};

		_methodName167 = "updateArchivePId";

		_methodParameterTypes167 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName168 = "updateArchivePIdType";

		_methodParameterTypes168 = new String[] {
				"long", "int", "java.lang.String", "long"
			};

		_methodName169 = "updateBrokerSubmissionId";

		_methodParameterTypes169 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName170 = "updateIsPublic";

		_methodParameterTypes170 = new String[] {
				"long", "int", "java.lang.String", "java.lang.Boolean"
			};

		_methodName171 = "updateLastChanged";

		_methodParameterTypes171 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName172 = "updatePublicAfter";

		_methodParameterTypes172 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName173 = "updateStatus";

		_methodParameterTypes173 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName174 = "updateUserId";

		_methodParameterTypes174 = new String[] {
				"long", "int", "java.lang.String", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SubmissionLocalServiceUtil.addSubmission((org.gfbio.model.Submission)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SubmissionLocalServiceUtil.deleteSubmission(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SubmissionLocalServiceUtil.deleteSubmission((org.gfbio.model.Submission)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SubmissionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SubmissionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SubmissionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SubmissionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SubmissionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SubmissionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SubmissionLocalServiceUtil.fetchSubmission(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmission(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SubmissionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.gfbio.model.Submission)arguments[0]);
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			SubmissionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsWithTypeOfENA((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsWithTypeSampleOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdType((java.lang.String)arguments[0]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdWithTypeStudyOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionByIds(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionsByArchive((java.lang.String)arguments[0]);
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissions();
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX(((Integer)arguments[0]).intValue());
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return SubmissionLocalServiceUtil.getResearchObjectVersion(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId((java.lang.String)arguments[0]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return SubmissionLocalServiceUtil.GetStatusByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkForIgnoredParameter((java.lang.Object[])arguments[0],
				(java.util.Set<java.lang.String>)arguments[1]);
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructSubmissionsJson((java.util.List<org.gfbio.model.Submission>)arguments[0]);
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructSubmissionJson((org.gfbio.model.Submission)arguments[0]);
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateKernelSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue());
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(), (java.lang.String)arguments[8]);
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				(java.lang.Boolean)arguments[9], (java.util.Date)arguments[10]);
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmissionWithoutPId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.util.Date)arguments[4], ((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6]);
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateArchivePId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateArchivePIdType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], ((Long)arguments[3]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateBrokerSubmissionId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateIsPublic(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.Boolean)arguments[3]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateLastChanged(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return SubmissionLocalServiceUtil.updatePublicAfter(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateUserId(((Long)arguments[0]).longValue(),
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
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
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
}