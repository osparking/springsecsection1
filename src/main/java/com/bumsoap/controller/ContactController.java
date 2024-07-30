package com.bumsoap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String saveContactInquiryDetails() {
        return "상세한 문의 정보는 DB 에 저장되었다.";
    }
}
