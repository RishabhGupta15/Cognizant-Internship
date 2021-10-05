package com.cognizant.truyum.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.adminservice.model.MenuItem;
import com.cognizant.truyum.adminservice.service.MenuItemService;

@RestController
public class AdminController {

	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/menuitems")
	public List<MenuItem> getMenuItems() {
		return menuItemService.getAllMenuItems();
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) {
		return menuItemService.getMenuItem(id);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editMenuItem(@PathVariable long id, @RequestBody MenuItem menuItem) {
		String rpl = menuItemService.editMenuItem(id, menuItem);
		return new ResponseEntity<String>(rpl, HttpStatus.OK);
	}

}
