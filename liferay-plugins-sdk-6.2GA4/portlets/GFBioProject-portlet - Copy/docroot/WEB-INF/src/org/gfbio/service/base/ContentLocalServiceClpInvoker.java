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

import org.gfbio.service.ContentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Marcel Froemming
 * @generated
 */
public class ContentLocalServiceClpInvoker {
	public ContentLocalServiceClpInvoker() {
		_methodName0 = "addContent";

		_methodParameterTypes0 = new String[] { "org.gfbio.model.Content" };

		_methodName1 = "createContent";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteContent";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteContent";

		_methodParameterTypes3 = new String[] { "org.gfbio.model.Content" };

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

		_methodName10 = "fetchContent";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getContent";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getContents";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getContentsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateContent";

		_methodParameterTypes15 = new String[] { "org.gfbio.model.Content" };

		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "deleteContentsByColumnId";

		_methodParameterTypes168 = new String[] { "long" };

		_methodName169 = "deleteContentsByHeadId";

		_methodParameterTypes169 = new String[] { "long" };

		_methodName170 = "deleteContentsByRowId";

		_methodParameterTypes170 = new String[] { "long" };

		_methodName171 = "deleteRelationContentByCellContent";

		_methodParameterTypes171 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName172 = "deleteRelationContentsByCellContent";

		_methodParameterTypes172 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName173 = "deleteRelationContentOfCategoryWithSpecificType";

		_methodParameterTypes173 = new String[] {
				"java.lang.String", "long", "java.lang.String"
			};

		_methodName174 = "getCellContentByContentId";

		_methodParameterTypes174 = new String[] { "long" };

		_methodName175 = "getCellContentByRowIdAndColumnName";

		_methodParameterTypes175 = new String[] { "long", "java.lang.String" };

		_methodName176 = "getColumnIdById";

		_methodParameterTypes176 = new String[] { "long" };

		_methodName177 = "getContentIdByRowIdAndColumnName";

		_methodParameterTypes177 = new String[] { "long", "java.lang.String" };

		_methodName178 = "getContentByTableIds";

		_methodParameterTypes178 = new String[] { "long", "long" };

		_methodName179 = "getContentIdByTableIds";

		_methodParameterTypes179 = new String[] { "long", "long" };

		_methodName180 = "getContentIdsByRowId";

		_methodParameterTypes180 = new String[] { "long" };

		_methodName181 = "getContentIdsOfRelationshipsOfSpecificCellContent";

		_methodParameterTypes181 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName182 = "getContentIdsOfRelationshipsOfSpecificCellContent";

		_methodParameterTypes182 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName183 = "getContentIdsWithoutRelationships";

		_methodParameterTypes183 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName184 = "getContentIdsWithRelationships";

		_methodParameterTypes184 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName185 = "getContentIdsWithNormalTableRelationships";

		_methodParameterTypes185 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName186 = "getContentInformationAsJSONByContentId";

		_methodParameterTypes186 = new String[] { "long" };

		_methodName187 = "getContentInformationAsJSONByRowId";

		_methodParameterTypes187 = new String[] { "long" };

		_methodName188 = "getContentsAsJSONByRowId";

		_methodParameterTypes188 = new String[] { "long" };

		_methodName189 = "getCountOfColumns";

		_methodParameterTypes189 = new String[] { "long" };

		_methodName190 = "getCountOfRows";

		_methodParameterTypes190 = new String[] { "long" };

		_methodName191 = "getFirstContentIdByRowId";

		_methodParameterTypes191 = new String[] { "long" };

		_methodName192 = "getHeadIdById";

		_methodParameterTypes192 = new String[] { "long" };

		_methodName193 = "getHeadIdByRowId";

		_methodParameterTypes193 = new String[] { "long" };

		_methodName195 = "getOppositeCellContentsOfRelationsByCellContent";

		_methodParameterTypes195 = new String[] { "long", "java.lang.String" };

		_methodName196 = "getOppositeCellContentsOfRelationsByCellContent";

		_methodParameterTypes196 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName197 = "getRowIdByCellContent";

		_methodParameterTypes197 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName198 = "getRowIdByCellContent";

		_methodParameterTypes198 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName201 = "getRowIdById";

		_methodParameterTypes201 = new String[] { "long" };

		_methodName202 = "getRowIdOfRelation";

		_methodParameterTypes202 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName203 = "getRowIds";

		_methodParameterTypes203 = new String[] { "long" };

		_methodName206 = "getRowInformationByContentId";

		_methodParameterTypes206 = new String[] { "long" };

		_methodName207 = "getRowInformationById";

		_methodParameterTypes207 = new String[] { "long" };

		_methodName208 = "getRowInformationOfRelationByContentId";

		_methodParameterTypes208 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName209 = "getRowInformationsOfRelationshipsOfSpecificCellContent";

		_methodParameterTypes209 = new String[] { "org.json.simple.JSONObject" };

		_methodName210 = "getRowInformationsOfRelationshipsOfSpecificCellContent";

		_methodParameterTypes210 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName211 = "getRowInformationOfRelationshipsOfSpecificCellContent";

		_methodParameterTypes211 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName212 = "checkExistenceOfKeyId";

		_methodParameterTypes212 = new String[] { "java.lang.String", "long" };

		_methodName213 = "checkExistenceOfKeyId";

		_methodParameterTypes213 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName214 = "checkExistenceOfKeyId";

		_methodParameterTypes214 = new String[] { "long", "java.lang.String" };

		_methodName215 = "checkForIgnoredParameter";

		_methodParameterTypes215 = new String[] {
				"java.lang.Object[][]", "java.util.Set"
			};

		_methodName216 = "checkKeyPairInRelationship";

		_methodParameterTypes216 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName217 = "constructContentJson";

		_methodParameterTypes217 = new String[] { "org.gfbio.model.Content" };

		_methodName218 = "constructContentJson";

		_methodParameterTypes218 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.util.Date"
			};

