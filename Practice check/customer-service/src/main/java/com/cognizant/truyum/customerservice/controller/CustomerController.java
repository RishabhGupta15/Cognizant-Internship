package com.cognizant.truyum.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.customerservice.model.MenuItem;
import com.cognizant.truyum.customerservice.service.MenuItemService;

@RestController
public class CustomerController {
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/menuitems")
	public ResponseEntity<List<MenuItem>> getMenuItems() {
		return new ResponseEntity<List<MenuItem>>(menuItemService.getAllMenuItems(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable long id) {
		return new ResponseEntity<MenuItem>(menuItemService.getMenuItem(id), HttpStatus.OK);
	}
	
	
	
	
}
