package com.valtech.training.invoicespringjdbc.components;

import java.util.List;

public interface ItemDAO {

	void createItem(Item item);

	long count();

	void updateItem(Item item);

	void deleteItem(int itemId);

	Item getItem(int itemId);

	List<Item> getAllItems();

}