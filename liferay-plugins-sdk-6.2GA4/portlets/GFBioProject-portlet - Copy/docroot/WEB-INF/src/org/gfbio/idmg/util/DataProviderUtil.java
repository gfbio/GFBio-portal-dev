package org.gfbio.idmg.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.model.DataProvider;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.json.simple.JSONArray;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DataProviderUtil {

	private static Log _log = LogFactoryUtil.getLog(ContentUtil.class);
	
	/*
	 * Set recommended datacenters in consideration of the radio input selection
	 * which was made
	 */
	public static List<DataProvider> setRecommendedProviders(String physicalInput, String taxonInput, String aliveInput,
			String sequencedInput) {

		List<DataProvider> tempProviders = getDataProviders();
		List<DataProvider> recommendedProviders = new ArrayList<DataProvider>();
		for (DataProvider dp : tempProviders) {
			recommendedProviders.add(dp);
		}
		// List<DataProvider> allProviders = getDataProviders();
		boolean physical;
		boolean taxon;
		boolean alive;
		boolean sequenced;

		if (physicalInput != null) {
			physical = Boolean.valueOf(physicalInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (physical) {
					if (!p.getPhysicalobjectpossible()) {
						providersToDelete.add(p);
					}
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}

		if (taxonInput != null) {
			taxon = Boolean.valueOf(taxonInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (taxon) {
					if (p.getTaxonbased() != taxon) {
						providersToDelete.add(p);
					}
				} else {
					if (p.getNotaxonbased() == taxon) {
						providersToDelete.add(p);
					}
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}
		if (aliveInput != null) {
			alive = Boolean.valueOf(aliveInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (alive) {
					if (p.getLivingobjects() != alive) {
						providersToDelete.add(p);
					}
				} else {
					if (p.getDeadobjects() == alive) {
						providersToDelete.add(p);
					}
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}
		if (sequencedInput != null) {
			sequenced = Boolean.valueOf(sequencedInput);
			List<DataProvider> providersToDelete = new ArrayList<DataProvider>();
			for (DataProvider p : recommendedProviders) {
				if (p.getSequencedata() != sequenced) {
					providersToDelete.add(p);
				}
			}
			if (!providersToDelete.isEmpty()) {
				recommendedProviders.removeAll(providersToDelete);
			}
		}

		return recommendedProviders;
	}

	/*
	 * Set recommended datacenters in consideration of the radio input and
	 * category selection which was made
	 */
	public static List<DataProvider> setRecommendedProvidersWithCategory(String physical, String taxon, String alive,
			String sequenced, String category) {

		JSONArray providerIdList = new JSONArray();

		try {
			long headId = HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_dataprovider");
			long columnId = ColumnLocalServiceUtil.getColumnIdByNames("gfbio_category_dataprovider", "gfbio_category");
			providerIdList = ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(headId, columnId, category);
			
		} catch (NoSuchHeadException | SystemException e) {
			e.printStackTrace();
		}
		
		// Results for Category
		List<DataProvider> providersForCategory = new ArrayList<>();

		for (int i = 0; i < providerIdList.size(); i++) {
			try {
				providersForCategory.add(DataProviderLocalServiceUtil.getDataProvider((long) providerIdList.get(i)));
			} catch (PortalException | SystemException e) {
				_log.error("Something went wrong in DataProviderLocalServiceUtil!", e);
			}
		}
		// Results For Radio-Button Inputs
		List<DataProvider> providersForRadioButtons = setRecommendedProviders(physical, taxon, alive, sequenced);

		List<DataProvider> temp = new ArrayList<>();

		for (DataProvider dp : providersForCategory) {
			if (!providersForRadioButtons.contains(dp)) {
				temp.add(dp);
			}
		}
		providersForCategory.removeAll(temp);
		Collections.sort(providersForCategory);
		return providersForCategory;
	}

	/* Get a list of all datacenters from db */
	private static List<DataProvider> getDataProviders() {
		List<DataProvider> providers = null;

		providers = DataProviderLocalServiceUtil.getDataProviderByProviderType("GFBio Archive");

		return providers;
	}
}
