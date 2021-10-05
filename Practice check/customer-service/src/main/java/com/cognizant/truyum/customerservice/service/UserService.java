package com.cognizant.truyum.customerservice.service;

import java.util.List;

import com.cognizant.truyum.customerservice.model.MenuItem;

public interface UserService {

	List<MenuItem> getAllCartItems(int userId);
	
	String addMenuItem(int userId, long itemId);
	
	String deleteMenuItem(int userId, long itemId);

}
