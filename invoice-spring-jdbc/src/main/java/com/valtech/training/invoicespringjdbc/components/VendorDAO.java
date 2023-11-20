package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface VendorDAO {

	void createVendor(Vendor vendor);
	
	long count();
	
	void deleteVendor(int vendorId);
	
	void updateVendor(Vendor vendor);
	
	Vendor getVendor(int vendorId);
	
	List<Vendor> getAllVendors();
	
}