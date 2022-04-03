package com.Kamal.ProjectTrial2.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Kamal.ProjectTrial2.Product.Products;
import com.Kamal.ProjectTrial2.UserDetails.User;

@Entity
@Table(name="CART")
public class AddtoCart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long cartId;
	
	@OneToOne
	@JoinColumn(name="productId")
	Products product_id;
	int qty;
	// double price;
	
	@OneToOne
	@JoinColumn(name="userId")
	User user_id;
	
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long id) {
		this.cartId = id;
	}

	/*
	 * public int getProduct_id() { return product_id; } public void
	 * setProduct_id(int product_id) { this.product_id = product_id; }
	 */
	public int getQty() {
		return qty;
	}
	public Products getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Products product_id) {
		this.product_id = product_id;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	/*
	 * public long getUser_id() { return user_id; } public void setUser_id(long
	 * user_id) { this.user_id = user_id; }
	 */
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	

}
