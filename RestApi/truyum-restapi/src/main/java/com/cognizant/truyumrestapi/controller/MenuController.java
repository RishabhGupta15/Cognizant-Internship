package com.cognizant.truyumrestapi.controller;


import com.cognizant.truyumrestapi.dao.MenuRepository;
import com.cognizant.truyumrestapi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-items")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public List<Menu> getAllMenuItems(){
        List<Menu> menuItems = (List<Menu>) menuRepository.findAll();
        return menuItems;
    }

    @GetMapping("/test")
    public String test(){
        return "test page";
    }
}
