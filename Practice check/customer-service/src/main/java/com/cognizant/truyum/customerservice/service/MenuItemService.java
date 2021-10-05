package com.cognizant.truyum.customerservice.service;

import java.util.List;

import com.cognizant.truyum.customerservice.model.MenuItem;

public interface MenuItemService {
	List<MenuItem> getAllMenuItems();
	MenuItem getMenuItem(long id);
}

