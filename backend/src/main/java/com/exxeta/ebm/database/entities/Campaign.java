package com.exxeta.ebm.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campaign implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String customer;
	
	@Column(name = "campaign_name", nullable=false)
	private String campaignName;
	
	@Column(name = "start_date", nullable=false)
	private String startDate;
	
	@Column(name = "end_date", nullable=false)
	private String endDate;
	
	public Campaign() {
	}
	
	public Campaign(String customer, String campaignName, String startDate, String endDate) {
		this.customer=customer;
		this.campaignName=campaignName;
		this.startDate=startDate;
		this.endDate=endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
