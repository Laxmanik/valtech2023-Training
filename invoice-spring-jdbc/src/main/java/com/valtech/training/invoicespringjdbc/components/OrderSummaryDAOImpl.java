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
public class OrderSummaryDAOImpl implements OrderSummaryDAO {
	
	public class OrderSummaryRowMapper implements RowMapper<OrderSummary> {

		@Override
		public OrderSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderSummary os = new OrderSummary();
			os.setId(rs.getInt(1));
			os.setItemId(rs.getInt(2));
			os.setItemQuantity(rs.getInt(3));
			return os;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createOrderSummary(OrderSummary os) {
		String createQuery = "INSERT INTO OrderSummary (id, itemId, itemQuantity) VALUES (?, ?, ?)";
		new JdbcTemplate(dataSource).update(createQuery, os.getId(), os.getItemId(), os.getItemQuantity());
	}

	@Override
	public long count() {
		String countQuery = "SELECT COUNT(id) FROM OrderSummary";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Integer.class);
	}

	@Override
	public void updateOrderSummary(OrderSummary os) {
		String updateQuery = "UPDATE OrderSummary SET id = ?, itemId = ?, itemQuantity = ? WHERE id = ?";
		new JdbcTemplate(dataSource).update(updateQuery,  os.getId(), os.getItemId(), os.getItemQuantity());
	}

	@Override
	public void deleteOrderSummary(int id) {
		String deleteQuery = "DELETE FROM OrderSummary WHERE id = ?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public OrderSummary getOrderSummary(int id) {
		String selectQuery = "SELECT id, itemId, itemQuantity FROM OrderSummary WHERE id = ?";
		return (OrderSummary) new JdbcTemplate(dataSource).query(selectQuery, new OrderSummaryRowMapper());
	}

	@Override
	public List<OrderSummary> getAllOrderSummary() {
		String selectAllQuery = "SELECT id, itemId, itemQuantity FROM OrderSummary";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new OrderSummaryRowMapper());
	}

}