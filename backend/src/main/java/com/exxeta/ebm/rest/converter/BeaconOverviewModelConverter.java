package com.exxeta.ebm.rest.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.exxeta.ebm.database.entities.Beacon;
import com.exxeta.ebm.database.entities.BeaconLocation;
import com.exxeta.ebm.rest.model.BeaconOverviewModel;

@Component
public class BeaconOverviewModelConverter {
	
	public List<BeaconOverviewModel> toOverviewModel(Iterable<Beacon> beacons) {
		if (beacons == null) {
			return new ArrayList<BeaconOverviewModel>();
		}
		
		List<BeaconOverviewModel> beaconList = new ArrayList<BeaconOverviewModel>();
		
		for (Beacon beacon: beacons) {
			if (beacon == null) {
				continue;
			}
			beaconList.add(toBeaconOverviewModel(beacon));
		}
		
		return beaconList;
	}
	
	private BeaconOverviewModel toBeaconOverviewModel(Beacon beacon) {
		if (beacon == null) {
			return null;
		}
		
		BeaconLocation location = beacon.getLocation();
		String address = String.format("%s %s, %s", location.getZipCode(), location.getCity(), location.getCountry());
		if (location.getLat() != null && location.getLng() != null) {
			return new BeaconOverviewModel(String.valueOf(beacon.getId()), beacon.getUuid(), beacon.getType(), address, location.getLat(), location.getLng());
		}
		return new BeaconOverviewModel(String.valueOf(beacon.getId()), beacon.getUuid(), beacon.getType(), address);
	}

}
