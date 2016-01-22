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

import com.exxeta.ebm.database.entities.Campaign;
import com.exxeta.ebm.exceptions.CampaignNotFoundException;
import com.exxeta.ebm.rest.model.CampaignOverviewModel;
import com.exxeta.ebm.service.CampaignService;

@RestController
@RequestMapping("/campaign")
public class CampaignController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<CampaignOverviewModel> getAllCampaigns(@RequestParam(required=false, value="page") Integer page,
    								  @RequestParam(required=false, value="size") Integer size) {
		
		if (page == null && size == null) {
			return campaignService.listAllCampaigns();
		} else {
			return campaignService.listCampaignsPaged(page, size);
		}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Campaign> getCampaignById(@PathVariable("id") Long id) {
		Campaign campaign = campaignService.getCampaignData(id);
		if (campaign == null) {
			return new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Campaign>(campaign, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) {
		if (campaign == null) {
			return new ResponseEntity<Campaign>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Campaign>(campaignService.addNewCampaign(campaign), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Campaign> updateCampaign(@PathVariable("id") Long id, @RequestBody Campaign campaignData) {
		if (campaignData == null) {
			return new ResponseEntity<Campaign>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Campaign updatedCampaign = campaignService.updateCampaign(id, campaignData);
			return new ResponseEntity<Campaign>(updatedCampaign, HttpStatus.OK);
		} catch(CampaignNotFoundException e) {
			return new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Campaign> deleteCampaign(@PathVariable("id") Long id) {
		try {
			campaignService.deleteCampaign(id);
			return new ResponseEntity<Campaign>(HttpStatus.OK);
		} catch (CampaignNotFoundException e) {
			return new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
		}
	}
	
}
