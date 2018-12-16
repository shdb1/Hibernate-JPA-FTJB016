package com.jpa.hibernate.app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;

import com.jpa.hibernate.models.Student;

public class XMLAppRunner {
	//insert,select,update,delete,transaction
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =	sessionFactory.openSession();
		Student student = new Student("Ram", 100, "MCA", "Chennai", 20);
		Student student2 = new Student("Tom", 101, "MS", "Delhi", 24);
		Student student3 = new Student("Rohan", 102, "BE", "Hydarabad", 19);
		Student student4 = new Student("John", 103, "MCA", "Chennai", 25);
		Student student5 = new Student("Shyam", 104, "MS", "Delhi", 26);
		Student student6 = new Student("Tomy", 105, "BE", "Hydarabad", 16);
		
		//addStudent(student3, session);
	/*	addStudent(student3, session);
		addStudent(student4, session);
	addStudent(student5, session);
		addStudent(student6, session);
*/		
		//fetchStudent(session);
		
		//updateStudent(session, student6);
		deleteStudent(session, student6);
		session.close();
		
		
	}
	
	
	public static void addStudent(Student student,Session session) {
		
		 Transaction transaction = session.beginTransaction();
		 
		int createdID= (int) session.save(student);
		
		System.out.println("PK Created :"+createdID);
	transaction.commit();
		
		
	}
	
	/*public static void fetchStudent(Session session) {
		
		//Query query = session.createQuery("from Student");
	Query query = session.createQuery("from Student stud where stud.name=:name_to_be_passed_by_user");
		query.setParameter("name_to_be_passed_by_user", "Rohan");
		List studentResult = query.list();
		
		for(Iterator iterator= studentResult.iterator();iterator.hasNext();) {
			Student student = (Student)iterator.next();
			System.out.println(student);
		}
		
	}*/
	
	public static void updateStudent(Session session, Student student) {
		student.setId(10);
		 Transaction transaction = session.beginTransaction();
			session.update(student);
		transaction.commit();
			
	}
	
	public static void deleteStudent(Session session, Student student) {
		student.setId(1);
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
			
	}

}
