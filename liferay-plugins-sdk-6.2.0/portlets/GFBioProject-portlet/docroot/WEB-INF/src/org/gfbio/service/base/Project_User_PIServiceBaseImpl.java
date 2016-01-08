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

import org.gfbio.model.Project_User_PI;

import org.gfbio.service.Project_User_PIService;
import org.gfbio.service.persistence.BasketPersistence;
import org.gfbio.service.persistence.ColumnFinder;
import org.gfbio.service.persistence.ColumnPersistence;
import org.gfbio.service.persistence.ContentFinder;
import org.gfbio.service.persistence.ContentPersistence;
import org.gfbio.service.persistence.DataProviderFinder;
import org.gfbio.service.persistence.DataProviderPersistence;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierFinder;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierPersistence;
import org.gfbio.service.persistence.HeadFinder;
import org.gfbio.service.persistence.HeadPersistence;
import org.gfbio.service.persistence.ProjectPersistence;
import org.gfbio.service.persistence.Project_ResearchObjectFinder;
import org.gfbio.service.persistence.Project_ResearchObjectPersistence;
import org.gfbio.service.persistence.Project_UserPersistence;
import org.gfbio.service.persistence.Project_User_PIPersistence;
import org.gfbio.service.persistence.ResearchObjectFinder;
import org.gfbio.service.persistence.ResearchObjectPersistence;
import org.gfbio.service.persistence.SubmissionFinder;
import org.gfbio.service.persistence.SubmissionPersistence;
import org.gfbio.service.persistence.UserExtensionPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the project_ user_ p i remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.gfbio.service.impl.Project_User_PIServiceImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.impl.Project_User_PIServiceImpl
 * @see org.gfbio.service.Project_User_PIServiceUtil
 * @generated
 */
