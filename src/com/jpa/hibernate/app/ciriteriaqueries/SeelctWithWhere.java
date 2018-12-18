package com.jpa.hibernate.app.ciriteriaqueries;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.criteriaqueries.Student;

public class SeelctWithWhere {

	
	public static void main(String[] args) {


		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		//saveData(sessionFactory);	
		
		
		// almost remains same 
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		
		// seletc * from studnet where student_address='chennai'
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("studentAddress"),"Chennai" ));
		//criteriaQuery.where(restriction)
		
		
	//	session.createQuery(criteriaQuery).list();
	Query<Student> query =	session.createQuery(criteriaQuery);
		List<Student> studentList = query.list();
		System.out.println(studentList);
	
	
	}
}
