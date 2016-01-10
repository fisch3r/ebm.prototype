package com.exxeta.ebm.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.exxeta.ebm.database.entities.Beacon;

public interface BeaconRepository extends CrudRepository<Beacon, Long> {
	
	Page<Beacon> findAll(Pageable pageable);
	
	Beacon findByUuid(String uuid);
	
	Page<Beacon> findByType(String type, Pageable pageable);

}
