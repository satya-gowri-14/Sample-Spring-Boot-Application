package com.spring.boot.model;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_address")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="hno", nullable=false)
	private int hno;
	@Column(name="streetname", nullable=false)
	private String streetname;
	@Column(name="pincode", nullable=false)
	private int pincode;
	@Column(name="state", nullable=false)
	private String state;
	@Column(name="district", nullable=false)
	private String district;
	
	/*@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userAddress")
	private User user;*/
	
	
	public UserAddress() {}
	
	public UserAddress(int hno, String streetname, int pincode, String state, String district) {
		this.hno = hno;
		this.streetname = streetname;
		this.pincode = pincode;
		this.state = state;
		this.district = district;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
	
	
	
	

}
