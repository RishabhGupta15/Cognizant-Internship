package com.cognizant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.repository.CartEmptyException;


/**
 * 
 * @author Shiyam CartController used to handle request from carts of users
 * @see CartItemService
 *
 */
@SessionAttributes("userId")
@Controller
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	
	
}
