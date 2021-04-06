package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "table_cart1")
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "cart_id")
	private int cartId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> cartItem;
	
	private int quantity;
	private int totalCost;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
	
}
