package com.cognizant.truyum.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.adminservice.exception.MenuItemNotFoundException;
import com.cognizant.truyum.adminservice.model.MenuItem;
import com.cognizant.truyum.adminservice.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getAllMenuItems() {
		// TODO Auto-generated method stub
		List<MenuItem> list = menuItemRepository.findAll(); 
		//System.out.println(list);
		return list;
	}

	@Override
	public MenuItem getMenuItem(long id) {
		// TODO Auto-generated method stub
		return menuItemRepository.findById(id)
				.orElseThrow(() -> new MenuItemNotFoundException("menu item with id " + id + " doesn't exist"));
	}

	@Override
	public String editMenuItem(long id, MenuItem menuItem) {
		MenuItem item = menuItemRepository.findById(id)
				.orElseThrow(() -> new MenuItemNotFoundException("menu item with id " + id + " doesn't exist"));

		if (menuItem.getName() != null) {
			item.setName(menuItem.getName());
		}
		if (menuItem.getPrice() != 0.0) {
			item.setPrice(menuItem.getPrice());
		}
		if (menuItem.getCategory() != null) {
			item.setCategory(menuItem.getCategory());
		}
		if (menuItem.getDateOfLaunch() != null) {
			item.setDateOfLaunch(menuItem.getDateOfLaunch());
		}
		item.setActive(menuItem.isActive());
		item.setFreeDelivery(menuItem.isFreeDelivery());
		
		menuItemRepository.save(item);

		return "MenuItem with the id "+id+" updated successfully";
	}

}
