package com.exxeta.ebm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exxeta.ebm.database.BeaconLocationRepository;
import com.exxeta.ebm.database.BeaconRepository;
import com.exxeta.ebm.database.CampaignRepository;
import com.exxeta.ebm.database.entities.Beacon;
import com.exxeta.ebm.database.entities.Campaign;
import com.exxeta.ebm.database.entities.BeaconLocation;
import com.exxeta.ebm.exceptions.BeaconNotFoundException;
import com.exxeta.ebm.rest.converter.BeaconOverviewModelConverter;
import com.exxeta.ebm.rest.model.BeaconOverviewModel;

@Service
public class BeaconService {
	
	@Autowired
	private BeaconRepository beaconRepository;
	
	@Autowired
	private BeaconLocationRepository beaconLocationRepository;
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Autowired 
	private BeaconOverviewModelConverter beaconOverviewConverter;
	
	public List<BeaconOverviewModel> listAllBeacons() {
		return beaconOverviewConverter.toOverviewModel(beaconRepository.findAll());
	}
	
	public List<BeaconOverviewModel> listBeaconsPaged(int page, int size) {
		Page<Beacon> beaconPage = beaconRepository.findAll(new PageRequest(page, size));
		return beaconOverviewConverter.toOverviewModel(beaconPage.getContent());
	}
	
	public Beacon getBeaconData(Long id) {
		return beaconRepository.findOne(id);
	}
	
	@Transactional
	public Beacon addNewBeacon(Beacon beaconData) {
		Campaign storedCampaign = campaignRepository.save(beaconData.getCampaign());
		beaconData.setCampaign(storedCampaign);
		
		BeaconLocation storedLocation = beaconLocationRepository.save(beaconData.getLocation());
		beaconData.setLocation(storedLocation);
		
		return beaconRepository.save(beaconData);
	}
	
	@Transactional
	public Beacon updateBeacon(Long id, Beacon beaconData) {
		Beacon beaconToUpdate = beaconRepository.findOne(id);
		if (beaconToUpdate == null) {
			throw new BeaconNotFoundException();
		}
		
		beaconToUpdate.setType(beaconData.getType());
		beaconToUpdate.setUuid(beaconData.getUuid());
		beaconToUpdate.setReferenceId(beaconData.getReferenceId());
		
		if (beaconData.getLocation() != null) {
			beaconToUpdate.getLocation().setStreet(beaconData.getLocation().getStreet());
			beaconToUpdate.getLocation().setHouseNumber(beaconData.getLocation().getHouseNumber());
			beaconToUpdate.getLocation().setZipCode(beaconData.getLocation().getZipCode());
			beaconToUpdate.getLocation().setCity(beaconData.getLocation().getCity());
			beaconToUpdate.getLocation().setCountry(beaconData.getLocation().getCountry());
			beaconToUpdate.getLocation().setLat(beaconData.getLocation().getLat());
			beaconToUpdate.getLocation().setLng(beaconData.getLocation().getLng());
		}
		
		if (beaconData.getCampaign() != null) {
			beaconToUpdate.getCampaign().setCustomer(beaconData.getCampaign().getCustomer());
			beaconToUpdate.getCampaign().setCampaignName(beaconData.getCampaign().getCampaignName());
			beaconToUpdate.getCampaign().setStartDate(beaconData.getCampaign().getStartDate());
			beaconToUpdate.getCampaign().setEndDate(beaconData.getCampaign().getEndDate());
		}
		
		return beaconRepository.save(beaconToUpdate);
	}
	
	@Transactional
	public void deleteBeacon(Long id) {
		try {
			beaconRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BeaconNotFoundException();
		}
	}
	

}
