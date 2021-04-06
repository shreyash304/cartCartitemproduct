package com.lti.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Cart;
import com.lti.entity.CartItem;
import com.lti.entity.Customer;
import com.lti.entity.Product;

public class ShoppingTest {

	@Test
	public void testShopping() {
		GenericDao dao = new GenericDao();
		Customer customer = new Customer();
		
		
		customer.setName("shreyash");
		customer.setEmail("shreyash@gmail.com");
		customer.setPassword("qwer123");
		customer.setMobileNumber(879);
		customer.setAddress1("A/304,harihar enclave");
		customer.setAddress2("Evershine city last stop");
		
		Cart cart = new Cart();
		cart.setQuantity(20);
		cart.setTotalCost(12000);
		List<Cart> list = new ArrayList<Cart>();
		list.add(cart);
		cart.setCustomer(customer);
		customer.setCart(list);
		dao.save(customer);
	}
	
	/*@Test
	public void customerCartProduct() {
		GenericDao dao = new GenericDao();
		
		Product product = new Product();
		product.setProductName("lenovo");
		product.setProductDetail("This is lenovo");
		product.setQuantity(20);
		product.setPrice(18000);
		product.setImage("lenovo.png");
		
		Cart cart = new Cart();
		
		cart.setQuantity(23);
		cart.setTotalCost(27000);
		List<Cart> list = new ArrayList<Cart>();
		list.add(cart);
		cart.setProduct(product);
		
		Customer customer = (Customer) dao.fetch(Customer.class, 7);
		cart.setCustomer(customer);
	
		List<Cart> list2 = new ArrayList<Cart>();
		list2.add(cart);
		
		product.setCart(list2);
		dao.save(product);
	}*/
	
	@Test
	public void cartCartItem() {
		GenericDao dao = new GenericDao();
		
		Cart cart = new Cart();
		
		Customer customer = (Customer) dao.fetch(Customer.class, 7);
		cart.setCustomer(customer);
		
		cart.setTotalCost(12000);
		
		
		
		CartItem ci = new CartItem();
	
		Product product = (Product) dao.fetch(Product.class, 11);
		ci.setProduct(product);
		
		List<CartItem> list2 = new ArrayList<CartItem>();
		list2.add(ci);
		
		ci.setQuantity(12);
		ci.setCart(cart);
		cart.setCartItem(list2);
		dao.save(cart);
	}
	
	@Test
	public void cartCartItemProduct() {
		GenericDao dao = new GenericDao();
		CartItem ci = new CartItem();
		
		Product product = (Product) dao.fetch(Product.class, 11);
		ci.setProduct(product);
		
		List<CartItem> list3 = new ArrayList<CartItem>();
		list3.add(ci);
		
		Cart cart = (Cart) dao.fetch(Cart.class, 26);
		ci.setProduct(product);
		ci.setCart(cart);
		ci.setQuantity(12);
		ci.setTotalCost(20000);
		
		product.setCartItem(list3);
		dao.save(product);
		
		
		System.out.println(ci.getCartItemId() + "," + ci.getTotalCost() + "," + ci.getProduct().getId());
		
	}
}
