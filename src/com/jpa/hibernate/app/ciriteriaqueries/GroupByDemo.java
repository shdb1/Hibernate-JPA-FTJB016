package com.jpa.hibernate.app.ciriteriaqueries;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.criteriaqueries.Student;

public class GroupByDemo {
	
	public static void main(String[] args) {
		

		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		//saveData(sessionFactory);	
		
		
		// almost remains same 
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<Student> root = criteriaQuery.from(Student.class);
		
		// select * from student 
		
		criteriaQuery.multiselect(criteriaBuilder.sum(root.get("studentMarks")),root.get("studentName"),root.get("studentAddress")).groupBy(root.get("studentName"),root.get("studentAddress")).having(criteriaBuilder.equal(root.get("studentName"), "Amar"));
		
		Query<Object[]> query =	session.createQuery(criteriaQuery);
		List<Object[]> studentList = query.list();

		
	}

}
