package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Loan;

@RestController
@RequestMapping("/loan")
public class LoanController {
    
	@GetMapping("/{number}")
	public Loan getLoanDetails() {
		return new Loan(80980980088L, "car", 40000, 3322, 18);
	}
}
