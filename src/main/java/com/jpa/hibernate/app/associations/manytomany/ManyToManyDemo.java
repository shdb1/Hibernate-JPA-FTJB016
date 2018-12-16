package com.jpa.hibernate.app.associations.manytomany;

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
import com.jpa.hibernate.models.associations.manytomany.Computer;
import com.jpa.hibernate.models.associations.manytomany.Printer;
import com.jpa.hibernate.models.associations.onetomany.College;
import com.jpa.hibernate.models.associations.onetomany.Student;
import com.jpa.hibernate.models.associations.onetoone.Cart;
import com.jpa.hibernate.models.associations.onetoone.Item;

public class ManyToManyDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		try {
			insertData(sessionFactory);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertData(SessionFactory sessionFactory) throws ParseException {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Printer printer = new Printer();
		printer.setPrinterLocation("EAST-Block");
		printer.setPrintername("HP");
		
		Printer printer1 = new Printer();
		printer1.setPrinterLocation("WEST-Block");
		printer1.setPrintername("HP2");
		
		Printer printer11 = new Printer();
		printer11.setPrinterLocation("North-Block");
		printer11.setPrintername("HP3");
		
List<Printer> printerList = new ArrayList<>();
printerList.add(printer);
printerList.add(printer1);
 Computer computer = new Computer();
 computer.setComputerName("Dell Laptop");
 computer.setLocation("Chennai");
// computer.setPrinters(printerList);
 
 
 Computer computerDummy = new Computer();
 computerDummy.setComputerName("Dell Laptop- Dummy");
 computerDummy.setLocation("Chennai");

 
 Computer computer1 = new Computer();
 computer1.setComputerName("Dell PC");
 computer1.setLocation("Chennai");
 computer1.setPrinters(printerList);
 session.save(computer);
 session.save(computer1);
 session.save(printer11);
 session.save(computerDummy);
 transaction.commit();
 session.close();
 
 
 

		
	}
	
	public static void fetchdata(SessionFactory sessionFactory) {}
}
