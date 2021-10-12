package com.cognizant.truyum.customerservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.truyum.customerservice.exception.MenuItemNotAvailableException;
import com.cognizant.truyum.customerservice.model.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	private static Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceImpl.class);

	private static final String URL_BASE = "http://localhost:8081/admin/";
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<MenuItem> getAllMenuItems() {
		// TODO Auto-generated method stub
		LOGGER.info("start get All MenuItems");
		MenuItem menuItems[] = restTemplate.getForObject(URL_BASE + "menuitems", MenuItem[].class);
		List<MenuItem> adminMenuItemList = Arrays.asList(menuItems);
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		// System.out.println("admin menu item list:- " + adminMenuItemList);
		Iterator<MenuItem> itr = adminMenuItemList.iterator();
		MenuItem menuItem;
		while (itr.hasNext()) {
			menuItem = itr.next();
			if (menuItem.isActive() && menuItem.getDateOfLaunch().before(new Date())) {

				customerMenuItemList.add(menuItem);

			}

		}
		System.out.println(customerMenuItemList);
		LOGGER.info("end get All MenuItems");
		return customerMenuItemList;
	}

	@Override
	public MenuItem getMenuItem(long id) {
		// TODO Auto-generated method stub
		MenuItem menuItem = restTemplate.getForObject(URL_BASE + id, MenuItem.class);
		if (!menuItem.isActive() || !menuItem.getDateOfLaunch().before(new Date())) {
			throw new MenuItemNotAvailableException("MenuItem with id " + id + " is not available");
		}
		return menuItem;
	}

}
