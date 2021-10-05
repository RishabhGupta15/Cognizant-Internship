package com.cognizant.truyum.customerservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.customerservice.exception.CartEmptyException;
import com.cognizant.truyum.customerservice.exception.MenuItemNotFoundException;
import com.cognizant.truyum.customerservice.exception.UserNotFoundException;
import com.cognizant.truyum.customerservice.model.MenuItem;
import com.cognizant.truyum.customerservice.model.User;
import com.cognizant.truyum.customerservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MenuItemService menuItemService;

	@Override
	public List<MenuItem> getAllCartItems(int userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user with user id " + userId + " doesn't exist"));
		List<MenuItem> cart = user.getCart();
		if (cart.isEmpty()) {
			throw new CartEmptyException("Cart is Empty");
		}
		return cart;
	}

	@Override
	public String addMenuItem(int userId, long itemId) {

		MenuItem item = menuItemService.getMenuItem(itemId);
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user with user id " + userId + " doesn't exist"));
		List<MenuItem> cart = user.getCart();
		cart.add(item);
		user.setCart(cart);
		userRepository.save(user);
		return "item with id " + itemId + " successfully added into " + user.getName() + " cart.";
	}

	@Override
	public String deleteMenuItem(int userId, long itemId) {
		// TODO Auto-generated method stub
		LOGGER.info("Start deleteMenuItem");
		MenuItem item = menuItemService.getMenuItem(itemId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user with user id " + userId + " doesn't exist"));
		List<MenuItem> cart = user.getCart();
		LOGGER.debug("menuitem {} = ", item);
		/*
		 * System.out.println(cart); System.out.println(item);
		 */
		/*
		 * if (cart.contains(item)) { cart.remove(item); else throw new
		 * MenuItemNotFoundException("menuitem with id " + itemId +
		 * " is not present in the cart");
		 */

		for (MenuItem menuItem : cart) {
			if (menuItem.getId()==item.getId()) {
				cart.remove(menuItem);
				user.setCart(cart);
				userRepository.save(user);
				return "item with id " + itemId + " successfully deleted from " + user.getName() + " cart.";
			}
		}
		throw new MenuItemNotFoundException("menuitem with id " + itemId + " is not present in the cart");
		
	}

}
