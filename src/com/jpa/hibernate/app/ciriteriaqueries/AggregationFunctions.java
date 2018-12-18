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

public class AggregationFunctions {
	
	public static void main(String[] args) {

		

		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		//saveData(sessionFactory);	
		// count - long
		// avg-  double
		// max
		// min
		// distinct, disticount
		
		// almost remains same 
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		
		// select * from student 
		
	//	criteriaQuery.select(criteriaBuilder.avg(root.get("studentMarks")));
    //  criteriaQuery.select(criteriaBuilder.count(root.get("studentMarks")));
	//	criteriaQuery.select(criteriaBuilder.count(root));
	//	criteriaQuery.select(criteriaBuilder.countDistinct((root.get("studentMarks"))));
		
		 criteriaQuery.select(criteriaBuilder.max(root.get("studentMarks")));
		Query<Long> query =	session.createQuery(criteriaQuery);
		List<Long> marksAvg = query.list();

		System.out.println(marksAvg);
		
	
	}

}
