package com.jpa.hibernate.app;

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

public class AnnotationAppRunner {
	
	public static void main(String[] args) {
		
		
	//	SessionFactory sessionFactory  = new AnnotationConfiguration().configure().Re("com.jpa.hibernate.models.StudentEntity").buildSessionFactory();
	//	Session session =	sessionFactory.openSession();
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		StudentEntity studentEntity = new StudentEntity("Ram", 100, "MCA", "Chennai", 20);
		StudentEntity student2 = new StudentEntity("Tom", 101, "MS", "Delhi", 24);
		StudentEntity student3 = new StudentEntity("Rohan", 102, "BE", "Hydarabad", 19);
		StudentEntity student4 = new StudentEntity("John", 103, "MCA", "Chennai", 25);
		StudentEntity student5 = new StudentEntity("Shyam", 104, "MS", "Delhi", 26);
		StudentEntity student6 = new StudentEntity("Tomy", 105, "BE", "Hydarabad", 16);
		
	/*	addStudent(student3, session);
		addStudent(student3, session);
		addStudent(student4, session);
	addStudent(student5, session);*/
		addStudent(studentEntity, session);
		
		fetchStudent(session);
		
		//updateStudent(session, student6);
	//	deleteStudent(session, student6);
		session.close();
		
		
	}
	
	
	public static void addStudent(StudentEntity student,Session session) {
		
		 Transaction transaction = session.beginTransaction();
		 
		int createdID= (int) session.save(student);
		
		System.out.println("PK Created :"+createdID);
	transaction.commit();
		
		
	}
	
	public static void fetchStudent(Session session) {
		
		//Query query = session.createQuery("from Student");
		Query query = session.createQuery("from StudentEntity stud where stud.name=:name_to_be_passed_by_user");
		query.setParameter("name_to_be_passed_by_user", "Ram");
		List studentResult = query.list();
		
		for(Iterator iterator= studentResult.iterator();iterator.hasNext();) { 	
			StudentEntity student = (StudentEntity)iterator.next();
			
			System.out.println(student);
		}
		
	}
	
	public static void updateStudent(Session session, StudentEntity student) {
		student.setId(10);
		 Transaction transaction = session.beginTransaction();
			session.update(student);
		transaction.commit();
			
	}
	
	public static void deleteStudent(Session session, StudentEntity student) {
		student.setId(1);
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
			
	}

}
