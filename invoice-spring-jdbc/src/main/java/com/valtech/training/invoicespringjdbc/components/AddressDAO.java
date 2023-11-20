package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface AddressDAO {

	void createAddress(Address address);

	long count();

	void deleteAddress(int id);

	void updateAddress(Address address);

	Address getAddress(int id);

	List<Address> getAllAddress();

}