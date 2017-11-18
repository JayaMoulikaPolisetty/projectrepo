package com.niit.foodcourtbackend.dao;

import com.niit.foodcourtbackend.OrderTable;

public interface OrderTableDao {
	
	boolean placeOrder(OrderTable orderTable);
	boolean cancelOrder(OrderTable orderTable);
	
	OrderTable getOrder(Integer id);

}
