package com.exxeta.ebm.database.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Campaign implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (nullable=false)
	private String customer;
	
	@Column (name = "campaign_name", nullable=false)
	private String campaignName;
	
	@Temporal(TemporalType.DATE)
	@Column (name = "start_date", nullable=false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column (name = "end_date", nullable=false)
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "BEACON_ID")
    private Beacon beacon;
	
	protected Campaign() {
	}
	
	public Campaign(String customer, String campaignName, Date startDate, Date endDate) {
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

	public Beacon getBeacon() {
		return beacon;
	}
	
	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}
}
