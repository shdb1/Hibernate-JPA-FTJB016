package com.jpa.hibernate.app.associations.onetomany;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.StudentEntity;
import com.jpa.hibernate.models.associations.onetomany.College;
import com.jpa.hibernate.models.associations.onetomany.Student;
import com.jpa.hibernate.models.associations.onetoone.Cart;
import com.jpa.hibernate.models.associations.onetoone.Item;

public class OneToManyDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		/*try {
			//insertData(sessionFactory);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	fetchdata(sessionFactory);
		
		// Cart [cartId=1, cartName=samplecart, cartValue=20, item=Item [intemId=2, itemName=sampleItem, itemValue=20]
*/
		
		fetchdata(sessionFactory);
	}
	
	public static void insertData(SessionFactory sessionFactory) throws ParseException {
		
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
	
	
	Student student2 = new Student();
	student2.setStudentName("Akbar");
	student2.setStudentAddress("Bengal");
	student2.setCollege(college);
	student2.setStudentCourse("MA");

	List<Student> studentList = new ArrayList<Student>();
	studentList.add(student1);
	studentList.add(student2);
	college.setStudents(studentList);
	
	
	session.save(college);

	
	transaction.commit();
	session.close();
	
	}
	
	public static void fetchdata(SessionFactory sessionFactory) {
		

		Session session = sessionFactory.openSession();
		List cartList =session.createQuery("from College").list();
		for(Iterator<College> collegeIterator= cartList.iterator();collegeIterator.hasNext();) {
			College college = collegeIterator.next();
			System.out.println(college);
			System.out.println(college.getStudents());
		}
		
	
		
	}
}
