package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCardDetails() {
        return "상세한 카드 정보는 DB 에 저장되었다.";
    }
}
