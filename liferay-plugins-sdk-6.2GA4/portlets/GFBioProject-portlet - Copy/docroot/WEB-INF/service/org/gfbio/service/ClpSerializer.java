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

package org.gfbio.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.gfbio.model.BasketClp;
import org.gfbio.model.ColumnClp;
import org.gfbio.model.ContentClp;
import org.gfbio.model.DataProviderClp;
import org.gfbio.model.DataProvider_PersistentIdentifierClp;
import org.gfbio.model.Funding_InstitutionProjectClp;
import org.gfbio.model.Funding_PersonProjectClp;
import org.gfbio.model.HeadClp;
import org.gfbio.model.PrimaryDataClp;
import org.gfbio.model.PrimaryData_ResearchObjectClp;
import org.gfbio.model.ProjectClp;
import org.gfbio.model.Project_ResearchObjectClp;
import org.gfbio.model.Project_UserClp;
import org.gfbio.model.ResearchObjectClp;
import org.gfbio.model.ResearchObject_UserClp;
import org.gfbio.model.SubmissionClp;
import org.gfbio.model.UserExtensionClp;
import org.gfbio.model.UserSSOClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcel Froemming
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"GFBioProject-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"GFBioProject-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "GFBioProject-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BasketClp.class.getName())) {
			return translateInputBasket(oldModel);
		}

		if (oldModelClassName.equals(ColumnClp.class.getName())) {
			return translateInputColumn(oldModel);
		}

		if (oldModelClassName.equals(ContentClp.class.getName())) {
			return translateInputContent(oldModel);
		}

		if (oldModelClassName.equals(DataProviderClp.class.getName())) {
			return translateInputDataProvider(oldModel);
		}

		if (oldModelClassName.equals(
					DataProvider_PersistentIdentifierClp.class.getName())) {
			return translateInputDataProvider_PersistentIdentifier(oldModel);
		}

		if (oldModelClassName.equals(
					Funding_InstitutionProjectClp.class.getName())) {
			return translateInputFunding_InstitutionProject(oldModel);
		}

		if (oldModelClassName.equals(Funding_PersonProjectClp.class.getName())) {
			return translateInputFunding_PersonProject(oldModel);
		}

		if (oldModelClassName.equals(HeadClp.class.getName())) {
			return translateInputHead(oldModel);
		}

		if (oldModelClassName.equals(PrimaryDataClp.class.getName())) {
			return translateInputPrimaryData(oldModel);
		}

		if (oldModelClassName.equals(
					PrimaryData_ResearchObjectClp.class.getName())) {
			return translateInputPrimaryData_ResearchObject(oldModel);
		}

		if (oldModelClassName.equals(ProjectClp.class.getName())) {
			return translateInputProject(oldModel);
		}

		if (oldModelClassName.equals(Project_ResearchObjectClp.class.getName())) {
			return translateInputProject_ResearchObject(oldModel);
		}

		if (oldModelClassName.equals(Project_UserClp.class.getName())) {
			return translateInputProject_User(oldModel);
		}

		if (oldModelClassName.equals(ResearchObjectClp.class.getName())) {
			return translateInputResearchObject(oldModel);
		}

		if (oldModelClassName.equals(ResearchObject_UserClp.class.getName())) {
			return translateInputResearchObject_User(oldModel);
		}

		if (oldModelClassName.equals(SubmissionClp.class.getName())) {
			return translateInputSubmission(oldModel);
		}

		if (oldModelClassName.equals(UserExtensionClp.class.getName())) {
			return translateInputUserExtension(oldModel);
		}

		if (oldModelClassName.equals(UserSSOClp.class.getName())) {
			return translateInputUserSSO(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputBasket(BaseModel<?> oldModel) {
		BasketClp oldClpModel = (BasketClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBasketRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputColumn(BaseModel<?> oldModel) {
		ColumnClp oldClpModel = (ColumnClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getColumnRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContent(BaseModel<?> oldModel) {
		ContentClp oldClpModel = (ContentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDataProvider(BaseModel<?> oldModel) {
		DataProviderClp oldClpModel = (DataProviderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDataProviderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDataProvider_PersistentIdentifier(
		BaseModel<?> oldModel) {
		DataProvider_PersistentIdentifierClp oldClpModel = (DataProvider_PersistentIdentifierClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDataProvider_PersistentIdentifierRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFunding_InstitutionProject(
		BaseModel<?> oldModel) {
		Funding_InstitutionProjectClp oldClpModel = (Funding_InstitutionProjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFunding_InstitutionProjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFunding_PersonProject(
		BaseModel<?> oldModel) {
		Funding_PersonProjectClp oldClpModel = (Funding_PersonProjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFunding_PersonProjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHead(BaseModel<?> oldModel) {
		HeadClp oldClpModel = (HeadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHeadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPrimaryData(BaseModel<?> oldModel) {
		PrimaryDataClp oldClpModel = (PrimaryDataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPrimaryDataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPrimaryData_ResearchObject(
		BaseModel<?> oldModel) {
		PrimaryData_ResearchObjectClp oldClpModel = (PrimaryData_ResearchObjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPrimaryData_ResearchObjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProject(BaseModel<?> oldModel) {
		ProjectClp oldClpModel = (ProjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProject_ResearchObject(
		BaseModel<?> oldModel) {
		Project_ResearchObjectClp oldClpModel = (Project_ResearchObjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProject_ResearchObjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProject_User(BaseModel<?> oldModel) {
		Project_UserClp oldClpModel = (Project_UserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProject_UserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResearchObject(BaseModel<?> oldModel) {
		ResearchObjectClp oldClpModel = (ResearchObjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getResearchObjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResearchObject_User(
		BaseModel<?> oldModel) {
		ResearchObject_UserClp oldClpModel = (ResearchObject_UserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getResearchObject_UserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubmission(BaseModel<?> oldModel) {
		SubmissionClp oldClpModel = (SubmissionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubmissionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserExtension(BaseModel<?> oldModel) {
		UserExtensionClp oldClpModel = (UserExtensionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserExtensionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserSSO(BaseModel<?> oldModel) {
		UserSSOClp oldClpModel = (UserSSOClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserSSORemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("org.gfbio.model.impl.BasketImpl")) {
			return translateOutputBasket(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.ColumnImpl")) {
			return translateOutputColumn(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.ContentImpl")) {
			return translateOutputContent(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.DataProviderImpl")) {
			return translateOutputDataProvider(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.gfbio.model.impl.DataProvider_PersistentIdentifierImpl")) {
			return translateOutputDataProvider_PersistentIdentifier(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.gfbio.model.impl.Funding_InstitutionProjectImpl")) {
			return translateOutputFunding_InstitutionProject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.gfbio.model.impl.Funding_PersonProjectImpl")) {
			return translateOutputFunding_PersonProject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.HeadImpl")) {
			return translateOutputHead(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.PrimaryDataImpl")) {
			return translateOutputPrimaryData(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.gfbio.model.impl.PrimaryData_ResearchObjectImpl")) {
			return translateOutputPrimaryData_ResearchObject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.ProjectImpl")) {
			return translateOutputProject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.gfbio.model.impl.Project_ResearchObjectImpl")) {
			return translateOutputProject_ResearchObject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.Project_UserImpl")) {
			return translateOutputProject_User(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.ResearchObjectImpl")) {
			return translateOutputResearchObject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.gfbio.model.impl.ResearchObject_UserImpl")) {
			return translateOutputResearchObject_User(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.SubmissionImpl")) {
			return translateOutputSubmission(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.UserExtensionImpl")) {
			return translateOutputUserExtension(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("org.gfbio.model.impl.UserSSOImpl")) {
			return translateOutputUserSSO(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("org.gfbio.NoSuchBasketException")) {
			return new org.gfbio.NoSuchBasketException();
		}

		if (className.equals("org.gfbio.NoSuchColumnException")) {
			return new org.gfbio.NoSuchColumnException();
		}

		if (className.equals("org.gfbio.NoSuchContentException")) {
			return new org.gfbio.NoSuchContentException();
		}

		if (className.equals("org.gfbio.NoSuchDataProviderException")) {
			return new org.gfbio.NoSuchDataProviderException();
		}

		if (className.equals(
					"org.gfbio.NoSuchDataProvider_PersistentIdentifierException")) {
			return new org.gfbio.NoSuchDataProvider_PersistentIdentifierException();
		}

		if (className.equals(
					"org.gfbio.NoSuchFunding_InstitutionProjectException")) {
			return new org.gfbio.NoSuchFunding_InstitutionProjectException();
		}

		if (className.equals("org.gfbio.NoSuchFunding_PersonProjectException")) {
			return new org.gfbio.NoSuchFunding_PersonProjectException();
		}

		if (className.equals("org.gfbio.NoSuchHeadException")) {
			return new org.gfbio.NoSuchHeadException();
		}

		if (className.equals("org.gfbio.NoSuchPrimaryDataException")) {
			return new org.gfbio.NoSuchPrimaryDataException();
		}

		if (className.equals(
					"org.gfbio.NoSuchPrimaryData_ResearchObjectException")) {
			return new org.gfbio.NoSuchPrimaryData_ResearchObjectException();
		}

		if (className.equals("org.gfbio.NoSuchProjectException")) {
			return new org.gfbio.NoSuchProjectException();
		}

		if (className.equals("org.gfbio.NoSuchProject_ResearchObjectException")) {
			return new org.gfbio.NoSuchProject_ResearchObjectException();
		}

		if (className.equals("org.gfbio.NoSuchProject_UserException")) {
			return new org.gfbio.NoSuchProject_UserException();
		}

		if (className.equals("org.gfbio.NoSuchResearchObjectException")) {
			return new org.gfbio.NoSuchResearchObjectException();
		}

		if (className.equals("org.gfbio.NoSuchResearchObject_UserException")) {
			return new org.gfbio.NoSuchResearchObject_UserException();
		}

		if (className.equals("org.gfbio.NoSuchSubmissionException")) {
			return new org.gfbio.NoSuchSubmissionException();
		}

		if (className.equals("org.gfbio.NoSuchUserExtensionException")) {
			return new org.gfbio.NoSuchUserExtensionException();
		}

		if (className.equals("org.gfbio.NoSuchUserSSOException")) {
			return new org.gfbio.NoSuchUserSSOException();
		}

		return throwable;
	}

	public static Object translateOutputBasket(BaseModel<?> oldModel) {
		BasketClp newModel = new BasketClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBasketRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputColumn(BaseModel<?> oldModel) {
		ColumnClp newModel = new ColumnClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setColumnRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContent(BaseModel<?> oldModel) {
		ContentClp newModel = new ContentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDataProvider(BaseModel<?> oldModel) {
		DataProviderClp newModel = new DataProviderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDataProviderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDataProvider_PersistentIdentifier(
		BaseModel<?> oldModel) {
		DataProvider_PersistentIdentifierClp newModel = new DataProvider_PersistentIdentifierClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDataProvider_PersistentIdentifierRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFunding_InstitutionProject(
		BaseModel<?> oldModel) {
		Funding_InstitutionProjectClp newModel = new Funding_InstitutionProjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFunding_InstitutionProjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFunding_PersonProject(
		BaseModel<?> oldModel) {
		Funding_PersonProjectClp newModel = new Funding_PersonProjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFunding_PersonProjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHead(BaseModel<?> oldModel) {
		HeadClp newModel = new HeadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHeadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPrimaryData(BaseModel<?> oldModel) {
		PrimaryDataClp newModel = new PrimaryDataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPrimaryDataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPrimaryData_ResearchObject(
		BaseModel<?> oldModel) {
		PrimaryData_ResearchObjectClp newModel = new PrimaryData_ResearchObjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPrimaryData_ResearchObjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProject(BaseModel<?> oldModel) {
		ProjectClp newModel = new ProjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProject_ResearchObject(
		BaseModel<?> oldModel) {
		Project_ResearchObjectClp newModel = new Project_ResearchObjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProject_ResearchObjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProject_User(BaseModel<?> oldModel) {
		Project_UserClp newModel = new Project_UserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProject_UserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResearchObject(BaseModel<?> oldModel) {
		ResearchObjectClp newModel = new ResearchObjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setResearchObjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResearchObject_User(
		BaseModel<?> oldModel) {
		ResearchObject_UserClp newModel = new ResearchObject_UserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setResearchObject_UserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubmission(BaseModel<?> oldModel) {
		SubmissionClp newModel = new SubmissionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubmissionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserExtension(BaseModel<?> oldModel) {
		UserExtensionClp newModel = new UserExtensionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserExtensionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserSSO(BaseModel<?> oldModel) {
		UserSSOClp newModel = new UserSSOClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserSSORemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}