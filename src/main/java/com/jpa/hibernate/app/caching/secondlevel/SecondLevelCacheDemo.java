package com.jpa.hibernate.app.caching.secondlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jpa.hibernate.models.caching.Student;

public class SecondLevelCacheDemo {
	
public static void main(String[] args) {
	SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Student student = session.get(Student.class, 20);
	System.out.println(session);
	System.out.println(student);
 session.close();
 session= sessionFactory.openSession();
	Student student1 = session.get(Student.class, 20);
	System.out.println(student1);
	System.out.println(session);

}
}
