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
import com.valtech.training.invoicespringjdbc.components.ItemDAOImpl.ItemRowMapper;

@Component
public class ItemDAOImpl implements ItemDAO {
	
	public class ItemRowMapper implements RowMapper<Item> {

		@Override
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
			Item item = new Item();
			item.setItemId(rs.getInt(1));
			item.setItemName(rs.getString(2));
			item.setItemAmount(rs.getFloat(3));
			item.setManufactureId(rs.getInt(4));
			return item;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createItem(Item item) {
		String createQuery = "INSERT INTO Item (itemId, itemName, itemAmount, manufactureId) VALUES (?, ?, ?, ?)";
		new JdbcTemplate(dataSource).update(createQuery, item.getItemId(), item.getItemName(), item.getItemAmount(), item.getManufactureId());
	}

	@Override
	public long count() {
		String countQuery = "SELECT COUNT(itemId) FROM Item";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Integer.class);
	}

	@Override
	public void updateItem(Item item) {
		String updateQuery = "UPDATE Item SET itemId = ?, itemName = ?, itemAmount = ?, manufactureId = ? WHERE itemID = ?";
		new JdbcTemplate(dataSource).update(updateQuery, item.getItemId(), item.getItemName(), item.getItemAmount(), item.getManufactureId());
	}

	@Override
	public void deleteItem(int itemId) {
		String deleteQuery = "DELETE FROM Item WHERE itemId = ?";
		new JdbcTemplate(dataSource).update(deleteQuery, itemId);
	}

	@Override
	public Item getItem(int itemId) {
		String selectQuery = "SELECT itemId, itemName, itemAmount, manufactureId FROM Item WHERE itemId = ?";
		return (Item) new JdbcTemplate(dataSource).query(selectQuery, new ItemRowMapper());
	}

	@Override
	public List<Item> getAllItems() {
		String selectAllQuery = "SELECT itemId, itemName, itemAmount, manufactureId FROM Item";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new ItemRowMapper());
	}

}
