package com.valtech.training.invoicespringjdbc.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.invoicespringjdbc.components.CustomerDAOImpl.CustomerRowMapper;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerName(rs.getString(2));
			customer.setPhoneNo(rs.getLong(3));
			customer.setAddressId(rs.getInt(4));
			return customer;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createCustomer(Customer customer) {
		String createQuery = "INSERT INTO Customer (customerId, customerName, phoneNo, addressId) VALUES (?, ?, ?, ?)";
		new JdbcTemplate(dataSource).update(createQuery, customer.getCustomerId(), customer.getCustomerName(),
				customer.getPhoneNo(), customer.getAddressId());
	}

	@Override
	public long count() {
		String countQuery = "SELECT COUNT(customerId) FROM Customer";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Integer.class);
	}

	@Override
	public void updateCustomer(Customer customer) {
		String updateQuery = "UPDATE Customer SET customerId = ?, customerName = ?, PhoneNo = ?, addressId = ? WHERE customerID = ?";
		new JdbcTemplate(dataSource).update(updateQuery, customer.getCustomerId(), customer.getCustomerName(),
				customer.getPhoneNo(), customer.getAddressId());
	}

	@Override
	public void deleteCustomer(int customerId) {
		String deleteQuery = "DELETE FROM Customer WHERE customerId = ?";
		new JdbcTemplate(dataSource).update(deleteQuery, customerId);
	}

	@Override
	public Customer getCustomer(int customerId) {
		String selectQuery = "SELECT customerId, customerName, phoneNo, addressId FROM Customer WHERE customerId = ?";
		return (Customer) new JdbcTemplate(dataSource).query(selectQuery, new CustomerRowMapper());
	}

	@Override
	public List<Customer> getAllCustomers() {
		String selectAllQuery = "SELECT customerId, customerName, phoneNo, addressId FROM Customer";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new CustomerRowMapper());
	}

}
