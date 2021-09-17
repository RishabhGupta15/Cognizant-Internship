package com.cognizant.truyum;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartItemService;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.service.UserService;

@SpringBootApplication
@ComponentScan("com.*")
public class TruYumApplication {
	static CartItemService cservice;
	static MenuItemService mservice; 
	static UserService uservice; 
	
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TruYumApplication.class, args);
		cservice=context.getBean(CartItemService.class);
		mservice=context.getBean(MenuItemService.class);
		uservice=context.getBean(UserService.class);
		testaddCartItem();
		//testdeleteCartItem();
		testGetMenuItemsAdmin();
		testgetMenuItemusingMenuItemId();
		testgetMenuItemsCustomer();
	}
	static void testaddCartItem()
	{
		//log.info("Start");
		int userId=1;
		long menuitemid=1;
		cservice.addtoCart(userId, menuitemid);
		//log.info("End");
	}
	//correct
	static void testdeleteCartItem()
	{
		//log.info("Start");
		int userId=1;
		long menuitemid=3;
		cservice.deleteCart(userId, menuitemid);
		//log.info("End");
	}
	static void testGetMenuItemsAdmin()
	{
		//log.info("Start");
		List<MenuItem> lmt=mservice.getMenuItemListAdmin();
		lmt.forEach(System.out::println);
		//log.info("End");
	}
	static void testgetMenuItemusingMenuItemId()
	{
		//log.info("Start");
		long menuItemId=3;
		MenuItem mt=null;
		try {
			mt = mservice.getMenuItem(menuItemId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mt);
		//log.info("End");
	}
	static void testgetMenuItemsCustomer()
	{
		//log.info("Start");
		List<MenuItem> lmt=mservice.getMenuItemListCustomer();
		lmt.forEach(System.out::println);
		//log.info("End");
	}
}


