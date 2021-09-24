package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.entity.AuthRequest;
import com.cognizant.springlearn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    @ResponseStatus(value= HttpStatus.OK)
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid username/password...");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
