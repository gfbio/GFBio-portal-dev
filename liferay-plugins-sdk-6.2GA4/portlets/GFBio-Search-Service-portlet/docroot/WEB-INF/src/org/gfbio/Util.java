package org.gfbio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.gfbio.model.SearchHistory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class Util {



	// ////////////////////////////////////////////////////////////////////////////

	// period = 0 : all time period = 1 : 1 day period = 2 : 2 days period = 10
	// : 1 week period = 20 : 2 weeks period = 100 : 1 month period = 200 : 2
	// months period = 300 : 3 months period = 600 : 6 months period = 1000 : 1
	// year period = 2000 : 2 years period = 3000 : 3 years

	// ////////////////////////////////////////////////////////////////////////////
	public static Date getStartDateFromPeriod(int period) {
		Date date = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (period) {
		case 1:
			cal.add(Calendar.DATE, -1);
			break;
		case 2:
			cal.add(Calendar.DATE, -2);
			break;
		case 10:
			cal.add(Calendar.DATE, -7);
			break;
		case 20:
			cal.add(Calendar.DATE, -14);
			break;
		case 100:
			cal.add(Calendar.MONTH, -1);
			break;
		case 200:
			cal.add(Calendar.MONTH, -2);
			break;
		case 300:
			cal.add(Calendar.MONTH, -3);
			break;
		case 600:
			cal.add(Calendar.MONTH, -6);
			break;
		case 1000:
			cal.add(Calendar.YEAR, -1);
			break;
		case 2000:
			cal.add(Calendar.YEAR, -2);
			break;
		case 3000:
			cal.add(Calendar.YEAR, -3);
			break;
		default:
			cal.add(Calendar.YEAR, -1000);
			break;
		}

		Date startDate = cal.getTime();
		return startDate;
	}
	public static long getLoggedInUserId() {
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			if (null == serviceContext) {
				System.out.println("ServiceContext is unavailable, returning default user");
				long companyId = PortalUtil.getDefaultCompanyId();
				long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
				return defaultUserId;
			}

			return serviceContext.getUserId();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public static boolean isUserAdmin(long userId) {
		boolean isAdmin = false;
		try {
			List<Role> roles;
			roles = RoleLocalServiceUtil.getUserRoles(userId);
			for (Role role : roles) {
				// System.out.println(role.getName());
				if (role.getName().indexOf("Administrator") > -1) {
					isAdmin = true;
					break;
				}
			}
		} catch (SystemException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return isAdmin;
	}
}
