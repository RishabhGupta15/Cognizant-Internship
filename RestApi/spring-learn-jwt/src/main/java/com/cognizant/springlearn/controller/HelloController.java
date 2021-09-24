package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String displayHello(){
        return "Hello World!!";
    }

    @GetMapping("/hello/{name}")
    public String greetUser(@PathVariable("name") String userName){
        return "hello " + userName;
    }
}
