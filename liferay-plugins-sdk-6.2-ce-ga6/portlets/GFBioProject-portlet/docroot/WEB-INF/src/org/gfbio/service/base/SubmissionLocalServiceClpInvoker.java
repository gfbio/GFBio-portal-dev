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

		_methodName176 = "getBeanIdentifier";

		_methodParameterTypes176 = new String[] {  };

		_methodName177 = "setBeanIdentifier";

		_methodParameterTypes177 = new String[] { "java.lang.String" };

		_methodName182 = "deleteSubmission";

		_methodParameterTypes182 = new String[] { "org.json.simple.JSONObject" };

		_methodName187 = "getBrokerSubmissionId";

		_methodParameterTypes187 = new String[] { "org.json.simple.JSONObject" };

		_methodName188 = "getLatestXPublicSubmissionsByX";

		_methodParameterTypes188 = new String[] { "org.json.simple.JSONObject" };

		_methodName189 = "getStatusByResearchObjectId";

		_methodParameterTypes189 = new String[] { "org.json.simple.JSONObject" };

		_methodName190 = "getStatusByResearchObjectIdAndVersion";

		_methodParameterTypes190 = new String[] { "org.json.simple.JSONObject" };

		_methodName191 = "getSubmissionsByBrokerSubmissionId";

		_methodParameterTypes191 = new String[] { "org.json.simple.JSONObject" };

		_methodName192 = "getSubmissionsByResearchObjectId";

		_methodParameterTypes192 = new String[] { "org.json.simple.JSONObject" };

		_methodName193 = "getSubmissionsByResearchObjectIdAndVersion";

		_methodParameterTypes193 = new String[] { "org.json.simple.JSONObject" };

		_methodName194 = "getSubmissionIdsByResearchObjectIdAndVersion";

		_methodParameterTypes194 = new String[] { "org.json.simple.JSONObject" };

		_methodName196 = "getArchivePIdsOfENA";

		_methodParameterTypes196 = new String[] { "java.lang.String" };

		_methodName197 = "getArchivePIdsWithTypeOfENA";

		_methodParameterTypes197 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName198 = "getArchivePIdsWithTypeSampleOfENA";

		_methodParameterTypes198 = new String[] { "java.lang.String" };

		_methodName199 = "getArchivePIdType";

		_methodParameterTypes199 = new String[] { "java.lang.String" };

		_methodName200 = "getArchivePIdWithTypeStudyOfENA";

		_methodParameterTypes200 = new String[] { "java.lang.String" };

		_methodName201 = "getBrokerSubmissionIdByIds";

		_methodParameterTypes201 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName202 = "getLatestSubmissionByIds";

		_methodParameterTypes202 = new String[] { "long", "java.lang.String" };

		_methodName203 = "getLatestSubmissionsByArchive";

		_methodParameterTypes203 = new String[] { "java.lang.String" };

		_methodName204 = "getLatestSubmissionsByResearchObjectId";

		_methodParameterTypes204 = new String[] { "long" };

		_methodName205 = "getLatestSubmissions";

		_methodParameterTypes205 = new String[] {  };

		_methodName206 = "getLatestXPublicSubmissionsByX";

		_methodParameterTypes206 = new String[] { "int" };

		_methodName208 = "getStatus";

		_methodParameterTypes208 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName209 = "getResearchObjectVersion";

		_methodParameterTypes209 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName212 = "getStatusByIds";

		_methodParameterTypes212 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName213 = "getSubmission";

		_methodParameterTypes213 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName216 = "getSubmissionsByBrokerSubmissionId";

		_methodParameterTypes216 = new String[] { "java.lang.String" };

		_methodName217 = "getSubmissionsByResearchObjectId";

		_methodParameterTypes217 = new String[] { "long" };

		_methodName219 = "getSubmissionIdByIds";

		_methodParameterTypes219 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName220 = "checkOfIds";

		_methodParameterTypes220 = new String[] {
				"long", "int", "java.lang.String"
			};

		_methodName221 = "checkOfSubmissionId";

		_methodParameterTypes221 = new String[] { "long" };

		_methodName222 = "checkOfBrokerSubmissionId";

		_methodParameterTypes222 = new String[] { "java.lang.String" };

		_methodName223 = "checkResearchObjectIdAndVersion";

		_methodParameterTypes223 = new String[] { "long", "int" };

		_methodName224 = "constructNewId";

		_methodParameterTypes224 = new String[] {  };

		_methodName225 = "constructSubmissionsJson";

		_methodParameterTypes225 = new String[] { "java.util.List" };

		_methodName226 = "constructSubmissionJson";

		_methodParameterTypes226 = new String[] { "org.gfbio.model.Submission" };

		_methodName227 = "createSubmission";

		_methodParameterTypes227 = new String[] { "org.json.simple.JSONArray" };

		_methodName228 = "createSubmission";

		_methodParameterTypes228 = new String[] { "org.json.simple.JSONObject" };

		_methodName229 = "updateSubmission";

		_methodParameterTypes229 = new String[] { "org.json.simple.JSONArray" };

		_methodName230 = "updateSubmission";

		_methodParameterTypes230 = new String[] { "org.json.simple.JSONObject" };

		_methodName232 = "updateKernelSubmission";

		_methodParameterTypes232 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String", "long"
			};

		_methodName233 = "updateSubmission";

		_methodParameterTypes233 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String"
			};

		_methodName234 = "updateSubmission";

		_methodParameterTypes234 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Date", "long",
				"java.lang.String", "java.lang.Boolean", "java.util.Date"
			};

		_methodName235 = "updateSubmissionWithoutPId";

		_methodParameterTypes235 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String",
				"java.util.Date", "long", "java.lang.String"
			};

		_methodName236 = "updateArchivePId";

		_methodParameterTypes236 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName237 = "updateArchivePIdType";

		_methodParameterTypes237 = new String[] {
				"long", "int", "java.lang.String", "long"
			};

		_methodName238 = "updateBrokerSubmissionId";

		_methodParameterTypes238 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName239 = "updateIsPublic";

		_methodParameterTypes239 = new String[] {
				"long", "int", "java.lang.String", "java.lang.Boolean"
			};

		_methodName240 = "updateJiraId";

		_methodParameterTypes240 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName241 = "updateJiraKey";

		_methodParameterTypes241 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName242 = "updateLastChanged";

		_methodParameterTypes242 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName243 = "updatePublicAfter";

		_methodParameterTypes243 = new String[] {
				"long", "int", "java.lang.String", "java.util.Date"
			};

		_methodName244 = "updateStatus";

		_methodParameterTypes244 = new String[] {
				"long", "int", "java.lang.String", "java.lang.String"
			};

		_methodName245 = "updateUserId";

		_methodParameterTypes245 = new String[] {
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

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			SubmissionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return SubmissionLocalServiceUtil.deleteSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatusByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatusByResearchObjectIdAndVersion((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectIdAndVersion((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionIdsByResearchObjectIdAndVersion((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsWithTypeOfENA((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdsWithTypeSampleOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdType((java.lang.String)arguments[0]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return SubmissionLocalServiceUtil.getArchivePIdWithTypeStudyOfENA((java.lang.String)arguments[0]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return SubmissionLocalServiceUtil.getBrokerSubmissionIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionByIds(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionsByArchive((java.lang.String)arguments[0]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestSubmissions();
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX(((Integer)arguments[0]).intValue());
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return SubmissionLocalServiceUtil.getResearchObjectVersion(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return SubmissionLocalServiceUtil.getStatusByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId((java.lang.String)arguments[0]);
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId(((Long)arguments[0]).longValue());
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return SubmissionLocalServiceUtil.getSubmissionIdByIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkOfIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkOfSubmissionId(((Long)arguments[0]).longValue());
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkOfBrokerSubmissionId((java.lang.String)arguments[0]);
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return SubmissionLocalServiceUtil.checkResearchObjectIdAndVersion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructNewId();
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructSubmissionsJson((java.util.List<org.gfbio.model.Submission>)arguments[0]);
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			return SubmissionLocalServiceUtil.constructSubmissionJson((org.gfbio.model.Submission)arguments[0]);
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
			return SubmissionLocalServiceUtil.createSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName232.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes232, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateKernelSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue());
		}

		if (_methodName233.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes233, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(), (java.lang.String)arguments[8]);
		}

		if (_methodName234.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes234, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmission(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				(java.lang.Boolean)arguments[9], (java.util.Date)arguments[10]);
		}

		if (_methodName235.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes235, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateSubmissionWithoutPId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.util.Date)arguments[4], ((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6]);
		}

		if (_methodName236.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes236, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateArchivePId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName237.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes237, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateArchivePIdType(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], ((Long)arguments[3]).longValue());
		}

		if (_methodName238.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes238, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateBrokerSubmissionId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName239.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes239, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateIsPublic(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.Boolean)arguments[3]);
		}

		if (_methodName240.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes240, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateJiraId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName241.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes241, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateJiraKey(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName242.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes242, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateLastChanged(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName243.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes243, parameterTypes)) {
			return SubmissionLocalServiceUtil.updatePublicAfter(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3]);
		}

		if (_methodName244.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes244, parameterTypes)) {
			return SubmissionLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName245.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes245, parameterTypes)) {
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
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
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
	private String _methodName205;
	private String[] _methodParameterTypes205;
	private String _methodName206;
	private String[] _methodParameterTypes206;
	private String _methodName208;
	private String[] _methodParameterTypes208;
	private String _methodName209;
	private String[] _methodParameterTypes209;
	private String _methodName212;
	private String[] _methodParameterTypes212;
	private String _methodName213;
	private String[] _methodParameterTypes213;
	private String _methodName216;
	private String[] _methodParameterTypes216;
	private String _methodName217;
	private String[] _methodParameterTypes217;
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
	private String _methodName232;
	private String[] _methodParameterTypes232;
	private String _methodName233;
	private String[] _methodParameterTypes233;
	private String _methodName234;
	private String[] _methodParameterTypes234;
	private String _methodName235;
	private String[] _methodParameterTypes235;
	private String _methodName236;
	private String[] _methodParameterTypes236;
	private String _methodName237;
	private String[] _methodParameterTypes237;
	private String _methodName238;
	private String[] _methodParameterTypes238;
	private String _methodName239;
	private String[] _methodParameterTypes239;
	private String _methodName240;
	private String[] _methodParameterTypes240;
	private String _methodName241;
	private String[] _methodParameterTypes241;
	private String _methodName242;
	private String[] _methodParameterTypes242;
	private String _methodName243;
	private String[] _methodParameterTypes243;
	private String _methodName244;
	private String[] _methodParameterTypes244;
	private String _methodName245;
	private String[] _methodParameterTypes245;
}