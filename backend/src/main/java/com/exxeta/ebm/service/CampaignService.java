package com.exxeta.ebm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exxeta.ebm.database.CampaignRepository;
import com.exxeta.ebm.database.entities.Campaign;
import com.exxeta.ebm.exceptions.CampaignNotFoundException;
import com.exxeta.ebm.rest.converter.CampaignOverviewModelConverter;
import com.exxeta.ebm.rest.model.CampaignOverviewModel;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Autowired 
	private CampaignOverviewModelConverter campaignOverviewConverter;
	
	public List<CampaignOverviewModel> listAllCampaigns() {
		return campaignOverviewConverter.toOverviewModel(campaignRepository.findAll());
	}
	
	public List<CampaignOverviewModel> listCampaignsPaged(int page, int size) {
		Page<Campaign> campaignPage = campaignRepository.findAll(new PageRequest(page, size));
		return campaignOverviewConverter.toOverviewModel(campaignPage.getContent());
	}
	
	public Campaign getCampaignData(Long id) {
		return campaignRepository.findOne(id);
	}
	
	@Transactional
	public Campaign addNewCampaign(Campaign campaignData) {
		return campaignRepository.save(campaignData);
	}
	
	@Transactional
	public Campaign addCampaign(Long id, Campaign campaignData) {
		Campaign campaignToUpdate = campaignRepository.findOne(id);
		if (campaignToUpdate == null) {
			throw new CampaignNotFoundException();
		}
		
		campaignToUpdate.setCustomer(campaignData.getCustomer());
		campaignToUpdate.setCampaignName(campaignData.getCampaignName());
		campaignToUpdate.setStartDate(campaignData.getStartDate());
		campaignToUpdate.setEndDate(campaignData.getEndDate());
		
		return campaignRepository.save(campaignToUpdate);
	}
	
	@Transactional
	public void deleteCampaign(Long id) {
		try {
			campaignRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CampaignNotFoundException();
		}
	}

}
