package com.jpa.hibernate.app.associations.namedqueries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jpa.hibernate.models.namedqueries.Student;


public class NamedQueryDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		
		saveStudent(sessionFactory);
		
		Session session = sessionFactory.openSession();
		//session.createQuery("from Student").list();
		List studnetList = session.getNamedQuery("findStudent").list();
		for(Iterator<Student> studentIterator= studnetList.iterator();studentIterator.hasNext();) {
			System.out.println(studentIterator.next());
		}
		
		
	}
	
	
	public static void saveStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setStudentName("Ram");
		session.save(student);
		transaction.commit();
		session.close();
		
	}

}
