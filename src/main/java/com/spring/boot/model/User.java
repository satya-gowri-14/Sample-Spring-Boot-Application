package com.spring.boot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.springframework.http.HttpStatus;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fname", nullable=false)
	private String fname;
	@Column(name="lname", nullable=false)
	private String lname;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="phno", nullable=false)
	private long phno;
	@Column(name="designation", nullable=false)
	private String designation;
	@Column(name="active", nullable=false)
	private boolean active;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="address_id")
	private UserAddress userAddress;
	
	 //public User(User user, HttpStatus ok) {}
	 User(){}
	
	public User(long id,String fname, String lname, String email, String designation, long phno, UserAddress userAddress,
			boolean active) {
		super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.designation = designation;
		this.phno = phno;
		this.userAddress = userAddress;
		this.active = active;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
