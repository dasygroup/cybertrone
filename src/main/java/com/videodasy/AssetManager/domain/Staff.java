package com.videodasy.AssetManager.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long staffId;
	private String firstName;
	private String lastName;
	private String gender;
	
	private Date dob;
	private String phone;
	private String jobTitle;
	
	@OneToMany(mappedBy="staff")
	@JsonIgnore
	private List<Asset>assets;
	
	
	
	@ManyToOne
	private Department department;
	
	public Staff(String firstName, String lastName, String gender, Date dob, String phone, String jobTitle,
			List<Asset> assets, Department department ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.assets = assets;
		this.department = department;
		
	}
	public Staff(Long staffId, String firstName, String lastName, String gender, Date dob, String phone,
			String jobTitle, List<Asset> assets, Department department) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.assets = assets;
		this.department = department;
		
	}
	public Staff() {
		
	}
	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

	
	
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Override
	public String toString() {
		return firstName;
	}
	
	
	
}
