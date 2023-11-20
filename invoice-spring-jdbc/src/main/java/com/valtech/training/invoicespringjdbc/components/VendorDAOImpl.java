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
public class VendorDAOImpl implements VendorDAO {
	
	public class VendorRowMapper implements RowMapper<Vendor> {

		@Override
		public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vendor vendor = new Vendor();
			vendor.setVendorId(rs.getInt(1));
			vendor.setVendorName(rs.getString(2));
			vendor.setAddressId(rs.getInt(3));
			return vendor;
		}


	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createVendor(Vendor vendor) {
		String createQuery = "INSERT INTO Vendor (vendorId, vendorName, addressId) VALUES (?, ?, ?)";
		new JdbcTemplate(dataSource).update(createQuery, vendor.getVendorId(), vendor.getVendorName(), vendor.getAddressId());
	}

	@Override
	public long count() {
		String countQuery = "SELECT COUNT(vendorId) FROM Vendor";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Integer.class);
	}

	@Override
	public void deleteVendor(int vendorId) {
		String deleteQuery = "DELETE FROM Vendor WHERE vendorId = ?";
		new JdbcTemplate(dataSource).update(deleteQuery, vendorId);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		String updateQuery = "UPDATE Vendor SET vendorId=?, vendorName=?, addressId=? WHERE vendorId=?";
		new JdbcTemplate(dataSource).update(updateQuery, vendor.getVendorId(), vendor.getVendorName(), vendor.getAddressId());
	}

	@Override
	public Vendor getVendor(int vendorId) {
		String selectQuery = "SELECT vendorId, vendorName, addressId FROM Vendor WHERE vendorId = ?";
		return (Vendor) new JdbcTemplate(dataSource).query(selectQuery, new VendorRowMapper());
	}

	@Override
	public List<Vendor> getAllVendors() {
		String selectAllQuery = "SELECT vendorId, vendorName, addressId FROM Vendor";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new VendorRowMapper());
	}

	
	
}