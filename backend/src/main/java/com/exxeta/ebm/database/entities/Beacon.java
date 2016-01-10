package com.exxeta.ebm.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Beacon implements Serializable {
	
	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String type;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "LOCATION_ID")
    private BeaconLocation location;
	
	protected Beacon() {
	}

	public Beacon(String uuid, String type, BeaconLocation location) {
		this.uuid = uuid;
		this.type = type;
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

}
