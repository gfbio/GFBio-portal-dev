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

package com.liferay.portal.http.service.internal.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

import org.osgi.service.http.HttpContext;

/**
 * @author Raymond Augé
 * @author Miguel Pastor
 */
public class BundleFilterConfig implements FilterConfig {

	public BundleFilterConfig(
		ServletContext servletContext, String filterName,
		Map<String, String> initParameters, HttpContext httpContext) {

		_servletContext = servletContext;
		_filterName = filterName;
		_initParameters = initParameters;
		_httpContext = httpContext;
	}


	public String getFilterName() {
		return _filterName;
	}

	public HttpContext getHttpContext() {
		return _httpContext;
	}


	public String getInitParameter(String parameter) {
		return _initParameters.get(parameter);
	}


	public Enumeration<String> getInitParameterNames() {
		return Collections.enumeration(_initParameters.keySet());
	}


	public ServletContext getServletContext() {
		return _servletContext;
	}

	private String _filterName;
	private HttpContext _httpContext;
	private Map<String, String> _initParameters;
	private ServletContext _servletContext;

}