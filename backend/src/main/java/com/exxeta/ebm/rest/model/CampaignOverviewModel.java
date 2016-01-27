package com.exxeta.ebm.rest.model;

import java.util.Date;

public class CampaignOverviewModel {
	
	private String id;
	private String customer;
	private String campaignName;
	private Date startDate;
	private Date endDate;
	
	public CampaignOverviewModel (String id, String customer, String campaignName, Date startDate, Date endDate) {
		this.id=id;
		this.customer=customer;
		this.campaignName=campaignName;
		this.startDate=startDate;
		this.endDate=endDate;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