		_methodName219 = "constructContenRowInputJson";

		_methodParameterTypes219 = new String[] {
				"java.lang.String", "long", "long", "org.json.simple.JSONObject"
			};

		_methodName220 = "constructNewId";

		_methodParameterTypes220 = new String[] {  };

		_methodName221 = "createContent";

		_methodParameterTypes221 = new String[] { "org.json.simple.JSONObject" };

		_methodName222 = "createContentWithTS";

		_methodParameterTypes222 = new String[] { "org.json.simple.JSONObject" };

		_methodName223 = "createContentRow";

		_methodParameterTypes223 = new String[] { "org.json.simple.JSONArray" };

		_methodName224 = "updateContent";

		_methodParameterTypes224 = new String[] { "org.json.simple.JSONObject" };

		_methodName225 = "updateContentWithTS";

		_methodParameterTypes225 = new String[] { "org.json.simple.JSONObject" };

		_methodName226 = "updateContentRow";

		_methodParameterTypes226 = new String[] { "org.json.simple.JSONArray" };

		_methodName227 = "updateKernalContent";

		_methodParameterTypes227 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName228 = "updateKernelContent";

		_methodParameterTypes228 = new String[] {
				"long", "long", "long", "long", "java.lang.String"
			};

		_methodName229 = "updateRowTimeStamp";

		_methodParameterTypes229 = new String[] { "long", "long", "long" };

		_methodName230 = "updateContent";

