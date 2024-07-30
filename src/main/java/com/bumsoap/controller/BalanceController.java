package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "여기 잔고 상세정보는 DB 에서 읽은 것입니다.";
    }
}
