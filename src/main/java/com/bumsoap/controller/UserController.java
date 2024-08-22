package com.bumsoap.controller;

import com.bumsoap.model.Customer;
import com.bumsoap.model.LoginRequestDto;
import com.bumsoap.model.LoginResponseDto;
import com.bumsoap.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody Customer customer) {
        try {
            String hashedPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPwd);
            customer.setCreateDt(new Date(System.currentTimeMillis()));
            Customer customerInDB = customerRepository.save(customer);

            if (customerInDB.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("고객 정보가 저장되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("고객 정보 저장에 실패하였습니다.");
            }
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("고객 생성 예외: " + ex.getMessage());
        }
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        Optional<Customer> optionalCustomer
                = customerRepository.findByEmail(authentication.getName());
        return optionalCustomer.orElse(null);
    }
    
    @PostMapping("/apiLogin")
    public ResponseEntity<LoginResponseDto> apiLogin(
            @RequestBody LoginRequestDto loginRequestDto) {
        String jwt = null;
        Authentication authentication =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        loginRequestDto.username(), loginRequestDto.password());
    }
}
