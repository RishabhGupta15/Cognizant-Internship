package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.repository.CartEmptyException;
import com.cognizant.truyum.service.CartItemService;

@SessionAttributes("userId")
@Controller
public class CartController {
	@Autowired
	private CartItemService service;

	@GetMapping("/show-cart/")
	public String addToCart(@RequestParam("cart_menu_id") long menuItemId, @RequestParam("cart_user_Id") int userId,
			ModelMap map, final RedirectAttributes redirectAttributes) throws CartEmptyException {
		// LOGGER.info("Start");
		service.addtoCart(userId, menuItemId);
		List<Cart> cartlist = service.getallcartlist();
		map.addAttribute("menuItemList", cartlist);
		// LOGGER.info("End");
		return "cart";
	}

	@GetMapping("/remove-cart")
	public String removeCart(@RequestParam("cart_menu_id") long menuItemId, @RequestParam("cart_user_Id") int userId, ModelMap map) throws CartEmptyException {

		service.deleteCart(userId, menuItemId);
		List<Cart> cartlist = service.getallcartlist();
		map.addAttribute("menuItemList", cartlist);
		// LOGGER.info("End");
		return "cart";
	}
	
	@GetMapping("/show-cart")
	public String showCart(ModelMap map) throws CartEmptyException
	{
		List<Cart> cartList=service.getallcartlist();
		map.addAttribute("menuItemList", cartList);
		return "cart";
	}
}
