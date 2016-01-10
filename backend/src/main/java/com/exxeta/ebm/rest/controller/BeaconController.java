package com.exxeta.ebm.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exxeta.ebm.database.entities.Beacon;
import com.exxeta.ebm.exceptions.BeaconNotFoundException;
import com.exxeta.ebm.rest.model.BeaconOverviewModel;
import com.exxeta.ebm.service.BeaconService;

@RestController
@RequestMapping("/beacon")
public class BeaconController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BeaconService beaconService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<BeaconOverviewModel> getAllBeacons(@RequestParam(required=false, value="page") Integer page,
    								  @RequestParam(required=false, value="size") Integer size) {
		
		if (page == null && size == null) {
			return beaconService.listAllBeacons();
		} else {
			return beaconService.listBeaconsPaged(page, size);
		}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Beacon> getBeaconById(@PathVariable("id") Long id) {
		Beacon beacon = beaconService.getBeaconData(id);
		if (beacon == null) {
			return new ResponseEntity<Beacon>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Beacon>(beacon, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Beacon> addBeacon(@RequestBody Beacon beacon) {
		if (beacon == null || beacon.getLocation() == null) {
			return new ResponseEntity<Beacon>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Beacon>(beaconService.addNewBeacon(beacon), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Beacon> addBeacon(@PathVariable("id") Long id, @RequestBody Beacon beaconData) {
		if (beaconData == null) {
			return new ResponseEntity<Beacon>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Beacon updatedBeacon = beaconService.updateBeacon(id, beaconData);
			return new ResponseEntity<Beacon>(updatedBeacon, HttpStatus.OK);
		} catch(BeaconNotFoundException e) {
			return new ResponseEntity<Beacon>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Beacon> deleteBeacon(@PathVariable("id") Long id) {
		try {
			beaconService.deleteBeacon(id);
			return new ResponseEntity<Beacon>(HttpStatus.OK);
		} catch (BeaconNotFoundException e) {
			return new ResponseEntity<Beacon>(HttpStatus.NOT_FOUND);
		}
	}

}
