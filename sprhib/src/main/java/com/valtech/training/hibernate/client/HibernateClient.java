package com.valtech.training.hibernate.client;

import org.hibernate.cfg.AnnotationConfiguration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		
		cfg.addAnnotatedClass(Employee.class);
		
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class);
		SessionFactory sesFac = cfg.buildSessionFactory();
	    Session ses = sesFac.openSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(new Tx(1000));
		
		ses.save(new ChequeTx(2000, 123123, 34435));
		
		ses.save(new TellerTx(3000, 123, 345));
		
		ses.save(new AtmTx(5000, 789));
		
		ses.createQuery("from Tx tx").list().forEach(t -> System.out.println(t));
		
//		int id = (Integer)ses.save(new Employee("Abc", df.parse("15-08-1947"), 2000, 'M', false));
//		System.out.println(id);
//		
//		Employee e = (Employee)ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Abc2");
		
//		ses.merge(e);
		
		System.out.println("Loading...");
		
		tx.commit();
		ses.close();
		sesFac.close();
	}

}
