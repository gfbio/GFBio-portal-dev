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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import org.gfbio.model.UserExtension;

import org.gfbio.service.UserExtensionService;
import org.gfbio.service.persistence.BasketPersistence;
import org.gfbio.service.persistence.ColumnPersistence;
import org.gfbio.service.persistence.HeadFinder;
import org.gfbio.service.persistence.HeadPersistence;
import org.gfbio.service.persistence.PositionFinder;
import org.gfbio.service.persistence.PositionPersistence;
import org.gfbio.service.persistence.ProjectPersistence;
import org.gfbio.service.persistence.Project_ResearchObjectPersistence;
import org.gfbio.service.persistence.Project_UserPersistence;
import org.gfbio.service.persistence.Project_User_PIPersistence;
import org.gfbio.service.persistence.ResearchObjectPersistence;
import org.gfbio.service.persistence.UserExtensionPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the user extension remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.gfbio.service.impl.UserExtensionServiceImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.impl.UserExtensionServiceImpl
 * @see org.gfbio.service.UserExtensionServiceUtil
 * @generated
 */
public abstract class UserExtensionServiceBaseImpl extends BaseServiceImpl
	implements UserExtensionService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.gfbio.service.UserExtensionServiceUtil} to access the user extension remote service.
	 */

	/**
	 * Returns the basket local service.
	 *
	 * @return the basket local service
	 */
	public org.gfbio.service.BasketLocalService getBasketLocalService() {
		return basketLocalService;
	}

	/**
	 * Sets the basket local service.
	 *
	 * @param basketLocalService the basket local service
	 */
	public void setBasketLocalService(
		org.gfbio.service.BasketLocalService basketLocalService) {
		this.basketLocalService = basketLocalService;
	}

	/**
	 * Returns the basket remote service.
	 *
	 * @return the basket remote service
	 */
	public org.gfbio.service.BasketService getBasketService() {
		return basketService;
	}

	/**
	 * Sets the basket remote service.
	 *
	 * @param basketService the basket remote service
	 */
	public void setBasketService(org.gfbio.service.BasketService basketService) {
		this.basketService = basketService;
	}

	/**
	 * Returns the basket persistence.
	 *
	 * @return the basket persistence
	 */
	public BasketPersistence getBasketPersistence() {
		return basketPersistence;
	}

	/**
	 * Sets the basket persistence.
	 *
	 * @param basketPersistence the basket persistence
	 */
	public void setBasketPersistence(BasketPersistence basketPersistence) {
		this.basketPersistence = basketPersistence;
	}

	/**
	 * Returns the column local service.
	 *
	 * @return the column local service
	 */
	public org.gfbio.service.ColumnLocalService getColumnLocalService() {
		return columnLocalService;
	}

	/**
	 * Sets the column local service.
	 *
	 * @param columnLocalService the column local service
	 */
	public void setColumnLocalService(
		org.gfbio.service.ColumnLocalService columnLocalService) {
		this.columnLocalService = columnLocalService;
	}

	/**
	 * Returns the column remote service.
	 *
	 * @return the column remote service
	 */
	public org.gfbio.service.ColumnService getColumnService() {
		return columnService;
	}

	/**
	 * Sets the column remote service.
	 *
	 * @param columnService the column remote service
	 */
	public void setColumnService(org.gfbio.service.ColumnService columnService) {
		this.columnService = columnService;
	}

	/**
	 * Returns the column persistence.
	 *
	 * @return the column persistence
	 */
	public ColumnPersistence getColumnPersistence() {
		return columnPersistence;
	}

	/**
	 * Sets the column persistence.
	 *
	 * @param columnPersistence the column persistence
	 */
	public void setColumnPersistence(ColumnPersistence columnPersistence) {
		this.columnPersistence = columnPersistence;
	}

	/**
	 * Returns the head local service.
	 *
	 * @return the head local service
	 */
	public org.gfbio.service.HeadLocalService getHeadLocalService() {
		return headLocalService;
	}

	/**
	 * Sets the head local service.
	 *
	 * @param headLocalService the head local service
	 */
	public void setHeadLocalService(
		org.gfbio.service.HeadLocalService headLocalService) {
		this.headLocalService = headLocalService;
	}

	/**
	 * Returns the head remote service.
	 *
	 * @return the head remote service
	 */
	public org.gfbio.service.HeadService getHeadService() {
		return headService;
	}

	/**
	 * Sets the head remote service.
	 *
	 * @param headService the head remote service
	 */
	public void setHeadService(org.gfbio.service.HeadService headService) {
		this.headService = headService;
	}

	/**
	 * Returns the head persistence.
	 *
	 * @return the head persistence
	 */
	public HeadPersistence getHeadPersistence() {
		return headPersistence;
	}

	/**
	 * Sets the head persistence.
	 *
	 * @param headPersistence the head persistence
	 */
	public void setHeadPersistence(HeadPersistence headPersistence) {
		this.headPersistence = headPersistence;
	}

	/**
	 * Returns the head finder.
	 *
	 * @return the head finder
	 */
	public HeadFinder getHeadFinder() {
		return headFinder;
	}

	/**
	 * Sets the head finder.
	 *
	 * @param headFinder the head finder
	 */
	public void setHeadFinder(HeadFinder headFinder) {
		this.headFinder = headFinder;
	}

	/**
	 * Returns the position local service.
	 *
	 * @return the position local service
	 */
	public org.gfbio.service.PositionLocalService getPositionLocalService() {
		return positionLocalService;
	}

	/**
	 * Sets the position local service.
	 *
	 * @param positionLocalService the position local service
	 */
	public void setPositionLocalService(
		org.gfbio.service.PositionLocalService positionLocalService) {
		this.positionLocalService = positionLocalService;
	}

	/**
	 * Returns the position remote service.
	 *
	 * @return the position remote service
	 */
	public org.gfbio.service.PositionService getPositionService() {
		return positionService;
	}

	/**
	 * Sets the position remote service.
	 *
	 * @param positionService the position remote service
	 */
	public void setPositionService(
		org.gfbio.service.PositionService positionService) {
		this.positionService = positionService;
	}

	/**
	 * Returns the position persistence.
	 *
	 * @return the position persistence
	 */
	public PositionPersistence getPositionPersistence() {
		return positionPersistence;
	}

	/**
	 * Sets the position persistence.
	 *
	 * @param positionPersistence the position persistence
	 */
	public void setPositionPersistence(PositionPersistence positionPersistence) {
		this.positionPersistence = positionPersistence;
	}

	/**
	 * Returns the position finder.
	 *
	 * @return the position finder
	 */
	public PositionFinder getPositionFinder() {
		return positionFinder;
	}

	/**
	 * Sets the position finder.
	 *
	 * @param positionFinder the position finder
	 */
	public void setPositionFinder(PositionFinder positionFinder) {
		this.positionFinder = positionFinder;
	}

	/**
	 * Returns the project local service.
	 *
	 * @return the project local service
	 */
	public org.gfbio.service.ProjectLocalService getProjectLocalService() {
		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(
		org.gfbio.service.ProjectLocalService projectLocalService) {
		this.projectLocalService = projectLocalService;
	}

	/**
	 * Returns the project remote service.
	 *
	 * @return the project remote service
	 */
	public org.gfbio.service.ProjectService getProjectService() {
		return projectService;
	}

	/**
	 * Sets the project remote service.
	 *
	 * @param projectService the project remote service
	 */
	public void setProjectService(
		org.gfbio.service.ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * Returns the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
	}

	/**
	 * Returns the project_ research object local service.
	 *
	 * @return the project_ research object local service
	 */
	public org.gfbio.service.Project_ResearchObjectLocalService getProject_ResearchObjectLocalService() {
		return project_ResearchObjectLocalService;
	}

	/**
	 * Sets the project_ research object local service.
	 *
	 * @param project_ResearchObjectLocalService the project_ research object local service
	 */
	public void setProject_ResearchObjectLocalService(
		org.gfbio.service.Project_ResearchObjectLocalService project_ResearchObjectLocalService) {
		this.project_ResearchObjectLocalService = project_ResearchObjectLocalService;
	}

	/**
	 * Returns the project_ research object remote service.
	 *
	 * @return the project_ research object remote service
	 */
	public org.gfbio.service.Project_ResearchObjectService getProject_ResearchObjectService() {
		return project_ResearchObjectService;
	}

	/**
	 * Sets the project_ research object remote service.
	 *
	 * @param project_ResearchObjectService the project_ research object remote service
	 */
	public void setProject_ResearchObjectService(
		org.gfbio.service.Project_ResearchObjectService project_ResearchObjectService) {
		this.project_ResearchObjectService = project_ResearchObjectService;
	}

	/**
	 * Returns the project_ research object persistence.
	 *
	 * @return the project_ research object persistence
	 */
	public Project_ResearchObjectPersistence getProject_ResearchObjectPersistence() {
		return project_ResearchObjectPersistence;
	}

	/**
	 * Sets the project_ research object persistence.
	 *
	 * @param project_ResearchObjectPersistence the project_ research object persistence
	 */
	public void setProject_ResearchObjectPersistence(
		Project_ResearchObjectPersistence project_ResearchObjectPersistence) {
		this.project_ResearchObjectPersistence = project_ResearchObjectPersistence;
	}

	/**
	 * Returns the project_ user local service.
	 *
	 * @return the project_ user local service
	 */
	public org.gfbio.service.Project_UserLocalService getProject_UserLocalService() {
		return project_UserLocalService;
	}

	/**
	 * Sets the project_ user local service.
	 *
	 * @param project_UserLocalService the project_ user local service
	 */
	public void setProject_UserLocalService(
		org.gfbio.service.Project_UserLocalService project_UserLocalService) {
		this.project_UserLocalService = project_UserLocalService;
	}

	/**
	 * Returns the project_ user remote service.
	 *
	 * @return the project_ user remote service
	 */
	public org.gfbio.service.Project_UserService getProject_UserService() {
		return project_UserService;
	}

	/**
	 * Sets the project_ user remote service.
	 *
	 * @param project_UserService the project_ user remote service
	 */
	public void setProject_UserService(
		org.gfbio.service.Project_UserService project_UserService) {
		this.project_UserService = project_UserService;
	}

	/**
	 * Returns the project_ user persistence.
	 *
	 * @return the project_ user persistence
	 */
	public Project_UserPersistence getProject_UserPersistence() {
		return project_UserPersistence;
	}

	/**
	 * Sets the project_ user persistence.
	 *
	 * @param project_UserPersistence the project_ user persistence
	 */
	public void setProject_UserPersistence(
		Project_UserPersistence project_UserPersistence) {
		this.project_UserPersistence = project_UserPersistence;
	}

	/**
	 * Returns the project_ user_ p i local service.
	 *
	 * @return the project_ user_ p i local service
	 */
	public org.gfbio.service.Project_User_PILocalService getProject_User_PILocalService() {
		return project_User_PILocalService;
	}

	/**
	 * Sets the project_ user_ p i local service.
	 *
	 * @param project_User_PILocalService the project_ user_ p i local service
	 */
	public void setProject_User_PILocalService(
		org.gfbio.service.Project_User_PILocalService project_User_PILocalService) {
		this.project_User_PILocalService = project_User_PILocalService;
	}

	/**
	 * Returns the project_ user_ p i remote service.
	 *
	 * @return the project_ user_ p i remote service
	 */
	public org.gfbio.service.Project_User_PIService getProject_User_PIService() {
		return project_User_PIService;
	}

	/**
	 * Sets the project_ user_ p i remote service.
	 *
	 * @param project_User_PIService the project_ user_ p i remote service
	 */
	public void setProject_User_PIService(
		org.gfbio.service.Project_User_PIService project_User_PIService) {
		this.project_User_PIService = project_User_PIService;
	}

	/**
	 * Returns the project_ user_ p i persistence.
	 *
	 * @return the project_ user_ p i persistence
	 */
	public Project_User_PIPersistence getProject_User_PIPersistence() {
		return project_User_PIPersistence;
	}

	/**
	 * Sets the project_ user_ p i persistence.
	 *
	 * @param project_User_PIPersistence the project_ user_ p i persistence
	 */
	public void setProject_User_PIPersistence(
		Project_User_PIPersistence project_User_PIPersistence) {
		this.project_User_PIPersistence = project_User_PIPersistence;
	}

	/**
	 * Returns the research object local service.
	 *
	 * @return the research object local service
	 */
	public org.gfbio.service.ResearchObjectLocalService getResearchObjectLocalService() {
		return researchObjectLocalService;
	}

	/**
	 * Sets the research object local service.
	 *
	 * @param researchObjectLocalService the research object local service
	 */
	public void setResearchObjectLocalService(
		org.gfbio.service.ResearchObjectLocalService researchObjectLocalService) {
		this.researchObjectLocalService = researchObjectLocalService;
	}

	/**
	 * Returns the research object remote service.
	 *
	 * @return the research object remote service
	 */
	public org.gfbio.service.ResearchObjectService getResearchObjectService() {
		return researchObjectService;
	}

	/**
	 * Sets the research object remote service.
	 *
	 * @param researchObjectService the research object remote service
	 */
	public void setResearchObjectService(
		org.gfbio.service.ResearchObjectService researchObjectService) {
		this.researchObjectService = researchObjectService;
	}

	/**
	 * Returns the research object persistence.
	 *
	 * @return the research object persistence
	 */
	public ResearchObjectPersistence getResearchObjectPersistence() {
		return researchObjectPersistence;
	}

	/**
	 * Sets the research object persistence.
	 *
	 * @param researchObjectPersistence the research object persistence
	 */
	public void setResearchObjectPersistence(
		ResearchObjectPersistence researchObjectPersistence) {
		this.researchObjectPersistence = researchObjectPersistence;
	}

	/**
	 * Returns the user extension local service.
	 *
	 * @return the user extension local service
	 */
	public org.gfbio.service.UserExtensionLocalService getUserExtensionLocalService() {
		return userExtensionLocalService;
	}

	/**
	 * Sets the user extension local service.
	 *
	 * @param userExtensionLocalService the user extension local service
	 */
	public void setUserExtensionLocalService(
		org.gfbio.service.UserExtensionLocalService userExtensionLocalService) {
		this.userExtensionLocalService = userExtensionLocalService;
	}

	/**
	 * Returns the user extension remote service.
	 *
	 * @return the user extension remote service
	 */
	public org.gfbio.service.UserExtensionService getUserExtensionService() {
		return userExtensionService;
	}

	/**
	 * Sets the user extension remote service.
	 *
	 * @param userExtensionService the user extension remote service
	 */
	public void setUserExtensionService(
		org.gfbio.service.UserExtensionService userExtensionService) {
		this.userExtensionService = userExtensionService;
	}

	/**
	 * Returns the user extension persistence.
	 *
	 * @return the user extension persistence
	 */
	public UserExtensionPersistence getUserExtensionPersistence() {
		return userExtensionPersistence;
	}

	/**
	 * Sets the user extension persistence.
	 *
	 * @param userExtensionPersistence the user extension persistence
	 */
	public void setUserExtensionPersistence(
		UserExtensionPersistence userExtensionPersistence) {
		this.userExtensionPersistence = userExtensionPersistence;
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
		return UserExtension.class;
	}

	protected String getModelClassName() {
		return UserExtension.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = userExtensionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.gfbio.service.BasketLocalService.class)
	protected org.gfbio.service.BasketLocalService basketLocalService;
	@BeanReference(type = org.gfbio.service.BasketService.class)
	protected org.gfbio.service.BasketService basketService;
	@BeanReference(type = BasketPersistence.class)
	protected BasketPersistence basketPersistence;
	@BeanReference(type = org.gfbio.service.ColumnLocalService.class)
	protected org.gfbio.service.ColumnLocalService columnLocalService;
	@BeanReference(type = org.gfbio.service.ColumnService.class)
	protected org.gfbio.service.ColumnService columnService;
	@BeanReference(type = ColumnPersistence.class)
	protected ColumnPersistence columnPersistence;
	@BeanReference(type = org.gfbio.service.HeadLocalService.class)
	protected org.gfbio.service.HeadLocalService headLocalService;
	@BeanReference(type = org.gfbio.service.HeadService.class)
	protected org.gfbio.service.HeadService headService;
	@BeanReference(type = HeadPersistence.class)
	protected HeadPersistence headPersistence;
	@BeanReference(type = HeadFinder.class)
	protected HeadFinder headFinder;
	@BeanReference(type = org.gfbio.service.PositionLocalService.class)
	protected org.gfbio.service.PositionLocalService positionLocalService;
	@BeanReference(type = org.gfbio.service.PositionService.class)
	protected org.gfbio.service.PositionService positionService;
	@BeanReference(type = PositionPersistence.class)
	protected PositionPersistence positionPersistence;
	@BeanReference(type = PositionFinder.class)
	protected PositionFinder positionFinder;
	@BeanReference(type = org.gfbio.service.ProjectLocalService.class)
	protected org.gfbio.service.ProjectLocalService projectLocalService;
	@BeanReference(type = org.gfbio.service.ProjectService.class)
	protected org.gfbio.service.ProjectService projectService;
	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;
	@BeanReference(type = org.gfbio.service.Project_ResearchObjectLocalService.class)
	protected org.gfbio.service.Project_ResearchObjectLocalService project_ResearchObjectLocalService;
	@BeanReference(type = org.gfbio.service.Project_ResearchObjectService.class)
	protected org.gfbio.service.Project_ResearchObjectService project_ResearchObjectService;
	@BeanReference(type = Project_ResearchObjectPersistence.class)
	protected Project_ResearchObjectPersistence project_ResearchObjectPersistence;
	@BeanReference(type = org.gfbio.service.Project_UserLocalService.class)
	protected org.gfbio.service.Project_UserLocalService project_UserLocalService;
	@BeanReference(type = org.gfbio.service.Project_UserService.class)
	protected org.gfbio.service.Project_UserService project_UserService;
	@BeanReference(type = Project_UserPersistence.class)
	protected Project_UserPersistence project_UserPersistence;
	@BeanReference(type = org.gfbio.service.Project_User_PILocalService.class)
	protected org.gfbio.service.Project_User_PILocalService project_User_PILocalService;
	@BeanReference(type = org.gfbio.service.Project_User_PIService.class)
	protected org.gfbio.service.Project_User_PIService project_User_PIService;
	@BeanReference(type = Project_User_PIPersistence.class)
	protected Project_User_PIPersistence project_User_PIPersistence;
	@BeanReference(type = org.gfbio.service.ResearchObjectLocalService.class)
	protected org.gfbio.service.ResearchObjectLocalService researchObjectLocalService;
	@BeanReference(type = org.gfbio.service.ResearchObjectService.class)
	protected org.gfbio.service.ResearchObjectService researchObjectService;
	@BeanReference(type = ResearchObjectPersistence.class)
	protected ResearchObjectPersistence researchObjectPersistence;
	@BeanReference(type = org.gfbio.service.UserExtensionLocalService.class)
	protected org.gfbio.service.UserExtensionLocalService userExtensionLocalService;
	@BeanReference(type = org.gfbio.service.UserExtensionService.class)
	protected org.gfbio.service.UserExtensionService userExtensionService;
	@BeanReference(type = UserExtensionPersistence.class)
	protected UserExtensionPersistence userExtensionPersistence;
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
	private UserExtensionServiceClpInvoker _clpInvoker = new UserExtensionServiceClpInvoker();
}