		_methodParameterTypes230 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "long"
			};

		_methodName231 = "updateContent2";

		_methodParameterTypes231 = new String[] { "org.json.simple.JSONObject" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ContentLocalServiceUtil.addContent((org.gfbio.model.Content)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ContentLocalServiceUtil.createContent(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ContentLocalServiceUtil.deleteContent(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ContentLocalServiceUtil.deleteContent((org.gfbio.model.Content)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ContentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ContentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ContentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ContentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ContentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ContentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ContentLocalServiceUtil.fetchContent(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ContentLocalServiceUtil.getContent(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ContentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ContentLocalServiceUtil.getContents(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ContentLocalServiceUtil.getContentsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ContentLocalServiceUtil.updateContent((org.gfbio.model.Content)arguments[0]);
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return ContentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			ContentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			ContentLocalServiceUtil.deleteContentsByColumnId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			ContentLocalServiceUtil.deleteContentsByHeadId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			ContentLocalServiceUtil.deleteContentsByRowId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			ContentLocalServiceUtil.deleteRelationContentByCellContent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			ContentLocalServiceUtil.deleteRelationContentsByCellContent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			ContentLocalServiceUtil.deleteRelationContentOfCategoryWithSpecificType((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return ContentLocalServiceUtil.getCellContentByContentId(((Long)arguments[0]).longValue());
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return ContentLocalServiceUtil.getColumnIdById(((Long)arguments[0]).longValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdByRowIdAndColumnName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return ContentLocalServiceUtil.getContentByTableIds(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdByTableIds(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdsByRowId(((Long)arguments[0]).longValue());
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdsOfRelationshipsOfSpecificCellContent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdsOfRelationshipsOfSpecificCellContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdsWithoutRelationships(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdsWithRelationships(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return ContentLocalServiceUtil.getContentIdsWithNormalTableRelationships(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return ContentLocalServiceUtil.getContentInformationAsJSONByContentId(((Long)arguments[0]).longValue());
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return ContentLocalServiceUtil.getContentInformationAsJSONByRowId(((Long)arguments[0]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return ContentLocalServiceUtil.getContentsAsJSONByRowId(((Long)arguments[0]).longValue());
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return ContentLocalServiceUtil.getCountOfColumns(((Long)arguments[0]).longValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return ContentLocalServiceUtil.getCountOfRows(((Long)arguments[0]).longValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return ContentLocalServiceUtil.getFirstContentIdByRowId(((Long)arguments[0]).longValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return ContentLocalServiceUtil.getHeadIdById(((Long)arguments[0]).longValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return ContentLocalServiceUtil.getHeadIdByRowId(((Long)arguments[0]).longValue());
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return ContentLocalServiceUtil.getRowIdByCellContent(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return ContentLocalServiceUtil.getRowIdByCellContent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return ContentLocalServiceUtil.getRowIdById(((Long)arguments[0]).longValue());
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return ContentLocalServiceUtil.getRowIdOfRelation((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return ContentLocalServiceUtil.getRowIds(((Long)arguments[0]).longValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return ContentLocalServiceUtil.getRowInformationByContentId(((Long)arguments[0]).longValue());
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return ContentLocalServiceUtil.getRowInformationById(((Long)arguments[0]).longValue());
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return ContentLocalServiceUtil.getRowInformationOfRelationByContentId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return ContentLocalServiceUtil.getRowInformationsOfRelationshipsOfSpecificCellContent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return ContentLocalServiceUtil.getRowInformationsOfRelationshipsOfSpecificCellContent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return ContentLocalServiceUtil.getRowInformationOfRelationshipsOfSpecificCellContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return ContentLocalServiceUtil.checkExistenceOfKeyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return ContentLocalServiceUtil.checkExistenceOfKeyId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return ContentLocalServiceUtil.checkExistenceOfKeyId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return ContentLocalServiceUtil.checkForIgnoredParameter((java.lang.Object[])arguments[0],
				(java.util.Set<java.lang.String>)arguments[1]);
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return ContentLocalServiceUtil.checkKeyPairInRelationship(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return ContentLocalServiceUtil.constructContentJson((org.gfbio.model.Content)arguments[0]);
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return ContentLocalServiceUtil.constructContentJson(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.util.Date)arguments[5]);
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return ContentLocalServiceUtil.constructContenRowInputJson((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(org.json.simple.JSONObject)arguments[3]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return ContentLocalServiceUtil.constructNewId();
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return ContentLocalServiceUtil.createContent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return ContentLocalServiceUtil.createContentWithTS((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return ContentLocalServiceUtil.createContentRow((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return ContentLocalServiceUtil.updateContent((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return ContentLocalServiceUtil.updateContentWithTS((org.json.simple.JSONObject)arguments[0]);
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			return ContentLocalServiceUtil.updateContentRow((org.json.simple.JSONArray)arguments[0]);
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			return ContentLocalServiceUtil.updateKernalContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
			return ContentLocalServiceUtil.updateKernelContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			return ContentLocalServiceUtil.updateRowTimeStamp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
			return ContentLocalServiceUtil.updateContent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName231.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes231, parameterTypes)) {
			return ContentLocalServiceUtil.updateContent2((org.json.simple.JSONObject)arguments[0]);
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
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
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
	private String _methodName216;
	private String[] _methodParameterTypes216;
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
	private String _methodName231;
	private String[] _methodParameterTypes231;
}