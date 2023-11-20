package com.valtech.training.invoicespringjdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.invoicespringjdbc.components.Address;
import com.valtech.training.invoicespringjdbc.components.AddressDAO;
import com.valtech.training.invoicespringjdbc.components.Customer;
import com.valtech.training.invoicespringjdbc.components.CustomerDAO;
import com.valtech.training.invoicespringjdbc.components.Item;
import com.valtech.training.invoicespringjdbc.components.ItemDAO;
import com.valtech.training.invoicespringjdbc.components.OrderSummary;
import com.valtech.training.invoicespringjdbc.components.OrderSummaryDAO;
import com.valtech.training.invoicespringjdbc.components.Orders;
import com.valtech.training.invoicespringjdbc.components.OrdersDAO;
import com.valtech.training.invoicespringjdbc.components.Vendor;
import com.valtech.training.invoicespringjdbc.components.VendorDAO;

@SpringBootTest
class InvoiceSpringJdbcApplicationTests {
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private VendorDAO vendorDAO;
	
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testAddressDAO() {
		Address address = new Address(1, "Kottigepalya", "Bengaluru", 560072);
		addressDAO.createAddress(address);
		addressDAO.createAddress(new Address(2, "Shivaji Street", "Pune", 590091));
		System.out.println(address);
		assertEquals(2, addressDAO.count());
		assertEquals("Bengaluru", address.getCity());
	}
	
	@Test
	void testCustomerDAO() {
		Customer customer = new Customer(1,"Laxman", 994571129, 1);
		customerDAO.createCustomer(customer);
		assertEquals(1, customerDAO.count());
	}
	
	@Test
	void testItemDAO() {
		Item item = new Item(1, "Bag", 360, 100);
		itemDAO.createItem(item);
		assertEquals(1, itemDAO.count());
	}
	
	@Test
	void testOrdersDAO() {
		Orders orders = new Orders(1, null, 1);
		ordersDAO.createOrders(orders);
		assertEquals(1, ordersDAO.count());
	}
	
	@Test
	void testVendorDAO() {
			Vendor vendor = new Vendor(1, "Wild Craft", 2);
			vendorDAO.createVendor(vendor);
			assertEquals(1, vendorDAO.count());
	}
	
	@Test
	void testOrderSummaryDAO() {
		OrderSummary os = new OrderSummary(1, 1, 4);
		orderSummaryDAO.createOrderSummary(os);
		assertEquals(1, orderSummaryDAO.count());
	}

}
