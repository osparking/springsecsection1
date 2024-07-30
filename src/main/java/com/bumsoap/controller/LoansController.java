package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoans")
    public String getLoanDetails() {
        return "DB 에서 읽어온 상세한 대출 정보이다.";
    }
}
