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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import org.gfbio.model.SearchFeedback;

import org.gfbio.service.SearchFeedbackService;
import org.gfbio.service.persistence.SearchFeedbackPersistence;
import org.gfbio.service.persistence.SearchHistoryPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the search feedback remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.gfbio.service.impl.SearchFeedbackServiceImpl}.
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see org.gfbio.service.impl.SearchFeedbackServiceImpl
 * @see org.gfbio.service.SearchFeedbackServiceUtil
 * @generated
 */
public abstract class SearchFeedbackServiceBaseImpl extends BaseServiceImpl
	implements SearchFeedbackService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.gfbio.service.SearchFeedbackServiceUtil} to access the search feedback remote service.
	 */

	/**
	 * Returns the search feedback local service.
	 *
	 * @return the search feedback local service
	 */
	public org.gfbio.service.SearchFeedbackLocalService getSearchFeedbackLocalService() {
		return searchFeedbackLocalService;
	}

	/**
	 * Sets the search feedback local service.
	 *
	 * @param searchFeedbackLocalService the search feedback local service
	 */
	public void setSearchFeedbackLocalService(
		org.gfbio.service.SearchFeedbackLocalService searchFeedbackLocalService) {
		this.searchFeedbackLocalService = searchFeedbackLocalService;
	}

	/**
	 * Returns the search feedback remote service.
	 *
	 * @return the search feedback remote service
	 */
	public org.gfbio.service.SearchFeedbackService getSearchFeedbackService() {
		return searchFeedbackService;
	}

	/**
	 * Sets the search feedback remote service.
	 *
	 * @param searchFeedbackService the search feedback remote service
	 */
	public void setSearchFeedbackService(
		org.gfbio.service.SearchFeedbackService searchFeedbackService) {
		this.searchFeedbackService = searchFeedbackService;
	}

	/**
	 * Returns the search feedback persistence.
	 *
	 * @return the search feedback persistence
	 */
	public SearchFeedbackPersistence getSearchFeedbackPersistence() {
		return searchFeedbackPersistence;
	}

	/**
	 * Sets the search feedback persistence.
	 *
	 * @param searchFeedbackPersistence the search feedback persistence
	 */
	public void setSearchFeedbackPersistence(
		SearchFeedbackPersistence searchFeedbackPersistence) {
		this.searchFeedbackPersistence = searchFeedbackPersistence;
	}

	/**
	 * Returns the search history local service.
	 *
	 * @return the search history local service
	 */
	public org.gfbio.service.SearchHistoryLocalService getSearchHistoryLocalService() {
		return searchHistoryLocalService;
	}

	/**
	 * Sets the search history local service.
	 *
	 * @param searchHistoryLocalService the search history local service
	 */
	public void setSearchHistoryLocalService(
		org.gfbio.service.SearchHistoryLocalService searchHistoryLocalService) {
		this.searchHistoryLocalService = searchHistoryLocalService;
	}

	/**
	 * Returns the search history remote service.
	 *
	 * @return the search history remote service
	 */
	public org.gfbio.service.SearchHistoryService getSearchHistoryService() {
		return searchHistoryService;
	}

	/**
	 * Sets the search history remote service.
	 *
	 * @param searchHistoryService the search history remote service
	 */
	public void setSearchHistoryService(
		org.gfbio.service.SearchHistoryService searchHistoryService) {
		this.searchHistoryService = searchHistoryService;
	}

	/**
	 * Returns the search history persistence.
	 *
	 * @return the search history persistence
	 */
	public SearchHistoryPersistence getSearchHistoryPersistence() {
		return searchHistoryPersistence;
	}

	/**
	 * Sets the search history persistence.
	 *
	 * @param searchHistoryPersistence the search history persistence
	 */
	public void setSearchHistoryPersistence(
		SearchHistoryPersistence searchHistoryPersistence) {
		this.searchHistoryPersistence = searchHistoryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SearchFeedback.class;
	}

	protected String getModelClassName() {
		return SearchFeedback.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = searchFeedbackPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.gfbio.service.SearchFeedbackLocalService.class)
	protected org.gfbio.service.SearchFeedbackLocalService searchFeedbackLocalService;
	@BeanReference(type = org.gfbio.service.SearchFeedbackService.class)
	protected org.gfbio.service.SearchFeedbackService searchFeedbackService;
	@BeanReference(type = SearchFeedbackPersistence.class)
	protected SearchFeedbackPersistence searchFeedbackPersistence;
	@BeanReference(type = org.gfbio.service.SearchHistoryLocalService.class)
	protected org.gfbio.service.SearchHistoryLocalService searchHistoryLocalService;
	@BeanReference(type = org.gfbio.service.SearchHistoryService.class)
	protected org.gfbio.service.SearchHistoryService searchHistoryService;
	@BeanReference(type = SearchHistoryPersistence.class)
	protected SearchHistoryPersistence searchHistoryPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SearchFeedbackServiceClpInvoker _clpInvoker = new SearchFeedbackServiceClpInvoker();
}