public abstract class Project_User_PIServiceBaseImpl extends BaseServiceImpl
	implements Project_User_PIService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.gfbio.service.Project_User_PIServiceUtil} to access the project_ user_ p i remote service.
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
	 * Returns the column finder.
	 *
	 * @return the column finder
	 */
	public ColumnFinder getColumnFinder() {
		return columnFinder;
	}

	/**
	 * Sets the column finder.
	 *
	 * @param columnFinder the column finder
	 */
	public void setColumnFinder(ColumnFinder columnFinder) {
		this.columnFinder = columnFinder;
	}

	/**
	 * Returns the content local service.
	 *
	 * @return the content local service
	 */
	public org.gfbio.service.ContentLocalService getContentLocalService() {
		return contentLocalService;
	}

	/**
	 * Sets the content local service.
	 *
	 * @param contentLocalService the content local service
	 */
	public void setContentLocalService(
		org.gfbio.service.ContentLocalService contentLocalService) {
		this.contentLocalService = contentLocalService;
	}

	/**
	 * Returns the content remote service.
	 *
	 * @return the content remote service
	 */
	public org.gfbio.service.ContentService getContentService() {
		return contentService;
	}

	/**
	 * Sets the content remote service.
	 *
	 * @param contentService the content remote service
	 */
	public void setContentService(
		org.gfbio.service.ContentService contentService) {
		this.contentService = contentService;
	}

	/**
	 * Returns the content persistence.
	 *
	 * @return the content persistence
	 */
	public ContentPersistence getContentPersistence() {
		return contentPersistence;
	}

	/**
	 * Sets the content persistence.
	 *
	 * @param contentPersistence the content persistence
	 */
	public void setContentPersistence(ContentPersistence contentPersistence) {
		this.contentPersistence = contentPersistence;
	}

	/**
	 * Returns the content finder.
	 *
	 * @return the content finder
	 */
	public ContentFinder getContentFinder() {
		return contentFinder;
	}

	/**
	 * Sets the content finder.
	 *
	 * @param contentFinder the content finder
	 */
	public void setContentFinder(ContentFinder contentFinder) {
		this.contentFinder = contentFinder;
	}

	/**
	 * Returns the data provider local service.
	 *
	 * @return the data provider local service
	 */
	public org.gfbio.service.DataProviderLocalService getDataProviderLocalService() {
		return dataProviderLocalService;
	}

	/**
	 * Sets the data provider local service.
	 *
	 * @param dataProviderLocalService the data provider local service
	 */
	public void setDataProviderLocalService(
		org.gfbio.service.DataProviderLocalService dataProviderLocalService) {
		this.dataProviderLocalService = dataProviderLocalService;
	}

	/**
	 * Returns the data provider remote service.
	 *
	 * @return the data provider remote service
	 */
	public org.gfbio.service.DataProviderService getDataProviderService() {
		return dataProviderService;
	}

	/**
	 * Sets the data provider remote service.
	 *
	 * @param dataProviderService the data provider remote service
	 */
	public void setDataProviderService(
		org.gfbio.service.DataProviderService dataProviderService) {
		this.dataProviderService = dataProviderService;
	}

	/**
	 * Returns the data provider persistence.
	 *
	 * @return the data provider persistence
	 */
	public DataProviderPersistence getDataProviderPersistence() {
		return dataProviderPersistence;
	}

	/**
	 * Sets the data provider persistence.
	 *
	 * @param dataProviderPersistence the data provider persistence
	 */
	public void setDataProviderPersistence(
		DataProviderPersistence dataProviderPersistence) {
		this.dataProviderPersistence = dataProviderPersistence;
	}

	/**
	 * Returns the data provider finder.
	 *
	 * @return the data provider finder
	 */
	public DataProviderFinder getDataProviderFinder() {
		return dataProviderFinder;
	}

	/**
	 * Sets the data provider finder.
	 *
	 * @param dataProviderFinder the data provider finder
	 */
	public void setDataProviderFinder(DataProviderFinder dataProviderFinder) {
		this.dataProviderFinder = dataProviderFinder;
	}

	/**
	 * Returns the data provider_ persistent identifier local service.
	 *
	 * @return the data provider_ persistent identifier local service
	 */
	public org.gfbio.service.DataProvider_PersistentIdentifierLocalService getDataProvider_PersistentIdentifierLocalService() {
		return dataProvider_PersistentIdentifierLocalService;
	}

	/**
	 * Sets the data provider_ persistent identifier local service.
	 *
	 * @param dataProvider_PersistentIdentifierLocalService the data provider_ persistent identifier local service
	 */
	public void setDataProvider_PersistentIdentifierLocalService(
		org.gfbio.service.DataProvider_PersistentIdentifierLocalService dataProvider_PersistentIdentifierLocalService) {
		this.dataProvider_PersistentIdentifierLocalService = dataProvider_PersistentIdentifierLocalService;
	}

	/**
	 * Returns the data provider_ persistent identifier remote service.
	 *
	 * @return the data provider_ persistent identifier remote service
	 */
	public org.gfbio.service.DataProvider_PersistentIdentifierService getDataProvider_PersistentIdentifierService() {
		return dataProvider_PersistentIdentifierService;
	}

	/**
	 * Sets the data provider_ persistent identifier remote service.
	 *
	 * @param dataProvider_PersistentIdentifierService the data provider_ persistent identifier remote service
	 */
	public void setDataProvider_PersistentIdentifierService(
		org.gfbio.service.DataProvider_PersistentIdentifierService dataProvider_PersistentIdentifierService) {
		this.dataProvider_PersistentIdentifierService = dataProvider_PersistentIdentifierService;
	}

	/**
	 * Returns the data provider_ persistent identifier persistence.
	 *
	 * @return the data provider_ persistent identifier persistence
	 */
	public DataProvider_PersistentIdentifierPersistence getDataProvider_PersistentIdentifierPersistence() {
		return dataProvider_PersistentIdentifierPersistence;
	}

	/**
	 * Sets the data provider_ persistent identifier persistence.
	 *
	 * @param dataProvider_PersistentIdentifierPersistence the data provider_ persistent identifier persistence
	 */
	public void setDataProvider_PersistentIdentifierPersistence(
		DataProvider_PersistentIdentifierPersistence dataProvider_PersistentIdentifierPersistence) {
		this.dataProvider_PersistentIdentifierPersistence = dataProvider_PersistentIdentifierPersistence;
	}

	/**
	 * Returns the data provider_ persistent identifier finder.
	 *
	 * @return the data provider_ persistent identifier finder
	 */
	public DataProvider_PersistentIdentifierFinder getDataProvider_PersistentIdentifierFinder() {
		return dataProvider_PersistentIdentifierFinder;
	}

	/**
	 * Sets the data provider_ persistent identifier finder.
	 *
	 * @param dataProvider_PersistentIdentifierFinder the data provider_ persistent identifier finder
	 */
	public void setDataProvider_PersistentIdentifierFinder(
		DataProvider_PersistentIdentifierFinder dataProvider_PersistentIdentifierFinder) {
		this.dataProvider_PersistentIdentifierFinder = dataProvider_PersistentIdentifierFinder;
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
	 * Returns the project_ research object finder.
	 *
	 * @return the project_ research object finder
	 */
	public Project_ResearchObjectFinder getProject_ResearchObjectFinder() {
		return project_ResearchObjectFinder;
	}

	/**
	 * Sets the project_ research object finder.
	 *
	 * @param project_ResearchObjectFinder the project_ research object finder
	 */
	public void setProject_ResearchObjectFinder(
		Project_ResearchObjectFinder project_ResearchObjectFinder) {
		this.project_ResearchObjectFinder = project_ResearchObjectFinder;
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
	 * Returns the research object finder.
	 *
	 * @return the research object finder
	 */
	public ResearchObjectFinder getResearchObjectFinder() {
		return researchObjectFinder;
	}

	/**
	 * Sets the research object finder.
	 *
	 * @param researchObjectFinder the research object finder
	 */
	public void setResearchObjectFinder(
		ResearchObjectFinder researchObjectFinder) {
		this.researchObjectFinder = researchObjectFinder;
	}

	/**
	 * Returns the submission local service.
	 *
	 * @return the submission local service
	 */
	public org.gfbio.service.SubmissionLocalService getSubmissionLocalService() {
		return submissionLocalService;
	}

	/**
	 * Sets the submission local service.
	 *
	 * @param submissionLocalService the submission local service
	 */
	public void setSubmissionLocalService(
		org.gfbio.service.SubmissionLocalService submissionLocalService) {
		this.submissionLocalService = submissionLocalService;
	}

	/**
	 * Returns the submission remote service.
	 *
	 * @return the submission remote service
	 */
	public org.gfbio.service.SubmissionService getSubmissionService() {
		return submissionService;
	}

	/**
	 * Sets the submission remote service.
	 *
	 * @param submissionService the submission remote service
	 */
	public void setSubmissionService(
		org.gfbio.service.SubmissionService submissionService) {
		this.submissionService = submissionService;
	}

	/**
	 * Returns the submission persistence.
	 *
	 * @return the submission persistence
	 */
	public SubmissionPersistence getSubmissionPersistence() {
		return submissionPersistence;
	}

	/**
	 * Sets the submission persistence.
	 *
	 * @param submissionPersistence the submission persistence
	 */
	public void setSubmissionPersistence(
		SubmissionPersistence submissionPersistence) {
		this.submissionPersistence = submissionPersistence;
	}

	/**
	 * Returns the submission finder.
	 *
	 * @return the submission finder
	 */
	public SubmissionFinder getSubmissionFinder() {
		return submissionFinder;
	}

	/**
	 * Sets the submission finder.
	 *
	 * @param submissionFinder the submission finder
	 */
	public void setSubmissionFinder(SubmissionFinder submissionFinder) {
		this.submissionFinder = submissionFinder;
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
		return Project_User_PI.class;
	}

	protected String getModelClassName() {
		return Project_User_PI.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = project_User_PIPersistence.getDataSource();

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
	@BeanReference(type = ColumnFinder.class)
	protected ColumnFinder columnFinder;
	@BeanReference(type = org.gfbio.service.ContentLocalService.class)
	protected org.gfbio.service.ContentLocalService contentLocalService;
	@BeanReference(type = org.gfbio.service.ContentService.class)
	protected org.gfbio.service.ContentService contentService;
	@BeanReference(type = ContentPersistence.class)
	protected ContentPersistence contentPersistence;
	@BeanReference(type = ContentFinder.class)
	protected ContentFinder contentFinder;
	@BeanReference(type = org.gfbio.service.DataProviderLocalService.class)
	protected org.gfbio.service.DataProviderLocalService dataProviderLocalService;
	@BeanReference(type = org.gfbio.service.DataProviderService.class)
	protected org.gfbio.service.DataProviderService dataProviderService;
	@BeanReference(type = DataProviderPersistence.class)
	protected DataProviderPersistence dataProviderPersistence;
	@BeanReference(type = DataProviderFinder.class)
	protected DataProviderFinder dataProviderFinder;
	@BeanReference(type = org.gfbio.service.DataProvider_PersistentIdentifierLocalService.class)
	protected org.gfbio.service.DataProvider_PersistentIdentifierLocalService dataProvider_PersistentIdentifierLocalService;
	@BeanReference(type = org.gfbio.service.DataProvider_PersistentIdentifierService.class)
	protected org.gfbio.service.DataProvider_PersistentIdentifierService dataProvider_PersistentIdentifierService;
	@BeanReference(type = DataProvider_PersistentIdentifierPersistence.class)
	protected DataProvider_PersistentIdentifierPersistence dataProvider_PersistentIdentifierPersistence;
	@BeanReference(type = DataProvider_PersistentIdentifierFinder.class)
	protected DataProvider_PersistentIdentifierFinder dataProvider_PersistentIdentifierFinder;
	@BeanReference(type = org.gfbio.service.HeadLocalService.class)
	protected org.gfbio.service.HeadLocalService headLocalService;
	@BeanReference(type = org.gfbio.service.HeadService.class)
	protected org.gfbio.service.HeadService headService;
	@BeanReference(type = HeadPersistence.class)
	protected HeadPersistence headPersistence;
	@BeanReference(type = HeadFinder.class)
	protected HeadFinder headFinder;
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
	@BeanReference(type = Project_ResearchObjectFinder.class)
	protected Project_ResearchObjectFinder project_ResearchObjectFinder;
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
	@BeanReference(type = ResearchObjectFinder.class)
	protected ResearchObjectFinder researchObjectFinder;
	@BeanReference(type = org.gfbio.service.SubmissionLocalService.class)
	protected org.gfbio.service.SubmissionLocalService submissionLocalService;
	@BeanReference(type = org.gfbio.service.SubmissionService.class)
	protected org.gfbio.service.SubmissionService submissionService;
	@BeanReference(type = SubmissionPersistence.class)
	protected SubmissionPersistence submissionPersistence;
	@BeanReference(type = SubmissionFinder.class)
	protected SubmissionFinder submissionFinder;
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
	private Project_User_PIServiceClpInvoker _clpInvoker = new Project_User_PIServiceClpInvoker();
}