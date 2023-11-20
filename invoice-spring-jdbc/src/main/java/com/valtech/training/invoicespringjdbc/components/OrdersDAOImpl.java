package com.valtech.training.invoicespringjdbc.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OrdersDAOImpl implements OrdersDAO {
	
	public class OrderRowMapper implements RowMapper<Orders> {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders order = new Orders();
			order.setOrderId(rs.getInt(1));
			order.setOrderDate(rs.getDate(2));
			order.setCustomerId(rs.getInt(3));
			return order;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createOrders(Orders order) {
		String createQuery = "INSERT INTO Orders (orderId, orderDate, customerId) VALUES (?, ?, ?)";
		new JdbcTemplate(dataSource).update(createQuery, order.getOrderId(), order.getOrderDate(), order.getCustomerId());
	}

	@Override
	public long count() {
		String countQuery = "SELECT COUNT(orderId) FROM Orders";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Integer.class);
	}

	@Override
	public void updateOrders(Orders order) {
		String updateQuery = "UPDATE Orders SET orderId = ?, orderDate = ?, customerId = ? WHERE orderID = ?";
		new JdbcTemplate(dataSource).update(updateQuery,  order.getOrderId(), order.getOrderDate(), order.getCustomerId());
	}

	@Override
	public void deleteOrders(int orderId) {
		String deleteQuery = "DELETE FROM Orders WHERE orderId = ?";
		new JdbcTemplate(dataSource).update(deleteQuery, orderId);
	}

	@Override
	public Orders getOrders(int orderId) {
		String selectQuery = "SELECT orderId, orderDate, customerId FROM Orders WHERE orderId = ?";
		return (Orders) new JdbcTemplate(dataSource).query(selectQuery, new OrderRowMapper());
	}

	@Override
	public List<Orders> getAllOrders() {
		String selectAllQuery = "SELECT orderId, orderDate, customerId FROM Orders";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new OrderRowMapper());
	}

}
