package com.jpa.hibernate.app.loadvsget;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jpa.hibernate.models.namedqueries.Student;

public class LoadGetDemo {
	

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		
		saveStudent(sessionFactory);
		
/*		Session session = sessionFactory.openSession();
		//session.createQuery("from Student").list();
		Student studentObject =  session.load(Student.class, 1);
		System.out.println(studentObject);*/
		
		
		Session session1 = sessionFactory.openSession();
		//session.createQuery("from Student").list();
		Student studentObject1 =  session1.load(Student.class, 100);
	    System.out.println(studentObject1);
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
