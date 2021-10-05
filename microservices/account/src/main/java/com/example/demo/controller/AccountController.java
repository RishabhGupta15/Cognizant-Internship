package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@GetMapping("/{number}")
	public Account getAccountDetails() {
		return new Account(9879878797809098L, "savings", 230000);
	}

}
