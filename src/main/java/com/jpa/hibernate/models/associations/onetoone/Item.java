package com.jpa.hibernate.models.associations.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="item_id")
	int intemId;
	@Column(name="item_name")
	String itemName;
	@Column(name="item_value")
	int itemValue;
	@OneToOne(mappedBy="item",fetch=FetchType.LAZY)
	Cart cart;
	public int getIntemId() {
		return intemId;
	}
	public void setIntemId(int intemId) {
		this.intemId = intemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemValue() {
		return itemValue;
	}
	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "Item [intemId=" + intemId + ", itemName=" + itemName + ", itemValue=" + itemValue + ", cart=" + cart
				+ "]";
	}

}
