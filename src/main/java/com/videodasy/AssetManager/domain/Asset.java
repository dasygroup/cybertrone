package com.videodasy.AssetManager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Asset {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long assetId;
	private String assetType;
	private String brand;
	private String description;
	
	private String status;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	public Asset(String assetType, String brand, String description, String status, Category category, Vendor vendor,
			Staff staff) {
		super();
		this.assetType = assetType;
		this.brand = brand;
		this.description = description;
		this.status = status;
		this.category = category;
		this.vendor = vendor;
		this.staff = staff;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
	
	
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetType=" + assetType + ", brand=" + brand + ", description="
				+ description + ", status=" + status + "]";
	}
	
	public Asset() {
		
	}
	
}
