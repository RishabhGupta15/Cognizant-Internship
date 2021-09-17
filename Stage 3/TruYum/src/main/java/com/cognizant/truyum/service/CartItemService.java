package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.CartEmptyException;
import com.cognizant.truyum.repository.CartRepository;

@Service
public class CartItemService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	UserService userService;
	@Transactional
	public void addtoCart(int userId,long menuItemId)
	{
		//logger.info("start");
		System.out.println(userId+" ::: "+menuItemId);
		MenuItem menuItem=null;
		try {
			menuItem = menuItemService.getMenuItem(menuItemId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User user=null;
		try {
			user = userService.getUser(userId);
		} catch (Exception e) {
			System.err.println(e);
		}
		Cart cart=new Cart();
		cart.setMenuItem(menuItem);
		cart.setUser(user);
		//LOGGER.debug("Cart Added is:{}"+cart);
		//LOGGER.info("End");
	}
	@Transactional
	public void deleteCart(int userId,long menuItemId)
	{
		//LOGGER.info("Start");
		MenuItemService menuItemService = new MenuItemService();
		UserService userService=new UserService();
		MenuItem menuItem=null;
		try {
			menuItem = menuItemService.getMenuItem(menuItemId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User user=null;
		try {
			user = userService.getUser(userId);
		} catch (Exception e) {
			System.err.println(e);
		}
		Cart cart=new Cart();
		cart.setMenuItem(menuItem);
		cart.setUser(user);
		cartRepository.delete(cart);
		//LOGGER.info("End");
	}
	public List<Cart> getallcartlist() throws CartEmptyException
	{
		//LOGGER.info("start");
		List<Cart> it=cartRepository.findAll();
		if(it.isEmpty())
		{
			throw new CartEmptyException("Cart Empty");
		}
		else {
		//LOGGER.debug("Cart List is:{}"+it);
		return it;
		}
	}
}
