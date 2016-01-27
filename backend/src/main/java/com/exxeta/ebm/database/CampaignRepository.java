package com.exxeta.ebm.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.exxeta.ebm.database.entities.Campaign;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {
	
	Page<Campaign> findAll(Pageable pageable);
	
	Campaign findById(String id);
	
	Page<Campaign> findByCustomer(String Customer, Pageable pageable);
	
}
