package com.jpa.hibernate.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.StudentMarks;

public class HQLDemo {
	
	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
	//	hqlInsert(sessionFactory);
	 //   hqlSelect(sessionFactory);
	//	hqlUpdate(sessionFactory);
	//	hqlDelete(sessionFactory);
	//	hqlOrder(sessionFactory);
	//	hqlGrouping(sessionFactory);
		hqlPagination(sessionFactory);
		
	}
	
	
	public static void hqlSelect(SessionFactory sessionFactory){
		
		Session session = sessionFactory.openSession();
		List studentMarks =session.createQuery("from StudentMarks").list();
		
		for(Iterator<StudentMarks> studentmark = studentMarks.iterator();studentmark.hasNext();) {
			StudentMarks StudentMarkObject =studentmark.next();
			System.out.println(StudentMarkObject);
		}
		
		
	}

	static void hqlInsert(SessionFactory sessionFactory) throws ParseException{
Session session = sessionFactory.openSession();
		
		StudentMarks studentMarks = new StudentMarks();
		studentMarks.setStudentRoll(1234);
		studentMarks.setStudentname("Ram");
		studentMarks.setStudentCourse("M.Tech");
		studentMarks.setResultDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"));
		studentMarks.setStudentMarks(89.20);
		

		StudentMarks studentMarks1 = new StudentMarks();
		studentMarks1.setStudentRoll(1234);
		studentMarks1.setStudentname("Shyam");
		studentMarks1.setStudentCourse("MCA");
		studentMarks1.setResultDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-5-01"));
		studentMarks1.setStudentMarks(10.5);

		StudentMarks studentMarks2 = new StudentMarks();
		studentMarks2.setStudentRoll(1234);
		studentMarks2.setStudentname("Ramesh");
		studentMarks2.setStudentCourse("MBA");
		studentMarks2.setResultDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01"));
		studentMarks2.setStudentMarks(99.5);
		

		StudentMarks studentMarks3 = new StudentMarks();
		studentMarks3.setStudentRoll(1234);
		studentMarks3.setStudentname("Johny");
		studentMarks3.setStudentCourse("BCA");
		studentMarks3.setResultDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"));
		studentMarks3.setStudentMarks(60.5);
		
		StudentMarks studentMarks4 = new StudentMarks();
		studentMarks4.setStudentRoll(1234);
		studentMarks4.setStudentname("Tom");
		studentMarks4.setStudentCourse("BBA");
		studentMarks4.setResultDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-01"));
		studentMarks4.setStudentMarks(33.33);
		
		Transaction transaction= session.beginTransaction();
		session.save(studentMarks);
		session.save(studentMarks1);
		session.save(studentMarks2);
		session.save(studentMarks3);
		session.save(studentMarks4);
		transaction.commit();
		session.close();
	}
	
	static void hqlUpdate(SessionFactory sessionFactory) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query=  session.createQuery("update StudentMarks set studentCourse=:course where id=:myid" );
		query.setParameter("course", "m.Tech");
		query.setParameter("myid", 1);
		int numberIfRowsUpdated =query.executeUpdate();
		
		transaction.commit();
		session.close();
		System.out.println("Number of rows updated are :"+numberIfRowsUpdated);
		
		
	}
	
static void hqlDelete(SessionFactory sessionFactory) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query=  session.createQuery("delete from StudentMarks where id=:myid" );
		query.setParameter("myid", 1);
		int numberIfRowsUpdated =query.executeUpdate();
		
		transaction.commit();
		session.close();
		System.out.println("Number of rows deleted are :"+numberIfRowsUpdated);
		
		
	}


static void hqlOrder(SessionFactory sessionFactory) {
	
// select * from tablename order by colq1,col2 ASC,DESC
	
	Session session = sessionFactory.openSession();
	List studentMarks =session.createQuery("from StudentMarks order by studentMarks DESC").list();
	
	for(Iterator<StudentMarks> studentmark = studentMarks.iterator();studentmark.hasNext();) {
		StudentMarks StudentMarkObject =studentmark.next();
		System.out.println(StudentMarkObject);
	}
	
	

	
}

static void hqlGrouping(SessionFactory sessionFactory) {
	
	// select * from tablename order by colq1,col2 ASC,DESC
		
		Session session = sessionFactory.openSession();
		List studentMarks =session.createQuery("select sum(studentMarks) , studentRoll from StudentMarks group by studentRoll").list();
		
		for(Iterator studentmark = studentMarks.iterator();studentmark.hasNext();) {
			Object[] StudentMarkObject =(Object[])studentmark.next();
			System.out.println(StudentMarkObject[0]);
			System.out.println(StudentMarkObject[1]);
		}
		
		

		
	}

static void hqlPagination(SessionFactory sessionFactory) {

	
	// select * from tablename order by colq1,col2 ASC,DESC
		
		Session session = sessionFactory.openSession();
	   Query qry= session.createQuery("from StudentMarks");
	   qry.setFirstResult(2);
	   qry.setMaxResults(2);
	List studentMarks=   qry.list();
		
		for(Iterator<StudentMarks> studentmark = studentMarks.iterator();studentmark.hasNext();) {
			StudentMarks StudentMarkObject =studentmark.next();
			System.out.println(StudentMarkObject);
		}
		
		

		

	 
}

// aggregation - select sum(col from entity) from entity , min, max, 
// pass date object new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01")
	
}
