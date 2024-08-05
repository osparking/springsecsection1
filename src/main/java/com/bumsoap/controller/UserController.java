package com.bumsoap.controller;

import com.bumsoap.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public ResponseEntity<String> createUser(@RequestBody Customer customer) {
        try {

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("고객 생성 예외: " + ex.getMessage());
        }
        return null;
    }
}
