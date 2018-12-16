package com.jpa.hibernate.app.associations.onetoone;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.Student;
import com.jpa.hibernate.models.StudentEntity;
import com.jpa.hibernate.models.associations.onetoone.Cart;
import com.jpa.hibernate.models.associations.onetoone.Item;

public class OneToOneDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		insertData(sessionFactory);
		fetchdata(sessionFactory);
		
		// Cart [cartId=1, cartName=samplecart, cartValue=20, item=Item [intemId=2, itemName=sampleItem, itemValue=20]

	}
	
	public static void insertData(SessionFactory sessionFactory) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Item item = new Item();
		item.setItemName("sampleItem");
		item.setItemValue(20);
		
		Cart cart = new Cart();
		cart.setCartName("samplecart");
		cart.setCartValue(20);
		cart.setItem(item);
	
		
	//	session.save(item);
		session.save(cart);
		transaction.commit();
		
		
		
	}
	
	public static void fetchdata(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		List cartList =session.createQuery("from Cart").list();
		for(Iterator<Cart> cartIterartor= cartList.iterator();cartIterartor.hasNext();) {
			Cart cart = cartIterartor.next();
			System.out.println(cart);
			System.out.println(cart.getItem());
		}
		
	}
}
