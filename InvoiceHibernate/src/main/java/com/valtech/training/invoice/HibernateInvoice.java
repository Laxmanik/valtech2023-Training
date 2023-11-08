package com.valtech.training.invoice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.Address;
import com.valtech.training.Customers;
import com.valtech.training.Items;
import com.valtech.training.OrderDescription;
import com.valtech.training.Orders;
import com.valtech.training.Vendors;

public class HibernateInvoice {

	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Vendors.class);
		cfg.addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Customers.class);
		cfg.addAnnotatedClass(Orders.class);
		cfg.addAnnotatedClass(Items.class);
		cfg.addAnnotatedClass(OrderDescription.class);
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
		Address address = new Address(24,"Javaregowda Nagar","Bangalore","Karnataka","India",560098);
		Address address1 = new Address(24,"Byatarayana pura","Bangalore","Karnataka","India",560026);
		Address address2 = new Address(23, "Kottigepalya", "Bangalore", "Karnataka", "India", 560072);
		Address address3 = new Address(22, "Jnana Bharati", "Bangalore", "Karnataka", "India", 560056);
		
		Vendors vendors = new Vendors("dhanush.v.2001@gmail.com","9480208384","Dhanush");
		address.setVendors(vendors);
		vendors.setAddress(address);
		
		Vendors vendors1 = new Vendors("pradeep@gmail.com","9480204521","Pradeep");
		address2.setVendors(vendors1);
		vendors1.setAddress(address2);
		
		Customers customers=new Customers("Laxman", "Kuddemmi", 1235, "laxman@gamil.com");
		customers.setAddress(address1);
		address1.setCustomers(customers);
		
		Customers customers1=new Customers("Sneha", "Vijapur", 1290, "sneha@gamil.com");
		customers1.setAddress(address3);
		address3.setCustomers(customers1);
		
		Items items = new Items("Iphone 15","It is IOS phone", 100000);
		items.setVendors(vendors);
		
		Items items1 = new Items("Water Heater","Heater", 379);
		items1.setVendors(vendors1);
		
		OrderDescription orderDescription = new OrderDescription(1);
		orderDescription.setItems(items);
		
		OrderDescription orderDescription1 = new OrderDescription(2);
		orderDescription1.setItems(items1);
		
		Orders orders = new Orders("06-11-2023");
		orders.setCustomers(customers1);
		orders.setOrderDescription(orderDescription);
		
		Orders orders1 = new Orders("07-11-2023");
		orders1.setCustomers(customers);
		orders1.setOrderDescription(orderDescription1);
		
		ses.persist(address);
		ses.persist(address1);
		ses.persist(vendors);
		ses.persist(customers);
		ses.persist(address2);
		ses.persist(address3);
		ses.persist(vendors1);
		ses.persist(customers1);
		ses.persist(items);
		ses.persist(orderDescription);
		ses.persist(orders);
		ses.persist(items1);
		ses.persist(orderDescription1);
		ses.persist(orders1);
		
		System.out.println("Loading...");
		tx.commit();
		ses.close();
		sesFac.close();
	}
}
