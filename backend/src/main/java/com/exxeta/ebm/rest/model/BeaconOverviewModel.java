package com.exxeta.ebm.rest.model;

public class BeaconOverviewModel {
	
	private String id;
	private String uuid;
	private String type;
	private String address;
	private Double lat;
	private Double lng;
	
	public BeaconOverviewModel(String id, String uuid, String type, String address, Double lat, Double lng) {
		this.id = id;
		this.uuid = uuid;
		this.type = type;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
	}
	
	public BeaconOverviewModel(String id, String uuid, String type, String address) {
		this(id, uuid, type, address, null, null);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
}
