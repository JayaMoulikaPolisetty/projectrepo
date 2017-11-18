package com.niit.foodcourtbackend.dao;

import java.util.List;

import com.niit.foodcourtbackend.OrderedItems;

public interface OrderedItemsDao {

	boolean addOrderedItem(OrderedItems orderedItems);
	boolean deleteOrderedItem(OrderedItems orderedItems);
	OrderedItems getOrderedItem(int id);
	List<OrderedItems> orderedItems();
	
}
