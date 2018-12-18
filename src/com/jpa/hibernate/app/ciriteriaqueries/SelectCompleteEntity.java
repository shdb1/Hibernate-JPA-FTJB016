package com.jpa.hibernate.app.ciriteriaqueries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.criteriaqueries.College;
import com.jpa.hibernate.models.criteriaqueries.Student;


public class SelectCompleteEntity {
	
	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		//saveData(sessionFactory);	
		
		
		// almost remains same 
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		
		// select * from student 
		
		criteriaQuery.select(root);
		
		
	//	session.createQuery(criteriaQuery).list();
	Query<Student> query =	session.createQuery(criteriaQuery);
		List<Student> studentList = query.list();
		
		System.out.println(studentList);
	}
	
	
	public static void saveData(SessionFactory sessionFactory ) throws ParseException {
		

		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		College college = new College();
		college.setCollegeName("TestCollege");
		college.setCollegeRank("AB+");
		college.setCollegeAddress("Chennai");
		college.setCollegeEstablished(new SimpleDateFormat("yyyy-mm-dd").parse("2018-10-10"));
		
		
	Student student1 = new Student();
	student1.setStudentName("Amar");
	student1.setStudentAddress("Chennai");
	student1.setCollege(college);
	student1.setStudentCourse("BA");
	student1.setStudentMarks(35);
	
	
	
	Student student2 = new Student();
	student2.setStudentName("Akbar");
	student2.setStudentAddress("Bengal");
	student2.setCollege(college);
	student2.setStudentCourse("MA");
	student2.setStudentMarks(50);
	
	
	Student student3 = new Student();
	student3.setStudentName("Anthony");
	student3.setStudentAddress("Delhi");
	student3.setCollege(college);
	student3.setStudentCourse("MS");
	student3.setStudentMarks(75);

	List<Student> studentList = new ArrayList<Student>();
	studentList.add(student1);
	studentList.add(student2);
	studentList.add(student3);
	college.setStudents(studentList);
	
	
	session.save(college);

	
	transaction.commit();
	session.close();
	
	
	}

}
