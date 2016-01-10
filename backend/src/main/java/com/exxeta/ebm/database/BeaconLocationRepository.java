package com.exxeta.ebm.database;

import org.springframework.data.repository.CrudRepository;

import com.exxeta.ebm.database.entities.BeaconLocation;

public interface BeaconLocationRepository extends CrudRepository<BeaconLocation, Long> {

}
