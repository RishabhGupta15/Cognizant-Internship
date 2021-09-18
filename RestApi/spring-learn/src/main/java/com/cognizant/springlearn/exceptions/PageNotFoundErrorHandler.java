package com.cognizant.springlearn.exceptions;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageNotFoundErrorHandler implements ErrorController {
    @GetMapping("/error")
    public String showErrorMassage(){
        return "<h1>country not in list</h1>";
    }
}
