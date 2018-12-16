package com.jpa.hibernate.app.caching.querycache;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jpa.hibernate.models.caching.Student;

public class QueryCacheDemo {
	
	public static void main(String[] args) {

		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	for(int iterateQuery=0 ;iterateQuery<=10;iterateQuery++) {
		
		
		List studnetList = session.createQuery("from Student where studentName=:dynamicname").setParameter("dynamicname", "Ram").setCacheable(true).list();
		for(Iterator<Student> studentIterator= studnetList.iterator();studentIterator.hasNext();) {
			System.out.println(studentIterator.next());
		}
	}
		
		
	


	}

}
