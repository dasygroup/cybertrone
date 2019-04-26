package com.videodasy.AssetManager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
public class OrderAsset {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	private String description;
	private Date orderdate;
	private boolean confirmed;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	
	public OrderAsset(String description, Date orderdate, boolean confirmed) {
		
		this.description = description;
		this.orderdate = orderdate;
		this.confirmed = confirmed;
	}
	@Override
	public String toString() {
		return "OrderAsset [orderId=" + orderId + ", description=" + description + ", orderdate=" + orderdate
				+ ", confirmed=" + confirmed + "]";
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
}
