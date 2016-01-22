package com.exxeta.ebm.rest.model;

public class CampaignOverviewModel {
	
	private String id;
	private String customer;
	private String campaignName;
	private String startDate;
	private String endDate;
	
	public CampaignOverviewModel(String id, String customer, String campaignName, String startDate, String endDate) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
