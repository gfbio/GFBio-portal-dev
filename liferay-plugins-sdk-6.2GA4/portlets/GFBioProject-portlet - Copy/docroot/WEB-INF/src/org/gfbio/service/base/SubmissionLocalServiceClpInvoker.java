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

		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "deleteSubmission";

		_methodParameterTypes168 = new String[] { "org.json.simple.JSONObject" };

		_methodName172 = "getBrokerSubmissionId";

		_methodParameterTypes172 = new String[] { "org.json.simple.JSONObject" };

		_methodName173 = "getLatestXPublicSubmissionsByX";

		_methodParameterTypes173 = new String[] { "org.json.simple.JSONObject" };

		_methodName174 = "getStatusByResearchObjectId";

		_methodParameterTypes174 = new String[] { "org.json.simple.JSONObject" };

		_methodName175 = "getStatusByResearchObjectIdAndVersion";

		_methodParameterTypes175 = new String[] { "org.json.simple.JSONObject" };

		_methodName176 = "getSubmissionsByBrokerSubmissionId";

		_methodParameterTypes176 = new String[] { "org.json.simple.JSONObject" };

		_methodName177 = "getSubmissionsByResearchObjectId";

		_methodParameterTypes177 = new String[] { "org.json.simple.JSONObject" };

		_methodName178 = "getSubmissionsByResearchObjectIdAndVersion";

		_methodParameterTypes178 = new String[] { "org.json.simple.JSONObject" };

		_methodName179 = "getSubmissionIdsByResearchObjectIdAndVersion";

		_methodParameterTypes179 = new String[] { "org.json.simple.JSONObject" };

		_methodName181 = "getArchivePIdsOfENA";

		_methodParameterTypes181 = new String[] { "java.lang.String" };

		_methodName182 = "getArchivePIdsWithTypeOfENA";

		_methodParameterTypes182 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName183 = "getArchivePIdsWithTypeSampleOfENA";

		_methodParameterTypes183 = new String[] { "java.lang.String" };

		_methodName184 = "getArchivePIdType";

		_methodParameterTypes184 = new String[] { "java.lang.String" };

		_methodName185 = "getArchivePIdWithTypeStudyOfENA";

		_methodParameterTypes185 = new String[] { "java.lang.String" };

		_methodName186 = "getBrokerSubmissionIdByIds";

		_methodParameterTypes186 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName187 = "getLatestSubmissionByIds";

		_methodParameterTypes187 = new String[] { "long", "java.lang.String" };

		_methodName188 = "getLatestSubmissionsByArchive";

		_methodParameterTypes188 = new String[] { "java.lang.String" };

		_methodName189 = "getLatestSubmissionsByResearchObjectId";

		_methodParameterTypes189 = new String[] { "long" };

		_methodName190 = "getLatestSubmissions";

		_methodParameterTypes190 = new String[] {  };

		_methodName191 = "getLatestXPublicSubmissionsByX";

		_methodParameterTypes191 = new String[] { "int" };

		_methodName193 = "getStatus";

		_methodParameterTypes193 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName194 = "getResearchObjectVersion";

		_methodParameterTypes194 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName197 = "getStatusByIds";

		_methodParameterTypes197 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName198 = "getSubmission";

		_methodParameterTypes198 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName201 = "getSubmissionsByBrokerSubmissionId";

		_methodParameterTypes201 = new String[] { "java.lang.String" };

		_methodName202 = "getSubmissionsByResearchObjectId";

		_methodParameterTypes202 = new String[] { "long" };

		_methodName204 = "getSubmissionIdByIds";

		_methodParameterTypes204 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName205 = "checkOfIds";

		_methodParameterTypes205 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName206 = "checkOfSubmissionId";

		_methodParameterTypes206 = new String[] { "long" };

		_methodName207 = "checkOfBrokerSubmissionId";

		_methodParameterTypes207 = new String[] { "java.lang.String" };

		_methodName208 = "checkResearchObjectIdAndVersion";

		_methodParameterTypes208 = new String[] { "long", "int" };

		_methodName209 = "constructNewId";

		_methodParameterTypes209 = new String[] {  };

		_methodName210 = "constructSubmissionsJson";

		_methodParameterTypes210 = new String[] { "java.util.List" };

		_methodName211 = "constructSubmissionJson";

		_methodParameterTypes211 = new String[] { "org.gfbio.model.Submission" };

		_methodName212 = "createSubmission";

		_methodParameterTypes212 = new String[] { "org.json.simple.JSONArray" };

		_methodName213 = "createSubmission";

		_methodParameterTypes213 = new String[] { "org.json.simple.JSONObject" };

		_methodName214 = "updateSubmission";

		_methodParameterTypes214 = new String[] { "org.json.simple.JSONArray" };

		_methodName215 = "updateSubmission";

		_methodParameterTypes215 = new String[] { "org.json.simple.JSONObject" };

		_methodName217 = "updateKernelSubmission";

		_methodParameterTypes217 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String", "long"
			};

		_methodName218 = "updateSubmission";

		_methodParameterTypes218 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String"
			};

		_methodName219 = "updateSubmission";

		_methodParameterTypes219 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String", "java.lang.Boolean", "java.util.Date"
			};

		_methodName220 = "updateSubmissionWithoutPId";

		_methodParameterTypes220 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.util.Date", "long", "java.lang.String"
			};

		_methodName221 = "updateArchivePId";

		_methodParameterTypes221 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName222 = "updateArchivePIdType";

		_methodParameterTypes222 = new String[] {
				"long", "int", "java.lang.String", "long"
			};

		_methodName223 = "updateBrokerSubmissionId";

		_methodParameterTypes223 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName224 = "updateIsPublic";

		_methodParameterTypes224 = new String[] {
				"long", "int", "java.lang.String", "java.lang.Boolean"
			};

		_methodName225 = "updateJiraId";

		_methodParameterTypes225 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName226 = "updateJiraKey";

		_methodParameterTypes226 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName227 = "updateLastChanged";

		_methodParameterTypes227 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName228 = "updatePublicAfter";

		_methodParameterTypes228 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName229 = "updateStatus";

		_methodParameterTypes229 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName230 = "updateUserId";

		_methodParameterTypes230 = new String[] {
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

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			SubmissionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return SubmissionLocalServiceUtil.deleteSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatusByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatusByResearchObjectIdAndVersion((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectIdAndVersion((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionIdsByResearchObjectIdAndVersion((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsWithTypeOfENA((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsWithTypeSampleOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdType((java.lang.String)arguments[0]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdWithTypeStudyOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBrokerSubmissionIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionByIds(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionsByArchive((java.lang.String)arguments[0]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissions();
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX(((Integer)arguments[0]).intValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return SubmissionLocalServiceUtil.getResearchObjectVersion(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatusByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId((java.lang.String)arguments[0]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkOfIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkOfSubmissionId(((Long)arguments[0]).longValue());
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkOfBrokerSubmissionId((java.lang.String)arguments[0]);
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructNewId();
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructSubmissionsJson((java.util.List<org.gfbio.model.Submission>)arguments[0]);
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructSubmissionJson((org.gfbio.model.Submission)arguments[0]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateKernelSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue());
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(), (java.lang.String)arguments[8]);
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				(java.lang.Boolean)arguments[9], (java.util.Date)arguments[10]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmissionWithoutPId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.util.Date)arguments[4], ((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6]);
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateArchivePId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateArchivePIdType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], ((Long)arguments[3]).longValue());
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateBrokerSubmissionId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateIsPublic(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.Boolean)arguments[3]);
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateJiraId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateJiraKey(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateLastChanged(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
			return SubmissionLocalServiceUtil.updatePublicAfter(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
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
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName168;
	private String[] _methodParameterTypes168;
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
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName205;
	private String[] _methodParameterTypes205;
	private String _methodName206;
	private String[] _methodParameterTypes206;
	private String _methodName207;
	private String[] _methodParameterTypes207;
	private String _methodName208;
	private String[] _methodParameterTypes208;
	private String _methodName209;
	private String[] _methodParameterTypes209;
	private String _methodName210;
	private String[] _methodParameterTypes210;
	private String _methodName211;
	private String[] _methodParameterTypes211;
	private String _methodName212;
	private String[] _methodParameterTypes212;
	private String _methodName213;
	private String[] _methodParameterTypes213;
	private String _methodName214;
	private String[] _methodParameterTypes214;
	private String _methodName215;
	private String[] _methodParameterTypes215;
	private String _methodName217;
	private String[] _methodParameterTypes217;
	private String _methodName218;
	private String[] _methodParameterTypes218;
	private String _methodName219;
	private String[] _methodParameterTypes219;
	private String _methodName220;
	private String[] _methodParameterTypes220;
	private String _methodName221;
	private String[] _methodParameterTypes221;
	private String _methodName222;
	private String[] _methodParameterTypes222;
	private String _methodName223;
	private String[] _methodParameterTypes223;
	private String _methodName224;
	private String[] _methodParameterTypes224;
	private String _methodName225;
	private String[] _methodParameterTypes225;
	private String _methodName226;
	private String[] _methodParameterTypes226;
	private String _methodName227;
	private String[] _methodParameterTypes227;
	private String _methodName228;
	private String[] _methodParameterTypes228;
	private String _methodName229;
	private String[] _methodParameterTypes229;
	private String _methodName230;
	private String[] _methodParameterTypes230;
}