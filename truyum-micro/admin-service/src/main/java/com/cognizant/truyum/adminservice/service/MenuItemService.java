package com.cognizant.truyum.adminservice.service;

import java.util.List;

import com.cognizant.truyum.adminservice.model.MenuItem;

public interface MenuItemService {
	List<MenuItem> getAllMenuItems();

	MenuItem getMenuItem(long id);

	String editMenuItem(long id, MenuItem menuItem);
}	
