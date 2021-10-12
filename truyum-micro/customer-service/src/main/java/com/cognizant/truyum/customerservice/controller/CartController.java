package com.cognizant.truyum.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.customerservice.model.MenuItem;
import com.cognizant.truyum.customerservice.service.UserService;
import com.cognizant.truyum.feign.AuthorisationClient;

@RestController
@RequestMapping("/customer")
@EnableFeignClients(basePackages = "com.cognizant.truyum.feign")
public class CartController {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthorisationClient authClient;

	@GetMapping("/cart/menuitems/{userId}")
	public ResponseEntity<List<MenuItem>> getAllCartItems(@PathVariable int userId) {
		return new ResponseEntity<List<MenuItem>>(userService.getAllCartItems(userId), HttpStatus.OK);
	}

	@PostMapping("/cart/add/{userId}/{itemId}")
	public ResponseEntity<String> addMenuItem(@RequestHeader(name = "Authorization") String token,@PathVariable int userId, @PathVariable long itemId) {
		if(authClient.validate(token)) {
		return new ResponseEntity<String>(userService.addMenuItem(userId, itemId),HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<String>("Invalid Token",HttpStatus.FORBIDDEN);
		}
		
	}
	
	@DeleteMapping("/cart/delete/{userId}/{itemId}")
	public ResponseEntity<String> deleteMenuItem(@PathVariable int userId, @PathVariable long itemId) {
		return new ResponseEntity<String>(userService.deleteMenuItem(userId, itemId),HttpStatus.OK);
	}
}
