package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface AddressDAO {

	void createAddress(Address address);

	long count();

	void deleteAddress(int addressId);

	void updateAddress(Address address);

	Address getAddress(int addressId);

	List<Address> getAllAddress();

}