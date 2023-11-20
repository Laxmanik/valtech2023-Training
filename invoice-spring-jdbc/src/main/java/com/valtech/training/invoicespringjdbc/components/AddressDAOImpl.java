package com.valtech.training.invoicespringjdbc.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.invoicespringjdbc.components.AddressDAOImpl.AddressRowMapper;

@Component
public class AddressDAOImpl implements AddressDAO {

	public class AddressRowMapper implements RowMapper<Address> {

		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address address = new Address();
			address.setAddressId(rs.getInt(1));
			address.setStreet(rs.getString(2));
			address.setCity(rs.getString(3));
			address.setZipcode(rs.getInt(4));
			return address;
		}

	}

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void createAddress(Address address) {
		String createQuery = "INSERT INTO Address (addressId, street, city, zipcode) values (?, ?, ?, ?)";
		new JdbcTemplate(dataSource).update(createQuery, address.getAddressId(), address.getStreet(), address.getCity(), address.getZipcode());
	}
	
	@Override
	public long count() {
		String countQuery = "SELECT COUNT(addressId) FROM Address";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}
	
	@Override
	public void deleteAddress(int addressId) {
		String deleteQuery = "DELETE FROM Address WHERE addressId=?";
		new JdbcTemplate(dataSource).update(deleteQuery, addressId);
	}
	
	@Override
	public void updateAddress(Address address) {
		String updateQuery = "UPDATE Address SET street=?, city=?, zipcode=?";
		new JdbcTemplate(dataSource).update(updateQuery, address.getStreet(), address.getCity(), address.getZipcode());
	}
	
	@Override
	public Address getAddress(int addressId) {
		String selectQuery = "SELECT addressId, street, city from Address WHERE addressId = ?";
		return (Address) new JdbcTemplate(dataSource).query(selectQuery, new AddressRowMapper());
	}
	
	@Override
	public List<Address> getAllAddress() {
		String selectAllQuery = "SELECT addressId, street, city, zipcode FROM Address";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new AddressRowMapper());
	}
	
}