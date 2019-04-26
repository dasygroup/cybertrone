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
public class Category {

  @Id
   @GeneratedValue()
  private Long categoryId;
  public Category() {
	
}
private String name;
  private String  description;
  
  @OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  @JsonIgnore
  private List<Asset>assets;
  
public Category(String name, String description, List<Asset> assets) {
	super();
	this.name = name;
	this.description = description;
	this.assets = assets;
}
public List<Asset> getAssets() {
	return assets;
}
public void setAssets(List<Asset> assets) {
	this.assets = assets;
}
public Long getCategoryId() {
	return categoryId;
}
public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + "]";
}
  
}
