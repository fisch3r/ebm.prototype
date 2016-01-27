package com.exxeta.ebm.database.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beacon implements Serializable {
	
	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String type;
    
    @Column(name = "reference_id", nullable = false)
    private String referenceId;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "LOCATION_ID")
    private BeaconLocation location;
    
    @JsonIgnore
    @OneToMany(mappedBy = "beacon")
    private List<Campaign> campaigns;

	protected Beacon() {
	}

	public Beacon(String uuid, String type, String referenceId, BeaconLocation location) {
		this.uuid = uuid;
		this.type = type;
		this.referenceId = referenceId;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BeaconLocation getLocation() {
		return location;
	}

	public void setLocation(BeaconLocation location) {
		this.location = location;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}


}
