package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "table_customer3")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int customerId;
	private String name ; 
	private String email;
	private String password; 
	private int mobileNumber;
	private String address1;
	private String address2;
	private boolean accountStatus;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private List<Cart> cart;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	
}
