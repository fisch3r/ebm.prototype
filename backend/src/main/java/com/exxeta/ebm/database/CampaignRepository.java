package com.exxeta.ebm.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.exxeta.ebm.database.entities.Campaign;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {
	
	Page<Campaign> findAll(Pageable pageable);
	
	Campaign findByCampaignName(String campaignName);
	
	Page<Campaign> findByCustomer(String customer, Pageable pageable);
	
	//Page<Campaign> findByOngoing(String startDate, String endDate, Pageable pageable);

}
