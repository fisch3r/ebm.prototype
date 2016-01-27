package com.exxeta.ebm.rest.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.exxeta.ebm.database.entities.Campaign;
import com.exxeta.ebm.rest.model.CampaignOverviewModel;


@Component
public class CampaignOverviewModelConverter {
	
	public List<CampaignOverviewModel> toOverviewModel(Iterable<Campaign> campaigns) {
		if (campaigns == null) {
			return new ArrayList<CampaignOverviewModel>();
		}
		
		List<CampaignOverviewModel> campaignList = new ArrayList<CampaignOverviewModel>();
		
		for (Campaign campaign: campaigns) {
			if (campaign == null) {
				continue;
			}
			campaignList.add(toCampaignOverviewModel(campaign));
		}
		
		return campaignList;
	}
	
	
	private CampaignOverviewModel toCampaignOverviewModel(Campaign campaign) {
		if (campaign == null) {
			return null;
		}
		
		return new CampaignOverviewModel(String.valueOf(campaign.getId()), campaign.getCustomer(), campaign.getCampaignName(), campaign.getStartDate(), campaign.getEndDate());
	}

	
}
