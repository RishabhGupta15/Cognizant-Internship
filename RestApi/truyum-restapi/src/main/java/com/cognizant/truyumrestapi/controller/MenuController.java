package com.cognizant.truyumrestapi.controller;


import com.cognizant.truyumrestapi.dao.MenuRepository;
import com.cognizant.truyumrestapi.entity.MenuItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu-items")
@Slf4j
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public List<MenuItem> getAllMenuItems(){
        List<MenuItem> menuItems = new ArrayList<>();
        var it = menuRepository.findAll();
        it.forEach(i -> menuItems.add(i));
        log.debug(menuItems.toString());
        return menuItems;
    }
}
