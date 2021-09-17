package com.cognizant.truyum.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.controller.MenuItemController;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.CartRepository;

import com.cognizant.truyum.repository.MenuItemRepository;


/**
 * 
 * 
 * @see MenuItemDaoSqlImpl
 *
 */

@Service
public class MenuItemService {
	/**
	 * MenuItemService class is the implementation of the service layer
	 * menuItemDao attribute is injected using spring-config.xml
	 * bean menuItemDao is auto wired with MenuItemCollectionDaoImpl object
	 */
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	@Autowired
	private CartRepository cartRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	
}
