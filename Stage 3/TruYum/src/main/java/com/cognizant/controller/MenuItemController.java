package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SessionAttributes("userId")
@Controller
public class MenuItemController {
	@Autowired
	MenuItemService service;
	
	@RequestMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model)throws SystemException /*throws SystemException*/{
		//LOGGER.info("showMenuItemListAdmin -Start");
		List<MenuItem> items=service.getMenuItemListAdmin();
		//LOGGER.debug("ADminList:{}",items);
		model.addAttribute("itemList", items);		
		//LOGGER.info("showMenuItemListAdmin -End");
		return "menu-item-list-admin";
	}
	
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam("id") long  menuItemId,ModelMap model) {
		//LOGGER.info("showEditMenuItem -Start");
		MenuItem item=null;
		try {
			item = service.getMenuItem(menuItemId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//LOGGER.debug("Item :{}",item);
		model.addAttribute("menuItem", item);
		//LOGGER.info("showEditMenuItem -End");
		return "edit-menu-item";
	}
	
	@PostMapping("/edit-menu-item")
	public String editMenuItem( @Validated MenuItem menuItem, BindingResult bindingResult)
	{
		//LOGGER.info("showEditMenuItemPost -Start");
		if(bindingResult.hasErrors())
			return "edit-menu-item";
		service.editMenuItem(menuItem);
		//LOGGER.info("showEditMenuItemPost -End");
		return "edit-menu-item-status";
	}
	
	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) 
	{
		//LOGGER.info("showMenuItemListCustomer -Start");
		List<MenuItem> item=service.getMenuItemListCustomer();
		model.addAttribute("itemList",item);
		//LOGGER.info("showMenuItemListCustomer -End");
		return "menu-item-list-customer";
		
		
	}
	
	@ModelAttribute("categoryList")
	public List<String> populateCategory()
	{
		//LOGGER.info("populateCategory -Start");
		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Starters");
		categoryList.add("Main Course");
		categoryList.add("Dessert");
		categoryList.add("Drinks");
		//LOGGER.info("populateCategory -End");
		return categoryList;
	}
}
