package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountDetails() {
        return "여기 계좌 상세정보는 DB 에서 읽은 것입니다.";
    }
}
