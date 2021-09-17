package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemRepository menuItemRepository;
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		//LOGGER.info("Start");
		List<MenuItem> mt=menuItemRepository.findAll();
		//LOGGER.debug("List of Menu Items are:{}"+mt);
		return mt;
	}
	
	public MenuItem getMenuItem(long menuItemId) throws Exception {
		//LOGGER.info("Start");
		System.out.println("!!!!!!!!!"+menuItemId);
		Optional<MenuItem> itemobj= menuItemRepository.findById((int)menuItemId);
		MenuItem item=null;
		if(itemobj.isPresent()) {
		 item=itemobj.get();
		//LOGGER.debug("MenuItem is:{}"+item);
		}else {
			throw new Exception("Menu iteem not found");
		}
		System.out.println("!!!!!!!!!!!!"+item);
		return item;
	}
	@Transactional
	public void editMenuItem(@Validated MenuItem menuItem) {
		//LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		//LOGGER.info("End");
		
	}

	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		//LOGGER.info("Start");
		List<MenuItem> mt=menuItemRepository.findCustomerMenuItems();
		//LOGGER.debug("CustomerMenuItems{}:"+mt);
		return mt;
	}
}
