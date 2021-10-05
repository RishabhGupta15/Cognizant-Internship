package com.cognizant.truyum.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.customerservice.model.MenuItem;
import com.cognizant.truyum.customerservice.service.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private UserService userService;

	@GetMapping("/menuitems/{userId}")
	public ResponseEntity<List<MenuItem>> getAllCartItems(@PathVariable int userId) {
		return new ResponseEntity<List<MenuItem>>(userService.getAllCartItems(userId), HttpStatus.OK);
	}

	@PostMapping("/add/{userId}/{itemId}")
	public ResponseEntity<String> addMenuItem(@PathVariable int userId, @PathVariable long itemId) {
		return new ResponseEntity<String>(userService.addMenuItem(userId, itemId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{userId}/{itemId}")
	public ResponseEntity<String> deleteMenuItem(@PathVariable int userId, @PathVariable long itemId) {
		return new ResponseEntity<String>(userService.deleteMenuItem(userId, itemId),HttpStatus.OK);
	}
}
