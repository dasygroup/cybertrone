package com.videodasy.AssetManager.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vendor {
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long vendorId;

private String firstName;
private String lastName;
private String email;
private String phone;

@OneToMany(mappedBy="vendor",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JsonIgnore
private List<Asset>assets;

public Vendor(String firstName, String lastName, String email, String phone, List<Asset> assets) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.assets = assets;
}
public List<Asset> getAssets() {
	return assets;
}
public void setAssets(List<Asset> assets) {
	this.assets = assets;
}
public Long getVendorId() {
	return vendorId;
}
public void setVendorId(Long vendorId) {
	this.vendorId = vendorId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Vendor() {
	
}
}
