package com.jpa.hibernate.app.caching.firstlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jpa.hibernate.models.caching.Student;

public class FirstLevelCacheDemo {
	
	public static void main(String[] args) throws InterruptedException {
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		saveStudent(sessionFactory);
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, 20);
		System.out.println(student);
	//	session.close();
		Thread.sleep(9000);
	//	session= sessionFactory.openSession();
		Student student1 = session.get(Student.class, 20);
		System.out.println(student1);

		
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
