package com.bumsoap.controller;

import com.bumsoap.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public ResponseEntity<String> createUser(@RequestBody Customer customer) {
        return null;
    }
}
