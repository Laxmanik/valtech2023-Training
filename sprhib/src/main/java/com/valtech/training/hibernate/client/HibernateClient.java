package com.valtech.training.hibernate.client;

import org.hibernate.cfg.AnnotationConfiguration;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();

		cfg.addAnnotatedClass(Employee.class);

		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class);

		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Registration.class)
				.addAnnotatedClass(BankAccount.class);

		cfg.addAnnotatedClass(Account.class);
		SessionFactory sesFac = cfg.buildSessionFactory();

		Session ses = sesFac.openSession();

		Transaction tx = ses.beginTransaction();

		ses.persist(new BankAccount(new BankAccountId("SB",1), 3000));
		
		BankAccountId id = new BankAccountId("SB", 1);
		BankAccount ba = new BankAccount(id, 3000);
		
//		Customer cust = new Customer("Abc", 23);
//		ses.save(cust);
//		Address add = new Address("JP Nagar", "Blr", 560078);
//		add.setCustomer(cust);
////		cust.setAddress(add);
//		ses.save(add);
//		
//		Account acc = new Account(10000, "SB");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000, 123123, 34435);
//		Tx tx3 = new TellerTx(3000, 123, 345);
//		Tx tx4 = new AtmTx(5000, 789);
//		
//		Account acc1 = new Account(2000, "CA");
//		Tx tx5 = new ChequeTx(2000, 456233, 345124);
//		
//		Customer cus1 = new Customer("Def", 25);
//		Address add1 = new Address("Jayanagar", "Blr", 560070);
//		Customer cus2 = new Customer("Pqr", 27);
//		Address add2 = new Address("Gandhinagar", "HYD", 560055);
//		
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//		
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//		
//		acc1.addTx(tx5);
//		acc1.addCustomer(cus1);acc1.addCustomer(cus2);acc1.addCustomer(cust);
//		acc.addCustomer(cus2);acc.addCustomer(cus1);
//		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000, 123123, 34435));
//		ses.save(new TellerTx(3000, 123, 345));
//		ses.save(new AtmTx(5000, 789));

//		ses.createQuery("select distinct tx from Tx tx").list().forEach(t -> System.out.println(t));

//		Query query = ses.createQuery("SELECT DISTINCT c FROM Customer c JOIN c.accounts a JOIN a.txs t WHERE t.amount > ?");
//		query.setFloat(0, 3000);
//		query.list().forEach(t -> System.out.println(t));

		Query query = ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//				ses.createQuery("SELECT t FROM Tx t JOIN t.account.customers c WHERE c.address.city = ? AND t.amount > ?");
		query.setString(0, "Blr");
		query.setFloat(1, 3000);
		query.list().forEach(t -> System.out.println(t));

//		int id = (Integer)ses.save(new Employee("Abc", df.parse("15-08-1947"), 2000, 'M', false));
//		System.out.println(id);
//		
//		Employee e = (Employee)ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Abc2");
//		
//		ses.merge(e);

		System.out.println("Loading...");

		tx.commit();
		ses.close();
		sesFac.close();
	}

}
