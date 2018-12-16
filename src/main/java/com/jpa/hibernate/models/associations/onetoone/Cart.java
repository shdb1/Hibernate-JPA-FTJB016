package com.jpa.hibernate.models.associations.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name="cart_id")
	int cartId;
	@Column(name="cart_name")
	String cartName;
	@Column(name="cart_value")
	int cartValue;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	Item item;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public int getCartValue() {
		return cartValue;
	}
	public void setCartValue(int cartValue) {
		this.cartValue = cartValue;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartName=" + cartName + ", cartValue=" + cartValue;
	}

}
