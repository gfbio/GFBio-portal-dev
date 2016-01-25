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

package org.gfbio.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.gfbio.service.BasketLocalServiceUtil;
import org.gfbio.service.BasketServiceUtil;
import org.gfbio.service.ClpSerializer;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ColumnServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.ContentServiceUtil;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.DataProviderServiceUtil;
import org.gfbio.service.DataProvider_PersistentIdentifierLocalServiceUtil;
import org.gfbio.service.DataProvider_PersistentIdentifierServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.HeadServiceUtil;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.ProjectServiceUtil;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.Project_ResearchObjectServiceUtil;
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.Project_UserServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.SubmissionServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.UserExtensionServiceUtil;

/**
 * @author Marcel Froemming
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			BasketLocalServiceUtil.clearService();

			BasketServiceUtil.clearService();
			ColumnLocalServiceUtil.clearService();

			ColumnServiceUtil.clearService();
			ContentLocalServiceUtil.clearService();

			ContentServiceUtil.clearService();
			DataProviderLocalServiceUtil.clearService();

			DataProviderServiceUtil.clearService();
			DataProvider_PersistentIdentifierLocalServiceUtil.clearService();

			DataProvider_PersistentIdentifierServiceUtil.clearService();
			HeadLocalServiceUtil.clearService();

			HeadServiceUtil.clearService();
			ProjectLocalServiceUtil.clearService();

			ProjectServiceUtil.clearService();
			Project_ResearchObjectLocalServiceUtil.clearService();

			Project_ResearchObjectServiceUtil.clearService();
			Project_UserLocalServiceUtil.clearService();

			Project_UserServiceUtil.clearService();
			ResearchObjectLocalServiceUtil.clearService();

			ResearchObjectServiceUtil.clearService();
			SubmissionLocalServiceUtil.clearService();

			SubmissionServiceUtil.clearService();
			UserExtensionLocalServiceUtil.clearService();

			UserExtensionServiceUtil.clearService();
		}
	}
}