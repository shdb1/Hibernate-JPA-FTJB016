package com.jpa.hibernate.app.ciriteriaqueries;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jpa.hibernate.models.criteriaqueries.College;
import com.jpa.hibernate.models.criteriaqueries.Student;

public class Joins {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<Student> rootStudent = criteriaQuery.from(Student.class);
		Root<College> rootCollege = criteriaQuery.from(College.class);
		
		
		criteriaQuery.multiselect(rootStudent,rootCollege).where(criteriaBuilder.equal(rootStudent.get("college"),rootCollege.get("collegeId")));
		
		
		Query<Object[]> query =	session.createQuery(criteriaQuery);
		List<Object[]> studentList = query.list();
	}

	
	
}
